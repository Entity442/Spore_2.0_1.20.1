package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CorrosiveDrownedLump extends GenericFoliageBlock{
    public CorrosiveDrownedLump() {
        super(Properties.of().sound(SoundType.CROP)
                .strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.SLIME_BLOCK).randomTicks());
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());

        if (fluid.getType() == Fluids.WATER) {
            return this.defaultBlockState()
                    .setValue(WATERLOGGED, true);
        }

        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        FluidState fluid = level.getFluidState(pos);
        return fluid.getType() == Fluids.WATER;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        AABB aabb = new AABB(pos.getX()-3,pos.getY(),pos.getZ()-3,pos.getX()+3,pos.getY()+3.,pos.getZ()+3);
        List<Entity> entityList = level.getEntities(null,aabb);
        for (Entity entity : entityList){
            if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living) && living.isInWater()){
                living.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),100,1));
                living.addEffect(new MobEffectInstance(MobEffects.POISON,100,1));
            }
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }
}
