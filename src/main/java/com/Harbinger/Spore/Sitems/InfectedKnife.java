package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.ScreativeTab;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class InfectedKnife extends SwordItem {
    public InfectedKnife() {
        super(new Tier() {
            @Override
            public int getUses() {
                return SConfig.SERVER.knife_durability.get();
            }

            @Override
            public float getSpeed() {
                return 1;
            }

            @Override
            public float getAttackDamageBonus() {
                return SConfig.SERVER.knife_damage.get() - 4f;
            }

            @Override
            public int getLevel() {
                return 1;
            }

            @Override
            public int getEnchantmentValue() {
                return 5;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }},3, -3f, new Item.Properties());
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }

    @SubscribeEvent
    public static void drops(LootingLevelEvent event){
        if (event != null && event.getEntity() != null && event.getDamageSource() != null){
            LivingEntity player = (LivingEntity) event.getDamageSource().getDirectEntity();
            if (player != null){
            if (player.getMainHandItem().equals(new ItemStack(Sitems.KNIFE.get())) || player.getOffhandItem().equals(new ItemStack(Sitems.KNIFE.get()))){
                event.setLootingLevel(3);
              }
            }
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (ModList.get().isLoaded("farmersdelight")){
            Enchantment enchantment1 = ForgeRegistries.ENCHANTMENTS.getValue(new ResourceLocation("farmersdelight:backstabbing"));
            if (enchantment1 != null){
            return (super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(enchantment1).contains(enchantment) || Senchantments.SPORE_ENCHANTS.contains(enchantment))
                    && !ImmutableSet.of(Enchantments.MOB_LOOTING).contains(enchantment);}
        }
        return (super.canApplyAtEnchantingTable(stack, enchantment) || Senchantments.SPORE_ENCHANTS.contains(enchantment)) && !ImmutableSet.of(Enchantments.MOB_LOOTING).contains(enchantment);
    }
}
