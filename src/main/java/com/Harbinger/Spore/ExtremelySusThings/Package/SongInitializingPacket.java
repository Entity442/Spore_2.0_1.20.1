package com.Harbinger.Spore.ExtremelySusThings.Package;

import com.Harbinger.Spore.Client.MusicManager.SporeMusicPlayer;
import com.Harbinger.Spore.ExtremelySusThings.ClientUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;


public record SongInitializingPacket(int id , boolean val,boolean pro){
    public SongInitializingPacket(FriendlyByteBuf buffer) {
        this(buffer.readInt(),buffer.readBoolean(),buffer.readBoolean());
    }
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(id());
        buffer.writeBoolean(val());
        buffer.writeBoolean(pro());
    }
    public static void handle(SongInitializingPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            if (context.get().getDirection().getReceptionSide().isClient()) {
                SporeMusicPlayer.handlePacket(message.pro(), message.id,message.val);
                System.out.print("Song_Package_Sent");
            }
        });
        context.get().setPacketHandled(true);
    }
}