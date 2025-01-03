package com.Harbinger.Spore.Sitems.BaseWeapons;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.extensions.IForgeItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class SporeToolsBaseItem extends BaseItem implements IForgeItem {
    public String BASE_TAG = "agent";
    public String MELEE_TAG = "mutant_damage";
    public String MELEE_DURABILITY = "mutant_durability";
    public String MAX_DURABILITY = "mutant_max_durability";
    public String ENCHANTING = "mutant_enchanting";
    public String MUTATION = "mutation";
    protected final double meleeDamage;
    protected final double meleeReach;
    protected final double meleeRecharge;
    protected final int miningLevel;
    private final UUID BONUS_DAMAGE_MODIFIER_UUID = UUID.fromString("035e66d6-5a74-402f-b64c-e61432ec39ba");
    private final UUID BONUS_REACH_MODIFIER_UUID = UUID.fromString("d8c35ba5-f440-4335-92b2-3c8b1b703706");
    private final UUID BONUS_RECHARGE_MODIFIER_UUID = UUID.fromString("6dee499d-60f9-4f91-9ae9-fa62f285cc24");
    public SporeToolsBaseItem(double meleeDamage, double meleeReach, double meleeRecharge, int durability, int miningLevel) {
        super(new Item.Properties().stacksTo(1).durability(durability));
        this.meleeDamage = meleeDamage;
        this.meleeReach = meleeReach;
        this.meleeRecharge = meleeRecharge;
        this.miningLevel = miningLevel;
        Sitems.TINTABLE_ITEMS.add(this);
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack itemStack) {
        return super.isValidRepairItem(stack, itemStack) || itemStack.getItem() == Sitems.BIOMASS.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE,new AttributeModifier(BONUS_DAMAGE_MODIFIER_UUID,"Tool modifier",calculateTrueDamage(stack)-1+modifyDamage(stack), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BONUS_RECHARGE_MODIFIER_UUID, "Tool modifier", -meleeRecharge+modifyRecharge(stack), AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_REACH_MODIFIER_UUID, "Tool modifier",meleeReach+modifyRange(stack), AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND && tooHurt(stack) ? builder.build() : ImmutableMultimap.of();
    }

    public boolean tooHurt(ItemStack stack){
        return stack.getDamageValue() < stack.getMaxDamage() - 10;
    }
    protected double calculateTrueDamage(ItemStack stack){
        double value = getAdditionalDamage(stack) * 0.01;
        if (value > 0){
            return meleeDamage + (meleeDamage * value);
        }
        return meleeDamage;
    }
    public float getDestroySpeed(ItemStack stack, BlockState blockState) {
        return this.miningLevel;
    }

    public void setAdditionalDamage(double value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(MELEE_TAG,value);
    }
    public double getAdditionalDamage(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getDouble(MELEE_TAG);
    }

    public int getMaxAdditionalDurability(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MAX_DURABILITY);
    }
    public void setMaxAdditionalDurability(int value,ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MAX_DURABILITY,value);
    }
    public int getAdditionalDurability(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MELEE_DURABILITY);
    }
    public void setAdditionalDurability(int value,ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MELEE_DURABILITY,value);
    }

    public void hurtExtraDurability(ItemStack stack,int value,@Nullable LivingEntity living){
        setAdditionalDurability(getAdditionalDurability(stack)-value,stack);
    }

    public void setLuck(int value, ItemStack stack){
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putDouble(ENCHANTING,value);
    }
    public int getLuck(ItemStack itemStack){
        CompoundTag tag = itemStack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(ENCHANTING);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        int luck = getLuck(stack);
        return luck > 0 ? luck : 1;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if (!tooHurt(stack) && entity instanceof Player player){
            player.getCooldowns().addCooldown(this,60);
        }
        return false;
    }
    public int getMaxTrueAdditionalDurability(ItemStack stack){
        return (int)(stack.getMaxDamage() * (getMaxAdditionalDurability(stack) * 0.01));
    }

    public void healTool(ItemStack stack,int value){
        if (stack.getDamageValue() < stack.getMaxDamage()){
            stack.setDamageValue(stack.getDamageValue()-value);
        }
        if (getMaxTrueAdditionalDurability(stack) > getAdditionalDurability(stack)){
            setAdditionalDurability(getAdditionalDurability(stack)+value,stack);
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity entity) {
        if (tooHurt(stack)){
            hurtTool(stack,entity,1);
        }
        doEntityHurtAfterEffects(stack,living,entity);
        return super.hurtEnemy(stack, living, entity);
    }

    public void hurtTool(ItemStack stack, LivingEntity entity,int value){
        int lostDurability = this.calculateDurabilityLostForMutations(value,stack);
        if (getAdditionalDurability(stack) > 0){
            hurtExtraDurability(stack,lostDurability,entity);
        }else{
            stack.hurtAndBreak(lostDurability, entity, (p_43296_) -> {
                p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity living) {
        if (!tooHurt(stack)){
            return false;
        }
        return super.mineBlock(stack, level, state, pos, living);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return super.isBarVisible(stack) || getAdditionalDurability(stack) > 0;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        if (getAdditionalDurability(stack) > 0){
            return Mth.hsvToRgb( 240.0F, 100.0F, 100.0F);
        }else{
            return super.getBarColor(stack);
        }
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(stack, p_41422_, components, p_41424_);
        components.add(Component.literal("Damage Increase " + getAdditionalDamage(stack) + "%"));
        components.add(Component.literal("Durability Increase "+ getMaxAdditionalDurability(stack) + "%"));
        components.add(Component.literal("Additional Durability "+ getAdditionalDurability(stack)));
        components.add(Component.literal("Enchant "+ getEnchantmentValue(stack)));
        components.add(Component.literal("Mutation "+ getVariant(stack).getName()));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.SHARPNESS, Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK , Enchantments.MOB_LOOTING , Enchantments.SMITE).contains(enchantment);
    }

    public int calculateDurabilityLostForMutations(int value ,ItemStack stack){
        if (getVariant(stack) == SporeToolsMutations.TOXIC){
            return value * 2;
        }
        if (getVariant(stack) == SporeToolsMutations.ROTTEN){
            return value * 2;
        }
        return value;
    }

    public SporeToolsMutations getVariant(ItemStack stack) {
        return SporeToolsMutations.byId(this.getTypeVariant(stack) & 255);
    }

    private int getTypeVariant(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        return tag.getInt(MUTATION);
    }

    public void setVariant(SporeToolsMutations variant,ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTagElement(BASE_TAG);
        tag.putInt(MUTATION,variant.getId() & 255);
    }

    public void doEntityHurtAfterEffects(ItemStack stack, LivingEntity victim, LivingEntity entity){
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

    public double modifyDamage(ItemStack stack){
        return getVariant(stack) == SporeToolsMutations.VAMPIRIC ? (calculateTrueDamage(stack) * -0.2) : 0;
    }
    public double modifyRange(ItemStack stack){
        return 0;
    }
    public double modifyRecharge(ItemStack stack){
        return getVariant(stack) == SporeToolsMutations.CALCIFIED ? -0.5 : 0;
    }

}
