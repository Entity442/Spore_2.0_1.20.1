package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
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

    public static final RegistryObject<SoundEvent> BROKEN_SCREAMS = soundRegistry("broken_screams");

    private Ssounds() {
    }
}
