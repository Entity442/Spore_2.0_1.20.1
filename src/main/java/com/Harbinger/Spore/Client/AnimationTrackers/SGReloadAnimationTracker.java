package com.Harbinger.Spore.Client.AnimationTrackers;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class SGReloadAnimationTracker {
    private static final Map<UUID, MagazineRotationState> rotationStates = new HashMap<>();

    public static class MagazineRotationState {
        public float currentRotation = 0f; // Current rotation in degrees
        public float targetRotation = 0f;  // Target rotation in degrees
        public int animationTicks;     // Animation duration
        public int maxAnimationTicks; // Total animation duration

        public MagazineRotationState(float targetRot, int duration) {
            this.targetRotation = targetRot;
            this.maxAnimationTicks = duration;
            this.animationTicks = duration;
        }
    }

    public static void triggerRotation(Player player, float targetRotation, int duration) {
        UUID playerId = player.getUUID();
        MagazineRotationState newState = new MagazineRotationState(targetRotation, duration);
        rotationStates.put(playerId, newState);
    }

    public static float getCurrentRotation(Player player, float partialTicks) {
        MagazineRotationState state = rotationStates.get(player.getUUID());
        if (state == null || state.animationTicks <= 0) {
            return state != null ? state.targetRotation : 0f;
        }

        float progress = 1f - ((float) state.animationTicks - partialTicks) / state.maxAnimationTicks;
        progress = easeInOutCubic(progress); // Smooth easing

        float startRotation = getStartRotation(state);
        float rotationDelta = getRotationDelta(state, startRotation);

        return startRotation + (rotationDelta * progress);
    }

    private static float getStartRotation(MagazineRotationState state) {
        return state.currentRotation;
    }

    private static float getRotationDelta(MagazineRotationState state, float startRotation) {
        float delta = state.targetRotation - startRotation;
        if (Math.abs(delta) > 180f) {
            delta = delta - 360f * Math.signum(delta);
        }

        return delta;
    }

    private static float easeInOutCubic(float x) {
        return x < 0.5 ? 4 * x * x * x : 1 - (float) Math.pow(-2 * x + 2, 3) / 2;
    }

    public static void tickAll() {
        rotationStates.entrySet().removeIf(entry -> {
            MagazineRotationState state = entry.getValue();
            if (state.animationTicks > 0) {
                state.animationTicks--;

                // Update current rotation when animation completes
                if (state.animationTicks <= 0) {
                    state.currentRotation = state.targetRotation;
                    // Normalize to 0-360 range
                    state.currentRotation = (state.currentRotation % 360 + 360) % 360;
                    state.targetRotation = state.currentRotation;
                }
            }
            return false; // Don't remove, keep for state tracking
        });
    }

}