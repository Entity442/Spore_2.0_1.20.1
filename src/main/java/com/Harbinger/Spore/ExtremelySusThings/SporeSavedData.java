package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Spore;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

public class SporeSavedData extends SavedData {
    public static final String NAME = Spore.MODID +"_world_data";
    private int amountOfHiveminds = 0;

    public SporeSavedData() {
        super();
    }

    public static void addHivemind(ServerLevel level){
        SporeSavedData data = level.getDataStorage().computeIfAbsent(SporeSavedData::load,SporeSavedData::new,NAME);
        data.amountOfHiveminds++;
        data.setDirty();
    }
    public static void removeHivemind(ServerLevel level){
        SporeSavedData data = level.getDataStorage().computeIfAbsent(SporeSavedData::load,SporeSavedData::new,NAME);
        if (data.amountOfHiveminds > 0){
            data.amountOfHiveminds--;
        }
        data.setDirty();
    }
    public int getAmountOfHiveminds(){
        return amountOfHiveminds;
    }

    public static SporeSavedData getDataLocation(ServerLevel level){
        return level.getDataStorage().get(SporeSavedData::load,NAME);
    }
    public static SporeSavedData load(CompoundTag tag){
        SporeSavedData data = new SporeSavedData();
        if (tag.contains("number_hiveminds",99)){
            data.amountOfHiveminds = tag.getInt("number_hiveminds");
        }
        return data;
    }

    @Override
    public @NotNull CompoundTag save(@NotNull CompoundTag tag) {
        tag.putInt("number_hiveminds",amountOfHiveminds);
        return tag;
    }

}
