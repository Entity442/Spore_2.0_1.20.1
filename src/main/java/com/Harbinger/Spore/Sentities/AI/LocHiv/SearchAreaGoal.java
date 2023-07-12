package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class SearchAreaGoal extends Goal {
    public final Infected infected;
    public final double speed;
    public  int tryTicks;

    public SearchAreaGoal(Infected infected1 , double speed){
        this.infected = infected1;
        this.speed = speed;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    protected void moveMobToBlock() {
        this.infected.getNavigation().moveTo((double)((float)this.infected.getSearchPos().getX()) + 0.5D, (double)(this.infected.getSearchPos().getY() + 1), (double)((float)this.infected.getSearchPos().getZ()) + 0.5D, 1);
    }
    @Override
    public boolean canUse() {
        return this.infected.getSearchPos() != null && infected.getTarget() == null;
    }

    @Override
    public void start() {
        this.moveMobToBlock();
        this.tryTicks = 0;
        super.start();
    }

    @Override
    public boolean canContinueToUse() {
        return infected.getTarget() == null;
    }


    @Override
    public void tick() {
        super.tick();
        ++this.tryTicks;
        if (this.infected.getSearchPos() != null && shouldRecalculatePath()){
            this.infected.getNavigation().moveTo(this.infected.getSearchPos().getX(),this.infected.getSearchPos().getY(),this.infected.getSearchPos().getZ(),1);
        }
        if (this.infected.getSearchPos() != null && this.infected.getSearchPos().closerToCenterThan(this.infected.position(),9.0)){
            infected.setSearchPos(null);
        }
    }

    public boolean shouldRecalculatePath() {
        return this.tryTicks % 40 == 0;
    }


    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
