package com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public final class SporeMobConversionData {

    private static final Map<EntityType<?>, EntityType<?>> ENTITY_CONVERSIONS = new HashMap<>();
    private static final Map<TagKey<EntityType<?>>, EntityType<?>> ENTITY_TAG_CONVERSIONS = new HashMap<>();

    public static void clear() {
        ENTITY_CONVERSIONS.clear();
        ENTITY_TAG_CONVERSIONS.clear();
    }

    public static void addBlock(EntityType<?> from, EntityType<?> to) {
        ENTITY_CONVERSIONS.put(from, to);
    }

    public static void addTag(TagKey<EntityType<?>> tag, EntityType<?> to) {
        ENTITY_TAG_CONVERSIONS.put(tag, to);
    }

    public static EntityType<?> getResult(EntityType<?> block) {
        // Exact match first
        EntityType<?> direct = ENTITY_CONVERSIONS.get(block);
        if (direct != null) return direct;

        // Then tag-based
        for (var entry : ENTITY_TAG_CONVERSIONS.entrySet()) {
            if (block.is(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }
}
