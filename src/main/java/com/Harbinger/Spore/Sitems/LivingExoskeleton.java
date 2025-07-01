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

public class LivingExoskeleton extends SporeBaseArmor {
    protected final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/armor/flesh_armor_set.png");
    public LivingExoskeleton(Type slot) {
        super(slot, new int[]{
                SConfig.SERVER.boots_durability2.get(), SConfig.SERVER.pants_durability2.get(), SConfig.SERVER.chestplate_durability2.get(), SConfig.SERVER.helmet_durability2.get()},new int[]{
                SConfig.SERVER.boots_protection2.get(), SConfig.SERVER.pants_protection2.get(), SConfig.SERVER.chestplate_protection2.get(), SConfig.SERVER.helmet_protection2.get()
        }, SConfig.SERVER.armor_toughness2.get(),SConfig.SERVER.knockback_resistance2.get(), Ssounds.INFECTED_GEAR_EQUIP.get(),"Flesh");
    }

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
