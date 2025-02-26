package com.Harbinger.Spore.ExtremelySusThings.Package;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
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
    }

    public static void handle(AdvancementGivingPackage message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            NetworkEvent.Context ctx = context.get();
            ServerPlayer player = ctx.getSender();
            if (player == null) return;
            Entity playerPresser = player.level().getEntity(message.id);
            MinecraftServer server = player.server;
            Advancement advancement = server.getAdvancements().getAdvancement(new ResourceLocation(message.advancement));
            if (advancement == null){
                return;
            }
            AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
            if (!progress.isDone() && playerPresser instanceof ServerPlayer serverPlayer) {
                for (String criterion : progress.getRemainingCriteria()) {
                    serverPlayer.getAdvancements().award(advancement, criterion);
                }
            }
        });
        context.get().setPacketHandled(true);
    }
}
