package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.InfVillagerSkins;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfectedVillager extends Infected implements EvolvingInfected , VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(InfectedVillager.class, EntityDataSerializers.INT);
    public InfectedVillager(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    @Override
    protected void registerGoals() {


        this.goalSelector.addGoal(1, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true) {
            @Override
            public boolean canUse() {
                return super.canUse() && SConfig.SERVER.higher_thinking.get();
            }
            @Override
            public void start() {
                this.mob.swing(InteractionHand.MAIN_HAND);
                super.start();
            }
        });
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_villager_loot.get();
    }
    protected void customServerAiStep() {
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this) && SConfig.SERVER.higher_thinking.get()) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }

        super.customServerAiStep();
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
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
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_vil_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_vil_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_vil_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3);

    }
    @Override
    public void baseTick() {
        super.baseTick();
        tickEvolution(this,SConfig.SERVER.villager_ev.get(), ScamperVariants.VILLAGER);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_VILLAGER_AMBIENT.get();
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

    @Override
    public String origin() {
        return "minecraft:villager";
    }

    private void setVariant(InfVillagerSkins variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    public InfVillagerSkins getVariant() {
        return InfVillagerSkins.byId(this.getTypeVariant() & 255);
    }
    @Override
    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > InfVillagerSkins.values().length || i < 0 ? 0 : i);
    }

    @Override
    public int amountOfMutations() {
        return InfVillagerSkins.values().length;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        Holder<Biome> biome = serverLevelAccessor.getBiome(this.getOnPos());
        if (biome.is(Tags.Biomes.IS_DESERT)){
            setVariant(InfVillagerSkins.DESERT);
        }
        if (biome.is(Biomes.JUNGLE) || biome.is(Biomes.BAMBOO_JUNGLE)){
            setVariant(InfVillagerSkins.JUNGLE);
        }
        if (biome.is(Biomes.SAVANNA) || biome.is(Biomes.SAVANNA_PLATEAU)){
            setVariant(InfVillagerSkins.SAVANNA);
        }
        if (biome.is(Tags.Biomes.IS_SWAMP)){
            setVariant(InfVillagerSkins.SWAMP);
        }
        if (biome.is(Tags.Biomes.IS_CONIFEROUS)){
            setVariant(InfVillagerSkins.TAIGA);
        }
        if (biome.is(Tags.Biomes.IS_SNOWY)){
            setVariant(InfVillagerSkins.TUNDRA);
        }
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, p_21436_, p_21437_, p_21438_);
    }
}
