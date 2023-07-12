package com.Harbinger.Spore.Sentities.AI;

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

public class TransportInfected<T extends LivingEntity> extends Goal {
    public Mob mob;
    private final Class<T> partnerClass;
    protected final TargetingConditions partneerT;
    protected Level level;
    protected  final double speed;
    @Nullable
    protected T partner;

    public TransportInfected(Mob mob, Class<T> partnerClass, double speed) {
        this(mob ,partnerClass, speed, null);
    }
    public TransportInfected(Mob mob, Class<T> partnerClass, double speed, @Nullable Predicate<LivingEntity> en) {
        this.mob = mob;
        this.level = mob.level();
        this.partnerClass = partnerClass;
        this.speed = speed;
        partneerT = TargetingConditions.forNonCombat().range(this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE)).selector(en);
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }
    @Nullable
    private T getFreePartner() {
        List<T> list = this.level.getNearbyEntities(this.partnerClass, partneerT, this.mob, this.mob.getBoundingBox().inflate(this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE)));
        double d0 = Double.MAX_VALUE;
        T inf = null;

        for(T inf1 : list) {
            if ( this.mob.distanceToSqr(inf1) < d0) {
                inf = inf1;
                d0 = this.mob.distanceToSqr(inf1);
            }
        }

        return inf;
    }



    @Override
    public boolean canUse() {
        this.partner = this.getFreePartner();
        return !mob.isVehicle() && mob.getTarget() == null && partner != null;
    }

    @Override
    public void tick() {
        if (!mob.isVehicle() && partner != null && !partner.isPassenger()){
            this.mob.getLookControl().setLookAt(this.partner, 10.0F, (float)this.mob.getMaxHeadXRot());
             this.mob.getNavigation().moveTo(this.partner, this.speed);
             if (this.mob.distanceToSqr(partner) < 9.0D && !partner.isPassenger()){
             this.equip();}
        }
    }

    private void equip() {
        assert partner != null;
        partner.startRiding(mob);
    }
}
