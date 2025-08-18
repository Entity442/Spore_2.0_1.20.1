package com.Harbinger.Spore.Sitems.BaseWeapons;

import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public abstract class SporeBaseArmor extends ArmorItem implements SporeArmorData {
    public final EnumMap<EquipmentSlot,UUID> UUIDS =
            Util.make(Maps.newEnumMap(EquipmentSlot.class), (p_114874_) -> {
            p_114874_.put(EquipmentSlot.HEAD,UUID.fromString("bcd36ebc-8e7e-4598-b35d-de98063823f3"));
            p_114874_.put(EquipmentSlot.CHEST,UUID.fromString("8e55d62a-8302-4422-9f70-a1cb4efbb93e"));
            p_114874_.put(EquipmentSlot.LEGS,UUID.fromString("5424cab4-14d5-49c2-a4f0-b6778a728a0a"));
            p_114874_.put(EquipmentSlot.FEET,UUID.fromString("8cea5f8e-4b19-43ba-85de-91d49faf8c28"));
            });
    protected final int[] protection;
    protected final float toughness;
    protected float knockback;
    public SporeBaseArmor(Type type ,int[] durability,int[] protection,float toughness,float knockback,SoundEvent soundEvent,String name) {
        super(new ArmorMaterial() {
            @Override
            public int getDurabilityForType(Type type) {
                return durability[type.getSlot().getIndex()];
            }

            @Override
            public int getDefenseForType(Type type) {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 0;
            }

            @Override
            public SoundEvent getEquipSound() {
                return soundEvent;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Sitems.BIOMASS.get());
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public float getToughness() {
                return 0;
            }

            @Override
            public float getKnockbackResistance() {
                return 0;
            }
        }, type, new Item.Properties());
        Sitems.TINTABLE_ITEMS.add(this);
        Sitems.BIOLOGICAL_ITEMS.add(this);
        this.protection = protection;
        this.toughness = toughness;
        this.knockback = knockback;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = UUIDS.get(slot);
        builder.put(Attributes.ARMOR,new AttributeModifier(uuid,"Armor modifier",calculateTrueDefense(stack,protection[type.getSlot().getIndex()])+modifyProtection(stack,protection[type.getSlot().getIndex()]), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS,new AttributeModifier(uuid,"Armor modifier",calculateTrueToughness(stack,toughness)+modifyToughness(stack,toughness), AttributeModifier.Operation.ADDITION));
        if (this.knockback > 0.0F) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", (this.knockback + modifyKnockbackResistance(stack,knockback)) * 0.1f, AttributeModifier.Operation.ADDITION));
        }
        if (this.getVariant(stack) == SporeArmorMutations.DROWNED){
            builder.put(ForgeMod.SWIM_SPEED.get(), new AttributeModifier(uuid, "Armor Speed modifier", 0.25, AttributeModifier.Operation.ADDITION));
        }
        if (this.getVariant(stack) == SporeArmorMutations.REINFORCED || this.getVariant(stack) == SporeArmorMutations.SKELETAL){
            builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "Armor Speed modifier", this.getVariant(stack) == SporeArmorMutations.REINFORCED ? -0.01 : 0.01, AttributeModifier.Operation.ADDITION));
        }
        return slot == this.type.getSlot() && tooHurt(stack) ? builder.build() : ImmutableMultimap.of();
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        int durabilityLeft = stack.getMaxDamage() - stack.getDamageValue();
        if (durabilityLeft-amount <= 11){
            entity.playSound(Ssounds.INFECTED_GEAR_BREAK.get());
        }
        if (tooHurt(stack)){
            if (getAdditionalDurability(stack) > 0){
                hurtExtraDurability(stack,amount,entity);
                return 0;
            }else{
                return super.damageItem(stack, calculateDurabilityLost(stack,amount), entity, onBroken);
            }
        }else{
            return 0;
        }
    }


    public int calculateDurabilityLost(ItemStack stack, int value){
        if (getVariant(stack) == SporeArmorMutations.CHARRED){
            return value * 2;
        }
        return value;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        int luck = getLuck(stack);
        return luck > 0 ? luck : 1;
    }

    public double modifyProtection(ItemStack stack, double value){
        if (this.getVariant(stack) == SporeArmorMutations.REINFORCED){
            return value * 0.2f;
        }
        if (this.getVariant(stack) == SporeArmorMutations.SKELETAL){
            return value * -0.2f;
        }
        return 0;
    }
    public double modifyToughness(ItemStack stack,double value){
        if (this.getVariant(stack) == SporeArmorMutations.SKELETAL){
            return 1;
        }
        return 0;
    }
    public double modifyKnockbackResistance(ItemStack stack,double value){
        return 0;
    }
    public float calculateAdditionalDamage(DamageSource source,ItemStack stack,float value){
        if (this.getVariant(stack) == SporeArmorMutations.CHARRED && source.is(DamageTypeTags.IS_FIRE)){
            return -value * 0.25f;
        }
        if (this.getVariant(stack) == SporeArmorMutations.DROWNED && source.is(DamageTypeTags.IS_FIRE)){
            return value * 0.25f;
        }
        return 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(stack, p_41422_, components, p_41424_);
        if (!tooHurt(stack)){
            components.add(Component.translatable("spore.item.hurt").withStyle(ChatFormatting.RED));
        }
        if (Screen.hasShiftDown()){
            if (getAdditionalProtection(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.armor_increase").getString() + getAdditionalProtection(stack) + "%"));
            }if (getAdditionalToughness(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.toughness_increase").getString()+ getAdditionalToughness(stack) + "%"));
            }if (getMaxAdditionalDurability(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.durability_increase").getString()+ getMaxAdditionalDurability(stack) + "%"));
            }if (getAdditionalDurability(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.additional_durability").getString()+ getAdditionalDurability(stack)));
            }if (getEnchantmentValue(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.enchant").getString()+ getEnchantmentValue(stack)));
            }
            if (getVariant(stack) != SporeArmorMutations.DEFAULT){
                components.add(Component.literal(Component.translatable("spore.item.mutation").getString()+Component.translatable(getVariant(stack).getName()).getString()));
            }
        }

    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack itemStack, Slot slot, ClickAction clickAction, Player player, SlotAccess slotAccess) {
        if (clickAction == ClickAction.SECONDARY && itemStack.getItem().isEdible() && stack.getEnchantmentLevel(Senchantments.VORACIOUS_MAW.get()) > 0 && stack.getDamageValue() > 0){
            stack.setDamageValue(getDamage(stack)-50);
            itemStack.shrink(1);
            player.playNotifySound(SoundEvents.GENERIC_EAT, SoundSource.AMBIENT, 1f, 1f);
            return true;
        }
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
