package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class InfectedPlayer extends Infected {

    public InfectedPlayer(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }


    @Override
    protected void customServerAiStep() {
        this.setSprinting(isAggressive());
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this)) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }
        super.customServerAiStep();
    }

    @Override
    protected void registerGoals() {


        this.goalSelector.addGoal(1, new LeapAtTargetGoal(this,0.3F));
        this.goalSelector.addGoal(2, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true) {
            @Override
            public void start() {
                this.mob.swing(InteractionHand.MAIN_HAND);
                super.start();
            }
        });
        super.registerGoals();
    }

    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        return super.getCustomDamage(entity);
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        RandomSource randomsource = p_33282_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_33283_);
        this.populateDefaultEquipmentEnchantments(randomsource, p_33283_);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }
    



    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        ItemStack helmetG = ItemStack.EMPTY;
        ItemStack chestG = ItemStack.EMPTY;
        ItemStack legsG = ItemStack.EMPTY;
        ItemStack bootG = ItemStack.EMPTY;
        ItemStack mainG = ItemStack.EMPTY;
        ItemStack offG = ItemStack.EMPTY;
        List<? extends String> name = SConfig.DATAGEN.name.get();
        Random rand = new Random();
        if (this.getCustomName() == null){
        for (int i = 0; i < 1; ++i) {
            int randomIndex = rand.nextInt(name.size());
            Component component = Component.nullToEmpty(name.get(randomIndex));
            this.setCustomName(component);
           }
        }



        for (String str : SConfig.DATAGEN.player_h.get()){
            String[] string = str.split("\\|" );
            ItemStack helmet = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                helmetG = helmet;
            }
        }
        for (String str : SConfig.DATAGEN.player_c.get()){
            String[] string = str.split("\\|" );
            ItemStack chest = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                chestG = chest;
            }
        }
        for (String str : SConfig.DATAGEN.player_l.get()){
            String[] string = str.split("\\|" );
            ItemStack legs = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                legsG = legs;
            }
        }
        for (String str : SConfig.DATAGEN.player_b.get()){
            String[] string = str.split("\\|" );
            ItemStack boot = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                bootG = boot;
            }
        }
        for (String str : SConfig.DATAGEN.player_hm.get()){
            String[] string = str.split("\\|" );
            ItemStack main = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                mainG = main;
            }
        }
        for (String str : SConfig.DATAGEN.player_ho.get()){
            String[] string = str.split("\\|" );
            ItemStack off = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            if (Math.random() < Integer.parseUnsignedInt(string[1]) / 100F) {
                offG = off;
            }
        }
        
        this.setItemSlot(EquipmentSlot.MAINHAND, mainG);
        this.setItemSlot(EquipmentSlot.OFFHAND, offG);
        this.setItemSlot(EquipmentSlot.HEAD, helmetG);
        this.setItemSlot(EquipmentSlot.CHEST, chestG);
        this.setItemSlot(EquipmentSlot.LEGS, legsG);
        this.setItemSlot(EquipmentSlot.FEET, bootG);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.player_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.player_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.player_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 0.2);

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
}
