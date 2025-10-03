package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Layers.CustomArmorLayer;
import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Client.Models.NukeParts.BombFunnelModel;
import com.Harbinger.Spore.Client.Models.NukeParts.FireDiskModel;
import com.Harbinger.Spore.Client.Models.NukeParts.MushroomExplosionTop;
import com.Harbinger.Spore.Client.Renderers.*;
import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Particles.*;
import com.Harbinger.Spore.Screens.*;
import com.Harbinger.Spore.Sitems.Agents.AbstractSyringe;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import com.Harbinger.Spore.Spore;
import com.Harbinger.Spore.sEvents.SItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

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
        event.registerLayerDefinition(InfectedHazmatWithTank.LAYER_LOCATION, InfectedHazmatWithTank::createBodyLayer);
        event.registerLayerDefinition(MoundModel.LAYER_LOCATION, MoundModel::createBodyLayer);
        event.registerLayerDefinition(BraionmilBabe.LAYER_LOCATION, BraionmilBabe::createBodyLayer);
        event.registerLayerDefinition(InfectedHazmatCoat.LAYER_LOCATION, InfectedHazmatCoat::createBodyLayer);
        event.registerLayerDefinition(VolatileModel.LAYER_LOCATION, VolatileModel::createBodyLayer);
        event.registerLayerDefinition(WombModel.LAYER_LOCATION, WombModel::createBodyLayer);
        event.registerLayerDefinition(VigilModel.LAYER_LOCATION, VigilModel::createBodyLayer);
        event.registerLayerDefinition(VigilSignModel.LAYER_LOCATION, VigilSignModel::createBodyLayer);
        event.registerLayerDefinition(GasMaskModel.LAYER_LOCATION, GasMaskModel::createBodyLayer);
        event.registerLayerDefinition(BileRound.LAYER_LOCATION, BileRound::createBodyLayer);
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
        event.registerLayerDefinition(InfestedContructModel.LAYER_LOCATION, InfestedContructModel::createBodyLayer);
        event.registerLayerDefinition(BrokenIronGolemModel.LAYER_LOCATION, BrokenIronGolemModel::createBodyLayer);
        event.registerLayerDefinition(OvergrownSpawnerModel.LAYER_LOCATION, OvergrownSpawnerModel::createBodyLayer);
        event.registerLayerDefinition(brainMatterModel.LAYER_LOCATION, brainMatterModel::createBodyLayer);
        event.registerLayerDefinition(ZoaholicModel.LAYER_LOCATION, ZoaholicModel::createBodyLayer);
        event.registerLayerDefinition(IncubatorModel.LAYER_LOCATION, IncubatorModel::createBodyLayer);
        event.registerLayerDefinition(OutpostWatcherModel.LAYER_LOCATION, OutpostWatcherModel::createBodyLayer);
        event.registerLayerDefinition(BrainTentacleModel.LAYER_LOCATION, BrainTentacleModel::createBodyLayer);
        event.registerLayerDefinition(ArenaTendrilModel.LAYER_LOCATION, ArenaTendrilModel::createBodyLayer);
        event.registerLayerDefinition(OgreModel.LAYER_LOCATION, OgreModel::createBodyLayer);
        event.registerLayerDefinition(BloaterModel.LAYER_LOCATION, BloaterModel::createBodyLayer);
        event.registerLayerDefinition(ScavengerModel.LAYER_LOCATION, ScavengerModel::createBodyLayer);
        event.registerLayerDefinition(ProtoChritsmasHat.LAYER_LOCATION, ProtoChritsmasHat::createBodyLayer);
        event.registerLayerDefinition(NuckelaveModel.LAYER_LOCATION, NuckelaveModel::createBodyLayer);
        event.registerLayerDefinition(NuckelaveArmorModel.LAYER_LOCATION, NuckelaveArmorModel::createBodyLayer);
        event.registerLayerDefinition(WombModelStageIII.LAYER_LOCATION, WombModelStageIII::createBodyLayer);
        event.registerLayerDefinition(WombModelStageII.LAYER_LOCATION, WombModelStageII::createBodyLayer);
        event.registerLayerDefinition(ScamperVillagerModel.LAYER_LOCATION, ScamperVillagerModel::createBodyLayer);
        event.registerLayerDefinition(DrownedScamperModel.LAYER_LOCATION, DrownedScamperModel::createBodyLayer);
        event.registerLayerDefinition(HevokerModel.LAYER_LOCATION, HevokerModel::createBodyLayer);
        event.registerLayerDefinition(HevokerModelDead.LAYER_LOCATION, HevokerModelDead::createBodyLayer);
        event.registerLayerDefinition(DetasheHyperClaw.LAYER_LOCATION, DetasheHyperClaw::createBodyLayer);
        event.registerLayerDefinition(hVindicatorModel.LAYER_LOCATION, hVindicatorModel::createBodyLayer);
        event.registerLayerDefinition(TentacleSegmentModel.LAYER_LOCATION, TentacleSegmentModel::createBodyLayer);
        event.registerLayerDefinition(ReconstructedMindModel.LAYER_LOCATION, ReconstructedMindModel::createBodyLayer);
        event.registerLayerDefinition(hohlfresserHeadModel.LAYER_LOCATION, hohlfresserHeadModel::createBodyLayer);
        event.registerLayerDefinition(WormSegmentModel.LAYER_LOCATION, WormSegmentModel::createBodyLayer);
        event.registerLayerDefinition(WormTailModel.LAYER_LOCATION, WormTailModel::createBodyLayer);
        event.registerLayerDefinition(ExperimentDormantLayerModel.LAYER_LOCATION, ExperimentDormantLayerModel::createBodyLayer);
        event.registerLayerDefinition(BiobloobModel.LAYER_LOCATION, BiobloobModel::createBodyLayer);
        event.registerLayerDefinition(ElytrumModel.LAYER_LOCATION, ElytrumModel::createBodyLayer);
        event.registerLayerDefinition(PCI_Model.LAYER_LOCATION, PCI_Model::createBodyLayer);
        event.registerLayerDefinition(PCI_ModelL.LAYER_LOCATION, PCI_ModelL::createBodyLayer);
        event.registerLayerDefinition(livingArmorMkModel.LAYER_LOCATION, livingArmorMkModel::createBodyLayer);
        event.registerLayerDefinition(ProtectorModel.LAYER_LOCATION, ProtectorModel::createBodyLayer);
        event.registerLayerDefinition(InebriaterModel.LAYER_LOCATION, InebriaterModel::createBodyLayer);
        event.registerLayerDefinition(SauglingModel.LAYER_LOCATION, SauglingModel::createBodyLayer);
        event.registerLayerDefinition(SmasherSlasherModel.LAYER_LOCATION, SmasherSlasherModel::createBodyLayer);
        event.registerLayerDefinition(HohlfresserSeg1Model.LAYER_LOCATION, HohlfresserSeg1Model::createBodyLayer);
        event.registerLayerDefinition(HohlfresserSeg2Model.LAYER_LOCATION, HohlfresserSeg2Model::createBodyLayer);
        event.registerLayerDefinition(HohlfresserSeg3Model.LAYER_LOCATION, HohlfresserSeg3Model::createBodyLayer);
        event.registerLayerDefinition(hohlfresserTailModel.LAYER_LOCATION, hohlfresserTailModel::createBodyLayer);
        event.registerLayerDefinition(bansheeHowlerModel.LAYER_LOCATION, bansheeHowlerModel::createBodyLayer);
        event.registerLayerDefinition(InfectedTechnoModel.LAYER_LOCATION, InfectedTechnoModel::createBodyLayer);
        event.registerLayerDefinition(DualSpitterModel.LAYER_LOCATION, DualSpitterModel::createBodyLayer);
        event.registerLayerDefinition(SniperSpitterModel.LAYER_LOCATION, SniperSpitterModel::createBodyLayer);
        event.registerLayerDefinition(GrabberSlasherModel.LAYER_LOCATION, GrabberSlasherModel::createBodyLayer);
        event.registerLayerDefinition(RavenousJawModel.LAYER_LOCATION, RavenousJawModel::createBodyLayer);
        event.registerLayerDefinition(lacedThornsModel.LAYER_LOCATION, lacedThornsModel::createBodyLayer);
        event.registerLayerDefinition(MephiticModel.LAYER_LOCATION, MephiticModel::createBodyLayer);
        event.registerLayerDefinition(InfectedZombieVillager.LAYER_LOCATION, InfectedZombieVillager::createBodyLayer);
        event.registerLayerDefinition(SculkHowlerModel.LAYER_LOCATION, SculkHowlerModel::createBodyLayer);
        event.registerLayerDefinition(SyringeGunModel.LAYER_LOCATION, SyringeGunModel::createBodyLayer);
        event.registerLayerDefinition(SyringeGunModelArm.LAYER_LOCATION, SyringeGunModelArm::createBodyLayer);
        event.registerLayerDefinition(SyringeProjectileModel.LAYER_LOCATION, SyringeProjectileModel::createBodyLayer);


        event.registerLayerDefinition(BombFunnelModel.LAYER_LOCATION, BombFunnelModel::createBodyLayer);
        event.registerLayerDefinition(MushroomExplosionTop.LAYER_LOCATION, MushroomExplosionTop::createBodyLayer);
        event.registerLayerDefinition(FireDiskModel.LAYER_LOCATION, FireDiskModel::createBodyLayer);
        event.registerLayerDefinition(SickleModel.LAYER_LOCATION, SickleModel::createBodyLayer);
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
        event.registerEntityRenderer(Sentities.OGRE.get(), OgreRenderer::new);
        event.registerEntityRenderer(Sentities.INF_CONSTRUCT.get(), InfestedConstructRenderer::new);
        event.registerEntityRenderer(Sentities.JAGD.get(), JagdhundRenderer::new);
        event.registerEntityRenderer(Sentities.PLAGUED.get(), PlaguedRenderer::new);
        event.registerEntityRenderer(Sentities.WAVE.get(), WaveRenderer::new);
        event.registerEntityRenderer(Sentities.ILLUSION.get(), IllusionRenderer::new);
        event.registerEntityRenderer(Sentities.GASTGABER.get(), GastGaverRenderer::new);
        event.registerEntityRenderer(Sentities.SPECTER.get(), SpecterRenderer::new);
        event.registerEntityRenderer(Sentities.HOWITZER.get(), HowitzerRenderer::new);
        event.registerEntityRenderer(Sentities.BLOATER.get(), BloaterRenderer::new);
        event.registerEntityRenderer(Sentities.SCAVENGER.get(), ScavengerRenderer::new);
        event.registerEntityRenderer(Sentities.NUCLEA.get(), NucleaRenderer::new);
        event.registerEntityRenderer(Sentities.HEVOKER.get(), HevokerRenderer::new);
        event.registerEntityRenderer(Sentities.HVINDICATOR.get(), HyperVindicatorRenderer::new);
        event.registerEntityRenderer(Sentities.INF_DISEASED_VILLAGER.get(), InfectedDiseasedVillagerRenderer::new);

        event.registerEntityRenderer(Sentities.ACID_BALL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.VOMIT_BALL.get(), VomitRenderer::new);
        event.registerEntityRenderer(Sentities.SPIT.get(), BulletRender::new);
        event.registerEntityRenderer(Sentities.BILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.ACID.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_TOOL.get(), ThrownMeleeItemRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_TUMOR.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(Sentities.FLESH_BOMB.get(), FleshBombRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_BLOCK.get(), ThrownBlockRenderer::new);
        event.registerEntityRenderer(Sentities.SCENT.get(), ScentEntityRenderer::new);
        event.registerEntityRenderer(Sentities.TENDRIL.get(), TendrilRenderer::new);
        event.registerEntityRenderer(Sentities.STINGER.get(), StingerRenderer::new);
        event.registerEntityRenderer(Sentities.BRAUREI.get(), BraureiRenderer::new);
        event.registerEntityRenderer(Sentities.DELUSIONARE.get(), DelusionareRenderer::new);
        event.registerEntityRenderer(Sentities.ARENA_TENDRIL.get(), RaidTendrilRenderer::new);
        event.registerEntityRenderer(Sentities.HEVOKER_ARM.get(), HyperClawRenderer::new);
        event.registerEntityRenderer(Sentities.NUKE.get(), NuclearBombRenderer::new);
        event.registerEntityRenderer(Sentities.TENTACLE.get(), TentacleRenderer::new);
        event.registerEntityRenderer(Sentities.HOHLFRESSER.get(), HohlRenderer::new);
        event.registerEntityRenderer(Sentities.HOHLFRESSER_SEG.get(), HohlSegRenderer::new);
        event.registerEntityRenderer(Sentities.BIOBLOOB.get(), BiobloobRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_KNIFE.get(), KnifeRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_SICKEL.get(), SickleRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_BOOMERANG.get(), ThrownBoomerangRenderer::new);
        event.registerEntityRenderer(Sentities.PROTECTOR.get(), ProtectorRenderer::new);
        event.registerEntityRenderer(Sentities.INEBRIATER.get(), InebriatorRenderer::new);
        event.registerEntityRenderer(Sentities.SAUGLING.get(), SauglingRenderer::new);
        event.registerEntityRenderer(Sentities.CORPSE_PIECE.get(), CorpseRenderer::new);
        event.registerEntityRenderer(Sentities.MEPHETIC.get(), MephticRenderer::new);
        event.registerEntityRenderer(Sentities.THROWN_SYRINGE.get(), SyringeRenderer::new);

        event.registerBlockEntityRenderer(SblockEntities.OVERGROWN_SPAWNER.get(), new OvergrownSpawnerRenderer());
        event.registerBlockEntityRenderer(SblockEntities.BRAIN_REMNANTS.get(), new BrainRemnantsRenderer());
        event.registerBlockEntityRenderer(SblockEntities.ZOAHOLIC.get(), new ZoaholicRenderer());
        event.registerBlockEntityRenderer(SblockEntities.INCUBATOR.get(), new IncubatorRenderer());
        event.registerBlockEntityRenderer(SblockEntities.OUTPOST_WATCHER.get(), new OutpostWatcherRenderer());
        event.registerBlockEntityRenderer(SblockEntities.HIVE_SPAWN.get(), new ReconMindRenderer());
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        SItemProperties.addCustomItemProperties();
        event.enqueueWork(() -> {
            MenuScreens.register(SMenu.CONTAINER.get(), ContainerScreen::new);
            MenuScreens.register(SMenu.SURGERY_MENU.get(), SurgeryScreen::new);
            MenuScreens.register(SMenu.INJECTION_MENU.get(), InjectionScreen::new);
            MenuScreens.register(SMenu.INCUBATOR_MENU.get(), IncubatorScreen::new);
            MenuScreens.register(SMenu.ZOAHOLIC_MENU.get(), ZoaholicScreen::new);
            MenuScreens.register(SMenu.SURGERY_RECIPE_MENU.get(), SurgeryRecipeScreen::new);
            MenuScreens.register(SMenu.CDU_MENU.get(), CDUScreen::new);
            MenuScreens.register(SMenu.ASSIMILATION_MENU.get(), AssimilationScreen::new);
            MenuScreens.register(SMenu.CABINET_MENU.get(), CabinetScreen::new);
            MenuScreens.register(SMenu.GRAFTING_MENU.get(), GraftingScreen::new);
            MenuScreens.register(SMenu.GRAFTING_RECIPE_MENU.get(), GraftingRecipeScreen::new);
            MenuScreens.register(SMenu.INJECTION_RECIPE_MENU.get(), InjectionRecipeScreen::new);
        });

    }
    @SubscribeEvent
    public static void addLayers(final EntityRenderersEvent.AddLayers event) {
        event.getSkins().forEach(name -> {
            if (event.getSkin(name) instanceof PlayerRenderer renderer) {
                renderer.addLayer(new CustomArmorLayer<>(renderer));
            }
        });
        if (event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer){
            renderer.addLayer(new CustomArmorLayer<>(renderer));
        }
        tryToAddArmorToType(event);
    }
    private static void tryToAddArmorToType(EntityRenderersEvent.AddLayers event){
        for (EntityType<?> type : ForgeRegistries.ENTITY_TYPES.getValues()){
           if (type == null){continue;}
            try {
                if (event.getRenderer((EntityType<? extends LivingEntity>) type) instanceof HumanoidMobRenderer renderer){
                    renderer.addLayer(new CustomArmorLayer<>(renderer));
                }
            } catch (Exception e) {
                ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(type);
                Spore.LOGGER.warn("Could not apply custom armor to entity type {}: {}", id, e.getMessage());
            }

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

        Minecraft.getInstance().particleEngine.register(Sparticles.SPORE_SLASH.get(),
                SlashParticle.Provider::new);

        Minecraft.getInstance().particleEngine.register(Sparticles.SPORE_IMPACT.get(),
                BashParticle.Provider::new);

        Minecraft.getInstance().particleEngine.register(Sparticles.VOMIT.get(),
                VomitParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(Sparticles.VOMIT_BONE.get(),
                VomitParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(Sparticles.VOMIT_ORES.get(),
                VomitParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        for (Item item : Sitems.TINTABLE_ITEMS){
            if (item instanceof SporeWeaponData data){
                event.register((itemStack, tintIndex) -> {
                    if (tintIndex == 0) {
                        return data.getVariant(itemStack).getColor();
                    }
                    return -1;
                },item);

            }
            if (item instanceof SporeArmorData data){
                event.register((itemStack, tintIndex) -> {
                    if (tintIndex == 0) {
                        return data.getVariant(itemStack).getColor();
                    }
                    return -1;
                },item);

            }
            if (item instanceof AbstractSyringe data){
                event.register((itemStack, tintIndex) -> {
                    if (tintIndex == 0) {
                        return data.getColor();
                    }
                    return -1;
                },item);
            }
        }
    }
}
