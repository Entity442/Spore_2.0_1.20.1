package com.Harbinger.Spore.Effect;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class Ignitable extends MobEffect {
    public Ignitable() {
        super(MobEffectCategory.NEUTRAL, 1908001);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of();
    }
    public enum SetAblazeChances{
        LIGHTNING(DamageTypes.LIGHTNING_BOLT,1),
        EXPLOSION(DamageTypes.EXPLOSION,0.8f),
        PLAYER_EXPLOSION(DamageTypes.PLAYER_EXPLOSION,0.6f),
        IN_FIRE(DamageTypes.IN_FIRE,0.2f),
        ON_FIRE(DamageTypes.ON_FIRE,0.1f),
        FIREWORKS(DamageTypes.FIREWORKS,0.3f);

        private final ResourceKey<DamageType> damageType;
        private final float chance;

        SetAblazeChances(ResourceKey<DamageType> damageType, float chance) {
            this.damageType = damageType;
            this.chance = chance;
        }

        public float getChance() {
            return chance;
        }

        public ResourceKey<DamageType> getDamageType() {
            return damageType;
        }
    }
}
