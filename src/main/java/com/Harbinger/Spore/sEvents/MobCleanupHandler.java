package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MobCleanupHandler {
    private static int tickCounter = 0;
    private static final int CHECK_INTERVAL = 1200;
    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.level.isClientSide) return;
        tickCounter++;
        if (tickCounter >= CHECK_INTERVAL && event.level instanceof ServerLevel level) {
            tickCounter = 0;
            cleanUpMobs(level);
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
                    !SConfig.SERVER.despawn_blacklist.get().contains(living.getEncodeId()) && !living.hasCustomName()) {

                if (living instanceof Organoid o) organoid.add(o);
                else if (living instanceof EvolvedInfected e) evolved.add(e);
                else if (living instanceof Hyper h) hyper.add(h);
                else if (living instanceof ScentEntity s) scent.add(s);
                else if (living instanceof Infected i){infected.add(i);}
            }
        }

        despawnExcess(level, infected, SConfig.SERVER.max_infected_cap.get());
        despawnExcess(level, evolved, SConfig.SERVER.max_evolved_cap.get());
        despawnExcess(level, hyper, SConfig.SERVER.max_hyper_cap.get());
        despawnExcess(level, organoid, SConfig.SERVER.max_organoid_cap.get());
        despawnExcess(level, scent, SConfig.SERVER.max_scent_cap.get());
    }

    private static <T extends LivingEntity> void despawnExcess(ServerLevel level, List<T> entities, int cap) {
        int despawns = 0;
        if (entities.size() <= cap) return;
        List<ServerPlayer> players = level.getPlayers(p -> true);
        if (players.isEmpty()){
            for (int i = 0; i < entities.size() - cap; i++) {
                T entity = entities.get(i);
                entity.discard();
                despawns++;
            }
        }else {
            entities.sort(Comparator.comparingDouble(e ->
                    level.getNearestPlayer(e, -1) != null ? e.distanceToSqr(Objects.requireNonNull(level.getNearestPlayer(e, -1))) : Double.MAX_VALUE));
            int toRemove = entities.size() - cap;
            for (int i = 0; i < toRemove; i++) {
                T entity = entities.get(i);
                entity.discard();
                despawns++;
            }
        }
        if (players.isEmpty()){
            System.out.print(despawns + " spore entities have been despawned");
        }else {
            int finalDespawns = despawns;
            players.forEach(e -> e.displayClientMessage(Component.literal(finalDespawns + " mobs have been assimilated"), false));
        }
    }
}
