package com.Harbinger.Spore.Core;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.List;

public class SConfig {
    public static final Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    public static final DataGen DATAGEN;
    public static final ForgeConfigSpec DATAGEN_SPEC;

    public static class Server {

        public final ForgeConfigSpec.ConfigValue<Double> global_damage;
        public final ForgeConfigSpec.ConfigValue<Double> global_health;
        public final ForgeConfigSpec.ConfigValue<Double> global_armor;
        public final ForgeConfigSpec.ConfigValue<Integer> hunger;
        public final ForgeConfigSpec.ConfigValue<Boolean> at_mob;
        public final ForgeConfigSpec.ConfigValue<Boolean> inf_player;
        public final ForgeConfigSpec.ConfigValue<Boolean> at_an;
        public final ForgeConfigSpec.ConfigValue<Boolean> weaktocold;
        public final ForgeConfigSpec.ConfigValue<Boolean> should_starve;
        public final ForgeConfigSpec.ConfigValue<Boolean> higher_thinking;


        public final ForgeConfigSpec.ConfigValue<Boolean> faw_target;
        public final ForgeConfigSpec.ConfigValue<Boolean> skulk_target;


        public final ForgeConfigSpec.ConfigValue<Integer> days;
        public final ForgeConfigSpec.ConfigValue<Integer> mob_cap;
        public final ForgeConfigSpec.ConfigValue<Boolean> spawn;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> dimension_parameters;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> spawns;

        public final ForgeConfigSpec.ConfigValue<Boolean> scent_spawn;
        public final ForgeConfigSpec.ConfigValue<Boolean> scent_summon;
        public final ForgeConfigSpec.ConfigValue<Integer> scent_summon_cooldown;
        public final ForgeConfigSpec.ConfigValue<Boolean> scent_particles;
        public final ForgeConfigSpec.ConfigValue<Integer> scent_life;
        public final ForgeConfigSpec.ConfigValue<Integer> scent_kills;
        public final ForgeConfigSpec.ConfigValue<Integer> scent_spawn_chance;

        public final ForgeConfigSpec.ConfigValue<Double> inf_human_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_human_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_human_armor;

        public final ForgeConfigSpec.ConfigValue<Double> inf_vil_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_vil_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_vil_armor;

        public final ForgeConfigSpec.ConfigValue<Double> inf_dr_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_dr_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_dr_armor;

        public final ForgeConfigSpec.ConfigValue<Double> inf_van_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_van_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_van_armor;
        public final ForgeConfigSpec.ConfigValue<Boolean> inf_van_potion;

        public final ForgeConfigSpec.ConfigValue<Double> inf_vin_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_vin_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_vin_armor;

        public final ForgeConfigSpec.ConfigValue<Double> bus_hp;
        public final ForgeConfigSpec.ConfigValue<Double> bus_damage;
        public final ForgeConfigSpec.ConfigValue<Double> bus_armor;

        public final ForgeConfigSpec.ConfigValue<Double> inf_pil_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_pil_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_pil_armor;
        public final ForgeConfigSpec.ConfigValue<Double> inf_pil_range_damage;

        public final ForgeConfigSpec.ConfigValue<Double> reconstructor_hp;
        public final ForgeConfigSpec.ConfigValue<Double> reconstructor_armor;
        public final ForgeConfigSpec.ConfigValue<Integer> recontructor_clock;
        public final ForgeConfigSpec.ConfigValue<Integer> reconstructor_biomass;
        public final ForgeConfigSpec.ConfigValue<Integer> reconstructor_assimilation;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> reconstructor_terrain;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> reconstructor_air;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> reconstructor_water;

        public final ForgeConfigSpec.ConfigValue<Double> vigil_hp;
        public final ForgeConfigSpec.ConfigValue<Double> vigil_armor;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> vigil_base_wave;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> vigil_middle_wave;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> vigil_max_wave;

        public final ForgeConfigSpec.ConfigValue<Double> inf_evo_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_evo_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_evo_armor;
        public final ForgeConfigSpec.ConfigValue<Double> inf_claw_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_claw_damage;
        public final ForgeConfigSpec.ConfigValue<Double> inf_claw_armor;

        public final ForgeConfigSpec.ConfigValue<Double> inf_witch_hp;
        public final ForgeConfigSpec.ConfigValue<Double> inf_witch_armor;
        public final ForgeConfigSpec.ConfigValue<Double> inf_witch_melee_damage;
        public final ForgeConfigSpec.ConfigValue<Integer> at_potion_meter;
        public final ForgeConfigSpec.ConfigValue<Integer> buff_potion_meter;
        public final ForgeConfigSpec.ConfigValue<Boolean> use_potions;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> buffing_potions;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> harming_potions;

        public final ForgeConfigSpec.ConfigValue<Double> braio_armor;
        public final ForgeConfigSpec.ConfigValue<Double> braio_hp;
        public final ForgeConfigSpec.ConfigValue<Double> braio_melee_damage;


        public final ForgeConfigSpec.ConfigValue<Double> griefer_armor;
        public final ForgeConfigSpec.ConfigValue<Double> griefer_hp;
        public final ForgeConfigSpec.ConfigValue<Double> griefer_damage;
        public final ForgeConfigSpec.ConfigValue<Integer> explosion;
        public final ForgeConfigSpec.ConfigValue<Boolean> explosion_on;

        public final ForgeConfigSpec.ConfigValue<Double> knight_hp;
        public final ForgeConfigSpec.ConfigValue<Double> knight_damage;
        public final ForgeConfigSpec.ConfigValue<Double> knight_armor;

        public final ForgeConfigSpec.ConfigValue<Double> stalker_hp;
        public final ForgeConfigSpec.ConfigValue<Double> stalker_damage;
        public final ForgeConfigSpec.ConfigValue<Double> stalker_armor;

        public final ForgeConfigSpec.ConfigValue<Double> scamper_hp;
        public final ForgeConfigSpec.ConfigValue<Double> scamper_damage;
        public final ForgeConfigSpec.ConfigValue<Double> scamper_armor;
        public final ForgeConfigSpec.ConfigValue<Integer> scamper_age;
        public final ForgeConfigSpec.ConfigValue<Boolean> scamper_summon;

        public final ForgeConfigSpec.ConfigValue<Double> brute_hp;
        public final ForgeConfigSpec.ConfigValue<Double> brute_damage;
        public final ForgeConfigSpec.ConfigValue<Double> brute_armor;

        public final ForgeConfigSpec.ConfigValue<Double> sieger_hp;
        public final ForgeConfigSpec.ConfigValue<Double> sieger_damage;
        public final ForgeConfigSpec.ConfigValue<Double> sieger_armor;
        public final ForgeConfigSpec.ConfigValue<Double> sieger_dpsr;
        public final ForgeConfigSpec.ConfigValue<Integer> sieger_block_damage;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> sieger_buffs;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> sieger_debuffs;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> sieger_explosive_effects;

        public final ForgeConfigSpec.ConfigValue<Double> leap_hp;
        public final ForgeConfigSpec.ConfigValue<Double> leap_damage;
        public final ForgeConfigSpec.ConfigValue<Double> leap_armor;

        public final ForgeConfigSpec.ConfigValue<Double> sla_hp;
        public final ForgeConfigSpec.ConfigValue<Double> sla_damage;
        public final ForgeConfigSpec.ConfigValue<Double> sla_armor;

        public final ForgeConfigSpec.ConfigValue<Double> mound_hp;
        public final ForgeConfigSpec.ConfigValue<Double> mound_armor;
        public final ForgeConfigSpec.ConfigValue<Integer> mound_cooldown;
        public final ForgeConfigSpec.ConfigValue<Integer> mound_tendril_checker;
        public final ForgeConfigSpec.ConfigValue<Integer> mound_age;
        public final ForgeConfigSpec.ConfigValue<Integer> mound_tendril_feed;
        public final ForgeConfigSpec.ConfigValue<Double> mound_range_default;
        public final ForgeConfigSpec.ConfigValue<Double> mound_range_age2;
        public final ForgeConfigSpec.ConfigValue<Double> mound_range_age3;
        public final ForgeConfigSpec.ConfigValue<Double> mound_range_age4;



        public final ForgeConfigSpec.ConfigValue<Double> proto_hp;
        public final ForgeConfigSpec.ConfigValue<Double> proto_armor;
        public final ForgeConfigSpec.ConfigValue<Double> proto_damage;
        public final ForgeConfigSpec.ConfigValue<Double> proto_dpsr;
        public final ForgeConfigSpec.ConfigValue<Double> proto_calamity;
        public final ForgeConfigSpec.ConfigValue<Integer> proto_range;
        public final ForgeConfigSpec.ConfigValue<Boolean> proto_chunk;
        public final ForgeConfigSpec.ConfigValue<Boolean> proto_raid;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> proto_sapient_target;

        public final ForgeConfigSpec.ConfigValue<Double> how_hp;
        public final ForgeConfigSpec.ConfigValue<Double> how_damage;
        public final ForgeConfigSpec.ConfigValue<Double> how_armor;

        public final ForgeConfigSpec.ConfigValue<Double> player_hp;
        public final ForgeConfigSpec.ConfigValue<Double> player_damage;
        public final ForgeConfigSpec.ConfigValue<Double> player_armor;

        public final ForgeConfigSpec.ConfigValue<Double> spit_hp;
        public final ForgeConfigSpec.ConfigValue<Double> spit_armor;
        public final ForgeConfigSpec.ConfigValue<Double> spit_damage_l;
        public final ForgeConfigSpec.ConfigValue<Double> spit_damage_c;

        public final ForgeConfigSpec.ConfigValue<Integer> evolution_age_human;
        public final ForgeConfigSpec.ConfigValue<Integer> min_kills;

        public final ForgeConfigSpec.ConfigValue<Integer> spear_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> spear_damage;
        public final ForgeConfigSpec.ConfigValue<Integer> spear_range;

        public final ForgeConfigSpec.ConfigValue<Integer> saber_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> saber_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> greatsword_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> greatsword_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> armads_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> armads_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> knife_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> knife_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> maul_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> maul_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> scythe_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> scythe_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> shovel_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> shovel_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> rapier_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> rapier_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> mace_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> mace_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> sickle_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> sickle_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> crossbow_durability;
        public final ForgeConfigSpec.ConfigValue<Double> crossbow_arrow_damage_multiplier;

        public final ForgeConfigSpec.ConfigValue<Integer> bow_durability;
        public final ForgeConfigSpec.ConfigValue<Double> bow_arrow_damage_multiplier;
        public final ForgeConfigSpec.ConfigValue<Integer> bow_melee_damage;

        public final ForgeConfigSpec.ConfigValue<Integer> helmet_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_up_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> pants_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> boots_durability;

        public final ForgeConfigSpec.ConfigValue<Integer> helmet_protection;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_protection;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_up_protection;
        public final ForgeConfigSpec.ConfigValue<Integer> pants_protection;
        public final ForgeConfigSpec.ConfigValue<Integer> boots_protection;

        public final ForgeConfigSpec.ConfigValue<Integer> armor_toughness;

        public final ForgeConfigSpec.ConfigValue<Integer> knockback_resistance;

        public final ForgeConfigSpec.ConfigValue<Integer> helmet_durability1;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_durability1;
        public final ForgeConfigSpec.ConfigValue<Integer> pants_durability1;
        public final ForgeConfigSpec.ConfigValue<Integer> boots_durability1;

        public final ForgeConfigSpec.ConfigValue<Integer> helmet_protection1;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_protection1;
        public final ForgeConfigSpec.ConfigValue<Integer> pants_protection1;
        public final ForgeConfigSpec.ConfigValue<Integer> boots_protection1;

        public final ForgeConfigSpec.ConfigValue<Integer> armor_toughness1;

        public final ForgeConfigSpec.ConfigValue<Integer> knockback_resistance1;

        public final ForgeConfigSpec.ConfigValue<Integer> helmet_durability2;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_durability2;
        public final ForgeConfigSpec.ConfigValue<Integer> pants_durability2;
        public final ForgeConfigSpec.ConfigValue<Integer> boots_durability2;

        public final ForgeConfigSpec.ConfigValue<Integer> helmet_protection2;
        public final ForgeConfigSpec.ConfigValue<Integer> chestplate_protection2;
        public final ForgeConfigSpec.ConfigValue<Integer> pants_protection2;
        public final ForgeConfigSpec.ConfigValue<Integer> boots_protection2;

        public final ForgeConfigSpec.ConfigValue<Integer> armor_toughness2;

        public final ForgeConfigSpec.ConfigValue<Integer> knockback_resistance2;

        public final ForgeConfigSpec.ConfigValue<Integer> ely_durability;
        public final ForgeConfigSpec.ConfigValue<Integer> ely_protection;
        public final ForgeConfigSpec.ConfigValue<Integer> ely_toughness;
        public final ForgeConfigSpec.ConfigValue<Integer> ely_knockback_resistance;


        public final ForgeConfigSpec.ConfigValue<List<? extends String>> human_ev;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> villager_ev;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> pil_ev;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> undespawn;
        public final ForgeConfigSpec.ConfigValue<Boolean> starve;

        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_summon;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> howler_summon;

        public final ForgeConfigSpec.ConfigValue<List<? extends String>> blacklist;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> whitelist;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> flee;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> attack;


        public final ForgeConfigSpec.ConfigValue<List<? extends String>> howler_effects_buff;

        public final ForgeConfigSpec.ConfigValue<List<? extends String>> mycelium;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> corrosion;

        public final ForgeConfigSpec.ConfigValue<List<? extends String>> scent_effects_buff;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_human_conv;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> braio_effects;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> support;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> ranged;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> can_be_carried;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> basic;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> evolved;

        public Server(ForgeConfigSpec.Builder builder) {

            builder.push("Compatibilities");
            this.faw_target = builder.comment("Default false").define("Should the infected attack mobs from FAW?",false);
            this.skulk_target = builder.comment("Default false").define("Should the infected attack mobs from Sculk Infection?",false);
            builder.pop();


            builder.push("Global Variables");
            this.global_damage = builder.define("Global Damage Modifier",1.0);
            this.global_health = builder.define("Global Health Modifier",1.0);
            this.global_armor = builder.define("Global Armor Modifier",1.0);
            this.weaktocold = builder.comment("Default true").define("Should the infected be weak to cold?",true);
            this.should_starve = builder.comment("Default true").define("Should the infected starve overtime?",true);
            this.higher_thinking = builder.comment("Default true").define("Should some infected have higher thinking such as opening doors or trying to break certain blocks?",true);
            this.hunger = builder.define("Hunger in ticks",6000);

            builder.pop();
            builder.push("TargetingTasks");
            this.at_mob = builder.comment("Default true").define("Should attack other mobs?",true);
            this.at_an = builder.comment("Default false").define("Should attack Animals?",false);

            this.blacklist = builder.defineList("Mobs Not Targeted",
                    Lists.newArrayList(
                            "minecraft:creeper","minecraft:squid","minecraft:bat") , o -> o instanceof String);

            this.whitelist = builder.defineList("Mobs ALWAYS Targeted",
                    Lists.newArrayList("minecraft:villager","minecraft:wandering_trader","minecraft:iron_golem","roamers:roamer","roamers:bandit") , o -> o instanceof String);

            this.attack = builder.defineList("Mobs that will target infected",
                    Lists.newArrayList(
                            "minecraft:iron_golem",
                            "guardvillagers:guard" , "roamers:roamer") , o -> o instanceof String);

            this.flee = builder.defineList("Mobs that will run from infected",
                    Lists.newArrayList(
                            "minecraft:villager",
                            "minecraft:wandering_trader" , "roamers:bandit") , o -> o instanceof String);

            builder.pop();

            builder.push("MobRoles ,decides some of the interactions between the infected mobs");
            this.basic = builder.defineList("Basic_Infected",
                    Lists.newArrayList("spore:inf_human","spore:inf_villager","spore:inf_wanderer","spore:inf_witch","spore:inf_pillager","spore:inf_player") , o -> o instanceof String);

            this.evolved = builder.defineList("Evolved_Infected",
                    Lists.newArrayList("spore:braiomil","spore:knight","spore:griefer","spore:busser","spore:spitter","spore:leaper","spore:slasher",
                            "spore:howler","spore:stalker","spore:brute" , "spore:inf_evoker", "spore:inf_vindicator") , o -> o instanceof String);

            this.support = builder.defineList("Support",
                    Lists.newArrayList("spore:inf_witch","spore:braiomil","spore:howler","spore:busser") , o -> o instanceof String);

            this.can_be_carried = builder.defineList("Disposable",
                    Lists.newArrayList("spore:inf_human","spore:inf_villager","spore:inf_wanderer","spore:knight","spore:griefer","spore:slasher","spore:inf_vindicator","minecraft:creeper") , o -> o instanceof String);

            this.ranged = builder.defineList("Ranged",
                    Lists.newArrayList("spore:spitter","spore:inf_pillager","spore:braiomil","spore:inf_evoker") , o -> o instanceof String);
            builder.pop();



            builder.push("Mob Evolutions and Infection System");
            builder.push("Evolutions");
            this.human_ev = builder.defineList("Infected Human Evolutions",
                    Lists.newArrayList(
                            "spore:knight"
                            ,"spore:griefer"
                            ,"spore:braiomil"
                            ,"spore:busser" ) , o -> o instanceof String);

            this.villager_ev = builder.defineList("Infected Villager Evolutions",
                    Lists.newArrayList(
                            "spore:slasher"
                            ,"spore:leaper"
                            ,"spore:spitter" ) , o -> o instanceof String);
            this.pil_ev = builder.defineList("Infected Pillager Evolutions",
                    Lists.newArrayList(
                            "spore:howler",
                                     "spore:stalker",
                                     "spore:brute") , o -> o instanceof String);

            this.undespawn = builder.defineList("Mobs that won't despawn after being created from assimilation",
                    Lists.newArrayList("spore:inf_villager", "spore:inf_pillager", "spore:inf_witch") , o -> o instanceof String);
            this.starve = builder.comment("Default true").define("Should mobs with no kills starve?",true);
            this.evolution_age_human = builder.comment("Default 150").define("Evolution Timer in seconds",300);
            this.min_kills = builder.comment("Default 1").define("Minimum amount of kills to start the evolution",1);
            builder.pop();
            builder.push("Infections");
            this.inf_player = builder.comment("Default true").define("Should the player be infected on death?",true);
            this.inf_human_conv = builder.defineList("Mobs and their infected counterparts",
                    Lists.newArrayList(
                            "minecraft:zombie|spore:inf_human","minecraft:husk|spore:inf_human","minecraft:drowned|spore:inf_drowned"
                            ,"minecraft:pillager|spore:inf_pillager","minecraft:villager|spore:inf_villager","guardvillagers:guard|spore:inf_villager",
                            "recruits:recruit|spore:inf_villager","recruits:bowman|spore:inf_villager","recruits:recruit_shieldman|spore:inf_villager",
                            "recruits:nomad|spore:inf_villager","recruits:horseman|spore:inf_villager",
                            "minecraft:witch|spore:inf_witch","minecraft:wandering_trader|spore:inf_wanderer","minecraft:evoker|spore:inf_evoker",
                            "minecraft:vindicator|spore:inf_vindicator","hunterillager:hunterillager|spore:inf_vindicator","roamers:roamer|spore:inf_player"
                            ,"roamers:bandit|spore:inf_player") , o -> o instanceof String);
            builder.pop();
            builder.pop();


            builder.push("Effects");
            this.mycelium = builder.defineList("Mobs that are immune to the mycelium infection",
                    Lists.newArrayList(
                            "minecraft:ghast"
                            , "minecraft:iron_golem"
                            , "minecraft:magma_cube"
                            , "minecraft:mooshroom"
                            , "minecraft:phantom"
                            , "minecraft:skeleton_horse"
                            , "minecraft:snow_golem"
                            , "minecraft:stray"
                            , "minecraft:wither"
                            , "minecraft:skeleton" ) , o -> o instanceof String);

            this.corrosion = builder.defineList("Mobs that are damaged by corrosion",
                    Lists.newArrayList("minecraft:iron_golem" ) , o -> o instanceof String);
            builder.pop();

            builder.push("Mobs");
            builder.push("Infected Evoker");
            this.inf_evo_hp = builder.comment("Default 35").defineInRange("Sets Infected Evoker Max health", 35, 1, Double.MAX_VALUE);
            this.inf_evo_damage = builder.comment("Default 7").defineInRange("Sets Infected Evoker Damage", 7, 1, Double.MAX_VALUE);
            this.inf_evo_armor = builder.comment("Default 4").defineInRange("Sets Infected Evoker Armor", 4, 1, Double.MAX_VALUE);
            this.inf_claw_hp = builder.comment("Default 15").defineInRange("Sets Infected Claw Max health", 15, 1, Double.MAX_VALUE);
            this.inf_claw_damage = builder.comment("Default 7").defineInRange("Sets Infected Claw Damage", 7, 1, Double.MAX_VALUE);
            this.inf_claw_armor = builder.comment("Default 3").defineInRange("Sets Infected Claw Armor", 3, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Infected Vindicator");
            this.inf_vin_hp = builder.comment("Default 28").defineInRange("Sets Infected Vindicator Max health", 28, 1, Double.MAX_VALUE);
            this.inf_vin_damage = builder.comment("Default 7").defineInRange("Sets Infected Vindicator Damage", 7, 1, Double.MAX_VALUE);
            this.inf_vin_armor = builder.comment("Default 4").defineInRange("Sets Infected Vindicator Armor", 4, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Infected Drowned");
            this.inf_dr_hp = builder.comment("Default 16").defineInRange("Sets Infected Vindicator Max health", 16, 1, Double.MAX_VALUE);
            this.inf_dr_damage = builder.comment("Default 5").defineInRange("Sets Infected Vindicator Damage", 5, 1, Double.MAX_VALUE);
            this.inf_dr_armor = builder.comment("Default 1").defineInRange("Sets Infected Vindicator Armor", 1, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Phayres");
            this.bus_hp = builder.comment("Default 50").defineInRange("Sets Phayres Max health", 50, 1, Double.MAX_VALUE);
            this.bus_damage = builder.comment("Default 6").defineInRange("Sets Phayres Damage", 6, 1, Double.MAX_VALUE);
            this.bus_armor = builder.comment("Default 10").defineInRange("Sets Phayres Armor", 10, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Vigil");
            this.vigil_hp = builder.comment("Default 50").defineInRange("Sets Vigil Max health", 60, 1, Double.MAX_VALUE);
            this.vigil_armor = builder.comment("Default 6").defineInRange("Sets Vigil Armor", 5, 1, Double.MAX_VALUE);
            this.vigil_base_wave = builder.comment("The base wave of infected a vigil can summon").defineList("Vigil min wave",
                    Lists.newArrayList("spore:inf_human" , "spore:inf_villager","spore:inf_pillager","spore:inf_drowned") , o -> o instanceof String);

            this.vigil_middle_wave = builder.comment("The mixed wave of infected a vigil can summon").defineList("Vigil mix wave",
                    Lists.newArrayList("spore:inf_human" , "spore:inf_villager","spore:inf_pillager","spore:inf_wanderer"
                            ,"spore:knight","spore:griefer","spore:leaper","spore:inf_evoker","spore:spitter") , o -> o instanceof String);

            this.vigil_max_wave = builder.comment("The max wave of infected a vigil can summon").defineList("Vigil max wave",
                    Lists.newArrayList("spore:inf_vindicator" , "spore:busser","spore:inf_witch","spore:brute"
                            ,"spore:knight","spore:griefer","spore:leaper","spore:inf_evoker","spore:spitter","spore:stalker"
                            ,"spore:howler","spore:braiomil") , o -> o instanceof String);

            builder.pop();

            builder.push("Sieger");
            this.sieger_hp = builder.comment("Default 300").defineInRange("Sets Sieger Max health", 300, 1, Double.MAX_VALUE);
            this.sieger_damage = builder.comment("Default 25").defineInRange("Sets Sieger Damage", 25, 1, Double.MAX_VALUE);
            this.sieger_armor = builder.comment("Default 25").defineInRange("Sets Sieger Armor", 25, 1, Double.MAX_VALUE);
            this.sieger_dpsr = builder.comment("Default 70").defineInRange("Sets Sieger Damage Cap , set to 0 to disable", 70, 1, Double.MAX_VALUE);
            this.sieger_block_damage = builder.comment("Default 5").defineInRange("Sets Sieger maximum hardness for a block to be broken", 5, 1, Integer.MAX_VALUE);

            this.sieger_buffs = builder.comment("Default values: minecraft:speed|600|0 ,minecraft:mycelium|600|0 ,minecraft:resistance|600|1").defineList("Sieger buffs",
                    Lists.newArrayList("minecraft:speed|600|0" , "minecraft:strength|600|0","minecraft:resistance|600|1") , o -> o instanceof String);

            this.sieger_debuffs = builder.comment("Default values: minecraft:weakness|600|1 ,spore:mycelium|600|1 ,minecraft:slowness|600|1").defineList("Sieger debuffs",
                    Lists.newArrayList("minecraft:weakness|600|1" , "spore:mycelium_ef|600|1","minecraft:slowness|600|1") , o -> o instanceof String);

            this.sieger_explosive_effects = builder.comment("Default values: minecraft:wither ,spore:mycelium ,minecraft:weakness").defineList("Sieger explosion ranged effects",
                    Lists.newArrayList("minecraft:wither" , "spore:mycelium_ef","minecraft:weakness") , o -> o instanceof String);

            builder.pop();

            builder.push("Brute");
            this.brute_hp = builder.comment("Default 70").defineInRange("Sets Brute Max health", 70, 1, Double.MAX_VALUE);
            this.brute_damage = builder.comment("Default 7").defineInRange("Sets Brute Damage", 7, 1, Double.MAX_VALUE);
            this.brute_armor = builder.comment("Default 15").defineInRange("Sets Brute Armor", 15, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Mound");
            this.mound_hp = builder.comment("Default 20").defineInRange("Sets Mound Max health", 20, 1, Double.MAX_VALUE);
            this.mound_armor = builder.comment("Default 2").defineInRange("Sets Mound Armor", 2, 1, Double.MAX_VALUE);
            this.mound_cooldown = builder.comment("Default 600").defineInRange("Sets Mound Infection Cooldown", 600, 1, Integer.MAX_VALUE);
            this.mound_age = builder.comment("Default 12000").defineInRange("Sets Mound Ageing Cooldown", 18000, 1, Integer.MAX_VALUE);
            this.mound_tendril_checker = builder.comment("Default 80").defineInRange("Sets the range in which a mound checks for feedable blocks", 80, 1, Integer.MAX_VALUE);
            this.mound_tendril_feed = builder.comment("Default 2").defineInRange("Sets the amount of biomass a mound can feed a structure block at once", 2, 1, Integer.MAX_VALUE);
            this.mound_range_default = builder.comment("Default 5").defineInRange("Sets Mound default range", 5, 1, Double.MAX_VALUE);
            this.mound_range_age2 = builder.comment("Default 10").defineInRange("Sets Mound range at the age of 2", 10, 1, Double.MAX_VALUE);
            this.mound_range_age3 = builder.comment("Default 15").defineInRange("Sets Mound range at the age of 3", 15, 1, Double.MAX_VALUE);
            this.mound_range_age4 = builder.comment("Default 20").defineInRange("Sets Mound range at the age of 4", 20, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Proto Hivemind");
            this.proto_hp = builder.comment("Default 100").defineInRange("Sets Proto Max health", 100, 1, Double.MAX_VALUE);
            this.proto_armor = builder.comment("Default 10").defineInRange("Sets Proto Armor", 10, 1, Double.MAX_VALUE);
            this.proto_damage = builder.comment("Default 10").defineInRange("Sets Proto Melee damage", 10, 1, Double.MAX_VALUE);
            this.proto_dpsr = builder.comment("Default 20").defineInRange("Sets Proto Damage Cap , set to 0 to disable", 20, 1, Double.MAX_VALUE);
            this.proto_range = builder.comment("Default 300").defineInRange("Sets the linking range", 300, 1, Integer.MAX_VALUE);
            this.proto_calamity = builder.comment("Default 5").defineInRange("Chance for the death of a linked evolved infected to trigger the hivemind", 5, 0, Double.MAX_VALUE);
            this.proto_chunk = builder.comment("Default true").define("Should the hivemind generate a chunkloader at its location?",true);
            this.proto_raid = builder.comment("Default true").define("Should the hivemind send Vigils to raid?",true);
            this.proto_sapient_target = builder.defineList("Sentient Mobs targeted by the hivemind",
                    Lists.newArrayList("minecraft:villager","minecraft:pillager","guardvillagers:guard","minecraft:evoker","minecraft:vindicator",
                            "recruits:recruit","recruits:bowman","recruits:recruit_shieldman", "recruits:nomad","recruits:horseman","roamers:roamer") , o -> o instanceof String);
            builder.pop();

            builder.push("Howler");
            this.how_hp = builder.comment("Default 32").defineInRange("Sets Howler Max health", 32, 1, Double.MAX_VALUE);
            this.how_damage = builder.comment("Default 5").defineInRange("Sets Howler Damage", 5, 1, Double.MAX_VALUE);
            this.how_armor = builder.comment("Default 4").defineInRange("Sets Howler Armor", 4, 1, Double.MAX_VALUE);
            this.howler_effects_buff = builder.defineList("Howler buff effect list",
                    Lists.newArrayList("minecraft:regeneration","minecraft:speed","minecraft:health_boost","minecraft:strength","minecraft:resistance" ) , o -> o instanceof String);
            this.howler_summon = builder.defineList("Mobs that can be summoned by the Howler",
                    Lists.newArrayList("spore:inf_human","spore:inf_villager","spore:inf_pillager","spore:knight" ) , o -> o instanceof String);
            builder.pop();

            builder.push("Infected Pillager");
            this.inf_pil_hp = builder.comment("Default 20").defineInRange("Sets Infected Pillager Max health", 20, 1, Double.MAX_VALUE);
            this.inf_pil_damage = builder.comment("Default 6").defineInRange("Sets Infected Pillager Damage", 6, 1, Double.MAX_VALUE);
            this.inf_pil_armor = builder.comment("Default 2").defineInRange("Sets Infected Pillager Armor", 2, 1, Double.MAX_VALUE);
            this.inf_pil_range_damage = builder.comment("Default 1.6f").define("Sets Infected Pillager Range Damage",1.6);
            builder.pop();

            builder.push("Womb");
            this.reconstructor_hp = builder.comment("Default 30").defineInRange("Sets the base health of the reconstructor", 30, 1, Double.MAX_VALUE);
            this.reconstructor_armor = builder.comment("Default 6").defineInRange("Sets the base armor of the reconstructor", 6, 1, Double.MAX_VALUE);
            this.recontructor_clock = builder.comment("Default 30").defineInRange("Sets the time before it gains one biomass", 30, 1, Integer.MAX_VALUE);
            this.reconstructor_assimilation = builder.comment("Default 10").defineInRange("How much biomass does it get from assimilating infected", 10, 1, Integer.MAX_VALUE);
            this.reconstructor_biomass = builder.comment("Default 100").defineInRange("Sets the maximum biomass before it summons a calamity", 100, 1, Integer.MAX_VALUE);
            this.reconstructor_terrain = builder.defineList("Mobs that are summoned for ground support",
                    Lists.newArrayList("spore:sieger" ) , o -> o instanceof String);
            this.reconstructor_air = builder.defineList("Mobs that are summoned for air support",
                    Lists.newArrayList("spore:sieger" ) , o -> o instanceof String);
            this.reconstructor_water = builder.defineList("Mobs that are summoned for water support",
                    Lists.newArrayList("spore:sieger" ) , o -> o instanceof String);
            builder.pop();


            builder.push("Scent");
            this.scent_spawn = builder.comment("Default true").define("Should scent spawn?",true);
            this.scent_particles = builder.comment("Default true").define("Should scent have particles?",true);
            this.scent_life = builder.comment("Default 4000").define("Scent life",4000);
            this.scent_effects_buff = builder.defineList("Overcharged Scent buff effect list",
                    Lists.newArrayList("minecraft:regeneration","minecraft:speed","minecraft:health_boost","minecraft:strength","minecraft:resistance" ) , o -> o instanceof String);
            this.scent_kills = builder.comment("Default 4").define("OverCharged Scent bonus kill points",4);
            this.scent_spawn_chance = builder.comment("Default 5").define("The Chance for the scent to spawn from a mob dying 1-100",5);
            this.inf_summon = builder.defineList("Mobs that can be summoned by the Scent",
                    Lists.newArrayList(
                            "spore:inf_human"
                            ,"spore:inf_villager"
                            ,"spore:inf_pillager" ) , o -> o instanceof String);
            this.scent_summon = builder.comment("Default true").define("Should scent summon entities?",true);
            this.scent_summon_cooldown = builder.comment("Default 300").define("The average amount of time it will take for a mob to be summoned",300);
            builder.pop();

            builder.push("Infected Villager");
            this.inf_vil_hp = builder.comment("Default 20").defineInRange("Sets Infected Villager Max health", 20, 1, Double.MAX_VALUE);
            this.inf_vil_damage = builder.comment("Default 6").defineInRange("Sets Infected Villager Damage", 6, 1, Double.MAX_VALUE);
            this.inf_vil_armor = builder.comment("Default 1").defineInRange("Sets Infected Villager Armor", 1, 0, Double.MAX_VALUE);


            builder.pop();

            builder.push("Stalker");
            this.stalker_hp = builder.comment("Default 55").defineInRange("Sets Stalker Max health", 55, 1, Double.MAX_VALUE);
            this.stalker_damage = builder.comment("Default 10").defineInRange("Sets Stalker Damage", 10, 1, Double.MAX_VALUE);
            this.stalker_armor = builder.comment("Default 3").defineInRange("Sets Stalker Armor", 3, 0, Double.MAX_VALUE);
            builder.pop();

            builder.push("Infected Wandering Trader");
            this.inf_van_hp = builder.comment("Default 20").defineInRange("Sets Infected Wandering Trader Max health", 20, 1, Double.MAX_VALUE);
            this.inf_van_damage = builder.comment("Default 6").defineInRange("Sets Infected Wandering Trader Damage", 6, 1, Double.MAX_VALUE);
            this.inf_van_armor = builder.comment("Default 1").defineInRange("Sets Infected Wandering Trader Armor", 1, 0, Double.MAX_VALUE);
            this.inf_van_potion = builder.comment("Default true").define("Can the Infected Wandering Trader use Potions", true);
            builder.pop();

            builder.push("Infected Witch");
            this.inf_witch_hp = builder.comment("Default 25").defineInRange("Sets Infected Witch Max health", 25, 1, Double.MAX_VALUE);
            this.inf_witch_armor = builder.comment("Default 1").defineInRange("Sets Infected Witch Armor", 1, 0, Double.MAX_VALUE);
            this.inf_witch_melee_damage = builder.comment("Default 4").defineInRange("Sets Infected Witch Melee Damage", 4, 0, Double.MAX_VALUE);
            this.buffing_potions = builder.defineList("Potions that are used to buff infected , NOT effects",
                    Lists.newArrayList("minecraft:invisibility","minecraft:swiftness","minecraft:strength" ) , o -> o instanceof String);
            this.harming_potions = builder.defineList("Potions that are used to attack others , NOT effects",
                    Lists.newArrayList("minecraft:weakness","minecraft:poison","spore:mycelium_potion","spore:marker_potion" ) , o -> o instanceof String);
            this.use_potions = builder.comment("Default true").define("Should Witches use Potions?",true);
            this.at_potion_meter = builder.comment("Default 60").defineInRange("Sets the time before throwing a potion when attacking", 60, 1, Integer.MAX_VALUE);
            this.buff_potion_meter = builder.comment("Default 40").defineInRange("Sets the time before throwing a potion when buffing", 40, 1, Integer.MAX_VALUE);
            builder.pop();

            builder.push("Braiomil");
            this.braio_hp = builder.comment("Default 25").defineInRange("Sets Braiomil Max health", 25, 1, Double.MAX_VALUE);
            this.braio_armor = builder.comment("Default 4").defineInRange("Sets Braiomil Armor", 4, 1, Double.MAX_VALUE);
            this.braio_melee_damage = builder.comment("Default 8").defineInRange("Sets Braiomil Melee Damage", 8, 1, Double.MAX_VALUE);
            this.braio_effects = builder.comment("Default values: minecraft:poison|120|0 ,spore:mycelium|600|0 ,spore:marker|2400|1").defineList("Braiomil Effects",
                    Lists.newArrayList("minecraft:poison|120|0" , "spore:mycelium_ef|600|1","spore:marker|2400|1") , o -> o instanceof String);
            builder.pop();


            builder.push("Infected Human");
            this.inf_human_hp = builder.comment("Default 15").defineInRange("Sets Infected Human Max health", 15, 1, Double.MAX_VALUE);
            this.inf_human_damage = builder.comment("Default 6").defineInRange("Sets Infected Human Damage", 6, 1, Double.MAX_VALUE);
            this.inf_human_armor = builder.comment("Default 1").defineInRange("Sets Infected Human Armor", 1, 0, Double.MAX_VALUE);
            builder.pop();
            builder.push("Knight ");
            this.knight_hp = builder.comment("Default 25").defineInRange("Sets Knight Max health", 25, 1, Double.MAX_VALUE);
            this.knight_damage = builder.comment("Default 7").defineInRange("Sets Knight Damage", 7, 1, Double.MAX_VALUE);
            this.knight_armor = builder.comment("Default 7").defineInRange("Sets Knight Armor", 7, 1, Double.MAX_VALUE);
            builder.pop();
            builder.push("Leaper ");
            this.leap_hp = builder.comment("Default 55").defineInRange("Sets Leaper Max health", 55, 1, Double.MAX_VALUE);
            this.leap_damage = builder.comment("Default 8").defineInRange("Sets Leaper Damage", 8, 1, Double.MAX_VALUE);
            this.leap_armor = builder.comment("Default 3").defineInRange("Sets Leaper Armor", 3, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Slasher ");
            this.sla_hp = builder.comment("Default 35").defineInRange("Sets Slasher Max health", 35, 1, Double.MAX_VALUE);
            this.sla_damage = builder.comment("Default 10").defineInRange("Sets Slasher Damage", 10, 1, Double.MAX_VALUE);
            this.sla_armor = builder.comment("Default 2").defineInRange("Sets Slasher Armor", 2, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Scamper ");
            this.scamper_hp = builder.comment("Default 35").defineInRange("Sets Scamper Max health", 25, 1, Double.MAX_VALUE);
            this.scamper_damage = builder.comment("Default 10").defineInRange("Sets Scamper Damage", 6, 1, Double.MAX_VALUE);
            this.scamper_armor = builder.comment("Default 2").defineInRange("Sets Scamper Armor", 3, 1, Double.MAX_VALUE);
            this.scamper_age = builder.comment("Default 12000").defineInRange("Sets Scamper Age", 12000, 1, Integer.MAX_VALUE);
            this.scamper_summon = builder.comment("Default true").define("Should a Scamper Summon Mounds on death?",true);
            builder.pop();

            builder.push("Infected Player");
            this.player_hp = builder.comment("Default 21").defineInRange("Infected Player Max health", 21, 1, Double.MAX_VALUE);
            this.player_damage = builder.comment("Default 4").defineInRange("Infected Player Damage", 4, 1, Double.MAX_VALUE);
            this.player_armor = builder.comment("Default 2").defineInRange("Infected Player Armor", 2, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Spitter");
            this.spit_hp = builder.comment("Default 15").defineInRange("Sets Spiter Max health", 15, 1, Double.MAX_VALUE);
            this.spit_armor = builder.comment("Default 1").defineInRange("Sets Spitter Armor", 1, 1, Double.MAX_VALUE);
            this.spit_damage_l = builder.comment("Default 6").defineInRange("Sets Spitter Damage at long range", 6, 1, Double.MAX_VALUE);
            this.spit_damage_c = builder.comment("Default 1").defineInRange("Sets Spitter Damage at close range", 1, 1, Double.MAX_VALUE);
            builder.pop();

            builder.push("Griefer");
            this.griefer_armor = builder.comment("Default 3").defineInRange("Sets Griefer Armor", 3, 1, Double.MAX_VALUE);
            this.griefer_hp = builder.comment("Default 45").defineInRange("Sets Griefer Max health", 45, 1, Double.MAX_VALUE);
            this.griefer_damage = builder.comment("Default 5").defineInRange("Sets Griefer Damage", 5, 1, Double.MAX_VALUE);
            this.explosion = builder.comment("Default 2").define("Explosion Radius",2);
            this.explosion_on = builder.comment("Default true").define("Should explosion break blocks ?",true);
            builder.pop();
            builder.pop();


            builder.push("Spawns");
            this.spawn = builder.comment("Default false").define("Should mobs spawn after a few days?",false);
            this.mob_cap = builder.comment("Default 30").define("MobCap",30);
            this.dimension_parameters = builder.comment("Default minecraft:is_overworld").defineList("Dictates in what biome the infected spawn",
                    Lists.newArrayList("minecraft:is_overworld") , o -> o instanceof String);
            this.days = builder.comment("Default 3").define("Days before infected start spawning",3);
            this.spawns = builder.defineList("mob|weight|minimum|maximum",
                    Lists.newArrayList("spore:inf_human|80|2|5","spore:inf_drowned|10|1|2","spore:inf_pillager|40|1|3","spore:inf_villager|70|1|3","spore:inf_player|20|1|2"
                            ,"spore:inf_wanderer|25|1|2","spore:inf_witch|25|1|2","spore:inf_vindicator|1|1|2","spore:inf_evoker|5|1|2") , o -> o instanceof String);
            builder.pop();


            builder.push("Weapons and Tools OwO");
            builder.push("Spear");
            this.spear_durability = builder.comment("Default 800").define("Durability",800);
            this.spear_damage = builder.comment("Default 11").defineInRange("Melee Damage", 11, 1, Integer.MAX_VALUE);
            this.spear_range = builder.comment("Default 12").define("Ranged Damage",12);
            builder.pop();
            builder.push("Saber");
            this.saber_durability = builder.comment("Default 1000").define("Durability",1000);
            this.saber_damage = builder.comment("Default 8").defineInRange("Damage", 8, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Knife");
            this.knife_durability = builder.comment("Default 400").define("Durability",400);
            this.knife_damage = builder.comment("Default 6").defineInRange("Damage", 6, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("GreatSword");
            this.greatsword_durability = builder.comment("Default 2000").define("Durability",2000);
            this.greatsword_damage = builder.comment("Default 12").defineInRange("Damage", 12, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Crossbow");
            this.crossbow_durability = builder.comment("Default 700").define("Crossbow Durability",700);
            this.crossbow_arrow_damage_multiplier = builder.comment("Default 1.0").define("Crossbow Range Damage Modifier",1.0);
             builder.pop();
            builder.push("Bow");
            this.bow_durability = builder.comment("Default 700").define("Bow Durability",700);
            this.bow_arrow_damage_multiplier = builder.comment("Default 1.0").define("Bow Range Damage Modifier",1.0);
            this.bow_melee_damage = builder.comment("Default 5").defineInRange("Damage", 5, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Armads");
            this.armads_durability = builder.comment("Default 2500").define("Durability",2500);
            this.armads_damage = builder.comment("Default 15").defineInRange("Damage", 15, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Maul");
            this.maul_durability = builder.comment("Default 3000").define("Durability",3000);
            this.maul_damage = builder.comment("Default 7").defineInRange("Damage", 7, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Sickle");
            this.sickle_durability = builder.comment("Default 1200").define("Durability",1200);
            this.sickle_damage = builder.comment("Default 12").defineInRange("Damage", 12, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Scythe");
            this.scythe_durability = builder.comment("Default 1200").define("Durability",1200);
            this.scythe_damage = builder.comment("Default 8").defineInRange("Damage", 8, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Combat Shovel");
            this.shovel_durability = builder.comment("Default 2800").define("Durability",2800);
            this.shovel_damage = builder.comment("Default 6").defineInRange("Damage", 6, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Rapier");
            this.rapier_durability = builder.comment("Default 900").define("Durability",900);
            this.rapier_damage = builder.comment("Default 10").defineInRange("Damage", 10, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Mace");
            this.mace_durability = builder.comment("Default 1000").define("Durability",1000);
            this.mace_damage = builder.comment("Default 9").defineInRange("Damage", 9, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.pop();
            builder.push("Living Exoskeleton");
            builder.push("Helmet");
            this.helmet_durability = builder.comment("Default 350").defineInRange("Helmet Durability", 350, 1, Integer.MAX_VALUE);
            this.helmet_protection = builder.comment("Default 4").defineInRange("Helmet Protection", 4, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Chestplate");
            this.chestplate_durability = builder.comment("Default 500").defineInRange("Chestplate Durability", 500, 1, Integer.MAX_VALUE);
            this.chestplate_protection = builder.comment("Default 10").defineInRange("Chestplate Protection", 10, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Chestplate Upgraded");
            this.chestplate_up_durability = builder.comment("Default 700").defineInRange("Chestplate Durability", 700, 1, Integer.MAX_VALUE);
            this.chestplate_up_protection = builder.comment("Default 13").defineInRange("Chestplate Protection", 13, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Leggings");
            this.pants_durability = builder.comment("Default 400").defineInRange("Leggings Durability", 400, 1, Integer.MAX_VALUE);
            this.pants_protection = builder.comment("Default 9").defineInRange("Leggings Protection", 9, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Boots");
            this.boots_durability = builder.comment("Default 350").defineInRange("Boots Durability", 350, 1, Integer.MAX_VALUE);
            this.boots_protection = builder.comment("Default 4").defineInRange("Boots Protection", 4, 1, Integer.MAX_VALUE);
            builder.pop();
            this.armor_toughness = builder.comment("Default 1").defineInRange("Armor Toughness", 1, 0, Integer.MAX_VALUE);
            this.knockback_resistance = builder.comment("Default 1").defineInRange("Armor Knockback Resistance", 1, 0, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Plated Exoskeleton");
            builder.push("Helmet");
            this.helmet_durability1 = builder.comment("Default 350").defineInRange("Helmet Durability", 450, 1, Integer.MAX_VALUE);
            this.helmet_protection1 = builder.comment("Default 3").defineInRange("Helmet Protection", 3, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Chestplate");
            this.chestplate_durability1 = builder.comment("Default 500").defineInRange("Chestplate Durability", 600, 1, Integer.MAX_VALUE);
            this.chestplate_protection1 = builder.comment("Default 7").defineInRange("Chestplate Protection", 7, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Leggings");
            this.pants_durability1 = builder.comment("Default 400").defineInRange("Leggings Durability", 500, 1, Integer.MAX_VALUE);
            this.pants_protection1 = builder.comment("Default 6").defineInRange("Leggings Protection", 5, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Boots");
            this.boots_durability1 = builder.comment("Default 350").defineInRange("Boots Durability", 450, 1, Integer.MAX_VALUE);
            this.boots_protection1 = builder.comment("Default 2").defineInRange("Boots Protection", 2, 1, Integer.MAX_VALUE);
            builder.pop();
            this.armor_toughness1 = builder.comment("Default 1").defineInRange("Armor Toughness", 1, 0, Integer.MAX_VALUE);
            this.knockback_resistance1 = builder.comment("Default 0").defineInRange("Armor Knockback Resistance", 0, 0, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Flesh Exoskeleton");
            builder.push("Helmet");
            this.helmet_durability2 = builder.comment("Default 350").defineInRange("Helmet Durability", 350, 1, Integer.MAX_VALUE);
            this.helmet_protection2 = builder.comment("Default 2").defineInRange("Helmet Protection", 2, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Chestplate");
            this.chestplate_durability2 = builder.comment("Default 500").defineInRange("Chestplate Durability", 500, 1, Integer.MAX_VALUE);
            this.chestplate_protection2 = builder.comment("Default 6").defineInRange("Chestplate Protection", 6, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Leggings");
            this.pants_durability2 = builder.comment("Default 400").defineInRange("Leggings Durability", 400, 1, Integer.MAX_VALUE);
            this.pants_protection2 = builder.comment("Default 5").defineInRange("Leggings Protection", 5, 1, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Boots");
            this.boots_durability2 = builder.comment("Default 350").defineInRange("Boots Durability", 350, 1, Integer.MAX_VALUE);
            this.boots_protection2 = builder.comment("Default 2").defineInRange("Boots Protection", 2, 1, Integer.MAX_VALUE);
            builder.pop();
            this.armor_toughness2 = builder.comment("Default 0").defineInRange("Armor Toughness", 0, 0, Integer.MAX_VALUE);
            this.knockback_resistance2 = builder.comment("Default 0").defineInRange("Armor Knockback Resistance", 0, 0, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Elytron");
            this.ely_knockback_resistance = builder.comment("Default 0").defineInRange("Knockback Resistance", 0, 0, Integer.MAX_VALUE);
            this.ely_durability = builder.comment("Default 500").defineInRange("Durability", 500, 1, Integer.MAX_VALUE);
            this.ely_protection = builder.comment("Default 5").defineInRange("Protection", 5, 1, Integer.MAX_VALUE);
            this.ely_toughness = builder.comment("Default 1").defineInRange("Toughness", 1, 0, Integer.MAX_VALUE);
            builder.pop();
        }
    }

    public static class DataGen{
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_human_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_villager_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_pillager_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_witch_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_wan_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_vin_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_evoker_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_braio_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_knight_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_griefer_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_leap_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_spitter_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_slasher_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_howler_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_stalker_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_brute_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_claw_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_bus_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_drow_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> inf_player_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> sca_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> sieger_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> sieger_tail_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> vigil_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> proto_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> mound_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> organite_loot;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> innards_loot;


        public final ForgeConfigSpec.ConfigValue<List<? extends String>> name;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> player_h;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> player_c;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> player_l;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> player_b;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> player_ho;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> player_hm;

        public final ForgeConfigSpec.ConfigValue<Integer> biomass_lump_kills;
        public final ForgeConfigSpec.ConfigValue<Integer> hive_spawn_kills;

        public final ForgeConfigSpec.ConfigValue<List<? extends String>> block_infection;
        public DataGen(ForgeConfigSpec.Builder builder){
            builder.push("LootTables");
            builder.comment("item|chance to drop(1-100)|minimum amount|maximum amount.Only values above 0 will be taken in consideration.");
            this.inf_human_loot = builder.defineList("Infected Human",
                    Lists.newArrayList("spore:mutated_fiber|50|1|3","spore:mutated_heart|10|1|1") , o -> o instanceof String);
            this.inf_drow_loot = builder.defineList("Infected Drowned",
                    Lists.newArrayList("spore:mutated_fiber|50|1|3","spore:mutated_heart|5|1|1","minecraft:copper_ingot|15|1|1") , o -> o instanceof String);
            this.inf_villager_loot = builder.defineList("Infected Villager",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:mutated_heart|10|1|1","spore:cerebrum|25|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_pillager_loot = builder.defineList("Infected Pillager",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:mutated_heart|10|1|1","spore:cerebrum|25|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_witch_loot = builder.defineList("Infected Witch",
                    Lists.newArrayList("spore:mutated_fiber|50|1|3" ,"minecraft:stick|60|1|6","minecraft:glowstone_dust|30|1|3","spore:cerebrum|30|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_wan_loot = builder.defineList("Infected Wandering Trader",
                    Lists.newArrayList("spore:mutated_fiber|80|2|5","spore:mutated_heart|10|1|1","spore:cerebrum|30|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_evoker_loot = builder.defineList("Infected Evoker",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:armor_fragment|70|1|3","spore:claw_fragment|80|3|6","spore:mutated_heart|10|1|1","spore:cerebrum|25|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_vin_loot = builder.defineList("Infected Vindicator",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:armor_fragment|80|1|4","spore:mutated_heart|10|1|1","spore:cerebrum|25|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_claw_loot = builder.defineList("Claw ",
                    Lists.newArrayList("spore:mutated_fiber|50|1|3","spore:armor_fragment|80|1|2","spore:claw_fragment|80|2|6") , o -> o instanceof String);
            this.inf_player_loot = builder.defineList("Infected Adventurer",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:mutated_heart|10|1|1") , o -> o instanceof String);

            this.inf_braio_loot = builder.defineList("Braiomil ",
                    Lists.newArrayList("spore:mutated_fiber|80|1|3","spore:armor_fragment|50|1|2","spore:mutated_heart|10|1|1","spore:alveolic_sack|40|1|3") , o -> o instanceof String);
            this.inf_knight_loot = builder.defineList("Knight ",
                    Lists.newArrayList("spore:mutated_fiber|70|1|5","spore:armor_fragment|80|4|9","spore:mutated_heart|10|1|1","spore:claw_fragment|80|6|9") , o -> o instanceof String);
            this.inf_griefer_loot = builder.defineList("Griefer ",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:armor_fragment|80|2|4","spore:mutated_heart|10|1|1","spore:claw_fragment|80|3|6","spore:tumor|100|1|3","spore:innards|50|1|1") , o -> o instanceof String);
            this.inf_bus_loot = builder.defineList("Phayres ",
                    Lists.newArrayList("spore:mutated_fiber|80|1|3","spore:armor_fragment|50|1|2","spore:mutated_heart|10|1|1","spore:wing_membrane|60|1|3") , o -> o instanceof String);

            this.inf_spitter_loot = builder.defineList("Spitter ",
                    Lists.newArrayList("spore:mutated_fiber|80|1|3","spore:armor_fragment|50|1|2","spore:mutated_heart|10|1|1","spore:cerebrum|20|1|1","spore:spine_fragment|15|1|3","spore:corrosive_sack|30|1|1") , o -> o instanceof String);
            this.inf_slasher_loot = builder.defineList("Slasher ",
                    Lists.newArrayList("spore:mutated_fiber|70|1|5","spore:armor_fragment|80|4|9","spore:mutated_heart|10|1|1","spore:cerebrum|20|1|1","spore:spine_fragment|15|1|3","spore:sickle_fragment|60|1|1") , o -> o instanceof String);
            this.inf_leap_loot = builder.defineList("Leaper ",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:innards|50|1|1","spore:armor_fragment|80|2|4","spore:mutated_heart|10|1|1","spore:claw_fragment|80|3|6","spore:cerebrum|20|1|1","spore:spine_fragment|15|1|3","spore:tendons|60|3|7") , o -> o instanceof String);

            this.inf_howler_loot = builder.defineList("Howler ",
                    Lists.newArrayList("spore:mutated_fiber|80|1|3","spore:armor_fragment|50|1|2","spore:mutated_heart|10|1|1","spore:cerebrum|20|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);
            this.inf_stalker_loot = builder.defineList("Stalker ",
                    Lists.newArrayList("spore:mutated_fiber|70|1|5","spore:armor_fragment|80|3|6","spore:mutated_heart|10|1|1","spore:claw_fragment|80|1|4","spore:cerebrum|20|1|1","spore:spine_fragment|15|1|3","spore:altered_spleen|30|1|1") , o -> o instanceof String);
            this.inf_brute_loot = builder.defineList("Brute ",
                    Lists.newArrayList("spore:mutated_fiber|50|2|5","spore:innards|50|1|1","spore:armor_fragment|80|5|12","spore:mutated_heart|10|1|1","spore:cerebrum|20|1|1","spore:spine_fragment|15|1|3") , o -> o instanceof String);

            this.sca_loot = builder.defineList("Scamper ",
                    Lists.newArrayList("spore:mutated_fiber|50|1|4","spore:armor_fragment|80|1|3","spore:mutated_heart|10|1|1","spore:tumor|100|1|1") , o -> o instanceof String);

            this.sieger_loot = builder.defineList("Sieger ",
                    Lists.newArrayList("spore:mutated_fiber|100|33|75","spore:armor_fragment|100|15|38","spore:mutated_heart|70|3|7","spore:tumor|100|2|5","spore:cerebrum|70|2|7","spore:spine_fragment|56|4|9") , o -> o instanceof String);

            this.sieger_tail_loot = builder.defineList("Sieger Tail",
                    Lists.newArrayList("spore:mutated_fiber|100|10|25","spore:armor_fragment|100|3|10","spore:tumor|100|7|22") , o -> o instanceof String);


            this.proto_loot = builder.defineList("Proto Hivemind ",
                    Lists.newArrayList("spore:mutated_fiber|100|10|20","spore:armor_fragment|80|4|14","spore:mutated_heart|80|1|6","spore:cerebrum|100|2|11","spore:spine_fragment|80|2|8") , o -> o instanceof String);


            this.mound_loot = builder.defineList("Mound ",
                    Lists.newArrayList("spore:mutated_fiber|70|2|5") , o -> o instanceof String);

            this.vigil_loot = builder.defineList("Vigil",
                    Lists.newArrayList("spore:mutated_fiber|100|6|15","spore:mutated_heart|30|1|1") , o -> o instanceof String);


            this.organite_loot = builder.defineList("Organite Block",
                    Lists.newArrayList("spore:mutated_fiber|50|1|4","spore:spine|80|1|3","spore:innards|70|1|5") , o -> o instanceof String);

            this.innards_loot = builder.defineList("Innards",
                    Lists.newArrayList("minecraft:bone_meal|50|1|2","minecraft:rotten_flesh|40|1|1","minecraft:wheat_seeds|40|1|1") , o -> o instanceof String);

            builder.pop();
            builder.push("Others");
            this.name = builder.defineList("Infected Player possible names",
                    Lists.newArrayList(
                            "The_Harbinger69", "ABucketOfFriedChicken", "LoneGuy", "cheesepuff", "Sire_AwfulThe1st", "Azami",
                            "Deyvid", "Dany_Why", "Technoblade", "Ike", "Hypnotizd", "SaDrOcK:(", "JhonOK22", "hacie", "WhisperFire26",
                            "Pajera", "Gistique", "Demonid", "Bowser", "Mad_Dog", "Ripley", "Kraken", "Zero", "Joker_de_Coeur", "bartsek009 ",
                            "xXFuryXx", "Nova69", "Belladonna","Entity","Keymind","Whisper","Helldwin",
                            "Mademoiselle2016") , o -> o instanceof String);
            builder.comment("Items|chance of giving");
            this.player_h = builder.defineList("Head Slot",
                    Lists.newArrayList("minecraft:leather_helmet|50","minecraft:iron_helmet|20","minecraft:chainmail_helmet|20") , o -> o instanceof String);
            this.player_c = builder.defineList("Chest Slot",
                    Lists.newArrayList("minecraft:leather_chestplate|50","minecraft:iron_chestplate|20","minecraft:chainmail_chestplate|20") , o -> o instanceof String);
            this.player_l = builder.defineList("Legs Slot",
                    Lists.newArrayList("minecraft:leather_leggings|50","minecraft:iron_leggings|20","minecraft:chainmail_leggings|20") , o -> o instanceof String);
            this.player_b = builder.defineList("Boots Slot",
                    Lists.newArrayList("minecraft:leather_boots|50","minecraft:iron_boots|20","minecraft:chainmail_boots|20") , o -> o instanceof String);
            this.player_hm = builder.defineList("MainHand Slot",
                    Lists.newArrayList("minecraft:stone_sword|50" , "minecraft:stone_axe|20", "minecraft:pickaxe|20" , "minecraft:iron_sword|30") , o -> o instanceof String);
            this.player_ho = builder.defineList("OffHand Slot",
                    Lists.newArrayList("minecraft:torch|50","minecraft:shield|30") , o -> o instanceof String);

            builder.pop();
            builder.push("Structure data");
            this.biomass_lump_kills = builder.comment("Default 5").defineInRange("Biomass Lump minimal kills", 5, 0, Integer.MAX_VALUE);
            this.hive_spawn_kills = builder.comment("Default 50").defineInRange("Reconstructed Mind Block kills", 50, 0, Integer.MAX_VALUE);
            builder.pop();
            builder.push("Block infection");
            this.block_infection = builder.defineList("Blocks and their infected counterparts",
                    Lists.newArrayList("minecraft:stone|spore:infested_stone","minecraft:grass_block|minecraft:mycelium","minecraft:dirt|spore:infested_dirt","minecraft:coarse_dirt|spore:infested_dirt"
                            ,"minecraft:podzol|spore:infested_dirt","minecraft:rooted_dirt|spore:infested_dirt","minecraft:podzol|spore:infested_dirt","minecraft:deepslate|spore:infested_deepslate"
                            ,"minecraft:sand|spore:infested_sand","minecraft:gravel|spore:infested_gravel","minecraft:netherrack|spore:infested_netherrack","minecraft:end_stone|spore:infested_end_stone"
                            ,"minecraft:soulsand|spore:infested_soulsand","minecraft:soulsoil|spore:infested_soulsand","minecraft:sculk|spore:rooted_mycelium") , o -> o instanceof String);
            builder.pop();
        }
    }


    static {
        Pair<Server, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER = commonSpecPair.getLeft();
        SERVER_SPEC = commonSpecPair.getRight();

        Pair<DataGen , ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(DataGen::new);
        DATAGEN = commonPair.getLeft();
        DATAGEN_SPEC = commonPair.getRight();

    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }
}
