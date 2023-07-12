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

public class BiomeModification implements BiomeModifier {
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER =
            RegistryObject.create(new ResourceLocation(Spore.MODID, "inf_spawns"),
                    ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Spore.MODID);

    public BiomeModification() {
    }

    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            int biomesModifier = 0;
            if (biome.is(Tags.Biomes.IS_MUSHROOM)){biomesModifier = 20;}

            for (String biomeString : SConfig.SERVER.dimension_parameters.get()){
                if (biome.is(TagKey.create(Registries.BIOME,
                        new ResourceLocation(biomeString))) || biome.is(new ResourceLocation(biomeString))) {
                    for (String str : SConfig.SERVER.spawns.get()) {
                        String[] string = str.split("\\|");
                        EntityType<?> entity = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(string[0]));
                        if (entity != null){
                            builder.getMobSpawnSettings().getSpawner(entity.getCategory())
                                    .add(new MobSpawnSettings.SpawnerData(entity, Integer.parseUnsignedInt(string[1]) + biomesModifier,
                                            Integer.parseUnsignedInt(string[2]), Integer.parseUnsignedInt(string[3])));
                        }

                    }
                }
            }
        }
    }

    public Codec<? extends BiomeModifier> codec() {
        return (Codec)SERIALIZER.get();
    }


    public static Codec<BiomeModification> makeCodec() {
        return Codec.unit(BiomeModification::new);
    }





}
