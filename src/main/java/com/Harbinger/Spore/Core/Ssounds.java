package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Ssounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Spore.MODID);
    public static void register(IEventBus eventBus) {SOUNDS.register(eventBus);}

    private static RegistryObject<SoundEvent> soundRegistry(String id){
        return SOUNDS.register(id, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Spore.MODID, id)));
    }
    public static final RegistryObject<SoundEvent> CORRUPTED_RECORD = soundRegistry("corrupted_record");

    public static final RegistryObject<SoundEvent> FORGOTTEN_PATIENT = soundRegistry("forgotten_patient");

    public static final RegistryObject<SoundEvent> FORSAKEN_FUTURE = soundRegistry("forsaken_future");

    public static final RegistryObject<SoundEvent> NUKE = soundRegistry("nuke");

    public static final RegistryObject<SoundEvent> AREA_AMBIENT = soundRegistry("spore_area_ambient");

    public static final RegistryObject<SoundEvent> REBIRTH = soundRegistry("rebirth");

    public static final RegistryObject<SoundEvent> INF_DAMAGE = soundRegistry("inf_damage");

    public static final RegistryObject<SoundEvent> INF_GROWL = soundRegistry("inf_growl");

    public static final RegistryObject<SoundEvent> HOWLER_GROWL = soundRegistry("howler_growl");

    public static final RegistryObject<SoundEvent> INF_VILLAGER_DAMAGE = soundRegistry("inf_villager_damage");

    public static final RegistryObject<SoundEvent> INF_VILLAGER_GROWL = soundRegistry("inf_villager_growl");

    public static final RegistryObject<SoundEvent> INF_VILLAGER_DEATH = soundRegistry("inf_villager_death");

    public static final RegistryObject<SoundEvent> INF_EVOKER_DAMAGE = soundRegistry("inf_evoker_damage");

    public static final RegistryObject<SoundEvent> INF_EVOKER_GROWL = soundRegistry("inf_evoker_growl");

    public static final RegistryObject<SoundEvent> INF_EVOKER_DEATH = soundRegistry("inf_evoker_death");

    public static final RegistryObject<SoundEvent> BRAIOMIL_ATTACK = soundRegistry("braiomil_attack");

    public static final RegistryObject<SoundEvent> SIEGER_AMBIENT = soundRegistry("sieger_ambient");

    public static final RegistryObject<SoundEvent> SIEGER_BITE = soundRegistry("sieger_bite");

    public static final RegistryObject<SoundEvent> GAZEN_AMBIENT = soundRegistry("gazen_ambient");

    public static final RegistryObject<SoundEvent> HINDEN_AMBIENT = soundRegistry("hinden_ambient");

    public static final RegistryObject<SoundEvent> BRAUREI_AMBIENT = soundRegistry("braurei_ambient");

    public static final RegistryObject<SoundEvent> HINDEN_NUKE = soundRegistry("hinden_nuke");

    public static final RegistryObject<SoundEvent> SONAR = soundRegistry("sonar");

    public static final RegistryObject<SoundEvent> LANDING = soundRegistry("landing");

    public static final RegistryObject<SoundEvent> HOWITZER_AMBIENT = soundRegistry("howitzer_ambient");

    public static final RegistryObject<SoundEvent> FALLING_BOMB = soundRegistry("falling_bomb");

    public static final RegistryObject<SoundEvent> SIGNAL = soundRegistry("signal");

    public static final RegistryObject<SoundEvent> UMARMER_AMBIENT = soundRegistry("umarmer_ambient");

    public static final RegistryObject<SoundEvent> VIGIL_AMBIENT = soundRegistry("vigil_ambient");

    public static final RegistryObject<SoundEvent> WENDIGO_AMBIENT = soundRegistry("wendigo_ambient");

    public static final RegistryObject<SoundEvent> WENDIGO_SCREECH = soundRegistry("wendigo_screech");

    public static final RegistryObject<SoundEvent> WOMB_AMBIENT = soundRegistry("womb_ambient");

    public static final RegistryObject<SoundEvent> USURPER_AMBIENT = soundRegistry("usurper_ambient");

    public static final RegistryObject<SoundEvent> INQUISITOR_AMBIENT = soundRegistry("inquisitor_ambient");

    public static final RegistryObject<SoundEvent> BROT_AMBIENT = soundRegistry("brot_ambient");

    public static final RegistryObject<SoundEvent> DELUSIONER_AMBIENT = soundRegistry("delusioner_ambient");

    public static final RegistryObject<SoundEvent> DELUSIONER_CASTING = soundRegistry("delusioner_casting");

    public static final RegistryObject<SoundEvent> BIOBLOB = soundRegistry("bioblob");

    public static final RegistryObject<SoundEvent> SPIT = soundRegistry("spit");

    public static final RegistryObject<SoundEvent> MADNESS = soundRegistry("madness");

    public static final RegistryObject<SoundEvent> LIMB_SLASH = soundRegistry("limb_slash");

    public static final RegistryObject<SoundEvent> PROTO_AMBIENT = soundRegistry("proto_ambient");

    public static final RegistryObject<SoundEvent> FUNGAL_BURST = soundRegistry("fungal_burst");

    public static final RegistryObject<SoundEvent> HEART_BEAT = soundRegistry("heart_beat");

    public static final RegistryObject<SoundEvent> PUFF = soundRegistry("puff");

    public static final RegistryObject<SoundEvent> PRINTING = soundRegistry("printing");

    public static final RegistryObject<SoundEvent> GAST_AMBIENT = soundRegistry("gast_ambient");

    public static final RegistryObject<SoundEvent> SAW_SOUND = soundRegistry("saw_sound");

    public static final RegistryObject<SoundEvent> ENGINE = soundRegistry("engine");

    public static final RegistryObject<SoundEvent> SPECTER_AMBIENT = soundRegistry("specter_ambient");

    public static final RegistryObject<SoundEvent> CONSTRUCT_AMBIENT = soundRegistry("construct_ambient");

    public static final RegistryObject<SoundEvent> SCAVENGER_SCREECH = soundRegistry("scavenger_screech");

    public static final RegistryObject<SoundEvent> BROKEN_SCREAMS = soundRegistry("broken_screams");

    public static final RegistryObject<SoundEvent> HYPER_EVOLVE = soundRegistry("hyper_evolve");

    public static final RegistryObject<SoundEvent> OGRE_AMBIENT = soundRegistry("ogre_ambient");

    public static final RegistryObject<SoundEvent> CALAMITY_SPAWN = soundRegistry("calamity_spawn");

    public static final RegistryObject<SoundEvent> CALAMITY_INCOMING = soundRegistry("calamity_incoming");

    public static final RegistryObject<SoundEvent> SURGERY = soundRegistry("surgery");

    public static final RegistryObject<SoundEvent> EVOLVE_HURT = soundRegistry("evolve_hurt");

    public static final RegistryObject<SoundEvent> HEVOKER_AMBIENT = soundRegistry("hevoker_ambient");

    public static final RegistryObject<SoundEvent> HINDICATOR_AMBIENT = soundRegistry("hindicator_ambient");

    public static final RegistryObject<SoundEvent> INFECTED_WEAPON_THROW = soundRegistry("infected_weapon_throw");

    public static final RegistryObject<SoundEvent> INFECTED_WEAPON_HIT_ENTITY = soundRegistry("infected_weapon_hit_entity");

    public static final RegistryObject<SoundEvent> INFECTED_WEAPON_HIT_BLOCK = soundRegistry("infected_weapon_hit_block");

    public static final RegistryObject<SoundEvent> CDU_INSERT = soundRegistry("cdu_insert");

    public static final RegistryObject<SoundEvent> CDU_AMBIENT = soundRegistry("cdu_ambient");

    public static final RegistryObject<SoundEvent> CLEAVER_SPIN = soundRegistry("cleaver_spin");

    public static final RegistryObject<SoundEvent> INFECTED_PICKAXE = soundRegistry("infected_pickaxe");

    public static final RegistryObject<SoundEvent> REAVER_REAVE = soundRegistry("reaver_reave");

    public static final RegistryObject<SoundEvent> SABER_LEAP = soundRegistry("saber_leap");

    public static final RegistryObject<SoundEvent> SCANNER_ITEM = soundRegistry("scanner_item");

    public static final RegistryObject<SoundEvent> SCANNER_EMPTY = soundRegistry("scanner_empty");

    public static final RegistryObject<SoundEvent> SCANNER_MOB = soundRegistry("scanner_mob");

    public static final RegistryObject<SoundEvent> VIGIL_EYE_USE = soundRegistry("vigil_eye_use");

    public static final RegistryObject<SoundEvent> SYRINGE_SUCK = soundRegistry("syringe_suck");

    public static final RegistryObject<SoundEvent> SYRINGE_INJECT = soundRegistry("syringe_inject");

    public static final RegistryObject<SoundEvent> PCI_INJECT = soundRegistry("pci_inject");

    public static final RegistryObject<SoundEvent> REAGENT = soundRegistry("reagent");

    public static final RegistryObject<SoundEvent> INFECTED_GEAR_BREAK = soundRegistry("infected_gear_break");

    public static final RegistryObject<SoundEvent> INFECTED_GEAR_EQUIP = soundRegistry("infected_gear_equip");

    public static final RegistryObject<SoundEvent> SHIELD_BASH = soundRegistry("shield_bash");

    public static final RegistryObject<SoundEvent> TUMOROID_EXPLOSION = soundRegistry("tumoroid_explosion");

    public static final RegistryObject<SoundEvent> INF_VILLAGER_AMBIENT = soundRegistry("villager_ambient");

    public static final RegistryObject<SoundEvent> INF_PILLAGER_AMBIENT = soundRegistry("pillager_ambient");

    public static final RegistryObject<SoundEvent> ADVENTURER_AMBIENT = soundRegistry("adventurer_ambient");

    public static final RegistryObject<SoundEvent> TRADER_AMBIENT = soundRegistry("trader_ambient");

    public static final RegistryObject<SoundEvent> WITCH_AMBIENT = soundRegistry("witch_ambient");

    public static final RegistryObject<SoundEvent> DROWNED_AMBIENT = soundRegistry("drowned_ambient");

    public static final RegistryObject<SoundEvent> HUSK_AMBIENT = soundRegistry("husk_ambient");

    public static final RegistryObject<SoundEvent> VINDICATOR_AMBIENT = soundRegistry("vindicator_ambient");

    public static final RegistryObject<SoundEvent> SCAMPER_AMBIENT = soundRegistry("scamper_ambient");

    public static final RegistryObject<SoundEvent> ORGANOID_DAMAGE = soundRegistry("organoid_damage");

    public static final RegistryObject<SoundEvent> HYPER_DAMAGE = soundRegistry("hyper_damage");

    public static final RegistryObject<SoundEvent> CALAMITY_DAMAGE = soundRegistry("calamity_damage");

    public static final RegistryObject<SoundEvent> INEBRIATER_INJECT = soundRegistry("inebriater_inject");

    public static final RegistryObject<SoundEvent> LACERATOR_AMBIENT = soundRegistry("lacerator_ambient");

    public static final RegistryObject<SoundEvent> SAUGLING_AMBIENT = soundRegistry("saugling_ambient");

    public static final RegistryObject<SoundEvent> PLAGUED_AMBIENT = soundRegistry("plagued_ambient");

    public static final RegistryObject<SoundEvent> SAUGLING_CHEST_AMBIENT = soundRegistry("saugling_chest_ambient");

    public static final RegistryObject<SoundEvent> SAUGLING_JUMPSCARE = soundRegistry("saugling_jumpscare");

    public static final RegistryObject<SoundEvent> SCIENTIST_AMBIENT = soundRegistry("scientist_ambient");

    public static final RegistryObject<SoundEvent> SPORE_BURST = soundRegistry("spore_burst");

    public static final RegistryObject<SoundEvent> WORM_DIGGING = soundRegistry("worm_digging");

    public static final RegistryObject<SoundEvent> HOHL_AMBIENT = soundRegistry("hohl_ambient");

    public static final RegistryObject<SoundEvent> CALAMITY_DEATH = soundRegistry("calamity_death");

    public static final RegistryObject<SoundEvent> SYRINGE_RELOAD = soundRegistry("syringe_reload");

    public static final RegistryObject<SoundEvent> SYRINGE_SPIN = soundRegistry("syringe_spin");

    public static final RegistryObject<SoundEvent> SYRINGE_SHOOT = soundRegistry("syringe_shoot");

    public static final RegistryObject<SoundEvent> SYRINGE_GUN_INJECT = soundRegistry("syringe_gun_inject");

    public static final RegistryObject<SoundEvent> SCIENTIST_FUSE = soundRegistry("scientist_fuse");

    public static final RegistryObject<SoundEvent> CHEMIST_FUSE = soundRegistry("chemist_fuse");

    public static final RegistryObject<SoundEvent> EVOKER_SUCK = soundRegistry("evoker_suck");

    public static final RegistryObject<SoundEvent> HEXEN_SUCK = soundRegistry("hexen_suck");

    public static final RegistryObject<SoundEvent> HEXEN_BLOW = soundRegistry("hexen_blow");

    public static final RegistryObject<SoundEvent> SLASHER_PULL = soundRegistry("slasher_pull");

    public static final RegistryObject<SoundEvent> SLASHER_STAB = soundRegistry("slasher_stab");

    public static final RegistryObject<SoundEvent> SPECTER_CLOAK = soundRegistry("specter_cloak");

    public static final RegistryObject<SoundEvent> SPECTER_UNCLOAK = soundRegistry("specter_uncloak");

    public static final RegistryObject<SoundEvent> VANGUARD_AMBIENT = soundRegistry("vanguard_ambient");

    public static final RegistryObject<SoundEvent> VANGUARD_SLASH = soundRegistry("vanguard_slash");

    public static final RegistryObject<SoundEvent> VANGUARD_SHOOT = soundRegistry("vanguard_shoot");

    public static final RegistryObject<SoundEvent> VANGUARD_FIREWORKS = soundRegistry("vanguard_fireworks");

    public static final RegistryObject<SoundEvent> VANGUARD_GRIEF = soundRegistry("vanguard_grief");

    public static final RegistryObject<SoundEvent> VANGUARD_CALL = soundRegistry("vanguard_call");

    public static final RegistryObject<SoundEvent> VANGUARD_RAID = soundRegistry("vanguard_raid");

    public static final RegistryObject<SoundEvent> KRAKEN_GROWL = soundRegistry("kraken_growl");

    public static final RegistryObject<SoundEvent> BAIRN = soundRegistry("bairn");

    public static final RegistryObject<SoundEvent> STAHL_AMBIENT = soundRegistry("stahl_ambient");

    public static final RegistryObject<SoundEvent> STAHL_KICK = soundRegistry("stahl_kick");

    public static final RegistryObject<SoundEvent> STAHL_SLAP = soundRegistry("stahl_slap");

    public static final RegistryObject<SoundEvent> STAHL_SLASH = soundRegistry("stahl_slash");

    public static final RegistryObject<SoundEvent> PHAYRES_SCREECH = soundRegistry("phayres_screech");
    private Ssounds() {
    }
}
