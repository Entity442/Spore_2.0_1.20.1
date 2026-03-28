package com.Harbinger.Spore.Client.MusicManager;


import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class SporeMusicPlayer {

    private static final SoundManager SoundManager = Minecraft.getInstance().getSoundManager();

    private static SporeMusicInstance currentMusic;
    private static SoundEvent oldMusic;

    // ===== MUSIC STATE =====
    private static SoundEvent battleMusic;
    private static int battleMusicTicks;
    private static int worldUpdateDelay;
    private static final RandomSource random = RandomSource.create();

    // ===== AMBIENT PLAYLISTS =====
    private static final List<SoundEvent> DEFAULT_PLAYLIST = List.of(
            Ssounds.BICENTENNIAL.get(),
            Ssounds.CYCLE_OF_EVOLUTION.get(),
            Ssounds.DESOLATION.get(),
            Ssounds.FALL_OF_MAN.get(),
            Ssounds.MANMADE_HORRORS.get(),
            Ssounds.MYCONOCLAST.get(),
            Ssounds.NOURISHMENT.get(),
            Ssounds.PROJECT_REGENESIS.get(),
            Ssounds.RECLAIMATION.get(),
            Ssounds.RESTLESS_REACH.get(),
            Ssounds.ROADS_ONCE_TRAVELLED.get(),
            Ssounds.SLEEPLESS_DREAMING.get(),
            Ssounds.START_ANEW.get(),
            Ssounds.THE_SOIL_TALKS.get(),
            Ssounds.THEY_AWAKEN.get(),
            Ssounds.THEY_GROW_BELOW.get(),
            Ssounds.MYCONOCLAST.get()

    );

    private static final List<SoundEvent> POST_PLAYLIST = List.of(
            Ssounds.BROKEN_REFLECTION.get(),
            Ssounds.DECAY.get(),
            Ssounds.ENDLESS_FEAST.get(),
            Ssounds.MYCONAUT.get(),
            Ssounds.NATURAL_OCCURANCE.get(),
            Ssounds.NEUROGENESIS.get(),
            Ssounds.PROTOTYPE.get(),
            Ssounds.REPURPOSED.get(),
            Ssounds.ROT.get(),
            Ssounds.SPORE_BURST_SONG.get(),
            Ssounds.SYNAPTIC_RELAPSE.get(),
            Ssounds.THEY_LISTEN.get(),
            Ssounds.WHAT_WE_BECOME.get(),
            Ssounds.WHISPERS.get(),
            Ssounds.MENTAL_MUTILATION.get()
    );

    // =========================================================
    // ===================== TICK LOOP ==========================
    // =========================================================

    public static void tickMusic() {

        // Tick currently playing music
        if (currentMusic != null) {
            currentMusic.tick();
        }

        if (worldUpdateDelay > 0) {
            worldUpdateDelay--;
        }
        if (battleMusicTicks > 0) {
            battleMusicTicks--;

            if (battleMusic != null && oldMusic != battleMusic) {
                playMusic(battleMusic);
            }
            if (battleMusicTicks == 60 && oldMusic == battleMusic) {
                stopMusic();
            }
        }
    }

    // =========================================================
    // ===================== PLAY HELPERS =======================
    // =========================================================

    private static void playRandomDefault() {
        SoundEvent pick = DEFAULT_PLAYLIST.get(random.nextInt(DEFAULT_PLAYLIST.size()));
        playMusic(pick);
    }

    private static void playRandomPost() {
        SoundEvent pick = POST_PLAYLIST.get(random.nextInt(POST_PLAYLIST.size()));
        playMusic(pick);
    }

    private static void playMusic(SoundEvent music) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen instanceof TitleScreen) {
            return;
        }
        if (currentMusic != null && SoundManager.isActive(currentMusic) && music.equals(oldMusic))
            return;

        stopMusic();

        currentMusic = new SporeMusicInstance(music);
        currentMusic.fadeIn();

        SoundManager.play(currentMusic);
        oldMusic = music;
    }

    private static void stopMusic() {
        if (currentMusic != null && !currentMusic.isStopped()) {
            currentMusic.fadeOut();
        }
    }

    // =========================================================
    // ===================== NETWORK PACKET =====================
    // =========================================================

    public static void handlePacket(boolean pro, int id, boolean inCombat) {
        if (pro && id == 3){
            if (currentMusic != null){
                currentMusic.fadeOut();
            }
            playMusic(Ssounds.SOMETHING_ONCE_GREAT.get());
            return;
        }
        if (inCombat && id >= 0 && SConfig.SERVER.encounter_songs.get()) {
            SongVariantsPerEntity variants = SongVariantsPerEntity.getVariant(id);
            if (battleMusicTicks <= 0 || (currentMusic != null && currentMusic.getTickCount() >= (variants.getDuration()-10))){
                SoundEvent event = variants.getName();
                if (currentMusic != null){
                    currentMusic.fadeOut();
                }
                battleMusic = event;
                playMusic(event);
            }
            battleMusicTicks = 200;
            return;
        }
        battleMusicTicks = 0;
        battleMusic = null;
        if (currentMusic == null || !SoundManager.isActive(currentMusic)) {
            if (pro) {
                playRandomPost();
            } else {
                playRandomDefault();
            }
        }
    }

    // =========================================================
    // ================= ENTITY COMBAT TRACKS ===================
    // =========================================================

    public enum SongVariantsPerEntity {
        CALAMITY(0, Ssounds.MYCOPHOBIA.get(),2720),
        VANGUARD(1, Ssounds.BANE_OF_SETTLEMENT.get(),1640),
        VIGIL(2, Ssounds.VIRULENT_VIGIL.get(),2880),
        PROTO(3, Ssounds.SOMETHING_ONCE_GREAT.get(),6000);

        private static final SongVariantsPerEntity[] BY_ID =
                Arrays.stream(values())
                        .sorted(Comparator.comparingInt(SongVariantsPerEntity::getId))
                        .toArray(SongVariantsPerEntity[]::new);

        private final int id;
        private final SoundEvent name;
        private final int duration;

        SongVariantsPerEntity(int id, SoundEvent name, int duration) {
            this.id = id;
            this.name = name;
            this.duration = duration;
        }


        public SoundEvent getName() {
            return name;
        }

        public int getId() {
            return id;
        }
        public int getDuration() {
            return duration;
        }

        public static SongVariantsPerEntity byId(int id) {
            return BY_ID[id % BY_ID.length];
        }

        public static SongVariantsPerEntity getVariant(int var) {
            return byId(var & 255);
        }
    }
}