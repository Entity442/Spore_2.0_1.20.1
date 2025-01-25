package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.SBlockEntities.*;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SblockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Spore.MODID);


    public static final RegistryObject<BlockEntityType<ContainerBlockEntity>> CONTAINER =
            BLOCK_ENTITIES.register("container", () ->
                    BlockEntityType.Builder.of(ContainerBlockEntity::new,
                            Sblocks.CONTAINER.get()).build(null));
    public static final RegistryObject<BlockEntityType<BiomassLumpEntity>> BIOMASS_LUMP =
            BLOCK_ENTITIES.register("biomass_lump", () ->
                    BlockEntityType.Builder.of(BiomassLumpEntity::new,
                            Sblocks.BIOMASS_LUMP.get()).build(null));
    public static final RegistryObject<BlockEntityType<HiveSpawnBlockEntity>> HIVE_SPAWN =
            BLOCK_ENTITIES.register("hive_spawn", () ->
                    BlockEntityType.Builder.of(HiveSpawnBlockEntity::new,
                            Sblocks.HIVE_SPAWN.get()).build(null));
    public static final RegistryObject<BlockEntityType<CDUBlockEntity>> CDU =
            BLOCK_ENTITIES.register("cdu", () ->
                    BlockEntityType.Builder.of(CDUBlockEntity::new,
                            Sblocks.CDU.get()).build(null));
    public static final RegistryObject<BlockEntityType<ZoaholicBlockEntity>> ZOAHOLIC =
            BLOCK_ENTITIES.register("zoaholic", () ->
                    BlockEntityType.Builder.of(ZoaholicBlockEntity::new,
                            Sblocks.ZOAHOLIC.get()).build(null));
    public static final RegistryObject<BlockEntityType<IncubatorBlockEntity>> INCUBATOR =
            BLOCK_ENTITIES.register("incubator_entity", () ->
                    BlockEntityType.Builder.of(IncubatorBlockEntity::new,
                            Sblocks.INCUBATOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<OvergrownSpawnerEntity>> OVERGROWN_SPAWNER =
            BLOCK_ENTITIES.register("overgrown_spawner", () ->
                    BlockEntityType.Builder.of(OvergrownSpawnerEntity::new,
                            Sblocks.OVERGROWN_SPAWNER.get()).build(null));
    public static final RegistryObject<BlockEntityType<BrainRemnantBlockEntity>> BRAIN_REMNANTS =
            BLOCK_ENTITIES.register("brain_remnants", () ->
                    BlockEntityType.Builder.of(BrainRemnantBlockEntity::new,
                            Sblocks.BRAIN_REMNANTS.get()).build(null));
    public static final RegistryObject<BlockEntityType<OutpostWatcherBlockEntity>> OUTPOST_WATCHER =
            BLOCK_ENTITIES.register("outpost_watcher_entity", () ->
                    BlockEntityType.Builder.of(OutpostWatcherBlockEntity::new,
                            Sblocks.OUTPOST_WATCHER.get()).build(null));
    public static final RegistryObject<BlockEntityType<SurgeryTableBlockEntity>> SURGERY_TABLE_ENTITY =
            BLOCK_ENTITIES.register("surgery_table_entity", () ->
                    BlockEntityType.Builder.of(SurgeryTableBlockEntity::new,
                            Sblocks.SURGERY_TABLE.get()).build(null));
    public static final RegistryObject<BlockEntityType<CentrifugeBlockEntity>> CENTRIFUGE_ENTITY =
            BLOCK_ENTITIES.register("centrifuge_entity", () ->
                    BlockEntityType.Builder.of(CentrifugeBlockEntity::new,
                            Sblocks.CENTRIFUGE.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
