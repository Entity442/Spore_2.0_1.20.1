package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.ScreativeTab;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
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

public class InfectedMace extends Item implements Vanishable {
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;
    public InfectedMace() {
        super(new Item.Properties().durability(SConfig.SERVER.mace_durability.get()));
        UUID BONUS_REACH_MODIFIER_UUID = UUID.fromString("30a9271c-d6b2-4651-b088-800acc43f282");
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", SConfig.SERVER.mace_damage.get() - 1, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -3, AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_REACH_MODIFIER_UUID, "Tool modifier",2f, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }
    @Override
    public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
        return Objects.equals(Sitems.BIOMASS.get(), repairitem.getItem());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);

    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity livingEntity) {
        stack.hurtAndBreak(1, livingEntity, (ss) -> {
            ss.broadcastBreakEvent(EquipmentSlot.MAINHAND);});
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

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if ((double)state.getDestroySpeed(level, pos) != 0.0D) {
            stack.hurtAndBreak(2, entity, (ss) -> {
                ss.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    public int getEnchantmentValue() {
        return 2;
    }


    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.SHARPNESS, Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK , Enchantments.MOB_LOOTING , Enchantments.SMITE).contains(enchantment);
    }
}
