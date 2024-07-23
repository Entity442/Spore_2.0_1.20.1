package com.Harbinger.Spore.Sblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.List;

public interface StructureGenerator {
    default void generateStructure(ServerLevel level, ResourceLocation location, BlockPos pos, Block block){

        StructureTemplate template = level.getStructureManager().getOrCreate(location);
        List<StructureTemplate.StructureBlockInfo> info = template.filterBlocks(pos,new StructurePlaceSettings(),block);
        for (StructureTemplate.StructureBlockInfo blockInfo : info){
            placeBlock(level,blockInfo.state(),blockInfo.pos());
        }
    }

    default void placeBlock(Level level,BlockState state,BlockPos pos){
        level.setBlock(pos,state,3);
    }
}
