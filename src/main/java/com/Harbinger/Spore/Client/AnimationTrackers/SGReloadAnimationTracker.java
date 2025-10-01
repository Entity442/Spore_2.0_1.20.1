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
        public float startRotation;   // Where the animation begins
        public float currentRotation; // Last completed rotation
        public float targetRotation;  // Where we want to end up
        public int animationTicks;    // Remaining ticks
        public int maxAnimationTicks; // Total animation duration

        public MagazineRotationState(float startRot, float targetRot, int duration) {
            this.startRotation = normalizeAngle(startRot);
            this.currentRotation = this.startRotation;
            this.targetRotation = normalizeAngle(targetRot);
            this.maxAnimationTicks = duration;
            this.animationTicks = duration;
        }
    }

    public static void triggerRotationToChamber(Player player, int chamberIndex, int duration) {
        UUID playerId = player.getUUID();
        MagazineRotationState prevState = rotationStates.get(playerId);

        float startRot = prevState != null ? prevState.currentRotation : 0f;
        float targetRot = chamberIndex * 90f; // 4 chambers, 90° each

        MagazineRotationState newState = new MagazineRotationState(startRot, targetRot, duration);
        rotationStates.put(playerId, newState);
    }


    public static float getCurrentRotation(Player player, float partialTicks) {
        MagazineRotationState state = rotationStates.get(player.getUUID());
        if (state == null) return 0f;

        if (state.animationTicks <= 0) {
            return state.currentRotation;
        }

        float progress = 1f - ((float) state.animationTicks - partialTicks) / state.maxAnimationTicks;
        progress = easeInOutCubic(progress); // Smooth easing curve

        float delta = shortestAngleDelta(state.startRotation, state.targetRotation);
        return normalizeAngle(state.startRotation + delta * progress);
    }

    public static void tickAll() {
        rotationStates.forEach((id, state) -> {
            if (state.animationTicks > 0) {
                state.animationTicks--;

                if (state.animationTicks <= 0) {
                    // Snap to final state
                    state.currentRotation = normalizeAngle(state.targetRotation);
                    state.startRotation = state.currentRotation;
                    state.targetRotation = state.currentRotation;
                }
            }
        });
    }
    private static float shortestAngleDelta(float from, float to) {
        float delta = normalizeAngle(to) - normalizeAngle(from);
        if (delta > 180f) delta -= 360f;
        if (delta < -180f) delta += 360f;
        return delta;
    }

    private static float normalizeAngle(float angle) {
        return (angle % 360f + 360f) % 360f;
    }

    private static float easeInOutCubic(float x) {
        return x < 0.5f ? 4 * x * x * x : 1 - (float) Math.pow(-2 * x + 2, 3) / 2f;
    }
}
