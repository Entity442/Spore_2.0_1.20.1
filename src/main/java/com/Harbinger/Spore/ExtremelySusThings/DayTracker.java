package com.Harbinger.Spore.ExtremelySusThings;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DayTracker {
    private static final int TICKS_PER_DAY = 24000; // 1 Minecraft day

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            MinecraftServer server = event.getServer();
            ServerLevel overworld = server.overworld(); // Get the main world (dimension 0)
            SporeSavedData data = getWorldData(overworld);
            int currentDay = (int) (overworld.getDayTime() / TICKS_PER_DAY);
            if (currentDay > data.getDaysPassed()) {
                data.setDaysPassed(currentDay);
            }
        }
    }

    private static SporeSavedData getWorldData(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(SporeSavedData::load, SporeSavedData::new, "days_data");
    }
}