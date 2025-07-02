package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedArialMovementControl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Scavenger extends EvolvedInfected implements FlyingInfected {
    private int screams;
    private int ticksAggressive;
    public Scavenger(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedArialMovementControl(this , 20,false);
        this.navigation = new FlyingPathNavigation(this,level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.scavenger_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.scavenger_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR,  SConfig.SERVER.scavenger_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.FLYING_SPEED, 0.4);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.scavenger_loot.get();
    }

    public boolean canAttack(){return ticksAggressive > 0 || checkForHelp();}

    public boolean causeFallDamage(float p_147105_, float p_147106_, DamageSource p_147107_) {
        return false;
    }
    @Override
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && !this.onGround()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            super.travel(vec);
        }
        this.setDeltaMovement(getDeltaMovement().add(0,-0.01,0));
    }
    private boolean checkForHelp(){
        LivingEntity living = this.getTarget();
        if (living == null){
            return false;
        }
        List<Entity> infected = level().getEntities(this,living.getBoundingBox().inflate(3),entity -> {return entity instanceof Infected || entity instanceof UtilityEntity;
        });
        return !infected.isEmpty();
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity living = this.getTarget();
        if (living != null && !canAttack()){
            moveToTarget(living, 150);
        }
        if (ticksAggressive > 0){
            ticksAggressive--;
        }
    }

    public void scream(LivingEntity living){
        if (screams > 3){
            ticksAggressive = 200;
            screams = 0;
            return;
        }
        this.playSound(Ssounds.SCAVENGER_SCREECH.get());
        screams++;
        screamForHelp(living);
    }

    public void screamForHelp(LivingEntity living){
        AABB aabb = this.getBoundingBox().inflate(48);
        List<Entity> infected = level().getEntities(this,aabb,entity -> {return entity instanceof Infected;
        });
        for (Entity entity : infected){
            if (entity instanceof Infected infected1 && infected1.getTarget() == null){infected1.setTarget(living);}
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() != null){
            ticksAggressive = 200;
        }
        return super.hurt(source, amount);
    }

    private void moveToTarget(LivingEntity living , double range){
        double distance = this.distanceToSqr(living);
        if (tickCount % 80 == 0){
            this.scream(living);
        }
        if (distance >= range){
            if (tickCount % 20 == 0){
                this.getNavigation().moveTo(living,1f);
            }
        }else if (distance < range * 0.75){
            if (tickCount % 20 == 0){
                Vec3 vec3 = Utilities.generatePositionAway(living.position(),10);
                this.getNavigation().moveTo(vec3.x,vec3.y,vec3.z,1.5f);
            }
        }else if (this.getNavigation().isDone()){
            this.setDeltaMovement(this.getDeltaMovement().multiply(0, 1, 0)
                    .add(living.position().subtract(this.position()).normalize()
                            .yRot(90)).scale(this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 2));
        }else{
            this.getNavigation().stop();
        }
        if (this.getY() < living.getY() +4){
            this.setDeltaMovement(this.getDeltaMovement().add(0,0.1,0));
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.HUNGER,1200,0));
        }
        return super.doHurtTarget(entity);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            public boolean canUse() {
                return canAttack() && super.canUse();
            }
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_VILLAGER_GROWL.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_VILLAGER_DEATH.get();
    }

}
