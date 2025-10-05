package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Sblocks.GenericFoliageBlock;
import com.Harbinger.Spore.Sblocks.SelectableFallingBlock;
import com.Harbinger.Spore.Spore;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FoliageSpread {
    default void SpreadInfection(Level level, double range, BlockPos pos){
        if (!level.isClientSide)
            if (SConfig.SERVER.mound_foliage.get()){
             additionPlacers(level,pos,range);
             for(int i = 0; i <= 2*range; ++i) {
                for(int j = 0; j <= 2*range; ++j) {
                    for(int k = 0; k <= 2*range; ++k) {
                        double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                        if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                            if (distance<range+(0.5)){
                                BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                                BlockState blockstate = level.getBlockState(blockpos);
                                SpreadFoliageAndConvert(level,blockstate,blockpos);
                            }}}}}

            }else{
             additionIgnoreConfigPlacers(level,pos,range);
            }
    }
    default void SpreadFoliageAndConvert(Level level,BlockState blockstate,BlockPos blockpos){
        BlockState nord = level.getBlockState(blockpos.north());
        BlockState south = level.getBlockState(blockpos.south());
        BlockState west = level.getBlockState(blockpos.west());
        BlockState east = level.getBlockState(blockpos.east());
        BlockState above = level.getBlockState(blockpos.above());
        BlockState below = level.getBlockState(blockpos.below());
        boolean nordT = !nord.isSolidRender(level,blockpos.north());
        boolean southT = !south.isSolidRender(level,blockpos.south());
        boolean westT = !west.isSolidRender(level,blockpos.west());
        boolean eastT = !east.isSolidRender(level,blockpos.east());
        boolean aboveT = !above.isSolidRender(level,blockpos.above());
        boolean belowT = !below.isSolidRender(level,blockpos.below());
        if (Math.random() < 0.1 && blockstate.isSolidRender(level,blockpos)
                && (nordT || southT || westT || eastT || aboveT || belowT)){
            convertBlocks(blockstate,level,blockpos);
        }
        if (Math.random() < 0.2){
            convertWood(level,blockstate,blockpos);
            placeRottenBush(above,level,blockpos,blockstate);
        }
        if (Math.random() < 0.01){
            placeGroundFoliage(above,level,blockpos,blockstate);
        }
        if (Math.random() < 0.01){
            placeCropsFoliage(level,blockpos,blockstate);
        }
        if (Math.random() < 0.01){
            placeWaterFoliage(above,level,blockpos,blockstate);
        }
        if (Math.random() < 0.01){
            placeHangingFoliage(below,level,blockpos,blockstate);
        }
        if (Math.random() < 0.01){
            placeWallFoliage(nord,south,west,east,nordT,southT,westT,eastT,level,blockpos,blockstate);
        }
    }

    default void additionPlacers(Level level,BlockPos pos,double range){
    }
    default void additionIgnoreConfigPlacers(Level level,BlockPos pos,double range){
    }

    default void placeGroundFoliage(BlockState above,Level level,BlockPos blockpos,BlockState blockstate){
        if (above.isAir() && blockstate.isSolidRender(level ,blockpos)){
            BlockState block1 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:ground_foliage")))
                    .getRandomElement(RandomSource.create()).orElse(Sblocks.GROWTHS_BIG.get())).defaultBlockState();
            level.setBlock(blockpos.above(),block1,3);
        }
    }
    default void placeCropsFoliage(Level level,BlockPos blockpos,BlockState blockstate){
        if (blockstate.getBlock() instanceof CropBlock){
            level.setBlock(blockpos,Sblocks.ROTTEN_CROPS.get().defaultBlockState(),3);
        }
    }
    default void placeRottenBush(BlockState above,Level level,BlockPos blockpos,BlockState blockstate){
        if (above.getBlock() instanceof BushBlock && !(above.getBlock() instanceof GenericFoliageBlock) && blockstate.isSolidRender(level ,blockpos)){
            BlockState state = Math.random() < 0.5f ? Sblocks.ROTTEN_BUSH.get().defaultBlockState() : Sblocks.GROWTHS_BIG.get().defaultBlockState();
            level.setBlock(blockpos.above(),state, 3);
        }
    }
    default void placeWaterFoliage(BlockState above,Level level,BlockPos blockpos,BlockState blockstate){
        BlockState block5 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:underwater_blocks")))
                .getRandomElement(RandomSource.create()).orElse(Sblocks.GROWTHS_SMALL.get())).defaultBlockState();
        if (blockstate.isSolidRender(level,blockpos ) && above.getFluidState().is(Fluids.WATER)){
            if (block5.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty property){
                level.setBlock(blockpos.above(),block5.setValue(property, true),3);
            }else {
                level.setBlock(blockpos.above(),block5,3);
            }
        }
    }
    default void placeHangingFoliage(BlockState below,Level level,BlockPos blockpos,BlockState blockstate){
        if (below.isAir() && blockstate.isSolidRender(level ,blockpos)){
            BlockState block2 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:roof_foliage")))
                    .getRandomElement(RandomSource.create()).orElse(Sblocks.FUNGAL_ROOTS.get())).defaultBlockState();
            if (block2.getBlock().getStateDefinition().getProperty("hanging") instanceof BooleanProperty property){
                level.setBlock(blockpos.below(),block2.setValue(property, true),3);
            }else {
                level.setBlock(blockpos.below(),block2,3);}}
    }
    default void placeWallFoliage(BlockState nord,BlockState south,BlockState west,BlockState east,boolean nordT,boolean southT,boolean westT,boolean eastT,Level level,BlockPos blockpos,BlockState blockstate){
        if (blockstate.isSolidRender(level , blockpos) && (nordT || southT || westT || eastT)){
            BlockState block3 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:wall_foliage")))
                    .getRandomElement(RandomSource.create()).orElse(Sblocks.WALL_GROWTHS.get())).defaultBlockState();
            Direction direction = Direction.NORTH;
            Direction direction2 = Direction.SOUTH;
            Direction direction3 = Direction.EAST;
            Direction direction4 = Direction.WEST;
            Property<?> property = block3.getBlock().getStateDefinition().getProperty("facing");
            if (property instanceof DirectionProperty directionProperty) {
                if (nord.isAir() && Math.random() < 0.5){
                    level.setBlock(blockpos.north(),block3.setValue(directionProperty,direction),3);
                }
                if (south.isAir() && Math.random() < 0.5){
                    level.setBlock(blockpos.south(),block3.setValue(directionProperty,direction2),3);
                }
                if (west.isAir() && Math.random() < 0.5){
                    level.setBlock(blockpos.west(),block3.setValue(directionProperty,direction4),3);
                }
                if (east.isAir() && Math.random() < 0.5){
                    level.setBlock(blockpos.east(),block3.setValue(directionProperty,direction3),3);
                }
            }
        }
    }
    default void placeBranches(Level level,BlockPos blockpos,BlockState blockstate){
        if (blockstate.isSolidRender(level , blockpos)){
            BlockState block3 = Sblocks.ROTTEN_BRANCH.get().defaultBlockState();
            BlockState nord = level.getBlockState(blockpos.north());
            BlockState south = level.getBlockState(blockpos.south());
            BlockState west = level.getBlockState(blockpos.west());
            BlockState east = level.getBlockState(blockpos.east());
            Property<?> property = block3.getBlock().getStateDefinition().getProperty("facing");
            if (property instanceof DirectionProperty directionProperty) {
                if (nord.getBlock() instanceof LeavesBlock && Math.random() < 0.3){
                    level.setBlock(blockpos.north(),block3.setValue(directionProperty,Direction.NORTH),3);
                }
                if (south.getBlock() instanceof LeavesBlock && Math.random() < 0.3){
                    level.setBlock(blockpos.south(),block3.setValue(directionProperty,Direction.SOUTH),3);
                }
                if (west.getBlock() instanceof LeavesBlock && Math.random() < 0.3){
                    level.setBlock(blockpos.west(),block3.setValue(directionProperty,Direction.WEST),3);
                }
                if (east.getBlock() instanceof LeavesBlock && Math.random() < 0.3){
                    level.setBlock(blockpos.east(),block3.setValue(directionProperty,Direction.EAST),3);
                }
            }
        }
    }
    default void convertBlocks(BlockState blockstate,Level level,BlockPos blockpos){
        for (String str : SConfig.DATAGEN.block_infection.get()){
            String[] string = str.split("\\|" );
            Block blockCon1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0]));
            Block blockCon2 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1]));
            if (blockCon1 != null && blockCon2 != null){
                if (blockCon1 == blockstate.getBlock()){
                    level.setBlock(blockpos,blockCon2.defaultBlockState(),3);
                }
            }
        }
    }

    default void convertWood(Level level,BlockState blockstate,BlockPos blockpos){
        if (blockstate.is(BlockTags.LOGS)){
            BlockState _bs = Sblocks.ROTTEN_LOG.get().defaultBlockState();
            for (Map.Entry<Property<?>, Comparable<?>> entry : blockstate.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null)
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception e) {
                    }
            }
            level.setBlock(blockpos, _bs, 3);
            placeBranches(level, blockpos, blockstate);
        }
        if (blockstate.is(BlockTags.WOODEN_STAIRS)){
            BlockState _bs = Sblocks.ROTTEN_STAIR.get().defaultBlockState();
            for (Map.Entry<Property<?>, Comparable<?>> entry : blockstate.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null)
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception e) {
                    }
            }
            if (Math.random() < 0.3f){
                FallingBlockEntity.fall(level,blockpos,_bs);
            }else {
                level.setBlock(blockpos, _bs, 3);
            }
        }
        if (blockstate.is(BlockTags.PLANKS)){
            BlockState _bs = Sblocks.ROTTEN_PLANKS.get().defaultBlockState();
            if (Math.random() < 0.3f && level.getBlockState(blockpos.below()).isAir()){
                FallingBlockEntity.fall(level,blockpos,_bs);
            }else {
                level.setBlock(blockpos, _bs, 3);
            }
        }
        if (blockstate.is(BlockTags.WOODEN_SLABS)){
            BlockState _bs = Sblocks.ROTTEN_SLAB.get().defaultBlockState();
            for (Map.Entry<Property<?>, Comparable<?>> entry : blockstate.getValues().entrySet()) {
                Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                if (_property != null && _bs.getValue(_property) != null)
                    try {
                        _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                    } catch (Exception e) {
                    }
            }
            level.setBlock(blockpos, _bs, 3);
        }
        if (blockstate.is(BlockTags.WOODEN_DOORS) || blockstate.is(BlockTags.WOODEN_TRAPDOORS) || blockstate.is(BlockTags.WOODEN_FENCES) || blockstate.is(BlockTags.WOODEN_PRESSURE_PLATES)){
            BlockState _bs = Sblocks.ROTTEN_SCRAPS.get().defaultBlockState();
            FallingBlockEntity.fall(level,blockpos,_bs);
        }
    }
}
