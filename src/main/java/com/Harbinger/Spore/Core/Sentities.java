package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.BasicInfected.*;
import com.Harbinger.Spore.Sentities.Calamities.*;
import com.Harbinger.Spore.Sentities.EvolvedInfected.*;
import com.Harbinger.Spore.Sentities.Experiments.Biobloob;
import com.Harbinger.Spore.Sentities.Experiments.Lacerator;
import com.Harbinger.Spore.Sentities.Experiments.Plagued;
import com.Harbinger.Spore.Sentities.Experiments.Saugling;
import com.Harbinger.Spore.Sentities.FallenMultipart.HowitzerArm;
import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Sentities.FallenMultipart.StalhArm;
import com.Harbinger.Spore.Sentities.Hyper.*;
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

import java.util.function.Supplier;

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
    public static final MobCategory ORGANOID = MobCategory.create("organoid","organoid",20,false,false,64);

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

    public static final RegistryObject<EntityType<Protector>> PROTECTOR = SPORE_ENTITIES.register("protector",
            () -> EntityType.Builder.of(Protector::new, INFECTED).sized(0.6f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "protector").toString()));

    public static final RegistryObject<EntityType<Inebriator>> INEBRIATER = SPORE_ENTITIES.register("inebriater",
            () -> EntityType.Builder.of(Inebriator::new, INFECTED).sized(0.6f, 1.8f)
                    .build(new ResourceLocation(Spore.MODID, "inebriater").toString()));

    public static final RegistryObject<EntityType<Saugling>> SAUGLING = SPORE_ENTITIES.register("saugling",
            () -> EntityType.Builder.of(Saugling::new, INFECTED).sized(0.9f, 0.9f)
                    .build(new ResourceLocation(Spore.MODID, "saugling").toString()));

    public static final RegistryObject<EntityType<Griefer>> GRIEFER = SPORE_ENTITIES.register("griefer",
            () -> EntityType.Builder.of(Griefer::new, INFECTED).sized(0.8f, 2.1f)
                    .build(new ResourceLocation(Spore.MODID, "griefer").toString()));

    public static final RegistryObject<EntityType<Braionmil>> BRAIOMIL = SPORE_ENTITIES.register("braiomil",
            () -> EntityType.Builder.of(Braionmil::new, INFECTED).sized(0.6f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "braiomil").toString()));

    public static final RegistryObject<EntityType<InfectedVillager>> INF_VILLAGER = SPORE_ENTITIES.register("inf_villager",
            () -> EntityType.Builder.of(InfectedVillager::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_villager").toString()));

    public static final RegistryObject<EntityType<InfectedDiseasedVillager>> INF_DISEASED_VILLAGER = SPORE_ENTITIES.register("inf_diseased_villager",
            () -> EntityType.Builder.of(InfectedDiseasedVillager::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_diseased_villager").toString()));

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

    public static final RegistryObject<EntityType<Thorn>> THORN = SPORE_ENTITIES.register("thorn",
            () -> EntityType.Builder.of(Thorn::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "thorn").toString()));

    public static final RegistryObject<EntityType<Mephetic>> MEPHETIC = SPORE_ENTITIES.register("mephitic",
            () -> EntityType.Builder.of(Mephetic::new, INFECTED).sized(0.6f, 2.2f)
                    .build(new ResourceLocation(Spore.MODID, "mephitic").toString()));

    public static final RegistryObject<EntityType<Jagdhund>> JAGD = SPORE_ENTITIES.register("jagd",
            () -> EntityType.Builder.of(Jagdhund::new, INFECTED).sized(1.3f, 1.1f)
                    .build(new ResourceLocation(Spore.MODID, "jagd").toString()));

    public static final RegistryObject<EntityType<Scavenger>> SCAVENGER = SPORE_ENTITIES.register("scavenger",
            () -> EntityType.Builder.of(Scavenger::new, INFECTED).sized(1.3f, 1.1f)
                    .build(new ResourceLocation(Spore.MODID, "scavenger").toString()));

    public static final RegistryObject<EntityType<Bloater>> BLOATER = SPORE_ENTITIES.register("bloater",
            () -> EntityType.Builder.of(Bloater::new, INFECTED).sized(0.8f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "bloater").toString()));

    public static final RegistryObject<EntityType<Nuclealave>> NUCLEA = SPORE_ENTITIES.register("nuclea",
            () -> EntityType.Builder.of(Nuclealave::new, INFECTED).sized(1.1f, 2.2f)
                    .build(new ResourceLocation(Spore.MODID, "nuclea").toString()));

    public static final RegistryObject<EntityType<Scamper>> SCAMPER = SPORE_ENTITIES.register("scamper",
            () -> EntityType.Builder.of(Scamper::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "scamper").toString()));

    public static final RegistryObject<EntityType<InfectedPillager>> INF_PILLAGER = SPORE_ENTITIES.register("inf_pillager",
            () -> EntityType.Builder.of(InfectedPillager::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_pillager").toString()));

    public static final RegistryObject<EntityType<Plagued>> PLAGUED = SPORE_ENTITIES.register("plagued",
            () -> EntityType.Builder.of(Plagued::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "plagued").toString()));

    public static final RegistryObject<EntityType<Lacerator>> LACERATOR = SPORE_ENTITIES.register("lacerator",
            () -> EntityType.Builder.of(Lacerator::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "lacerator").toString()));

    public static final RegistryObject<EntityType<Biobloob>> BIOBLOOB = SPORE_ENTITIES.register("biobloob",
            () -> EntityType.Builder.of(Biobloob::new, INFECTED).sized(2.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "biobloob").toString()));

    public static final RegistryObject<EntityType<InfectedHazmat>> INF_HAZMAT = SPORE_ENTITIES.register("inf_hazmat",
            () -> EntityType.Builder.of(InfectedHazmat::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_hazmat").toString()));

    public static final RegistryObject<EntityType<InfectedVendicator>> INF_VINDICATOR = SPORE_ENTITIES.register("inf_vindicator",
            () -> EntityType.Builder.of(InfectedVendicator::new, INFECTED).sized(0.6f, 1.9f)
                    .build(new ResourceLocation(Spore.MODID, "inf_vindicator").toString()));

    public static final RegistryObject<EntityType<InfestedConstruct>> INF_CONSTRUCT = SPORE_ENTITIES.register("inf_contruct",
            () -> EntityType.Builder.of(InfestedConstruct::new, INFECTED).sized(1.5f, 2.6f)
                    .build(new ResourceLocation(Spore.MODID, "inf_contruct").toString()));

    public static final Supplier<EntityType<Bairn>> BAIRN = SPORE_ENTITIES.register("bairn",
            () -> EntityType.Builder.of(Bairn::new, INFECTED).sized(0.8f, 0.8f)
                    .build(new ResourceLocation(Spore.MODID, "bairn").toString()));

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

    public static final RegistryObject<EntityType<Inquisitor>> INQUISITOR = SPORE_ENTITIES.register("inquisitor",
            () -> EntityType.Builder.of(Inquisitor::new, INFECTED).sized(1f, 2.8f)
                    .build(new ResourceLocation(Spore.MODID, "inquisitor").toString()));

    public static final RegistryObject<EntityType<Hevoker>> HEVOKER = SPORE_ENTITIES.register("hevoker",
            () -> EntityType.Builder.of(Hevoker::new, INFECTED).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "hevoker").toString()));

    public static final RegistryObject<EntityType<HyperClaw>> HEVOKER_ARM = SPORE_ENTITIES.register("hevoker_arm",
            () -> EntityType.Builder.of(HyperClaw::new, INFECTED).sized(1.2f, 1.8f)
                    .build(new ResourceLocation(Spore.MODID, "hevoker_arm").toString()));

    public static final RegistryObject<EntityType<Brot>> BROTKATZE = SPORE_ENTITIES.register("brot",
            () -> EntityType.Builder.of(Brot::new, INFECTED).sized(1.8f, 1.8f)
                    .build(new ResourceLocation(Spore.MODID, "brot").toString()));

    public static final RegistryObject<EntityType<Ogre>> OGRE = SPORE_ENTITIES.register("ogre",
            () -> EntityType.Builder.of(Ogre::new, INFECTED).sized(2.5f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "ogre").toString()));

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

    public static final RegistryObject<EntityType<Chemist>> CHEMIST = SPORE_ENTITIES.register("chemist",
            () -> EntityType.Builder.of(Chemist::new, INFECTED).sized(0.6f, 1.8f)
                    .build(new ResourceLocation(Spore.MODID, "chemist").toString()));

    public static final RegistryObject<EntityType<Vanguard>> VANGUARD = SPORE_ENTITIES.register("vanguard",
            () -> EntityType.Builder.of(Vanguard::new, INFECTED).sized(0.8f, 2.5f)
                    .build(new ResourceLocation(Spore.MODID, "vanguard").toString()));

    public static final RegistryObject<EntityType<Naiad>> NAIAD = SPORE_ENTITIES.register("naiad",
            () -> EntityType.Builder.of(Naiad::new, INFECTED).sized(1.25f, 0.75f)
                    .build(new ResourceLocation(Spore.MODID, "naiad").toString()));

    public static final RegistryObject<EntityType<Vigil>> VIGIL = SPORE_ENTITIES.register("vigil",
            () -> EntityType.Builder.of(Vigil::new, ORGANOID).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "vigil").toString()));

    public static final RegistryObject<EntityType<Delusionare>> DELUSIONARE = SPORE_ENTITIES.register("delusioner",
            () -> EntityType.Builder.of(Delusionare::new, ORGANOID).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "delusioner").toString()));

    public static final RegistryObject<EntityType<Umarmer>> UMARMED = SPORE_ENTITIES.register("umarmed",
            () -> EntityType.Builder.of(Umarmer::new, ORGANOID).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "umarmed").toString()));

    public static final RegistryObject<EntityType<Brauerei>> BRAUREI = SPORE_ENTITIES.register("braurei",
            () -> EntityType.Builder.of(Brauerei::new, ORGANOID).sized(3f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "braurei").toString()));

    public static final RegistryObject<EntityType<Tentacle>> TENTACLE = SPORE_ENTITIES.register("tentacle",
            () -> EntityType.Builder.of(Tentacle::new, ORGANOID).sized(1f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "tentacle").toString()));

    public static final RegistryObject<EntityType<Illusion>> ILLUSION = SPORE_ENTITIES.register("illusion",
            () -> EntityType.Builder.of(Illusion::new, MobCategory.MISC).sized(1f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "illusion").toString()));

    public static final RegistryObject<EntityType<ArenaEntity>> ARENA_TENDRIL = SPORE_ENTITIES.register("arena_tendril",
            () -> EntityType.Builder.of(ArenaEntity::new, ORGANOID).sized(1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "arena_tendril").toString()));

    public static final RegistryObject<EntityType<GastGeber>> GASTGABER = SPORE_ENTITIES.register("gastgaber",
            () -> EntityType.Builder.of(GastGeber::new, ORGANOID).sized(1.1f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "gastgaber").toString()));

    public static final RegistryObject<EntityType<Specter>> SPECTER = SPORE_ENTITIES.register("specter",
            () -> EntityType.Builder.of(Specter::new, INFECTED).sized(1.1f, 2.5f)
                    .build(new ResourceLocation(Spore.MODID, "specter").toString()));

    public static final RegistryObject<EntityType<Hvindicator>> HVINDICATOR = SPORE_ENTITIES.register("hvindicator",
            () -> EntityType.Builder.of(Hvindicator::new, INFECTED).sized(1.1f, 3.5f)
                    .build(new ResourceLocation(Spore.MODID, "hvindicator").toString()));

    public static final RegistryObject<EntityType<NukeEntity>> NUKE = SPORE_ENTITIES.register("nuke",
            () -> EntityType.Builder.of(NukeEntity::new, MobCategory.MISC).sized(1.1f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "nuke").toString()));

    public static final RegistryObject<EntityType<VomitHohlBall>> VOMIT_BALL = register("vomit_ball",
            EntityType.Builder.<VomitHohlBall>of(VomitHohlBall::new, MobCategory.MISC).setCustomClientFactory((spawnEntity, level) -> new VomitHohlBall(level))
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<VomitUsurperBall>> USURPER_VOMIT_BALL = register("usurper_vomit_ball",
            EntityType.Builder.<VomitUsurperBall>of(VomitUsurperBall::new, MobCategory.MISC).setCustomClientFactory((spawnEntity, level) -> new VomitUsurperBall(level))
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<AcidBall>> ACID_BALL = register("acid_ball",
            EntityType.Builder.<AcidBall>of(AcidBall::new, MobCategory.MISC).setCustomClientFactory((spawnEntity, level) -> new AcidBall(level))
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<Vomit>> ACID = register("acid",
            EntityType.Builder.<Vomit>of(Vomit::new, MobCategory.MISC).setCustomClientFactory(Vomit::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<ThrownSpear>> THROWN_SPEAR = register("thrown_spear",
            EntityType.Builder.<ThrownSpear>of(ThrownSpear::new, MobCategory.MISC).setCustomClientFactory(ThrownSpear::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<ThrownBoomerang>> THROWN_BOOMERANG = register("thrown_boomerang",
            EntityType.Builder.<ThrownBoomerang>of(ThrownBoomerang::new, MobCategory.MISC).setCustomClientFactory(ThrownBoomerang::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1f, 0.5f));

    public static final RegistryObject<EntityType<ThrownKnife>> THROWN_KNIFE = register("thrown_knife",
            EntityType.Builder.<ThrownKnife>of(ThrownKnife::new, MobCategory.MISC).setCustomClientFactory(ThrownKnife::new)
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

    public static final RegistryObject<EntityType<StingerProjectile>> STINGER = register("stinger",
            EntityType.Builder.of((EntityType<StingerProjectile> p_33002_, Level level) -> new StingerProjectile(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));

    public static final RegistryObject<EntityType<ThrownItemProjectile>> THROWN_TOOL = register("thrown_tool",
            EntityType.Builder.of((EntityType<ThrownItemProjectile> p_33002_, Level level) -> new ThrownItemProjectile(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));

    public static final RegistryObject<EntityType<SyringeProjectile>> THROWN_SYRINGE = register("thrown_syringe",
            EntityType.Builder.of((EntityType<SyringeProjectile> p_33002_, Level level) -> new SyringeProjectile(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));

    public static final RegistryObject<EntityType<ThrownSickle>> THROWN_SICKEL = register("thrown_sickle",
            EntityType.Builder.of((EntityType<ThrownSickle> p_33002_, Level level) -> new ThrownSickle(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));

    public static final RegistryObject<EntityType<ThrownBlockProjectile>> THROWN_BLOCK = register("thrown_block",
            EntityType.Builder.of((EntityType<ThrownBlockProjectile> p_33002_, Level level) -> new ThrownBlockProjectile(level), MobCategory.MISC)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1f, 1f));

    public static final RegistryObject<EntityType<FleshBomb>> FLESH_BOMB = register("flesh_bomb",
            EntityType.Builder.<FleshBomb>of(FleshBomb::new, MobCategory.MISC).setCustomClientFactory(FleshBomb::new)
                    .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<ScentEntity>> SCENT = SPORE_ENTITIES.register("scent",
            () -> EntityType.Builder.of(ScentEntity::new, MobCategory.MISC).sized(0.2f,0.2f)
                    .build(new ResourceLocation(Spore.MODID, "scent").toString()));

    public static final RegistryObject<EntityType<InfEvoClaw>> CLAW = SPORE_ENTITIES.register("claw",
            () -> EntityType.Builder.of(InfEvoClaw::new, INFECTED).sized(0.5f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "claw").toString()));

    public static final RegistryObject<EntityType<CorpseEntity>> CORPSE_PIECE =
            SPORE_ENTITIES.register("corpse_piece",
                    () -> EntityType.Builder.<CorpseEntity>of(CorpseEntity::new, MobCategory.MISC)
                            .sized(1.0f, 1.0f)
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(Spore.MODID, "corpse_piece").toString()));


    public static final RegistryObject<EntityType<Mound>> MOUND = SPORE_ENTITIES.register("mound",
            () -> EntityType.Builder.of(Mound::new, ORGANOID).sized(0.3f, 0.3f)
                    .build(new ResourceLocation(Spore.MODID, "mound").toString()));

    public static final RegistryObject<EntityType<Womb>> RECONSTRUCTOR = SPORE_ENTITIES.register("reconstructor",
            () -> EntityType.Builder.of((EntityType.EntityFactory<Womb>) Womb::new, ORGANOID).sized(1f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "reconstructor").toString()));

    public static final RegistryObject<EntityType<Verwa>> VERVA = SPORE_ENTITIES.register("verva",
            () -> EntityType.Builder.of(Verwa::new, ORGANOID).sized(1f, 2f)
                    .build(new ResourceLocation(Spore.MODID, "verva").toString()));

    public static final RegistryObject<EntityType<Usurper>> USURPER = SPORE_ENTITIES.register("usurper",
            () -> EntityType.Builder.of(Usurper::new, ORGANOID).sized(1f, 2.2f)
                    .build(new ResourceLocation(Spore.MODID, "usurper").toString()));

    public static final RegistryObject<EntityType<Proto>> PROTO = SPORE_ENTITIES.register("proto",
            () -> EntityType.Builder.of(Proto::new, ORGANOID).sized(1f, 3.5f)
                    .build(new ResourceLocation(Spore.MODID, "proto").toString()));

    public static final Supplier<EntityType<HiveTumor>> HIVETUMOR = SPORE_ENTITIES.register("hivetumor",
            () -> EntityType.Builder.of(HiveTumor::new, ORGANOID).sized(1.2f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "hivetumor").toString()));

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
    public static final RegistryObject<EntityType<HowitzerArm>> HOWIT_ARM = SPORE_ENTITIES.register("howit_arm",
            () -> EntityType.Builder.of(HowitzerArm::new, MobCategory.MISC).sized(2.1f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "howit_arm").toString()));

    public static final RegistryObject<EntityType<Gazenbrecher>> GAZENBREACHER = SPORE_ENTITIES.register("gazenbreacher",
            () -> EntityType.Builder.of(Gazenbrecher::new, INFECTED).sized(3.5f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "gazenbreacher").toString()));
    public static final RegistryObject<EntityType<Grakensenker>> KRAKEN = SPORE_ENTITIES.register("kraken",
            () -> EntityType.Builder.of(Grakensenker::new, INFECTED).sized(3f, 3f)
                    .build(new ResourceLocation(Spore.MODID, "kraken").toString()));

    public static final RegistryObject<EntityType<Licker>> LICKER = SPORE_ENTITIES.register("licker",
            () -> EntityType.Builder.of(Licker::new, MobCategory.MISC).sized(1.4f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "licker").toString()));

    public static final RegistryObject<EntityType<Hinderburg>> HINDENBURG = SPORE_ENTITIES.register("hindenburg",
            () -> EntityType.Builder.of(Hinderburg::new, INFECTED).sized(5f, 5f)
                    .build(new ResourceLocation(Spore.MODID, "hindenburg").toString()));

    public static final RegistryObject<EntityType<Howitzer>> HOWITZER = SPORE_ENTITIES.register("howitzer",
            () -> EntityType.Builder.of(Howitzer::new, INFECTED).sized(5f, 5f)
                    .build(new ResourceLocation(Spore.MODID, "howitzer").toString()));

    public static final Supplier<EntityType<Stahlmorder>> STALH = SPORE_ENTITIES.register("stahl",
            () -> EntityType.Builder.of(Stahlmorder::new, INFECTED).sized(3f, 6f)
                    .build(new ResourceLocation(Spore.MODID, "stahl").toString()));

    public static final RegistryObject<EntityType<Hohlfresser>> HOHLFRESSER = SPORE_ENTITIES.register("hohlfresser",
            () -> EntityType.Builder.of(Hohlfresser::new, INFECTED).sized(3.5f, 3.5f)
                    .build(new ResourceLocation(Spore.MODID, "hohlfresser").toString()));
    public static final RegistryObject<EntityType<HohlMultipart>> HOHLFRESSER_SEG = SPORE_ENTITIES.register("hohlfresser_seg",
            () -> EntityType.Builder.of(HohlMultipart::new, INFECTED).sized(3.5f, 3.5f)
                    .build(new ResourceLocation(Spore.MODID, "hohlfresser_seg").toString()));
    public static final Supplier<EntityType<StalhArm>> STAHL_ARM = SPORE_ENTITIES.register("stahl_arm",
            () -> EntityType.Builder.of(StalhArm::new, MobCategory.MISC).sized(3f, 1f)
                    .build(new ResourceLocation(Spore.MODID, "stahl_arm").toString()));
}