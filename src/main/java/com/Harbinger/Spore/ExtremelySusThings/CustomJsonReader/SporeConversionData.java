package com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public final class SporeConversionData {

    private static final Map<Block, Block> BLOCK_CONVERSIONS = new HashMap<>();
    private static final Map<TagKey<Block>, Block> TAG_CONVERSIONS = new HashMap<>();

    public static void clear() {
        BLOCK_CONVERSIONS.clear();
        TAG_CONVERSIONS.clear();
    }

    public static void addBlock(Block from, Block to) {
        BLOCK_CONVERSIONS.put(from, to);
    }

    public static void addTag(TagKey<Block> tag, Block to) {
        TAG_CONVERSIONS.put(tag, to);
    }

    public static Block getResult(Block block) {
        // Exact match first
        Block direct = BLOCK_CONVERSIONS.get(block);
        if (direct != null) return direct;

        // Then tag-based
        for (var entry : TAG_CONVERSIONS.entrySet()) {
            if (block.defaultBlockState().is(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }
}
