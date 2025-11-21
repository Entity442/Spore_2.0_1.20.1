package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Sentities.EvolvedInfected.Protector;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SporeSavedData extends SavedData {
    public static final Map<String, ChunkLoadRequest> activeRequests = new HashMap<>();
    public static final String NAME = Spore.MODID +"_world_data";
    private static final List<Protector> protectorList = new ArrayList<>();
    private static final List<Proto> protos = new ArrayList<>();
    public static void addProtector(Protector protector){
        protectorList.add(protector);
    }
    public static void removeProtector(Protector protector){
        protectorList.remove(protector);
    }
    public static List<Protector> protectorList(){
        return protectorList;
    }
    public static void addProto(Proto protector){
        protos.add(protector);
    }
    public static void removeProto(Proto protector){
        protos.remove(protector);
    }
    public static List<Proto> getHiveminds(){
        return protos;
    }

    public SporeSavedData() {
        super();
    }

    public int getAmountOfHiveminds(){
        return protos.size();
    }

    public static void StartupData(ServerLevel level){
        SporeSavedData data = level.getDataStorage().computeIfAbsent(
                SporeSavedData::load
                ,SporeSavedData::new
                ,NAME);
        data.setDirty();
    }

    public static SporeSavedData getDataLocation(ServerLevel level){
        return level.getDataStorage().get(SporeSavedData::load,NAME);
    }

    public static SporeSavedData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                SporeSavedData::load,
                SporeSavedData::new,
                NAME
        );
    }

    public void addRequest(ChunkLoadRequest request) {
        activeRequests.put(request.getRequestID(), request);
        setDirty();
    }

    public void removeRequest(String id) {
        activeRequests.remove(id);
        setDirty();
    }

    public Collection<ChunkLoadRequest> getRequests() {
        return activeRequests.values();
    }

    public static SporeSavedData load(CompoundTag tag){
        SporeSavedData data = new SporeSavedData();
        if (tag.contains("ChunkRequests", 9)) { // 9 = ListTag
            var list = tag.getList("ChunkRequests", 10);
            for (int i = 0; i < list.size(); i++) {
                CompoundTag entry = list.getCompound(i);
                ChunkLoadRequest request = ChunkLoadRequest.deserializeNBT(entry);
                activeRequests.put(request.getRequestID(), request);
            }
        }
        return data;
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag tag) {
        var listTag = new net.minecraft.nbt.ListTag();
        for (ChunkLoadRequest request : activeRequests.values()) {
            listTag.add(request.serializeNBT());
        }
        tag.put("ChunkRequests", listTag);
        return tag;
    }

}
