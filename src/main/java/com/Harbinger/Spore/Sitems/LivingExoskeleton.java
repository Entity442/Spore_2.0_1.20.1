package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class LivingExoskeleton extends SporeBaseArmor {
    public LivingExoskeleton(Type slot) {
        super(slot, new int[]{
                SConfig.SERVER.boots_durability2.get(), SConfig.SERVER.pants_durability2.get(), SConfig.SERVER.chestplate_durability2.get(), SConfig.SERVER.helmet_durability2.get()},new int[]{
                SConfig.SERVER.boots_protection2.get(), SConfig.SERVER.pants_protection2.get(), SConfig.SERVER.chestplate_protection2.get(), SConfig.SERVER.helmet_protection2.get()
        }, SConfig.SERVER.armor_toughness2.get(),SConfig.SERVER.knockback_resistance2.get(), Ssounds.INFECTED_GEAR_EQUIP.get(),"Flesh");
    }

    public static Map<SporeArmorMutations,String> GET_LOCATION_1 =
            Util.make(Maps.newEnumMap(SporeArmorMutations.class), (p_114874_) -> {
                p_114874_.put(SporeArmorMutations.DEFAULT, "spore:textures/armor/default/flesh_layer_1.png");
                p_114874_.put(SporeArmorMutations.REINFORCED, "spore:textures/armor/reinforced/flesh_layer_1.png");
                p_114874_.put(SporeArmorMutations.SKELETAL, "spore:textures/armor/skeletal/flesh_layer_1.png");
                p_114874_.put(SporeArmorMutations.DROWNED, "spore:textures/armor/drowned/flesh_layer_1.png");
                p_114874_.put(SporeArmorMutations.CHARRED, "spore:textures/armor/charred/flesh_layer_1.png");
            });
    public static Map<SporeArmorMutations,String> GET_LOCATION_2 =
            Util.make(Maps.newEnumMap(SporeArmorMutations.class), (p_114874_) -> {
                p_114874_.put(SporeArmorMutations.DEFAULT, "spore:textures/armor/default/flesh_layer_2.png");
                p_114874_.put(SporeArmorMutations.REINFORCED, "spore:textures/armor/reinforced/flesh_layer_2.png");
                p_114874_.put(SporeArmorMutations.SKELETAL, "spore:textures/armor/skeletal/flesh_layer_2.png");
                p_114874_.put(SporeArmorMutations.DROWNED, "spore:textures/armor/drowned/flesh_layer_2.png");
                p_114874_.put(SporeArmorMutations.CHARRED, "spore:textures/armor/charred/flesh_layer_2.png");
            });

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        this.geteffect(player);
        super.onArmorTick(stack, level, player);
    }

    public void geteffect(LivingEntity entity) {
        if (!entity.hasEffect(Seffects.SYMBIOSIS.get())){
            if ((entity.getItemBySlot(EquipmentSlot.FEET).getItem() == Sitems.LIVING_BOOTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Sitems.LIVING_PANTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Sitems.LIVING_CHEST.get())
                    && (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.LIVING_HELMET.get())) {
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, 0, (false), (false)));
            }
        }

    }
}
