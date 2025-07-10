package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Inebriator extends EvolvedInfected {
    private int attackAnimationTick;
    private LivingEntity patient;
    public Inebriator(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    public void setPatient(LivingEntity patient){
        this.patient = patient;
    }
    public LivingEntity getPatient(){
        return this.patient;
    }

    public List<MobEffectInstance> getEffects(){
        List<MobEffectInstance> values = new ArrayList<>();
        for (String s : SConfig.SERVER.ineb_buffs.get()){
            String[] val = s.split("\\|");
            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(val[0]));
            if (effect != null){
                values.add(new MobEffectInstance(effect,Integer.parseUnsignedInt(val[1]), Integer.parseUnsignedInt(val[2])));
            }
        }
        return values;
    }

    public void checkForPatients(){
        Level level = this.level();
        if (!level.isClientSide()){
            AABB aabb = this.getBoundingBox().inflate(4,1,4);
            List<Entity> entities = level.getEntities(this,aabb, entity -> {return entity instanceof LivingEntity livingEntity
             && (livingEntity instanceof Infected || livingEntity instanceof UtilityEntity);});
            if (entities.isEmpty()){return;}
            Entity entity = entities.get(random.nextInt(entities.size()));
            if (entity instanceof LivingEntity livingEntity && !(livingEntity instanceof Inebriator) && this.hasLineOfSight(livingEntity))
            {setPatient(livingEntity);}
        }
    }

    public void InjectMedicine(List<MobEffectInstance> effects){
        LivingEntity entity = this.getPatient();
        if (entity != null){
            for (MobEffectInstance instance : effects){
                entity.addEffect(instance);
            }
            this.level().broadcastEntityEvent(this, (byte)4);
            this.playSound(Ssounds.INEBRIATER_INJECT.get());
        }
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        } else {
            super.handleEntityEvent(value);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if (tickCount % 40 == 0){
            checkForPatients();
            LivingEntity livingEntity = getPatient();
            if (getPatient() != null && (!getPatient().isAlive())) {
                setPatient(null);
            }
            if (livingEntity != null){
                if (!livingEntity.isAlive()){
                    setPatient(null);
                }else {
                    if (livingEntity.distanceTo(this) < 4){
                        this.InjectMedicine(this.getEffects());
                    }
                }
            }
        }
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inebriater_loot.get();
    }
    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.ineb_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.ineb_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.ineb_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new FollowPatientGoal(this, 1.5, 4.0f, 2.0f));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();}

            @Override
            public boolean canUse() {
                AABB aabb = mob.getBoundingBox().inflate(4, 1, 4);
                List<Entity> allies = mob.level().getEntities(mob, aabb, entity ->
                        (entity instanceof Infected || entity instanceof UtilityEntity) && !(entity instanceof Inebriator));
                return allies.isEmpty() && super.canUse();
            }});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        super.registerGoals();
    }


    public static class FollowPatientGoal extends Goal {
        private final Inebriator mob;
        private LivingEntity target;
        private final double speedModifier;
        private final float stopDistance;
        private final float startDistance;

        public FollowPatientGoal(Inebriator mob, double speedModifier, float startDistance, float stopDistance) {
            this.mob = mob;
            this.speedModifier = speedModifier;
            this.startDistance = startDistance;
            this.stopDistance = stopDistance;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            target = mob.getPatient();
            return target != null && target.isAlive() && mob.distanceTo(target) > startDistance;
        }

        @Override
        public boolean canContinueToUse() {
            return target != null && target.isAlive() && mob.distanceTo(target) > stopDistance;
        }

        @Override
        public void tick() {
            if (target != null) {
                mob.getNavigation().moveTo(target, speedModifier);
            }
        }

        @Override
        public void stop() {
            target = null;
            mob.getNavigation().stop();
        }
    }


    protected SoundEvent getAmbientSound() {
        return Ssounds.SCIENTIST_AMBIENT.get();
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
}
