package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class InfectedKnife extends SporeSwordBase {
    public InfectedKnife() {
        super(SConfig.SERVER.knife_damage.get(), 1, -1, SConfig.SERVER.knife_durability.get());
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
            return (super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(enchantment1).contains(enchantment))
                    && !ImmutableSet.of(Enchantments.MOB_LOOTING).contains(enchantment);}
        }
        return (super.canApplyAtEnchantingTable(stack, enchantment)) && !ImmutableSet.of(Enchantments.MOB_LOOTING).contains(enchantment);
    }
}
