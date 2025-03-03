package com.Harbinger.Spore.ExtremelySusThings.Package;

import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import net.minecraft.advancements.Advancement;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RequestAdvancementPacket {
    private final String advancementId;
    private final int id;

    public RequestAdvancementPacket(String advancementId, int id) {
        this.advancementId = advancementId;
        this.id = id;
    }

    public RequestAdvancementPacket(FriendlyByteBuf buffer) {
        this.advancementId = buffer.readUtf();
        this.id = buffer.readInt();
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(advancementId);
        buffer.writeInt(id);
    }

    public static void handle(RequestAdvancementPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            NetworkEvent.Context ctx = context.get();
            ServerPlayer player = ctx.getSender();
            if (player == null) return;
            Entity truePlayer = player.level().getEntity(message.id);
            if (truePlayer instanceof ServerPlayer playerValue){
                MinecraftServer server = playerValue.server;
                Advancement advancement = server.getAdvancements().getAdvancement(new ResourceLocation(message.advancementId));
                if (advancement == null){
                    return;
                }
                // Check if the player has the advancement
                boolean hasAdvancement = playerValue.getAdvancements()
                        .getOrStartProgress(advancement)
                        .isDone();
                // Send response back to client
                SporePacketHandler.sendToClient(new SyncAdvancementPacket(message.advancementId, hasAdvancement), playerValue);
            }
        });
        context.get().setPacketHandled(true);
    }
}