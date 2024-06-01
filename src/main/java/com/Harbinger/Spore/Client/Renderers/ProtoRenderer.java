package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.ProtoMembraneLayer;
import com.Harbinger.Spore.Client.Models.ProtoHivemindModel;
import com.Harbinger.Spore.Client.Models.ProtoRedesign;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ProtoRenderer extends OrganoidMobRenderer<Proto , EntityModel<Proto>> {
    private final EntityModel<Proto> normalProto = this.getModel();
    private final EntityModel<Proto> nunny;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/proto_remade.png");
    private static final ResourceLocation OLD_PROTO = new ResourceLocation(Spore.MODID,
            "textures/entity/proto.png");

    public ProtoRenderer(EntityRendererProvider.Context context) {
        super(context, new ProtoRedesign<>(context.bakeLayer(ProtoRedesign.LAYER_LOCATION)), 3f);
        nunny = new ProtoHivemindModel<>(context.bakeLayer(ProtoHivemindModel.LAYER_LOCATION));
        this.addLayer(new ProtoMembraneLayer(this));
    }

    @Override
    public void render(Proto type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        this.model = type.isNunny() ? nunny : normalProto;
        super.render(type, value1, value2, stack, bufferSource, value3);
    }

    @Override
    public ResourceLocation getTextureLocation(Proto proto) {
        return proto.isNunny() ? OLD_PROTO : TEXTURE;
    }

}
