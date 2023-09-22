package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.Models.GasMaskModel;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

public class GasMaskItem extends ArmorItem {
    public GasMaskItem() {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type p_266807_) {
                return 0;
            }

            @Override
            public int getDefenseForType(Type p_267168_) {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 0;
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ARMOR_EQUIP_IRON;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return null;
            }

            @Override
            public String getName() {
                return "Gas Mask";
            }

            @Override
            public float getToughness() {
                return 0;
            }

            @Override
            public float getKnockbackResistance() {
                return 0;
            }
        }, Type.HELMET, new Item.Properties().stacksTo(1));
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "spore:textures/armor/gas_mask.png";
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                HumanoidModel armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of("body",
                        new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_arm",
                        new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm",
                        new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "head", new GasMaskModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(GasMaskModel.LAYER_LOCATION)).GasMask, "hat",
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
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }
}
