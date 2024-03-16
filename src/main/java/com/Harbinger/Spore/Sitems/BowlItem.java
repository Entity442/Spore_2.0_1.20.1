package com.Harbinger.Spore.Sitems;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class BowlItem extends BaseItem{
    public BowlItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (entity instanceof Player player && !player.getAbilities().instabuild){
            player.addItem(new ItemStack(Items.BOWL));
        }
        return super.finishUsingItem(itemStack, level, entity);
    }
}
