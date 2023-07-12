package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.SBlockEntities.BiomassLumpEntity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Spore;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BiomassLump extends Block implements EntityBlock {
    public BiomassLump() {
        super(BlockBehaviour.Properties.of().strength(2f,2f).sound(SoundType.SLIME_BLOCK).randomTicks().noOcclusion().noCollission());
    }


    @Override
    public void onPlace(BlockState blockstate, Level level, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, level, pos, oldState, moving);
        level.scheduleTick(pos, this, 40);
    }


    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos blockPos, RandomSource source) {
        BlockEntity entity = level.getBlockEntity(blockPos);
        level.scheduleTick(blockPos, this, 40);
        if (entity != null) {
            AABB searchbox = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 33, 33, 33);
            List<Infected> entities = level.getEntitiesOfClass(Infected.class, searchbox);

            for (Entity entity1 : entities) {
                if (entity1 instanceof Infected infected && infected.getKills() > 1 && entity.getPersistentData().getInt("kills") <= SConfig.DATAGEN.biomass_lump_kills.get()) {
                    infected.setSearchPos(blockPos);
                }
            }
            if (entity.getPersistentData().getInt("kills") >= SConfig.DATAGEN.biomass_lump_kills.get() && (Math.random() < 0.01)) {
            level.destroyBlock(blockPos, false);
            RandomSource random = RandomSource.create();
             if (Math.random() < 0.4) {
               StructureTemplate template = level.getStructureManager().getOrCreate(new ResourceLocation(Spore.MODID, "biomass_tower"));
             BlockPos pos = new BlockPos(blockPos.getX() - 3, blockPos.getY() - 2, blockPos.getZ() - 3);
              template.placeInWorld(level, pos, pos, new StructurePlaceSettings().setIgnoreEntities(true), random, 3);
            } else if (Math.random() < 0.4) {
              StructureTemplate template = level.getStructureManager().getOrCreate(new ResourceLocation(Spore.MODID, "biomass_tower_tall"));
              BlockPos pos = new BlockPos(blockPos.getX() - 3, blockPos.getY() - 1, blockPos.getZ() - 3);
             template.placeInWorld(level, pos, pos, new StructurePlaceSettings().setIgnoreEntities(true), random, 3);
             }
             else {
             StructureTemplate template = level.getStructureManager().getOrCreate(new ResourceLocation(Spore.MODID, "biomass_tower_small"));
             BlockPos pos = new BlockPos(blockPos.getX() - 2, blockPos.getY() - 1, blockPos.getZ() - 2);
             template.placeInWorld(level, pos, pos, new StructurePlaceSettings().setIgnoreEntities(true), random, 3);
             }}}

    }


    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity livingEntity) {
        BlockEntity entity = level.getBlockEntity(pos);
        if (entity != null && livingEntity instanceof Infected infected && infected.getKills() > 1 && entity.getPersistentData().getInt("kills") <= SConfig.DATAGEN.biomass_lump_kills.get()){
            infected.setKills(infected.getKills() - 1);
            entity.getPersistentData().putInt("kills",entity.getPersistentData().getInt("kills") + 1);
        }
        super.entityInside(state, level, pos, livingEntity);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BiomassLumpEntity(pos , state);
    }
}
