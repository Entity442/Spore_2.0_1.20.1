package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.level.ChunkPos;

import java.util.Comparator;

public class SticketType {
    public static final TicketType<ChunkPos> SPORE_CHUNK_LOADER = TicketType.create(
            Spore.MODID+"chunk_loader",
            Comparator.comparingLong(ChunkPos::toLong)
    );
    public static void init() {
    }
}
