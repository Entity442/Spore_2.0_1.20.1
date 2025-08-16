package com.Harbinger.Spore.ExtremelySusThings;

import com.Harbinger.Spore.ExtremelySusThings.Package.AdvancementGivingPackage;
import com.Harbinger.Spore.ExtremelySusThings.Package.OpenGraftingScreenPacket;
import com.Harbinger.Spore.ExtremelySusThings.Package.RequestAdvancementPacket;
import com.Harbinger.Spore.ExtremelySusThings.Package.SyncAdvancementPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.concurrent.atomic.AtomicInteger;

public class SporePacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("spore", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static final AtomicInteger packetId = new AtomicInteger(0);

    public static void registerPackets() {
        INSTANCE.messageBuilder(RequestAdvancementPacket.class, packetId.getAndIncrement())
                .encoder(RequestAdvancementPacket::encode)
                .decoder(RequestAdvancementPacket::new)
                .consumerMainThread(RequestAdvancementPacket::handle)
                .add();

        INSTANCE.messageBuilder(SyncAdvancementPacket.class, packetId.getAndIncrement())
                .encoder(SyncAdvancementPacket::encode)
                .decoder(SyncAdvancementPacket::new)
                .consumerMainThread(SyncAdvancementPacket::handle)
                .add();
        INSTANCE.messageBuilder(AdvancementGivingPackage.class, packetId.getAndIncrement())
                .encoder(AdvancementGivingPackage::encode)
                .decoder(AdvancementGivingPackage::new)
                .consumerMainThread(AdvancementGivingPackage::handle)
                .add();
        INSTANCE.messageBuilder(OpenGraftingScreenPacket.class, packetId.getAndIncrement())
                .encoder(OpenGraftingScreenPacket::encode)
                .decoder(OpenGraftingScreenPacket::new)
                .consumerMainThread(OpenGraftingScreenPacket::handle)
                .add();
    }
    public static <T> void sendToServer(T packet) {
        INSTANCE.sendToServer(packet);
    }

    public static <T> void sendToClient(T packet, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }
}