package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidType;

public class FallenMultipartEntity extends UtilityEntity implements Enemy {
    public FallenMultipartEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.random.nextInt(200) == 0 && this.onGround()){
            AABB aabb = this.getBoundingBox().inflate(1);
            for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockState = level().getBlockState(blockpos);
                BlockState above = level().getBlockState(blockpos.above());
                if (!level().isClientSide() && blockState.isSolidRender(level(),blockpos) && !above.isSolidRender(level(),blockpos)){
                    if (Math.random() < 0.1){
                        if (Math.random() < 0.5) {
                            level().setBlock(blockpos.above(), Sblocks.GROWTHS_BIG.get().defaultBlockState(), 3);
                        } else {
                            level().setBlock(blockpos.above(), Sblocks.GROWTHS_SMALL.get().defaultBlockState(), 3);
                        }
                    }
                }
            }
        }
    }


    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
}
