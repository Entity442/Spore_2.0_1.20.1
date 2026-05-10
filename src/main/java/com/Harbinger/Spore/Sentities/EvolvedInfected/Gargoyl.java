package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import com.Harbinger.Spore.Sentities.AI.NeuralProcessing.Experimental.ExpAirPathNavigation;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedArialMovementControl;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.GargoyleVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Gargoyl extends EvolvedInfected implements FlyingInfected, ArmedInfected,HasUsableSlot , VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Gargoyl.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> ATTACK_TICKS = SynchedEntityData.defineId(Gargoyl.class, EntityDataSerializers.INT);
    public Gargoyl(EntityType<? extends Infected> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedArialMovementControl(this , 20,false);
        this.navigation = new ExpAirPathNavigation(this,level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.gargoyle_health.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.gargoyle_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR,  SConfig.SERVER.gargoyle_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.FLYING_SPEED, 0.4);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.gargoyle_loot.get();
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        InfectedPlayer.createName(this,SConfig.DATAGEN.name.get());
        InfectedPlayer.createItems(this,EquipmentSlot.HEAD,SConfig.DATAGEN.player_h.get());
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficulty, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        this.populateDefaultEquipmentSlots(this.random, difficulty);
        setVariant(Util.getRandom(GargoyleVariants.values(), random));
        return super.finalizeSpawn(serverLevelAccessor, difficulty, p_21436_, p_21437_, p_21438_);
    }

    public boolean isBomb(){return getVariant() == GargoyleVariants.BOMBER && getHealth() <= getMaxHealth()/4;}

    public boolean causeFallDamage(float damage_val, float protection_val, DamageSource source) {
        if (fallDistance < 3 || !isAlive() || getVariant() == GargoyleVariants.ICHOR) return false;
        boolean bomb = getVariant() == GargoyleVariants.BOMBER && getHealth() > getMaxHealth()/4;;
        if (getVariant() == GargoyleVariants.VALKYRIE){
            setAttackTicks(80);
            this.playSound(Ssounds.LANDING.get(), 2.2f, 0.8f);
            return false;
        }
        float ratio = 0.1f;
        float attackMulti = 1f + (fallDistance * ratio);

        double smashRange = 2 + fallDistance * 0.25;
        double blockBreaking = 1 + fallDistance * 0.15;
        smashRange = smashRange > 16 ? 16 : smashRange;
        attackMulti = attackMulti > 3 ? 3 : attackMulti;

        smashRange = bomb ? smashRange * 1.5f : smashRange;
        attackMulti = bomb ? attackMulti * 1.5f : attackMulti;

        this.DamageEntities(level(), smashRange, attackMulti);
        this.SmashStomp(level(), this.blockPosition(), smashRange, blockBreaking > 32 ? 32 : blockBreaking);

        this.playSound(Ssounds.LANDING.get(), 2f, 0.8f);
        if (bomb){
            level().explode(this,this.getBlockX(),this.getBlockY(),this.getBlockZ(),2, Level.ExplosionInteraction.NONE);
            this.hurt(level().damageSources().generic(),5);
        }
        return false;
    }
    protected void SmashStomp(Level level, BlockPos pos, double range,double breaking){
        if (level instanceof ServerLevel serverLevel){
            for(int i = 0; i <= 2*range; ++i) {
                for(int j = 0; j <= 2*range; ++j) {
                    for(int k = 0; k <= 2*range; ++k) {
                        double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                        if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                            if (distance<range+(0.5)){
                                BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                                BlockState state = level.getBlockState(blockpos);
                                boolean airBelow = level.getBlockState(blockpos.below()).isAir();
                                double breakSpeed = state.getDestroySpeed(level,pos);
                                if (airBelow && state.getDestroySpeed(level,pos) >= 0 && breakSpeed <= breaking && Math.random() < 0.3 && !state.isAir()){
                                    FallingBlockEntity.fall(serverLevel,blockpos,state);
                                    serverLevel.removeBlock(blockpos,false);
                                }
                            }}}}}}
    }
    protected void DamageEntities(Level level,double range,float multiplier){
        AttributeInstance instance = this.getAttribute(Attributes.ATTACK_DAMAGE);
        if (instance == null || level.isClientSide){
            return;
        }
        instance.setBaseValue(SConfig.SERVER.gargoyle_damage.get() * SConfig.SERVER.global_damage.get() * multiplier);
        AABB aabb = this.getBoundingBox().inflate(range);
        boolean bloom = getVariant() == GargoyleVariants.BLOOMING;
        List<Entity> entities = level().getEntities(this,aabb);
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                this.doHurtTarget(living);
                if (bloom){
                    living.addEffect(new MobEffectInstance(MobEffects.POISON,400,1));
                }
            }
        }
    }
    @Override
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && !this.onGround()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement().scale(isInWater() ? 0.2 : this.getVariant() == GargoyleVariants.BLOOMING ? 0.5 : 1f));
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            super.travel(vec);
        }
        this.setDeltaMovement(getDeltaMovement().add(0,-0.01,0));
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (dataAccessor.equals(DATA_ID_TYPE_VARIANT)){
            double prot = 1;
            AttributeInstance protection = this.getAttribute(Attributes.ARMOR);
            if (getVariant() == GargoyleVariants.VALKYRIE){
                prot = 2;
            }
            if (protection != null) {
                protection.setBaseValue(SConfig.SERVER.gargoyle_armor.get() * prot);
            }
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return super.getDimensions(pose).scale(getVariant() == GargoyleVariants.VALKYRIE ? 1.2f : 1);
    }

    @Override
    protected void addTargettingGoals() {
        this.goalSelector.addGoal(2, new HurtTargetGoal(this , livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}, Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {return livingEntity instanceof Player || SConfig.SERVER.whitelist.get().contains(livingEntity.getEncodeId());}){
            @Override
            protected AABB getTargetSearchArea(double targetDistance) {
                return this.mob.getBoundingBox().inflate(targetDistance, targetDistance, targetDistance);
            }
        });
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true, livingEntity -> {return SConfig.SERVER.at_mob.get() && TARGET_SELECTOR.test(livingEntity);}){
            @Override
            protected AABB getTargetSearchArea(double targetDistance) {
                return this.mob.getBoundingBox().inflate(targetDistance, targetDistance, targetDistance);
            }
        });

    }

    public void setAttackTicks(int value){
        entityData.set(ATTACK_TICKS,value);
    }
    public int getAttackTicks(){
        return entityData.get(ATTACK_TICKS);
    }
    public boolean canAttack(){
        return getAttackTicks() > 0;
    }
    @Override
    public void tick() {
        super.tick();
        if (canAttack()){
            setAttackTicks(getAttackTicks()-1);
        }
        if (getVariant() == GargoyleVariants.ICHOR){
            for (int i = 0;i<5;i++){
                float randomX = (float) (position().x + (random.nextFloat() -random.nextFloat()) * 1.2);
                float randomY = (float) (position().y + (random.nextFloat() -random.nextFloat()) * 1.2);
                float randomZ = (float) (position().z + (random.nextFloat() -random.nextFloat()) * 1.2);
                this.level().addParticle(ParticleTypes.FALLING_HONEY,randomX,randomY,randomZ,0,-1,0);
            }
        }
        if (getVariant() == GargoyleVariants.BLOOMING){
            for (int i = 0;i<10;i++){
                float randomX = (float) (position().x + (random.nextFloat() -random.nextFloat()) * 6);
                float randomY = (float) (position().y + (random.nextFloat() -random.nextFloat()) * 6);
                float randomZ = (float) (position().z + (random.nextFloat() -random.nextFloat()) * 6);
                this.level().addParticle(ParticleTypes.SPORE_BLOSSOM_AIR,randomX,randomY,randomZ,0,0,0);
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_TYPE_VARIANT, 0);
        entityData.define(ATTACK_TICKS, 0);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }

            @Override
            public boolean canUse() {
                return super.canUse() && (canAttack() || isBomb());
            }
        });
        this.goalSelector.addGoal(1, new GargoyleDiveGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.ADVENTURER_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_VILLAGER_DEATH.get();
    }

    @Override
    public boolean hasUsableSlot(EquipmentSlot slot) {
        return slot == EquipmentSlot.HEAD;
    }

    public GargoyleVariants getVariant() {
        return GargoyleVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,
                (i >= 0 && i < GargoyleVariants.values().length) ? i : 0);
    }

    @Override
    public int amountOfMutations() {
        return GargoyleVariants.values().length;
    }

    private void setVariant(GargoyleVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    @Override
    public String getMutation() {
        return getTypeVariant() != 0 ? this.getVariant().getName() : super.getMutation();
    }

    public static class GargoyleDiveGoal extends Goal {

        private final Gargoyl gargoyle;
        private int state = 0;

        public GargoyleDiveGoal(Gargoyl mob){
            this.gargoyle = mob;
        }

        @Override
        public boolean canUse() {
            if (gargoyle.canAttack() || gargoyle.isBomb()){
                return false;
            }
            LivingEntity target = gargoyle.getTarget();
            return target != null && target.isAlive() && gargoyle.distanceTo(target) < 32 && !target.isInWater();
        }

        @Override
        public void start(){
            state = 0;
        }

        @Override
        public void tick(){
            LivingEntity target = gargoyle.getTarget();
            if(target == null) return;

            switch (state){

                case 0 -> {
                    Vec3 pos = new Vec3(
                            target.getX(),
                            target.getY() + (gargoyle.getVariant() == GargoyleVariants.ICHOR ? 5 : 10),
                            target.getZ()
                    );

                    gargoyle.getMoveControl().setWantedPosition(
                            pos.x, pos.y, pos.z, 1.2
                    );
                    if (pos.y > gargoyle.getY()){
                        gargoyle.setDeltaMovement(
                                gargoyle.getDeltaMovement().add(0, 0.1, 0)
                        );
                    }
                    if(gargoyle.distanceToSqr(pos) < 4){
                        if (gargoyle.getVariant() == GargoyleVariants.ICHOR){
                            createHitBox();
                        }else {
                            state = 1;
                        }
                    }
                }

                case 1 -> {
                    gargoyle.setDeltaMovement(
                            gargoyle.getDeltaMovement().add(0, -1.6, 0)
                    );
                    gargoyle.hurtMarked = true;
                    if(gargoyle.onGround()){
                        state = 2;
                    }
                }

                case 2 -> stop();
            }
        }
        public void createHitBox(){
            AABB aabb = gargoyle.getBoundingBox().inflate(1,6,1).move(0,-4,0);
            List<Entity> entities = gargoyle.level().getEntities(gargoyle,aabb);
            for (Entity entity : entities){
                if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                    living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),400,1),gargoyle);
                    for (MobEffectInstance instance : BileLiquid.bileEffects()){
                        living.addEffect(instance);
                    }
                }
            }
            if (entities.isEmpty()){
                state = 1;
            }
        }

        @Override
        public boolean canContinueToUse(){
            LivingEntity target = gargoyle.getTarget();
            if (gargoyle.isBomb() || target == null){
                return false;
            }
            return state != 2 && gargoyle.isAlive();
        }

        @Override
        public void stop(){
            state = 0;
        }
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (entity.isInWater()){
            return false;
        }
        return super.hasLineOfSight(entity);
    }
}
