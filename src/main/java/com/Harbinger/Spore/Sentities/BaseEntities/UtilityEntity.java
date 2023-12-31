package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public class UtilityEntity extends PathfinderMob {
    protected UtilityEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }


    @Override
    public boolean doHurtTarget(Entity entity) {
        float f = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float f1 = (float) this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
        if (entity instanceof LivingEntity) {
            f += EnchantmentHelper.getDamageBonus(this.getMainHandItem(), ((LivingEntity) entity).getMobType());
            f1 += (float) EnchantmentHelper.getKnockbackBonus(this);
        }

        int i = EnchantmentHelper.getFireAspect(this);
        if (i > 0) {
            entity.setSecondsOnFire(i * 4);
        }

        boolean flag = entity.hurt(getCustomDamage(this), f);
        if (flag) {
            if (f1 > 0.0F && entity instanceof LivingEntity livingEntity) {
                livingEntity.knockback((double) (f1 * 0.5F), (double) Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), (double) (-Mth.cos(this.getYRot() * ((float) Math.PI / 180F))));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6D, 1.0D, 0.6D));
            }

            this.doEnchantDamageEffects(this, entity);
            this.setLastHurtMob(entity);
        }
        if (entity instanceof Player player) {
            this.maybeDisableShield(player, this.getMainHandItem(), player.isUsingItem() ? player.getUseItem() : ItemStack.EMPTY);
        }
        return flag;
    }

    public void maybeDisableShield(Player p_21425_, ItemStack p_21426_, ItemStack p_21427_) {
        if (!p_21426_.isEmpty() && !p_21427_.isEmpty() && p_21426_.getItem() instanceof AxeItem && p_21427_.is(Items.SHIELD)) {
            float f = 0.25F + (float)EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
            if (this.random.nextFloat() < f) {
                p_21425_.getCooldowns().addCooldown(Items.SHIELD, 100);
                this.level().broadcastEntityEvent(p_21425_, (byte)30);
            }
        }

    }
    public DamageSource getCustomDamage(LivingEntity entity){
        return this.damageSources().mobAttack(this);
    }

    protected void addTargettingGoals(){
        this.goalSelector.addGoal(2, new HurtTargetGoal(this , entity -> {return !SConfig.SERVER.blacklist.get().contains(entity.getEncodeId()) || entity instanceof UtilityEntity || entity instanceof Infected;}, Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, Player.class,  true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return (SConfig.SERVER.whitelist.get().contains(en.getEncodeId()) || en.hasEffect(Seffects.MARKER.get())) && !(en instanceof Infected || en instanceof UtilityEntity);
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return !(this.otherWorld(en) || this.SkulkLove(en) || this.likedFellows(en)) && SConfig.SERVER.at_mob.get();
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Animal.class, 5, false, true, (en) -> {
            return !SConfig.SERVER.blacklist.get().contains(en.getEncodeId()) && SConfig.SERVER.at_an.get();
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return !this.likedFellows(en) && SConfig.SERVER.at_mob.get() && ((this.otherWorld(en) && SConfig.SERVER.faw_target.get())
                    || (this.SkulkLove(en) && SConfig.SERVER.skulk_target.get()));
        }));
    }

    public boolean otherWorld(Entity entity){
        return entity.getType().is(TagKey.create(Registries.ENTITY_TYPE,
                new ResourceLocation("fromanotherworld:things")));
    }

    public boolean SkulkLove(Entity entity){
        return entity.getType().is(TagKey.create(Registries.ENTITY_TYPE,
                new ResourceLocation("sculkhorde:sculk_entity")));
    }

    public boolean likedFellows(Entity en){
        return en instanceof Animal || en instanceof AbstractFish || en instanceof Infected || en instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(en.getEncodeId());
    }

    protected boolean Cold(){
        BlockPos pos = new BlockPos(this.getBlockX(),this.getBlockY(),this.getBlockZ());
        Biome biome = level().getBiome(pos).value();
        return SConfig.SERVER.weaktocold.get() && biome.getBaseTemperature() <= 0.2;
    }
}
