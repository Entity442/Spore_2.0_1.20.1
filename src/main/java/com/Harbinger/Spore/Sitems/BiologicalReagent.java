package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Spore;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BiologicalReagent extends BaseItem {
    public BiologicalReagent(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    public List<Enchantment> curses(){
        List<Enchantment> enchantments = new ArrayList<>();
        enchantments.add(Senchantments.UNWAVERING_NATURE.get());
        return enchantments;
    }

    public Enchantment getAppliedEnchantment(){
        return null;
    }

    public boolean testSlotCompat(ItemStack stack){
        return stack.is(ItemTags.create(new ResourceLocation(Spore.MODID,"enchantable_items")));
    }

    private double chance(){
        return 0.2;
    }



    @Override
    public boolean overrideStackedOnOther(ItemStack itemStack, Slot slot, ClickAction clickAction, Player player) {
        ItemStack stack = slot.getItem();
        if (testSlotCompat(stack)  && EnchantmentHelper.getTagEnchantmentLevel(this.getAppliedEnchantment(),stack) == 0){
            if (getAppliedEnchantment() != null && clickAction == ClickAction.SECONDARY){
                stack.enchant(getAppliedEnchantment(),getAppliedEnchantment().getMaxLevel());
                itemStack.setCount(itemStack.getCount() -1);
                if (Math.random() < chance()){
                    Enchantment curse = curses().get(player.getRandom().nextInt(curses().size()));
                    stack.enchant(curse,curse.getMaxLevel());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.reagent.line1"));
        list.add(Component.translatable(getAppliedEnchantment().getDescriptionId()));
        list.add(Component.translatable("item.reagent.line2").withStyle(ChatFormatting.DARK_RED));
        for (Enchantment enchantment : curses()){
            list.add(Component.translatable(enchantment.getDescriptionId()).withStyle(ChatFormatting.DARK_RED));
        }
    }
}
