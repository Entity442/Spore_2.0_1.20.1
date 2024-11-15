package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.Projectile.ThrownBlockProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Ogre extends Hyper implements RangedAttackMob , ArmorPersentageBypass {
    public static final EntityDataAccessor<Boolean> HAS_IMPALED_BODY = SynchedEntityData.defineId(Ogre.class, EntityDataSerializers.BOOLEAN);
    private int attackAnimationTick;
    private int attacks;
    public Ogre(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    public boolean canDoTailAttack(){return attacks > 2;}

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.ogre_loot.get();
    }

    public boolean hasImpaledBody(){
        return this.entityData.get(HAS_IMPALED_BODY);
    }
    public void setHasImpaledBody(boolean value){
        this.entityData.set(HAS_IMPALED_BODY,value);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("impaled_body",hasImpaledBody());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setHasImpaledBody(tag.getBoolean("impaled_body"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_IMPALED_BODY, false);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.ogre_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.ogre_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.ogre_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.27)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,7, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }


    @Override
    public void tick() {
        super.tick();
        if (tickCount % 40 == 0 && this.isAggressive()){
            performRangedThrow(this);
        }
        if (tickCount % 200 == 0){
            LivingEntity livingEntity = this.getTarget();
            if (livingEntity != null && this.hasLineOfSight(livingEntity)){
                for (int i = 0;i < random.nextInt(1,4);i++){
                    performRangedAttack(livingEntity,0);
                }
            }
        }
    }
    public void handleEntityEvent(byte value) {
        if (value == 4 && canDoTailAttack()) {
            this.attackAnimationTick = 10;
        } else {
            super.handleEntityEvent(value);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (canDoTailAttack() && !this.isVehicle() && entity instanceof LivingEntity living){
            this.attackAnimationTick = 10;
            living.knockback((10f),  Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), (double) (-Mth.cos(this.getYRot() * ((float) Math.PI / 180F))));
            this.attacks = 0;
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION,120));
        }else{
            attacks++;
        }
        if (entity instanceof Player player && Math.random() < 0.2){
            player.startRiding(this);
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        if (canDoTailAttack() && !hasImpaledBody()){
            this.setHasImpaledBody(true);
        }
        super.awardKillScore(entity, i, damageSource);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        BlockState state = getBlock();
        if(!level().isClientSide && state != null) {
            ThrownBlockProjectile thrownBlockProjectile = new ThrownBlockProjectile(level(),this,10f,state,TARGET_SELECTOR);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
            double dz = livingEntity.getZ() - this.getZ();
            thrownBlockProjectile.moveTo(this.getX(),this.getY()+1.5,this.getZ());
            thrownBlockProjectile.shoot(dx, dy - thrownBlockProjectile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f, 6.0F);
            level().addFreshEntity(thrownBlockProjectile);
        }
    }

    public BlockState getBlock(){
        AABB aabb = this.getBoundingBox().inflate(0.2);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.getDestroySpeed(level(), blockpos) < 5 && blockstate.getDestroySpeed(level(), blockpos) >= 0 && !blockstate.isAir()) {
                level().destroyBlock(blockpos,false);
                return blockstate;
            }
        }
        return null;
    }

    public void performRangedThrow(LivingEntity entity) {
        LivingEntity livingEntity = this.getTarget();
        if (livingEntity != null){
            this.attackAnimationTick = 10;
            Vec3 vec3 = entity.getDeltaMovement();
            double d0 = entity.getX() + vec3.x - livingEntity.getX();
            double d1 = entity.getEyeY() - (double)1.1F - this.getY();
            double d2 = entity.getZ() + vec3.z - livingEntity.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            AABB boundingBox = entity.getBoundingBox().inflate(1.2);
            List<Entity> entities = entity.level().getEntities(entity, boundingBox);

            for (Entity en : entities) {
                if (en instanceof Mob && SConfig.SERVER.can_be_carried.get().contains(en.getEncodeId())){
                    en.setDeltaMovement(d0 * -0.2D, (d1 + d3) * 0.02D, d2 * -0.2D);
                    ((Mob) en).addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING , 200,0));
                }
            }
        }
    }
    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }

    @Override
    public float amountOfDamage(float value) {
        return canDoTailAttack() ?value * 0.5f: 0;
    }

    @Override
    protected void positionRider(Entity entity, MoveFunction function) {
        super.positionRider(entity, function);
        if (entity instanceof Player player){
            Vec3 vec3 = (new Vec3(1.1D, 1.4D, 0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            player.setPos(this.getX() + vec3.x, this.getY() + vec3.y,this.getZ()+ vec3.z);
        }
    }

    @Override
    public boolean isVehicle() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof Player player){
            player.setPose(Pose.SWIMMING);
        }
        return super.isVehicle();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.OGRE_AMBIENT.get();
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

}
