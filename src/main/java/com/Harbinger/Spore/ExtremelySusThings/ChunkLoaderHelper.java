package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.Core.SticketType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChunkLoaderHelper {
    public static final Map<String, ChunkLoadRequest> ACTIVE_REQUESTS = new HashMap<>();

    public static void addRequest(ChunkLoadRequest request) {
        ACTIVE_REQUESTS.put(request.getRequestID(), request);
        ServerLevel level = request.getDimension();
        SporeSavedData data = SporeSavedData.getDataLocation(level);
        for (ChunkPos pos : request.getChunkPositionsToLoad()) {
            ChunkLoaderHelper.forceChunk(level, pos);
        }
        data.addRequest(request);
    }

    public static void removeRequest(String requestId) {
        ChunkLoadRequest request = ACTIVE_REQUESTS.remove(requestId);
        if (request != null) {
            ServerLevel level = request.getDimension();
            SporeSavedData data = SporeSavedData.getDataLocation(level);
            for (ChunkPos pos : request.getChunkPositionsToLoad()) {
                ChunkLoaderHelper.unforceChunk(level, pos);
            }
            data.removeRequest(requestId);
        }
    }

    public static void tick() {
        Iterator<Map.Entry<String, ChunkLoadRequest>> iterator = ACTIVE_REQUESTS.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ChunkLoadRequest> entry = iterator.next();
            ChunkLoadRequest request = entry.getValue();

            request.decrementTicksUntilExpiration(1);
            if (request.isExpired() && request.refreshIfOwnerStillPresent(request.getTickAmount())) {
                removeRequest(request.getRequestID());
                iterator.remove();
            }
        }
    }
    public static void forceChunk(ServerLevel level, ChunkPos pos) {
        level.getChunkSource().addRegionTicket(
                SticketType.SPORE_CHUNK_LOADER,
                pos,
                2,
                pos
        );
    }

    public static void unforceChunk(ServerLevel level, ChunkPos pos) {
        level.getChunkSource().removeRegionTicket(
                SticketType.SPORE_CHUNK_LOADER,
                pos,
                2,
                pos
        );
    }
}
