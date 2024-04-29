package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import net.minecraft.server.level.ServerLevel;
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
        if (Math.random() < 0.1 && intense > 2 && entity.level() instanceof ServerLevel serverLevel){
            Illusion illusion = new Illusion(Sentities.ILLUSION.get(), entity.level());
            illusion.setSeeAble(false);
            int x = entity.getRandom().nextInt(-6,6);
            int z = entity.getRandom().nextInt(-6,6);
            DifficultyInstance difficultyInstance = entity.level().getCurrentDifficultyAt(entity.blockPosition());
            illusion.moveTo(entity.getX() + x,entity.getY(),entity.getZ()+z);
            illusion.finalizeSpawn(serverLevel, difficultyInstance, MobSpawnType.EVENT,null,null);
            entity.level().addFreshEntity(illusion);
        }
    }


    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.MADNESS.get()) {
            return duration % 80 == 0;
        }
        return false;
    }



}