package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class UtilityEntity extends PathfinderMob {
    protected UtilityEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }
    public List<? extends String> getDropList(){
        return null;
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


    public Predicate<LivingEntity> TARGET_SELECTOR = (entity) -> {
        return Utilities.TARGET_SELECTOR.Test(entity);
    };

    protected void addTargettingGoals(){
        this.goalSelector.addGoal(2, new HurtTargetGoal(this ,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}, Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {return livingEntity instanceof Player || SConfig.SERVER.whitelist.get().contains(livingEntity.getEncodeId());}){
            @Override
            protected AABB getTargetSearchArea(double value) {
                return this.mob.getBoundingBox().inflate(value, value, value);
            }
        });
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true, livingEntity -> {return SConfig.SERVER.at_mob.get() && TARGET_SELECTOR.test(livingEntity);}){
            @Override
            protected AABB getTargetSearchArea(double value) {
                return this.mob.getBoundingBox().inflate(value, value, value);
            }
        });
    }
    @Override
    protected void dropCustomDeathLoot(DamageSource source, int val, boolean bool) {
        super.dropCustomDeathLoot(source, val, bool);
        if (getDropList() == null){return;}
        if (!getDropList().isEmpty()){
            for (String str : getDropList()){
                String[] string = str.split("\\|" );
                ItemStack itemStack = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
                int m = 1;
                if (Integer.parseUnsignedInt(string[2]) == Integer.parseUnsignedInt(string[3])){
                    m = Integer.parseUnsignedInt(string[3])+val;

                } else {if (Integer.parseUnsignedInt(string[2]) >= 1 && Integer.parseUnsignedInt(string[2]) >= 1){
                    int v1 = Integer.parseUnsignedInt(string[2]);
                    int v2 = Integer.parseUnsignedInt(string[3]);
                    float e = m * (0.15f * val);
                    int i = e > val ? (int) e : val;
                    m = random.nextInt(v1, v2+i);
                }}
                int value = Integer.parseUnsignedInt(string[1])+(val*10);
                if (Math.random() < (value / 100F)) {
                    itemStack.setCount(m);
                    ItemEntity item = new ItemEntity(level(), this.getX() , this.getY(),this.getZ(),itemStack);
                    item.setPickUpDelay(10);
                    level().addFreshEntity(item);}}
        }
    }

    protected boolean Cold(){
        BlockPos pos = new BlockPos(this.getBlockX(),this.getBlockY(),this.getBlockZ());
        Biome biome = level().getBiome(pos).value();
        return SConfig.SERVER.weaktocold.get() && biome.getBaseTemperature() <= 0.2;
    }

    public String getMutation(){
        return null;
    }
}
