package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BiomassBulb extends GenericFoliageBlock{
    public BiomassBulb() {
        super(BlockBehaviour.Properties.of().strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.SLIME_BLOCK));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        return box(4, 0, 4, 12, 8, 12).move(offset.x, offset.y, offset.z);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (fluid.is(Fluids.WATER)){
            AreaEffectCloud cloud = new AreaEffectCloud(level,pos.getX(),pos.getY(),pos.getZ());
            cloud.addEffect(new MobEffectInstance(Seffects.MARKER.get(),200,0));
            level.addFreshEntity(cloud);
        }else{
            RandomSource randomSource = RandomSource.create();
            ItemStack stack = new ItemStack(Sitems.BIOMASS.get());
            stack.setCount(randomSource.nextInt(1,5));
            ItemEntity entity = new ItemEntity(level,pos.getX(),pos.getY(),pos.getZ(),stack);
            level.addFreshEntity(entity);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
