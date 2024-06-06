package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Sblocks.MembraneBlock;
import net.minecraft.core.BlockPos;
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
        if (level.getBlockState(blockpos).getBlock() instanceof MembraneBlock){
            return false;
        }
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
        values.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        values.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        values.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        values.add(Sblocks.MEMBRANE_BLOCK.get().defaultBlockState());
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
}
