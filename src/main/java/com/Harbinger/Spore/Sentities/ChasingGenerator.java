package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;


public interface ChasingGenerator {
    default void generateChasing(Entity entity, int range,int thickness){
        List<BlockState> possibleBlock = new ArrayList<>();
        possibleBlock.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        possibleBlock.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        possibleBlock.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        possibleBlock.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        possibleBlock.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        Level level = entity.level();
        RandomSource randomSource = RandomSource.create();
        BlockPos blockPos = entity.getOnPos();
        AABB boxInner = AABB.ofSize(new Vec3(blockPos.getX()-1, blockPos.getY(), blockPos.getZ()-1), range-thickness, range-thickness, range-thickness);
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), range, range, range);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            if (!boxInner.contains(blockpos.getX()-1,blockpos.getY(),blockpos.getZ()-1)){
                BlockState blockstate = level.getBlockState(blockpos);
                boolean properPlacement = level.getBlockState(blockpos.below()).isSolidRender(level,blockpos);
                if (Math.random() < 0.02 && !blockstate.isSolidRender(level,blockpos) && properPlacement){
                    if (!level.isClientSide){
                        level.setBlock(blockpos,possibleBlock.get(randomSource.nextInt(possibleBlock.size())),3);
                    }
                }
            }
        }
    }
}
