package com.Harbinger.Spore.ExtremelySusThings.CustomJsonReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.tags.TagKey;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class SporeCduConversionReloadListener extends SimpleJsonResourceReloadListener {
    public SporeCduConversionReloadListener() {
        super(new Gson(), "spore_cdu_conversion");
    }
    @Override
    protected void apply(
            Map<ResourceLocation, JsonElement> jsons,
            @NotNull ResourceManager resourceManager,
            @NotNull ProfilerFiller profiler
    ) {
        SporeCduConversionData.clear();

        for (JsonElement element : jsons.values()) {
            JsonObject obj = element.getAsJsonObject();

            for (var entry : obj.entrySet()) {
                String key = entry.getKey();
                ResourceLocation targetId = ResourceLocation.tryParse(entry.getValue().getAsString());
                Block target = BuiltInRegistries.BLOCK.get(targetId);

                if (key.startsWith("#")) {
                    // Tag input
                    ResourceLocation tagId = ResourceLocation.tryParse(key.substring(1));
                    TagKey<Block> tag = TagKey.create(Registries.BLOCK, tagId);
                    SporeCduConversionData.addTag(tag, target);
                } else {
                    // Direct block input
                    ResourceLocation fromId = ResourceLocation.tryParse(key);
                    Block from = BuiltInRegistries.BLOCK.get(fromId);
                    SporeCduConversionData.addBlock(from, target);
                }
            }
        }
    }
}
