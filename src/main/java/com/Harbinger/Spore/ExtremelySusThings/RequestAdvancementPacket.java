package com.Harbinger.Spore.ExtremelySusThings;

import net.minecraft.advancements.Advancement;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RequestAdvancementPacket {
    private final String advancementId;

    public RequestAdvancementPacket(String advancementId) {
        this.advancementId = advancementId;
    }

    public RequestAdvancementPacket(FriendlyByteBuf buffer) {
        this.advancementId = buffer.readUtf();
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(advancementId);
    }

    public static void handle(RequestAdvancementPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            NetworkEvent.Context ctx = context.get();
            ServerPlayer player = ctx.getSender();
            if (player == null) return;
            MinecraftServer server = player.server;
            Advancement advancement = server.getAdvancements().getAdvancement(new ResourceLocation(message.advancementId));
            if (advancement == null){
                return;
            }

            // Check if the player has the advancement
            boolean hasAdvancement = player.getAdvancements()
                    .getOrStartProgress(advancement)
                    .isDone();

            // Send response back to client
            SporePacketHandler.sendToClient(new SyncAdvancementPacket(message.advancementId, hasAdvancement), player);
        });
        context.get().setPacketHandled(true);
    }
}