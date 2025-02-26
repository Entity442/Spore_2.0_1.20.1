package com.Harbinger.Spore.Client.Layers;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class SporeRenderTypes extends RenderType {
    public SporeRenderTypes(String p_173178_, VertexFormat p_173179_, VertexFormat.Mode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
        super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
    }

    public static RenderType glowingTranslucent(ResourceLocation texture) {
        return RenderType.create(
                "glowing_translucent", // Custom name
                DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP, // Vertex format with lightmap
                VertexFormat.Mode.QUADS, // Render mode (quads)
                256, // Buffer size
                true, // Affects transparency
                true, // Needs sorting
                RenderType.CompositeState.builder()
                        .setShaderState(RenderType.RENDERTYPE_EYES_SHADER) // Use emissive translucent shader
                        .setTextureState(new RenderType.TextureStateShard(texture, false, false)) // Custom texture
                        .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY) // Enable translucency
                        .setCullState(RenderType.NO_CULL) // Disable face culling (renders both sides)
                        .setOverlayState(RenderType.NO_OVERLAY)
                        .createCompositeState(true) // Composite state for the render type
        );
    }
}
