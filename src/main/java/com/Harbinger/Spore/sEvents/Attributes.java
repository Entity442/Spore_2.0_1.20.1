package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BasicInfected.*;
import com.Harbinger.Spore.Sentities.Calamities.*;
import com.Harbinger.Spore.Sentities.EvolvedInfected.*;
import com.Harbinger.Spore.Sentities.Experiments.Biobloob;
import com.Harbinger.Spore.Sentities.Experiments.Lacerator;
import com.Harbinger.Spore.Sentities.Experiments.Plagued;
import com.Harbinger.Spore.Sentities.FallenMultipart.HowitzerArm;
import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Sentities.Hyper.*;
import com.Harbinger.Spore.Sentities.Organoids.*;
import com.Harbinger.Spore.Sentities.Utility.*;
import com.Harbinger.Spore.Spore;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Spore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Attributes {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Sentities.INF_HUMAN.get(), InfectedHuman.createAttributes().build());
        event.put(Sentities.INF_HUSK.get(), InfectedHusk.createAttributes().build());
        event.put(Sentities.KNIGHT.get(), Knight.createAttributes().build());
        event.put(Sentities.GRIEFER.get(), Griefer.createAttributes().build());
        event.put(Sentities.BRAIOMIL.get(), Braionmil.createAttributes().build());
        event.put(Sentities.INF_VILLAGER.get(), InfectedVillager.createAttributes().build());
        event.put(Sentities.INF_WITCH.get(), InfectedWitch.createAttributes().build());
        event.put(Sentities.LEAPER.get(), Leaper.createAttributes().build());
        event.put(Sentities.SLASHER.get(), Slasher.createAttributes().build());
        event.put(Sentities.VOLATILE.get(), Volatile.createAttributes().build());
        event.put(Sentities.SPITTER.get(), Spitter.createAttributes().build());
        event.put(Sentities.INF_PILLAGER.get(), InfectedPillager.createAttributes().build());
        event.put(Sentities.INF_VINDICATOR.get(), InfectedVendicator.createAttributes().build());
        event.put(Sentities.CLAW.get(), InfEvoClaw.createAttributes().build());
        event.put(Sentities.INF_EVOKER.get(), InfectedEvoker.createAttributes().build());
        event.put(Sentities.HOWLER.get(), Howler.createAttributes().build());
        event.put(Sentities.INF_WANDERER.get(), InfectedWanderingTrader.createAttributes().build());
        event.put(Sentities.PLAGUED.get(), Plagued.createAttributes().build());
        event.put(Sentities.STALKER.get(), Stalker.createAttributes().build());
        event.put(Sentities.SCENT.get(), ScentEntity.createAttributes().build());
        event.put(Sentities.BRUTE.get(), Brute.createAttributes().build());
        event.put(Sentities.BUSSER.get(), Busser.createAttributes().build());
        event.put(Sentities.INF_DROWNED.get(), InfectedDrowned.createAttributes().build());
        event.put(Sentities.INF_PLAYER.get(), InfectedPlayer.createAttributes().build());
        event.put(Sentities.INF_HAZMAT.get(), InfectedHazmat.createAttributes().build());
        event.put(Sentities.SCAMPER.get(), Scamper.createAttributes().build());
        event.put(Sentities.MOUND.get(), Mound.createAttributes().build());
        event.put(Sentities.RECONSTRUCTOR.get(), Womb.createAttributes().build());
        event.put(Sentities.PROTO.get(), Proto.createAttributes().build());
        event.put(Sentities.VIGIL.get(), Vigil.createAttributes().build());
        event.put(Sentities.UMARMED.get(), Umarmer.createAttributes().build());
        event.put(Sentities.TENDRIL.get(), InfectionTendril.createAttributes().build());
        event.put(Sentities.SIEGER.get(), Sieger.createAttributes().build());
        event.put(Sentities.GAZENBREACHER.get(), Gazenbrecher.createAttributes().build());
        event.put(Sentities.SIEGER_TAIL.get(), SiegerTail.createAttributes().build());
        event.put(Sentities.LICKER.get(), Licker.createAttributes().build());
        event.put(Sentities.HOWIT_ARM.get(), HowitzerArm.createAttributes().build());
        event.put(Sentities.HINDENBURG.get(), Hinderburg.createAttributes().build());
        event.put(Sentities.TUMOROID_NUKE.get(), Hinderburg.createAttributes().build());
        event.put(Sentities.BRAUREI.get(), Brauerei.createAttributes().build());
        event.put(Sentities.VERVA.get(), Verwa.createAttributes().build());
        event.put(Sentities.ILLUSION.get(), Illusion.createAttributes().build());
        event.put(Sentities.WAVE.get(), WaveEntity.createAttributes().build());
        event.put(Sentities.USURPER.get(), Usurper.createAttributes().build());
        event.put(Sentities.WENDIGO.get(), Wendigo.createAttributes().build());
        event.put(Sentities.OGRE.get(), Ogre.createAttributes().build());
        event.put(Sentities.INQUISITOR.get(), Inquisitor.createAttributes().build());
        event.put(Sentities.BROTKATZE.get(), Brot.createAttributes().build());
        event.put(Sentities.DELUSIONARE.get(), Delusionare.createAttributes().build());
        event.put(Sentities.GASTGABER.get(), GastGeber.createAttributes().build());
        event.put(Sentities.HOWITZER.get(), Howitzer.createAttributes().build());
        event.put(Sentities.LACERATOR.get(), Lacerator.createAttributes().build());
        event.put(Sentities.THORN.get(), Thorn.createAttributes().build());
        event.put(Sentities.SPECTER.get(), Specter.createAttributes().build());
        event.put(Sentities.JAGD.get(), Jagdhund.createAttributes().build());
        event.put(Sentities.INF_CONSTRUCT.get(),InfestedConstruct.createAttributes().build());
        event.put(Sentities.ARENA_TENDRIL.get(),ArenaEntity.createAttributes().build());
        event.put(Sentities.BLOATER.get(),Bloater.createAttributes().build());
        event.put(Sentities.SCAVENGER.get(),Scavenger.createAttributes().build());
        event.put(Sentities.NUCLEA.get(),Nuclealave.createAttributes().build());
        event.put(Sentities.HEVOKER.get(), Hevoker.createAttributes().build());
        event.put(Sentities.HEVOKER_ARM.get(), HyperClaw.createAttributes().build());
        event.put(Sentities.HVINDICATOR.get(), Hvindicator.createAttributes().build());
        event.put(Sentities.TENTACLE.get(), Tentacle.createAttributes().build());
        event.put(Sentities.HOHLFRESSER.get(), Hohlfresser.createAttributes().build());
        event.put(Sentities.BIOBLOOB.get(), Biobloob.createAttributes().build());
        event.put(Sentities.PROTECTOR.get(), Protector.createAttributes().build());
    }
}


