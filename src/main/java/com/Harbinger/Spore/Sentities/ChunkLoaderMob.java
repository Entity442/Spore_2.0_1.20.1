package com.Harbinger.Spore.Sentities;

public interface ChunkLoaderMob {
    String getChunkId();
    boolean shouldLoadChunk();
    int chunkLifeTicks();
}
