package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InfectedVendicator extends EvolvedInfected implements ArmedInfected {
    public InfectedVendicator(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_vin_loot.get();
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();
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


    protected void customServerAiStep() {
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this) && SConfig.SERVER.higher_thinking.get()) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }

        super.customServerAiStep();
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        this.populateDefaultEquipmentSlots();
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, p_21436_, p_21437_, p_21438_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.FOLLOW_RANGE, 28.0D)
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_vin_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_vin_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR,SConfig.SERVER.inf_vin_armor.get() * SConfig.SERVER.global_armor.get());
    }
    protected void populateDefaultEquipmentSlots() {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
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
