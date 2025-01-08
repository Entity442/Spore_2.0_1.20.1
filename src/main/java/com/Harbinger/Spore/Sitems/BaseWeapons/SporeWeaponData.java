package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface SporeWeaponData {
    String BASE_TAG = "agent";
    String MELEE_TAG = "mutant_damage";
    String MELEE_DURABILITY = "mutant_durability";
    String MAX_DURABILITY = "mutant_max_durability";
    String ENCHANTING = "mutant_enchanting";
    String MUTATION = "mutation";

    default boolean tooHurt(ItemStack stack){
        return stack.getDamageValue() < stack.getMaxDamage() - 10;
    }
    default double calculateTrueDamage(ItemStack stack,double meleeDamage){
        double value = getAdditionalDamage(stack) * 0.01;
        if (value > 0){
            return meleeDamage + (meleeDamage * value);
        }
        return meleeDamage;
    }
    default void setAdditionalDamage(double value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(MELEE_TAG,value);
    }
    default double getAdditionalDamage(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getDouble(MELEE_TAG);
    }

    default int getMaxAdditionalDurability(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MAX_DURABILITY);
    }
    default void setMaxAdditionalDurability(int value,ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MAX_DURABILITY,value);
    }
    default int getAdditionalDurability(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MELEE_DURABILITY);
    }
    default void setAdditionalDurability(int value,ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MELEE_DURABILITY,value);
    }

    default void hurtExtraDurability(ItemStack stack,int value,@Nullable LivingEntity living){
        setAdditionalDurability(getAdditionalDurability(stack)-value,stack);
    }

    default void setLuck(int value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(ENCHANTING,value);
    }
    default int getLuck(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(ENCHANTING);
    }

    default SporeToolsMutations getVariant(ItemStack stack) {
        return SporeToolsMutations.byId(this.getTypeVariant(stack) & 255);
    }

    default int getTypeVariant(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MUTATION);
    }

    default void setVariant(SporeToolsMutations variant,ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MUTATION,variant.getId() & 255);
    }

    default void doEntityHurtAfterEffects(ItemStack stack, LivingEntity victim, LivingEntity entity){
        if (getVariant(stack) == SporeToolsMutations.TOXIC){
            victim.addEffect(new MobEffectInstance(MobEffects.POISON,60,1));
        }
        if (getVariant(stack) == SporeToolsMutations.ROTTEN){
            victim.addEffect(new MobEffectInstance(MobEffects.WITHER,60,1));
        }
        if (getVariant(stack) == SporeToolsMutations.CALCIFIED){
            victim.knockback(1.5F, Mth.sin(entity.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(entity.getYRot() * ((float) Math.PI / 180F))));
        }
        if (getVariant(stack) == SporeToolsMutations.VAMPIRIC && entity.getHealth() < entity.getMaxHealth()){
            entity.heal(2f);
        }
        if (getVariant(stack) == SporeToolsMutations.BEZERK && Math.random() < 0.3){
            if (Math.random() < 0.5){
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,60,0));
            } else if (Math.random() < 0.5) {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,60,0));
            }else {
                entity.addEffect(new MobEffectInstance(MobEffects.SATURATION,60,0));
            }
        }
    }
}
