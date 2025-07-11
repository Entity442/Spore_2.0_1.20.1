
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
        if (!entity.hasEffect(Seffects.SYMBIOSIS.get())){
            if ((entity.getItemBySlot(EquipmentSlot.FEET).getItem() == Sitems.INF_BOOTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == Sitems.INF_PANTS.get())
                    && (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Sitems.INF_CHEST.get())
                    && (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.INF_HELMET.get())) {
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, 0, (false), (false)));
            }
        }

    }

    @Override
    public ResourceLocation getTextureLocation() {
        return location;
    }
}
