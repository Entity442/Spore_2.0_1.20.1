package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Conductor extends EvolvedInfected{
    private int attackAnimationTick;
    protected List<AmbientSparks> sparks = new ArrayList<>();
    private static final EntityDataAccessor<Float> CHARGE = SynchedEntityData.defineId(Conductor.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DATA_ID = SynchedEntityData.defineId(Conductor.class, EntityDataSerializers.INT);
    private int beamTicks;

    public Conductor(EntityType<? extends EvolvedInfected> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();}
        });

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }
    public List<AmbientSparks> getSparks(){
        return sparks;
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.conductor_loot.get();
    }
    public float getCharge(){
        return entityData.get(CHARGE);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.conductor_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.conductor_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.conductor_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32);

    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        }if (value == 7) {
            this.beamTicks = 20;
        } else {
            super.handleEntityEvent(value);
        }
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CHARGE,0f);
        entityData.define(DATA_ID,-1);
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }
    @Override
    public void tick() {
        super.tick();
        if (isAggressive()){
            if (getCharge() <= 20){
                entityData.set(CHARGE,entityData.get(CHARGE)+0.1f);
            }
        }else {
            if (getCharge() > 0){
                entityData.set(CHARGE,entityData.get(CHARGE)-0.1f);
            }
        }
        if (tickCount % 5 == 0 && getCharge() > 0){
            float range = Math.abs(getCharge() * 0.15f);
            List<Entity> nearbyEntities = level().getEntities(this,this.getBoundingBox().inflate(1+range));
            int charge = (int) range * 3;
            this.playSound(Ssounds.ELECTRIC.get());
            for (int i = 0;i<random.nextInt(3 + charge);i++){
                Vec3 vec3 = Utilities.generatePositionAway(this.position().add(0,2.2,0),1+range);
                Entity entity = nearbyEntities.isEmpty() ? null : nearbyEntities.get(random.nextInt(nearbyEntities.size()));
                LivingEntity living = null;
                if (entity instanceof LivingEntity livingEntity && Utilities.TARGET_SELECTOR.Test(livingEntity) && this.hasLineOfSight(livingEntity)){
                    living = livingEntity;
                }
                if (level().isClientSide){
                    AmbientSparks ambientSparks = new AmbientSparks(vec3,living,this,random.nextInt(5,10));
                    sparks.add(ambientSparks);
                }else {
                    if (living != null){
                        entityData.set(CHARGE,entityData.get(CHARGE)-1f);
                        living.hurt(level().damageSources().lightningBolt(), (float) (SConfig.SERVER.conductor_el_small_damage.get() * SConfig.SERVER.global_damage.get()));
                        if (Math.random() < 0.2){
                            living.setRemainingFireTicks(40);
                        }
                    }
                }
            }
        }
        if (level().isClientSide){
            if (!sparks.isEmpty()){
                Iterator<AmbientSparks> it = sparks.iterator();

                while (it.hasNext()) {
                    AmbientSparks spark = it.next();

                    spark.TickSpark();

                    if (spark.life > spark.maxLife) {
                        it.remove();
                    }
                }
            }
        }
        if (!level().isClientSide
                && beamTicks <= 0
                && getCharge() >= 10){
            LivingEntity target = getTarget();

            if (target != null && hasLineOfSight(target)){
                setAttackId(target.getId());
                beamTicks = 20;
                level().broadcastEntityEvent(this, (byte)7);
                int voltageModifier = target instanceof IronGolem ? 3 : 1;
                target.hurt(level().damageSources().lightningBolt(), (float) (SConfig.SERVER.conductor_el_discharge_damage.get() * SConfig.SERVER.global_damage.get() * voltageModifier));
                target.setRemainingFireTicks(100);
                entityData.set(CHARGE, getCharge() - 10f);
                playSound(SoundEvents.LIGHTNING_BOLT_IMPACT);
            }
        }
    }
    public int getAttackedId(){
        return entityData.get(DATA_ID);
    }
    public void setAttackId(int i){
        entityData.set(DATA_ID,i);
    }
    public int getBeamTicks(){
        return beamTicks;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if(beamTicks > 0){
            beamTicks--;
            if (beamTicks <= 1){
                setAttackId(0);
            }
        }
    }

    @Override
    public boolean addEffect(MobEffectInstance effectInstance, @Nullable Entity entity) {
        if (effectInstance.getEffect().isBeneficial()){
            return super.addEffect(effectInstance, entity);
        }
        return false;
    }


    public int getAttackAnimationTick(){
        return attackAnimationTick;
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

    public static class AmbientSparks{
        public int life;
        public final Vec3 Connection;
        @Nullable
        public final Entity living;
        public final Conductor owner;
        public final int maxLife;
        protected List<Vec3> connections = new ArrayList<>();
        protected final RandomSource randomSource = RandomSource.create();

        public AmbientSparks(Vec3 connection, @Nullable Entity living, Conductor owner, int maxLife) {
            Connection = connection;
            this.living = living;
            this.owner = owner;
            this.maxLife = maxLife;
        }

        private void rebuildChain(Vec3 start, Vec3 end){

            double distance = start.distanceTo(end);

            int desiredSegments = Mth.clamp((int)(distance * 2), 4, 40);

            if(desiredSegments == connections.size()) return;

            connections.clear();

            for(int i = 0; i < desiredSegments; i++){

                double t = (double)i/(desiredSegments-1);

                connections.add(new Vec3(
                        Mth.lerp(t,start.x,end.x),
                        Mth.lerp(t,start.y,end.y),
                        Mth.lerp(t,start.z,end.z)
                ));
            }
        }
        public List<Vec3> getConnections(){
            return connections;
        }

        public void TickSpark(){
            life++;
            Vec3 vec3 = living == null ? Connection : living.position().add(0,living.getBbHeight()/2,0);
            double rng = (owner.random.nextFloat() - owner.random.nextFloat()) * 0.05;
            Vec3 basePosition = owner.position().add(rng,2.2,rng);
            if (connections.isEmpty()){
                rebuildChain(basePosition,vec3);
            }
            applyIK(connections,basePosition,vec3);
        }
        protected void moveSegmentTowards(List<Vec3> entities,int index, Vec3 target) {
            double random = (randomSource.nextFloat() - randomSource.nextFloat()) * 0.1;
            entities.set(index,target.add(random,random,random));
        }
        public void applyIK(List<Vec3> entities , Vec3 basePos,Vec3 camera) {
            if (entities == null || entities.size() < 3) return;
            moveSegmentTowards(entities,entities.size()-1, camera);
            for (int i = entities.size() - 2; i >= 0; i--) {
                Vec3 nextPos = entities.get(i + 1);
                Vec3 dir = entities.get(i).subtract(nextPos);

                float segmentLength = 1f;
                if (dir.lengthSqr() > 0.0001f) {
                    dir = dir.normalize().scale(segmentLength);
                } else {
                    dir = new Vec3(segmentLength, 0, 0);
                }

                Vec3 solvedPos = nextPos.add(dir);
                moveSegmentTowards(entities,i, solvedPos);
            }
            entities.set(0,basePos);

            for (int i = 1; i < entities.size(); i++) {
                Vec3 prevPos = entities.get(i - 1);
                Vec3 dir = entities.get(i).subtract(prevPos);

                float segmentLength = 1f;
                if (dir.lengthSqr() > 0.0001f) {
                    dir = dir.normalize().scale(segmentLength);
                } else {
                    dir = new Vec3(segmentLength, 0, 0);
                }

                Vec3 solvedPos = prevPos.add(dir);
                moveSegmentTowards(entities,i, solvedPos);
            }
        }
    }
}
