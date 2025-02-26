package com.Harbinger.Spore.ExtremelySusThings.Package;

import com.Harbinger.Spore.ExtremelySusThings.ClientAdvancementTracker;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncAdvancementPacket {
    private final String advancementId;
    private final boolean hasAdvancement;

    public SyncAdvancementPacket(String advancementId, boolean hasAdvancement) {
        this.advancementId = advancementId;
        this.hasAdvancement = hasAdvancement;
    }

    public SyncAdvancementPacket(FriendlyByteBuf buffer) {
        this.advancementId = buffer.readUtf();
        this.hasAdvancement = buffer.readBoolean();
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeUtf(advancementId);
        buffer.writeBoolean(hasAdvancement);
    }

    public static void handle(SyncAdvancementPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            // Update the client-side cache
            ClientAdvancementTracker.setAdvancement(message.advancementId, message.hasAdvancement);
        });
        context.get().setPacketHandled(true);
    }
}