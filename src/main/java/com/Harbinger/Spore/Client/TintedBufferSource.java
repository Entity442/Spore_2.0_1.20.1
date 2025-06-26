package com.Harbinger.Spore.Client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TintedBufferSource implements MultiBufferSource {
    private final MultiBufferSource original;
    private final float r, g, b, a;

    public TintedBufferSource(MultiBufferSource original, float r, float g, float b, float a) {
        this.original = original;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    @Override
    public VertexConsumer getBuffer(RenderType renderType) {
        VertexConsumer base = original.getBuffer(renderType);
        return new TintedVertexConsumer(base, r, g, b, a);
    }
    public static class TintedVertexConsumer implements VertexConsumer {
        private final VertexConsumer base;
        private final float r, g, b, a;

        public TintedVertexConsumer(VertexConsumer base, float r, float g, float b, float a) {
            this.base = base;
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }

        @Override
        public VertexConsumer vertex(double x, double y, double z) {
            return base.vertex(x, y, z);
        }

        @Override
        public VertexConsumer color(int red, int green, int blue, int alpha) {
            return base.color((int)(red * r), (int)(green * g), (int)(blue * b), (int)(alpha * a));
        }

        @Override
        public VertexConsumer uv(float u, float v) {
            return base.uv(u, v);
        }

        @Override
        public VertexConsumer overlayCoords(int u, int v) {
            return base.overlayCoords(u, v);
        }

        @Override
        public VertexConsumer uv2(int u, int v) {
            return base.uv2(u, v);
        }

        @Override
        public VertexConsumer normal(float x, float y, float z) {
            return base.normal(x, y, z);
        }

        @Override
        public void endVertex() {
            base.endVertex();
        }

        @Override
        public void defaultColor(int red, int green, int blue, int alpha) {
            base.defaultColor((int)(red * r), (int)(green * g), (int)(blue * b), (int)(alpha * a));
        }

        @Override
        public void unsetDefaultColor() {
            base.unsetDefaultColor();
        }
    }
}