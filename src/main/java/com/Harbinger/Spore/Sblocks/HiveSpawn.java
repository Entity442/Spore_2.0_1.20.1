package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.SBlockEntities.HiveSpawnBlockEntity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
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

public class HiveSpawn extends Block implements EntityBlock {
    public HiveSpawn() {
        super(BlockBehaviour.Properties.of().strength(4f,4f).sound(SoundType.SLIME_BLOCK).randomTicks().noOcclusion().noCollission());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HiveSpawnBlockEntity(pos , state);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState blockState, boolean value) {
        super.onPlace(state, level, pos, blockState, value);
        level.scheduleTick(pos, this, 80);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos blockPos, RandomSource random) {
        BlockEntity entity = level.getBlockEntity(blockPos);
        level.scheduleTick(blockPos, this, 80);
        if (entity != null){
            AABB searchbox = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 50, 50, 50);
            List<Infected> entities = level.getEntitiesOfClass(Infected.class, searchbox);
            for (Entity entity1 : entities) {
                if (entity1 instanceof Infected infected && infected.getKills() > 1 && entity.getPersistentData().getInt("kills") <= SConfig.DATAGEN.hive_spawn_kills.get()) {
                    infected.setSearchPos(blockPos);
                }
            }
            if (entity.getPersistentData().getInt("kills") >= SConfig.DATAGEN.hive_spawn_kills.get() && checkForOtherMinds(blockPos,level)) {
                level.removeBlock(blockPos, true);
                Proto proto = Sentities.PROTO.get().create(level);
                if (proto != null) {
                    if (SConfig.SERVER.proto_chunk.get()) {
                        ChunkLoaderHelper.forceLoadChunksInRadius(level, blockPos, level.getChunk(blockPos).getPos().x, level.getChunk(blockPos).getPos().z, 3);
                    }
                    proto.setPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                    level.addFreshEntity(proto);
                }
                if (!level.isClientSide()){
                    level.getServer().getPlayerList().broadcastSystemMessage(Component.translatable("hivemind_summon_message"), false);
                }
            }else if (entity.getPersistentData().getInt("kills") >= SConfig.DATAGEN.hive_spawn_kills.get() && !checkForOtherMinds(blockPos,level)){
                StructureTemplate template = level.getStructureManager().getOrCreate(new ResourceLocation(Spore.MODID, "mega_biomass_tower"));
                BlockPos pos = new BlockPos(blockPos.getX() - 4, blockPos.getY() - 4, blockPos.getZ() - 4);
                template.placeInWorld(level, pos, pos, new StructurePlaceSettings().setIgnoreEntities(true), random, 3);

            }

        }
    }

    boolean checkForOtherMinds(BlockPos blockPos,Level level){
        int e = SConfig.SERVER.proto_range.get();
        AABB searchbox = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), e, e, e);
        List<Proto> entities = level.getEntitiesOfClass(Proto.class, searchbox);
        for (Entity entity1 : entities) {
            if (entity1 instanceof Proto){
                return false;
            }
        }
        return true;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity != null && entity instanceof Infected infected && infected.getKills() > 1){
            infected.setKills(infected.getKills() -1);
            blockEntity.getPersistentData().putInt("kills",blockEntity.getPersistentData().getInt("kills") + 1);
        }
        super.entityInside(state, level, pos, entity);
    }
}
