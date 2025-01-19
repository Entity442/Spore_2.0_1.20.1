package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Objects;

public class Elytron extends SporeBaseArmor {
    public Elytron(Type type) {
        super(type, new int[]{0, 0, SConfig.SERVER.ely_durability.get(),0},new int[]{0, 0, SConfig.SERVER.ely_protection.get(), 0}, SConfig.SERVER.ely_toughness.get(), SConfig.SERVER.ely_knockback_resistance.get() /10F, SoundEvents.ARMOR_EQUIP_LEATHER, "Elytron");
    }


    public static  class InfectedElytron extends Elytron{
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "spore:textures/armor/empty.png";
        }
        public InfectedElytron() {
            super(Type.CHESTPLATE);
        }

        @Override
        public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
            return Objects.equals(Sitems.BIOMASS.get(), repairitem.getItem());
        }
        public static boolean isFlyEnabled(ItemStack stack) {
            return stack.getDamageValue() < stack.getMaxDamage() - 10;
        }


        @Override
        public boolean canElytraFly(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
            return InfectedElytron.isFlyEnabled(stack);
        }

        @Override
        public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
            if (!entity.level().isClientSide) {
                int nextFlightTick = flightTicks + 1;
                if (nextFlightTick % 10 == 0) {
                    if (nextFlightTick % 20 == 0) {
                        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
                        if (entity instanceof Player player){
                            player.causeFoodExhaustion(0.1F);
                        }
                    }
                    entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
                }
            }
            return true;
        }


        public int getEnchantmentValue() {
            return 2;
        }

        @Nullable
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_ELYTRA;
        }

    }
}
