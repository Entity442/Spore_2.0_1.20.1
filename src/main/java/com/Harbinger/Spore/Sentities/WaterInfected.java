package com.Harbinger.Spore.Sentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

public interface WaterInfected {
    default boolean isOcean(Holder<Biome> biome){
        return biome.is(BiomeTags.IS_OCEAN) || biome.is(BiomeTags.IS_DEEP_OCEAN);
    }
     default BlockPos findOcean(Level level, BlockPos origin) {
        int range = 128;
        int step = 4;

        for (int r = 4; r <= range; r += step) {
            for (int i = 0; i < r * 2; i += step) {
                BlockPos pos1 = origin.offset(r, 0, i - r);
                BlockPos pos2 = origin.offset(-r, 0, i - r);
                BlockPos pos3 = origin.offset(i - r, 0, r);
                BlockPos pos4 = origin.offset(i - r, 0, -r);

                BlockPos[] positions = {pos1, pos2, pos3, pos4};

                for (BlockPos pos : positions) {
                    if (level.isLoaded(pos)) {
                        var biome = level.getBiome(pos);
                        if (isOcean(biome)) {
                            return pos;
                        }
                    }
                }
            }
        }
        return null;
    }
}
