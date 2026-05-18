package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.SporeRenderTypes;
import com.Harbinger.Spore.Client.Models.GorgonSpookyModel;
import com.Harbinger.Spore.Client.Models.gorgonModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Gorgon;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GorgonRenderer<Type extends Gorgon> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> def = this.getModel();
    private final EntityModel<Type> spooky;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/gorgon.png");
    private static final ResourceLocation TEXTURE_SPOOK = new ResourceLocation(Spore.MODID,
            "textures/entity/spooky_gorgon.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/gorgon.png");
    protected List<Vec3> entities = new ArrayList<>();
    private final List<SporeParticle> activeParticles = new ArrayList<>();
    private static final int MAX_PARTICLES = 15;
    private static final float PARTICLE_SPEED = 0.15f;
    private int particleTimer = 0;
    public GorgonRenderer(EntityRendererProvider.Context context) {
        super(context, new gorgonModel<>(context.bakeLayer(gorgonModel.LAYER_LOCATION)), 0.5f);
        spooky = new GorgonSpookyModel<>(context.bakeLayer(GorgonSpookyModel.LAYER_LOCATION));
        this.addLayer(new VolatileGlowingLayers<>(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.spooky() ? TEXTURE_SPOOK : TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }



    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        super.render(type, value1, value2, stack, bufferSource, light);
        model = type.spooky() ? spooky : def;
        Entity instance = type.level().getEntity(type.getTargetId());
        if (instance == null){
            return;
        }
        Vec3 vec3 = instance.getPosition(value2).add(0,instance.getEyeHeight(),0);

        Vec3 entityPos = type.getPosition(value2);
        applyIK(value2,type,vec3);
        spawnParticlesAlongChain(type);
        updateParticles(type);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            renderParticles(stack, bufferSource, entityPos);
        }
        stack.popPose();
    }
    static class VolatileGlowingLayers <T extends Gorgon,M extends EntityModel<T>> extends RenderLayer<T, M>{
        private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
                "textures/entity/gorgon_light.png");
        private static final ResourceLocation TEXTURE_SPOOKY = new ResourceLocation(Spore.MODID,
                "textures/entity/gorgon_light_spooky.png");
        public VolatileGlowingLayers(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!entity.isInvisible()){
                float alpha = 0.5F + 0.5F * Mth.sin(ageInTicks * 0.1F);
                VertexConsumer vertexConsumer = buffer.getBuffer(SporeRenderTypes.glowingTranslucent(entity.spooky() ? TEXTURE_SPOOKY : TEXTURE));
                getParentModel().renderToBuffer(matrixStack, vertexConsumer, packedLight, 15728640, 1.0F, 1.0F, 1.0F, alpha);
            }
        }
    }


    protected void moveSegmentTowards(int index, Vec3 target) {
        entities.set(index,target);
    }
    public void applyIK(float partial, Type t, Vec3 camera) {
        Vec3 vec3 = (new Vec3(0.1D, 1.8, 0.0D)).yRot(-t.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        Vec3 basePos = t.getPosition(partial).add(vec3);
        rebuildChain(basePos, camera);
        if (entities == null || entities.size() < 3) return;
        moveSegmentTowards(entities.size()-1, camera);
        for (int i = entities.size() - 2; i >= 0; i--) {
            Vec3 nextPos = entities.get(i + 1);
            Vec3 dir = entities.get(i).subtract(nextPos);

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = nextPos.add(dir);
            moveSegmentTowards(i, solvedPos);
        }
        entities.set(0,basePos);

        for (int i = 1; i < entities.size(); i++) {
            Vec3 prevPos = entities.get(i - 1);
            Vec3 dir = entities.get(i).subtract(prevPos);

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            moveSegmentTowards(i, solvedPos);
        }
    }
    private void rebuildChain(Vec3 start, Vec3 end){
        double distance = start.distanceTo(end);
        int desiredSegments = Mth.clamp((int)(distance * 1.1), 4, 40);
        if(entities.size() == desiredSegments && !entities.isEmpty()) {
            Vec3 oldStart = entities.get(0);
            Vec3 oldEnd = entities.get(entities.size()-1);
            if (oldStart.distanceToSqr(start) < 0.01 && oldEnd.distanceToSqr(end) < 0.01) {
                return;
            }
        }

        entities.clear();

        for(int i = 0; i < desiredSegments; i++){

            double t = (double)i/(desiredSegments-1);

            entities.add(new Vec3(
                    Mth.lerp(t,start.x,end.x),
                    Mth.lerp(t,start.y,end.y),
                    Mth.lerp(t,start.z,end.z)
            ));
        }
    }
    private void spawnParticlesAlongChain(Type entity) {
        if (entities.isEmpty() || entities.size() < 2) return;

        particleTimer++;
        if (particleTimer < 3) return;
        particleTimer = 0;

        ClientLevel level = (ClientLevel) entity.level();

        int particlesToSpawn = entity.getRandom().nextInt(2) + 1;

        for (int p = 0; p < particlesToSpawn && activeParticles.size() < MAX_PARTICLES; p++) {
            int segmentIndex = entity.getRandom().nextInt(entities.size() - 1);
            Vec3 start = entities.get(segmentIndex);
            Vec3 end = entities.get(segmentIndex + 1);

            float t = entity.getRandom().nextFloat();
            Vec3 position = start.lerp(end, t);

            Vec3 direction = entities.get(entities.size() - 1).subtract(position).normalize();

            direction = direction.add(
                    (entity.getRandom().nextDouble() - 0.5) * 0.2,
                    (entity.getRandom().nextDouble() - 0.5) * 0.2,
                    (entity.getRandom().nextDouble() - 0.5) * 0.2
            ).normalize();
            SporeParticle particle = new SporeParticle(
                    position,
                    direction.scale(PARTICLE_SPEED * (0.5f + entity.getRandom().nextFloat() * 0.5f)),
                    entities.size() - 1,
                    -1,
                    20 + entity.getRandom().nextInt(20)
            );
            activeParticles.add(particle);
            if (entity.getRandom().nextFloat() < 0.3f) {
                level.addParticle(
                        Sparticles.SPORE_PARTICLE.get(),
                        position.x, position.y, position.z,
                        direction.x * 0.1, direction.y * 0.1, direction.z * 0.1
                );
            }
        }
    }

    private void updateParticles(Type entity) {
        ClientLevel level = (ClientLevel) entity.level();
        Iterator<SporeParticle> iterator = activeParticles.iterator();

        while (iterator.hasNext()) {
            SporeParticle particle = iterator.next();
            particle.life--;

            if (particle.life <= 0) {
                if (particle.reachedEnd) {
                    createDispersalEffect(level, particle.position);
                }
                iterator.remove();
                continue;
            }

            Vec3 oldPos = particle.position;

            Vec3 newPos = oldPos.add(particle.velocity);
            particle.position = newPos;

            if (!particle.reachedEnd && entities.size() > particle.targetIndex) {
                Vec3 endPos = entities.get(particle.targetIndex);
                double distanceToEnd = newPos.distanceTo(endPos);

                if (distanceToEnd < 0.2 || particle.position.distanceTo(endPos) < particle.oldDistanceToEnd) {
                    particle.reachedEnd = true;
                    particle.life = Math.min(particle.life, 10); // Shorten life when dispersing

                    createDispersalEffect(level, newPos);
                }
                particle.oldDistanceToEnd = distanceToEnd;
            }

            if (entity.tickCount % 2 == 0) {
                level.addParticle(
                        Sparticles.SPORE_PARTICLE.get(),
                        newPos.x, newPos.y, newPos.z,
                        (entity.getRandom().nextDouble() - 0.5) * 0.05,
                        (entity.getRandom().nextDouble() - 0.5) * 0.05,
                        (entity.getRandom().nextDouble() - 0.5) * 0.05
                );
            }
        }
    }

    private void createDispersalEffect(ClientLevel level, Vec3 position) {
        Random random = new Random();
        // Create a burst of particles that fly outward
        for (int i = 0; i < 8; i++) {
            double angle = random.nextDouble() * Math.PI * 2;
            double pitch = random.nextDouble() * Math.PI;
            double speed = 0.1 + random.nextDouble() * 0.2;

            double vx = Math.sin(angle) * Math.cos(pitch) * speed;
            double vy = Math.sin(pitch) * speed;
            double vz = Math.cos(angle) * Math.cos(pitch) * speed;

            level.addParticle(
                    Sparticles.SPORE_PARTICLE.get(),
                    position.x, position.y, position.z,
                    vx, vy, vz
            );

            level.addParticle(
                    Sparticles.SPORE_PARTICLE.get(),
                    position.x, position.y, position.z,
                    vx * 0.5, vy * 0.5, vz * 0.5
            );
        }

        // Add a small cloud effect
        level.addParticle(
                Sparticles.SPORE_PARTICLE.get(),
                position.x, position.y, position.z,
                0, 0.05, 0
        );
    }

    private void renderParticles(PoseStack stack, MultiBufferSource buffer, Vec3 entityPos) {
        if (activeParticles.isEmpty()) return;

        stack.pushPose();
        for (SporeParticle particle : activeParticles) {
            Vec3 localPos = particle.position.subtract(entityPos);
            stack.pushPose();
            stack.translate(localPos.x, localPos.y, localPos.z);

            VertexConsumer consumer = buffer.getBuffer(RenderType.translucent());
            float size = 0.05f;
            float alpha = Math.min(1.0f, particle.life / 10.0f);

            int color = particle.color;
            int r = (color >> 16) & 0xFF;
            int g = (color >> 8) & 0xFF;
            int b = color & 0xFF;
            int packedColor = ((int)(alpha * 255) << 24) | (r << 16) | (g << 8) | b;

            Matrix4f pose = stack.last().pose();
            consumer.vertex(pose, -size, -size, 0)
                    .color(packedColor)
                    .uv(0, 0)
                    .uv2(0, 15728880)
                    .normal(1, 0, 0).endVertex();
            consumer.vertex(pose, size, -size, 0)
                    .color(packedColor)
                    .uv(1, 0)
                    .uv2(0, 15728880)
                    .normal(1, 0, 0).endVertex();
            consumer.vertex(pose, size, size, 0)
                    .color(packedColor)
                    .uv(1, 1)
                    .uv2(0, 15728880)
                    .normal(1, 0, 0).endVertex();
            consumer.vertex(pose, -size, size, 0)
                    .color(packedColor)
                    .uv(0, 1)
                    .uv2(0, 15728880)
                    .normal(1, 0, 0).endVertex();

            stack.popPose();
        }
        stack.popPose();
    }

    private static class SporeParticle {
        Vec3 position;
        Vec3 velocity;
        int targetIndex;
        int life;
        boolean reachedEnd;
        double oldDistanceToEnd;
        int color;

        SporeParticle(Vec3 position, Vec3 velocity, int targetIndex, int color, int life) {
            this.position = position;
            this.velocity = velocity;
            this.targetIndex = targetIndex;
            this.color = color;
            this.life = life;
            this.reachedEnd = false;
            this.oldDistanceToEnd = Double.MAX_VALUE;
        }
    }
}