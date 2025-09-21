package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class Mephetic extends EvolvedInfected implements RangedAttackMob {
    private List<ItemStack> potions = new ArrayList<>(){{add(ItemStack.EMPTY);add(ItemStack.EMPTY);add(ItemStack.EMPTY);}};
    public Mephetic(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_volatile_loot.get();
    }
    public void defineSynchedData() {
        super.defineSynchedData();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.vola_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.vola_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.vola_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    public List<ItemStack> getPotions(){
        return potions;
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 40 == 0){
            Potion potion = Math.random() < 0.5 ? Potions.HARMING : Potions.HEALING;
            potions.clear();
            for (int i = 0; i<3; i++){
                potions.add(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
            }
            potions.replaceAll(ignored -> PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion));
        }
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.WITCH_AMBIENT.get();
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
    public void performRangedAttack(LivingEntity livingEntity, float v) {

    }
}
