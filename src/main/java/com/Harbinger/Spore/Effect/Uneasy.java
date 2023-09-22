package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class Uneasy extends MobEffect {
    public Uneasy() {
        super(MobEffectCategory.NEUTRAL, -13434778);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(Items.MILK_BUCKET));
        list.add(new ItemStack(Items.COOKIE));
        list.add(new ItemStack(Items.PUMPKIN_PIE));
        return list;
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.getCommandSenderWorld().isClientSide && entity instanceof Player player) {
            player.playSound(Ssounds.HEART_BEAT.get());
        }
    }

    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.UNEASY.get()) {
            int i = 100 >> intensity;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
