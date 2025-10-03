package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Screens.InjectionRecipeMenu;
import com.Harbinger.Spore.Screens.InjectionRecipeScreen;
import com.Harbinger.Spore.Spore;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BiologicalReagent extends BaseItem {
    private final AcceptedTypes type;
    public BiologicalReagent(AcceptedTypes types) {
        super(new Item.Properties());
        type = types;
    }
    public static final TagKey<Item> ALL_TYPES = ItemTags.create(new ResourceLocation(Spore.MODID,"enchantable_items"));
    public static final TagKey<Item> WEAPON_TYPES = ItemTags.create(new ResourceLocation(Spore.MODID,"enchantable_weapon_items"));
    public static final TagKey<Item> ARMOR_TYPES_TYPES = ItemTags.create(new ResourceLocation(Spore.MODID,"enchantable_armor_items"));
    public AcceptedTypes getType(){return type;}
    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    public static List<Enchantment> curses(){
        List<Enchantment> enchantments = new ArrayList<>();
        enchantments.add(Senchantments.UNWAVERING_NATURE.get());
        enchantments.add(Senchantments.MUTAGENIC_REACTANT.get());
        return enchantments;
    }

    public Enchantment getAppliedEnchantment(){
        return null;
    }

    public boolean testSlotCompat(ItemStack stack){
        if (type == AcceptedTypes.ALL_TYPES){
            return stack.is(ALL_TYPES);
        }else if (type == AcceptedTypes.WEAPON_TYPES){
            return stack.is(WEAPON_TYPES);
        }else if (type == AcceptedTypes.ARMOR_TYPES){
            return stack.is(ARMOR_TYPES_TYPES);
        }
        return false;
    }

    private double chance(){
        return 0.2;
    }



    @Override
    public boolean overrideStackedOnOther(ItemStack itemStack, Slot slot, ClickAction clickAction, Player player) {
        ItemStack stack = slot.getItem();
        if (testSlotCompat(stack)  && EnchantmentHelper.getTagEnchantmentLevel(this.getAppliedEnchantment(),stack) == 0){
            if (getAppliedEnchantment() != null && clickAction == ClickAction.SECONDARY){
                player.playNotifySound(Ssounds.REAGENT.get(), SoundSource.AMBIENT,1F,1F);
                stack.enchant(getAppliedEnchantment(),getAppliedEnchantment().getMaxLevel());
                itemStack.setCount(itemStack.getCount() -1);
                if (Math.random() < chance()){
                    Enchantment curse = curses().get(player.getRandom().nextInt(curses().size()));
                    if (stack.getEnchantmentLevel(curse) == 0)
                        stack.enchant(curse,curse.getMaxLevel());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable(type.getId()).withStyle(ChatFormatting.GOLD));
        list.add(Component.translatable("item.reagent.line1"));
        list.add(Component.translatable(getAppliedEnchantment().getDescriptionId()));
        list.add(Component.translatable("item.reagent.line2").withStyle(ChatFormatting.BLACK));
        list.add(Component.translatable("universal_shift_rightclick"));
    }

    public enum AcceptedTypes{
        ALL_TYPES("spore.name.reagent_type1"),
        WEAPON_TYPES("spore.name.reagent_type2"),
        ARMOR_TYPES("spore.name.reagent_type3");
        private final String id;
        AcceptedTypes(String ids){
            id = ids;
        }
        public String getId(){
            return id;
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (player.isShiftKeyDown() && level.isClientSide){
            InjectionRecipeMenu menu1 = new InjectionRecipeMenu(1, player.getInventory());
            Minecraft.getInstance().setScreen(new InjectionRecipeScreen(menu1, player.getInventory(),
                    Component.literal("")));
        }
        ItemStack stack = player.getItemInHand(hand);
        return InteractionResultHolder.success(stack);
    }
}
