package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;

public class PlatedExoskeleton extends ArmorItem {
    public PlatedExoskeleton(Type slot, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type slot1) {
                return new int[]{SConfig.SERVER.boots_durability1.get(), SConfig.SERVER.pants_durability1.get(), SConfig.SERVER.chestplate_durability1.get(), SConfig.SERVER.helmet_durability1.get()}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getDefenseForType(Type slot1) {
                return new int[]{SConfig.SERVER.boots_protection1.get(), SConfig.SERVER.pants_protection1.get(), SConfig.SERVER.chestplate_protection1.get(), SConfig.SERVER.helmet_protection1.get()}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 18;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ARMOR_EQUIP_LEATHER;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.ARMOR_FRAGMENT.get());
            }

            @Override
            public String getName() {
                return "Plated";
            }

            @Override
            public float getToughness() {
                return SConfig.SERVER.armor_toughness1.get();
            }

            @Override
            public float getKnockbackResistance() {
                return SConfig.SERVER.knockback_resistance1.get() / 10F;
            }
        } , slot,properties);
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || Senchantments.SPORE_ENCHANTS.contains(enchantment);
    }
}
