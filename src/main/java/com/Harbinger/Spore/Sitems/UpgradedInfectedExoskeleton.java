package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.Models.WingedChestplate;
import com.Harbinger.Spore.Core.*;
import com.google.common.collect.ImmutableSet;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class UpgradedInfectedExoskeleton extends ArmorItem {


    public UpgradedInfectedExoskeleton(Type slot, Properties properties) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type slot1) {
                return new int[]{0, 0, SConfig.SERVER.chestplate_up_durability.get(),0}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getDefenseForType(Type slot1) {
                return new int[]{0, 0, SConfig.SERVER.chestplate_up_protection.get(), 0}
                        [slot1.getSlot().getIndex()];
            }

            @Override
            public int getEnchantmentValue() {
                return 18;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ARMOR_EQUIP_LEATHER;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }

            @Override
            public String getName() {
                return "Upgraded Living Armor";
            }

            @Override
            public float getToughness() {
                return SConfig.SERVER.armor_toughness.get();
            }

            @Override
            public float getKnockbackResistance() {
                return SConfig.SERVER.knockback_resistance.get() /10F;
            }
        } , slot,properties);
        Sitems.BIOLOGICAL_ITEMS.add(this);
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

    public static  class InfectedUpChestplate extends UpgradedInfectedExoskeleton {
        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "spore:textures/armor/infected_wing.png";
        }

        public InfectedUpChestplate() {
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
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(new IClientItemExtensions() {
                @Override
                @OnlyIn(Dist.CLIENT)
                public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                    HumanoidModel armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of("body",
                            new WingedChestplate<>(Minecraft.getInstance().getEntityModels().bakeLayer(WingedChestplate.LAYER_LOCATION)).body,
                            "left_arm",
                            new WingedChestplate<>(Minecraft.getInstance().getEntityModels().bakeLayer(WingedChestplate.LAYER_LOCATION)).left_arm,
                            "right_arm",
                            new WingedChestplate<>(Minecraft.getInstance().getEntityModels().bakeLayer(WingedChestplate.LAYER_LOCATION)).right_arm,
                            "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
                            new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg",
                            new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
                            new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                    armorModel.crouching = living.isShiftKeyDown();
                    armorModel.riding = defaultModel.riding;
                    armorModel.young = living.isBaby();
                    return armorModel;
                }
            });
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

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }
}
