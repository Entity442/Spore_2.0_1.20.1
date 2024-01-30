package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.google.common.base.Predicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class FollowOthersGoal extends Goal {
    private static Predicate<LivingEntity> PARTNER_TARGETING;
    private final Infected infected;
    private final Class<? extends LivingEntity> desired_partner;
    public FollowOthersGoal(Infected infected,Class<? extends LivingEntity> desiredPartner, @Nullable Predicate<LivingEntity> en){
        PARTNER_TARGETING = en;
        this.infected = infected;
        this.desired_partner = desiredPartner;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (infected.tickCount % 20 == 0){
            if(infected.getFollowPartner() == null){
                getFreePartner();
                return false;
            }else{
                return infected.getFollowPartner() != null;
            }
        }
        return false;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        return infected.getFollowPartner() != null;
    }

    @Override
    public void tick() {
        super.tick();
        if (infected.getFollowPartner() != null){
            infected.getNavigation().moveTo(this.infected.getFollowPartner(),1);
        }
    }

    @Nullable
    private LivingEntity getFreePartner() {
        List<? extends LivingEntity> list = infected.level().getEntitiesOfClass(desired_partner, this.infected.getBoundingBox().inflate(32),PARTNER_TARGETING);
        double d0 = Double.MAX_VALUE;
        for(LivingEntity inf1 : list) {
            if (this.infected.distanceToSqr(inf1) < d0 && inf1 != this.infected) {
                infected.setFollowPartner(inf1);
                d0 = this.infected.distanceToSqr(inf1);
            }
        }
        return null;
    }
}
