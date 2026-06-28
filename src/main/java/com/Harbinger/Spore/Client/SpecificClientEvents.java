package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.AnimationTrackers.*;
import com.Harbinger.Spore.Client.ArmorParts.ComplexHandModelItem;
import com.Harbinger.Spore.Client.MusicManager.MenuMusicPlayer;
import com.Harbinger.Spore.Client.MusicManager.SporeMusicPlayer;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.ExtremelySusThings.Package.SporeGunFirePacket;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Sitems.Guns.AbstractSporeGun;
import com.Harbinger.Spore.Sitems.Guns.AcidicAssasin;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
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
            TerroriserShootAnimationTracker.tickAll();
            TerroriserReloadAnimationTracker.tickAll();
            Minecraft mc = Minecraft.getInstance();
            if (SConfig.SERVER.disable_vanilla.get()){
                Minecraft.getInstance().getMusicManager().stopPlaying();
            }
            if (!SConfig.SERVER.disable_system.get()){
                SporeMusicPlayer.tickMusic();
            }
            if (mc.screen instanceof TitleScreen && SConfig.SERVER.menu_song.get()) {
                MenuMusicPlayer.tick();
            }
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


    public static final ResourceLocation ASSASIN_SCOPE =new ResourceLocation(Spore.MODID,"textures/gui/icons/assassin_scope.png");
    public static final ResourceLocation BILE_OVERLAY =new ResourceLocation(Spore.MODID,"textures/gui/icons/bile_overlay.png");
    public static final ResourceLocation CORROSION_OVERLAY =new ResourceLocation(Spore.MODID,"textures/gui/icons/corrosion_overlay.png");
    public static final ResourceLocation MADNESS_OVERLAY =new ResourceLocation(Spore.MODID,"textures/gui/icons/madness_overlay.png");
    public static final ResourceLocation MYCELIUM_INFECTION_OVERLAY =new ResourceLocation(Spore.MODID,"textures/gui/icons/mycelium_infection_overlay.png");
    public static final ResourceLocation TAR_OVERLAY =new ResourceLocation(Spore.MODID,"textures/gui/icons/tar_overlay.png");
    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || !SConfig.SERVER.activeOverlays.get()){
            return;
        }
        GuiGraphics guiGraphics = event.getGuiGraphics();
        int screenWidth = guiGraphics.guiWidth();
        int screenHeight = guiGraphics.guiHeight();

        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() instanceof AcidicAssasin) {
            if (player.isShiftKeyDown()) {
                renderOverlay(event,screenWidth,screenHeight,ASSASIN_SCOPE,false,0);
            }
        }
        MobEffectInstance biled = player.getEffect(Seffects.BILED.get());
        MobEffectInstance corroded = player.getEffect(Seffects.CORROSION.get());
        MobEffectInstance madness = player.getEffect(Seffects.MADNESS.get());
        MobEffectInstance mycelium = player.getEffect(Seffects.MYCELIUM.get());
        MobEffectInstance tar = player.getEffect(Seffects.IGNITABLE.get());
        if (biled != null){
            renderOverlay(event,screenWidth,screenHeight,BILE_OVERLAY,true,biled.getDuration());
        }
        if (corroded != null){
            renderOverlay(event,screenWidth,screenHeight,CORROSION_OVERLAY,true,corroded.getDuration());
        }
        if (madness != null){
            renderOverlay(event,screenWidth,screenHeight,MADNESS_OVERLAY,true,madness.getDuration());
        }
        if (mycelium != null){
            renderOverlay(event,screenWidth,screenHeight,MYCELIUM_INFECTION_OVERLAY,true,mycelium.getDuration());
        }
        if (tar != null){
            renderOverlay(event,screenWidth,screenHeight,TAR_OVERLAY,true,tar.getDuration());
        }
    }

    protected static void renderOverlay(RenderGuiEvent.Pre event,int w,int h,ResourceLocation location,boolean fade,int i){
        float alpha = 1;
        if (fade && i <= 100){
            alpha = i * 0.01f;
        }
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.setShaderColor(1, 1, 1, alpha);
        event.getGuiGraphics().blit(location, 0, 0, 0, 0, w, h, w, h);
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1, 1, 1, alpha);
    }
}
