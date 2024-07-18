package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.SBlockEntities.BrainRemnantBlockEntity;
import com.Harbinger.Spore.SBlockEntities.CDUBlockEntity;
import com.Harbinger.Spore.SBlockEntities.LivingStructureBlocks;
import com.Harbinger.Spore.Sentities.BaseEntities.*;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedDrowned;
import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Slasher;
import com.Harbinger.Spore.Sentities.Hyper.Inquisitor;
import com.Harbinger.Spore.Sentities.Organoids.*;
import com.Harbinger.Spore.Sentities.Utility.GastGeber;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import com.Harbinger.Spore.Sentities.Variants.SlasherVariants;
import com.Harbinger.Spore.Sitems.InfectedCombatShovel;
import com.Harbinger.Spore.Sitems.InfectedMaul;
import com.Harbinger.Spore.Spore;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = Spore.MODID)
public class HandlerEvents {
    @SubscribeEvent
    public static void onLivingSpawned(EntityJoinLevelEvent event) {
        if (event != null && event.getEntity() != null) {
            if (event.getEntity() instanceof Proto && event.getLevel() instanceof ServerLevel serverLevel){
                SporeSavedData.addHivemind(serverLevel);
            }
            if (event.getEntity() instanceof PathfinderMob mob){

            for (String string : SConfig.SERVER.attack.get()){
                if (string.endsWith(":")){
                    String[] mod = string.split(":");
                    String[] iterations = mob.getEncodeId().split(":");
                    if (Objects.equals(mod[0], iterations[0])){
                        mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Infected.class, false));
                        mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Calamity.class, false));
                        mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Organoid.class, false));
                    }
                }else{
                    if (SConfig.SERVER.attack.get().contains(mob.getEncodeId())){
                        mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Infected.class, false));
                        mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Calamity.class, false));
                        mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, Organoid.class, false));
                    }
                }
            }
            for (String string : SConfig.SERVER.flee.get()){
                    if (string.endsWith(":")){
                        String[] mod = string.split(":");
                        String[] iterations = mob.getEncodeId().split(":");
                        if (Objects.equals(mod[0], iterations[0])){
                            mob.goalSelector.addGoal(4, new AvoidEntityGoal<>(mob, Infected.class, 6.0F, 1.0D, 0.9D));
                            mob.goalSelector.addGoal(4, new AvoidEntityGoal<>(mob, UtilityEntity.class, 8.0F, 1.0D, 0.9D));
                        }
                    }else{
                        if (SConfig.SERVER.flee.get().contains(mob.getEncodeId())){
                            mob.goalSelector.addGoal(4, new AvoidEntityGoal<>(mob, Infected.class, 6.0F, 1.0D, 0.9D));
                            mob.goalSelector.addGoal(4, new AvoidEntityGoal<>(mob, UtilityEntity.class, 8.0F, 1.0D, 0.9D));

                        }
                    }
            }
            }
        }
    }

    @SubscribeEvent
    public static  void Command(RegisterCommandsEvent event){
        event.getDispatcher().register(Commands.literal(Spore.MODID+":set_area")
        .executes(arguments -> {
            ServerLevel world = arguments.getSource().getLevel();
            int x = (int) arguments.getSource().getPosition().x();
            int y = (int) arguments.getSource().getPosition().y();
            int z = (int) arguments.getSource().getPosition().z();
            Entity entity = arguments.getSource().getEntity();
            if (entity == null)
                entity = FakePlayerFactory.getMinecraft(world);
             if (entity != null){
                 BlockPos pos = new BlockPos(x ,y,z);
                 AABB hitbox = entity.getBoundingBox().inflate(20);
                 List<Entity> entities = entity.level().getEntities(entity, hitbox);
                 for (Entity entity1 : entities) {
                     if(entity1 instanceof Infected infected) {
                         infected.setSearchPos(pos);
                     }else if (entity1 instanceof Calamity calamity){
                         calamity.setSearchArea(pos);
                     }
                 }
             }
            return 1;
        }).requires(s -> s.hasPermission(1)));
        event.getDispatcher().register(Commands.literal(Spore.MODID+":feed")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    Entity entity = arguments.getSource().getEntity();
                    if (entity == null)
                        entity = FakePlayerFactory.getMinecraft(world);
                    if (entity != null){
                        AABB hitbox = entity.getBoundingBox().inflate(20);
                        List<Entity> entities = entity.level().getEntities(entity, hitbox);
                        for (Entity entity1 : entities) {
                            if(entity1 instanceof Infected infected) {
                                infected.setKills(infected.getKills()+1);
                                infected.setEvoPoints(infected.getEvoPoints()+1);
                            }else if (entity1 instanceof Calamity calamity){
                                calamity.setKills(calamity.getKills()+1);
                            }
                        }
                    }
                    return 1;
                }).requires(s -> s.hasPermission(1)));
        event.getDispatcher().register(Commands.literal(Spore.MODID+":evolve")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    Entity entity = arguments.getSource().getEntity();
                    if (entity == null)
                        entity = FakePlayerFactory.getMinecraft(world);
                    if (entity != null){
                        AABB hitbox = entity.getBoundingBox().inflate(20);
                        List<Entity> entities = entity.level().getEntities(entity, hitbox);
                        for (Entity entity1 : entities) {
                            if(entity1 instanceof Infected infected) {
                                infected.setEvolution(SConfig.SERVER.evolution_age_human.get());
                                if (entity1 instanceof Scamper scamper){
                                    scamper.setAge(SConfig.SERVER.scamper_age.get());
                                }else if (infected instanceof EvolvedInfected evolvedInfected){
                                    evolvedInfected.setEvoPoints(SConfig.SERVER.min_kills_hyper.get());
                                }else
                                infected.setEvoPoints(SConfig.SERVER.min_kills.get());
                            }else if (entity1 instanceof Mound mound){
                                mound.setAge(mound.getAge()+1);
                            }else if (entity1 instanceof Calamity calamity){
                                calamity.ActivateAdaptation();
                            }
                        }
                    }
                    return 1;
                }).requires(s -> s.hasPermission(1)));
        event.getDispatcher().register(Commands.literal(Spore.MODID+":get_data")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    Entity entity = arguments.getSource().getEntity();
                    if (entity instanceof Player player){
                        SporeSavedData data = SporeSavedData.getDataLocation(world);
                        int time = data.getMinutesBeforeSpawning();
                        int numberofprotos = data.getAmountOfHiveminds();
                        player.displayClientMessage(Component.literal("There are "+numberofprotos + " proto hiveminds in this dimension"),false);
                        if (SConfig.SERVER.spawn.get())
                            player.displayClientMessage(Component.literal("Time before spawns "+time + "/"+1200*SConfig.SERVER.days.get()),false);
                    }
                    return 1;
                }).requires(s -> s.hasPermission(1)));
        if (SConfig.SERVER.spawn.get()){
            event.getDispatcher().register(Commands.literal(Spore.MODID+":add_day")
                    .executes(arguments -> {
                        ServerLevel world = arguments.getSource().getLevel();
                        SporeSavedData.addDay(world);
                        return 1;
                    }).requires(s -> s.hasPermission(1)));
        }
        event.getDispatcher().register(Commands.literal(Spore.MODID+":check_entity")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    Entity entity = arguments.getSource().getEntity();
                    if (entity == null)
                        entity = FakePlayerFactory.getMinecraft(world);
                    if (entity instanceof Player player && !player.level().isClientSide){
                        AABB hitbox = entity.getBoundingBox().inflate(5);
                        List<Entity> entities = entity.level().getEntities(entity, hitbox);
                        for (Entity entity1 : entities) {
                            if(entity1 instanceof Infected infected) {
                                player.displayClientMessage(Component.literal("Entity "+ infected.getEncodeId() + " " + infected.getCustomName()),false);
                                player.displayClientMessage(Component.literal("Current Health " + infected.getHealth() + "/" + infected.getMaxHealth()),false);
                                player.displayClientMessage(Component.literal("Kills " + infected.getKills()),false);
                                player.displayClientMessage(Component.literal("Evolution Points " + infected.getEvoPoints()),false);
                                player.displayClientMessage(Component.literal("Position to be Searched " + infected.getSearchPos()),false);
                                player.displayClientMessage(Component.literal("Buffs " + infected.getActiveEffects()),false);
                                player.displayClientMessage(Component.literal("Seconds until evolution: " + infected.getEvolutionCoolDown() + "/" + SConfig.SERVER.evolution_age_human.get()),false);
                                player.displayClientMessage(Component.literal("Seconds until starvation: " + infected.getHunger() + "/" + (SConfig.SERVER.hunger.get())),false);
                                player.displayClientMessage(Component.literal("Is Linked ? " + infected.getLinked()),false);
                                player.displayClientMessage(Component.literal("Target ? " + infected.getTarget()),false);
                                player.displayClientMessage(Component.literal("Partner ? " + infected.getFollowPartner()),false);
                                if (infected instanceof Scamper scamper){
                                    player.displayClientMessage(Component.literal("Time before overtake ? " + scamper.getAge()+"/"+SConfig.SERVER.scamper_age.get()),false);
                                }
                                if (infected instanceof Hyper scamper){
                                    player.displayClientMessage(Component.literal("get nest location ? " + scamper.getNestLocation()),false);
                                }
                                if (infected instanceof GastGeber geber){
                                        player.displayClientMessage(Component.literal("RootTimer ? " + geber.getTimeRooted()),false);
                                        player.displayClientMessage(Component.literal("Aggression ? " + geber.getAggression()),false);
                                        player.displayClientMessage(Component.literal("Spread ? " + geber.getSpreadInterval()),false);
                                }
                                player.displayClientMessage(Component.literal("-------------------------"),false);

                            }else if (entity1 instanceof Calamity calamity){
                                    player.displayClientMessage(Component.literal("Entity "+ calamity.getEncodeId() + " " + calamity.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + calamity.getHealth() + "/" + calamity.getMaxHealth()),false);
                                    player.displayClientMessage(Component.literal("Kills " + calamity.getKills()),false);
                                    player.displayClientMessage(Component.literal("Position to be Searched " + calamity.getSearchArea()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + calamity.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Target ? " + calamity.getTarget()),false);
                                    if (calamity instanceof Sieger sieger){
                                        player.displayClientMessage(Component.literal("Tail health "+ sieger.getTailHp()+"/"+sieger.getMaxTailHp()),false);
                                    }
                                    if (calamity instanceof Gazenbrecher sieger){
                                        player.displayClientMessage(Component.literal("Tongue health "+ sieger.getTongueHp()+"/"+sieger.getMaxTongueHp()),false);
                                        player.displayClientMessage(Component.literal("Is adapted to fire "+ sieger.isAdaptedToFire() + " fire points" + sieger.getAdaptationCount()),false);
                                    }
                                    if (calamity instanceof Hinderburg sieger){
                                        player.displayClientMessage(Component.literal("Is armed "+ sieger.isArmed()),false);
                                    }
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }else if (entity1 instanceof Mound mound){
                                    player.displayClientMessage(Component.literal("Entity "+ mound.getEncodeId() + " " + mound.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + mound.getHealth() + "/" + mound.getMaxHealth()),false);
                                    player.displayClientMessage(Component.literal("Is Linked ? " + mound.getLinked()),false);
                                    player.displayClientMessage(Component.literal("Age " + mound.getAge()),false);
                                    player.displayClientMessage(Component.literal("Seconds until growth " + mound.getAgeCounter() + "/" + SConfig.SERVER.mound_age.get()),false);
                                    player.displayClientMessage(Component.literal("Seconds until puff " + mound.getCounter() + "/" + mound.getMaxCounter()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + mound.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);

                            }else if(entity1 instanceof Proto proto) {
                                    player.displayClientMessage(Component.literal("Entity "+ proto.getEncodeId() + " " + proto.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + proto.getHealth() + "/" + proto.getMaxHealth()),false);
                                    player.displayClientMessage(Component.literal("Current Target " + proto.getTarget()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + proto.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Mobs under control " + proto.getHosts()),false);
                                    player.displayClientMessage(Component.literal("Targeted individuals " + proto.readTargets()),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }
                            else if(entity1 instanceof BiomassReformator reformator) {
                                    player.displayClientMessage(Component.literal("Entity "+ reformator.getEncodeId() + " " + reformator.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + reformator.getHealth()),false);
                                    player.displayClientMessage(Component.literal("Stored Location " + reformator.getLocation()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + reformator.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Biomass " + reformator.getBiomass()),false);
                                    player.displayClientMessage(Component.literal("State " + reformator.getState()),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }else if(entity1 instanceof Vigil vigil) {
                                    player.displayClientMessage(Component.literal("Entity "+ vigil.getEncodeId() + " " + vigil.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + vigil.getHealth()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + vigil.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("State " + vigil.getTrigger()),false);
                                    player.displayClientMessage(Component.literal("Horde size " + vigil.getWaveSize()),false);
                                    player.displayClientMessage(Component.literal("Time until it leaves " + vigil.getTimer()+"/6000"),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);

                            }else if(entity1 instanceof Umarmer umarmer) {
                                    player.displayClientMessage(Component.literal("Entity "+ umarmer.getEncodeId() + " " + umarmer.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + umarmer.getHealth()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + umarmer.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Shielded? " + umarmer.isShielding()),false);
                                    player.displayClientMessage(Component.literal("Pins? " + umarmer.isPinned()),false);
                                    player.displayClientMessage(Component.literal("Time until it leaves " + umarmer.getTimer()+"/2400"),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }else if(entity1 instanceof Brauerei brauerei) {
                                    player.displayClientMessage(Component.literal("Entity "+ brauerei.getEncodeId() + " " + brauerei.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + brauerei.getHealth()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + brauerei.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Time until it leaves " + brauerei.getTimer()+"/300"),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }
                            else if(entity1 instanceof Delusionare delusionare) {
                                    player.displayClientMessage(Component.literal("Entity "+ delusionare.getEncodeId() + " " + delusionare.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + delusionare.getHealth()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + delusionare.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Target ? " + delusionare.getTarget()),false);
                                    player.displayClientMessage(Component.literal("Magic state " + delusionare.getSpellById() + " casting "+delusionare.isCasting()),false);
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }
                        }
                    }
                    return 1;
                }).requires(s -> s.hasPermission(1)));

        event.getDispatcher().register(Commands.literal(Spore.MODID+":check_block_entity")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    Entity entity = arguments.getSource().getEntity();
                    if (entity == null)
                        entity = FakePlayerFactory.getMinecraft(world);
                    if (entity != null) {
                        AABB aabb = entity.getBoundingBox().inflate(5);
                        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                            BlockEntity blockEntity = entity.level().getBlockEntity(blockpos);
                            if (entity instanceof Player player && !player.level().isClientSide) {
                                if (blockEntity instanceof LivingStructureBlocks structureBlocks){
                                    player.displayClientMessage(Component.literal("Structure block with " + structureBlocks.getKills() + " kills"), false);
                                }else if (blockEntity instanceof BrainRemnantBlockEntity block){
                                    player.displayClientMessage(Component.literal("Brain with source " + block.getSource() +", time"+ block.getTime()+ " and UUID "+block.getUUID()), false);
                                }else if (blockEntity instanceof CDUBlockEntity block){
                                    player.displayClientMessage(Component.literal("Fuel " + block.fuel), false);
                                }
                            }

                        }
                        }
                    return 1;
                }).requires(s -> s.hasPermission(1)));

    }

    @SubscribeEvent
    public static void ServerCount(TickEvent.ServerTickEvent event){
        if (SConfig.SERVER.spawn.get()){
            ServerLevel level  = event.getServer().overworld();
            SporeSavedData data = SporeSavedData.getDataLocation(level);
            if (level.getDayTime() % 20 == 0 && data != null  && data.getMinutesBeforeSpawning()<(1200 * SConfig.SERVER.days.get())){
                SporeSavedData.addTime(level);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null && event.getEntity().level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
            RandomSource random = RandomSource.create();
            List<? extends String> lootList;
            if (event.getEntity() instanceof Infected infected){
                lootList = infected.getDropList();
            }else if (event.getEntity() instanceof UtilityEntity entity){
                lootList = entity.getDropList();
            }
            else{
                lootList = null;
            }
            if (lootList != null){
                for (String str : lootList){
                    String[] string = str.split("\\|" );
                    ItemStack itemStack = new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(string[0]))));
                    int m = 1;
                    if (Integer.parseUnsignedInt(string[2]) == Integer.parseUnsignedInt(string[3])){
                        m = Integer.parseUnsignedInt(string[3]);

                    } else {if (Integer.parseUnsignedInt(string[2]) >= 1 && Integer.parseUnsignedInt(string[2]) >= 1){
                        m = random.nextInt(Integer.parseUnsignedInt(string[2]), Integer.parseUnsignedInt(string[3]));}}

                    if (Math.random() < (Integer.parseUnsignedInt(string[1]) / 100F)) {
                        itemStack.setCount(m);
                        ItemEntity item = new ItemEntity(event.getEntity().level(), event.getEntity().getX() , event.getEntity().getY(),event.getEntity().getZ(),itemStack);
                        item.setPickUpDelay(10);
                        event.getEntity().level().addFreshEntity(item);}}
            }
        }
    }
    @SubscribeEvent
    public static void Start(ServerStartedEvent event){
        SporeSavedData.StartupData(event.getServer().overworld());
    }

    @SubscribeEvent
    public static void SpawnPlacement(SpawnPlacementRegisterEvent event){
        event.register(Sentities.INF_VINDICATOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_EVOKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_PILLAGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_HUMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_VILLAGER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_WANDERER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_WITCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_PLAYER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_DROWNED.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.KNIGHT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.GRIEFER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.BRAIOMIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.BUSSER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.SCAMPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.SPITTER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.LEAPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.SLASHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.HOWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.BRUTE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.STALKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.VOLATILE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.INF_HAZMAT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.WENDIGO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(Sentities.PLAGUED.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
    }


    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    @SubscribeEvent
    public static void onExtendedToolUsage(BlockEvent.BreakEvent event)
    {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof InfectedMaul hammer && player instanceof ServerPlayer serverPlayer && !serverPlayer.isCrouching())
        {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos))
            {
                return;
            }

            for (BlockPos pos : InfectedMaul.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer))
            {
                if(pos == initalBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos)))
                {
                    continue;
                }
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
        if(mainHandItem.getItem() instanceof InfectedCombatShovel shovel && player instanceof ServerPlayer serverPlayer && !serverPlayer.isCrouching())
        {
            BlockPos initalBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initalBlockPos))
            {
                return;
            }

            for (BlockPos pos : InfectedCombatShovel.getBlocksToBeDestroyed(1, initalBlockPos, serverPlayer))
            {
                if(pos == initalBlockPos || !shovel.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos)))
                {
                    continue;
                }
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }


    @SubscribeEvent
    public static void Effects(TickEvent.PlayerTickEvent event){
        if (event.player instanceof ServerPlayer player){
            if (player.hasEffect(Seffects.CORROSION.get())){
                if (player.tickCount % 60 == 0){
                    player.getInventory().hurtArmor(SdamageTypes.acid(player),0.5f, Inventory.ALL_ARMOR_SLOTS);
                }
            }
            if (player.hasEffect(Seffects.SYMBIOSIS.get())){
                if (player.tickCount % 400 == 0){
                    int size = player.getInventory().getContainerSize();
                    for (int i = 0;i <= size;i++){
                        ItemStack itemStack = player.getInventory().getItem(i);
                        if (EnchantmentHelper.getTagEnchantmentLevel(Senchantments.SYMBIOTIC_RECONSTITUTION.get(),itemStack) != 0 && itemStack.isDamaged()){
                            int l = itemStack.getDamageValue()-1;
                            itemStack.setDamageValue(l);
                        }
                    }
                }
            }
        }

    }

    @SubscribeEvent
    public static void FishingAnInfectedDrowned(ItemFishedEvent event){
        if (event != null){
            if (Math.random() < 0.05 && event.getHookEntity().isOpenWaterFishing()){
                InfectedDrowned infectedDrowned = new InfectedDrowned(Sentities.INF_DROWNED.get(),event.getEntity().level());
                infectedDrowned.moveTo(event.getHookEntity().getX(),event.getHookEntity().getY(),event.getHookEntity().getZ());
                infectedDrowned.setKills(1);
                infectedDrowned.setTarget(event.getEntity());
                event.getEntity().level().addFreshEntity(infectedDrowned);
            }
        }
    }

    @SubscribeEvent
    public static void ExplosiveBite(LivingEntityUseItemEvent.Finish event){
        if (event != null && !event.getEntity().level().isClientSide){
            Item item = event.getItem().getItem();
            if (item == Sitems.ROASTED_TUMOR.get() && Math.random() < 0.2){
                LivingEntity entity = event.getEntity();
                entity.level().explode(null,entity.getX(),entity.getY(),entity.getZ(),0.5f, Level.ExplosionInteraction.NONE);
            }
            if (item == Sitems.MILKY_SACK.get()){
                LivingEntity entity = event.getEntity();
                List<MobEffectInstance> effectsToRemove = new ArrayList<>();
                entity.getActiveEffects().forEach(mobEffectInstance -> {
                    if (!mobEffectInstance.getEffect().isBeneficial()) {
                        effectsToRemove.add(mobEffectInstance);
                    }
                });
                effectsToRemove.forEach(mobEffectInstance -> entity.removeEffect(mobEffectInstance.getEffect()));
            }
        }
    }

    @SubscribeEvent
    public static void LoadCalamity(EntityEvent.EnteringSection event){
        if (event.getEntity() instanceof Calamity calamity && calamity.level() instanceof ServerLevel level && calamity.getSearchArea() != BlockPos.ZERO){
            SectionPos OldChunk = event.getOldPos();
            SectionPos NewChunk = event.getNewPos();
            if (event.didChunkChange() && OldChunk != NewChunk){
                BlockPos position = new BlockPos((int)calamity.getX(),(int)calamity.getY(),(int)calamity.getZ());
                if (NewChunk != null){
                    ChunkLoaderHelper.forceLoadChunk(level,position, NewChunk.x(), NewChunk.z(), true);
                }
                if (OldChunk != null){
                    ChunkLoaderHelper.unloadChunk(level,position,OldChunk.x(), OldChunk.z(), true);
                }
            }
        }
        if (event.getEntity() instanceof Proto proto && proto.level() instanceof ServerLevel level && SConfig.SERVER.proto_chunk.get()){
            SectionPos OldChunk = event.getOldPos();
            SectionPos NewChunk = event.getNewPos();
            if (event.didChunkChange() && OldChunk != NewChunk){
                BlockPos position = new BlockPos((int)proto.getX(),(int)proto.getY(),(int)proto.getZ());
                if (NewChunk != null){
                    ChunkLoaderHelper.forceLoadChunk(level,position, NewChunk.x(), NewChunk.z(), true);
                }
                if (OldChunk != null){
                    ChunkLoaderHelper.unloadChunk(level,position,OldChunk.x(), OldChunk.z(), true);
                }
            }
        }
    }
    @SubscribeEvent
    public static void UnloadAround(EntityLeaveLevelEvent event){
        if (event.getEntity() instanceof Calamity calamity && calamity.level() instanceof ServerLevel level){
            BlockPos position = new BlockPos((int)calamity.getX(),(int)calamity.getY(),(int)calamity.getZ());
            SectionPos chunk = SectionPos.of(position);
            ChunkLoaderHelper.unloadChunk(level,position, chunk.x(), chunk.z(), true);
        }
    }
    @SubscribeEvent
    public static void ProtectFromEffect(MobEffectEvent.Applicable event)
    {
        if (event.getEntity() != null){
            List<Item> masks =  new ArrayList<>();
            for (String string : SConfig.SERVER.gas_masks.get()){
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(string));
                if (item != null){
                 masks.add(item);
                }
            }
            event.getEffectInstance();
            if (event.getEffectInstance().getEffect() == Seffects.MYCELIUM.get() && masks.contains(event.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem())){
                event.setResult(Event.Result.DENY);
            }
            if (SConfig.SERVER.blacklist.get().contains(event.getEntity().getEncodeId())){
                event.setResult(Event.Result.DENY);
            }
            if (SConfig.SERVER.faw_target.get() && event.getEntity().getType().is(TagKey.create(Registries.ENTITY_TYPE,
                    new ResourceLocation("fromanotherworld:things")))){
                if (event.getEffectInstance().getEffect() == Seffects.MARKER.get()){
                    event.setResult(Event.Result.DENY);
                }
            }else if (SConfig.SERVER.skulk_target.get() && event.getEntity().getType().is(TagKey.create(Registries.ENTITY_TYPE,
                    new ResourceLocation("sculkhorde:sculk_entity")))){
                if (event.getEffectInstance().getEffect() == Seffects.MARKER.get()){
                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }

    @SubscribeEvent
    public static void DiscardProto(EntityLeaveLevelEvent event){
        if (event.getEntity() instanceof Proto && event.getLevel() instanceof ServerLevel level){
            SporeSavedData.removeHivemind(level);
        }
    }

    @SubscribeEvent
    public static void onProjectileImpact(ProjectileImpactEvent event) {
        if (event.getProjectile() instanceof Snowball) {
            if (event.getRayTraceResult().getType() == HitResult.Type.ENTITY) {
                Entity entity = ((EntityHitResult) event.getRayTraceResult()).getEntity();
                if (entity instanceof LivingEntity living) {
                    if (living.canFreeze()) living.setTicksFrozen(living.getTicksFrozen() + 100);
                }
            }
        }
    }

    @SubscribeEvent
    public static void NoSleep(PlayerSleepInBedEvent event){
        if(event.getEntity() instanceof ServerPlayer player && player.hasEffect(Seffects.UNEASY.get())){
            player.displayClientMessage(Component.translatable("uneasy.message"),true);
            event.setResult(Player.BedSleepingProblem.OTHER_PROBLEM);
        }
    }

    @SubscribeEvent
    public static void DefenseBypass(LivingDamageEvent event) {
        Entity living = event.getSource().getEntity();
        if (living instanceof Calamity calamity) {
            float original_damage = event.getAmount();
            AttributeInstance attack = calamity.getAttribute(Attributes.ATTACK_DAMAGE);
            double recalculated_damage = attack != null ? (attack.getValue()/10)*2 : original_damage;
            if (original_damage < recalculated_damage){
                event.setAmount((float) recalculated_damage);
            }
        }
        if (living instanceof Slasher slasher && slasher.getVariant() == SlasherVariants.PIERCER) {
            float original_damage = event.getAmount();
            AttributeInstance attack = slasher.getAttribute(Attributes.ATTACK_DAMAGE);
            double recalculated_damage = attack != null ? attack.getValue()/2 : original_damage;
            if (original_damage < recalculated_damage){
                event.setAmount((float) recalculated_damage);
            }
        }
        if (living instanceof Illusion illusion && !illusion.getSeeAble()){
            event.setAmount((float) (SConfig.SERVER.halucinations_damage.get()*1f));
        }
        if (living instanceof Infected || living instanceof UtilityEntity && !(living instanceof Illusion)){
            LivingEntity livingEntity = event.getEntity();
            MobEffectInstance mobEffectInstance = livingEntity.getEffect(Seffects.MADNESS.get());
            if (mobEffectInstance != null){
                int level = mobEffectInstance.getAmplifier();
                int duration = mobEffectInstance.getDuration() +1200;
                boolean jumpLevel = duration < 12000;
                livingEntity.addEffect(new MobEffectInstance(Seffects.MADNESS.get(),jumpLevel ? duration: duration-12000,jumpLevel ? level : level+1));
            }
        }
    }

    @SubscribeEvent
    public static void TickEvents(LivingEvent.LivingTickEvent event){
        if (event.getEntity() instanceof Player player){
            MobEffectInstance effectInstance = player.getEffect(Seffects.MADNESS.get());
            if (effectInstance != null && effectInstance.getDuration() == 1){
                int level = effectInstance.getAmplifier();
                if (level > 0){
                    effectInstance.update(new MobEffectInstance(Seffects.MADNESS.get(),12000,level-1));
                }
            }
            if (player.tickCount % 400 == 0 && player.level().isClientSide){
                AABB aabb = player.getBoundingBox().inflate(5);
                List<BlockPos> list = new ArrayList<>();
                for (BlockPos blockPos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))){
                    if (player.level().getBlockState(blockPos).is(BlockTags.create(new ResourceLocation("spore:fungal_blocks")))){
                        list.add(blockPos);
                    }
                }
                if (list.size() > 4){
                    player.playSound(Ssounds.AREA_AMBIENT.get());
                }
            }
        }
    }

}
