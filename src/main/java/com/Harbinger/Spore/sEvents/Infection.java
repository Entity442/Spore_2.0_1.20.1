package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Sentities.Hyper.Hvindicator;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Sentities.Signal;
import com.Harbinger.Spore.Sentities.Utility.GastGeber;
import com.Harbinger.Spore.Sentities.Utility.InfestedConstruct;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber
public class Infection {
    public static final List<? extends String> infectionValues = SConfig.SERVER.inf_human_conv.get();
    public static void setItemBySlot(Player player , EquipmentSlot slot,Mob entity){
        entity.setItemSlot(slot,player.getItemBySlot(slot));
        entity.setDropChance(slot,0);
    }
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null && !event.getEntity().level().isClientSide) {
            Level world = event.getEntity().level();
            double x = event.getEntity().getX();
            double y = event.getEntity().getY();
            double z = event.getEntity().getZ();
            Entity entity = event.getEntity();

        if (entity instanceof Infected infected && SConfig.SERVER.scent_spawn.get()) {
            if (world instanceof ServerLevel _level) {
                if (Math.random() < (SConfig.SERVER.scent_spawn_chance.get() / 100f)) {
                    AABB aabb = infected.getBoundingBox().inflate(16);
                    List<ScentEntity> entities = infected.level().getEntitiesOfClass(ScentEntity.class, aabb);
                    if (entities.size() < SConfig.SERVER.scent_cap.get())
                    {
                        ScentEntity entityToSpawn = new ScentEntity(Sentities.SCENT.get(), _level);
                        entityToSpawn.setOvercharged(infected.getLinked());
                        entityToSpawn.moveTo(x, y + 4, z, world.getRandom().nextFloat() * 360F, 0);
                        world.addFreshEntity(entityToSpawn);
                    }
                }
            }
        }


        if (entity instanceof  EvolvedInfected infected && (Math.random() < 0.2)){
            AreaEffectCloud areaeffectcloud = new AreaEffectCloud(world, x, y, z);
            areaeffectcloud.setRadius(2.5F);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setWaitTime(10);
            areaeffectcloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get() ,40 ,0));
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            world.addFreshEntity(areaeffectcloud);
            AABB hitbox = infected.getBoundingBox().inflate(30);
            List<Entity> entities = entity.level().getEntities(entity, hitbox);
            for (Entity entity1 : entities) {
                if(entity1 instanceof Infected infected1) {
                    BlockPos pos = new BlockPos((int)x ,(int)y,(int)z);
                    infected1.setSearchPos(pos);
                }
            }
        }

        if (entity instanceof Infected infected && event.getSource().getEntity() != null && infected.getLinked()){
            double value = SConfig.SERVER.proto_calamity.get()/100;
            if (infected instanceof EvolvedInfected evolvedInfected && Math.random() < value){
                callProto(evolvedInfected);
            }if (infected instanceof Hyper hyper && Math.random() < value*2){
                callProto(hyper);
            }if (infected instanceof GastGeber geber && Math.random() < value*4){
                callProto(geber);
            }
        }

        if (entity instanceof Player player && player.hasEffect(Seffects.MYCELIUM.get()) && !world.isClientSide && SConfig.SERVER.inf_player.get()){
            Component name = player.getName();
            InfectedPlayer infectedHuman = new InfectedPlayer(Sentities.INF_PLAYER.get(),player.level());
            setItemBySlot(player,EquipmentSlot.HEAD,infectedHuman);
            setItemBySlot(player,EquipmentSlot.CHEST,infectedHuman);
            setItemBySlot(player,EquipmentSlot.LEGS,infectedHuman);
            setItemBySlot(player,EquipmentSlot.FEET,infectedHuman);
            setItemBySlot(player,EquipmentSlot.MAINHAND,infectedHuman);
            setItemBySlot(player,EquipmentSlot.OFFHAND,infectedHuman);
            infectedHuman.moveTo(player.getX(),player.getY(),player.getZ());
            infectedHuman.setCustomName(name);
            world.addFreshEntity(infectedHuman);
        }


        if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(Seffects.MYCELIUM.get()) && !world.isClientSide && !(entity instanceof Player)) {
            if (entity.level() instanceof ServerLevel serverLevel){
                for (String str: infectionValues){
                    String[] string = str.split("\\|");
                    EntityType<?> infected =  ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(string[1]));
                    Entity infected1 = infected.create(serverLevel);
                    if (infected1 != null && string[0].equals(livingEntity.getEncodeId())){
                        infected1.setCustomName(livingEntity.getCustomName());
                        infected1.setPos(livingEntity.position());
                        if (infected1 instanceof Mob mob){mob.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(livingEntity.getOnPos()),MobSpawnType.CONVERSION,null,null);}
                        if (infected1 instanceof Infected assimilated){
                            assimilated.setOrigin(livingEntity.getEncodeId());
                        }
                        serverLevel.addFreshEntity(infected1);
                        livingEntity.discard();
                    }
                }
                if (livingEntity instanceof IronGolem golem && Math.random() < SConfig.SERVER.machine_infestation.get()/100){
                    InfestedConstruct construct = new InfestedConstruct(Sentities.INF_CONSTRUCT.get(),golem.level());
                    construct.setPos(golem.position());
                    construct.setHealth(10);
                    construct.setMachineHealth(0f);
                    construct.setActive(false);
                    construct.setCustomName(golem.getCustomName());
                    serverLevel.addFreshEntity(construct);
                    golem.discard();
                }
            }}
        giveRewards(event.getSource().getEntity(),event.getEntity());
        awardHivemind(event.getSource().getEntity(),event.getEntity());
        }
    }

    public static void callProto(Entity entity){
        AABB searchbox = entity.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
        List<Proto> entities = entity.level().getEntitiesOfClass(Proto.class, searchbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        if (entities.isEmpty()){
            return;
        }
        RandomSource source = RandomSource.create();
        Proto proto = entities.get(source.nextInt(entities.size()));
        proto.setSignal(new Signal(true,new BlockPos((int)entity.getX(),(int)entity.getY(),(int)entity.getZ())));
    }

    public static void giveRewards(Entity entity,LivingEntity victim){
        if (entity == null || victim == null){
            return;
        }
        if (entity instanceof Hvindicator hvindicator){
            hvindicator.awardSkull(victim);
        }
    }
    public static void awardHivemind(Entity entity,LivingEntity victim){
        if (entity == null || victim == null){
            return;
        }
        if (entity instanceof Mob creature){
            CompoundTag data = creature.getPersistentData();
            if (data.contains("hivemind")) {
                int summonerUUID = data.getInt("hivemind");
                Level level = creature.level();
                Entity summoner = level.getEntity(summonerUUID);
                if (summoner instanceof Proto smartMob) {
                    int decision = data.getInt("decision");
                    smartMob.adjustWeightsForDecision(decision,0.1);
                }
            }
        }
    }
}
