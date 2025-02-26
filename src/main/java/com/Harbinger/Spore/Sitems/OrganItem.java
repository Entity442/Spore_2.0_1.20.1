package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.ExtremelySusThings.ClientAdvancementTracker;
import com.Harbinger.Spore.ExtremelySusThings.RequestAdvancementPacket;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
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

    private boolean hasAdvancement(Player player, MinecraftServer server) {
        Advancement advancement = getStoredAdvancement(server);
        if (advancement == null){
            return false;
        }
        if (player instanceof ServerPlayer serverPlayer && serverPlayer.level() instanceof ServerLevel) {
            return serverPlayer.getAdvancements().getOrStartProgress(advancement).isDone();
        }
        return false;
    }

    public void giveAdvancement(ServerPlayer player) {
        MinecraftServer server = player.getServer();
        if (server == null) {
            return;
        }

        Advancement advancement = getStoredAdvancement(server);
        if (advancement == null) {
            return;
        }

        AdvancementProgress progress = player.getAdvancements().getOrStartProgress(advancement);
        if (!progress.isDone()) {
            for (String criterion : progress.getRemainingCriteria()) {
                player.getAdvancements().award(advancement, criterion);
            }
        }
    }

    @Nullable
    private Advancement getStoredAdvancement(MinecraftServer server) {
        return server.getAdvancements().getAdvancement(new ResourceLocation(advancementIds));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
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
            list.add(Component.translatable("spore.scanner.organ.default").withStyle(ChatFormatting.GRAY));
        }
        SporePacketHandler.sendToServer(new RequestAdvancementPacket(advancementIds));
    }
}