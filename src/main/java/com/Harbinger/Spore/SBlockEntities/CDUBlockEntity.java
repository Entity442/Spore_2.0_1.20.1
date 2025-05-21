package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Screens.CDUMenu;
import com.Harbinger.Spore.Sentities.Utility.InfectionTendril;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CDUBlockEntity extends BlockEntity implements MenuProvider {
    public final int maxFuel = SConfig.DATAGEN.cryo_time.get();
    public int fuel;
    private final List<StoreDouble> blockMap;
    private final List<BlockState> biomass;
    public CDUBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.CDU.get(), pos, state);
        blockMap = fabricateBlocks();
        biomass = stateList();
    }
    record StoreDouble(Block value1, Block value2){}

    private List<StoreDouble> fabricateBlocks(){
        List<StoreDouble> blocks = new ArrayList<>();
        for (String str : SConfig.DATAGEN.block_cleaning.get()){
            String[] string = str.split("\\|" );
            Block blockCon1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0]));
            Block blockCon2 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1]));
            if (blockCon1 != null && blockCon2 != null){
                blocks.add(new StoreDouble(blockCon1,blockCon2));
            }
        }
        return blocks;
    }
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("fuel",this.getFuel());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setFuel(tag.getInt("fuel"));
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    public void setFuel(int i){
        this.fuel = i;
    }
    public int getFuel(){
        return this.fuel;
    }

    public List<BlockState> stateList(){
        List<BlockState> states = new ArrayList<>();
        states.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.MEMBRANE_BLOCK.get().defaultBlockState());
        states.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        states.add(Sblocks.GASTRIC_BIOMASS.get().defaultBlockState());
        states.add(Sblocks.ROOTED_MYCELIUM.get().defaultBlockState());
        return states;
    }
    public void cleanInfection(BlockPos blockPos){
        int range =2* SConfig.DATAGEN.cryo_range.get();
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), range, range, range);
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, aabb);

        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState state = level.getBlockState(blockpos);
            if (state.is(TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(),new ResourceLocation(Spore.MODID,"removable_foliage")))){
                if (Math.random() < 0.2)
                    level.removeBlock(blockpos,false);
            }
            if (Math.random() < 0.2 && !blockMap.isEmpty()){
                for (StoreDouble storeDouble : blockMap){
                    if (storeDouble.value1 == state.getBlock()){
                        level.setBlock(blockpos,storeDouble.value2.defaultBlockState(),3);
                    }
                }
            }
            if (Math.random() < 0.1){
                if (biomass.contains(state)){
                    level.setBlock(blockpos,Sblocks.FROST_BURNED_BIOMASS.get().defaultBlockState(),3);
                }
                if (state == Sblocks.BILE.get().defaultBlockState()){
                    level.setBlock(blockpos,Sblocks.CRUSTED_BILE.get().defaultBlockState(),3);
                }
            }
            if (Math.random() < 0.001 && SConfig.DATAGEN.cryo_snow.get()){
                BlockState blockState1 = level.getBlockState(blockpos.above());
                if (state.isSolidRender(level,blockPos) && blockState1.isAir()){
                    RandomSource randomSource = RandomSource.create();
                    int layer = randomSource.nextInt(1,4);
                    BlockState snowState = Blocks.SNOW.defaultBlockState();
                    if (snowState.getBlock().getStateDefinition().getProperty("layers") instanceof IntegerProperty property)
                        level.setBlock(blockpos.above(),snowState.setValue(property,layer),3);
                }
            }
        }
        for (Entity entity : entities){
            if (entity instanceof LivingEntity livingEntity &&
                    (livingEntity.getType().is(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES))){
                livingEntity.setTicksFrozen(livingEntity.getTicksFrozen()+100);
                livingEntity.hurt(livingEntity.damageSources().freeze(), (float) (SConfig.DATAGEN.cryo_damage.get() *1f));
            }
            if (entity instanceof ScentEntity || entity instanceof InfectionTendril){
                entity.discard();
            }
        }
    }

    public static <E extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, CDUBlockEntity e) {
        if (e.getFuel() > 0 && !level.isClientSide){
            e.fuel--;
            if (e.getFuel() % 100 == 0){
                e.cleanInfection(blockPos);
            }
            if (e.getFuel() % 80 == 0){
                level.playSound(null,blockPos, Ssounds.CDU_AMBIENT.get(), SoundSource.BLOCKS,1,1);
            }
         }
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.spore.cdu");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CDUMenu(i,inventory);
    }
}
