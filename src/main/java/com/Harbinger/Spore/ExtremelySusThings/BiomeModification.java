package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Spore;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class BiomeModification implements BiomeModifier {
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER =
            RegistryObject.create(new ResourceLocation(Spore.MODID, "inf_spawns"),
                    ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Spore.MODID);

    public BiomeModification() {}

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase != Phase.ADD) return;

        if (isBiomeBlacklisted(biome)) return;

        int biomeModifier = biome.is(Tags.Biomes.IS_MUSHROOM) ? 20 : 0;

        for (String allowedBiome : SConfig.SERVER.dimension_parameters.get()) {
            ResourceLocation biomeLocation = new ResourceLocation(allowedBiome);
            TagKey<Biome> biomeTag = TagKey.create(Registries.BIOME, biomeLocation);

            if (biome.is(biomeTag) || biome.is(biomeLocation)) {
                addSpawns(builder, biomeModifier);
                break;
            }
        }
    }

    private void addSpawns(ModifiableBiomeInfo.BiomeInfo.Builder builder, int modifier) {
        List<? extends String> spawnEntries = SConfig.SERVER.spawns.get();

        for (String entry : spawnEntries) {
            String[] parts = entry.split("\\|");
            if (parts.length != 4) {
                Spore.LOGGER.warn("Invalid spawn config entry: {}", entry);
                continue;
            }

            ResourceLocation entityId = new ResourceLocation(parts[0]);
            EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(entityId);

            if (entityType == null) {
                Spore.LOGGER.warn("Unknown entity type: {}", parts[0]);
                continue;
            }

            try {
                int weight = Integer.parseUnsignedInt(parts[1]) + modifier;
                int minCount = Integer.parseUnsignedInt(parts[2]);
                int maxCount = Integer.parseUnsignedInt(parts[3]);

                builder.getMobSpawnSettings()
                        .getSpawner(entityType.getCategory())
                        .add(new MobSpawnSettings.SpawnerData(entityType, weight, minCount, maxCount));

            } catch (NumberFormatException e) {
                Spore.LOGGER.error("Invalid spawn config number format in: {}", entry, e);
            }
        }
    }

    private boolean isBiomeBlacklisted(Holder<Biome> biome) {
        for (String blacklisted : SConfig.SERVER.dimension_blacklist.get()) {
            ResourceLocation blacklistedLocation = new ResourceLocation(blacklisted);
            TagKey<Biome> blacklistTag = TagKey.create(Registries.BIOME, blacklistedLocation);
            if (biome.is(blacklistTag) || biome.is(blacklistedLocation)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return SERIALIZER.get();
    }

    public static Codec<BiomeModification> makeCodec() {
        return Codec.unit(BiomeModification::new);
    }
}
