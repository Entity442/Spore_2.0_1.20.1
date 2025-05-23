
package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.world.item.ItemStack;

import java.util.Map;

public class PlatedExoskeleton extends SporeBaseArmor {
    public PlatedExoskeleton(Type type) {
        super(type, new int[]{
                SConfig.SERVER.boots_durability1.get(), SConfig.SERVER.pants_durability1.get(), SConfig.SERVER.chestplate_durability1.get(), SConfig.SERVER.helmet_durability1.get()},new int[]{
                SConfig.SERVER.boots_protection1.get(), SConfig.SERVER.pants_protection1.get(), SConfig.SERVER.chestplate_protection1.get(), SConfig.SERVER.helmet_protection1.get()
        }, SConfig.SERVER.armor_toughness1.get(),SConfig.SERVER.knockback_resistance1.get(), Ssounds.INFECTED_GEAR_EQUIP.get(),"Plated");
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack itemStack) {
        return super.isValidRepairItem(stack, itemStack) || itemStack.getItem() == Sitems.ARMOR_FRAGMENT.get();
    }

    public static Map<SporeArmorMutations,String> GET_LOCATION_1 =
            Util.make(Maps.newEnumMap(SporeArmorMutations.class), (p_114874_) -> {
                p_114874_.put(SporeArmorMutations.DEFAULT, "spore:textures/armor/default/plated_layer_1.png");
                p_114874_.put(SporeArmorMutations.REINFORCED, "spore:textures/armor/reinforced/plated_layer_1.png");
                p_114874_.put(SporeArmorMutations.SKELETAL, "spore:textures/armor/skeletal/plated_layer_1.png");
                p_114874_.put(SporeArmorMutations.DROWNED, "spore:textures/armor/drowned/plated_layer_1.png");
                p_114874_.put(SporeArmorMutations.CHARRED, "spore:textures/armor/charred/plated_layer_1.png");
            });
    public static Map<SporeArmorMutations,String> GET_LOCATION_2 =
            Util.make(Maps.newEnumMap(SporeArmorMutations.class), (p_114874_) -> {
                p_114874_.put(SporeArmorMutations.DEFAULT, "spore:textures/armor/default/plated_layer_2.png");
                p_114874_.put(SporeArmorMutations.REINFORCED, "spore:textures/armor/reinforced/plated_layer_2.png");
                p_114874_.put(SporeArmorMutations.SKELETAL, "spore:textures/armor/skeletal/plated_layer_2.png");
                p_114874_.put(SporeArmorMutations.DROWNED, "spore:textures/armor/drowned/plated_layer_2.png");
                p_114874_.put(SporeArmorMutations.CHARRED, "spore:textures/armor/charred/plated_layer_2.png");
            });
}
