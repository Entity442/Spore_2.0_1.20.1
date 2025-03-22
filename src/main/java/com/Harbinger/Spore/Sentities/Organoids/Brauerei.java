package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Spotion;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.BraureiVariants;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Brauerei extends Organoid implements RangedAttackMob, VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Busser.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Brauerei.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(Brauerei.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<ParticleOptions> DATA_PARTICLE = SynchedEntityData.defineId(Brauerei.class, EntityDataSerializers.PARTICLE);

    @Nullable
    private MobEffect effect;

    public Brauerei(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    public int getEmerge_tick() {
        return 200;
    }

    @Override
    public int getBorrow_tick() {
        return 200;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("timer",entityData.get(TIMER));
        tag.putInt("color",entityData.get(COLOR));
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(COLOR, tag.getInt("color"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIMER,0);
        this.entityData.define(COLOR,0);
        this.getEntityData().define(DATA_PARTICLE, ParticleTypes.ENTITY_EFFECT);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public MobEffect getEffect() {
        return this.effect;
    }
    public void  setEffect(MobEffect effect){
        this.entityData.set(COLOR,effect.getColor());
        this.effect = effect;
    }

    public int getTimer(){
        return entityData.get(TIMER);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide){
            if (this.tickCount % 20 == 0){
                if (this.getTarget() == null && this.entityData.get(TIMER) < 300){
                    this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
                }else if (this.entityData.get(TIMER) >= 300){
                    tickBurrowing();
                }
            }
        }
        if (this.tickCount % 300 == 0){
            if (this.getVariant() == BraureiVariants.HAZARD){
                this.setEffect(debuff_List().get(this.random.nextInt(debuff_List().size())));
            }else{
                this.setEffect(testList().get(this.random.nextInt(testList().size())));
            }

            if (this.getEffect() != null) {
                if (this.getVariant() == BraureiVariants.HAZARD){
                    spreadDeBuffs(this,this.getEffect());
                }else{
                    spreadBuffs(this, this.getEffect());
                }
            }
        }
        if (this.entityData.get(COLOR) != 0){
            ParticleOptions particleoptions = this.entityData.get(DATA_PARTICLE);
            if (particleoptions.getType() == ParticleTypes.ENTITY_EFFECT) {
                int k = this.getColor();
                double d5 = (float)(k >> 16 & 255) / 255.0F;
                double d6 = (float)(k >> 8 & 255) / 255.0F;
                double d7 = (float)(k & 255) / 255.0F;
                for (int i = 0;i < 4; i++)
                    this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), d5, d6, d7);
            }
        }
    }

    @Override
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > this.getBorrow_tick()) {
            this.discard();
            burrowing = -1;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }

    private List<MobEffect> testList(){
        List<MobEffect> contents = new ArrayList<>();
        for (String str : SConfig.SERVER.braurei_buffs.get()){
            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(str));
            if (effect != null){contents.add(effect);}
        }
        if (contents.isEmpty()){
            contents.add(MobEffects.REGENERATION);
        }
        return contents;
    }
    private List<MobEffect> debuff_List(){
        List<MobEffect> contents = new ArrayList<>();
        for (String str : SConfig.SERVER.braurei_debuffs.get()){
            MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(str));
            if (effect != null){contents.add(effect);}
        }
        if (contents.isEmpty()){
            contents.add(Seffects.MYCELIUM.get());
        }
        return contents;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.braurei_loot.get();
    }

    protected void spreadBuffs(LivingEntity entity, MobEffect effect){
        AABB aabb = entity.getBoundingBox().inflate(32);
        List<Entity> entities = entity.level().getEntities(entity,aabb,living ->{return living instanceof Infected || living instanceof UtilityEntity;});
        for (Entity testEntity : entities){
            if (testEntity instanceof LivingEntity living){
                int level = entity.level().getDifficulty() == Difficulty.HARD ? 1 : 0;
                living.addEffect(new MobEffectInstance(effect,600,level));
            }
        }
    }
    protected void spreadDeBuffs(LivingEntity entity, MobEffect effect){
        AABB aabb = entity.getBoundingBox().inflate(32);
        List<Entity> entities = entity.level().getEntities(entity,aabb,living ->{return living instanceof LivingEntity livingEntity && TARGET_SELECTOR.test(livingEntity);});
        for (Entity testEntity : entities){
            if (testEntity instanceof LivingEntity living){
                int level = entity.level().getDifficulty() == Difficulty.HARD ? 1 : 0;
                living.addEffect(new MobEffectInstance(effect,600,level));
            }
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.braurei_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.braurei_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    public int getColor(){
        return this.entityData.get(COLOR);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(3,new ScatterShotRangedGoal(this,0,80,20,1,3));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        super.registerGoals();
    }
    private List<Potion> getPotion(){
        List<Potion> values = new ArrayList<>();
        values.add(Spotion.MARKER_POTION.get());
        values.add(Spotion.MYCELIUM_POTION.get());
        values.add(Spotion.CORROSION_POTION_STRONG.get());
        values.add(Potions.WEAKNESS);
        values.add(Potions.STRONG_POISON);
        return values;
    }
    @Override
    public boolean hurt(DamageSource source, float value) {
        if (this.isEmerging()){
            return false;
        }
        return super.hurt(source, value);
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float p_33318_) {
        Vec3 vec3 = entity.getDeltaMovement();
        double d0 = entity.getX() + vec3.x - this.getX();
        double d1 = entity.getEyeY() - (double)1.1F - this.getY();
        double d2 = entity.getZ() + vec3.z - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        ThrownPotion thrownpotion = new ThrownPotion(this.level(), this);
        thrownpotion.setItem(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), getPotion().get(this.random.nextInt(getPotion().size()))));
        thrownpotion.setXRot(thrownpotion.getXRot() - -20.0F);
        thrownpotion.shoot(d0, d1 + d3 * 0.2D, d2, 0.75F, 8.0F);
        if (!this.isSilent()) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.WITCH_THROW, this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
        }
        this.level().addFreshEntity(thrownpotion);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.BRAUREI_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    public BraureiVariants getVariant() {
        return BraureiVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        if (i > BraureiVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return BraureiVariants.values().length;
    }

    private void setVariant(BraureiVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @javax.annotation.Nullable SpawnGroupData p_146749_,
                                        @javax.annotation.Nullable CompoundTag p_146750_) {
        BraureiVariants variant = Util.getRandom(BraureiVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }
}
