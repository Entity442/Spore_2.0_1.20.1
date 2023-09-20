package com.Harbinger.Spore.Effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class Uneasy extends MobEffect {
    public Uneasy() {
        super(MobEffectCategory.NEUTRAL, 452112);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(Items.MILK_BUCKET));
        list.add(new ItemStack(Items.COOKIE));
        list.add(new ItemStack(Items.PUMPKIN_PIE));
        return list;
    }
}
