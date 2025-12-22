package com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public final class SporeConversionData {
    private static final Map<ResourceLocation, ResourceLocation> CONVERSIONS = new HashMap<>();

    public static void clear() {
        CONVERSIONS.clear();
    }

    public static void add(ResourceLocation from, ResourceLocation to) {
        CONVERSIONS.put(from, to);
    }

    public static ResourceLocation get(ResourceLocation from) {
        return CONVERSIONS.get(from);
    }
}