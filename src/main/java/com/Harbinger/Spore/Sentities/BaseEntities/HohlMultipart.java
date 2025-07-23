package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class HohlMultipart extends LivingEntity implements TrueCalamity {
    private double prevHeight = 0;
    private int headEntityId = -1;
    private static final EntityDataAccessor<Optional<UUID>> CHILD_UUID = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Optional<UUID>> PARENT_UUID = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.OPTIONAL_UUID);

    public HohlMultipart(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
        this.setNoGravity(true);
    }

    public float getInflation(){
        return 1f;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CHILD_UUID, Optional.empty());
        this.entityData.define(PARENT_UUID, Optional.empty());
    }
    public Entity getChild() {
        UUID id = getChildId();
        if (id != null && !level().isClientSide) {
            return ((ServerLevel) level()).getEntity(id);
        }
        return null;
    }
    @Override
    public void tick() {
        super.tick();
        isInsidePortal = false;
        this.setDeltaMovement(Vec3.ZERO);

        if (tickCount > 1) {
            Entity parent = getParentSafe();
            if (!level().isClientSide) {
                if (parent == null || parent.isRemoved()) {
                    this.remove(RemovalReason.DISCARDED);
                } else {
                    if (parent instanceof LivingEntity living) {
                        this.hurtTime = living.hurtTime;
                        this.deathTime = living.deathTime;
                    }
                }
            }
        }
    }

    public Vec3 tickMultipartPosition(int headId, Vec3 parentPos, float parentXRot, float parentYRot, float ourYRot, boolean doHeight) {
        // Get a simple fixed offset from the parent (same as before)
        Vec3 parentButt = parentPos.add(calcOffsetVec(new Vec3(-0.5f, 0, 0f), parentXRot, parentYRot));
        Vec3 ourButt = parentButt.add(calcOffsetVec(new Vec3(4.5f, 0, 0f), this.getXRot(), ourYRot));

        // Keep using direction vector to compute rotation (but skip averaging or snaking)
        double dx = parentButt.x - ourButt.x;
        double dz = parentButt.z - ourButt.z;
        double dist = Math.sqrt(dx * dx + dz * dz);

        double hgt = doHeight ? getLowPartHeight(parentButt.x, parentButt.y, parentButt.z) + getHighPartHeight(ourButt.x, ourButt.y, ourButt.z) : 0;
        if (Math.abs(hgt - prevHeight) > 0.2F) prevHeight = hgt;
        double yOffset = Mth.clamp(this.getScale() * prevHeight, -0.6F, 0.6F);

        float yaw = (float)(Mth.atan2(dz, dx) * Mth.RAD_TO_DEG) - 90.0F;
        float pitch = limitAngle(this.getXRot(), (float)(-Mth.atan2(yOffset, dist) * Mth.RAD_TO_DEG), 2F);

        // Apply calculated rotation
        this.setXRot(pitch);
        this.yHeadRot = yaw;

        // Just snap to the calculated butt position (no interpolation/smoothing)
        this.moveTo(ourButt.x, ourButt.y, ourButt.z, yaw, pitch);

        this.headEntityId = headId;
        return ourButt;
    }


    public Vec3 calcOffsetVec(Vec3 vec, float xRot, float yRot) {
        return vec
                .xRot(xRot * Mth.DEG_TO_RAD)
                .yRot((-yRot + 90F) * Mth.DEG_TO_RAD);
    }

    public boolean isOpaqueBlockAt(double x, double y, double z) {
        if (this.noPhysics) return false;
        Vec3 pos = new Vec3(x, y, z);
        AABB box = AABB.ofSize(pos, 1, 1e-6, 1);
        return level().getBlockStates(box).filter(Predicate.not(BlockBehaviour.BlockStateBase::isAir))
                .anyMatch(state -> state.isSuffocating(level(), BlockPos.containing(pos)) &&
                        Shapes.joinIsNotEmpty(state.getCollisionShape(level(), BlockPos.containing(pos)).move(pos.x, pos.y, pos.z), Shapes.create(box), BooleanOp.AND));
    }

    public double getLowPartHeight(double x, double y, double z) {
        if (isFluidAt(x, y, z)) return 0.0D;
        double dy = 0D;
        while (dy > -3D && !isOpaqueBlockAt(x, y + dy, z)) dy -= 0.2D;
        return dy;
    }

    public double getHighPartHeight(double x, double y, double z) {
        if (isFluidAt(x, y, z)) return 0.0D;
        double dy = 0D;
        while (dy <= 3D) {
            if (isOpaqueBlockAt(x, y + dy, z)) dy += 0.2D;
            else break;
        }
        return dy;
    }

    public boolean isFluidAt(double x, double y, double z) {
        if (this.noPhysics) return false;
        return !level().getFluidState(BlockPos.containing(x, y, z)).isEmpty();
    }

    public float limitAngle(float source, float target, float maxChange) {
        float delta = Mth.wrapDegrees(target - source);
        delta = Mth.clamp(delta, -maxChange, maxChange);
        float result = source + delta;
        return Mth.wrapDegrees(result);
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        this.hurtMarked = true;
        this.hurtTime = 20;
        return hurtHeadId(source, damage);
    }

    public boolean hurtHeadId(DamageSource source, float damage) {
        if (headEntityId != -1) {
            Entity e = level().getEntity(headEntityId);
            if (e instanceof Hohlfresser) {
                return e.hurt(source, damage);
            }
        }
        return true;
    }

    public Entity getParentSafe() {
        UUID id = getParentId();
        if (id != null && level() instanceof ServerLevel serverLevel) {
            return serverLevel.getEntity(id);
        }
        return null;
    }

    public void setParent(Entity entity) {
        setParentId(entity.getUUID());
    }

    public UUID getParentId() {
        return this.entityData.get(PARENT_UUID).orElse(null);
    }

    public void setParentId(@Nullable UUID uniqueId) {
        this.entityData.set(PARENT_UUID, Optional.ofNullable(uniqueId));
    }

    public UUID getChildId() {
        return this.entityData.get(CHILD_UUID).orElse(null);
    }

    public void setChildId(@Nullable UUID uniqueId) {
        this.entityData.set(CHILD_UUID, Optional.ofNullable(uniqueId));
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        Entity parent = getParentSafe();
        return parent instanceof LivingEntity living ? living.interact(player, hand) : super.interact(player, hand);
    }

    @Override public Iterable<ItemStack> getArmorSlots() { return List.of(); }
    @Override public ItemStack getItemBySlot(EquipmentSlot slot) { return ItemStack.EMPTY; }
    @Override public void setItemSlot(EquipmentSlot slot, ItemStack stack) {}
    @Override public HumanoidArm getMainArm() { return HumanoidArm.RIGHT; }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (getParentId() != null) tag.putUUID("ParentUUID", getParentId());
        if (getChildId() != null) tag.putUUID("ChildUUID", getChildId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.hasUUID("ParentUUID")) setParentId(tag.getUUID("ParentUUID"));
        if (tag.hasUUID("ChildUUID")) setChildId(tag.getUUID("ChildUUID"));
    }

    @Override
    public boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value) {
        return false;
    }

    @Override
    public int chemicalRange() {
        return 0;
    }

    @Override
    public List<? extends String> buffs() {
        return List.of();
    }

    @Override
    public List<? extends String> debuffs() {
        return List.of();
    }
}