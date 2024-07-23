package com.Harbinger.Spore.Sblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MyceliumVeins extends GenericFoliageBlock {
    public MyceliumVeins() {
        super(BlockBehaviour.Properties.of().strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.CROP));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(0, 0, 0, 16, 0.2, 16).move(offset.x, offset.y, offset.z);
    }

}
