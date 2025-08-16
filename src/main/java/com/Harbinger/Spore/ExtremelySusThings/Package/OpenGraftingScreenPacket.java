package com.Harbinger.Spore.ExtremelySusThings.Package;
import com.Harbinger.Spore.Screens.GraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenGraftingScreenPacket {
    private final BlockPos pos;
    private final int id;
    public OpenGraftingScreenPacket(BlockPos pos,int playerId) {
        this.pos = pos;
        this.id = playerId;
    }

    public OpenGraftingScreenPacket(FriendlyByteBuf friendlyByteBuf) {
        this.pos = friendlyByteBuf.readBlockPos();
        this.id = friendlyByteBuf.readInt();
    }

    public static void encode(OpenGraftingScreenPacket msg, FriendlyByteBuf buf) {
        buf.writeBlockPos(msg.pos);
        buf.writeInt(msg.id);
    }

    public static void handle(OpenGraftingScreenPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                Entity truePlayer = player.level().getEntity(msg.id);
                BlockEntity be = player.level().getBlockEntity(msg.pos);
                if (be instanceof com.Harbinger.Spore.SBlockEntities.SurgeryTableBlockEntity table && truePlayer instanceof ServerPlayer trueP) {
                    net.minecraftforge.network.NetworkHooks.openScreen(
                            trueP,
                            new MenuProvider() {
                                @Override
                                public Component getDisplayName() {
                                    return Component.translatable("block.spore.surgery_table");
                                }

                                @Override
                                public AbstractContainerMenu createMenu(int id, Inventory inv, Player ply) {
                                    return new GraftingMenu(id, inv, table, table.data);
                                }
                            },
                            buf -> buf.writeBlockPos(msg.pos)
                    );
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }

}
