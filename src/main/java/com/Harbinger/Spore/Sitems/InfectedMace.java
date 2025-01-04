package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.ScreativeTab;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class InfectedMace extends SporeToolsBaseItem {
    public InfectedMace() {
        super(SConfig.SERVER.mace_damage.get(), 2f, 3, SConfig.SERVER.mace_durability.get(), 1);
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity livingEntity) {
       entity.knockback(2.2F, Mth.sin(livingEntity.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(livingEntity.getYRot() * ((float) Math.PI / 180F))));
        AABB bounding = entity.getBoundingBox().inflate(2);
        List<Entity> targets = entity.level().getEntities(entity , bounding);
        for (Entity en : targets) {
            if (en instanceof LivingEntity && !(en.is(livingEntity))){
                ((LivingEntity) en).knockback(2.2F, Mth.sin(livingEntity.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(livingEntity.getYRot() * ((float) Math.PI / 180F))));
                en.hurt(livingEntity.damageSources().mobAttack(livingEntity), SConfig.SERVER.mace_damage.get());
                int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, stack);
                if (k > 0){ en.setSecondsOnFire(10 * k);}
            }
        }
        return true;
    }
}
