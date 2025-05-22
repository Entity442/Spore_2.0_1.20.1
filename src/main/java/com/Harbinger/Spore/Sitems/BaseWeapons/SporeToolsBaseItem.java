package com.Harbinger.Spore.Sitems.BaseWeapons;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseItem;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
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
import java.util.function.Consumer;

public class SporeToolsBaseItem extends BaseItem implements IForgeItem ,SporeWeaponData{
    protected final double meleeDamage;
    protected final double meleeReach;
    protected final double meleeRecharge;
    protected final int miningLevel;
    protected final UUID BONUS_DAMAGE_MODIFIER_UUID = UUID.fromString("035e66d6-5a74-402f-b64c-e61432ec39ba");
    protected final UUID BONUS_REACH_MODIFIER_UUID = UUID.fromString("d8c35ba5-f440-4335-92b2-3c8b1b703706");
    protected final UUID BONUS_RECHARGE_MODIFIER_UUID = UUID.fromString("6dee499d-60f9-4f91-9ae9-fa62f285cc24");
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
        builder.put(Attributes.ATTACK_DAMAGE,new AttributeModifier(BONUS_DAMAGE_MODIFIER_UUID,"Tool modifier",calculateTrueDamage(stack,meleeDamage)+modifyDamage(stack,meleeDamage), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BONUS_RECHARGE_MODIFIER_UUID, "Tool modifier", -meleeRecharge+modifyRecharge(stack), AttributeModifier.Operation.ADDITION));
        builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BONUS_REACH_MODIFIER_UUID, "Tool modifier",meleeReach+modifyRange(stack), AttributeModifier.Operation.ADDITION));
        return slot == EquipmentSlot.MAINHAND && tooHurt(stack) ? builder.build() : ImmutableMultimap.of();
    }

    public float getDestroySpeed(ItemStack stack, BlockState blockState) {
        return tooHurt(stack) ? this.miningLevel : 1.0F;
    }


    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        int durabilityLeft = stack.getMaxDamage() - stack.getDamageValue();
        if (durabilityLeft-amount <= 11){
            entity.playSound(Ssounds.INFECTED_GEAR_BREAK.get());
        }
        if (durabilityLeft < 10){return 0;}
        return super.damageItem(stack, amount, entity, onBroken);
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

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity entity) {
        if (tooHurt(stack)){
            hurtTool(stack,entity,1);
        }
        doEntityHurtAfterEffects(stack,living,entity);

        return super.hurtEnemy(stack, living, entity);
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
        if (!tooHurt(stack)){
            components.add(Component.translatable("spore.item.hurt").withStyle(ChatFormatting.RED));
        }
        if (Screen.hasShiftDown()){
            if (getAdditionalDamage(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.damage_increase").getString() + getAdditionalDamage(stack) + "%"));
            }if (getMaxAdditionalDurability(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.durability_increase").getString()+ getMaxAdditionalDurability(stack) + "%"));
            }if (getAdditionalDurability(stack) > 0){
                components.add(Component.literal(Component.translatable("spore.item.additional_durability").getString()+ getAdditionalDurability(stack)));
            }if (getEnchantmentValue(stack) > 1){
                components.add(Component.literal(Component.translatable("spore.item.enchant").getString()+ getEnchantmentValue(stack)));
            }
            if (getVariant(stack) != SporeToolsMutations.DEFAULT){
                components.add(Component.literal(Component.translatable("spore.item.mutation").getString()+Component.translatable(getVariant(stack).getName()).getString()));
            }
        }

    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(Enchantments.SHARPNESS, Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK , Enchantments.MOB_LOOTING , Enchantments.SMITE).contains(enchantment);
    }

}
