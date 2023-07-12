package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Projectile.Vomit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

public class Host extends EvolvedInfected implements RangedAttackMob {
    public Host(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }



    @Override
    protected void registerGoals() {


        ///this.goalSelector.addGoal(1, new RangedAttackGoal(this,0, 40 , 16){
            ///@Override
           /// public boolean canUse() {
              ///  return super.canUse() && switchy();}});

        this.goalSelector.addGoal(1,new PullGoal(this,32 , 16));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 5.0 + entity.getBbWidth() * entity.getBbWidth();
            }});
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5,new FloatGoal(this));
    }


    private boolean switchy() {
        if (this.getTarget() != null){
            double ze = this.distanceToSqr(this.getTarget());
            return (ze < 32.0D);
        }
        return true ;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_claw_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_claw_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_claw_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED , 0.15)
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }


    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float f1) {
      if (this.getTarget() != null){
          Vomit.shoot(this , this.getTarget());
      }
    }
}
