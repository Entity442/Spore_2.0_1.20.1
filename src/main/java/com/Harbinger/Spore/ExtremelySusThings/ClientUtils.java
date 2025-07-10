package com.Harbinger.Spore.ExtremelySusThings;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientUtils {
    public static void spinPlayer(Player player) {
        if (!(player instanceof LocalPlayer localPlayer)) return;

        float currentYaw = localPlayer.getYRot();
        float newYaw = (currentYaw + 10F) % 360;

        localPlayer.setYRot(newYaw);
        localPlayer.setYHeadRot(newYaw);
        localPlayer.yBodyRot = newYaw;
        localPlayer.yHeadRot = newYaw;
    }
}