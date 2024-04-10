package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Wendigo extends Hyper {
    private static final UUID SPEED_MODIFIER_ATTACKING_UUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final UUID SPEED_MODIFIER_STALKING_UUID = UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160890");
    private static final AttributeModifier SPEED_MODIFIER_STALKING = new AttributeModifier(SPEED_MODIFIER_STALKING_UUID, "Crawling speed slowdown", -0.15F, AttributeModifier.Operation.ADDITION);
    private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(SPEED_MODIFIER_ATTACKING_UUID, "Sprinting speed", 0.15F, AttributeModifier.Operation.ADDITION);
    public static final EntityDataAccessor<Boolean> IS_STALKING = SynchedEntityData.defineId(Wendigo.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> STALKING_TIMEOUT = SynchedEntityData.defineId(Wendigo.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> CAMO = SynchedEntityData.defineId(Wendigo.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> IS_SPRINTING = SynchedEntityData.defineId(Wendigo.class, EntityDataSerializers.INT);
    public Wendigo(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedWallMovementControl(this);
        this.navigation = new WallClimberNavigation(this,level);
        this.setMaxUpStep(1F);
    }



    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("stalking",this.isStalking());
        tag.putInt("camo",this.getCamo());
        tag.putInt("stalking_timeout",this.getStalkingTimeout());
        tag.putInt("sprinting",this.getIsSprinting());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setIsStalking(tag.getBoolean("stalking"));
        this.setCamo(tag.getInt("camo"));
        this.setStalkingTimeout(tag.getInt("stalking_timeout"));
        this.setIsSprinting(tag.getInt("sprinting"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_STALKING, false);
        this.entityData.define(STALKING_TIMEOUT, 0);
        this.entityData.define(CAMO, 0);
        this.entityData.define(IS_SPRINTING, 0);
    }

    public void setIsStalking(boolean value){
        this.entityData.set(IS_STALKING,value);
    }
    public boolean isStalking(){
        return this.entityData.get(IS_STALKING);
    }
    public void setCamo(int value){
        this.entityData.set(CAMO,value);
    }
    public int getCamo(){
        return this.entityData.get(CAMO);
    }
    public void setStalkingTimeout(int value){
        this.entityData.set(STALKING_TIMEOUT,value);
    }
    public int getStalkingTimeout(){return this.entityData.get(STALKING_TIMEOUT);}
    public void setIsSprinting(int value){
        this.entityData.set(IS_SPRINTING,value);
    }
    public int getIsSprinting(){
        return this.entityData.get(IS_SPRINTING);
    }

    @Override
    public boolean isCrouching() {
        return isStalking();
    }

    public double getJumpRange(){
        return 300d;
    }
    boolean isLookingAtMe(LivingEntity entity) {
        Vec3 vec3 = entity.getViewVector(1.0F).normalize();
        Vec3 vec31 = new Vec3(this.getX() - entity.getX(), this.getEyeY() - entity.getEyeY(), this.getZ() - entity.getZ());
        double d0 = vec31.length();
        vec31 = vec31.normalize();
        double d1 = vec3.dot(vec31);
        return d1 > 1.0D - 0.025D / d0 && entity.hasLineOfSight(this);
    }

    boolean canStartStalking(LivingEntity livingEntity){
        if (this.getStalkingTimeout() > 0){
            return false;
        }else if (livingEntity.distanceToSqr(this) < this.getJumpRange()){
            return false;
        }else if (this.isLookingAtMe(livingEntity)){
            this.setStalkingTimeout(20);
            return false;
        }else
        return true;
    }

    @Override
    public void setTarget(@Nullable LivingEntity livingEntity) {
        super.setTarget(livingEntity);
        AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attributeinstance != null){
            if (livingEntity != null && canStartStalking(livingEntity)){
                if (!attributeinstance.hasModifier(SPEED_MODIFIER_STALKING)) {
                    attributeinstance.addTransientModifier(SPEED_MODIFIER_STALKING);
                }
            }else{
                attributeinstance.removeModifier(SPEED_MODIFIER_STALKING);
            }
            this.setIsStalking(attributeinstance.hasModifier(SPEED_MODIFIER_STALKING));
        }
    }

    public List<SoundEvent> LureList(){
        List<SoundEvent> values = new ArrayList<>();
        values.add(SoundEvents.VILLAGER_AMBIENT);
        values.add(SoundEvents.WANDERING_TRADER_AMBIENT);
        values.add(SoundEvents.ENDERMAN_AMBIENT);
        values.add(SoundEvents.ENDERMAN_SCREAM);
        values.add(SoundEvents.PILLAGER_AMBIENT);
        return values;
    }

    public void playSoundsNearTarget(Entity target){
        SoundEvent soundEvent = this.LureList().get(this.random.nextInt(this.LureList().size()));
        BlockPos pos = target.getOnPos();
        target.level().playSound(null, pos.getX(),pos.getY(),pos.getZ(), soundEvent, target.getSoundSource(), 1, 1);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.wendigo_loot.get();
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }

    @Override
    public void aiStep() {
        super.aiStep();
        AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attributeinstance != null ){
            if (!this.isStalking() && this.getIsSprinting() > 0){
                if (!attributeinstance.hasModifier(SPEED_MODIFIER_ATTACKING)) {
                    attributeinstance.addTransientModifier(SPEED_MODIFIER_ATTACKING);
                }
            }else{
                attributeinstance.removeModifier(SPEED_MODIFIER_ATTACKING);
            }
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.wendigo_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.wendigo_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.wendigo_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 200 == 0 && this.isStalking()){
            Entity entity = this.getTarget();
            if (entity != null){
                this.playSoundsNearTarget(entity);
            }
        }
        if (this.tickCount % 20 == 0){
            if (this.getStalkingTimeout()>0){
                this.setStalkingTimeout(this.getStalkingTimeout()-1);
            }
            if (this.getIsSprinting()>0){
                this.setIsSprinting(this.getIsSprinting()-1);
            }
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() != null){
            this.setStalkingTimeout(20);
        }
        return super.hurt(source, amount);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (IS_STALKING.equals(dataAccessor)){
            if (this.getTarget() != null && this.getIsSprinting()<=0){
                this.setIsSprinting(10);
                this.playSound(Ssounds.WENDIGO_SCREECH.get());
            }
            this.setCamo(this.isStalking() ? getBiomeTint() : 0);
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }
    public int getBiomeTint(){
        int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY());
        int k = Mth.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        Biome biome = this.level().getBiome(blockpos).value();
        return biome.getFoliageColor();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.WENDIGO_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.isStalking()){
            return super.getDimensions(pose).scale(2.2F,0.35F);
        }
        return super.getDimensions(pose);
    }
}
