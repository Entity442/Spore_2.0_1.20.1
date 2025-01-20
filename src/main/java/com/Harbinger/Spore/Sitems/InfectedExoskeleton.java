
package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class InfectedExoskeleton extends SporeBaseArmor {
    public InfectedExoskeleton(Type type) {
        super(type, new int[]{
                SConfig.SERVER.boots_durability.get(), SConfig.SERVER.pants_durability.get(), SConfig.SERVER.chestplate_durability.get(), SConfig.SERVER.helmet_durability.get()},new int[]{
                SConfig.SERVER.boots_protection.get(), SConfig.SERVER.pants_protection.get(), SConfig.SERVER.chestplate_protection.get(), SConfig.SERVER.helmet_protection.get()
        }, SConfig.SERVER.armor_toughness.get(),SConfig.SERVER.knockback_resistance.get(), SoundEvents.ARMOR_EQUIP_LEATHER,"Infected");
    }



    public static Map<SporeArmorMutations,String> GET_LOCATION_1 =
            Util.make(Maps.newEnumMap(SporeArmorMutations.class), (p_114874_) -> {
                p_114874_.put(SporeArmorMutations.DEFAULT, "spore:textures/armor/default/infected_layer_1.png");
                p_114874_.put(SporeArmorMutations.REINFORCED, "spore:textures/armor/reinforced/infected_layer_1.png");
                p_114874_.put(SporeArmorMutations.SKELETAL, "spore:textures/armor/skeletal/infected_layer_1.png");
                p_114874_.put(SporeArmorMutations.DROWNED, "spore:textures/armor/drowned/infected_layer_1.png");
                p_114874_.put(SporeArmorMutations.CHARRED, "spore:textures/armor/charred/infected_layer_1.png");
            });
    public static Map<SporeArmorMutations,String> GET_LOCATION_2 =
            Util.make(Maps.newEnumMap(SporeArmorMutations.class), (p_114874_) -> {
                p_114874_.put(SporeArmorMutations.DEFAULT, "spore:textures/armor/default/infected_layer_2.png");
                p_114874_.put(SporeArmorMutations.REINFORCED, "spore:textures/armor/reinforced/infected_layer_2.png");
                p_114874_.put(SporeArmorMutations.SKELETAL, "spore:textures/armor/skeletal/infected_layer_2.png");
                p_114874_.put(SporeArmorMutations.DROWNED, "spore:textures/armor/drowned/infected_layer_2.png");
                p_114874_.put(SporeArmorMutations.CHARRED, "spore:textures/armor/charred/infected_layer_2.png");
            });


    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        this.geteffect(player);
        super.onArmorTick(stack, level, player);
    }

    public void geteffect(LivingEntity entity) {
        if (!entity.hasEffect(Seffects.SYMBIOSIS.get())){
            if ((entity.getItemBySlot(EquipmentSlot.FEET).getItem() == Sitems.INF_BOOTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Sitems.INF_PANTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Sitems.INF_CHEST.get())
                    && (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.INF_HELMET.get())) {
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, 0, (false), (false)));
            }
        }

    }

}
