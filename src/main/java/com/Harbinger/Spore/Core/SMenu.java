package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Screens.*;
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
    public static final RegistryObject<MenuType<InjectionMenu>> INJECTION_MENU = MENU.register("injection_menu", () -> IForgeMenuType.create(InjectionMenu::new));
    public static final RegistryObject<MenuType<AssimilationMenu>> ASSIMILATION_MENU = MENU.register("assimilation_menu", () -> IForgeMenuType.create(AssimilationMenu::new));
    public static final RegistryObject<MenuType<IncubatorMenu>> INCUBATOR_MENU = MENU.register("incubator_menu", () -> IForgeMenuType.create(IncubatorMenu::new));
    public static final RegistryObject<MenuType<ZoaholicMenu>> ZOAHOLIC_MENU = MENU.register("zoaholic_menu", () -> IForgeMenuType.create(ZoaholicMenu::new));
    public static final RegistryObject<MenuType<SurgeryRecipeMenu>> SURGERY_RECIPE_MENU = MENU.register("surgery_recipe_menu", () -> IForgeMenuType.create(SurgeryRecipeMenu::new));
    public static final RegistryObject<MenuType<CDUMenu>> CDU_MENU = MENU.register("cdu_menu", () -> IForgeMenuType.create(CDUMenu::new));
    public static final RegistryObject<MenuType<CabinetMenu>> CABINET_MENU = MENU.register("cabinet_menu", () -> IForgeMenuType.create(CabinetMenu::new));
    public static final RegistryObject<MenuType<GraftingMenu>> GRAFTING_MENU = MENU.register("grafting_menu", () -> IForgeMenuType.create(GraftingMenu::new));
    public static final RegistryObject<MenuType<GraftingRecipeMenu>> GRAFTING_RECIPE_MENU = MENU.register("grafting_recipe_menu", () -> IForgeMenuType.create(GraftingRecipeMenu::new));

}
