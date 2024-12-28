package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SporeDiggerTools extends SporeToolsBaseItem{
    protected final TagKey<Block> blocks;
    public SporeDiggerTools(double meleeDamage, double meleeReach, double meleeRecharge, int durability, int miningLevel, TagKey<Block> blocks) {
        super(meleeDamage, meleeReach, meleeRecharge, durability, miningLevel);
        this.blocks = blocks;
    }
    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity living) {
        if (state.getDestroySpeed(level, pos) != 0.0F) {
            hurtTool(stack,living,1);
        }
        return super.mineBlock(stack, level, state, pos, living);
    }
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return state.is(this.blocks) ? this.miningLevel : 1.0F;
    }

    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(this.blocks);
    }
}
