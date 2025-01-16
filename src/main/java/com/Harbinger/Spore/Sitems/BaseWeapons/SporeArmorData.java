package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

public interface SporeArmorData {
    String BASE_TAG = "agent";
    String PROTECTION_TAG = "mutant_protection";
    String TOUGHNESS_TAG = "mutant_toughness";
    String ENCHANTING = "mutant_enchanting";
    String MUTATION = "mutation";

    default boolean tooHurt(ItemStack stack){
        return stack.getDamageValue() < stack.getMaxDamage() - 10;
    }

    default double calculateTrueDefense(ItemStack stack,double defense){
        double value = getAdditionalProtection(stack) * 0.01;
        if (value > 0){
            return defense + (defense * value);
        }
        return defense;
    }
    default void setAdditionalProtection(double value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(PROTECTION_TAG,value);
    }
    default double getAdditionalProtection(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getDouble(PROTECTION_TAG);
    }
    default double calculateTrueToughness(ItemStack stack,double defense){
        double value = getAdditionalProtection(stack) * 0.01;
        if (value > 0){
            return defense + (defense * value);
        }
        return defense;
    }
    default void setAdditionalToughness(double value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(TOUGHNESS_TAG,value);
    }
    default double getAdditionalToughness(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getDouble(TOUGHNESS_TAG);
    }

    default void setLuck(int value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(ENCHANTING,value);
    }
    default int getLuck(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(ENCHANTING);
    }

    default SporeArmorMutations getVariant(ItemStack stack) {
        return SporeArmorMutations.byId(this.getTypeVariant(stack) & 255);
    }

    default int getTypeVariant(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MUTATION);
    }

    default void setVariant(SporeArmorMutations variant,ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MUTATION,variant.getId() & 255);
    }
}
