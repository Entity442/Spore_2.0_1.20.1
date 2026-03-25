package com.Harbinger.Spore.ExtremelySusThings.Package;

import com.Harbinger.Spore.ExtremelySusThings.ClientUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
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
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                ClientUtils.handleClient(message);
            });
        });
        context.get().setPacketHandled(true);
    }
}