package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class SporePickaxeItems extends SporeDiggerTools{
    public SporePickaxeItems(double meleeDamage, double meleeReach, double meleeRecharge, int durability, int miningLevel) {
        super(meleeDamage, meleeReach, meleeRecharge, durability, miningLevel, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }
}
