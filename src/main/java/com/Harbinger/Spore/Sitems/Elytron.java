package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.Models.ElytrumModel;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.ScreativeTab;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.ImmutableSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class Elytron extends ArmorItem {


    public Elytron(Type type, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type slot1) {
                return new int[]{0, 0, SConfig.SERVER.ely_durability.get(),0}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getDefenseForType(Type slot1) {
                return new int[]{0, 0, SConfig.SERVER.ely_protection.get(), 0}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 18;
            }

            @Override
            public SoundEvent getEquipSound() {
                return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }

            @Override
            public String getName() {
                return "Elytron";
            }

            @Override
            public float getToughness() {
                return SConfig.SERVER.ely_toughness.get();
            }

            @Override
            public float getKnockbackResistance() {
                return SConfig.SERVER.ely_knockback_resistance.get() /10F;
            }
        } , type,properties);
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }


    public static  class InfectedElytron extends Elytron implements CustomModelArmor{
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "spore:textures/armor/empty.png";
        }

        public InfectedElytron() {
            super(Type.CHESTPLATE, new Properties());
        }

        @Override
        public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
            return Objects.equals(Sitems.BIOMASS.get(), repairitem.getItem());
        }
        public static boolean isFlyEnabled(ItemStack p_41141_) {
            return p_41141_.getDamageValue() < p_41141_.getMaxDamage() - 1;
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

        @Override
        public EntityModel<LivingEntity> getModel() {
            return new ElytrumModel<>();
        }

        @Override
        public ResourceLocation getCustomArmorTexture() {
            return new ResourceLocation(Spore.MODID,"textures/armor/elytron.png");
        }

        @Override
        public boolean isFoil() {
            return false;
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }
}
