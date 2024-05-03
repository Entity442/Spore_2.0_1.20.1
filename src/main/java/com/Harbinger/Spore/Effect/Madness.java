package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;

public class Madness extends MobEffect {
    public Madness() {
        super(MobEffectCategory.HARMFUL, 419435);
    }

    public void applyEffectTick(LivingEntity entity, int intense) {
        if (Math.random() < (SConfig.SERVER.chance_hallucination_spawn.get() * 0.01) && intense > 1 && entity.level() instanceof ServerLevel serverLevel){
            SummonIllusion(entity,serverLevel);
        }
        if (Math.random() < 0.3 && intense > 0){
            this.playClientSounds(entity);
        }
    }

    public void SummonIllusion(LivingEntity entity,ServerLevel serverLevel){
        int x = entity.getRandom().nextInt(-6,6);
        int z = entity.getRandom().nextInt(-6,6);
        Illusion illusion = new Illusion(Sentities.ILLUSION.get(), serverLevel);
        illusion.setSeeAble(false);
        DifficultyInstance difficultyInstance = serverLevel.getCurrentDifficultyAt(entity.blockPosition());
        illusion.moveTo(entity.getX() + x,entity.getY(),entity.getZ()+z);
        illusion.finalizeSpawn(serverLevel, difficultyInstance, MobSpawnType.MOB_SUMMONED,null,null);
        serverLevel.addFreshEntity(illusion);
    }

    public void playClientSounds(LivingEntity entity){
        entity.playSound(SoundEvents.GHAST_AMBIENT);
    }


    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.MADNESS.get()) {
            return duration % 80 == 0;
        }
        return false;
    }



}