package com.Harbinger.Spore.Sentities.AI.LocHiv;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class FollowOthersGoal extends Goal {
    private static TargetingConditions PARTNER_TARGETING;
    protected final Level level;
    protected final PathfinderMob mob;
    private final Class<? extends PathfinderMob> partnerClass;
    @Nullable
    protected PathfinderMob partner;
    private final double speedModifier;

    public  FollowOthersGoal(PathfinderMob mob, double speedModifier){
        this(mob , speedModifier, mob.getClass());
    }
    public FollowOthersGoal(PathfinderMob mob, double speedModifier, Class<? extends PathfinderMob> partnerClass){
        this(mob,speedModifier,partnerClass , null);
    }

    public  FollowOthersGoal(PathfinderMob mob, double speedModifier, Class<? extends PathfinderMob> partnerClass, @Nullable Predicate<LivingEntity> en){
    this.level = mob.level();
    this.mob = mob;
    this.speedModifier = speedModifier;
    this.partnerClass = partnerClass;
    PARTNER_TARGETING = TargetingConditions.forNonCombat().range(this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE)).selector(en);
    this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
}

    @Override
    public boolean canUse() {
    if (mob.getTarget() != null || this.getFreePartner() == null){
        return false;
    } else{
        if (this.mob.getRandom().nextInt(0,5) == 1){
            this.partner = this.getFreePartner();
        }
        return this.partnerClass != null;
     }
    }
    public boolean canContinueToUse() {
        if (this.partner != null){
        return this.partner.isAlive() || this.getFreePartner() != null;
        }
        return false;
        }

    public void stop() {
        this.partner = null;
}

    public void tick() {
      if(this.partner != null){
        this.mob.getNavigation().moveTo(this.partner, this.speedModifier);
      }
}


    @Nullable
    private PathfinderMob getFreePartner() {
        List<? extends PathfinderMob> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.mob, this.mob.getBoundingBox().inflate(this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE)));
        double d0 = Double.MAX_VALUE;
        PathfinderMob inf = null;

        for(PathfinderMob inf1 : list) {
            if ( this.mob.distanceToSqr(inf1) < d0) {
                inf = inf1;
                d0 = this.mob.distanceToSqr(inf1);
            }
        }

        return inf;
    }

}

