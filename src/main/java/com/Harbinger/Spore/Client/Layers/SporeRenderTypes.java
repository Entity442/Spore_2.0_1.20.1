package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.ArmorModelList;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class SporeRenderTypes extends RenderType {
    public SporeRenderTypes(String p_173178_, VertexFormat p_173179_, VertexFormat.Mode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
        super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
    }

    public static RenderType glowingTranslucent(ResourceLocation texture) {
        return RenderType.create(
                "glowing_translucent",
                DefaultVertexFormat.NEW_ENTITY,
                VertexFormat.Mode.QUADS,
                512, // Increased buffer size
                true,
                false, // Try disabling sorting
                RenderType.CompositeState.builder()
                        .setShaderState(RenderType.RENDERTYPE_EYES_SHADER) // Better translucent glow shader
                        .setTextureState(new RenderType.TextureStateShard(texture, true, false)) // Enable mipmapping
                        .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY) // Makes glow effects stand out
                        .setCullState(RenderType.NO_CULL) // Renders both sides
                        .setOverlayState(RenderType.NO_OVERLAY)
                        .setLightmapState(RenderType.LIGHTMAP)
                        .createCompositeState(true)
        );
    }
    public static RenderType energySwirlStatic(ResourceLocation texture, float val1, float val2) {
        return create("energy_swirl_static", DefaultVertexFormat.NEW_ENTITY,
                VertexFormat.Mode.QUADS, 256, false, true,
                RenderType.CompositeState.builder()
                        .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER) // Uses built-in swirl shader
                        .setTextureState(new RenderStateShard.TextureStateShard(texture, false, false))
                        .setTexturingState(new RenderStateShard.OffsetTexturingStateShard(val1, val2))
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setOverlayState(RenderType.NO_OVERLAY)
                        .setLightmapState(LIGHTMAP)
                        .setWriteMaskState(COLOR_WRITE)
                        .createCompositeState(false));
    }
}
