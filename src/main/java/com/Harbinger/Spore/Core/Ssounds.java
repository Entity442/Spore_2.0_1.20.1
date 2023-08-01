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

    public static final RegistryObject<SoundEvent> WOMB_AMBIENT = soundRegistry("womb_ambient");

    public static final RegistryObject<SoundEvent> PROTO_AMBIENT = soundRegistry("proto_ambient");

    public static final RegistryObject<SoundEvent> FUNGAL_BURST = soundRegistry("fungal_burst");

    public static final RegistryObject<SoundEvent> PUFF = soundRegistry("puff");

    private Ssounds() {
    }
}
