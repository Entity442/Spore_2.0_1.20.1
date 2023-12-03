package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Sblocks.*;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sblocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Spore.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    public static final RegistryObject<Block> ACID = BLOCKS.register("acid", Acid::new);
    public static final RegistryObject<Block> CONTAINER = BLOCKS.register("container", Container::new);
    public static final RegistryObject<Block> LAB_BLOCK = BLOCKS.register("lab_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(6f, 20f)));
    public static final RegistryObject<Block> LAB_SLAB = BLOCKS.register("lab_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Sblocks.LAB_BLOCK.get())));
    public static final RegistryObject<Block> LAB_STAIR = BLOCKS.register("lab_stair", () -> new StairBlock(()-> LAB_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.copy(Sblocks.LAB_BLOCK.get())));
    public static final RegistryObject<Block> IRON_LADDER = BLOCKS.register("iron_ladder", () -> new IronLadderBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f, 4f).noOcclusion().sound(SoundType.METAL)));
    public static final RegistryObject<Block> VENT_PLATE = BLOCKS.register("vent_plate", VentPlateBlock::new);
    public static final RegistryObject<Block> RUSTED_VENT_PLATE = BLOCKS.register("rusted_vent_plate", VentPlateBlock::new);
    public static final RegistryObject<Block> VENT_DOOR = BLOCKS.register("vent_door",() -> new TrapDoorBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(2f, 4f).noOcclusion().sound(SoundType.METAL), BlockSetType.STONE));
    public static final RegistryObject<Block> CDU = BLOCKS.register("cdu", CDUBlock::new);

    public static final RegistryObject<Block> REINFORCED_DOOR = BLOCKS.register("reinforced_door",() -> new DoorBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(20f, 1200.0F).noOcclusion().sound(SoundType.METAL).noParticlesOnBreak(), BlockSetType.IRON));
    public static final RegistryObject<Block> RUSTED_REINFORCED_DOOR = BLOCKS.register("rusted_reinforced_door",() -> new DoorBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(10f, 600.0F).noOcclusion().sound(SoundType.METAL).noParticlesOnBreak(), BlockSetType.IRON));
    public static final RegistryObject<Block> FROZEN_REINFORCED_DOOR = BLOCKS.register("frozen_reinforced_door",() -> new DoorBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(15f, 800.0F).noOcclusion().sound(SoundType.METAL).noParticlesOnBreak(), BlockSetType.IRON));


    public static final RegistryObject<Block> GROWTHS_BIG = BLOCKS.register("growths_big", () -> new GenericFoliageBlock( BlockBehaviour.Properties.of().sound(SoundType.CROP).strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.CROP)));
    public static final RegistryObject<Block> GROWTHS_SMALL = BLOCKS.register("growths_small", () -> new GenericFoliageBlock( BlockBehaviour.Properties.of().strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.CROP)));
    public static final RegistryObject<Block> FUNGAL_STEM_SAPLING = BLOCKS.register("fungal_stem_sapling", FungalSaplings::new);
    public static final RegistryObject<Block> BLOOM_G = BLOCKS.register("blomfung", HangingPlant::new);
    public static final RegistryObject<Block> BLOOM_GG = BLOCKS.register("bloomfung2", HangingPlantBub::new);
    public static final RegistryObject<Block> FUNGAL_STEM = BLOCKS.register("fungal_stem", FungalStem::new);
    public static final RegistryObject<Block> UNDERWATER_FUNGAL_STEM = BLOCKS.register("underwater_fungal_stem", UnderWaterFungalStem::new);
    public static final RegistryObject<Block> HANGING_FUNGAL_STEM = BLOCKS.register("hanging_fungal_stem", HangingStem::new);
    public static final RegistryObject<Block> FUNGAL_STEM_TOP = BLOCKS.register("fungal_stem_top", FungalStemTop::new);
    public static final RegistryObject<Block> UNDERWATER_FUNGAL_STEM_TOP = BLOCKS.register("underwater_fungal_stem_top", UnderWaterFungusTop::new);
    public static final RegistryObject<Block> FUNGAL_ROOTS = BLOCKS.register("fungal_roots", HangingRoots::new);
    public static final RegistryObject<Block> GROWTH_MYCELIUM = BLOCKS.register("growth_mycelium", () -> new GenericFoliageBlock( BlockBehaviour.Properties.of().sound(SoundType.CROP).strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.CROP)
            .lightLevel(s -> 2).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)));
    public static final RegistryObject<Block> WALL_GROWTHS = BLOCKS.register("wall_growths", WallFolliage::new);
    public static final RegistryObject<Block> WALL_GROWTHS_BIG = BLOCKS.register("wall_growths_big", WallFolliage::new);
    public static final RegistryObject<Block> MYCELIUM_VEINS = BLOCKS.register("mycelium_veins", MyceliumVeins::new);

    public static final RegistryObject<Block> INFESTED_DIRT = BLOCKS.register("infested_dirt", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.COARSE_DIRT)));
    public static final RegistryObject<Block> INFESTED_STONE = BLOCKS.register("infested_stone", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> INFESTED_NETHERRACK = BLOCKS.register("infested_netherrack", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)));
    public static final RegistryObject<Block> INFESTED_SOUL_SAND = BLOCKS.register("infested_soul_sand", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.SOUL_SAND)));
    public static final RegistryObject<Block> INFESTED_END_STONE = BLOCKS.register("infested_end_stone", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)));
    public static final RegistryObject<Block> INFESTED_SAND = BLOCKS.register("infested_sand", () -> new SelectableFallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> INFESTED_GRAVEL = BLOCKS.register("infested_gravel", () -> new SelectableFallingBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));
    public static final RegistryObject<Block> INFESTED_DEEPSLATE = BLOCKS.register("infested_deepslate", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> INFESTED_RED_SAND = BLOCKS.register("infested_red_sand", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.RED_SAND)));
    public static final RegistryObject<Block> INFESTED_CLAY = BLOCKS.register("infested_clay", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.CLAY)));
    public static final RegistryObject<Block> INFESTED_COBBLESTONE = BLOCKS.register("infested_cobblestone", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> INFESTED_COBBLED_DEEPSLATE = BLOCKS.register("infested_cobbled_deepslate", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)));
    public static final RegistryObject<Block> INFESTED_LABORATORY_BLOCK = BLOCKS.register("infested_laboratory_block", () -> new SelectableBlock(BlockBehaviour.Properties.copy(Sblocks.LAB_BLOCK.get())));



    public static final RegistryObject<Block> ROTTEN_LOG = BLOCKS.register("rotten_log", () -> new FlamableRotatingBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIOMASS_LUMP = BLOCKS.register("biomass_lump", BiomassLump::new);
    public static final RegistryObject<Block> HIVE_SPAWN = BLOCKS.register("hive_spawn", HiveSpawn::new);


    public static final RegistryObject<Block> ORGANITE = BLOCKS.register("organite", OrganiteBlock::new);
    public static final RegistryObject<Block> ROOTED_BIOMASS = BLOCKS.register("rooted_biomass", () -> new Block(BlockBehaviour.Properties.of().strength(2f,2f).sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> BIOMASS_BLOCK = BLOCKS.register("biomass_block", () -> new Block(BlockBehaviour.Properties.of().strength(2f,2f).sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> ROOTED_MYCELIUM = BLOCKS.register("rooted_mycelium", () -> new Block(BlockBehaviour.Properties.of().strength(2f,2f).sound(SoundType.SLIME_BLOCK)));
    public static final RegistryObject<Block> FUNGAL_SHELL = BLOCKS.register("fungal_shell", () -> new Block(BlockBehaviour.Properties.of().strength(20f,6f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> MYCELIUM_BLOCK = BLOCKS.register("mycelium_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(4f,3f).sound(SoundType.BONE_BLOCK)));
    public static final RegistryObject<Block> MYCELIUM_SLAB = BLOCKS.register("mycelium_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Sblocks.MYCELIUM_BLOCK.get())));


    public static final RegistryObject<Block> REMAINS = BLOCKS.register("remains", Remains::new);
}
