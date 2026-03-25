package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.ExtremelySusThings.Package.SporeGunFireSyncPacket;
import com.Harbinger.Spore.Sitems.Guns.AbstractSporeGun;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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
    public static void handleClient(SporeGunFireSyncPacket message) {
        Player clientPlayer = Minecraft.getInstance().player;
        if (clientPlayer == null) return;

        Level level = clientPlayer.level();
        Entity entity = level.getEntity(message.playerId());
        if (!(entity instanceof Player targetPlayer)) return;

        InteractionHand hand = message.hand() == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        ItemStack stack = targetPlayer.getItemInHand(hand);

        if (stack.getItem() instanceof AbstractSporeGun gun) {
            gun.clientShoot(targetPlayer, hand);
        }
    }
}