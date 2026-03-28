package com.Harbinger.Spore.Client.MusicManager;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;

public class SporeMusicInstance extends AbstractTickableSoundInstance {

    private float targetVolume = 1f;
    private float fadeSpeed = 0.01f;
    private int ticks;
    private static final RandomSource random = RandomSource.create();
    public SporeMusicInstance(SoundEvent sound) {
        super(sound, SoundSource.MUSIC,random);
        this.looping = false;
        this.relative = true;
        this.attenuation = Attenuation.NONE;
        this.pitch = 1.0f;
        this.volume = 1.0f;
    }

    public void fadeIn() {
        targetVolume = 1f;
        fadeSpeed = 0.01f;
    }

    public void fadeOut() {
        targetVolume = 0f;
        fadeSpeed = 0.02f;
    }

    @Override
    public void tick() {
        if (volume < targetVolume) {
            volume = Math.min(targetVolume, volume + fadeSpeed);
        } else if (volume > targetVolume) {
            volume = Math.max(targetVolume, volume - fadeSpeed);
        }

        if (volume <= 0.001f && targetVolume == 0f) {
            stop();
        }
        ticks++;
    }
    public int getTickCount(){
        return ticks;
    }
}