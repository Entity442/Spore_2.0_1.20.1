package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class Innards extends BaseItem {
    public Innards(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        RandomSource random = RandomSource.create();
        for (String str : SConfig.DATAGEN.innards_loot.get()){
            String[] string = str.split("\\|" );
            ItemStack itemStack = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
            int m = 1;
            if (Integer.parseUnsignedInt(string[2]) == Integer.parseUnsignedInt(string[3])){
                m = Integer.parseUnsignedInt(string[3]);

            } else {if (Integer.parseUnsignedInt(string[2]) >= 1 && Integer.parseUnsignedInt(string[2]) >= 1){
                m = random.nextInt(Integer.parseUnsignedInt(string[2]), Integer.parseUnsignedInt(string[3]));}}

            if (Math.random() < (Integer.parseUnsignedInt(string[1]) / 100F)) {
                itemStack.setCount(m);
                ItemEntity item = new ItemEntity(level, player.getX() , player.getY(),player.getZ(),itemStack);
                item.setPickUpDelay(10);
                level.addFreshEntity(item);}}
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.consume(itemstack);
    }
}
