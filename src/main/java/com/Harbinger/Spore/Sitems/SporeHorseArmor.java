package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public abstract class SporeHorseArmor extends HorseArmorItem implements SporeArmorData {
    public final UUID HORSE_ARMOR_UUID = UUID.fromString("5c00d05d-5002-42e9-96f1-d758c065075f");
    private final int protection;

    public SporeHorseArmor(int armorValue) {
        super(0,new ResourceLocation("spore:textures/entity/empty.png"), new Properties().stacksTo(1));
        protection = armorValue;
        Sitems.TINTABLE_ITEMS.add(this);
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        double baseArmor = calculateTrueDefense(stack, protection) + modifyProtection(stack, protection);
        double baseToughness = calculateTrueToughness(stack, 0) + modifyToughness(stack, 0);
        builder.put(Attributes.ARMOR,new AttributeModifier(HORSE_ARMOR_UUID,"Armor modifier",baseArmor, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS,new AttributeModifier(HORSE_ARMOR_UUID,"Armor modifier",baseToughness, AttributeModifier.Operation.ADDITION));
        if (this.getVariant(stack) == SporeArmorMutations.DROWNED){
            builder.put(ForgeMod.SWIM_SPEED.get(), new AttributeModifier(HORSE_ARMOR_UUID, "Armor Speed modifier", 0.25, AttributeModifier.Operation.ADDITION));
        }
        if (this.getVariant(stack) == SporeArmorMutations.REINFORCED || this.getVariant(stack) == SporeArmorMutations.SKELETAL){
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(HORSE_ARMOR_UUID, "Armor Speed modifier", this.getVariant(stack) == SporeArmorMutations.REINFORCED ? -0.01 : 0.01, AttributeModifier.Operation.ADDITION));
        }
        return slot == EquipmentSlot.CHEST ? builder.build() : ImmutableMultimap.of();
    }


    public double modifyProtection(ItemStack stack, double value) {
        if (this.getVariant(stack) == SporeArmorMutations.REINFORCED) {
            return value * 0.2f;
        }
        if (this.getVariant(stack) == SporeArmorMutations.SKELETAL) {
            return value * -0.2f;
        }
        return 0;
    }

    public double modifyToughness(ItemStack stack, double value) {
        if (this.getVariant(stack) == SporeArmorMutations.SKELETAL) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack itemStack, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess) {
        boolean shouldOverride = clickAction == ClickAction.SECONDARY
                && itemStack.getItem() == Sitems.SYRINGE.get()
                && getVariant(stack) != SporeArmorMutations.DEFAULT;
        if (shouldOverride) {
            this.setVariant(SporeArmorMutations.DEFAULT, stack);
            itemStack.shrink(1);
            player.playNotifySound(Ssounds.SYRINGE_SUCK.get(), SoundSource.AMBIENT, 1f, 1f);
        }

        return shouldOverride;
    }
}
