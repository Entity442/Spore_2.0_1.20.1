package com.Harbinger.Spore.ExtremelySusThings.Package;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;
public class AdvancementGivingPackage {
    private final String advancement;
    private final int id;

    public AdvancementGivingPackage(String advancement, int id) {
        this.advancement = advancement;
        this.id = id;
    }

    public AdvancementGivingPackage(FriendlyByteBuf buffer) {
        this.advancement = buffer.readUtf();
        this.id = buffer.readInt();
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(advancement);
        buffer.writeInt(id); // Fix: Ensure ID is also written
    }

    public static void handle(AdvancementGivingPackage message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            if (player == null) return;

            MinecraftServer server = player.server;
            Advancement advancement = server.getAdvancements().getAdvancement(new ResourceLocation(message.advancement));

            if (advancement == null) {
                System.err.println("[Spore] Advancement not found: " + message.advancement); // Log error
                return;
            }

            AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
            if (progress.isDone()){
                return;
            }
            for (String criterion : progress.getRemainingCriteria()) {
                player.getAdvancements().award(advancement, criterion);
            }
        });
        context.get().setPacketHandled(true);
    }
}