package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public class InfectedGreatSword extends SporeSwordBase {
    private final UUID BONUS_ARMOR_MODIFIER_UUID = UUID.fromString("6d8794d2-25bc-41ad-8da7-1d2ce0818d75");
    private final UUID BONUS_TOUGHNESS_MODIFIER_UUID = UUID.fromString("69df05bf-4f50-47eb-9108-a55dc2673144");
    public InfectedGreatSword() {
        super(SConfig.SERVER.greatsword_damage.get(), 2.5f, 3F, SConfig.SERVER.greatsword_durability.get());
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR,new AttributeModifier(BONUS_ARMOR_MODIFIER_UUID,"Tool modifier",SConfig.SERVER.greatsword_armor.get(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS,new AttributeModifier(BONUS_TOUGHNESS_MODIFIER_UUID,"Tool modifier",SConfig.SERVER.greatsword_toughness.get(), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_DAMAGE,new AttributeModifier(BONUS_DAMAGE_MODIFIER_UUID,"Tool modifier",calculateTrueDamage(stack,meleeDamage)+modifyDamage(stack,meleeDamage), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BONUS_RECHARGE_MODIFIER_UUID, "Tool modifier", -meleeRecharge+modifyRecharge(stack), AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_REACH_MODIFIER_UUID, "Tool modifier",meleeReach+modifyRange(stack), AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND && tooHurt(stack) ? builder.build() : ImmutableMultimap.of();
    }
}
