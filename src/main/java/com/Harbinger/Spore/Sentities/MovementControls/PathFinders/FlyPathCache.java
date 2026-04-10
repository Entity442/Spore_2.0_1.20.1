package com.Harbinger.Spore.Sentities.MovementControls.PathFinders;

import it.unimi.dsi.fastutil.longs.Long2ByteLinkedOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class FlyPathCache {

    private static final int MAX_SIZE = 50_000;
    private static final Long2ByteLinkedOpenHashMap AIR_CACHE = new Long2ByteLinkedOpenHashMap();

    public static boolean isAir(Level level, BlockPos pos) {
        long key = pos.asLong();

        if (AIR_CACHE.containsKey(key)) {
            return AIR_CACHE.get(key) == 1;
        }

        boolean air = level.getBlockState(pos).isAir();
        AIR_CACHE.put(key, (byte)(air ? 1 : 0));

        if (AIR_CACHE.size() > MAX_SIZE) {
            AIR_CACHE.removeFirstByte();
        }

        return air;
    }

    public static void clear() {
        AIR_CACHE.clear();
    }
}