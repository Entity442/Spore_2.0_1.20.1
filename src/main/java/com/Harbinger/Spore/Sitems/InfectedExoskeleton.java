
package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InfectedExoskeleton extends SporeBaseArmor implements CustomModelArmorData{
    private static final ResourceLocation location = new ResourceLocation("spore:textures/armor/living_armor_set.png");
    public InfectedExoskeleton(Type type) {
        super(type, new int[]{
                SConfig.SERVER.boots_durability.get(), SConfig.SERVER.pants_durability.get(), SConfig.SERVER.chestplate_durability.get(), SConfig.SERVER.helmet_durability.get()},new int[]{
                SConfig.SERVER.boots_protection.get(), SConfig.SERVER.pants_protection.get(), SConfig.SERVER.chestplate_protection.get(), SConfig.SERVER.helmet_protection.get()
        }, SConfig.SERVER.armor_toughness.get(),SConfig.SERVER.knockback_resistance.get(), Ssounds.INFECTED_GEAR_EQUIP.get(),"Infected");
    }



    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        this.geteffect(player);
        super.onArmorTick(stack, level, player);
    }

    public void geteffect(LivingEntity entity) {
        if (!entity.hasEffect(Seffects.SYMBIOSIS.get()) && entity.tickCount % 20 == 0){
            int val = getEffectMod(entity);
            if (val != -1){
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, val, (false), (false)));
            }
        }
    }
    private int getEffectMod(LivingEntity living){
        int i = 0;
        ItemStack helmet = living.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = living.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = living.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = living.getItemBySlot(EquipmentSlot.FEET);
        if (helmet.equals(ItemStack.EMPTY) || chest.equals(ItemStack.EMPTY) || legs.equals(ItemStack.EMPTY) || feet.equals(ItemStack.EMPTY)){return -1;}
        if (helmet.getItem().equals(Sitems.INF_UP_HELMET.get())){i=i+2;}
        if (chest.getItem().equals(Sitems.INF_UP_CHESTPLATE.get())){i=i+2;}
        if (legs.getItem().equals(Sitems.INF_UP_PANTS.get())){i=i+2;}
        if (feet.getItem().equals(Sitems.INF_UP_BOOTS.get())){i=i+2;}
        if (helmet.getItem().equals(Sitems.INF_HELMET.get())){i++;}
        if (chest.getItem().equals(Sitems.INF_CHEST.get())){i++;}
        if (legs.getItem().equals(Sitems.INF_PANTS.get())){i++;}
        if (feet.getItem().equals(Sitems.INF_BOOTS.get())){i++;}
        return  i < 4 ? -1 : i > 7 ? 1 : 0;
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return location;
    }
}
