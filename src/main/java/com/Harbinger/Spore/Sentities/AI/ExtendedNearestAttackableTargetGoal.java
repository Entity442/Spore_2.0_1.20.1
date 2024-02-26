package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class ExtendedNearestAttackableTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {


    public ExtendedNearestAttackableTargetGoal(Mob p_26060_, Class<T> p_26061_, boolean p_26062_) {
        super(p_26060_, p_26061_, p_26062_);
    }

    public ExtendedNearestAttackableTargetGoal(Mob p_199891_, Class<T> p_199892_, boolean p_199893_, Predicate<LivingEntity> p_199894_) {
        super(p_199891_, p_199892_, p_199893_, p_199894_);
    }

    public ExtendedNearestAttackableTargetGoal(Mob p_26064_, Class<T> p_26065_, boolean p_26066_, boolean p_26067_) {
        super(p_26064_, p_26065_, p_26066_, p_26067_);
    }

    public ExtendedNearestAttackableTargetGoal(Mob p_26053_, Class<T> p_26054_, int p_26055_, boolean p_26056_, boolean p_26057_, @Nullable Predicate<LivingEntity> p_26058_) {
        super(p_26053_, p_26054_, p_26055_, p_26056_, p_26057_, p_26058_);
    }

    @Override
    protected AABB getTargetSearchArea(double value) {
        return this.mob.getBoundingBox().inflate(value, value, value);
    }
}
