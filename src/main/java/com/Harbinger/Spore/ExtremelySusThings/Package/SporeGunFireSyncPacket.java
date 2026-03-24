package com.Harbinger.Spore.ExtremelySusThings.Package;

import com.Harbinger.Spore.Sitems.Guns.AbstractSporeGun;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record SporeGunFireSyncPacket(int playerId, int hand){
    public SporeGunFireSyncPacket(FriendlyByteBuf buffer) {
        this(buffer.readInt(),buffer.readInt());
    }
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(playerId);
        buffer.writeInt(hand);
    }
    public static void handle(SporeGunFireSyncPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Player clientPlayer = net.minecraft.client.Minecraft.getInstance().player;
            if (clientPlayer == null) {
                return;
            }
            Level level = clientPlayer.level();
            Entity entity = level.getEntity(message.playerId);
            if (!(entity instanceof Player targetPlayer)) {
                return;
            }

            InteractionHand interactionHand = message.hand == 0 ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
            ItemStack stack = targetPlayer.getItemInHand(interactionHand);

            if (stack.getItem() instanceof AbstractSporeGun gun) {
                gun.clientShoot(targetPlayer, interactionHand);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        context.get().setPacketHandled(true);
    }
}