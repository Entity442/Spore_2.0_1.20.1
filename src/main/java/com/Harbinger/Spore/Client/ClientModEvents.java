package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Client.Renderers.*;
import com.Harbinger.Spore.Core.SMenu;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Particles.AcidParticle;
import com.Harbinger.Spore.Particles.BloodParticle;
import com.Harbinger.Spore.Particles.SporeParticle;
import com.Harbinger.Spore.Screens.ContainerScreen;
import com.Harbinger.Spore.Sitems.Elytron;
import com.Harbinger.Spore.Spore;
import com.Harbinger.Spore.sEvents.SItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Spore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    private ClientModEvents() {
    }
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(InfectedModel.LAYER_LOCATION, InfectedModel::createBodyLayer);
        event.registerLayerDefinition(KnightModel.LAYER_LOCATION, KnightModel::createBodyLayer);
        event.registerLayerDefinition(GrieferModel.LAYER_LOCATION, GrieferModel::createBodyLayer);
        event.registerLayerDefinition(BraionmilModel.LAYER_LOCATION, BraionmilModel::createBodyLayer);
        event.registerLayerDefinition(InfectedVillagerModel.LAYER_LOCATION, InfectedVillagerModel::createBodyLayer);
        event.registerLayerDefinition(InfectedWitchModel.LAYER_LOCATION, InfectedWitchModel::createBodyLayer);
        event.registerLayerDefinition(LeaperModel.LAYER_LOCATION, LeaperModel::createBodyLayer);
        event.registerLayerDefinition(SlasherModel.LAYER_LOCATION, SlasherModel::createBodyLayer);
        event.registerLayerDefinition(SpitterModel.LAYER_LOCATION, SpitterModel::createBodyLayer);
        event.registerLayerDefinition(InfectedPillagerModel.LAYER_LOCATION, InfectedPillagerModel::createBodyLayer);
        event.registerLayerDefinition(InfectedVindicatorModel.LAYER_LOCATION, InfectedVindicatorModel::createBodyLayer);
        event.registerLayerDefinition(InfEvoClawModel.LAYER_LOCATION, InfEvoClawModel::createBodyLayer);
        event.registerLayerDefinition(InfectedSpearModel.LAYER_LOCATION, InfectedSpearModel::createBodyLayer);
        event.registerLayerDefinition(InfectedEvokerModel.LAYER_LOCATION, InfectedEvokerModel::createBodyLayer);
        event.registerLayerDefinition(HowlerModel.LAYER_LOCATION, HowlerModel::createBodyLayer);
        event.registerLayerDefinition(InfectedWandererModel.LAYER_LOCATION, InfectedWandererModel::createBodyLayer);
        event.registerLayerDefinition(StalkerModel.LAYER_LOCATION, StalkerModel::createBodyLayer);
        event.registerLayerDefinition(BruteModel.LAYER_LOCATION, BruteModel::createBodyLayer);
        event.registerLayerDefinition(BusserModel.LAYER_LOCATION, BusserModel::createBodyLayer);
        event.registerLayerDefinition(ExplodingBusserModel.LAYER_LOCATION, ExplodingBusserModel::createBodyLayer);
        event.registerLayerDefinition(InfectedDrownModel.LAYER_LOCATION, InfectedDrownModel::createBodyLayer);
        event.registerLayerDefinition(HostModel.LAYER_LOCATION, HostModel::createBodyLayer);
        event.registerLayerDefinition(InfectedPlayerModel.LAYER_LOCATION, InfectedPlayerModel::createBodyLayer);
        event.registerLayerDefinition(ScamperModel.LAYER_LOCATION, ScamperModel::createBodyLayer);
        event.registerLayerDefinition(ElytrumModel.LAYER_LOCATION, ElytrumModel::createBodyLayer);
        event.registerLayerDefinition(WingedChestplate.LAYER_LOCATION, WingedChestplate::createBodyLayer);
        event.registerLayerDefinition(MoundModel.LAYER_LOCATION, MoundModel::createBodyLayer);
        event.registerLayerDefinition(BiomassReconstructorModel.LAYER_LOCATION, BiomassReconstructorModel::createBodyLayer);
        event.registerLayerDefinition(VigilModel.LAYER_LOCATION, VigilModel::createBodyLayer);
        event.registerLayerDefinition(GasMaskModel.LAYER_LOCATION, GasMaskModel::createBodyLayer);
        event.registerLayerDefinition(ProtoHivemindModel.LAYER_LOCATION, ProtoHivemindModel::createBodyLayer);
        event.registerLayerDefinition(SiegerModel.LAYER_LOCATION, SiegerModel::createBodyLayer);
        event.registerLayerDefinition(SiegerTailModel.LAYER_LOCATION, SiegerTailModel::createBodyLayer);
    }




    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Sentities.INF_HUMAN.get(), InfectedHumanRenderer::new);
        event.registerEntityRenderer(Sentities.KNIGHT.get(), KnightRenderer::new);
        event.registerEntityRenderer(Sentities.GRIEFER.get(), GrieferRenderer::new);
        event.registerEntityRenderer(Sentities.BRAIOMIL.get(), BraioRenderer::new);
        event.registerEntityRenderer(Sentities.INF_VILLAGER.get(), InfectedVillagerRenderer::new);
        event.registerEntityRenderer(Sentities.INF_WITCH.get(), InfectedWitchRenderer::new);
        event.registerEntityRenderer(Sentities.LEAPER.get(), LeaperRenderer::new);
        event.registerEntityRenderer(Sentities.SLASHER.get(), SlasherRenderer::new);
        event.registerEntityRenderer(Sentities.SPITTER.get(), SpitterRenderer::new);
        event.registerEntityRenderer(Sentities.INF_PILLAGER.get(), InfectedPillagerRenderer::new);
        event.registerEntityRenderer(Sentities.INF_VINDICATOR.get(), InfectedVindicatorRenderer::new);
        event.registerEntityRenderer(Sentities.CLAW.get(), ClawRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_SPEAR.get(), SpearRenderer::new);
        event.registerEntityRenderer(Sentities.INF_EVOKER.get(), InfectedEvokerRenderer::new);
        event.registerEntityRenderer(Sentities.HOWLER.get(), HowlerRenderer::new);
        event.registerEntityRenderer(Sentities.INF_WANDERER.get(), InfectedWandererRenderer::new);
        event.registerEntityRenderer(Sentities.STALKER.get(), StalkerRenderer::new);
        event.registerEntityRenderer(Sentities.BRUTE.get(), BruteRenderer::new);
        event.registerEntityRenderer(Sentities.BUSSER.get(), BusserRenderer::new);
        event.registerEntityRenderer(Sentities.INF_DROWNED.get(), InfectedDrownRenderer::new);
        event.registerEntityRenderer(Sentities.HOST.get(), HostRenderer::new);
        event.registerEntityRenderer(Sentities.INF_PLAYER.get(), InfectedPlayerRenderer::new);
        event.registerEntityRenderer(Sentities.SCAMPER.get(), ScamperHumanRenderer::new);
        event.registerEntityRenderer(Sentities.MOUND.get(), MoundRenderer::new);
        event.registerEntityRenderer(Sentities.RECONSTRUCTOR.get(), BiomassReconfiguratorRenderer::new);
        event.registerEntityRenderer(Sentities.PROTO.get(), ProtoRenderer::new);
        event.registerEntityRenderer(Sentities.VIGIL.get(), VigilRenderer::new);
        event.registerEntityRenderer(Sentities.SIEGER.get(), SiegerRenderer::new);
        event.registerEntityRenderer(Sentities.SIEGER_TAIL.get(), SiegerTailRenderer::new);


        event.registerEntityRenderer(Sentities.ACID_BALL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.ACID.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_TUMOR.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.SCENT.get(), ScentEntityRenderer::new);
        event.registerEntityRenderer(Sentities.TENDRIL.get(), TendrilRenderer::new);


    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {


        SItemProperties.addCustomItemProperties();

        event.enqueueWork(() -> {
            MenuScreens.register(SMenu.CONTAINER.get(), ContainerScreen::new);
        });

    }

    public static <T extends Item> Supplier<T> getElytraItem() {
        return () -> (T) new Elytron.InfectedElytron();
    }

    @SubscribeEvent
    public static void registerParticle(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(Sparticles.SPORE_PARTICLE.get(),
                SporeParticle.Provider::new);

        Minecraft.getInstance().particleEngine.register(Sparticles.ACID_PARTICLE.get(),
                AcidParticle.Provider::new);

        Minecraft.getInstance().particleEngine.register(Sparticles.BLOOD_PARTICLE.get(),
                BloodParticle.Provider::new);
    }

}
