package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Sitems.BaseItem2;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class MutationAgents extends BaseItem2 {
    protected final int mutationChance;
    protected final RandomSource source = RandomSource.create();
    public MutationAgents(int mutationChance) {
        super(new Item.Properties().stacksTo(8));
        this.mutationChance = mutationChance;
    }

    public int getMutationChance(){
        return mutationChance;
    }

    public abstract void mutateWeapon(ItemStack stack);
}
