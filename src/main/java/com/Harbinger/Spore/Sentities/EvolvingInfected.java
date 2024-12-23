package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public interface EvolvingInfected {
    default void tickEvolution(Infected infected, List<? extends String> value, ScamperVariants variants){
        if (infected.tickCount % 20 == 0){
            if (infected.getEvoPoints() >= SConfig.SERVER.min_kills.get()){
                if (infected.getEvolutionCoolDown() >= SConfig.SERVER.evolution_age_human.get()){
                    this.Evolve(infected,value,variants);
                }else{
                    if (!infected.hasEffect(MobEffects.WEAKNESS))
                        infected.setEvolution(infected.getEvolutionCoolDown()+1);
                }
            }
        }
    }
    default void tickHyperEvolution(EvolvedInfected infected){
        if (infected.tickCount % 20 == 0){
            if (infected.getEvoPoints() >= SConfig.SERVER.min_kills_hyper.get()){
                if (infected.getEvolutionCoolDown() >= SConfig.SERVER.evolution_age_human.get()){
                    this.HyperEvolve(infected);
                }else{
                    if (!infected.hasEffect(MobEffects.WEAKNESS))
                        infected.setEvolution(infected.getEvolutionCoolDown()+1);
                }
            }
        }
    }

    default void HyperEvolve(LivingEntity living){
        if (living.level() instanceof ServerLevel serverLevel){
            double x0 = living.getX() - (living.getRandom().nextFloat() - 0.1) * 0.1D;
            double y0 = living.getY() + (living.getRandom().nextFloat() - 0.25) * 0.15D * 5;
            double z0 = living.getZ() + (living.getRandom().nextFloat() - 0.1) * 0.1D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
            ringPlayers(living);
        }
    }
    default void ringPlayers(LivingEntity living){
        List<Entity> entities = living.level().getEntities(living,living.getBoundingBox().inflate(64),entity -> {return entity instanceof Player;
        });
        for (Entity entity : entities){
            if (entity instanceof Player player){player.playNotifySound(Ssounds.HYPER_EVOLVE.get(), SoundSource.AMBIENT,1f,1f);}
        }
    }
    default  void Evolve(Infected livingEntity, List<? extends String> value, ScamperVariants variants){
        if (livingEntity != null && value != null && livingEntity.level() instanceof ServerLevel world){
            Level level = livingEntity.level();
            RandomSource random = RandomSource.create();
            if (Math.random() < 0.9) {
                Random rand = new Random();
                for (int i = 0; i < 1; ++i) {
                    int randomIndex = rand.nextInt(value.size());
                    ResourceLocation randomElement1 = new ResourceLocation(value.get(randomIndex));
                    EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
                    Entity waveentity = randomElement.create(level);
                    waveentity.setPos(livingEntity.getX(), livingEntity.getY() + 0.5D, livingEntity.getZ());
                    waveentity.setCustomName(livingEntity.getCustomName());
                    if (waveentity instanceof LivingEntity entity){
                        Collection<MobEffectInstance> collection = livingEntity.getActiveEffects();
                        for(MobEffectInstance mobeffectinstance : collection) {
                            entity.addEffect(new MobEffectInstance(mobeffectinstance));
                        }
                    }
                    if (waveentity instanceof Infected infected){
                        infected.setKills(livingEntity.getKills());
                        infected.setEvoPoints(livingEntity.getEvoPoints());
                        infected.setSearchPos(livingEntity.getSearchPos());
                        infected.setLinked(livingEntity.getLinked());
                        infected.finalizeSpawn(world, livingEntity.level().getCurrentDifficultyAt(new BlockPos((int) livingEntity.getX(),(int)  livingEntity.getY(),(int)  livingEntity.getZ())), MobSpawnType.NATURAL, null, null);
                    }
                    level.addFreshEntity(waveentity);

                    livingEntity.discard();
                }
            }else {
                Scamper scamper = new Scamper(Sentities.SCAMPER.get(), level);
                scamper.setPos(livingEntity.getX(), livingEntity.getY() + 0.5D, livingEntity.getZ());
                scamper.setCustomName(livingEntity.getCustomName());
                scamper.setKills(livingEntity.getKills());
                scamper.setEvoPoints(livingEntity.getEvoPoints());
                scamper.setLinked(livingEntity.getLinked());
                scamper.setSearchPos(livingEntity.getSearchPos());
                Collection<MobEffectInstance> collection = livingEntity.getActiveEffects();
                for(MobEffectInstance mobeffectinstance : collection) {
                    scamper.addEffect(new MobEffectInstance(mobeffectinstance));
                }
                level.addFreshEntity(scamper);
                livingEntity.discard();
            }
            if (level instanceof ServerLevel serverLevel){
                double x0 = livingEntity.getX() - (random.nextFloat() - 0.1) * 0.1D;
                double y0 = livingEntity.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                double z0 = livingEntity.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
            }
        }
    }
}
