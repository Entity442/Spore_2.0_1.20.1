package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.GrieferSwellGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import com.Harbinger.Spore.Sentities.Variants.GrieferVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class Griefer extends EvolvedInfected {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Griefer.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Griefer.class, EntityDataSerializers.INT);
    private int swell;
    private final int maxSwell = 30;

    public Griefer(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_griefer_loot.get();
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putShort("Fuse", (short)this.maxSwell);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    public void tick() {
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

            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                    this.explodeGriefer();
            }

            if (this.getVariant() == GrieferVariants.RADIOACTIVE){
                if (this.tickCount % 30 == 0){
                    AABB boundingBox = this.getBoundingBox().inflate(6);
                    List<Entity> entities = this.level().getEntities(this, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
                    for (Entity entity1 : entities) {
                        if(entity1 instanceof LivingEntity livingEntity && !SConfig.SERVER.blacklist.get().contains(livingEntity.getEncodeId())) {
                            if (!(livingEntity instanceof Infected || livingEntity instanceof UtilityEntity)){
                                if (ModList.get().isLoaded("alexscaves")){
                                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("alexscaves:irradiated"));
                                    if (effect != null)
                                        livingEntity.addEffect(new MobEffectInstance(effect,200,0));
                                }else{
                                    livingEntity.hurt(SdamageTypes.radiation_damage(this),4);
                                }
                            }
                        }
                    }
                }
            }
        }
        super.tick();
    }



    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }

    public boolean grieferExplosion(){
        return this.swell >= 1;
    }


    public void setSwellDir(int p_32284_) {
        this.entityData.set(DATA_SWELL_DIR, p_32284_);
    }

    public int getSwell(){return swell;}

    private void explodeToxicTumor(boolean poison){
        AABB boundingBox = this.getBoundingBox().inflate(6);
        List<Entity> entities = this.level().getEntities(this, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity entity1 : entities) {
            if (entity1 instanceof LivingEntity livingEntity && Utilities.TARGET_SELECTOR.Test(livingEntity)) {
                if (poison){
                    livingEntity.addEffect( new MobEffectInstance(MobEffects.POISON ,  1200, 2));
                    livingEntity.addEffect( new MobEffectInstance(MobEffects.WEAKNESS ,  400, 0));
                }else{
                    for(MobEffectInstance instance : BileLiquid.bileEffects()){
                     livingEntity.addEffect(instance);
                    }
                }
            }
        }
    }

    private void explodeGriefer() {
        if (this.level() instanceof ServerLevel serverLevel) {
            int explosionRadius = this.getTypeVariant() == 2 ? 2 * SConfig.SERVER.explosion.get() : SConfig.SERVER.explosion.get();
            Level.ExplosionInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) && SConfig.SERVER.explosion_on.get() ?
                    Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float)explosionRadius, explosion$blockinteraction);
            if (SConfig.SERVER.scent_spawn.get()){
                this.summonScent(this.level(), this.getX(), this.getY(), this.getZ());
            }
            if (this.getTypeVariant() == 1 || this.getTypeVariant() == 3){
                explodeToxicTumor(this.getTypeVariant() == 1);
            }
            if (this.getTypeVariant() == 4){
                Utilities.convertBlocks(serverLevel,this,this.getOnPos(),7, Blocks.FIRE.defaultBlockState());
            }
            this.discard();
        }

    }


    private void summonScent(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level && SConfig.SERVER.scent_spawn.get()) {
                {
                    ScentEntity entityToSpawn = new ScentEntity(Sentities.SCENT.get(), _level);
                    entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
                    entityToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
                            null);
                    world.addFreshEntity(entityToSpawn);
                }

        }
    }


    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.3){
            return SdamageTypes.griefer_damage(this);
        }
        return super.getCustomDamage(entity);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new GrieferSwellGoal(this));
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        }); this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        super.registerGoals();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (this.getTypeVariant() == 1 && entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON ,600, 0));
        }
        if (this.getTypeVariant() == 3 && entity instanceof LivingEntity livingEntity){
            for(MobEffectInstance instance : BileLiquid.bileEffects()){
                livingEntity.addEffect(instance);
            }
        }
        return super.doHurtTarget(entity);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ARMOR, SConfig.SERVER.griefer_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.griefer_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.griefer_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.FOLLOW_RANGE, 25)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

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

    private boolean checkForNucMod(){
        return ModList.get().isLoaded("alexscaves") || ModList.get().isLoaded("bigreactors");
    }

    private GrieferVariants getSpawnVariant(){
        GrieferVariants variants = Util.getRandom(GrieferVariants.values(), this.random);
        if (variants == GrieferVariants.TOXIC || variants == GrieferVariants.RADIOACTIVE){
            if (checkForNucMod()){
                return GrieferVariants.RADIOACTIVE;
            }else{
                return GrieferVariants.TOXIC;
            }
        }
        return variants;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        setVariant(getSpawnVariant());
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public GrieferVariants getVariant() {
        return GrieferVariants.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(GrieferVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
}
