package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Tar extends Block {
    public Tar() {
        super(Properties.of().noOcclusion().sound(SoundType.SLIME_BLOCK).randomTicks());
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        {
            return box(0, 0, 0, 16, 1, 16).move(offset.x, offset.y, offset.z);
        }
    }

    @Override
    public void entityInside(BlockState p_60495_, Level p_60496_, BlockPos p_60497_, Entity entity) {
        super.entityInside(p_60495_, p_60496_, p_60497_, entity);
        if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living) && !living.hasEffect(Seffects.IGNITABLE.get())){
            living.addEffect(new MobEffectInstance(Seffects.IGNITABLE.get(),100,0));
        }
    }
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        level.removeBlock(pos,false);
        super.randomTick(state, level, pos, randomSource);
    }
    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 50;
    }
}
