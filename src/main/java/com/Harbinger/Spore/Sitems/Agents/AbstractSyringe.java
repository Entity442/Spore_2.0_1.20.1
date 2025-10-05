package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sitems.BaseItem2;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AbstractSyringe extends BaseItem2 {
    public AbstractSyringe() {
        super(new Item.Properties().stacksTo(16));
        Sitems.TINTABLE_ITEMS.add(this);
    }

    public abstract int getColor();

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.BOW;
    }

    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isShiftKeyDown()){
            if (level.isClientSide) {
                com.Harbinger.Spore.Client.ClientModEvents.openInjectionScreen(player);
            }
            return InteractionResultHolder.success(stack);
        }
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity living, InteractionHand hand) {
        useSyringe(stack,living);
        return super.interactLivingEntity(stack, player, living, hand);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity living, int value) {
        if ((getUseDuration(stack) - value) > 40){
            useSyringe(stack,living);
        }
        super.releaseUsing(stack, level, living, value);
    }

    public abstract void useSyringe(ItemStack stack,LivingEntity living);

    protected void addMycelium(LivingEntity living){
        living.playSound(Ssounds.SYRINGE_INJECT.get(),1F,1F);
        living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),300,0));
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, components, p_41424_);
        components.add(Component.translatable("universal_shift_rightclick").withStyle(ChatFormatting.YELLOW));
    }
}
