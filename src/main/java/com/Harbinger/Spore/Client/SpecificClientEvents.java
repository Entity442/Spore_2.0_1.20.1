package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.AnimationTrackers.PCIAnimationTracker;
import com.Harbinger.Spore.Client.ArmorParts.ComplexHandModelItem;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Spore.MODID, value = Dist.CLIENT)
public class SpecificClientEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            PCIAnimationTracker.tickAll();
        }
    }
    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) return;
        ItemStack stack = player.getItemInHand(event.getHand());
        for (ComplexHandModelItem handModelItem : ArmorModelList.ITEM_RENDERING_BITS){
            if (stack.getItem() instanceof CustomModelArmorData armorData && event.getHand().equals(handModelItem.slot) && stack.getItem().equals(handModelItem.item)){
                handModelItem.renderCustomHand(player,stack, event.getPartialTick(),event.getPackedLight() ,event.getMultiBufferSource(),event.getPoseStack(),armorData.getTextureLocation());
            }
        }
    }
}
