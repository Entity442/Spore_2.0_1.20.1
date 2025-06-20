package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Protector extends EvolvedInfected implements ArmedInfected,HasUsableSlot, RangedAttackMob {
    public static final EntityDataAccessor<Boolean> SHIELDED = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> PEARLS = SynchedEntityData.defineId(Protector.class, EntityDataSerializers.INT);
    public int ticksUnShielded;
    public Protector(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new ProtectorMeleeGoal(this, (float) (SConfig.SERVER.protector_damage.get() * SConfig.SERVER.global_damage.get())));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_knight_loot.get();
    }
    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.3){
            return SdamageTypes.knight_damage(this);
        }
        return super.getCustomDamage(entity);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.protector_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.protector_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.protector_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    public boolean getShielded(){return entityData.get(SHIELDED);}
    public void setShielded(boolean value){entityData.set(SHIELDED,value);}

    public int getPearls(){return entityData.get(PEARLS);}
    public void setPearls(int e){this.entityData.set(PEARLS,e);}
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHIELDED,false);
        this.entityData.define(PEARLS,1);
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        super.awardKillScore(entity, i, damageSource);
        if (entity instanceof EnderMan){setPearls(getPearls()+random.nextInt(3));}
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setShielded(tag.getBoolean("shield"));
        setPearls(tag.getInt("pearls"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("shield",getShielded());
        tag.putInt("pearls",getPearls());
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
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

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void tick() {
        super.tick();
        if (ticksUnShielded > 0){
            ticksUnShielded--;
        }
        if (tickCount % 200 == 0){
            setShielded(false);
        }
        if (this.tickCount % 40 == 0){
            LivingEntity entity = this.getTarget();
            if (entity != null){
                double distance = this.distanceTo(entity);
                if (distance > 20 && this.getPearls() > 0 && this.hasLineOfSight(entity)){
                    this.performRangedAttack(entity, 0);
                }
            }
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getEntity();
        if (entity instanceof LivingEntity livingEntity){
            ItemStack stack = livingEntity.getMainHandItem();
            if (getShielded() && isLookingAtMe(livingEntity)){
                this.playSound(SoundEvents.SHIELD_BLOCK);
                return false;
            }
            if (stack.canDisableShield(stack,this,livingEntity)){
                this.ticksUnShielded = 200;
                setShielded(false);
                this.playSound(SoundEvents.SHIELD_BREAK);
            }
            this.ticksUnShielded = 100;
            setShielded(false);
        }
        return super.hurt(source, amount);
    }

    @Override
    public void onSyncedDataUpdated(List<SynchedEntityData.DataValue<?>> values) {
        super.onSyncedDataUpdated(values);
        if (values == SHIELDED){
            AttributeInstance attributes = this.getAttribute(Attributes.MOVEMENT_SPEED);
            if (attributes != null){
                attributes.setBaseValue(this.getShielded() ? 0.1 : 0.2);
            }
        }
    }
    boolean isLookingAtMe(LivingEntity entity) {
        Vec3 vec3 = entity.getViewVector(1.0F).normalize();
        Vec3 vec31 = new Vec3(this.getX() - entity.getX(), this.getEyeY() - entity.getEyeY(), this.getZ() - entity.getZ());
        double d0 = vec31.length();
        vec31 = vec31.normalize();
        double d1 = vec3.dot(vec31);
        return d1 > 1.0D - 0.025D / d0 && entity.hasLineOfSight(this);
    }
    @Override
    public boolean hasUsableSlot(EquipmentSlot slot) {
        return slot == EquipmentSlot.FEET || slot == EquipmentSlot.HEAD;
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        InfectedPlayer.createName(this,SConfig.DATAGEN.name.get());
        InfectedPlayer.createItems(this,EquipmentSlot.HEAD,SConfig.DATAGEN.player_h.get());
        InfectedPlayer.createItems(this,EquipmentSlot.FEET,SConfig.DATAGEN.player_b.get());
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        this.populateDefaultEquipmentSlots(this.random, instance);
        return super.finalizeSpawn(serverLevelAccessor, instance, p_21436_, p_21437_, p_21438_);
    }

    
    @SubscribeEvent
    public static void onInfectedHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof Infected victim)) return;
        if (!(victim.level() instanceof ServerLevel level)) return;

        LivingEntity attacker = event.getSource().getEntity() instanceof LivingEntity e ? e : null;

        double radius = 64;
        for (Protector protector : level.getEntitiesOfClass(Protector.class, victim.getBoundingBox().inflate(radius))) {
            if (protector == victim || protector.isDeadOrDying()) continue;

            if (protector.getTarget() != null) continue;

            if (attacker != null){
                protector.setTarget(attacker);
            }
        }
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        if (!this.level().isClientSide) {
            ThrownEnderpearl pearl = new ThrownEnderpearl(this.level(), this);
            double d0 = livingEntity.getEyeY() - this.getEyeY();
            double d1 = livingEntity.getX() - this.getX();
            double d2 = d0;
            double d3 = livingEntity.getZ() - this.getZ();
            double d4 = Math.sqrt(d1 * d1 + d3 * d3) * 0.2;
            pearl.setOwner(this);
            pearl.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
            this.playSound(SoundEvents.ENDER_PEARL_THROW, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            this.level().addFreshEntity(pearl);
            setPearls(getPearls() - 1);
        }
    }

    public static class ProtectorMeleeGoal extends CustomMeleeAttackGoal{
        private final float meleeDamage;
        public ProtectorMeleeGoal(Protector mob, float meleeDamage) {
            super(mob, 1.2, false);
            this.meleeDamage = meleeDamage;
        }
        @Override
        protected double getAttackReachSqr(LivingEntity entity) {
            return 4.0 + entity.getBbWidth() * entity.getBbWidth();}


        @Override
        protected void checkAndPerformAttack(LivingEntity entity, double at) {
            if (mob instanceof Protector protector){
                double distance = protector.distanceTo(entity);
                protector.setShielded(distance < 15d && protector.ticksUnShielded <= 0);
                if (protector.getShielded() && entity.getHealth() > meleeDamage){
                    double d0 = this.getAttackReachSqr(entity);
                    if (at <= d0 && this.ticksUntilNextAttack <= 0 && protector.hasLineOfSight(entity)) {
                        this.resetAttackCooldown(20);
                        mob.playSound(SoundEvents.SHIELD_BLOCK);
                        this.mob.swing(InteractionHand.MAIN_HAND);
                        entity.hurtMarked = true;
                        if (entity instanceof Mob mob1){
                            mob1.setTarget(mob);
                        }
                        entity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),100,0));
                        entity.knockback(1.2F, Mth.sin(mob.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(mob.getYRot() * ((float) Math.PI / 180F))));
                    }
                }else {
                    super.checkAndPerformAttack(entity, at);
                }
            }
        }
    }
}
