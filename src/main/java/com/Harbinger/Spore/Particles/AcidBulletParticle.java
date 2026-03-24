package com.Harbinger.Spore.Particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AcidBulletParticle extends TextureSheetParticle {

    protected AcidBulletParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, double r, double g, double b) {
        super(level, xCoord, yCoord, zCoord, 0,-0.02,0);
        this.gravity = 1f;
        this.hasPhysics = true;
        this.friction = 0F;
        this.xd = 0;
        this.yd = -0.03;
        this.zd = 0;
        this.quadSize *= 1.2F;
        this.lifetime = 50;

        this.rCol = (float) r;
        this.gCol = (float) g;
        this.bCol = (float) b;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            AcidBulletParticle particle = new AcidBulletParticle(level, x, y, z, dx, dy, dz);
            particle.pickSprite(sprites);
            return particle;
        }
    }
}
