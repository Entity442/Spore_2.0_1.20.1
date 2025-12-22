package com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SporeConversionReloadListener extends SimpleJsonResourceReloadListener {
    public SporeConversionReloadListener() {
        super(new Gson(), "spore_conversion");
    }
    @Override
    protected void apply(
            Map<ResourceLocation, JsonElement> jsons,
            @NotNull ResourceManager resourceManager,
            @NotNull ProfilerFiller profiler
    ) {
        SporeConversionData.clear();

        for (JsonElement element : jsons.values()) {
            JsonObject obj = element.getAsJsonObject();

            for (var entry : obj.entrySet()) {
                ResourceLocation from = ResourceLocation.tryParse(entry.getKey());
                ResourceLocation to = ResourceLocation.tryParse(entry.getValue().getAsString());
                SporeConversionData.add(from, to);
            }
        }
    }
}
