package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.SBlockEntities.BrainRemnantBlockEntity;
import com.Harbinger.Spore.SBlockEntities.HiveSpawnBlockEntity;
import com.Harbinger.Spore.SBlockEntities.LivingStructureBlocks;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HiveSpawn extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public HiveSpawn() {
        super(BlockBehaviour.Properties.of().strength(4f,4f).sound(SoundType.SLIME_BLOCK).randomTicks().noOcclusion().noCollission());
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HiveSpawnBlockEntity(pos , state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
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
        if (entity instanceof LivingStructureBlocks structureBlocks){
            AABB searchbox = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), 50, 50, 50);
            List<Infected> entities = level.getEntitiesOfClass(Infected.class, searchbox);
            for (Entity entity1 : entities) {
                if (entity1 instanceof Infected infected && infected.getKills() > 1 && structureBlocks.getKills() <= SConfig.DATAGEN.hive_spawn_kills.get()) {
                    infected.setSearchPos(blockPos);
                }
            }
            if (structureBlocks.getKills() >= SConfig.DATAGEN.hive_spawn_kills.get() && checkForOtherMinds(blockPos,level)) {
                level.removeBlock(blockPos, true);
                Proto proto = Sentities.PROTO.get().create(level);
                if (proto != null) {
                    proto.tickEmerging();
                    proto.setPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                    proto.loadChunks();
                    if (SConfig.SERVER.teleport_hive.get()){
                        Proto.teleportToSurface(level,proto);
                    }
                    level.addFreshEntity(proto);
                }
                for(ServerPlayer player : level.getServer().getPlayerList().getPlayers()){
                    player.playNotifySound(Ssounds.REBIRTH.get(),SoundSource.AMBIENT,1f,1f);
                    player.displayClientMessage(Component.translatable("hivemind_summon_message"), false);
                }
            }else if (structureBlocks.getKills() >= SConfig.DATAGEN.hive_spawn_kills.get() && !checkForOtherMinds(blockPos,level)){
                StructureTemplate template = level.getStructureManager().getOrCreate(new ResourceLocation(Spore.MODID, "mega_biomass_tower"));
                BlockPos pos = new BlockPos(blockPos.getX() - 4, blockPos.getY() - 3, blockPos.getZ() - 4);
                template.placeInWorld(level, pos, pos, new StructurePlaceSettings().setIgnoreEntities(true), random, 3);

            }

        }
    }

    boolean checkForOtherMinds(BlockPos blockPos,Level level){
        int e = SConfig.DATAGEN.hive_generate.get();
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
        if (blockEntity instanceof LivingStructureBlocks structureBlocks && entity instanceof Infected infected && infected.getKills() > 1){
            infected.setKills(infected.getKills() -1);
            structureBlocks.addKills();
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(WATERLOGGED);
    }
    public PushReaction getPistonPushReaction(BlockState p_153494_) {
        return PushReaction.PUSH_ONLY;
    }


    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153274_, BlockEntityType<T> type) {
        return createBrainTicker(level, type, SblockEntities.HIVE_SPAWN.get());
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createBrainTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends HiveSpawnBlockEntity> p_151990_) {
        return level.isClientSide ? createTickerHelper(type, p_151990_, HiveSpawnBlockEntity::clientTick) : null;
    }
}
