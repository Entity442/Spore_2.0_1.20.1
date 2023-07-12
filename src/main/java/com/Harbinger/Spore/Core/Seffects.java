package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Effect.*;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Seffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Spore.MODID);
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }



    public static final RegistryObject<MobEffect> MYCELIUM = MOB_EFFECTS.register("mycelium_ef",
            Mycelium::new);

    public static final RegistryObject<MobEffect> STARVATION = MOB_EFFECTS.register("starvation",
            Starvation::new);

    public static final RegistryObject<MobEffect> STUNT = MOB_EFFECTS.register("stunt",() -> new
            Stunt().addAttributeModifier(Attributes.MOVEMENT_SPEED,
            "91AEAA56-376B-4498-935B-2F7F68070635", -0.3F, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ATTACK_DAMAGE,
            "91AEAA56-376B-4498-935B-2F7F68070635", -0.1F, AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ATTACK_SPEED,
            "91AEAA56-376B-4498-935B-2F7F68070635", -0.2F, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> MARKER = MOB_EFFECTS.register("marker",
            () -> new Marker().addAttributeModifier(Attributes.FOLLOW_RANGE,
                    "91AEAA56-376B-4498-935B-2F7F68070635",0.5F ,AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static final RegistryObject<MobEffect> CORROSION = MOB_EFFECTS.register("corrosion",
            () -> new Corrosion().addAttributeModifier(Attributes.ARMOR,
                    "91AEAA56-376B-4498-935B-2F7F68070635",-0.1F ,AttributeModifier.Operation.MULTIPLY_TOTAL));



    public static final RegistryObject<MobEffect> SYMBIOSIS = MOB_EFFECTS.register("symbiosis",
            () -> new Symbiosis().addAttributeModifier(Attributes.MOVEMENT_SPEED,
                    "91AEAA56-376B-4498-935B-2F7F68070635", 0.2F, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED,
                            "91AEAA56-376B-4498-935B-2F7F68070635", 0.2F, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            "91AEAA56-376B-4498-935B-2F7F68070635", 4F, AttributeModifier.Operation.ADDITION)
                    .addAttributeModifier(Attributes.MAX_HEALTH,
                            "91AEAA56-376B-4498-935B-2F7F68070635", 6F, AttributeModifier.Operation.ADDITION));
}
