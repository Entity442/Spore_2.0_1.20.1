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
import com.Harbinger.Spore.Sitems.BaseWeapons.DeathRewardingWeapon;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber
public class Infection {

    public static void setItemBySlot(Player player, EquipmentSlot slot, Mob entity) {
        entity.setItemSlot(slot, player.getItemBySlot(slot));
        entity.setDropChance(slot, 0);
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity == null || entity.level().isClientSide) return;

        Level level = entity.level();
        double x = entity.getX(), y = entity.getY(), z = entity.getZ();

        if (event.getSource().getEntity() instanceof LivingEntity livingEntity) {
            ItemStack stack = livingEntity.getMainHandItem();
            if (stack.getItem() instanceof DeathRewardingWeapon weapon) {
                weapon.computeAfterEffect(entity, livingEntity, stack);
            }
        }

        if (entity instanceof Infected infected && SConfig.SERVER.scent_spawn.get() && infected.getTicksFrozen() <= 0) {
            if (level instanceof ServerLevel serverLevel && Math.random() < SConfig.SERVER.scent_spawn_chance.get() / 100f) {
                AABB area = infected.getBoundingBox().inflate(16);
                List<ScentEntity> scents = level.getEntitiesOfClass(ScentEntity.class, area);
                if (scents.size() < SConfig.SERVER.scent_cap.get()) {
                    ScentEntity scent = new ScentEntity(Sentities.SCENT.get(), serverLevel);
                    scent.setOvercharged(infected.getLinked());
                    scent.moveTo(x, y + 4, z, level.getRandom().nextFloat() * 360F, 0);
                    level.addFreshEntity(scent);
                }
            }
        }

        // === Cloud burst + alert on evolved death ===
        if (entity instanceof EvolvedInfected evolved && Math.random() < 0.2) {
            AreaEffectCloud cloud = new AreaEffectCloud(level, x, y, z);
            cloud.setRadius(2.5F);
            cloud.setRadiusOnUse(-0.5F);
            cloud.setWaitTime(10);
            cloud.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 40, 0));
            cloud.setDuration(cloud.getDuration() / 2);
            cloud.setRadiusPerTick(-cloud.getRadius() / cloud.getDuration());
            level.addFreshEntity(cloud);

            AABB alertBox = evolved.getBoundingBox().inflate(30);
            List<Entity> nearby = level.getEntities(evolved, alertBox);
            for (Entity e : nearby) {
                if (e instanceof Infected ally) {
                    ally.setSearchPos(new BlockPos((int) x, (int)y, (int)z));
                }
            }
        }

        // === Proto summoning logic ===
        if (entity instanceof Infected inf && event.getSource().getEntity() != null && inf.getLinked()) {
            double chance = SConfig.SERVER.proto_calamity.get() / 100f;
            if (inf instanceof EvolvedInfected && Math.random() < chance) callProto(inf);
            if (inf instanceof Hyper && Math.random() < chance * 2) callProto(inf);
            if (inf instanceof GastGeber && Math.random() < chance * 4) callProto(inf);
        }

        // === Player to infected conversion ===
        if (entity instanceof Player player && player.hasEffect(Seffects.MYCELIUM.get()) && SConfig.SERVER.inf_player.get()) {
            InfectedPlayer infectedPlayer = new InfectedPlayer(Sentities.INF_PLAYER.get(), level);
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR || slot.getType() == EquipmentSlot.Type.HAND) {
                    setItemBySlot(player, slot, infectedPlayer);
                }
            }
            infectedPlayer.setSkin();
            infectedPlayer.moveTo(x, y, z);
            infectedPlayer.setCustomName(player.getName());
            level.addFreshEntity(infectedPlayer);
        }

        // === General conversion based on config map ===
        if (entity.hasEffect(Seffects.MYCELIUM.get()) && !(entity instanceof Player)) {
            if (level instanceof ServerLevel serverLevel) {
                for (String entry : SConfig.SERVER.inf_human_conv.get()) {
                    String[] parts = entry.split("\\|");
                    if (parts.length < 2) continue;

                    ResourceLocation id = new ResourceLocation(parts[1]);
                    EntityType<?> type = ForgeRegistries.ENTITY_TYPES.getValue(id);
                    if (type != null && parts[0].equals(entity.getEncodeId())) {
                        Entity result = type.create(serverLevel);
                        if (result != null) {
                            result.setCustomName(entity.getCustomName());
                            result.setPos(entity.position());
                            if (result instanceof Mob mob) {
                                mob.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(entity.blockPosition()), MobSpawnType.CONVERSION, null, null);
                            }
                            if (result instanceof Infected converted) {
                                converted.setOrigin(entity.getEncodeId());
                            }
                            serverLevel.addFreshEntity(result);
                            entity.discard();
                            break;
                        }
                    }
                }

                if (entity instanceof IronGolem golem && Math.random() < SConfig.SERVER.machine_infestation.get() / 100f) {
                    InfestedConstruct construct = new InfestedConstruct(Sentities.INF_CONSTRUCT.get(), serverLevel);
                    construct.setPos(golem.position());
                    construct.setHealth(10);
                    construct.setMachineHealth(0);
                    construct.setActive(false);
                    construct.setCustomName(golem.getCustomName());
                    serverLevel.addFreshEntity(construct);
                    golem.discard();
                }
            }
        }

        // === Rewards and Hivemind AI learning ===
        giveRewards(event.getSource().getEntity(), entity);
        awardHivemind(event.getSource().getEntity(), entity);
    }

    private static void callProto(Entity entity) {
        AABB box = entity.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
        List<Proto> protos = entity.level().getEntitiesOfClass(Proto.class, box, EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        if (!protos.isEmpty()) {
            Proto selected = protos.get(RandomSource.create().nextInt(protos.size()));
            selected.setSignal(new Signal(true, BlockPos.containing(entity.position())));
        }
    }

    private static void giveRewards(Entity source, LivingEntity victim) {
        if (source instanceof Hvindicator hv) {
            hv.awardSkull(victim);
        }
    }

    private static void awardHivemind(Entity source, LivingEntity victim) {
        if (source instanceof Mob mob) {
            CompoundTag data = mob.getPersistentData();
            if (data.contains("hivemind")) {
                Entity summoner = mob.level().getEntity(data.getInt("hivemind"));
                if (summoner instanceof Proto proto) {
                    int decision = data.getInt("decision");
                    proto.adjustWeightsForDecision(decision, 0.1);
                }
            }
        }
    }
}
