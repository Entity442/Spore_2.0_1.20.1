package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class CookedTorsoBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);
    public CookedTorsoBlock() {
        super(Properties.of().strength(0.0f).sound(SoundType.SLIME_BLOCK));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BITES, 0));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        {
            return switch (state.getValue(FACING)) {
                case EAST, WEST -> box(0, 0, 4, 16, 5, 12);
                default -> box(4, 0, 0, 12, 5, 16);
            };
        }
    }
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(BITES);
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            int bites = state.getValue(BITES);
            if (player.hasEffect(Seffects.MADNESS.get())) {player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 300, 1));} else {player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 0));}
            player.getFoodData().eat(4, 5F);
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,300,0));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,400,0));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,400,1));
            if (bites < 3) {
                world.setBlock(pos, state.setValue(BITES, bites + 1), 2);
            } else {
                world.removeBlock(pos, false);
            }
        }
        return InteractionResult.SUCCESS;
    }

}