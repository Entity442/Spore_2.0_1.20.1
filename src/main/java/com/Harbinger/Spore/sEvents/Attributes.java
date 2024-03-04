package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.*;
import com.Harbinger.Spore.Sentities.BasicInfected.*;
import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
import com.Harbinger.Spore.Sentities.EvolvedInfected.*;
import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Sentities.Organoids.*;
import com.Harbinger.Spore.Sentities.Utility.InfEvoClaw;
import com.Harbinger.Spore.Sentities.Utility.InfectionTendril;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
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
        event.put(Sentities.STALKER.get(), Stalker.createAttributes().build());
        event.put(Sentities.SCENT.get(), ScentEntity.createAttributes().build());
        event.put(Sentities.BRUTE.get(), Brute.createAttributes().build());
        event.put(Sentities.BUSSER.get(), Busser.createAttributes().build());
        event.put(Sentities.INF_DROWNED.get(), InfectedDrowned.createAttributes().build());
        event.put(Sentities.INF_PLAYER.get(), InfectedPlayer.createAttributes().build());
        event.put(Sentities.INF_HAZMAT.get(), InfectedHazmat.createAttributes().build());
        event.put(Sentities.SCAMPER.get(), Scamper.createAttributes().build());
        event.put(Sentities.MOUND.get(), Mound.createAttributes().build());
        event.put(Sentities.RECONSTRUCTOR.get(), BiomassReformator.createAttributes().build());
        event.put(Sentities.PROTO.get(), Proto.createAttributes().build());
        event.put(Sentities.VIGIL.get(), Vigil.createAttributes().build());
        event.put(Sentities.UMARMED.get(), Umarmer.createAttributes().build());
        event.put(Sentities.TENDRIL.get(), InfectionTendril.createAttributes().build());
        event.put(Sentities.SIEGER.get(), Sieger.createAttributes().build());
        event.put(Sentities.GAZENBREACHER.get(), Gazenbrecher.createAttributes().build());
        event.put(Sentities.SIEGER_TAIL.get(), SiegerTail.createAttributes().build());
        event.put(Sentities.LICKER.get(), Licker.createAttributes().build());
        event.put(Sentities.HINDENBURG.get(), Hinderburg.createAttributes().build());
        event.put(Sentities.TUMOROID_NUKE.get(), Hinderburg.createAttributes().build());
    }
}


