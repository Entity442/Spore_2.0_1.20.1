package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber
public class Infection {
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

        if (entity instanceof EvolvedInfected evolvedInfected && event.getSource().getEntity() != null && evolvedInfected.getLinked() && Math.random() < (SConfig.SERVER.proto_calamity.get()/100)){
            AABB searchbox = evolvedInfected.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
            List<Entity> entities = entity.level().getEntities(entity, searchbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Proto proto){
                    proto.setSignal(true);
                    proto.setPlace(new BlockPos((int)entity.getX(),(int)entity.getY(),(int)entity.getZ()));
                    break;
                }}
        }

        if (entity instanceof Player player && player.hasEffect(Seffects.MYCELIUM.get()) && !world.isClientSide && SConfig.SERVER.inf_player.get()){
             Component name = player.getName();
            InfectedPlayer infectedHuman = Sentities.INF_PLAYER.get().create(world);
            ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
            ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);
            ItemStack hand = player.getItemBySlot(EquipmentSlot.MAINHAND);
            ItemStack offhand = player.getItemBySlot(EquipmentSlot.OFFHAND);
            assert infectedHuman != null;
            infectedHuman.setItemSlot(EquipmentSlot.HEAD , head);
            infectedHuman.setItemSlot(EquipmentSlot.CHEST , chest);
            infectedHuman.setItemSlot(EquipmentSlot.LEGS , legs);
            infectedHuman.setItemSlot(EquipmentSlot.FEET , feet);
            infectedHuman.setItemSlot(EquipmentSlot.MAINHAND , hand);
            infectedHuman.setItemSlot(EquipmentSlot.OFFHAND , offhand);
            infectedHuman.moveTo(event.getEntity().getX(),event.getEntity().getY(),event.getEntity().getZ());
            infectedHuman.setCustomName(name);
            infectedHuman.setDropChance(EquipmentSlot.HEAD , 0);
            infectedHuman.setDropChance(EquipmentSlot.CHEST , 0);
            infectedHuman.setDropChance(EquipmentSlot.LEGS , 0);
            infectedHuman.setDropChance(EquipmentSlot.FEET , 0);
            infectedHuman.setDropChance(EquipmentSlot.OFFHAND , 0);
            infectedHuman.setDropChance(EquipmentSlot.MAINHAND , 0);
            world.addFreshEntity(infectedHuman);
        }


        if (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Seffects.MYCELIUM.get()) && !world.isClientSide && !(entity instanceof Player)) {

            ServerLevelAccessor worlder = (ServerLevelAccessor) entity.level();
            for (String str : SConfig.SERVER.inf_human_conv.get()) {
                String[] string = str.split("\\|");
                EntityType<?> value2 =  ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(string[1]));
                assert value2 != null;
                Mob mobT = (Mob) value2.create(event.getEntity().level());
                if (string[0].contains(Objects.requireNonNull(entity.getEncodeId()))) {
                    assert mobT != null;
                    mobT.setCustomName(entity.getCustomName());
                    mobT.setPos(entity.getX(), entity.getY(), entity.getZ());
                    mobT.finalizeSpawn(worlder, world.getCurrentDifficultyAt(new BlockPos((int)entity.getX(), (int)entity.getY(), (int)entity.getZ())), MobSpawnType.NATURAL, null, null);
                    if (mobT instanceof Infected infected && SConfig.SERVER.undespawn.get().contains(entity.getEncodeId())){
                        infected.setPersistent(true);
                    }
                    world.addFreshEntity(mobT);
                    entity.discard();
                }
            }}
        }
    }
}
