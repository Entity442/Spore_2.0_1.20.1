package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.google.common.base.Predicate;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class FollowOthersGoal extends Goal {
    private static final int SEARCH_INTERVAL = 20; // Search every second (20 ticks)
    private static final int FOLLOW_DISTANCE = 32;
    private static final double STOP_FOLLOWING_DISTANCE = 3.0; // Stop if too close
    private static final double TELEPORT_DISTANCE = 64.0; // Teleport if too far

    private final Infected infected;
    private final Class<? extends LivingEntity> desiredPartner;
    private final Predicate<LivingEntity> partnerTargeting;

    private int searchCooldown = 0;
    private int stuckCounter = 0;
    private LivingEntity lastTarget;

    public FollowOthersGoal(Infected infected, Class<? extends LivingEntity> desiredPartner,
                            @Nullable Predicate<LivingEntity> predicate) {
        this.infected = infected;
        this.desiredPartner = desiredPartner;
        this.partnerTargeting = predicate;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Only search every few ticks to reduce CPU usage
        if (--searchCooldown > 0) {
            return infected.getFollowPartner() != null;
        }

        searchCooldown = SEARCH_INTERVAL;

        LivingEntity currentPartner = infected.getFollowPartner();

        // Check if current partner is still valid
        if (isValidPartner(currentPartner)) {
            return true;
        }

        // Clear invalid partner
        if (currentPartner != null) {
            infected.setFollowPartner(null);
        }

        // Try to find a new partner
        LivingEntity newPartner = findNearestPartner();
        if (newPartner != null) {
            infected.setFollowPartner(newPartner);
            return true;
        }

        return false;
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity partner = infected.getFollowPartner();

        if (partner == null || !partner.isAlive()) {
            return false;
        }

        // Stop following if too far (prevents endless chasing)
        if (infected.distanceToSqr(partner) > TELEPORT_DISTANCE * TELEPORT_DISTANCE) {
            infected.setFollowPartner(null);
            return false;
        }

        return true;
    }

    @Override
    public void start() {
        super.start();
        stuckCounter = 0;
        lastTarget = null;
    }

    @Override
    public void stop() {
        super.stop();
        infected.getNavigation().stop();
        stuckCounter = 0;
        lastTarget = null;
    }

    @Override
    public void tick() {
        LivingEntity partner = infected.getFollowPartner();
        if (partner == null) return;

        double distanceToPartner = infected.distanceToSqr(partner);

        // Stop moving if too close
        if (distanceToPartner <= STOP_FOLLOWING_DISTANCE * STOP_FOLLOWING_DISTANCE) {
            infected.getNavigation().stop();
            return;
        }

        // Teleport if extremely far (prevents getting permanently stuck)
        if (distanceToPartner > TELEPORT_DISTANCE * TELEPORT_DISTANCE) {
            infected.teleportTo(partner.getX(), partner.getY(), partner.getZ());
            return;
        }

        PathNavigation navigation = infected.getNavigation();

        // Only update path periodically or when target changes
        if (lastTarget != partner || shouldRepath()) {
            navigation.moveTo(partner, 1.0);
            lastTarget = partner;
            stuckCounter = 0;
        }

        // Check if stuck
        if (navigation.isDone()) {
            stuckCounter++;
            if (stuckCounter > 10) { // Stuck for 10 ticks, try repathing
                navigation.stop();
                navigation.moveTo(partner, 1.0);
                stuckCounter = 0;
            }
        }

        // Look at the partner
        infected.getLookControl().setLookAt(partner, 30.0F, 30.0F);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Nullable
    private LivingEntity findNearestPartner() {
        List<? extends LivingEntity> candidates = infected.level().getEntitiesOfClass(
                desiredPartner,
                infected.getBoundingBox().inflate(FOLLOW_DISTANCE),
                this::isValidPartner
        );

        if (candidates.isEmpty()) {
            return null;
        }

        LivingEntity nearest = null;
        double nearestDistance = Double.MAX_VALUE;
        double infectedX = infected.getX();
        double infectedY = infected.getY();
        double infectedZ = infected.getZ();

        for (LivingEntity candidate : candidates) {
            if (candidate == infected) continue;

            double dx = candidate.getX() - infectedX;
            double dy = candidate.getY() - infectedY;
            double dz = candidate.getZ() - infectedZ;
            double distanceSqr = dx * dx + dy * dy + dz * dz;

            if (distanceSqr < nearestDistance) {
                nearestDistance = distanceSqr;
                nearest = candidate;
            }
        }

        return nearest;
    }

    private boolean isValidPartner(LivingEntity entity) {
        // Check if entity is alive and valid
        if (entity == null || !entity.isAlive()) return false;

        // Apply custom predicate if exists
        return partnerTargeting == null || partnerTargeting.apply(entity);
    }

    private boolean shouldRepath() {
        // Repath every 20 ticks or if navigation fails
        return infected.tickCount % 20 == 0;
    }
}