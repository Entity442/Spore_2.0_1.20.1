package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Sentities.BasicInfected.*;
import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
import com.Harbinger.Spore.Sentities.EvolvedInfected.*;
import com.Harbinger.Spore.Sentities.Experiments.Plagued;
import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Sentities.Hyper.Wendigo;
import com.Harbinger.Spore.Sentities.Organoids.*;
import com.Harbinger.Spore.Sentities.Projectile.*;
import com.Harbinger.Spore.Sentities.Utility.*;
import com.Harbinger.Spore.Spore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class Sentities {
    public static DeferredRegister<EntityType<?>> SPORE_ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            Spore.MODID);
    public static void register(IEventBus eventBus) {
        SPORE_ENTITIES.register(eventBus);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return SPORE_ENTITIES.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    public static final MobCategory INFECTED = MobCategory.create("infected","infected",SConfig.SERVER.mob_cap.get(),false,false,128);

    public  static  final List<Entity> INFECTED_ENTITIES = new ArrayList<>();

    public static final RegistryObject<EntityType<InfectedHuman>> INF_HUMAN = SPORE_ENTITIES.register("inf_human",
            () -> EntityType.Builder.of((EntityType<InfectedHuman> p_33002_, Level level) -> new InfectedHuman(level), INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_human").toString()));

    public static final RegistryObject<EntityType<InfectedHusk>> INF_HUSK = SPORE_ENTITIES.register("inf_husk",
            () -> EntityType.Builder.of((EntityType<InfectedHusk> p_33002_, Level level) -> new InfectedHusk(level), INFECTED).sized(0.6f, 2.1f)
                    .build(new ResourceLocation(Spore.MODID, "inf_husk").toString()));

    public static final RegistryObject<EntityType<InfectedPlayer>> INF_PLAYER = SPORE_ENTITIES.register("inf_player",
            () -> EntityType.Builder.of(InfectedPlayer::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_player").toString()));

    public static final RegistryObject<EntityType<Knight>> KNIGHT = SPORE_ENTITIES.register("knight",
            () -> EntityType.Builder.of(Knight::new, INFECTED).sized(0.6f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "knight").toString()));

    public static final RegistryObject<EntityType<Griefer>> GRIEFER = SPORE_ENTITIES.register("griefer",
            () -> EntityType.Builder.of(Griefer::new, INFECTED).sized(0.8f, 2.1f)
                    .build(new ResourceLocation(Spore.MODID, "griefer").toString()));

    public static final RegistryObject<EntityType<Braionmil>> BRAIOMIL = SPORE_ENTITIES.register("braiomil",
            () -> EntityType.Builder.of(Braionmil::new, INFECTED).sized(0.6f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "braiomil").toString()));

    public static final RegistryObject<EntityType<InfectedVillager>> INF_VILLAGER = SPORE_ENTITIES.register("inf_villager",
            () -> EntityType.Builder.of(InfectedVillager::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_villager").toString()));

    public static final RegistryObject<EntityType<InfectedWanderingTrader>> INF_WANDERER = SPORE_ENTITIES.register("inf_wanderer",
            () -> EntityType.Builder.of(InfectedWanderingTrader::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_wanderer").toString()));

    public static final RegistryObject<EntityType<InfectedWitch>> INF_WITCH = SPORE_ENTITIES.register("inf_witch",
            () -> EntityType.Builder.of(InfectedWitch::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_witch").toString()));

    public static final RegistryObject<EntityType<Leaper>> LEAPER = SPORE_ENTITIES.register("leaper",
            () -> EntityType.Builder.of(Leaper::new, INFECTED).sized(0.6f, 2.3f)
                    .build(new ResourceLocation(Spore.MODID, "leaper").toString()));

    public static final RegistryObject<EntityType<Slasher>> SLASHER = SPORE_ENTITIES.register("slasher",
            () -> EntityType.Builder.of(Slasher::new, INFECTED).sized(0.6f, 2.2f)
                    .build(new ResourceLocation(Spore.MODID, "slasher").toString()));

    public static final RegistryObject<EntityType<Spitter>> SPITTER = SPORE_ENTITIES.register("spitter",
            () -> EntityType.Builder.of(Spitter::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "spitter").toString()));

    public static final RegistryObject<EntityType<Scamper>> SCAMPER = SPORE_ENTITIES.register("scamper",
            () -> EntityType.Builder.of(Scamper::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "scamper").toString()));

    public static final RegistryObject<EntityType<InfectedPillager>> INF_PILLAGER = SPORE_ENTITIES.register("inf_pillager",
            () -> EntityType.Builder.of(InfectedPillager::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_pillager").toString()));

    public static final RegistryObject<EntityType<Plagued>> PLAGUED = SPORE_ENTITIES.register("plagued",
            () -> EntityType.Builder.of(Plagued::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "plagued").toString()));

    public static final RegistryObject<EntityType<InfectedHazmat>> INF_HAZMAT = SPORE_ENTITIES.register("inf_hazmat",
            () -> EntityType.Builder.of(InfectedHazmat::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_hazmat").toString()));

    public static final RegistryObject<EntityType<InfectedVendicator>> INF_VINDICATOR = SPORE_ENTITIES.register("inf_vindicator",
            () -> EntityType.Builder.of(InfectedVendicator::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_vindicator").toString()));

    public static final RegistryObject<EntityType<InfectedEvoker>> INF_EVOKER = SPORE_ENTITIES.register("inf_evoker",
            () -> EntityType.Builder.of(InfectedEvoker::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_evoker").toString()));

    public static final RegistryObject<EntityType<Howler>> HOWLER = SPORE_ENTITIES.register("howler",
            () -> EntityType.Builder.of(Howler::new, INFECTED).sized(0.6f, 2.1f)
                    .build(new ResourceLocation(Spore.MODID, "howler").toString()));

    public static final RegistryObject<EntityType<Stalker>> STALKER = SPORE_ENTITIES.register("stalker",
            () -> EntityType.Builder.of(Stalker::new, INFECTED).sized(0.6f, 2.3f)
                    .build(new ResourceLocation(Spore.MODID, "stalker").toString()));

    public static final RegistryObject<EntityType<Wendigo>> WENDIGO = SPORE_ENTITIES.register("wendigo",
            () -> EntityType.Builder.of(Wendigo::new, INFECTED).sized(1f, 3.3f)
                    .build(new ResourceLocation(Spore.MODID, "wendigo").toString()));

    public static final RegistryObject<EntityType<Brute>> BRUTE = SPORE_ENTITIES.register("brute",
            () -> EntityType.Builder.of(Brute::new, INFECTED).sized(1.8f,1.6f)
                    .build(new ResourceLocation(Spore.MODID, "brute").toString()));

    public static final RegistryObject<EntityType<Busser>> BUSSER = SPORE_ENTITIES.register("busser",
            () -> EntityType.Builder.of(Busser::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "busser").toString()));

    public static final RegistryObject<EntityType<Volatile>> VOLATILE = SPORE_ENTITIES.register("volatile",
            () -> EntityType.Builder.of(Volatile::new, INFECTED).sized(0.6f, 2.3f)
                    .build(new ResourceLocation(Spore.MODID, "volatile").toString()));

    public static final RegistryObject<EntityType<InfectedDrowned>> INF_DROWNED = SPORE_ENTITIES.register("inf_drowned",
            () -> EntityType.Builder.of(InfectedDrowned::new, INFECTED).sized(0.6f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "inf_drowned").toString()));

    public static final RegistryObject<EntityType<Vigil>> VIGIL = SPORE_ENTITIES.register("vigil",
            () -> EntityType.Builder.of(Vigil::new, INFECTED).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "vigil").toString()));

    public static final RegistryObject<EntityType<Umarmer>> UMARMED = SPORE_ENTITIES.register("umarmed",
            () -> EntityType.Builder.of(Umarmer::new, INFECTED).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "umarmed").toString()));


    public static final RegistryObject<EntityType<AcidBall>> ACID_BALL = register("acid_ball",
            EntityType.Builder.<AcidBall>of(AcidBall::new, MobCategory.MISC).setCustomClientFactory((spawnEntity, level) -> new AcidBall(level))
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<Vomit>> ACID = register("acid",
            EntityType.Builder.<Vomit>of(Vomit::new, MobCategory.MISC).setCustomClientFactory(Vomit::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<ThrownSpear>> THROWN_SPEAR = register("thrown_spear",
            EntityType.Builder.<ThrownSpear>of(ThrownSpear::new, MobCategory.MISC).setCustomClientFactory(ThrownSpear::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<ThrownTumor>> THROWN_TUMOR = register("thrown_tumor",
            EntityType.Builder.<ThrownTumor>of(ThrownTumor::new, MobCategory.MISC).setCustomClientFactory(ThrownTumor::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<BileProjectile>> BILE = register("bile",
            EntityType.Builder.of((EntityType<BileProjectile> p_33002_, Level level) -> new BileProjectile(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));

    public static final RegistryObject<EntityType<AdaptableProjectile>> SPIT = register("spit",
            EntityType.Builder.of((EntityType<AdaptableProjectile> p_33002_, Level level) -> new AdaptableProjectile(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));

    public static final RegistryObject<EntityType<ScentEntity>> SCENT = SPORE_ENTITIES.register("scent",
            () -> EntityType.Builder.of(ScentEntity::new, MobCategory.MISC).sized(0.2f,0.2f)
                    .build(new ResourceLocation(Spore.MODID, "scent").toString()));

    public static final RegistryObject<EntityType<InfEvoClaw>> CLAW = SPORE_ENTITIES.register("claw",
            () -> EntityType.Builder.of(InfEvoClaw::new, INFECTED).sized(0.5f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "claw").toString()));

    public static final RegistryObject<EntityType<Mound>> MOUND = SPORE_ENTITIES.register("mound",
            () -> EntityType.Builder.of(Mound::new, INFECTED).sized(0.3f, 0.3f)
                    .build(new ResourceLocation(Spore.MODID, "mound").toString()));

    public static final RegistryObject<EntityType<BiomassReformator>> RECONSTRUCTOR = SPORE_ENTITIES.register("reconstructor",
            () -> EntityType.Builder.of(BiomassReformator::new, INFECTED).sized(1f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "reconstructor").toString()));

    public static final RegistryObject<EntityType<Usurper>> USURPER = SPORE_ENTITIES.register("usurper",
            () -> EntityType.Builder.of(Usurper::new, INFECTED).sized(1f, 2.2f)
                    .build(new ResourceLocation(Spore.MODID, "usurper").toString()));

    public static final RegistryObject<EntityType<Proto>> PROTO = SPORE_ENTITIES.register("proto",
            () -> EntityType.Builder.of(Proto::new, INFECTED).sized(1f, 3.5f)
                    .build(new ResourceLocation(Spore.MODID, "proto").toString()));

    public static final RegistryObject<EntityType<InfectionTendril>> TENDRIL = SPORE_ENTITIES.register("tendril",
            () -> EntityType.Builder.of(InfectionTendril::new, MobCategory.MISC).sized(0.8f, 0.1f)
                    .build(new ResourceLocation(Spore.MODID, "tendril").toString()));

    public static final RegistryObject<EntityType<TumoroidNuke>> TUMOROID_NUKE = SPORE_ENTITIES.register("tumoroid_nuke",
            () -> EntityType.Builder.of((EntityType.EntityFactory<TumoroidNuke>) TumoroidNuke::new, MobCategory.MISC).sized(3f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "tumoroid_nuke").toString()));

    public static final RegistryObject<EntityType<WaveEntity>> WAVE = SPORE_ENTITIES.register("wave",
            () -> EntityType.Builder.of((EntityType.EntityFactory<WaveEntity>) WaveEntity::new, MobCategory.MISC).sized(0.8f, 0.1f)
                    .build(new ResourceLocation(Spore.MODID, "wave").toString()));

    public static final RegistryObject<EntityType<Sieger>> SIEGER = SPORE_ENTITIES.register("sieger",
            () -> EntityType.Builder.of(Sieger::new, INFECTED).sized(2.5f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "sieger").toString()));
    public static final RegistryObject<EntityType<SiegerTail>> SIEGER_TAIL = SPORE_ENTITIES.register("sieger_tail",
            () -> EntityType.Builder.of(SiegerTail::new, MobCategory.MISC).sized(2.1f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "sieger_tail").toString()));

    public static final RegistryObject<EntityType<Gazenbrecher>> GAZENBREACHER = SPORE_ENTITIES.register("gazenbreacher",
            () -> EntityType.Builder.of(Gazenbrecher::new, INFECTED).sized(3.5f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "gazenbreacher").toString()));

    public static final RegistryObject<EntityType<Licker>> LICKER = SPORE_ENTITIES.register("licker",
            () -> EntityType.Builder.of(Licker::new, MobCategory.MISC).sized(1.4f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "licker").toString()));

    public static final RegistryObject<EntityType<Hinderburg>> HINDENBURG = SPORE_ENTITIES.register("hindenburg",
            () -> EntityType.Builder.of(Hinderburg::new, INFECTED).sized(5f, 5f)
                    .build(new ResourceLocation(Spore.MODID, "hindenburg").toString()));
}