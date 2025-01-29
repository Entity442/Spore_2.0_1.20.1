package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.AI.LeapGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class HyperClaw extends UtilityEntity {
    public HyperClaw(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedWallMovementControl(this);
        this.navigation = new HybridPathNavigation(this,this.level());
        this.setMaxUpStep(1F);
    }

    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            Vec3 vec3 = this.moveControl.getWantedY() > this.getY() ? new Vec3(0,0.01,0) : new Vec3(0,-0.01,0);
            this.setDeltaMovement(this.getDeltaMovement().scale(0.75D).add(vec3));
            if (this.navigation.canFloat() && this.getRandom().nextFloat() < 0.4F){
                this.getJumpControl().jump();
            }
        } else {
            super.travel(vec);
        }
    }
    @Override
    protected void registerGoals() {
        addTargettingGoals();
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(2, new LeapGoal(this,0.6F));
        this.goalSelector.addGoal(5,new RandomStrollGoal(this,1));
        super.registerGoals();
    }

    @Override
    protected int calculateFallDamage(float p_21237_, float p_21238_) {
        return super.calculateFallDamage(p_21237_, p_21238_) - 15;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_claw_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.hevoker_hp.get()/4) * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, (SConfig.SERVER.hevoker_damage.get()/4) * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.hevoker_armor.get()/4) * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 24)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),  600, 0),this);
        }
        return super.doHurtTarget(entity);
    }
}
