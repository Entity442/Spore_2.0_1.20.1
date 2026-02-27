
package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkLeviLeg;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Sentities.Calamities.Leviathan;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import java.util.*;
import java.util.function.Predicate;

public class LeviathanMultipart extends LivingEntity implements TrueCalamity {
    private double prevHeight = 0;
    private int headEntityId = -1;
    private final IkLeviLeg[] legs;
    private static final EntityDataAccessor<Optional<UUID>> CHILD_UUID = SynchedEntityData.defineId(LeviathanMultipart.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Optional<UUID>> PARENT_UUID = SynchedEntityData.defineId(LeviathanMultipart.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(LeviathanMultipart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PARENT_ID = SynchedEntityData.defineId(LeviathanMultipart.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ADAPTED = SynchedEntityData.defineId(LeviathanMultipart.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_TAIL = SynchedEntityData.defineId(LeviathanMultipart.class, EntityDataSerializers.BOOLEAN);
    public LeviathanMultipart(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
        IkLeviLeg frontRightLeg = new IkLeviLeg(this,4, LEG_POSITIONS.FRONT_RIGHT_TENTACLE.bodySet, LEG_POSITIONS.FRONT_RIGHT_TENTACLE.offset,4);
        IkLeviLeg frontLeftLeg = new IkLeviLeg(this,4, LEG_POSITIONS.FRONT_LEFT_TENTACLE.bodySet, LEG_POSITIONS.FRONT_LEFT_TENTACLE.offset,4);
        IkLeviLeg backRightLeg = new IkLeviLeg(this,4, LEG_POSITIONS.BACK_RIGHT_TENTACLE.bodySet, LEG_POSITIONS.BACK_RIGHT_TENTACLE.offset,2);
        IkLeviLeg backLeftLeg = new IkLeviLeg(this,4, LEG_POSITIONS.BACK_LEFT_TENTACLE.bodySet, LEG_POSITIONS.BACK_LEFT_TENTACLE.offset,2);
        legs = new IkLeviLeg[]{frontLeftLeg,frontRightLeg,backLeftLeg,backRightLeg};
    }
    public IkLeviLeg[] getLegs(){
        return legs;
    }
    enum LEG_POSITIONS{
        BACK_LEFT_TENTACLE(new Vec3(-1.5,0.5,0.25),new Vec3(-2.5, -1, 4)),
        BACK_RIGHT_TENTACLE(new Vec3(-1.5,0.5,-0.25),new Vec3(-2.5, -1, -4)),
        FRONT_LEFT_TENTACLE(new Vec3(0.5,0.5,0.75),new Vec3(-1.5, -1, 6)),
        FRONT_RIGHT_TENTACLE(new Vec3(0.5,0.5,-0.75),new Vec3(-1.5, -1, -6));
        private final Vec3 bodySet;
        private final Vec3 offset;

        LEG_POSITIONS(Vec3 bodySet, Vec3 offset) {
            this.bodySet = bodySet;
            this.offset = offset;
        }
    }
    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.CALAMITY_DAMAGE.get();
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
        entityData.define(CHILD_UUID, Optional.empty());
        entityData.define(PARENT_UUID, Optional.empty());
        entityData.define(COLOR, 0);
        entityData.define(PARENT_ID,-1);
        entityData.define(ADAPTED,false);
        entityData.define(IS_TAIL,false);
    }

    public boolean isAdapted(){
        return entityData.get(ADAPTED);
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
        for (IkLeviLeg leg : legs) {
            leg.refreshLegStandingPoint();
            leg.applyIK();
        }
        if (tickCount > 1) {
            Entity parent = getParentSafe();
            if (!level().isClientSide) {
                if (parent == null || parent.isRemoved() || (parent instanceof Leviathan leviathan && !Objects.equals(leviathan.getChildId(), this.uuid))) {
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
        double spacing = 1.5f * this.getBbWidth();
        Vec3 buttOffset = calcOffsetVec((float) -spacing, parentXRot, parentYRot);
        Vec3 targetPos = parentPos.add(buttOffset);

        Vec3 currentPos = this.position();
        Vec3 smoothedPos = currentPos.lerp(targetPos, 0.25); // Smoother movement
        Vec3 dir = this.position().subtract(targetPos);
        if (dir.length() > 5){
            setPos(targetPos);
        }

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
            if (e instanceof LivingEntity) {
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
    protected void onEffectAdded(MobEffectInstance instance, @Nullable Entity source) {
        super.onEffectAdded(instance, source);
        if (!instance.getEffect().isBeneficial() && instance.getAmplifier() < 2){
            return;
        }
        Entity parent = this.getParentSafe();
        if (!(parent instanceof LivingEntity livingParent)) return;
        MobEffectInstance existing = livingParent.getEffect(instance.getEffect());
        if (existing == null || existing.getDuration() < instance.getDuration() - 5) {
            livingParent.addEffect(new MobEffectInstance(instance));
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
        tag.putInt("color",entityData.get(COLOR));
        tag.putBoolean("adapted",entityData.get(ADAPTED));
        tag.putBoolean("tail",entityData.get(IS_TAIL));
        for(int e = 0;e<legs.length;e++){
            legs[e].writeVariants(tag,e);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.hasUUID("ParentUUID")) setParentId(tag.getUUID("ParentUUID"));
        if (tag.hasUUID("ChildUUID")) setChildId(tag.getUUID("ChildUUID"));
        entityData.set(COLOR,tag.getInt("color"));
        entityData.set(IS_TAIL,tag.getBoolean("adapted"));
        entityData.set(ADAPTED,tag.getBoolean("tail"));
        for(int e = 0;e<legs.length;e++){
            legs[e].readVariants(tag,e);
        }
    }

    public void setAdapted(boolean val){
        entityData.set(ADAPTED,val);
    }
    public void setColor(int val){
        entityData.set(COLOR,val);
    }
    public int getColor(){
        return entityData.get(COLOR);
    }

    public boolean isTail(){
        return entityData.get(IS_TAIL);
    }
    public void setTail(boolean v){
        entityData.set(IS_TAIL,v);
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
