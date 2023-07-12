package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class BuffAlliesGoal extends Goal {
    protected final Level level;
    public final Mob mob;
    private final RangedBuff rangedAttackMob;
    private final TargetingConditions PARTNER_TARGETING;
    private final Class<? extends Mob> partnerClass;
    @Nullable
    protected Mob partner;
    private int attackTime = -1;
    private final double speedModifier;
    private final int attackIntervalMin;
    private final int attackIntervalMax;
    private final float attackRadius;

    public BuffAlliesGoal(RangedBuff mob1, Class<? extends Mob> partnerClass, double speedModifier, int attackTime, int attackTime1, float attackRadius) {
        this(mob1 ,partnerClass,speedModifier,attackTime,attackTime1,attackRadius, null);
    }

    public BuffAlliesGoal(RangedBuff mob1, Class<? extends Mob> partnerClass, double speedModifier, int attackTime, int attackTime1, float attackRadius ,@Nullable Predicate<LivingEntity> en) {
        this.partnerClass = partnerClass;
        if (!(mob1 instanceof LivingEntity)) {
            throw new IllegalArgumentException("Buff");
        } else {
            this.level =((LivingEntity) mob1).level();
            this.rangedAttackMob = mob1;
            this.mob = (Mob)mob1;
            this.PARTNER_TARGETING = TargetingConditions.forNonCombat().range(this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE)).selector(en);
            this.speedModifier = speedModifier;
            this.attackIntervalMin = attackTime;
            this.attackIntervalMax = attackTime1;
            this.attackRadius = attackRadius;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }
    }

    public boolean canUse() {
        if (mob.getTarget() != null || this.getFreePartner() == null){
            return false;
        } else {
            this.partner = this.getFreePartner();
            return this.partnerClass != null;
        }

    }

    public boolean canContinueToUse() {
        return this.partner != null && (this.partner.isAlive() || this.getFreePartner() != null);}

    public void stop() {
        this.partner = null;
        this.attackTime = -1;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        assert this.partner != null;
        double d0 = this.mob.distanceToSqr(this.partner.getX(), this.partner.getY(), this.partner.getZ());
        boolean flag = this.mob.getSensing().hasLineOfSight(this.partner);
            this.mob.getNavigation().moveTo(this.partner, this.speedModifier);

        this.mob.getLookControl().setLookAt(this.partner, 30.0F, 30.0F);
        if (--this.attackTime == 0) {
            if (!flag) {
                return;
            }

            float f = (float)Math.sqrt(d0) / this.attackRadius;
            float f1 = Mth.clamp(f, 0.1F, 1.0F);
            this.rangedAttackMob.performRangedBuff(this.partner, f1);
            this.attackTime = Mth.floor(f * (float)(this.attackIntervalMax - this.attackIntervalMin) + (float)this.attackIntervalMin);
        } else if (this.attackTime < 0) {
            this.attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / (double)this.attackRadius, this.attackIntervalMin, this.attackIntervalMax));
        }

    }

    @Nullable
    private Mob getFreePartner() {
        List<? extends Mob> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.mob, this.mob.getBoundingBox().inflate(this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE)));
        double d0 = Double.MAX_VALUE;
        Mob inf = null;

        for(Mob inf1 : list) {
            if ( this.mob.distanceToSqr(inf1) < d0) {
                inf = inf1;
                d0 = this.mob.distanceToSqr(inf1);
            }
        }

        return inf;
    }
}
