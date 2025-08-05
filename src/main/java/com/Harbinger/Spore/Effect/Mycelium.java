package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class Mycelium extends MobEffect {
    public Mycelium() {
        super(MobEffectCategory.HARMFUL, 9643043);
    }

    public void applyEffectTick(LivingEntity entity, int intense) {
        if (Utilities.TARGET_SELECTOR.Test(entity) && !SConfig.SERVER.mycelium.get().contains(entity.getEncodeId())){
            if (this == Seffects.MYCELIUM.get()) {
                if (!entity.level().isClientSide && entity instanceof Player player && player.getFoodData().getFoodLevel() > 0 && intense < 1){
                    player.causeFoodExhaustion(1.0F);
                }else {
                    entity.hurt(SdamageTypes.mycelium_overtake(entity), 1.0F);
                }
            }
        }
    }


    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.MYCELIUM.get()) {
            int i = 80 >> intensity;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}