package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import com.Harbinger.Spore.Sentities.Utility.GastGeber;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.util.List;

public class Scamper extends EvolvedInfected implements WaterInfected, VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Busser.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> AGE = SynchedEntityData.defineId(Scamper.class, EntityDataSerializers.INT);
    public int deployClock = 0;
    public boolean deploying;

    public Scamper(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        setPersistenceRequired();
        this.navigation = new HybridPathNavigation(this,this.level());
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
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.sca_loot.get();
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("age",entityData.get(AGE));
        tag.putInt("Variant", this.getTypeVariant());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(AGE, tag.getInt("age"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(AGE, 0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public void setAge(int e){
        this.entityData.set(AGE,e);
    }
    public int getAge(){
        return this.entityData.get(AGE);
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        if (getVariant() == ScamperVariants.DROWNED){
            return false;
        }
        return super.canDrownInFluidType(type);
    }

    public void travel(Vec3 vec3) {
        if (this.isEffectiveAi() && this.isInFluidType() && getVariant() == ScamperVariants.DROWNED) {
            this.moveRelative(0.1F, vec3);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.85D));
        } else {
            if (this.isInFluidType() && getVariant() != ScamperVariants.DROWNED){
                this.setDeltaMovement(this.getDeltaMovement().add(0,0.01D,0));
            }
            super.travel(vec3);
        }
    }

    @Override
    public void tick() {
        if (this.isAlive() && deployClock > 0) {deployClock--;}
        if (this.deployClock == 0){deploying = false;}
        if (this.isAlive() && this.tickCount % 20 == 0){
            this.setAge(this.getAge()+1);
            if (this.getAge() >= SConfig.SERVER.scamper_age.get()) {
                if (!level().isClientSide){
                    if ((this.getLinked() && Math.random() < 0.3f)  || this.getEvoPoints() >= SConfig.SERVER.min_kills_hyper.get()){
                        GastGeber geber = new GastGeber(Sentities.GASTGABER.get(),level());
                        geber.setKills(this.getKills() + this.getEvoPoints());
                        geber.moveTo(this.position());
                        level().addFreshEntity(geber);
                    }else{
                        int chance = this.random.nextInt(1,3);
                        int age = this.random.nextInt(1,4);
                        if (SConfig.SERVER.scamper_summon.get()){
                            Summon(4);
                        }
                        for (int i = 0; i < chance; ++i) {
                            if (SConfig.SERVER.scamper_summon.get()){
                                Summon(age);
                            }
                        }
                        if (SConfig.SERVER.scent_spawn.get()){
                            SummonScent();
                        }
                        level().setBlock(new BlockPos((int) this.getX(),(int) this.getY(),(int) this.getZ()) ,Sblocks.REMAINS.get().defaultBlockState(), 2);
                    }
                    if (this.level() instanceof ServerLevel serverLevel){
                        double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
                        double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                        double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                        serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
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
        int vecx = randomSource.nextInt(-3 ,3);
        int vecz = randomSource.nextInt(-3 ,3);
        mound.moveTo(this.getX() + vecx,this.getY(),this.getZ() + vecz);
        mound.setMaxAge(i);
        mound.setLinked(this.getLinked());
        mound.tickEmerging();
        mound.addEffect(new MobEffectInstance(MobEffects.REGENERATION ,200,0));
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
                .add(Attributes.FOLLOW_RANGE, 8)
                .add(Attributes.ATTACK_KNOCKBACK, 0);

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

    public ScamperVariants getVariant() {
        return ScamperVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        if (i > ScamperVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return ScamperVariants.values().length;
    }

    public void setVariant(ScamperVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
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
            areaeffectcloud.setRadius(2.0F);
            areaeffectcloud.setDuration(600);
            areaeffectcloud.setRadiusPerTick((4.0F - areaeffectcloud.getRadius()) / (float)areaeffectcloud.getDuration());
            areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 200, 1));
            entity.level().addFreshEntity(areaeffectcloud);
        }

    }

}
