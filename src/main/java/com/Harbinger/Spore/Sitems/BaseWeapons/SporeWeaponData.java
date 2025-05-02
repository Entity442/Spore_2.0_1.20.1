package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
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
    default void hurtTool(ItemStack stack, LivingEntity entity,int value){
        int lostDurability = this.calculateDurabilityLostForMutations(value,stack);
        if (getAdditionalDurability(stack) > 0){
            hurtExtraDurability(stack,lostDurability,entity);
        }else{
            stack.hurtAndBreak(lostDurability, entity, (p_43296_) -> {
                p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
    }
    default int calculateDurabilityLostForMutations(int value ,ItemStack stack){
        if (getVariant(stack) == SporeToolsMutations.TOXIC){
            return value * 2;
        }
        if (getVariant(stack) == SporeToolsMutations.ROTTEN){
            return value * 2;
        }
        return value;
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

    default boolean reversedKnockback(){return false;}
    default void doEntityHurtAfterEffects(ItemStack stack, LivingEntity victim, LivingEntity entity){
        if (getVariant(stack) == SporeToolsMutations.TOXIC){
            victim.addEffect(new MobEffectInstance(MobEffects.POISON,60,1));
        }
        if (getVariant(stack) == SporeToolsMutations.ROTTEN){
            victim.addEffect(new MobEffectInstance(MobEffects.WITHER,60,1));
        }
        if (getVariant(stack) == SporeToolsMutations.CALCIFIED){
            double knockback = reversedKnockback() ? Mth.sin(entity.getYRot() * ((float) Math.PI / 180F)) : -Mth.sin(entity.getYRot() * ((float) Math.PI / 180F));
            victim.knockback(1.5F, knockback, (-Mth.cos(entity.getYRot() * ((float) Math.PI / 180F))));
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

    default double modifyDamage(ItemStack stack,double value){
        return getVariant(stack) == SporeToolsMutations.VAMPIRIC ? (calculateTrueDamage(stack,value) * -0.2) : 0;
    }
    default double modifyRange(ItemStack stack){
        return 0;
    }
    default double modifyRecharge(ItemStack stack){
        return getVariant(stack) == SporeToolsMutations.CALCIFIED ? -0.5 : 0;
    }

    default int getMaxTrueAdditionalDurability(ItemStack stack){
        return (int)(stack.getMaxDamage() * (getMaxAdditionalDurability(stack) * 0.01));
    }

    default void healTool(ItemStack stack,int value){
        if (stack.getDamageValue() < stack.getMaxDamage()){
            stack.setDamageValue(stack.getDamageValue()-value);
        }
        if (getMaxTrueAdditionalDurability(stack) > getAdditionalDurability(stack)){
            setAdditionalDurability(getAdditionalDurability(stack)+value,stack);
        }
    }
}
