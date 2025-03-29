package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeartPie extends Block {
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);

    public HeartPie() {
        super(Properties.of().strength(0.5f).sound(SoundType.SLIME_BLOCK));
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Block.box(1, 0, 1, 15, 4, 15);
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            ItemStack stack = new ItemStack(Sitems.SLICE_OF_HEARTPIE.get());
            int bites = state.getValue(BITES);
            world.addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack.copy()));
            if (bites < 3) {
                world.setBlock(pos, state.setValue(BITES, bites + 1), 2);
            } else {
                world.removeBlock(pos, false);
            }
        }
        return InteractionResult.SUCCESS;
    }
}

