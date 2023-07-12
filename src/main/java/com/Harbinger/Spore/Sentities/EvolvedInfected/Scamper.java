package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Scamper extends EvolvedInfected {
    public int deployClock = 0;
    public boolean deploying;

    public Scamper(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        setPersistenceRequired();
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean isDeploying() {
        return deploying;
    }

    public void setDeploying(boolean deploying) {
        this.deploying = deploying;
    }

    @Override
    public void tick() {
        if (this.isAlive() && deployClock > 0)
        {deployClock = deployClock - 1;}
        if (this.deployClock == 0){
            deploying = false;}

        if (this.isAlive()){
            this.getPersistentData().putInt("age", 1 + this.getPersistentData().getInt("age"));
            if (this.getPersistentData().getInt("age") >= SConfig.SERVER.scamper_age.get()) {
                if (!level().isClientSide){
                    if (SConfig.SERVER.scamper_summon.get()){
                        Summon(4);
                    }
                    RandomSource randomSource = RandomSource.create();
                    int chance = randomSource.nextInt(1,3);
                    int age = randomSource.nextInt(1,4);
                    for (int i = 0; i < chance; ++i) {
                        if (SConfig.SERVER.scamper_summon.get()){
                            Summon(age);
                        }
                    }
                    if (SConfig.SERVER.scent_spawn.get()){
                        SummonScent();
                    }
                    this.discard();
                }
            }
        }
        super.tick();
    }

    private void Summon(int i){
        RandomSource randomSource = RandomSource.create();
        Mound mound = new Mound(Sentities.MOUND.get(),level());
        int vecx = randomSource.nextInt(-2 ,2);
        int vecz = randomSource.nextInt(-2 ,2);
        mound.moveTo(this.getX(),this.getY(),this.getZ());
        mound.setMaxAge(i);
        mound.addEffect(new MobEffectInstance(MobEffects.REGENERATION ,200,0));
        mound.setDeltaMovement(0.4 * vecx ,0.1,0.4 * vecz);
        level().explode(this,this.getX(),this.getY(), this.getZ(),1f, Level.ExplosionInteraction.NONE);
        level().addFreshEntity(mound);
    }
    private void SummonScent(){
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),level());
        scent.moveTo(this.getX(),this.getY() + 0.4F ,this.getZ());
        level().addFreshEntity(scent);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this ,1.2, true));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.scamper_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.scamper_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.scamper_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 36)
                .add(Attributes.ATTACK_KNOCKBACK, 0);

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


    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),  600, 1), this);
                if (this.deployClock == 0 && !this.isDeploying()){
                    this.setDeploying(true);
                    setcloud(this);
                    this.deployClock = 800;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void setcloud(LivingEntity entity){
        if (!entity.level().isClientSide) {
            AreaEffectCloud areaeffectcloud = new AreaEffectCloud(entity.level(), entity.getX(), entity.getY(), entity.getZ());
            areaeffectcloud.setOwner(entity);

            areaeffectcloud.setParticle(Sparticles.SPORE_PARTICLE.get());
            areaeffectcloud.setRadius(2.0F);
            areaeffectcloud.setDuration(600);
            areaeffectcloud.setRadiusPerTick((4.0F - areaeffectcloud.getRadius()) / (float)areaeffectcloud.getDuration());
            areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 200, 1));
            entity.level().addFreshEntity(areaeffectcloud);
        }

    }

}
