package com.Harbinger.Spore.ExtremelySusThings.Package;
import com.Harbinger.Spore.Screens.GraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenGraftingScreenPacket {
    private final BlockPos pos;

    public OpenGraftingScreenPacket(BlockPos pos) {
        this.pos = pos;
    }

    public OpenGraftingScreenPacket(FriendlyByteBuf friendlyByteBuf) {
        pos = BlockPos.ZERO;
    }

    public static void encode(OpenGraftingScreenPacket msg, FriendlyByteBuf buf) {
        buf.writeBlockPos(msg.pos);
    }

    public static OpenGraftingScreenPacket decode(FriendlyByteBuf buf) {
        return new OpenGraftingScreenPacket(buf.readBlockPos());
    }

    public static void handle(OpenGraftingScreenPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            if (player != null) {
                var be = player.level().getBlockEntity(msg.pos);
                if (be instanceof com.Harbinger.Spore.SBlockEntities.SurgeryTableBlockEntity table) {
                    net.minecraftforge.network.NetworkHooks.openScreen(
                            player,
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
