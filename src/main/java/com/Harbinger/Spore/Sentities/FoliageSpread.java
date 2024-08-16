package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public interface FoliageSpread {
    default void SpreadInfection(Level level, double range, BlockPos pos){
        BlockState block1 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:ground_foliage")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block2 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:roof_foliage")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block3 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:wall_foliage")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.AIR)).defaultBlockState();
        BlockState block5 =  (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("spore:underwater_blocks")))
                .getRandomElement(RandomSource.create()).orElse(Blocks.WATER)).defaultBlockState();
        if (SConfig.SERVER.mound_foliage.get()){
            for(int i = 0; i <= 2*range; ++i) {
                for(int j = 0; j <= 2*range; ++j) {
                    for(int k = 0; k <= 2*range; ++k) {
                        double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                        if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                            if (distance<range+(0.5)){
                                BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);

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

                                BlockState blockstate = level.getBlockState(blockpos);

                                if (Math.random() < 0.02 && blockstate.isSolidRender(level,blockpos)
                                        && (nordT || southT || westT || eastT || aboveT || belowT)){
                                    for (String str : SConfig.DATAGEN.block_infection.get()){
                                        String[] string = str.split("\\|" );
                                        ItemStack stack = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0])));
                                        if (stack != ItemStack.EMPTY && blockstate.getBlock().asItem() == stack.getItem()){
                                            ItemStack itemStack = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1])));
                                            if (itemStack != ItemStack.EMPTY && itemStack.getItem() instanceof BlockItem blockItem){
                                                level.setBlock(blockpos,blockItem.getBlock().defaultBlockState(),3);
                                            }
                                        }
                                    }
                                }



                                if (blockstate.is(BlockTags.LOGS) && blockstate.getDestroySpeed(level ,blockpos) < 5 && Math.random() < 0.3){
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
                                }
                                if (blockstate.is(BlockTags.WOODEN_STAIRS) && blockstate.getDestroySpeed(level ,blockpos) < 5 && Math.random() < 0.3){
                                    BlockState _bs = Sblocks.ROTTEN_STAIR.get().defaultBlockState();
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
                                if (blockstate.is(BlockTags.PLANKS) && blockstate.getDestroySpeed(level ,blockpos) < 5 && Math.random() < 0.3){
                                    BlockState _bs = Sblocks.ROTTEN_PLANKS.get().defaultBlockState();
                                    level.setBlock(blockpos, _bs, 3);
                                }


                                if (blockstate.isSolidRender(level,blockpos ) && (above.getFluidState().is(Fluids.WATER) || above.getFluidState().is(Fluids.FLOWING_WATER)) && Math.random() < 0.01){
                                    if (block5.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty property){
                                        level.setBlock(blockpos.above(),block5.setValue(property, true),3);
                                    }else {
                                        level.setBlock(blockpos.above(),block5,3);
                                    }

                                }


                                if (above.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.01){level.setBlock(blockpos.above(),block1,3);}
                                if (below.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.01){
                                    if (block2.getBlock().getStateDefinition().getProperty("hanging") instanceof BooleanProperty property){
                                        level.setBlock(blockpos.below(),block2.setValue(property, true),3);
                                    }else {
                                        level.setBlock(blockpos.below(),block2,3);}}


                                if (blockstate.isSolidRender(level , blockpos) && (nordT || southT || westT || eastT || aboveT || belowT)){
                                    Direction direction = Direction.NORTH;
                                    Direction direction2 = Direction.SOUTH;
                                    Direction direction3 = Direction.EAST;
                                    Direction direction4 = Direction.WEST;
                                    Property<?> property = block3.getBlock().getStateDefinition().getProperty("facing");
                                    if (property instanceof DirectionProperty directionProperty && Math.random() < 0.01) {
                                        if (nord.isAir()){
                                            level.setBlock(blockpos.north(),block3.setValue(directionProperty,direction),3);
                                        }
                                        if (south.isAir()){
                                            level.setBlock(blockpos.south(),block3.setValue(directionProperty,direction2),3);
                                        }
                                        if (west.isAir()){
                                            level.setBlock(blockpos.west(),block3.setValue(directionProperty,direction4),3);
                                        }
                                        if (east.isAir()){
                                            level.setBlock(blockpos.east(),block3.setValue(directionProperty,direction3),3);
                                        }
                                    }
                                }
                            }}}}}
        }
    }
}
