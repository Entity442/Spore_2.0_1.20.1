package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Madness extends MobEffect {
    public Madness() {
        super(MobEffectCategory.HARMFUL, 419435);
    }

    public void applyEffectTick(LivingEntity entity, int intense) {
        if (Math.random() < (SConfig.SERVER.chance_hallucination_spawn.get() * 0.01) && entity.level() instanceof ServerLevel serverLevel){
            if (intense > 1 && intense < 4){
                SummonIllusion(entity,serverLevel,false,entity.getId());
            }
            if (intense >= 4){
                SummonIllusion(entity,serverLevel,true,entity.getId());
            }
        }
        if (Math.random() < 0.1){
            this.playClientSounds(entity);
        }
        if (Math.random() < 0.1 && intense > 0 && entity instanceof ServerPlayer player){
            this.feelingWatched(player);
        }
    }

    public void feelingWatched(ServerPlayer player){
        player.displayClientMessage(Component.translatable("vigil.message"),true);
    }

    public void SummonIllusion(LivingEntity entity,ServerLevel serverLevel,boolean value,int targetId){
        int x = entity.getRandom().nextInt(-6,6);
        int z = entity.getRandom().nextInt(-6,6);
        Illusion illusion = new Illusion(Sentities.ILLUSION.get(), serverLevel);
        illusion.setSeeAble(false);
        illusion.setAdvanced(value);
        illusion.setTargetId(targetId);
        DifficultyInstance difficultyInstance = serverLevel.getCurrentDifficultyAt(entity.blockPosition());
        illusion.moveTo(entity.getX() + x,entity.getY(),entity.getZ()+z);
        illusion.finalizeSpawn(serverLevel, difficultyInstance, MobSpawnType.MOB_SUMMONED,null,null);
        serverLevel.addFreshEntity(illusion);
    }

    public void playClientSounds(LivingEntity entity){
        entity.playSound(Ssounds.MADNESS.get());
    }


    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.MADNESS.get()) {
            return duration % 80 == 0;
        }
        return false;
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(ItemStack.EMPTY);
        return ret;
    }
}