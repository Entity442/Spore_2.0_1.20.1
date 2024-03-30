package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Spore;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.world.ModifiableStructureInfo;
import net.minecraftforge.common.world.StructureModifier;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StructureModification implements StructureModifier {


    private static final RegistryObject<Codec<? extends StructureModifier>> SERIALIZER =
            RegistryObject.create(new ResourceLocation(Spore.MODID, "spore_structure_spawns"),
                    ForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, Spore.MODID);

    @Override
    public void modify(Holder<Structure> structure, Phase phase, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (structure.is(BuiltinStructures.WOODLAND_MANSION)){
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData(Sentities.INF_EVOKER.get(),60,2,4));
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData(Sentities.INF_VINDICATOR.get(),80,3,6));}

        if (structure.is(BuiltinStructures.PILLAGER_OUTPOST)){
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData(Sentities.INF_PILLAGER.get(),60,2,4));
        }

        if (structure.is(TagKey.create(Registries.STRUCTURE,new ResourceLocation(Spore.MODID,"laboratories")))){
            if (!SConfig.SERVER.structure_spawns.get().isEmpty()){
                for (String str : SConfig.SERVER.structure_spawns.get()) {
                    String[] string = str.split("\\|");
                    EntityType<?> entity = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(string[0]));
                    if (entity != null){
                        builder.getStructureSettings().getOrAddSpawnOverrides(entity.getCategory()).addSpawn(new MobSpawnSettings.SpawnerData(entity, Integer.parseUnsignedInt(string[1]),
                                Integer.parseUnsignedInt(string[2]), Integer.parseUnsignedInt(string[3])));
                    }
                }
            }
        }
    }

    public static Codec<StructureModification> makeCodec() {
        return Codec.unit(StructureModification::new);
    }

    public Codec codec() {
        return SERIALIZER.get();
    }
}
