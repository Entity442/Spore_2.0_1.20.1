package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Screens.ContainerMenu;
import com.Harbinger.Spore.Screens.SurgeryMenu;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SMenu {
    public static final DeferredRegister<MenuType<?>> MENU = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Spore.MODID);
    public static void register(IEventBus eventBus) {
        MENU.register(eventBus);
    }

    public static final RegistryObject<MenuType<ContainerMenu>> CONTAINER = MENU.register("container", () -> IForgeMenuType.create(ContainerMenu::new));
    public static final RegistryObject<MenuType<SurgeryMenu>> SURGERY_MENU = MENU.register("surgery_menu", () -> IForgeMenuType.create(SurgeryMenu::new));

}
