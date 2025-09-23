package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.*;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Carrier;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedArialMovementControl;
import com.Harbinger.Spore.Sentities.Projectile.StingerProjectile;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import net.minecraft.Util;
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
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class Busser extends EvolvedInfected implements Carrier, FlyingInfected, RangedAttackMob, VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Busser.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Busser.class, EntityDataSerializers.INT);
    private int flytimeV;
    private int swell;

    public Busser(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedArialMovementControl(this , 20,true);
        this.navigation = new FlyingPathNavigation(this,level);
    }
    public boolean causeFallDamage(float p_147105_, float p_147106_, DamageSource p_147107_) {
        return false;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_bus_loot.get();
    }
    @Override
    protected void positionRider(Entity entity, MoveFunction p_19958_) {
        super.positionRider(entity, p_19958_);
        Vec3 vec3 = (new Vec3(0.4D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        entity.setPos(this.getX() + vec3.x, this.getY() - 1.2,this.getZ()+ vec3.z);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(4, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            public boolean canUse() {
                return getTypeVariant() != 3 && super.canUse();
            }
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 5.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(3, new PullGoal(this, 32, 16){
            @Override
            public boolean canUse() {
                return getTypeVariant() == 0 && super.canUse();
            }
        });
        this.goalSelector.addGoal(5, new BusserFlyAndDrop(this, 6){
            @Override
            public boolean canUse() {
                return getTypeVariant() == 0 && super.canUse();
            }
        });
        this.goalSelector.addGoal(6, new TransportInfected<>(this, Mob.class, 0.8 ,
                e -> { return SConfig.SERVER.can_be_carried.get().contains(e.getEncodeId()) || SConfig.SERVER.ranged.get().contains(e.getEncodeId());}){
            @Override
            public boolean canUse() {
                return getTypeVariant() == 0 && super.canUse();
            }
        });

    }

    public void addVariantGoals(){
        if (getTypeVariant() == 3){
            this.goalSelector.addGoal(3,new ScatterShotRangedGoal(this,1.2,40,20,1,3){
                @Override
                public boolean canUse() {
                    return super.canUse() && getTypeVariant() == 3;
                }
            });
        }
        if (getTypeVariant() == 1){
            this.goalSelector.addGoal(3, new PhayerGrabAndDropTargets(this));
        }
        if (getTypeVariant() == 2){
            this.goalSelector.addGoal(3, new BusserSwellGoal(this));
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.bus_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.bus_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR,  SConfig.SERVER.bus_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.FLYING_SPEED, 0.4);

    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAlive() && this.getTypeVariant() == 2) {
            manageExplosiveBusser();
        }
    }

    public void manageExplosiveBusser(){
        int i = this.getSwellDir();
        if (i > 0 && this.swell == 0) {
            this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
            this.gameEvent(GameEvent.PRIME_FUSE);
        }
        if (i != 0){
            if (i > 0){
                this.swell++;
            }else{
                this.swell--;
            }
            if (this.swell < 0) {
                this.swell = 0;
            }
        }
        if (this.swell >= 20) {
            this.swell = 20;
            this.explodeBusser();
        }
    }

    private void explodeBusser() {
        if (!this.level().isClientSide) {
            Level.ExplosionInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) ? Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), SConfig.SERVER.kami_busser_explosion.get(), explosion$blockinteraction);
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
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && !this.onGround()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement().scale(this.isInWater() ? 0.1 : 0.75));
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            super.travel(vec);
        }
    }

    @Override
    protected void customServerAiStep() {
        if (this.getTypeVariant() == 1){
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
        if (tickCount % 20 == 0 && getTarget() == null && !onGround()){
            this.setDeltaMovement(this.getDeltaMovement().add(0,-0.2,0));
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
            addVariantGoals();
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
        BusserVariants variant = Util.getRandom(BusserVariants.values(), this.random);
        setVariant(variant);
        if (this.getTypeVariant() == 1){
            AttributeInstance health = this.getAttribute(Attributes.MAX_HEALTH);
            AttributeInstance armor = this.getAttribute(Attributes.ARMOR);
            if (health != null){health.setBaseValue(SConfig.SERVER.bus_hp.get() * 1.5f * SConfig.SERVER.global_health.get());}
            if (armor != null){armor.setBaseValue(SConfig.SERVER.bus_armor.get() * 1.5f * SConfig.SERVER.global_armor.get());}
        }
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }




    public BusserVariants getVariant() {
        return BusserVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        if (i > BusserVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return BusserVariants.values().length;
    }

    private void setVariant(BusserVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
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

    @Override
    public void performRangedAttack(LivingEntity entity, float p_33318_) {
        StingerProjectile stinger = new StingerProjectile(this.level(), this, (float) (SConfig.SERVER.bus_damage.get() *1f));
        stinger.moveTo(this.getX(),this.getY(),this.getZ());
        double dx = entity.getX() - this.getX();
        double dy = entity.getY() + entity.getEyeHeight() - 2;
        double dz = entity.getZ() - this.getZ();
        stinger.shoot(dx, dy - stinger.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
        this.level().addFreshEntity(stinger);
        this.setDeltaMovement(this.getDeltaMovement().add(0,0.3,0));
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }
}
