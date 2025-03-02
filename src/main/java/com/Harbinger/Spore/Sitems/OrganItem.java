package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.ExtremelySusThings.ClientAdvancementTracker;
import com.Harbinger.Spore.ExtremelySusThings.Package.RequestAdvancementPacket;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OrganItem extends BaseItem {
    private final String info;
    private final String advancementIds;

    public OrganItem(Properties properties, String value, String advancementId) {
        super(properties);
        this.info = value;
        this.advancementIds = advancementId;
    }

    public String getAdvancementIds() {
        return advancementIds;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, list, tooltipFlag);
        if (level == null || !level.isClientSide) {
            return;
        }
        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        MinecraftServer server = Minecraft.getInstance().getSingleplayerServer();
        if (server == null) {
            return;
        }
        if (ClientAdvancementTracker.hasAdvancement(advancementIds)) {
            list.add(Component.translatable(info).withStyle(ChatFormatting.GOLD));
        } else {
            list.add(Component.translatable("spore.scanner.organ.default").withStyle(ChatFormatting.RED));
        }
        SporePacketHandler.sendToServer(new RequestAdvancementPacket(advancementIds));
    }
}