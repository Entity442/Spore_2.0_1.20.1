package com.Harbinger.Spore.Client.AnimationTrackers;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class SGAnimationTracker {
    private static final Map<UUID, Integer> animationTicks = new HashMap<>();

    public static void trigger(Player player) {
        animationTicks.put(player.getUUID(), 10);
    }

    public static float getProgress(Player player, float partialTicks) {
        int ticks = animationTicks.getOrDefault(player.getUUID(), 0);
        return Math.max(0f, ticks - partialTicks) / 10f;
    }

    public static void tickAll() {
        animationTicks.replaceAll((uuid, ticks) -> Math.max(0, ticks - 1));
    }
}
