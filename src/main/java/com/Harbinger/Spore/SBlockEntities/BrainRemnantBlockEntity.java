package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.UUID;

public class BrainRemnantBlockEntity extends BlockEntity implements AnimatedEntity{
    public int ticks;
    private int time = 0;
    private UUID attacker = null;
    private String source = null;
    public BrainRemnantBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.BRAIN_REMNANTS.get(), pos, state);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setTime(tag.getInt("time"));
        if (tag.contains("source")){
            this.setSource(tag.getString("source"));
        }
        if (tag.contains("attacked")){
            this.setUUID(tag.getUUID("attacker"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("time",this.getTime());
        if (source != null){
            tag.putString("source", source);
        }
        if (attacker != null){
            tag.putUUID("attacker", attacker);
        }

    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public UUID getUUID(){return attacker;}
    public void setUUID(UUID value){this.attacker = value;}
    public String getSource(){return source;}
    public void setSource(DamageSource source){this.source = source.toString();}
    public void setSource(String source){this.source = source;}


    public void addTime(){
        this.setTime(this.getTime()+1);
    }

    public static <E extends BrainRemnantBlockEntity> void serverTick(Level level, BlockPos pos, BlockState state, E e) {
        tick(level,pos,state,e);
    }

    public static <E extends BrainRemnantBlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        if (e.ticks <= 720){
            e.ticks++;
        }else{
            e.ticks = 0;
        }
    }



    public static void tick(Level level, BlockPos pos, BlockState state, BrainRemnantBlockEntity entity){
        if (entity.getUUID() != null || entity.getSource() != null){
            if (entity.time < 2400){
                entity.addTime();
            }else{
                entity.contact(level,pos);
                entity.setTime(0);
            }
        }
    }


    private void contact(Level level1,BlockPos blockPos){
        int range = SConfig.SERVER.proto_range.get();
        AABB aabb = AABB.ofSize(new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ()), range, range, range);
        List<LivingEntity> entities = level1.getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity living : entities){
            if (living instanceof Proto proto){
                proto.addTargets(this.getUUID());
            }
        }
        this.attacker = null;
        this.source = null;
    }
    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    @Override
    public int getTicks() {
        return ticks;
    }
}
