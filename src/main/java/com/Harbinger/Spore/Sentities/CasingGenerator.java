package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Sblocks.MembraneBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

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

    default List<BlockState> possibleBlocks(){
        List<BlockState> values = new ArrayList<>();
        values.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        values.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        values.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        values.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        values.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        values.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        values.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        values.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        return values;
    }
    default void generateChasing(BlockPos pos,Entity entity, int radius){
        this.generateChasing(pos,entity,radius,1);
    }
    default void generateChasing(BlockPos pos,Entity entity, int radius,int thickness){
        Level level = entity.level();
        RandomSource randomSource = RandomSource.create();
        for(int i = 0; i <= 2*radius; ++i) {
            for(int j = 0; j <= 2*radius; ++j) {
                for(int k = 0; k <= 2*radius; ++k) {
                    double distance = Mth.sqrt((i-radius)*(i-radius) + (j-radius)*(j-radius) + (k-radius)*(k-radius));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance>radius-(thickness/2d) && distance<radius+(thickness/2d)){
                            BlockPos blockpos = pos.offset(i-radius,j-radius,k-radius);
                            BlockState blockstate = level.getBlockState(blockpos);
                            if (Math.random() < 0.1 && !blockstate.isSolidRender(level,blockpos) && compare(level,blockpos)){
                                if (!level.isClientSide){
                                    level.setBlock(blockpos,this.possibleBlocks().get(randomSource.nextInt(this.possibleBlocks().size())),3);
                                    if (Math.random() < 0.001){
                                        createSpots(blockpos,level,randomSource.nextInt(3,6),Math.random() < 0.5 ? Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState():Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
                                    }
                                    if (Math.random() < 0.001){
                                        createPussSpots(blockpos,level,randomSource.nextInt(2,5));
                                    }
                                    if (Math.random() < 0.01 && level.getBlockState(blockpos.above()).isAir()){
                                        createFungalStalks(blockpos,level,randomSource.nextInt(4,12),randomSource);
                                    }
                                }
                            }
                            if (Math.random() < 0.05 && blockstate.isSolidRender(level,blockpos)){
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
                        }
                    }
                }
            }
        }
    }

    default void createSpots(BlockPos pos,Level level, int range,BlockState state){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            if (possibleBlocks().contains(level.getBlockState(blockpos))){
                                level.setBlock(blockpos,state,3);
                            }
                        }}}}}
    }
    default void createPussSpots(BlockPos pos,Level level, int range){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5) && distance>range-(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            if (level.getBlockState(blockpos).isAir()){
                                level.setBlock(blockpos,Math.random() < 0.5 ? Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState() : Sblocks.BIOMASS_BLOCK.get().defaultBlockState(), 3);
                            }
                        }
                        if (distance<range-(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            if (level.getBlockState(blockpos).isAir()){
                                level.setBlock(blockpos,Math.random() < 0.5 ? Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState() : Sblocks.BILE.get().defaultBlockState(), 3);
                            }
                        }
                    }}}}
    }
    default void createFungalStalks(BlockPos pos,Level level,int range,RandomSource source){
        List<Integer> offsets = new ArrayList<>(){{add(-1);add(0);add(1);}};
        List<Integer> offsets2 = new ArrayList<>(){{add(-1);add(0);add(1);}};
        List<BlockState> states = new ArrayList<>(){{add(Sblocks.MYCELIUM_BLOCK.get().defaultBlockState());add(Sblocks.FUNGAL_SHELL.get().defaultBlockState());}};
        BlockPos blockPos = pos;
        for (int i = 0; i <= range;i++){
            blockPos = blockPos.offset(offsets.get(source.nextInt(offsets.size())),i,offsets2.get(source.nextInt(offsets.size())));
            level.setBlock(blockPos,states.get(source.nextInt(states.size())),3);
        }
    }
}
