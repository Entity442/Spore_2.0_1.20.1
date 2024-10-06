package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Layers.CustomArmorLayer;
import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Client.Renderers.*;
import com.Harbinger.Spore.Core.SMenu;
import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Particles.AcidParticle;
import com.Harbinger.Spore.Particles.BloodParticle;
import com.Harbinger.Spore.Particles.SporeParticle;
import com.Harbinger.Spore.Screens.ContainerScreen;
import com.Harbinger.Spore.Spore;
import com.Harbinger.Spore.sEvents.SItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Spore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    private ClientModEvents() {
    }
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(InfectedModel.LAYER_LOCATION, InfectedModel::createBodyLayer);
        event.registerLayerDefinition(InfectedHuskModel.LAYER_LOCATION, InfectedHuskModel::createBodyLayer);
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
        event.registerLayerDefinition(UsurperModel.LAYER_LOCATION, UsurperModel::createBodyLayer);
        event.registerLayerDefinition(ExplodingBusserModel.LAYER_LOCATION, ExplodingBusserModel::createBodyLayer);
        event.registerLayerDefinition(InfectedDrownModel.LAYER_LOCATION, InfectedDrownModel::createBodyLayer);
        event.registerLayerDefinition(InfectedPlayerModel.LAYER_LOCATION, InfectedPlayerModel::createBodyLayer);
        event.registerLayerDefinition(ScamperModel.LAYER_LOCATION, ScamperModel::createBodyLayer);
        event.registerLayerDefinition(UmarmerModel.LAYER_LOCATION, UmarmerModel::createBodyLayer);
        event.registerLayerDefinition(InfectedHazmatModel.LAYER_LOCATION, InfectedHazmatModel::createBodyLayer);
        event.registerLayerDefinition(ElytrumModel.LAYER_LOCATION, ElytrumModel::createBodyLayer);
        event.registerLayerDefinition(InfectedHazmatWithTank.LAYER_LOCATION, InfectedHazmatWithTank::createBodyLayer);
        event.registerLayerDefinition(WingedChestplate.LAYER_LOCATION, WingedChestplate::createBodyLayer);
        event.registerLayerDefinition(CoreModel.LAYER_LOCATION, CoreModel::createBodyLayer);
        event.registerLayerDefinition(MoundModel.LAYER_LOCATION, MoundModel::createBodyLayer);
        event.registerLayerDefinition(BraionmilBabe.LAYER_LOCATION, BraionmilBabe::createBodyLayer);
        event.registerLayerDefinition(InfectedHazmatCoat.LAYER_LOCATION, InfectedHazmatCoat::createBodyLayer);
        event.registerLayerDefinition(VolatileModel.LAYER_LOCATION, VolatileModel::createBodyLayer);
        event.registerLayerDefinition(BiomassReconstructorModel.LAYER_LOCATION, BiomassReconstructorModel::createBodyLayer);
        event.registerLayerDefinition(VigilModel.LAYER_LOCATION, VigilModel::createBodyLayer);
        event.registerLayerDefinition(GasMaskModel.LAYER_LOCATION, GasMaskModel::createBodyLayer);
        event.registerLayerDefinition(BileRound.LAYER_LOCATION, BileRound::createBodyLayer);
        event.registerLayerDefinition(LivingChestplateModel.LAYER_LOCATION, LivingChestplateModel::createBodyLayer);
        event.registerLayerDefinition(ProtoHivemindModel.LAYER_LOCATION, ProtoHivemindModel::createBodyLayer);
        event.registerLayerDefinition(SiegerModel.LAYER_LOCATION, SiegerModel::createBodyLayer);
        event.registerLayerDefinition(GazenbrecherModel.LAYER_LOCATION, GazenbrecherModel::createBodyLayer);
        event.registerLayerDefinition(HowitzerModel.LAYER_LOCATION, HowitzerModel::createBodyLayer);
        event.registerLayerDefinition(SiegerTailModel.LAYER_LOCATION, SiegerTailModel::createBodyLayer);
        event.registerLayerDefinition(LickerModel.LAYER_LOCATION, LickerModel::createBodyLayer);
        event.registerLayerDefinition(HindieModel.LAYER_LOCATION, HindieModel::createBodyLayer);
        event.registerLayerDefinition(LaceratorModel.LAYER_LOCATION, LaceratorModel::createBodyLayer);
        event.registerLayerDefinition(SantaModel.LAYER_LOCATION, SantaModel::createBodyLayer);
        event.registerLayerDefinition(HindenXmaslightsModel.LAYER_LOCATION, HindenXmaslightsModel::createBodyLayer);
        event.registerLayerDefinition(TumoralNukeModel.LAYER_LOCATION, TumoralNukeModel::createBodyLayer);
        event.registerLayerDefinition(RightArmModel.LAYER_LOCATION, RightArmModel::createBodyLayer);
        event.registerLayerDefinition(LeftArmModel.LAYER_LOCATION, LeftArmModel::createBodyLayer);
        event.registerLayerDefinition(WendigoModel.LAYER_LOCATION, WendigoModel::createBodyLayer);
        event.registerLayerDefinition(InquisitorModel.LAYER_LOCATION, InquisitorModel::createBodyLayer);
        event.registerLayerDefinition(BrotkatzeModel.LAYER_LOCATION, BrotkatzeModel::createBodyLayer);
        event.registerLayerDefinition(BulletModel.LAYER_LOCATION, BulletModel::createBodyLayer);
        event.registerLayerDefinition(ThornModel.LAYER_LOCATION, ThornModel::createBodyLayer);
        event.registerLayerDefinition(PlaguedModel.LAYER_LOCATION, PlaguedModel::createBodyLayer);
        event.registerLayerDefinition(RangedBusserModel.LAYER_LOCATION, RangedBusserModel::createBodyLayer);
        event.registerLayerDefinition(StingerModel.LAYER_LOCATION, StingerModel::createBodyLayer);
        event.registerLayerDefinition(BraureiModel.LAYER_LOCATION, BraureiModel::createBodyLayer);
        event.registerLayerDefinition(ProtoRedesign.LAYER_LOCATION, ProtoRedesign::createBodyLayer);
        event.registerLayerDefinition(SiegerArrowModel.LAYER_LOCATION, SiegerArrowModel::createBodyLayer);
        event.registerLayerDefinition(DelusionerModel.LAYER_LOCATION, DelusionerModel::createBodyLayer);
        event.registerLayerDefinition(JagdhundModel.LAYER_LOCATION, JagdhundModel::createBodyLayer);
        event.registerLayerDefinition(verwahrungModel.LAYER_LOCATION, verwahrungModel::createBodyLayer);
        event.registerLayerDefinition(RootsModel.LAYER_LOCATION, RootsModel::createBodyLayer);
        event.registerLayerDefinition(GastgeberModel.LAYER_LOCATION, GastgeberModel::createBodyLayer);
        event.registerLayerDefinition(SpecterModel.LAYER_LOCATION, SpecterModel::createBodyLayer);
        event.registerLayerDefinition(OvergrownSpawnerModel.LAYER_LOCATION, OvergrownSpawnerModel::createBodyLayer);
        event.registerLayerDefinition(brainMatterModel.LAYER_LOCATION, brainMatterModel::createBodyLayer);
        event.registerLayerDefinition(ZoaholicModel.LAYER_LOCATION, ZoaholicModel::createBodyLayer);
        event.registerLayerDefinition(IncubatorModel.LAYER_LOCATION, IncubatorModel::createBodyLayer);
        event.registerLayerDefinition(OutpostWatcherModel.LAYER_LOCATION, OutpostWatcherModel::createBodyLayer);
    }




    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Sentities.INF_HUMAN.get(), InfectedHumanRenderer::new);
        event.registerEntityRenderer(Sentities.INF_HUSK.get(), InfectedHuskRenderer::new);
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
        event.registerEntityRenderer(Sentities.VOLATILE.get(), VolatileRenderer::new);
        event.registerEntityRenderer(Sentities.INF_DROWNED.get(), InfectedDrownRenderer::new);
        event.registerEntityRenderer(Sentities.INF_HAZMAT.get(), InfectedHazmatRenderer::new);
        event.registerEntityRenderer(Sentities.INF_PLAYER.get(), InfectedPlayerRenderer::new);
        event.registerEntityRenderer(Sentities.LACERATOR.get(), LaceratorRenderer::new);
        event.registerEntityRenderer(Sentities.THORN.get(), ThornRenderer::new);
        event.registerEntityRenderer(Sentities.SCAMPER.get(), ScamperHumanRenderer::new);
        event.registerEntityRenderer(Sentities.MOUND.get(), MoundRenderer::new);
        event.registerEntityRenderer(Sentities.RECONSTRUCTOR.get(), BiomassReconfiguratorRenderer::new);
        event.registerEntityRenderer(Sentities.PROTO.get(), ProtoRenderer::new);
        event.registerEntityRenderer(Sentities.VIGIL.get(), VigilRenderer::new);
        event.registerEntityRenderer(Sentities.USURPER.get(), UsurperRenderer::new);
        event.registerEntityRenderer(Sentities.UMARMED.get(), UmarmedRenderer::new);
        event.registerEntityRenderer(Sentities.SIEGER.get(), SiegerRenderer::new);
        event.registerEntityRenderer(Sentities.GAZENBREACHER.get(), GazenRenderer::new);
        event.registerEntityRenderer(Sentities.HINDENBURG.get(), HindieRenderer::new);
        event.registerEntityRenderer(Sentities.SIEGER_TAIL.get(), SiegerTailRenderer::new);
        event.registerEntityRenderer(Sentities.LICKER.get(), LickerRenderer::new);
        event.registerEntityRenderer(Sentities.HOWIT_ARM.get(), HowdiArmRenderer::new);
        event.registerEntityRenderer(Sentities.TUMOROID_NUKE.get(), TumoroidNukeRenderer::new);
        event.registerEntityRenderer(Sentities.VERVA.get(), VervaRenderer::new);
        event.registerEntityRenderer(Sentities.WENDIGO.get(), WendigoRenderer::new);
        event.registerEntityRenderer(Sentities.INQUISITOR.get(), InquisitorRenderer::new);
        event.registerEntityRenderer(Sentities.BROTKATZE.get(), BrotkatzeRenderer::new);
        event.registerEntityRenderer(Sentities.JAGD.get(), JagdhundRenderer::new);
        event.registerEntityRenderer(Sentities.PLAGUED.get(), PlaguedRenderer::new);
        event.registerEntityRenderer(Sentities.WAVE.get(), WaveRenderer::new);
        event.registerEntityRenderer(Sentities.ILLUSION.get(), IllusionRenderer::new);
        event.registerEntityRenderer(Sentities.GASTGABER.get(), GastGaverRenderer::new);
        event.registerEntityRenderer(Sentities.SPECTER.get(), SpecterRenderer::new);
        event.registerEntityRenderer(Sentities.HOWITZER.get(), HowitzerRenderer::new);

        event.registerEntityRenderer(Sentities.ACID_BALL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.SPIT.get(), BulletRender::new);
        event.registerEntityRenderer(Sentities.BILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.ACID.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_TUMOR.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.FLESH_BOMB.get(), FleshBombRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_BLOCK.get(), ThrownBlockRenderer::new);
        event.registerEntityRenderer(Sentities.SCENT.get(), ScentEntityRenderer::new);
        event.registerEntityRenderer(Sentities.TENDRIL.get(), TendrilRenderer::new);
        event.registerEntityRenderer(Sentities.STINGER.get(), StingerRenderer::new);
        event.registerEntityRenderer(Sentities.BRAUREI.get(), BraureiRenderer::new);
        event.registerEntityRenderer(Sentities.DELUSIONARE.get(), DelusionareRenderer::new);

        event.registerBlockEntityRenderer(SblockEntities.OVERGROWN_SPAWNER.get(), new OvergrownSpawnerRenderer());
        event.registerBlockEntityRenderer(SblockEntities.BRAIN_REMNANTS.get(), new BrainRemnantsRenderer());
        event.registerBlockEntityRenderer(SblockEntities.ZOAHOLIC.get(), new ZoaholicRenderer());
        event.registerBlockEntityRenderer(SblockEntities.INCUBATOR.get(), new IncubatorRenderer());
        event.registerBlockEntityRenderer(SblockEntities.OUTPOST_WATCHER.get(), new OutpostWatcherRenderer());
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        SItemProperties.addCustomItemProperties();

        event.enqueueWork(() -> {
            MenuScreens.register(SMenu.CONTAINER.get(), ContainerScreen::new);
        });

    }
    @SubscribeEvent
    public static void addLayers(final EntityRenderersEvent.AddLayers event) {
        event.getSkins().forEach(name -> {
            if(event.getSkin(name) instanceof PlayerRenderer renderer) {
                renderer.addLayer(new CustomArmorLayer<>(renderer));
            }
        });
        if (event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer){
            renderer.addLayer(new CustomArmorLayer<>(renderer));
        }
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
