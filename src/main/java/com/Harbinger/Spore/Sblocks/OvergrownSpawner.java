package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.SBlockEntities.OvergrownSpawnerEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class OvergrownSpawner extends BaseEntityBlock {
    public OvergrownSpawner() {
        super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(6f, 20f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OvergrownSpawnerEntity(pos,state);
    }


    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createSpawnerTicker(level, type, SblockEntities.OVERGROWN_SPAWNER.get());
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createSpawnerTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends OvergrownSpawnerEntity> p_151990_) {
        return level.isClientSide ? createTickerHelper(type, p_151990_, OvergrownSpawnerEntity::clientTick) : createTickerHelper(type, p_151990_, OvergrownSpawnerEntity::serverTick);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        {
            return box(0.1, 0, 0.1, 15.9, 16, 15.9).move(offset.x, offset.y, offset.z);
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource randomSource) {
        super.animateTick(state, level, pos, randomSource);
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity instanceof OvergrownSpawnerEntity blockEntity && blockEntity.getTime() > (blockEntity.getMaxTime() - 60)){
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        for (int l = 0; l < 10; ++l) {
            blockpos$mutableblockpos.set(pos.getX() + Mth.nextInt(randomSource, -3, 3), pos.getY() + Mth.nextInt(randomSource, -3, 3), pos.getZ() + Mth.nextInt(randomSource, -3, 3));
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isSolidRender(level, blockpos$mutableblockpos)) {
                level.addParticle(Sparticles.BLOOD_PARTICLE.get(), (double) blockpos$mutableblockpos.getX() + randomSource.nextDouble(), (double) blockpos$mutableblockpos.getY() + randomSource.nextDouble(), (double) blockpos$mutableblockpos.getZ() + randomSource.nextDouble(), 0.0D, 0.1D, 0.0D);
            }
          }
        }
    }
}
