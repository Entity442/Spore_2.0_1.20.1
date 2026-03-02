package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.Projectile.FallenAcidSack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class FallingAcidSack extends HangingRootsBlock {
    public FallingAcidSack() {
        super(Properties.of().strength(4f, 2f).noCollission().noOcclusion().sound(SoundType.SLIME_BLOCK).randomTicks().lightLevel(s -> 1).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
    }
    protected static final VoxelShape SHAPE = Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public VoxelShape getShape(BlockState p_153342_, BlockGetter p_153343_, BlockPos p_153344_, CollisionContext p_153345_) {
        return SHAPE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        super.randomTick(state, serverLevel, pos, randomSource);
        AABB searchArea = new AABB(
                pos.getX() - 3, pos.getY() - 8, pos.getZ() - 3,
                pos.getX() + 3, pos.getY(), pos.getZ() + 3
        );
        List<LivingEntity> entities = serverLevel.getEntitiesOfClass(LivingEntity.class, searchArea,
                living -> Utilities.TARGET_SELECTOR.Test(living));
        if (!entities.isEmpty()) {
            serverLevel.destroyBlock(pos, false);
            FallenAcidSack sack = new FallenAcidSack(serverLevel);
            sack.moveTo(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D);
            sack.setDeltaMovement(
                    (randomSource.nextDouble() - 0.5D) * 0.1D,
                    -0.5D,
                    (randomSource.nextDouble() - 0.5D) * 0.1D
            );
            serverLevel.addFreshEntity(sack);
        }
    }
}
