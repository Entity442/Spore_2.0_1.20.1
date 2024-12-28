package com.Harbinger.Spore.Sitems.BaseWeapons;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.ArrayList;
import java.util.List;

public class SporePickaxeItems extends SporeDiggerTools{
    public SporePickaxeItems(double meleeDamage, double meleeReach, double meleeRecharge, int durability, int miningLevel) {
        super(meleeDamage, meleeReach, meleeRecharge, durability, miningLevel, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
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

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity living) {
        if (isHammer()){
            for (BlockPos blockPos : getBlocksToBeDestroyed(1,pos,living)){
                if (level.getBlockState(blockPos).is(blocks)){
                    level.removeBlock(blockPos,true);
                    hurtTool(stack,living,1);
                }
            }
        }
        return super.mineBlock(stack, level, state, pos, living);
    }

    public boolean isHammer(){
        return false;
    }
}
