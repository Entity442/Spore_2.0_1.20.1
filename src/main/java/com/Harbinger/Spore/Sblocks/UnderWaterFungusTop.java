package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UnderWaterFungusTop extends GenericFoliageBlock{
    public UnderWaterFungusTop() {
        super(BlockBehaviour.Properties.of().sound(SoundType.CROP).strength(0f, 0f).noCollission().sound(SoundType.CROP).randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.TRUE));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(4, 0, 4, 12, 10, 12).move(offset.x, offset.y, offset.z);
    }


    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return this.mayPlaceOn(groundState, worldIn, blockpos);
    }
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter p_51043_, BlockPos pos) {
        return (blockState.canOcclude() || blockState.getBlock() == Sblocks.UNDERWATER_FUNGAL_STEM.get());
    }
    @Override
    public void entityInside(BlockState state, Level level, BlockPos blockpos, Entity entity) {
        if (!level.isClientSide) {
            AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level, blockpos.getX()+0.4, blockpos.getY(), blockpos.getZ()+0.4);
            areaeffectcloud.setRadius(3.5F);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setWaitTime(10);
            areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 100, 0));
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());
            level.addFreshEntity(areaeffectcloud);
            level.removeBlock(blockpos,false);
            level.playSound(null,blockpos, Ssounds.FUNGAL_BURST.get(), SoundSource.BLOCKS,1,1);
        }
    }


    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        super.randomTick(state, level, pos, source);
            BlockState blockState = level.getBlockState(pos.above());
            if (blockState.getFluidState().is(Fluids.WATER)){
                level.setBlock(pos,Sblocks.UNDERWATER_FUNGAL_STEM.get().defaultBlockState(),3);
                level.setBlock(pos.above(),Sblocks.UNDERWATER_FUNGAL_STEM_TOP.get().defaultBlockState(),3);
            }

    }
}
