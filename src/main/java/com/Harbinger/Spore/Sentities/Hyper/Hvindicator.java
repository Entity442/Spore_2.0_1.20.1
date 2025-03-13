package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.Projectile.ThrownItemProjectile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;

import java.util.List;

public class Hvindicator extends Hyper implements RangedAttackMob {
    private static final EntityDataAccessor<Boolean> RIGHT_SKULL = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT_SKULL = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIME_AXE = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.INT);
    private int attackAnimationTick;
    private int rangedAnimationTick;
    private int blockTime = 0;
    public AnimationState block_attack = new AnimationState();
    public Hvindicator(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.hindicator_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.hindicator_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.hindicator_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("left_skull",this.entityData.get(LEFT_SKULL));
        tag.putBoolean("right_skull",this.entityData.get(RIGHT_SKULL));
        tag.putInt("time_axe",this.entityData.get(TIME_AXE));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(LEFT_SKULL,tag.getBoolean("left_skull"));
        this.entityData.set(RIGHT_SKULL,tag.getBoolean("right_skull"));
        this.entityData.set(TIME_AXE,tag.getInt("time_axe"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIGHT_SKULL, false);
        this.entityData.define(LEFT_SKULL, false);
        this.entityData.define(TIME_AXE, 600);
    }

    public boolean hasRightSkull(){return entityData.get(RIGHT_SKULL);}
    public boolean hasLeftSkull(){return entityData.get(LEFT_SKULL);}
    public boolean hasAxe(){return entityData.get(TIME_AXE) >= 600;}
    private void tickAxe(){
        if (hasAxe()){
            return;
        }else {
            entityData.set(TIME_AXE,entityData.get(TIME_AXE)+1);
        }
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        } else if (value == 5) {
            this.block_attack.start(this.tickCount);
            blockTime = 10;
        }else if (value == 6) {
            rangedAnimationTick = 10;
        }else {
            super.handleEntityEvent(value);
        }
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        if (entity instanceof Player player && (doesPlayerHaveShieldInHand(player,InteractionHand.MAIN_HAND) || doesPlayerHaveShieldInHand(player,InteractionHand.OFF_HAND))){
            player.disableShield(true);
        }
        return super.doHurtTarget(entity);
    }
    public boolean doesPlayerHaveShieldInHand(Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);
        return stack.getItem() instanceof ShieldItem;
    }

    @Override
    public void tick() {
        super.tick();
        tickAxe();
        this.setupAnimationStates();
        if (tickCount % 60 == 0 && hasAxe()){
            LivingEntity target = this.getTarget();
            if (target != null && this.hasLineOfSight(target)){
                rangedAnimationTick = 10;
                this.level().broadcastEntityEvent(this, (byte) 6);
                performRangedAttack(target,0);
                this.entityData.set(TIME_AXE,0);
            }
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.hindicator_loot.get();
    }

    private void setupAnimationStates() {
        if (this.blockTime > 0){
            if (blockTime == 1){
                this.block_attack.stop();
            }
            --blockTime;
        }
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean canDisableShield() {
        super.canDisableShield();
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        float reduction = 1.0f;
        reduction = hasLeftSkull() ? reduction - 0.1f : reduction;
        reduction = hasRightSkull() ? reduction - 0.1f : reduction;
        if (source.is(DamageTypeTags.IS_PROJECTILE) && Math.random() < 0.75f) {
            if (!this.level().isClientSide()) {
                this.playSound(SoundEvents.SHIELD_BLOCK);
                this.level().broadcastEntityEvent(this, (byte) 5);
            }
            return false;
        }
        if (source.getEntity() != null && Math.random() < 0.3f) {
            if (!this.level().isClientSide()) {
                this.level().broadcastEntityEvent(this, (byte) 5);
            }
            return false;
        }
        return super.hurt(source, amount * reduction);
    }
    public void awardSkull(LivingEntity entity){
        if ((entity instanceof Villager || entity instanceof AbstractIllager || entity instanceof Witch) && !hasLeftSkull()){
            this.entityData.set(LEFT_SKULL, true);
        }
        if ((entity instanceof Zombie || entity instanceof Player) && !hasRightSkull()){
            this.entityData.set(RIGHT_SKULL, true);
        }
    }

    public int getAttackAnimationTick() {
        return attackAnimationTick;
    }
    public int getRangedAttackAnimationTick() {
        return rangedAnimationTick;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if (this.rangedAnimationTick > 0) {
            --this.rangedAnimationTick;
        }
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        ThrownItemProjectile thrownItemProjectile = new ThrownItemProjectile(level(),this, (float) (SConfig.SERVER.hindicator_ranged_damage.get() * 1f),new ItemStack(Items.IRON_AXE));
        thrownItemProjectile.setLivingEntityPredicate(this.TARGET_SELECTOR);
        double d0 = livingEntity.getX() - this.getX();
        double d1 = livingEntity.getY(0.3333333333333333) - thrownItemProjectile.getY();
        double d2 = livingEntity.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        thrownItemProjectile.shoot(d0, d1 + d3 * 0.20000000298023224, d2, 2F, 2f);
        this.playSound(SoundEvents.PLAYER_ATTACK_CRIT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(thrownItemProjectile);
    }
}
