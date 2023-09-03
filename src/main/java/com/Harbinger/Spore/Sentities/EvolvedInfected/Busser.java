package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.*;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Carrier;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedArialMovementControl;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class Busser extends EvolvedInfected implements Carrier, FlyingInfected {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Griefer.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Griefer.class, EntityDataSerializers.INT);
    private int flytimeV;
    private int swell;

    public Busser(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedArialMovementControl(this , 20,true);
    }
    public boolean causeFallDamage(float p_147105_, float p_147106_, DamageSource p_147107_) {
        return false;
    }


    @Override
    protected void positionRider(Entity entity, MoveFunction p_19958_) {
        super.positionRider(entity, p_19958_);
        Vec3 vec3 = (new Vec3(0.4D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        entity.setPos(this.getX() + vec3.x, this.getY() - 1.2,this.getZ()+ vec3.z);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(3, new BusserSwellGoal(this));
        this.goalSelector.addGoal(3, new PhayerGrabAndDropTargets(this));
        this.goalSelector.addGoal(3, new PullGoal(this, 32, 16) {
            @Override
            public boolean canUse() {
                return super.canUse() && !(Busser.this.onGround() || Busser.this.isVehicle() || Busser.this.getTypeVariant() == 2);
            }
        });
        this.goalSelector.addGoal(4, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 5.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });
            this.goalSelector.addGoal(5, new BusserFlyAndDrop(this, 6){
                @Override
                public boolean canUse() {
                    return Busser.this.getTypeVariant() == 0 && super.canUse();
                }
            });
            this.goalSelector.addGoal(6, new TransportInfected<>(this, Mob.class, 0.8 ,
                    e -> { return SConfig.SERVER.can_be_carried.get().contains(e.getEncodeId()) || SConfig.SERVER.ranged.get().contains(e.getEncodeId());}){
                @Override
                public boolean canUse() {
                    return Busser.this.getTypeVariant() == 0 && super.canUse();
                }
            });

        this.goalSelector.addGoal(7 , new FlyingWanderAround(this , 1.0){
            @Override
            public boolean canUse() {
                return super.canUse() && !Busser.this.onGround();
            }
        });
        this.goalSelector.addGoal(7,new RandomStrollGoal(this ,1.0){
            @Override
            public boolean canUse() {
                return super.canUse() && Busser.this.onGround();
            }
        });
        super.registerGoals();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        double damage;
        if (this.getTypeVariant() == 1){
            damage = 0.1;
        }else {
            damage = 0.3;
        }
        if (Math.random() < damage && this.isVehicle()){
            this.ejectPassengers();
        }
        return super.hurt(source, amount);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.bus_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.bus_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR,  SConfig.SERVER.bus_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 128)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.FLYING_SPEED, 0.4);

    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAlive()) {

            int i = this.getSwellDir();
            if (i > 0 && this.swell == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                this.gameEvent(GameEvent.PRIME_FUSE);
            }

            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }

            if (this.swell >= 20) {
                this.swell = 20;
                this.explodeBusser();
            }
        }
    }

    private void explodeBusser() {
        if (!this.level().isClientSide) {
            Level.ExplosionInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) ? Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2f, explosion$blockinteraction);
            discard();
            for(int i = 0;i<3;i++){
                int x = this.random.nextInt(-2,2);
                int z = this.random.nextInt(-2,2);
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level(), this.getX() + x, this.getY(), this.getZ() + z);
                areaeffectcloud.setRadius(2.5F);
                areaeffectcloud.setRadiusOnUse(-0.5F);
                areaeffectcloud.setWaitTime(10);
                areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 200, 2));
                areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MARKER.get(), 600, 0));
                areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());
                this.level().addFreshEntity(areaeffectcloud);
            }

        }
    }


    @Override
    protected PathNavigation createNavigation(Level level) {
        if (this.onGround()){
            GroundPathNavigation navigation = new GroundPathNavigation(this,level);
            navigation.canPassDoors();
            return navigation;
        }else {
            FlyingPathNavigation navigation = new FlyingPathNavigation(this,level);
            navigation.canPassDoors();
            return navigation;
        }
    }


    @Override
    protected void customServerAiStep() {
        if (this.getTypeVariant() == 1){
                AttributeInstance health = this.getAttribute(Attributes.MAX_HEALTH);
                assert health != null;
                health.setBaseValue(SConfig.SERVER.bus_hp.get() * 2 * SConfig.SERVER.global_health.get());
                AttributeInstance armor = this.getAttribute(Attributes.ARMOR);
                assert armor != null;
                armor.setBaseValue(SConfig.SERVER.bus_armor.get() * 2 * SConfig.SERVER.global_armor.get());

            if (this.isVehicle()){
                this.setDeltaMovement(this.getDeltaMovement().add(0,0.03,0));
                if (this.flytimeV < 200){
                    this.flytimeV++;
                }else{
                    this.flytimeV = 0;
                    this.ejectPassengers();
                }
            }
        }
        if (!this.onGround() && this.getTarget() != null && this.getRandom().nextInt(5)==0){
            double d0 = this.getTarget().getX() - this.getX();
            double d1 = this.getTarget().getY() - this.getY();
            double d2 = this.getTarget().getZ() - this.getZ();
            this.setDeltaMovement(this.getDeltaMovement().add(new Vec3(d0, d1, d2).normalize().scale(0.06D)));
        }
        super.customServerAiStep();
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(DATA_SWELL_DIR, -1);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (DATA_ID_TYPE_VARIANT.equals(dataAccessor)){
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.getVariant() == BusserVariants.ENHANCED){
            return super.getDimensions(pose).scale(1.2f);
        }
        return super.getDimensions(pose);
    }
    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }

    public void setSwellDir(int p_32284_) {
        this.entityData.set(DATA_SWELL_DIR, p_32284_);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        BusserVariants variant = Math.random() < 0.3 ?
                Math.random() < 0.5 ?
                        BusserVariants.ENHANCED : BusserVariants.BOMBER : BusserVariants.DEFAULT;
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public BusserVariants getVariant() {
        return BusserVariants.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(BusserVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
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
}
