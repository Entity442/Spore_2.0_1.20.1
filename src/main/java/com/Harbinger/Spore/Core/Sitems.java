package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Sitems.*;
import com.Harbinger.Spore.Sitems.Agents.ConnectingAgent;
import com.Harbinger.Spore.Sitems.Agents.HardeningAgent;
import com.Harbinger.Spore.Sitems.Agents.MutationSyringe;
import com.Harbinger.Spore.Sitems.Agents.SharpeningAgent;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class Sitems {
    public  static  final List<Item> BIOLOGICAL_ITEMS = new ArrayList<>();
    public  static  final List<Item> TECHNOLOGICAL_ITEMS = new ArrayList<>();
    public  static  final List<Item> TINTABLE_ITEMS = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Spore.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public  static final RegistryObject<Item> CLAW_FRAGMENT = ITEMS.register("claw_fragment",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.claw_fragment"));
    public  static final RegistryObject<Item> CLAW = ITEMS.register("claw",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> ARMOR_FRAGMENT = ITEMS.register("armor_fragment",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.armor_fragment"));
    public  static final RegistryObject<Item> MUTATED_HEART = ITEMS.register("mutated_heart",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.mutated_heart"));
    public  static final RegistryObject<Item> MUTATED_FIBER = ITEMS.register("mutated_fiber",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.mutated_fiber"));
    public  static final RegistryObject<Item> WING_MEMBRANE = ITEMS.register("wing_membrane",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.wing_membrane"));
    public  static final RegistryObject<Item> FLESHY_BONE = ITEMS.register("fleshy_bone",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> HARDENED_BIND = ITEMS.register("hardened_bind",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> FLESHY_CLAW = ITEMS.register("fleshy_claw",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> LIVING_CORE = ITEMS.register("living_core",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> SPINE_FRAGMENT = ITEMS.register("spine_fragment",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> NERVES = ITEMS.register("nerves",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> CEREBRUM = ITEMS.register("cerebrum",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.cerebrum"));
    public  static final RegistryObject<Item> SPINE = ITEMS.register("spine",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> ARMOR_PLATE = ITEMS.register("armor_plate",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> PLATED_MUSCLE = ITEMS.register("plated_muscle",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> ALVEOLIC_SACK = ITEMS.register("alveolic_sack",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.alveolic_sack"));
    public  static final RegistryObject<Item> ALTERED_SPLEEN = ITEMS.register("altered_spleen",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.altered_spleen"));
    public  static final RegistryObject<Item> CORROSIVE_SACK = ITEMS.register("corrosive_sack",
            () -> new OrganItem( new Item.Properties(),"spore.scanner.organ.corrosive_sack"));
    public  static final RegistryObject<Item> TENDONS = ITEMS.register("tendons",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> INNARDS = ITEMS.register("innards",
            () -> new Innards( new Item.Properties()));
    public  static final RegistryObject<Item> SICKLE_FRAGMENT = ITEMS.register("sickle_fragment",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> R_WING = ITEMS.register("r_wing",
            () -> new BaseItem( new Item.Properties()));
    public  static final RegistryObject<Item> TUMOR = ITEMS.register("tumor",
            () -> new Tumor(Tumor.TumorType.REGULAR));
    public  static final RegistryObject<Item> SICKEN_TUMOR = ITEMS.register("sicken_tumor",
            () -> new Tumor(Tumor.TumorType.SICKEN));
    public  static final RegistryObject<Item> CALCIFIED_TUMOR = ITEMS.register("calcified_tumor",
            () -> new Tumor(Tumor.TumorType.CALCIFIED));
    public  static final RegistryObject<Item> BILE_TUMOR = ITEMS.register("bile_tumor",
            () -> new Tumor(Tumor.TumorType.BILE));
    public  static final RegistryObject<Item> FROZEN_TUMOR = ITEMS.register("frozen_tumor",
            () -> new Tumor(Tumor.TumorType.FROZEN));
    public  static final RegistryObject<Item> SAUSAGE = ITEMS.register("sausage",
            () -> new BaseItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.ABSORPTION,300,1),1f).meat().build())));
    public  static final RegistryObject<Item> FIBER_STEW = ITEMS.register("fiber_stew",
            () -> new BowlItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(6).saturationMod(1.5F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.REGENERATION,300,0),1f).meat().build())));
    public  static final RegistryObject<Item> HEART_KEBAB = ITEMS.register("heart_kebab",
            () -> new BaseItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.HUNGER,100,0),1f).meat().build())));
    public  static final RegistryObject<Item> ROASTED_HEART_KEBAB = ITEMS.register("roasted_heart_kebab",
            () -> new BaseItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(8).saturationMod(1.2F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.HEALTH_BOOST,300,1),1f).meat().build())));
    public  static final RegistryObject<Item> ROASTED_TUMOR = ITEMS.register("roasted_tumor",
            () -> new BaseItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(1.8F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,300,1),1f).meat().build())));
    public  static final RegistryObject<Item> VIGIL_EYE_SOUP = ITEMS.register("vigil_eye_soup",
            () -> new BowlItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(12).saturationMod(1.2F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.NIGHT_VISION,1200,0),1f).meat().build())));
    public  static final RegistryObject<Item> MILKY_SACK = ITEMS.register("milky_sack",
            () -> new BaseItem(new Item.Properties().stacksTo(8).food(new FoodProperties.Builder().nutrition(4).saturationMod(1.2F).meat().build())));
    public  static final RegistryObject<Item> BRAIN_NOODLES = ITEMS.register("brain_noodles",
            () -> new BowlItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(2F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.DIG_SPEED,300,1),1f).meat().build())));
    public  static final RegistryObject<Item> FRIED_WING_MEMBRANE = ITEMS.register("fried_wing_membrane",
            () -> new BowlItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder().nutrition(10).saturationMod(3F).effect(()-> new MobEffectInstance(Seffects.MYCELIUM.get(),200,0),0.4f)
                    .effect(()-> new MobEffectInstance(MobEffects.SLOW_FALLING,300,1),1f).meat().build())));

    public  static final RegistryObject<Item> INFECTED_HUMAN_SPAWNEGG = ITEMS.register("infected_human_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_HUMAN,-9357608,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INFECTED_HUSK_SPAWNEGG = ITEMS.register("inf_husk_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_HUSK,-875608,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_VILLAGER_SPAWNEGG = ITEMS.register("inf_villager_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_VILLAGER,-6639718,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_WITCH_SPAWNEGG = ITEMS.register("inf_witch_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_WITCH,-8512718,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_PILLAGER_SPAWNEGG = ITEMS.register("inf_pillager_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_PILLAGER,-2312718,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_VIND_SPAWNEGG = ITEMS.register("inf_vind_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_VINDICATOR,-984718,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> INF_EVO_SPAWNEGG = ITEMS.register("inf_evo_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_EVOKER,-254718,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> INF_WANDERER_SPAWNEGG = ITEMS.register("inf_wanderer_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_WANDERER,-6639718,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_DROWNED_SPAWNEGG = ITEMS.register("inf_drowned_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_DROWNED,-16751002,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_PLAYER_SPAWNEGG = ITEMS.register("inf_player_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_PLAYER,-86751002,SpawnEggType.INFECTED));
    public  static final RegistryObject<Item> INF_HAZMAT_SPAWNEGG = ITEMS.register("inf_hazmat_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_HAZMAT,-6345002,SpawnEggType.INFECTED));

    public  static final RegistryObject<Item> PLAGUED_SPAWNEGG = ITEMS.register("plagued_spawnegg",
            () -> new SporeSpawnEgg(Sentities.PLAGUED,78294644,SpawnEggType.EXPERIMENT));
    public  static final RegistryObject<Item> LACERATOR_SPAWNEGG = ITEMS.register("lacerator_spawnegg",
            () -> new SporeSpawnEgg(Sentities.LACERATOR,2412344,SpawnEggType.EXPERIMENT));




    public  static final RegistryObject<Item> KNIGHT_SPAWNEGG = ITEMS.register("knight_spawnegg",
            () -> new SporeSpawnEgg(Sentities.KNIGHT,-7681208,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> GRIEFER_SPAWNEGG = ITEMS.register("griefer_spawnegg",
            () -> new SporeSpawnEgg(Sentities.GRIEFER,-5750208,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> BRAIO_SPAWNEGG = ITEMS.register("braio_spawnegg",
            () -> new SporeSpawnEgg(Sentities.BRAIOMIL,-6124508,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> BUSSER_SPAWNEGG = ITEMS.register("busser_spawnegg",
            () -> new SporeSpawnEgg(Sentities.BUSSER,-3724508,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> LEAPER_SPAWNEGG = ITEMS.register("leaper_spawnegg",
            () -> new SporeSpawnEgg(Sentities.LEAPER,-9762718,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> SLASHER_SPAWNEGG = ITEMS.register("slasher_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SLASHER,-8564118,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> SPITTER_SPAWNEGG = ITEMS.register("spitter_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SPITTER,-8164818,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> HOWLER_SPAWNEGG = ITEMS.register("howler_spawnegg",
            () -> new SporeSpawnEgg(Sentities.HOWLER,-32464818,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> STALKER_SPAWNEGG = ITEMS.register("stalker_spawnegg",
            () -> new SporeSpawnEgg(Sentities.STALKER,-42364818,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> BRUTE_SPAWNEGG = ITEMS.register("brute_spawnegg",
            () -> new SporeSpawnEgg(Sentities.BRUTE,-1235818,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> VOLATILE_SPAWNEGG = ITEMS.register("volatile_spawnegg",
            () -> new SporeSpawnEgg(Sentities.VOLATILE,-976435818,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> THORN_SPAWNEGG = ITEMS.register("thorn_spawnegg",
            () -> new SporeSpawnEgg(Sentities.THORN,-1243545,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> JAGD_SPAWNEGG = ITEMS.register("jagd_spawnegg",
            () -> new SporeSpawnEgg(Sentities.JAGD,-95469235,SpawnEggType.EVOLVED));
    public  static final RegistryObject<Item> SCAVENGER_SPAWNEGG = ITEMS.register("scavenger_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SCAVENGER,-54353454,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> BLOATER_SPAWNEGG = ITEMS.register("bloater_spawnegg",
            () -> new SporeSpawnEgg(Sentities.BLOATER,-6834952,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> NUCLEA_SPAWNEGG = ITEMS.register("nuclea_spawnegg",
            () -> new SporeSpawnEgg(Sentities.NUCLEA,-265262544,SpawnEggType.EVOLVED));

    public  static final RegistryObject<Item> SCENT_SPAWNEGG = ITEMS.register("scent_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SCENT,-1,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> ILLUSION_SPAWNEGG = ITEMS.register("illusion_spawnegg",
            () -> new SporeSpawnEgg(Sentities.ILLUSION,-1,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> CLAW_SPAWNEGG = ITEMS.register("claw_spawnegg",
            () -> new SporeSpawnEgg(Sentities.CLAW,-5437216,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> SCAMPER_SPAWNEGG = ITEMS.register("scamper_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SCAMPER,-33777216,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> GASTGABER_SPAWNEGG = ITEMS.register("gastgaber_spawnegg",
            () -> new SporeSpawnEgg(Sentities.GASTGABER,-241247216,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> SPECTER_SPAWNEGG = ITEMS.register("specter_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SPECTER,-876534333,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> CONSTRUCT_SPAWNEGG = ITEMS.register("construct_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INF_CONSTRUCT,-65242341,SpawnEggType.UNKNOWN));

    public  static final RegistryObject<Item> MOUND_SPAWNEGG = ITEMS.register("mound_spawnegg",
            () -> new SporeSpawnEgg(Sentities.MOUND,-5750208,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> VIGIL_SPAWNEGG = ITEMS.register("vigil_spawnegg",
            () -> new SporeSpawnEgg(Sentities.VIGIL,-64160208,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> UMARMED_SPAWNEGG = ITEMS.register("umarmed_spawnegg",
            () -> new SporeSpawnEgg(Sentities.UMARMED,-8650208,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> USURPER_SPAWNEGG = ITEMS.register("usurper_spawnegg",
            () -> new SporeSpawnEgg(Sentities.USURPER,-432208,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> BRAUREI_SPAWNEGG = ITEMS.register("braurei_spawnegg",
            () -> new SporeSpawnEgg(Sentities.BRAUREI,-745723,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> VERVA_SPAWNEGG = ITEMS.register("verva_spawnegg",
            () -> new SporeSpawnEgg(Sentities.VERVA,-412323,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> DELUSIONER_SPAWNEGG = ITEMS.register("delusioner_spawnegg",
            () -> new SporeSpawnEgg(Sentities.DELUSIONARE,-93652400,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> RECONSTRUCTOR_SPAWNEGG = ITEMS.register("reconstructor_spawnegg",
            () -> new SporeSpawnEgg(Sentities.RECONSTRUCTOR,-2353208,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> PROTO_SPAWNEGG = ITEMS.register("proto_spawnegg",
            () -> new SporeSpawnEgg(Sentities.PROTO,244208,SpawnEggType.ORGANOID));

    public  static final RegistryObject<Item> WENDIGO_SPAWNEGG = ITEMS.register("wendigo_spawnegg",
            () -> new SporeSpawnEgg(Sentities.WENDIGO,-354345818,SpawnEggType.HYPER));

    public  static final RegistryObject<Item> INQUISITOR_SPAWNEGG = ITEMS.register("inquisitor_spawnegg",
            () -> new SporeSpawnEgg(Sentities.INQUISITOR,-6435818,SpawnEggType.HYPER));

    public  static final RegistryObject<Item> BROTKATZE_SPAWNEGG = ITEMS.register("brotkatze_spawnegg",
            () -> new SporeSpawnEgg(Sentities.BROTKATZE,-7352318,SpawnEggType.HYPER));

    public  static final RegistryObject<Item> HEVOKER_SPAWNEGG = ITEMS.register("hevoker_spawnegg",
            () -> new SporeSpawnEgg(Sentities.HEVOKER,-867785,SpawnEggType.HYPER));

    public  static final RegistryObject<Item> OGRE_SPAWNEGG = ITEMS.register("ogre_spawnegg",
            () -> new SporeSpawnEgg(Sentities.OGRE,-241434523,SpawnEggType.HYPER));

    public  static final RegistryObject<Item> SIEGER_SPAWNEGG = ITEMS.register("sieger_spawnegg",
            () -> new SporeSpawnEgg(Sentities.SIEGER,244208,SpawnEggType.CALAMITY));

    public  static final RegistryObject<Item> GAZEN_SPAWNEGG = ITEMS.register("gazen_spawnegg",
            () -> new SporeSpawnEgg(Sentities.GAZENBREACHER,865020865,SpawnEggType.CALAMITY));

    public  static final RegistryObject<Item> HINDEN_SPAWNEGG = ITEMS.register("hinden_spawnegg",
            () -> new SporeSpawnEgg(Sentities.HINDENBURG,346320865,SpawnEggType.CALAMITY));

    public  static final RegistryObject<Item> HOWITZER_SPAWNEGG = ITEMS.register("howitzer_spawnegg",
            () -> new SporeSpawnEgg(Sentities.HOWITZER,18414394,SpawnEggType.CALAMITY));


    public  static final RegistryObject<Item> ACID = ITEMS.register("acid",
            () -> new Item( new Item.Properties()));
    public  static final RegistryObject<Item> BILE = ITEMS.register("bile",
            () -> new Item( new Item.Properties()));
    public  static final RegistryObject<Item> ACID_BALL = ITEMS.register("acid_ball",
            () -> new Item( new Item.Properties()));


    public  static final RegistryObject<Item> SABER = ITEMS.register("saber",
            InfectedSaber::new);
    public  static final RegistryObject<Item> GREATSWORD = ITEMS.register("greatsword",
            InfectedGreatSword::new);
    public  static final RegistryObject<Item> ARMADS = ITEMS.register("armads",
            InfectedArmads::new);
    public  static final RegistryObject<Item> INFECTED_BOW = ITEMS.register("infected_bow",
            () -> new InfectedGreatBow( new Item.Properties().durability(SConfig.SERVER.bow_durability.get())));
    public  static final RegistryObject<Item> MAUL = ITEMS.register("maul",
            InfectedMaul::new);
    public  static final RegistryObject<Item> COMBAT_PICKAXE = ITEMS.register("combat_pickaxe",
            InfectedPickaxe::new);
    public  static final RegistryObject<Item> SCYTHE = ITEMS.register("scythe",
            InfectedScythe::new);
    public  static final RegistryObject<Item> COMBAT_SHOVEL = ITEMS.register("combat_shovel",
            InfectedCombatShovel::new);
    public  static final RegistryObject<Item> INFECTED_SPEAR = ITEMS.register("infected_spear",
            InfectedSpearItem::new);
    public  static final RegistryObject<Item> INFECTED_CROSSBOW = ITEMS.register("infected_crossbow",
            InfectedCrossbow::new);
    public  static final RegistryObject<Item> MACE = ITEMS.register("mace",
            InfectedMace::new);
    public  static final RegistryObject<Item> SICKLE = ITEMS.register("sickle",
            InfectedSickle::new);
    public  static final RegistryObject<Item> KNIFE = ITEMS.register("knife",
            InfectedKnife::new);
    public  static final RegistryObject<Item> RAPIER = ITEMS.register("rapier",
            InfectedRapier::new);
    public  static final RegistryObject<Item> VIGIL_EYE = ITEMS.register("vigil_eye",
            VigilEye::new);
    public  static final RegistryObject<Item> SYMBIOTIC_REAGENT = ITEMS.register("symbiotic_reagent",
            () -> new BiologicalReagent(BiologicalReagent.AcceptedTypes.ALL_TYPES){
                @Override
                public Enchantment getAppliedEnchantment() {
                    return Senchantments.SYMBIOTIC_RECONSTITUTION.get();
                }
            });
    public  static final RegistryObject<Item> CRYOGENIC_REAGENT = ITEMS.register("cryogenic_reagent",
            () -> new BiologicalReagent(BiologicalReagent.AcceptedTypes.WEAPON_TYPES){
                @Override
                public Enchantment getAppliedEnchantment() {
                    return Senchantments.CRYOGENIC_ASPECT.get();
                }
            });
    public  static final RegistryObject<Item> GASTRIC_REAGENT = ITEMS.register("gastric_reagent",
            () -> new BiologicalReagent(BiologicalReagent.AcceptedTypes.WEAPON_TYPES){
                @Override
                public Enchantment getAppliedEnchantment() {
                    return Senchantments.GASTRIC_SPEWAGE.get();
                }
            });
    public  static final RegistryObject<Item> CORROSIVE_REAGENT = ITEMS.register("corrosive_reagent",
            () -> new BiologicalReagent(BiologicalReagent.AcceptedTypes.WEAPON_TYPES){
                @Override
                public Enchantment getAppliedEnchantment() {
                    return Senchantments.CORROSIVE_POTENCY.get();
                }
            });

    public  static final RegistryObject<Item> INF_HELMET = ITEMS.register("inf_helmet",
            InfectedHelmet::new);
    public  static final RegistryObject<Item> INF_CHEST = ITEMS.register("inf_chest",
            InfectedChestplate::new);
    public  static final RegistryObject<Item> INF_PANTS = ITEMS.register("inf_pants",
            InfectedLeggings::new);
    public  static final RegistryObject<Item> INF_BOOTS = ITEMS.register("inf_boots",
            InfectedBoots::new);

    public  static final RegistryObject<Item> PLATED_HELMET = ITEMS.register("plated_helmet",
            PlatedHelmet::new);
    public  static final RegistryObject<Item> PLATED_CHEST = ITEMS.register("plated_chest",
            PlatedChestplate::new);
    public  static final RegistryObject<Item> PLATED_PANTS = ITEMS.register("plated_pants",
            PlatedLeggings::new);
    public  static final RegistryObject<Item> PLATED_BOOTS = ITEMS.register("plated_boots",
            PlatedBoots::new);

    public  static final RegistryObject<Item> LIVING_HELMET = ITEMS.register("living_helmet",
            LivingHelmet::new);
    public  static final RegistryObject<Item> LIVING_CHEST = ITEMS.register("living_chest",
            LivingChestplate::new);
    public  static final RegistryObject<Item> LIVING_PANTS = ITEMS.register("living_pants",
            LivingLeggings::new);
    public  static final RegistryObject<Item> LIVING_BOOTS = ITEMS.register("living_boots",
            LivingBoots::new);
    public  static final RegistryObject<Item> R_ELYTRON = ITEMS.register("r_elytron", Elytron.InfectedElytron::new);

    public  static final RegistryObject<Item> INF_UP_CHESTPLATE = ITEMS.register("inf_up_chest",
            UpgradedInfectedExoskeleton.InfectedUpChestplate::new);


    public  static final RegistryObject<Item> CORRUPTED_RECORD = ITEMS.register("corrupted_record",
            CorruptedRecord::new);
    public  static final RegistryObject<Item> BUCKET_OF_BILE = ITEMS.register("bucket_of_bile",
            () -> new SporeBucket(Sfluids.Bile_FLUID_SOURCE,new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public  static final RegistryObject<Item> GAS_MASK = ITEMS.register("gas_mask",
            GasMaskItem::new);
    public  static final RegistryObject<Item> SCANNER = ITEMS.register("scanner",
            () -> new ScannerItem( new Item.Properties()));
    public  static final RegistryObject<Item> BIOMASS = ITEMS.register("biomass",
            Biomass::new);
    public  static final RegistryObject<Item> CIRCUIT_BOARD = ITEMS.register("circuit_board",
            () -> new BaseItem2( new Item.Properties()));
    public  static final RegistryObject<Item> ICE_CANISTER = ITEMS.register("ice_canister",
            () -> new BaseItem2( new Item.Properties()));
    public  static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",
            () -> new BaseItem2( new Item.Properties()));
    public  static final RegistryObject<Item> COMPOUND = ITEMS.register("compound",
            () -> new BaseItem2( new Item.Properties()));
    public  static final RegistryObject<Item> COMPOUND_PLATE = ITEMS.register("compound_plate",
            () -> new BaseItem2( new Item.Properties()));
    public  static final RegistryObject<Item> HARDENING_AGENT = ITEMS.register("hardening_agent",
            HardeningAgent::new);
    public  static final RegistryObject<Item> SHARPENING_AGENT = ITEMS.register("sharpening_agent",
            SharpeningAgent::new);
    public  static final RegistryObject<Item> INTEGRATING_AGENT = ITEMS.register("integrating_agent",
            ConnectingAgent::new);
    public  static final RegistryObject<Item> MUTATION_SYRINGE = ITEMS.register("mutation_syringe",
            MutationSyringe::new);








    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItemBase2(block.get(), new Item.Properties()));
    }
    private static RegistryObject<Item> Techblock(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItemBase(block.get(), new Item.Properties()));
    }
    private static RegistryObject<Item> Exceptions(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItemCBU(block.get()));
    }

    public static final RegistryObject<Item> CONTAINER = Techblock(Sblocks.CONTAINER);
    public static final RegistryObject<Item> CDU = Exceptions(Sblocks.CDU);
    public static final RegistryObject<Item> ZOAHOLIC = Exceptions(Sblocks.ZOAHOLIC);
    public static final RegistryObject<Item> INCUBATOR = Exceptions(Sblocks.INCUBATOR);
    public static final RegistryObject<Item> SURGERY_TABLE = Exceptions(Sblocks.SURGERY_TABLE);
    public static final RegistryObject<Item> LAB_BLOCK = Techblock(Sblocks.LAB_BLOCK);
    public static final RegistryObject<Item> LAB_BLOCK1 = Techblock(Sblocks.LAB_BLOCK1);
    public static final RegistryObject<Item> LAB_BLOCK2 = Techblock(Sblocks.LAB_BLOCK2);
    public static final RegistryObject<Item> LAB_BLOCK3 = Techblock(Sblocks.LAB_BLOCK3);
    public static final RegistryObject<Item> LAB_SLAB = Techblock(Sblocks.LAB_SLAB);
    public static final RegistryObject<Item> LAB_SLAB1 = Techblock(Sblocks.LAB_SLAB1);
    public static final RegistryObject<Item> LAB_SLAB2 = Techblock(Sblocks.LAB_SLAB2);
    public static final RegistryObject<Item> LAB_SLAB3 = Techblock(Sblocks.LAB_SLAB3);
    public static final RegistryObject<Item> LAB_STAIR = Techblock(Sblocks.LAB_STAIR);
    public static final RegistryObject<Item> IRON_LADDER = Techblock(Sblocks.IRON_LADDER);
    public static final RegistryObject<Item> VENT_PLATE = Techblock(Sblocks.VENT_PLATE);
    public static final RegistryObject<Item> RUSTED_VENT_PLATE = Techblock(Sblocks.RUSTED_VENT_PLATE);
    public static final RegistryObject<Item> VENT_DOOR = Techblock(Sblocks.VENT_DOOR);
    public static final RegistryObject<Item> REINFORCED_DOOR = Techblock(Sblocks.REINFORCED_DOOR);
    public static final RegistryObject<Item> FROZEN_REINFORCED_DOOR = Techblock(Sblocks.FROZEN_REINFORCED_DOOR);
    public static final RegistryObject<Item> RUSTED_REINFORCED_DOOR = Techblock(Sblocks.RUSTED_REINFORCED_DOOR);

    public static final RegistryObject<Item> GROWTHS_BIG = block(Sblocks.GROWTHS_BIG);
    public static final RegistryObject<Item> GROWTHS_SMALL = block(Sblocks.GROWTHS_SMALL);
    public static final RegistryObject<Item> BLOOM_G = block(Sblocks.BLOOM_G);
    public static final RegistryObject<Item> BLOOM_GG = block(Sblocks.BLOOM_GG);
    public static final RegistryObject<Item> FUNGAL_ROOTS = block(Sblocks.FUNGAL_ROOTS);
    public static final RegistryObject<Item> GROWTH_MYCELIUM = block(Sblocks.GROWTH_MYCELIUM);
    public static final RegistryObject<Item> FUNGAL_STEP_SAPLING = block(Sblocks.FUNGAL_STEM_SAPLING);
    public static final RegistryObject<Item> MYCELIUM_VEINS = block(Sblocks.MYCELIUM_VEINS);
    public static final RegistryObject<Item> BIOMASS_BULB = block(Sblocks.BIOMASS_BULB);

    public static final RegistryObject<Item> ROTTEN_LOG = block(Sblocks.ROTTEN_LOG);
    public static final RegistryObject<Item> ROTTEN_PLANKS = block(Sblocks.ROTTEN_PLANKS);
    public static final RegistryObject<Item> ROTTEN_STAIR = block(Sblocks.ROTTEN_STAIR);
    public static final RegistryObject<Item> ROTTEN_SLAB = block(Sblocks.ROTTEN_SLAB);
    public static final RegistryObject<Item> ROTTEN_SCRAPS = block(Sblocks.ROTTEN_SCRAPS);
    public static final RegistryObject<Item> ROTTEN_BRANCH = block(Sblocks.ROTTEN_BRANCH);
    public static final RegistryObject<Item> ROTTEN_BUSH = block(Sblocks.ROTTEN_BUSH);
    public static final RegistryObject<Item> ROOTED_BIOMASS = block(Sblocks.ROOTED_BIOMASS);
    public static final RegistryObject<Item> BIOMASS_BLOCK = block(Sblocks.BIOMASS_BLOCK);
    public static final RegistryObject<Item> CALCIFIED_BIOMASS_BLOCK = block(Sblocks.CALCIFIED_BIOMASS_BLOCK);
    public static final RegistryObject<Item> SICKEN_BIOMASS_BLOCK = block(Sblocks.SICKEN_BIOMASS_BLOCK);
    public static final RegistryObject<Item> GASTRIC_BIOMASS = block(Sblocks.GASTRIC_BIOMASS);
    public static final RegistryObject<Item> MEMBRANE_BLOCK = block(Sblocks.MEMBRANE_BLOCK);
    public static final RegistryObject<Item> ROOTED_MYCELIUM = block(Sblocks.ROOTED_MYCELIUM);
    public static final RegistryObject<Item> CRUSTED_BILE = block(Sblocks.CRUSTED_BILE);
    public static final RegistryObject<Item> MYCELIUM_BLOCK = block(Sblocks.MYCELIUM_BLOCK);
    public static final RegistryObject<Item> MYCELIUM_SLAB = block(Sblocks.MYCELIUM_SLAB);
    public static final RegistryObject<Item> FUNGAL_SHELL = block(Sblocks.FUNGAL_SHELL);
    public static final RegistryObject<Item> ORGANITE = block(Sblocks.ORGANITE);
    public static final RegistryObject<Item> FROST_BURNED_BIOMASS = block(Sblocks.FROST_BURNED_BIOMASS);
    public static final RegistryObject<Item> FROZEN_REMAINS = block(Sblocks.FROZEN_REMAINS);

    public static final RegistryObject<Item> INFESTED_DEEPSLATE = block(Sblocks.INFESTED_DEEPSLATE);
    public static final RegistryObject<Item> INFESTED_DIRT = block(Sblocks.INFESTED_DIRT);
    public static final RegistryObject<Item> INFESTED_END_STONE = block(Sblocks.INFESTED_END_STONE);
    public static final RegistryObject<Item> INFESTED_GRAVEL = block(Sblocks.INFESTED_GRAVEL);
    public static final RegistryObject<Item> INFESTED_NETHERRACK = block(Sblocks.INFESTED_NETHERRACK);
    public static final RegistryObject<Item> INFESTED_SAND = block(Sblocks.INFESTED_SAND);
    public static final RegistryObject<Item> INFESTED_SOUL_SAND = block(Sblocks.INFESTED_SOUL_SAND);
    public static final RegistryObject<Item> INFESTED_STONE = block(Sblocks.INFESTED_STONE);
    public static final RegistryObject<Item> INFESTED_RED_SAND = block(Sblocks.INFESTED_RED_SAND);
    public static final RegistryObject<Item> INFESTED_CLAY = block(Sblocks.INFESTED_CLAY);
    public static final RegistryObject<Item> INFESTED_COBBLESTONE = block(Sblocks.INFESTED_COBBLESTONE);
    public static final RegistryObject<Item> INFESTED_COBBLED_DEEPSLATE = block(Sblocks.INFESTED_COBBLED_DEEPSLATE);
    public static final RegistryObject<Item> INFESTED_LABORATORY_BLOCK = block(Sblocks.INFESTED_LABORATORY_BLOCK);
    public static final RegistryObject<Item> INFESTED_LABORATORY_BLOCK1 = block(Sblocks.INFESTED_LABORATORY_BLOCK1);
    public static final RegistryObject<Item> INFESTED_LABORATORY_BLOCK2 = block(Sblocks.INFESTED_LABORATORY_BLOCK2);
    public static final RegistryObject<Item> INFESTED_LABORATORY_BLOCK3 = block(Sblocks.INFESTED_LABORATORY_BLOCK3);
    public static final RegistryObject<Item> OVERGROWN_SPAWNER = block(Sblocks.OVERGROWN_SPAWNER);
    public static final RegistryObject<Item> BRAIN_REMNANTS = block(Sblocks.BRAIN_REMNANTS);
    public static final RegistryObject<Item> OUTPOST_WATCHER = block(Sblocks.OUTPOST_WATCHER);

    public static final RegistryObject<Item> REMAINS = block(Sblocks.REMAINS);
    public static final RegistryObject<Item> BIOMASS_LUMP = block(Sblocks.BIOMASS_LUMP);
    public static final RegistryObject<Item> HIVE_SPAWN = block(Sblocks.HIVE_SPAWN);

}
