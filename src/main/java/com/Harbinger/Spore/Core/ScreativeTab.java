package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Spore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class ScreativeTab {
    public static final DeferredRegister<CreativeModeTab> SPORE_TABS =DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Spore.MODID);

    public static final RegistryObject<CreativeModeTab> SPORE = SPORE_TABS.register("spore",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.spore"))
                    .icon(Sitems.MUTATED_HEART.get()::getDefaultInstance).displayItems((parameters, output) -> {
                        Sitems.BIOLOGICAL_ITEMS.forEach(item -> output.accept(item.asItem()));
                        Sitems.BIOLOGICAL_BLOCKS.forEach(item -> output.accept(item.asItem()));
                    }).build()
    );





    public static final RegistryObject<CreativeModeTab> SPORE_T = SPORE_TABS.register("spore_t",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.spore_t"))
                    .icon(Sitems.CONTAINER.get()::getDefaultInstance).displayItems((parameters, output) -> {
                        Sitems.TECHNOLOGICAL_ITEMS.forEach(item -> output.accept(item.asItem()));
                        Sitems.TECHNOLOGICAL_BLOCKS.forEach(item -> output.accept(item.asItem()));
                    }).build()
    );

    public static void register(IEventBus eventBus) {
        SPORE_TABS.register(eventBus);
    }

}
