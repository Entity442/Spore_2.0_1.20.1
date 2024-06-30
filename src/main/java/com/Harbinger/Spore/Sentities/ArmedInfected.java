package com.Harbinger.Spore.Sentities;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.ArrayList;
import java.util.List;

public interface ArmedInfected {
    default Enchantment meleeEnchants(LivingEntity living){
        List<Enchantment> values = new ArrayList<>();
        values.add(Enchantments.SHARPNESS);
        values.add(Enchantments.FIRE_ASPECT);
        values.add(Enchantments.KNOCKBACK);
        return values.get(living.getRandom().nextInt(values.size()));
    }
    default Enchantment bowEnchantments(LivingEntity living){
        List<Enchantment> values = new ArrayList<>();
        values.add(Enchantments.FLAMING_ARROWS);
        values.add(Enchantments.POWER_ARROWS);
        values.add(Enchantments.PUNCH_ARROWS);
        return values.get(living.getRandom().nextInt(values.size()));
    }
    default Enchantment crossbowEnchantments(LivingEntity living){
        List<Enchantment> values = new ArrayList<>();
        values.add(Enchantments.MULTISHOT);
        values.add(Enchantments.PIERCING);
        return values.get(living.getRandom().nextInt(values.size()));
    }
    default Enchantment armorEnchantments(LivingEntity living){
        List<Enchantment> values = new ArrayList<>();
        values.add(Enchantments.ALL_DAMAGE_PROTECTION);
        values.add(Enchantments.THORNS);
        values.add(Enchantments.UNBREAKING);
        return values.get(living.getRandom().nextInt(values.size()));
    }
    default int getRandomLevel(Enchantment enchantment,LivingEntity living){
        if (enchantment.getMaxLevel() == 1){
            return 1;
        }
        return living.getRandom().nextInt(1,enchantment.getMaxLevel());
    }
    default void EnchantBasedOnItem(ItemStack stack,LivingEntity living){
        Item item = stack.getItem();
        Enchantment melee = meleeEnchants(living);
        Enchantment bow = bowEnchantments(living);
        Enchantment crossbow = crossbowEnchantments(living);
        if (item instanceof TieredItem){
            stack.enchant(melee,getRandomLevel(melee,living));
        }
        if (item instanceof BowItem){
            stack.enchant(bow,getRandomLevel(bow,living));
        }
        if (item instanceof CrossbowItem){
            stack.enchant(crossbow,getRandomLevel(crossbow,living));
        }
    }


    default void enchantItems(LivingEntity living){
        Enchantment armor = armorEnchantments(living);
        living.getArmorSlots().forEach(item -> item.enchant(armor,getRandomLevel(armor,living)));
        EnchantBasedOnItem(living.getMainHandItem(),living);
        EnchantBasedOnItem(living.getOffhandItem(),living);
    }
}
