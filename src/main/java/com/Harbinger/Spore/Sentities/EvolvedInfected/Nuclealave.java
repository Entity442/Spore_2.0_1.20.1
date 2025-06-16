package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Nuclealave extends EvolvedInfected implements RangedAttackMob , ArmedInfected,HasUsableSlot {
    public Nuclealave(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setMaxUpStep(1.0F);
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.nucke_loot.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.nuckelave_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.nuckelave_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.nuckelave_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        InfectedPlayer.createName(this,SConfig.DATAGEN.name.get());
        InfectedPlayer.createItems(this,EquipmentSlot.HEAD,SConfig.DATAGEN.player_h.get());
        InfectedPlayer.createItems(this,EquipmentSlot.CHEST,SConfig.DATAGEN.player_c.get());
        InfectedPlayer.createItems(this,EquipmentSlot.LEGS,SConfig.DATAGEN.player_l.get());
        InfectedPlayer.createItems(this,EquipmentSlot.FEET,SConfig.DATAGEN.player_b.get());
        InfectedPlayer.createItems(this,EquipmentSlot.MAINHAND,SConfig.DATAGEN.player_hm.get());
        InfectedPlayer.createItems(this,EquipmentSlot.OFFHAND,SConfig.DATAGEN.player_ho.get());
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance instance, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        this.populateDefaultEquipmentSlots(this.random, instance);
        return super.finalizeSpawn(serverLevelAccessor, instance, p_21436_, p_21437_, p_21438_);
    }


    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        super.awardKillScore(entity, i, damageSource);
        if (entity instanceof LivingEntity living){
            for (EquipmentSlot slot : EquipmentSlot.values()){
                ItemStack stack = living.getItemBySlot(slot);
                if (this.getItemBySlot(slot) == ItemStack.EMPTY && stack != ItemStack.EMPTY){
                    this.setItemSlot(slot,stack);
                }
            }
        }
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2,new RangedAttackGoal(this,1.1f,50,20){
            @Override
            public boolean canUse() {
                return canDoRangedAttacks() && super.canUse();
            }
            @Override
            public void start() {
                super.start();
                setAggressive(true);
            }
            @Override
            public void stop() {
                super.stop();
                setAggressive(false);
            }
        });
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.3, false) {
            @Override
            public boolean canUse() {
                return !canDoRangedAttacks() && super.canUse();
            }
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    public boolean canDoRangedAttacks(){
        LivingEntity living = this.getTarget();
        if (this.getMainHandItem().getItem() instanceof BowItem || this.getOffhandItem().getItem() instanceof BowItem){
            return living != null && living.distanceToSqr(this) > 100;
        }
        return false;
    }
    private boolean hasFireCapabilities(){
        return this.getMainHandItem().getItem() instanceof FlintAndSteelItem || this.getOffhandItem().getItem() instanceof FlintAndSteelItem;
    }
    private boolean canShield(){
        return this.getMainHandItem().getItem() instanceof ShieldItem || this.getOffhandItem().getItem() instanceof ShieldItem;
    }
    private ItemStack getShieldInHand(){
        if (this.getMainHandItem().getItem() instanceof ShieldItem){
            return this.getMainHandItem();
        }else{
            return this.getOffhandItem();
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (canShield() && source.getEntity() instanceof LivingEntity living && Math.random() < 0.35f){
            this.playSound(SoundEvents.SHIELD_BLOCK);
            getShieldInHand().hurtAndBreak((int) amount,living,e -> {});
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (hasFireCapabilities()){entity.setSecondsOnFire(10);}
        return super.doHurtTarget(entity);
    }
    protected AbstractArrow getArrow(ItemStack p_32156_, float p_32157_) {
        return ProjectileUtil.getMobArrow(this, p_32156_, p_32157_);
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float v) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem)));
        AbstractArrow abstractarrow = this.getArrow(itemstack, v);
        if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
            abstractarrow = ((net.minecraft.world.item.BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow);
        double d0 = entity.getX() - this.getX();
        double d1 = entity.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = entity.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        if(abstractarrow instanceof Arrow arrow){
            arrow.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600));
            if (hasFireCapabilities()){
                arrow.setSecondsOnFire(10);
            }
        }
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractarrow);
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
        return SoundEvents.HORSE_STEP;
    }

    @Override
    public boolean hasUsableSlot(EquipmentSlot slot) {
        return true;
    }
}
