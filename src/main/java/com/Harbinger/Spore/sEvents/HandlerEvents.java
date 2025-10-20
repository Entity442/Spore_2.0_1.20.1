package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoadRequest;
import com.Harbinger.Spore.ExtremelySusThings.ChunkLoaderHelper;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.SBlockEntities.CDUBlockEntity;
import com.Harbinger.Spore.SBlockEntities.LivingStructureBlocks;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.*;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedDrowned;
import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Protector;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.HitboxesForParts;
import com.Harbinger.Spore.Sentities.Organoids.*;
import com.Harbinger.Spore.Sentities.Utility.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.*;
import com.Harbinger.Spore.Sitems.PCI;
import com.Harbinger.Spore.Spore;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

@Mod.EventBusSubscriber(modid = Spore.MODID)
public class HandlerEvents {
    private static int tickCounter = 0;
    private static final int CHECK_INTERVAL = 1200; // 60 seconds

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ChunkLoaderHelper.tick();
        }
        if (event.phase != TickEvent.Phase.END) return;
        tickCounter++;
        if (tickCounter >= CHECK_INTERVAL) {
            MinecraftServer server = event.getServer();
            if (server != null) {
                for (ServerLevel level : server.getAllLevels()) {
                    cleanUpMobs(level);
                }
            }
            tickCounter = 0;
        }
    }

    private static void cleanUpMobs(ServerLevel level) {
        List<Infected> infected = new ArrayList<>();
        List<EvolvedInfected> evolved = new ArrayList<>();
        List<Hyper> hyper = new ArrayList<>();
        List<Organoid> organoid = new ArrayList<>();
        List<ScentEntity> scent = new ArrayList<>();

        for (Entity entity : level.getAllEntities()) {
            if (entity instanceof LivingEntity living &&
                    !SConfig.SERVER.despawn_blacklist.get().contains(living.getEncodeId()) &&
                    !living.hasCustomName()) {

                if (living instanceof Organoid o) organoid.add(o);
                else if (living instanceof EvolvedInfected e) evolved.add(e);
                else if (living instanceof Hyper h) hyper.add(h);
                else if (living instanceof ScentEntity s) scent.add(s);
                else if (living instanceof Infected i) infected.add(i);
            }
        }

        despawnExcess(level, infected, SConfig.SERVER.max_infected_cap.get());
        despawnExcess(level, evolved, SConfig.SERVER.max_evolved_cap.get());
        despawnExcess(level, hyper, SConfig.SERVER.max_hyper_cap.get());
        despawnExcess(level, organoid, SConfig.SERVER.max_organoid_cap.get());
        despawnExcess(level, scent, SConfig.SERVER.max_scent_cap.get());
    }

    private static <T extends LivingEntity> void despawnExcess(ServerLevel level, List<T> entities, int cap) {
        if (entities.size() <= cap) return;
        int toRemove = entities.size() - cap;
        int despawns = 0;
        List<ServerPlayer> players = level.getPlayers(p -> true);

        if (players.isEmpty()) {
            for (int i = 0; i < toRemove; i++) {
                T entity = entities.get(i);
                entity.discard();
                despawns++;
            }
        } else {
            entities.sort(Comparator.comparingDouble((LivingEntity e) ->
                    level.getNearestPlayer(e, -1) != null ? e.distanceToSqr(Objects.requireNonNull(level.getNearestPlayer(e, -1))) : Double.MAX_VALUE).reversed());
            for (int i = 0; i < toRemove; i++) {
                T entity = entities.get(i);
                entity.discard();
                despawns++;
            }
        }
        System.out.println("Despawned " + despawns + " mobs in level: " + level.dimension().location());
    }
    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (event.getLevel() instanceof ServerLevel level) {
            SporeSavedData data = SporeSavedData.get(level);
            for (ChunkLoadRequest request : data.getRequests()) {
                ChunkLoaderHelper.ACTIVE_REQUESTS.put(request.getRequestID(), request);
                for (ChunkPos pos : request.getChunkPositionsToLoad()) {
                    ChunkLoaderHelper.forceChunk(level, pos);
                }
            }
        }
    }
    @SubscribeEvent
    public static void onLivingSpawned(EntityJoinLevelEvent event) {
        if (event != null && event.getEntity() != null) {
            if (event.getEntity() instanceof Protector protector){
                SporeSavedData.addProtector(protector);
            }
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
        event.getDispatcher().register(Commands.literal(Spore.MODID+":nuke_the_land")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    int x = (int) arguments.getSource().getPosition().x();
                    int y = (int) arguments.getSource().getPosition().y();
                    int z = (int) arguments.getSource().getPosition().z();
                    NukeEntity nukeEntity = new NukeEntity(Sentities.NUKE.get(), world);
                    nukeEntity.setInitRange(1f);
                    nukeEntity.setRange((float) (SConfig.SERVER.nuke_range.get()*1f));
                    nukeEntity.setInitDuration(0);
                    nukeEntity.setDuration(SConfig.SERVER.nuke_time.get());
                    nukeEntity.setDamage((float) (SConfig.SERVER.nuke_damage.get()*1f));
                    nukeEntity.setPos(x,y,z);
                    world.addFreshEntity(nukeEntity);
                    return 1;
                }).requires(s -> s.hasPermission(1)));
        event.getDispatcher().register(Commands.literal(Spore.MODID+":corpse")
                .executes(arguments -> {
                    ServerLevel world = arguments.getSource().getLevel();
                    RandomSource randomSource = RandomSource.create();
                    int x = (int) arguments.getSource().getPosition().x();
                    int y = (int) arguments.getSource().getPosition().y();
                    int z = (int) arguments.getSource().getPosition().z();
                    CorpseEntity corpseEntity = new CorpseEntity(Sentities.CORPSE_PIECE.get(), world);
                    corpseEntity.setCorpseType(randomSource.nextInt(HitboxesForParts.values().length));
                    corpseEntity.setOwnerAda(true);
                    corpseEntity.setPos(x,y,z);
                    world.addFreshEntity(corpseEntity);
                    return 1;
                }).requires(s -> s.hasPermission(1)));
        event.getDispatcher().register(Commands.literal(Spore.MODID+":erase_the_fungus")
                .executes(arguments -> {
                    ServerLevel serverLevel = arguments.getSource().getLevel();
                    for (Entity entity : serverLevel.getAllEntities()){
                        if (entity instanceof LivingEntity living){
                            if (living instanceof Infected || living instanceof UtilityEntity){
                                living.discard();
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
                        int numberofprotos = data.getAmountOfHiveminds();
                        player.displayClientMessage(Component.literal("There are "+numberofprotos + " proto hiveminds in this dimension"),false);
                        for (ChunkLoadRequest request : data.getRequests()){
                            String id = request.getRequestID();
                            long getDefaultTicks = request.getTickAmount();
                            long ticks = request.getTicksUntilExpiration();
                            player.displayClientMessage(Component.literal("Loaded chunk "+id + " "+ticks +"/"+getDefaultTicks),false);
                        }
                    }
                    return 1;
                }).requires(s -> s.hasPermission(1)));
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
                            if (entity1 instanceof CorpseEntity corpseEntity){
                                player.displayClientMessage(Component.literal("isAdapted ? " + corpseEntity.getOwnerAda()),false);
                                player.displayClientMessage(Component.literal("ID ? " + corpseEntity.getCorpseType()),false);
                                player.displayClientMessage(Component.literal("Timer ? " + corpseEntity.getTimer()),false);
                                for (int i=0;i<corpseEntity.getInventory().getContainerSize();i++){
                                    ItemStack stack = corpseEntity.getInventory().getItem(i);
                                    if (stack != ItemStack.EMPTY){
                                        player.displayClientMessage(Component.literal("ID ? " + stack.getItem().asItem().getDescription()),false);
                                    }
                                }
                            }
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
                                    player.displayClientMessage(Component.literal("Mutation Color ? " + calamity.getMutationColor()),false);
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
                                if (calamity instanceof Hohlfresser sieger){
                                    player.displayClientMessage(Component.literal("Underground "+ sieger.isUnderground()),false);
                                    player.displayClientMessage(Component.literal("Ores ? "+ sieger.getOres()),false);
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
                                    player.displayClientMessage(Component.literal("Biomass " + proto.getBiomass()),false);
                                    for (int i = 0;i<proto.getWeights().length;i++){
                                        player.displayClientMessage(Component.literal("Neuron_"+i+" " + proto.getWeightsValue(i)),false);
                                    }
                                    for (String s : proto.team_1){
                                    player.displayClientMessage(Component.literal("TEAM_1 "+ s),false);
                                    }
                                    for (String s : proto.team_2){
                                    player.displayClientMessage(Component.literal("TEAM_2 "+ s),false);
                                    }
                                    for (String s : proto.team_3){
                                    player.displayClientMessage(Component.literal("TEAM_3 "+ s),false);
                                    }
                                    for (String s : proto.team_4){
                                    player.displayClientMessage(Component.literal("TEAM_4 "+ s),false);
                                    }
                                    for (String s : proto.team_5){
                                    player.displayClientMessage(Component.literal("Beloved mobs "+ s),false);
                                    }
                                    player.displayClientMessage(Component.literal("-------------------------"),false);
                            }
                            else if(entity1 instanceof Womb reformator) {
                                    player.displayClientMessage(Component.literal("Entity "+ reformator.getEncodeId() + " " + reformator.getCustomName()),false);
                                    player.displayClientMessage(Component.literal("Current Health " + reformator.getHealth()),false);
                                    player.displayClientMessage(Component.literal("Stored Location " + reformator.getLocation()),false);
                                    player.displayClientMessage(Component.literal("Buffs " + reformator.getActiveEffects()),false);
                                    player.displayClientMessage(Component.literal("Biomass " + reformator.getBiomass()),false);
                                    player.displayClientMessage(Component.literal("State " + reformator.getVariant().getValue()),false);
                                    for (String s : reformator.getAttributeIDs()){
                                        player.displayClientMessage(Component.translatable(s),false);
                                    }
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
                            }else if(entity1 instanceof Specter specter) {
                                player.displayClientMessage(Component.literal("Entity "+ specter.getEncodeId() + " " + specter.getCustomName()),false);
                                player.displayClientMessage(Component.literal("Current Health " + specter.getHealth()),false);
                                player.displayClientMessage(Component.literal("Buffs " + specter.getActiveEffects()),false);
                                player.displayClientMessage(Component.literal("Target ? " + specter.getTarget()),false);
                                player.displayClientMessage(Component.literal("Target Pos " + specter.getTargetPos()),false);
                                player.displayClientMessage(Component.literal("Stomach " + specter.getStomach()),false);
                                player.displayClientMessage(Component.literal("Biomass " + specter.getBiomass()),false);
                                player.displayClientMessage(Component.literal("-------------------------"),false);
                            }else if(entity1 instanceof InfestedConstruct construct) {
                                player.displayClientMessage(Component.literal("Entity "+ construct.getEncodeId() + " " + construct.getCustomName()),false);
                                player.displayClientMessage(Component.literal("Current Health " + construct.getHealth()),false);
                                player.displayClientMessage(Component.literal("Buffs " + construct.getActiveEffects()),false);
                                player.displayClientMessage(Component.literal("Target ? " + construct.getTarget()),false);
                                player.displayClientMessage(Component.literal("Machine hp " + construct.getMachineHealth()),false);
                                player.displayClientMessage(Component.literal("Metal " + construct.getMetalReserve()),false);
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
    public static void onServerStart(ServerStartedEvent event){
        ServerLevel level  = event.getServer().overworld();
        SporeSavedData data = SporeSavedData.getDataLocation(level);
        if (data != null){
            SporeSavedData.StartupData(level);
            SporeSavedData.resetHive(level);
        }
    }

    @SubscribeEvent
    public static void SpawnPlacement(SpawnPlacementRegisterEvent event){
        for (RegistryObject<EntityType<?>> type : Sentities.SPORE_ENTITIES.getEntries()){
            EntityType<?> entityType = type.get();
            if (blacklist().contains(entityType)){continue;}
            try {
                event.register((EntityType<Infected>) entityType, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,Infected::checkMonsterInfectedRules, SpawnPlacementRegisterEvent.Operation.AND);
            } catch (Exception e) {
                ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(entityType);
                Spore.LOGGER.warn("Could not apply custom placement {}: {}", id, e.getMessage());
            }
        }
    }

    private static List<EntityType<?>> blacklist(){
        List<EntityType<?>> values = new ArrayList<>();
        values.add(Sentities.PLAGUED.get());
        values.add(Sentities.LACERATOR.get());
        values.add(Sentities.BIOBLOOB.get());
        values.add(Sentities.SAUGLING.get());
        return values;
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
                if (player.tickCount % 200 == 0){
                    int size = player.getInventory().getContainerSize();
                    for (int i = 0;i <= size;i++){
                        ItemStack itemStack = player.getInventory().getItem(i);
                        if (EnchantmentHelper.getTagEnchantmentLevel(Senchantments.SYMBIOTIC_RECONSTITUTION.get(),itemStack) != 0 && itemStack.isDamaged()){
                            if (itemStack.getItem() instanceof SporeToolsBaseItem base){
                                base.healTool(itemStack,2);
                            }else if (itemStack.getItem() instanceof SporeArmorData base){
                                base.healTool(itemStack,2);
                            }else{
                                int l = itemStack.getDamageValue()-2;
                                itemStack.setDamageValue(l);
                            }
                        }
                    }
                }
            }
        }

    }
    @SubscribeEvent
    public static void drops(LootingLevelEvent event){
        if (event.getDamageSource() == null){
            return;
        }
        Entity entity = event.getDamageSource().getDirectEntity();
        if (entity instanceof LivingEntity living){
            if (living.getMainHandItem().getItem() instanceof LootModifierWeapon lootModifierWeapon){
                event.setLootingLevel(lootModifierWeapon.getLootingLevel());
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
            if (SConfig.SERVER.calamity_chunk.get() && event.didChunkChange() && OldChunk != NewChunk){
                BlockPos position = new BlockPos((int)calamity.getX(),(int)calamity.getY(),(int)calamity.getZ());
                if (NewChunk != null){
                    ChunkPos chunk = new ChunkPos(position.getX(), position.getY());
                    UUID ownerId = calamity.getUUID();
                    String id = "calamity_" + ownerId + "_" + chunk.toString();
                    ChunkLoadRequest request = new ChunkLoadRequest(
                            level.dimension(),
                            new ChunkPos[]{chunk},
                            0,
                            id,
                            20 * 60,
                            ownerId
                    );
                    ChunkLoaderHelper.addRequest(request);
                }
            }
        }
        if (event.getEntity() instanceof Proto proto && proto.level() instanceof ServerLevel level && SConfig.SERVER.proto_chunk.get()){
            SectionPos OldChunk = event.getOldPos();
            SectionPos NewChunk = event.getNewPos();
            if (event.didChunkChange() && OldChunk != NewChunk){
                BlockPos position = new BlockPos((int)proto.getX(),(int)proto.getY(),(int)proto.getZ());
                if (NewChunk != null){
                    ChunkPos chunk = new ChunkPos(position.getX(), position.getY());
                    UUID ownerId = proto.getUUID();
                    String id = "hivemind_" + ownerId + "_" + chunk.toString();
                    ChunkLoadRequest request = new ChunkLoadRequest(
                            level.dimension(),
                            new ChunkPos[]{chunk},
                            0,
                            id,
                            20 * 60 * 10,
                            ownerId
                    );
                    ChunkLoaderHelper.addRequest(request);
                }
            }
        }
    }
    @SubscribeEvent
    public static void FallProt(LivingFallEvent event){
        if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == Sitems.INF_UP_BOOTS.get()){
            event.setDistance(event.getDistance()-25);
        }
    }
    @SubscribeEvent
    public static void ProtectFromEffect(MobEffectEvent.Applicable event)
    {
        LivingEntity living = event.getEntity();
        MobEffectInstance instance = event.getEffectInstance();
        MobEffect mobEffect = event.getEffectInstance().getEffect();
        if (living != null){
            if (mobEffect == Seffects.MYCELIUM.get() && Utilities.helmetList().contains(living.getItemBySlot(EquipmentSlot.HEAD).getItem())){
                event.setResult(Event.Result.DENY);
            }
            if (SConfig.SERVER.faw_target.get() && event.getEntity().getType().is(TagKey.create(Registries.ENTITY_TYPE,
                    new ResourceLocation("fromanotherworld:things")))){
                if (mobEffect == Seffects.MARKER.get()){
                    event.setResult(Event.Result.DENY);
                }
            }else if (SConfig.SERVER.skulk_target.get() && event.getEntity().getType().is(TagKey.create(Registries.ENTITY_TYPE,
                    new ResourceLocation("sculkhorde:sculk_entity")))){
                if (mobEffect == Seffects.MARKER.get()){
                    event.setResult(Event.Result.DENY);
                }
            }
            if (living.getItemBySlot(EquipmentSlot.HEAD).getItem() == Sitems.INF_UP_HELMET.get() && mobEffect == Seffects.MADNESS.get() && instance.getAmplifier() < 1){
                event.setResult(Event.Result.DENY);
            }
        }
    }

    @SubscribeEvent
    public static void DiscardProto(EntityLeaveLevelEvent event){
        if (event.getEntity() instanceof Protector protector){
            SporeSavedData.removeProtector(protector);
        }
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
        if (living instanceof Player player && event.getEntity().getItemBySlot(EquipmentSlot.CHEST).equals(ItemStack.EMPTY)){
            ItemStack weapon = player.getMainHandItem();
            if (weapon.getItem() instanceof PCI pci && pci.getCharge(weapon)>0 && !player.getCooldowns().isOnCooldown(pci)){
                int damageMod = SConfig.SERVER.pci_damage_multiplier.get();
                int charge = pci.getCharge(weapon);
                LivingEntity target = event.getEntity();
                boolean freeze = event.getEntity().getType().is(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES);
                float targetHealth = freeze ? target.getHealth()/damageMod : target.getHealth();
                int freezeDamage = charge >= targetHealth ? (int) targetHealth : charge;
                event.setAmount(freeze ?freezeDamage * damageMod : freezeDamage);
                pci.setCharge(weapon, charge - freezeDamage);
                target.setTicksFrozen(600);
                player.getCooldowns().addCooldown(pci, (int) Math.ceil(targetHealth / 5f) * 20);
                pci.playSound(player);
            }
        }
        if(event.getEntity() instanceof Infected victim && !(victim instanceof Protector)) {
                LivingEntity attacker = living instanceof LivingEntity e ? e : null;
                List<Protector> protectorList = SporeSavedData.protectorList();
                if (!protectorList.isEmpty() && attacker != null){
                    for (Protector protector1 : protectorList){
                        double d0 = protector1.distanceTo(attacker);
                        if (protector1.isAlive() && d0 < 64f && !attacker.isSpectator() && Utilities.TARGET_SELECTOR.Test(attacker)){
                            protector1.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100,0));
                            protector1.setTarget(attacker);
                        }
                    }
                }
        }
        if (living instanceof ArmorPersentageBypass bypass){
            float original_damage = event.getAmount();
            float recalculatedDamage = bypass.amountOfDamage(original_damage);
            if (recalculatedDamage >= 0 && original_damage < recalculatedDamage){
                event.setAmount(recalculatedDamage);
            }
        }
        if (living instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().getItem() instanceof DamagePiercingModifier piercingModifier){
            float original_damage = event.getAmount();
            float recalculatedDamage = piercingModifier.getMinimalDamage(original_damage);
            if (recalculatedDamage >= 0 && original_damage < recalculatedDamage){
                event.setAmount(recalculatedDamage);
            }
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
        //////problem
        if (event.getEntity() instanceof Player player) {
            float totalDamageModification = 0.0F;

            for (ItemStack stack : player.getArmorSlots()) {
                if (stack.getItem() instanceof SporeBaseArmor armor) {
                    totalDamageModification += armor.calculateAdditionalDamage(event.getSource(), stack, event.getAmount());
                }
            }
            event.setAmount(event.getAmount() + totalDamageModification);
        }
        if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
            int i = 0;
            for (ItemStack stack : serverPlayer.getInventory().armor){
                if (stack.getItem() instanceof SporeBaseArmor baseArmor && baseArmor.getVariant(stack) == SporeArmorMutations.CHARRED){
                    i=i+2;
                }
            }
            if (i > 0){
                event.getEntity().setSecondsOnFire(i);
            }
        }
        if (event.getSource().getEntity() instanceof Mob attacker){
            CompoundTag data = attacker.getPersistentData();
            if (data.contains("hivemind")) {
                int summonerUUID = data.getInt("hivemind");
                Level level = attacker.level();
                Entity summoner = level.getEntity(summonerUUID);

                if (summoner instanceof Proto smartMob) {
                    int decision = data.getInt("decision");
                    int member = data.getInt("member");
                    smartMob.praisedForDecision(decision,member);
                }
            }
        }
        if (event.getEntity() instanceof Mob creature){
            CompoundTag data = creature.getPersistentData();
            if (data.contains("hivemind")) {
                int summonerUUID = data.getInt("hivemind");
                Level level = creature.level();
                Entity summoner = level.getEntity(summonerUUID);
                if (summoner instanceof Proto smartMob) {
                    int decision = data.getInt("decision");
                    int member = data.getInt("member");
                    smartMob.punishForDecision(decision,member);
                }
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
