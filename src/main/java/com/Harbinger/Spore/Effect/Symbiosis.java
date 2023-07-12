package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.Seffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.extensions.IForgeMobEffect;

import java.util.ArrayList;
import java.util.List;

public class Symbiosis extends MobEffect implements IForgeMobEffect {
    public Symbiosis() {
        super(MobEffectCategory.BENEFICIAL, 8412043);
    }
    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(ItemStack.EMPTY);
        return ret;
    }


    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.getCommandSenderWorld().isClientSide && entity instanceof Player player) {
                    player.causeFoodExhaustion(0.1F);
        }
    }

    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.SYMBIOSIS.get()) {
            int i = 40 >> intensity;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
