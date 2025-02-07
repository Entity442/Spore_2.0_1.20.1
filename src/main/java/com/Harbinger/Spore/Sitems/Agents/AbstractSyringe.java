package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseItem2;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

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
        useSyringe(stack,living);
        super.releaseUsing(stack, level, living, value);
    }

    abstract void useSyringe(ItemStack stack,LivingEntity living);

    protected void addMycelium(LivingEntity living){
        living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),300,0));
    }
}
