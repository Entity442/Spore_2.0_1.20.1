package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedArialMovementControl;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Gargoyl extends EvolvedInfected implements FlyingInfected, ArmedInfected,HasUsableSlot {
    public Gargoyl(EntityType<? extends Infected> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedArialMovementControl(this , 20,false);
        this.navigation = new FlyingPathNavigation(this,level);
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
        return super.finalizeSpawn(serverLevelAccessor, difficulty, p_21436_, p_21437_, p_21438_);
    }

    public boolean causeFallDamage(float damage_val, float protection_val, DamageSource source) {
        if (fallDistance < 3) return false;

        float ratio = 0.1f;
        float attackMulti = 1f + (fallDistance * ratio);

        double smashRange = 2 + fallDistance * 0.25;
        double blockBreaking = 1 + fallDistance * 0.15;

        this.DamageEntities(level(), smashRange, attackMulti);
        this.SmashStomp(level(), this.blockPosition(), smashRange, blockBreaking);

        this.playSound(Ssounds.LANDING.get(), 2f, 0.8f);
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
                                if (airBelow && state.getDestroySpeed(level,pos) >= 0 && breakSpeed <= breaking && Math.random() < 0.3){
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
        List<Entity> entities = level().getEntities(this,aabb);
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                this.doHurtTarget(living);
            }
        }
    }
    @Override
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && !this.onGround()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement().scale(isInWater() ? 0.2 : 1f));
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            super.travel(vec);
        }
        this.setDeltaMovement(getDeltaMovement().add(0,-0.01,0));
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

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new GargoyleDiveGoal(this));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
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

    public static class GargoyleDiveGoal extends Goal {

        private final Gargoyl gargoyle;
        private LivingEntity target;
        private int state = 0;

        public GargoyleDiveGoal(Gargoyl mob){
            this.gargoyle = mob;
        }

        @Override
        public boolean canUse() {
            target = gargoyle.getTarget();
            return target != null && target.isAlive() && gargoyle.distanceTo(target) < 32 && !target.isInWater();
        }

        @Override
        public void start(){
            state = 0;
        }


        @Override
        public void tick(){

            if(target == null) return;

            switch (state){

                case 0 -> {
                    Vec3 pos = new Vec3(
                            target.getX(),
                            target.getY() + 10,
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
                        state = 1;
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

        @Override
        public boolean canContinueToUse(){
            return state != 2 && gargoyle.isAlive();
        }

        @Override
        public void stop(){
            state = 0;
            target = null;
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
