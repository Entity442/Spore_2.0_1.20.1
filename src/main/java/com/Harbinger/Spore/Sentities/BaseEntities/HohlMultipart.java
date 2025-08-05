
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
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraftforge.fluids.FluidType;

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
    private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_TAIL = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> PARENT_ID = SynchedEntityData.defineId(HohlMultipart.class, EntityDataSerializers.INT);
    private float spin = 0f;
    public HohlMultipart(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
        this.setMaxUpStep(1.5F);
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CHILD_UUID, Optional.empty());
        this.entityData.define(PARENT_UUID, Optional.empty());
        this.entityData.define(SIZE, 1f);
        this.entityData.define(VARIANT, 0);
        this.entityData.define(COLOR, 0);
        this.entityData.define(IS_TAIL, false);
        this.entityData.define(PARENT_ID,-1);
    }
    public Entity getChild() {
        UUID id = getChildId();
        if (id != null && level() instanceof ServerLevel serverLevel) {
            return serverLevel.getEntity(id);
        }
        return null;
    }
    public int getParentIntId(){
        return entityData.get(PARENT_ID);
    }
    @Override
    public void tick() {
        super.tick();
        isInsidePortal = false;

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
        if (tickCount % 100 == 0){
            refreshDimensions();
        }
    }
    public float getSpin(){
        float speed = (float) Math.sqrt(this.getDeltaMovement().x * this.getDeltaMovement().x +
                this.getDeltaMovement().z * this.getDeltaMovement().z);
        spin = spin + speed * 0.00025F * tickCount;
        return spin;
    }
    public Vec3 tickMultipartPosition(int headId, Vec3 parentPos, float parentXRot, float parentYRot, float ourYRot, boolean doHeight) {
        double spacing = 1.5f * this.getBbWidth();
        Vec3 buttOffset = calcOffsetVec((float) -spacing, parentXRot, parentYRot);
        Vec3 targetPos = parentPos.add(buttOffset);

        Vec3 currentPos = this.position();
        Vec3 smoothedPos = currentPos.lerp(targetPos, 0.25); // Smoother movement

        // Optional vertical adjustment
        double yOffset = 0.0;
        if (doHeight) {
            double hgt = getLowPartHeight(targetPos.x, targetPos.y, targetPos.z) + getHighPartHeight(targetPos.x, targetPos.y, targetPos.z);
            if (Math.abs(hgt - prevHeight) > 0.2F) {
                prevHeight = hgt;
            }
            yOffset = Mth.clamp(this.getScale() * prevHeight, -0.6F, 0.6F);
        }

        // Calculate direction to face toward parent
        double dx = parentPos.x - smoothedPos.x;
        double dz = parentPos.z - smoothedPos.z;
        double horizontalDist = Math.sqrt(dx * dx + dz * dz);

        float targetYaw = (float)(Mth.atan2(dz, dx) * Mth.RAD_TO_DEG) - 90.0F;
        float smoothedYaw = limitAngle(this.getYRot(), targetYaw, 7.5F);

        float targetPitch = (float)(-Mth.atan2(yOffset, horizontalDist) * Mth.RAD_TO_DEG);
        float smoothedPitch = limitAngle(this.getXRot(), targetPitch, 5F);

        // === NEW: Disable gravity & physics if too far from parent ===
        double distanceToParent = this.position().distanceTo(parentPos);
        boolean disablePhysics = distanceToParent > 5.0;

        Entity entity = getParentSafe();
        if (entity != null){
            this.setNoGravity(disablePhysics || entity.isNoGravity());
            noPhysics = disablePhysics || entity.noPhysics;
            if (disablePhysics){
                teleportTo(entity.getX(),entity.getY(),entity.getZ());
            }
            this.setDeltaMovement(disablePhysics ? entity.getDeltaMovement().multiply(1,0,1) : entity.getDeltaMovement());
        }
        // Move to new location
        this.moveTo(smoothedPos.x, onGround() ? this.position().y : smoothedPos.y, smoothedPos.z, smoothedYaw, smoothedPitch);
        this.setYRot(smoothedYaw);
        this.setXRot(smoothedPitch);
        this.yHeadRot = smoothedYaw;

        this.headEntityId = headId;
        return smoothedPos;
    }



    private Vec3 calcOffsetVec(float offsetZ, float xRot, float yRot){
        return new Vec3(0, 0, offsetZ).xRot(xRot * Mth.DEG_TO_RAD).yRot(-yRot * Mth.DEG_TO_RAD);
    }


    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL)  || source.is(DamageTypes.FALL);
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

    @Override
    public boolean canBeSeenAsEnemy() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
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
            Entity parent = serverLevel.getEntity(id);
            if (parent == null){return null;}
            this.entityData.set(PARENT_ID,parent.getId());
            return parent;
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
    public boolean shouldShowName() {
        return false;
    }

    @Override
    protected void onEffectAdded(MobEffectInstance instance, @org.jetbrains.annotations.Nullable Entity p_147191_) {
        super.onEffectAdded(instance, p_147191_);
        Entity entity = this.getParentSafe();
        if (entity instanceof LivingEntity living && !living.hasEffect(instance.getEffect())){
            living.addEffect(instance);
        }
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
        tag.putFloat("size",entityData.get(SIZE));
        tag.putInt("variant",entityData.get(VARIANT));
        tag.putInt("color",entityData.get(COLOR));
        tag.putBoolean("tail",entityData.get(IS_TAIL));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.hasUUID("ParentUUID")) setParentId(tag.getUUID("ParentUUID"));
        if (tag.hasUUID("ChildUUID")) setChildId(tag.getUUID("ChildUUID"));
        entityData.set(SIZE,tag.getFloat("size"));
        entityData.set(VARIANT,tag.getInt("variant"));
        entityData.set(COLOR,tag.getInt("color"));
        entityData.set(IS_TAIL,tag.getBoolean("tail"));
    }

    public void setSize(float val){
        entityData.set(SIZE,val);
    }
    public void setVariant(int val){
        entityData.set(VARIANT,val);
    }
    public void setColor(int val){
        entityData.set(COLOR,val);
    }
    public void setIsTail(boolean val){
        entityData.set(IS_TAIL,val);
    }

    public float getSize(){
        return entityData.get(SIZE);
    }
    public int getVariant(){
        return entityData.get(VARIANT);
    }
    public int getColor(){
        return entityData.get(COLOR);
    }
    public boolean isTail(){
        return entityData.get(IS_TAIL);
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

    @Override
    public EntityDimensions getDimensions(Pose p_21047_) {
        return super.getDimensions(p_21047_).scale(this.getSize());
    }
}
