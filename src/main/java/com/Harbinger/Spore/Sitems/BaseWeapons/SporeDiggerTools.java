package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

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
        if (canMultiBreak()){
            for (BlockPos blockPos : getBlocksToBeDestroyed(1,pos,living)){
                if (level.getBlockState(blockPos).is(blocks)){
                    level.removeBlock(blockPos,true);
                    hurtTool(stack,living,1);
                }
            }
        }
        return super.mineBlock(stack, level, state, pos, living);
    }
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return state.is(this.blocks) ? this.miningLevel : 1.0F;
    }

    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(this.blocks);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, LivingEntity player)
    {
        List<BlockPos> positions = new ArrayList<>();
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS)
        {
            return positions;
        }
        if(traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP)
        {
            for(int x = -range; x <= range; x++)
            {
                for(int y = -range; y <= range; y++)
                {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                }
            }
        }
        if(traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH)
        {
            for(int x = -range; x <= range; x++)
            {
                for(int y = -range; y <= range; y++)
                {
                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                }
            }
        }
        if(traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST)
        {
            for(int x = -range; x <= range; x++)
            {
                for(int y = -range; y <= range; y++)
                {
                    positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                }
            }
        }
        return positions;
    }

    public boolean canMultiBreak(){
        return false;
    }
}
