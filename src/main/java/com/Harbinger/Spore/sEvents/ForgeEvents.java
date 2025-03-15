package com.Harbinger.Spore.sEvents;

import com.Harbinger.Spore.Sentities.Utility.NukeEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Spore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEvents {
    @SubscribeEvent
    public static void onCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player != null) {
            float maxShakeDistance = 25.0f; // Max distance for shake
            float maxShakeIntensity = 2.0f; // Max shake intensity

            List<NukeEntity> nukes = player.level().getEntitiesOfClass(NukeEntity.class, player.getBoundingBox().inflate(maxShakeDistance));
            for (NukeEntity nuke : nukes) {
                double distance = player.distanceTo(nuke);

                if (distance < maxShakeDistance) {
                    RandomSource randomSource = RandomSource.create();
                    float intensity = (1.0f - (float) (distance / maxShakeDistance)) * maxShakeIntensity;

                    float shakeX = (randomSource.nextFloat() - 0.5f) * intensity;
                    float shakeY = (randomSource.nextFloat() - 0.5f) * intensity;

                    event.setYaw(event.getYaw() + shakeX);
                    event.setPitch(event.getPitch() + shakeY);
                }
            }
        }
    }
}
