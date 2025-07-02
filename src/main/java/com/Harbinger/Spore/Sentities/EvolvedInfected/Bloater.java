package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.AI.ReturnToWater;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.MovementControls.WaterXlandMovement;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.util.List;

public class Bloater extends EvolvedInfected implements WaterInfected {
    public static final EntityDataAccessor<Integer> TUMORS = SynchedEntityData.defineId(Bloater.class, EntityDataSerializers.INT);
    private int explosionTicks = 0;
    public Bloater(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.moveControl = new WaterXlandMovement(this);
        this.navigation = new HybridPathNavigation(this,this.level());
    }
    public void travel(Vec3 p_32858_) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, p_32858_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            super.travel(p_32858_);
        }
    }
    @Override
    public float getStepHeight() {
        return this.isInFluidType() ? 2.0f : 1.0f;
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.bloater_melee_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.braio_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.bloater_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 28)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    public int getAmountOfTumors(){return entityData.get(TUMORS);}
    public void setAmountOfTumors(int value){entityData.set(TUMORS,value);}

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TUMORS,4);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setAmountOfTumors(tag.getInt("tumors"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("tumors",getAmountOfTumors());
    }

    @Override
    public void tick() {
        super.tick();
        if (explosionTicks > 0){
            tickExplosion();
        }
        if (tickCount % 400 == 0 && this.getAmountOfTumors() < 4){
            this.setAmountOfTumors(getAmountOfTumors()+1);
        }
    }

    public void tickExplosion(){
        if (explosionTicks == 1){
            this.playSound(SoundEvents.CREEPER_PRIMED);
        }
        explosionTicks++;
        if (explosionTicks == 50){
            explodeTumor();
            explosionTicks = 0;
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.bloater_loot.get();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (Math.random() < 0.5f && getAmountOfTumors() > 0){
            tickExplosion();
        }
        if (entity.isInFluidType()){
            entity.setDeltaMovement(getDeltaMovement().add(0f,-1f,0));
        }
        return super.doHurtTarget(entity);
    }

    public void explodeTumor(){
        AABB aabb = this.getBoundingBox().inflate(8);
        List<Entity>  entities = level().getEntities(this,aabb,entity -> {return entity instanceof LivingEntity living && this.TARGET_SELECTOR.test(living);});
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living && !Utilities.helmetList().contains(living.getItemBySlot(EquipmentSlot.HEAD).getItem())){
                living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),200,2));
                living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,200,0));
            }
        }
        this.playSound(SoundEvents.GENERIC_EXPLODE);
        this.setAmountOfTumors(getAmountOfTumors()-1);
        if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
            serverLevel.sendParticles(Sparticles.SPORE_PARTICLE.get(), x0, y0, z0, 12,0, 0, 0,1);
        }
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.3, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2 + entity.getBbWidth() * entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4 , new ReturnToWater(this, 1.2));
        super.registerGoals();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.DROWNED_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
}
