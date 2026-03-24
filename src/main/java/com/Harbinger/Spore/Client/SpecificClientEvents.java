package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.AnimationTrackers.*;
import com.Harbinger.Spore.Client.ArmorParts.ComplexHandModelItem;
import com.Harbinger.Spore.ExtremelySusThings.Package.SporeGunFirePacket;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Sitems.Guns.AbstractSporeGun;
import com.Harbinger.Spore.Sitems.Guns.AcidicAssasin;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Spore.MODID, value = Dist.CLIENT)
public class SpecificClientEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        handleGunTrigger();
        if (event.phase == TickEvent.Phase.END) {
            PCIAnimationTracker.tickAll();
            SGAnimationTracker.tickAll();
            SGReloadAnimationTracker.tickAll();
            MistMakerSawAnimationTracker.tickAll();
            MistMakerShootAnimationTracker.tickAll();
            BileBlasterShootAnimationTracker.tickAll();
            BileBlasterReloadAnimationTracker.tickAll();
            AssassinShootAnimationTracker.tickAll();
            AssassinReloadAnimationTracker.tickAll();
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
    public static void handleGunTrigger() {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player == null) return;

        if (mc.options.keyAttack.isDown()) {

            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);

            if (stack.getItem() instanceof AbstractSporeGun gun) {

                int shootDelay = getInt(stack, "ShootDelay");
                int reloadDelay = getInt(stack, "ReloadDelay");

                if (shootDelay <= 0 && reloadDelay <= 0
                        && !player.getCooldowns().isOnCooldown(gun)) {

                    SporePacketHandler.sendToServer(
                            new SporeGunFirePacket(player.getId())
                    );
                }
            }
        }
    }
    private static int getInt(ItemStack stack, String key) {
        return stack.getTag() != null && stack.getTag().contains(key)
                ? stack.getTag().getInt(key)
                : 0;
    }
    @SubscribeEvent
    public static void onFovUpdate(ViewportEvent.ComputeFov event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) return;
        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() instanceof AcidicAssasin) {
            if (player.isShiftKeyDown()) {
                float zoomMultiplier = 0.4f;
                event.setFOV(event.getFOV() * zoomMultiplier);
            }
        }
    }
}
