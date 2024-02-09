package com.Harbinger.Spore.SBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LivingStructureBlocks extends BlockEntity {
    int kills;
    public LivingStructureBlocks(BlockEntityType<?> p_155228_, BlockPos pos, BlockState state) {
        super(p_155228_, pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("kills",this.getKills());

    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setKills(tag.getInt("kills"));
    }


    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }


    public void setKills(int i){
        this.kills = i;
    }
    public int getKills(){
        return this.kills;
    }

    public void addKills(){
        this.setKills(this.getKills() + 1);
    }
}
