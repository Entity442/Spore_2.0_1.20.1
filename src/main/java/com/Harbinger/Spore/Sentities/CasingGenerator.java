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


public interface CasingGenerator {
    private boolean compare(Level level,BlockPos blockpos){
        boolean propery1 = level.getBlockState(blockpos.below()).isSolidRender(level,blockpos);
        boolean propery2 = level.getBlockState(blockpos.above()).isSolidRender(level,blockpos);
        boolean properzx1 = level.getBlockState(blockpos.east()).isSolidRender(level,blockpos);
        boolean properzx2 = level.getBlockState(blockpos.south()).isSolidRender(level,blockpos);
        boolean properzx3 = level.getBlockState(blockpos.north()).isSolidRender(level,blockpos);
        boolean properzx4 = level.getBlockState(blockpos.west()).isSolidRender(level,blockpos);
        return propery1 || propery2 || properzx1 || properzx2 || properzx3 || properzx4;
    }
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
                if (Math.random() < 0.02 && !blockstate.isSolidRender(level,blockpos) && compare(level,blockpos)){
                    if (!level.isClientSide){
                        level.setBlock(blockpos,possibleBlock.get(randomSource.nextInt(possibleBlock.size())),3);
                    }
                }
            }
        }
    }
}
