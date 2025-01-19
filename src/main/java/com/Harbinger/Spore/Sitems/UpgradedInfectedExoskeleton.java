package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import com.google.common.collect.Maps;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class UpgradedInfectedExoskeleton extends SporeBaseArmor {
    public UpgradedInfectedExoskeleton(Type type) {
        super(type, new int[]{0, 0, SConfig.SERVER.chestplate_up_durability.get(),0}, new int[]{0, 0, SConfig.SERVER.chestplate_up_protection.get(), 0}, SConfig.SERVER.armor_toughness.get(), SConfig.SERVER.knockback_resistance.get() /10F, SoundEvents.ARMOR_EQUIP_LEATHER, "Upgraded Living Armor");
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
                    && (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == Sitems.INF_UP_CHESTPLATE.get())
                    && (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.INF_HELMET.get())) {
                entity.addEffect(new MobEffectInstance(Seffects.SYMBIOSIS.get(), 200, 0, (false), (false)));
            }
        }
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

    public static  class InfectedUpChestplate extends UpgradedInfectedExoskeleton{
        @Override
        public @org.jetbrains.annotations.Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return GET_LOCATION_1.get(getVariant(stack));
        }

        public InfectedUpChestplate() {
            super(Type.CHESTPLATE);
        }

        public static boolean isFlyEnabled(ItemStack stack) {
            return stack.getDamageValue() < stack.getMaxDamage() - 10;
        }


        @Override
        public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
            return InfectedUpChestplate.isFlyEnabled(stack);
        }

        @Override
        public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
            if (!entity.level().isClientSide) {
                int nextFlightTick = flightTicks + 1;
                if (nextFlightTick % 10 == 0) {
                    if (nextFlightTick % 20 == 0) {
                        stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
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

        @Override
        public void onArmorTick(ItemStack stack, Level level, Player entity) {
            if (entity.horizontalCollision && entity.isCrouching()) {
                Vec3 initialVec = entity.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
                entity.setDeltaMovement(climbVec.x * 0.91D,
                        climbVec.y * 0.98D, climbVec.z * 0.91D);
            }
            super.onArmorTick(stack, level, entity);
        }
        @Override
        public void appendHoverText(ItemStack itemStack, @org.jetbrains.annotations.Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

            if (Screen.hasShiftDown()){
                components.add(Component.translatable("item.armor.shift").withStyle(ChatFormatting.DARK_RED));
            } else {
                components.add(Component.translatable("item.armor.normal").withStyle(ChatFormatting.GOLD));
            }
            super.appendHoverText(itemStack, level, components, tooltipFlag);
        }

    }

}
