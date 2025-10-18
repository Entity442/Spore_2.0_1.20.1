package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Models.TentacledModel;
import com.Harbinger.Spore.Sentities.Organoids.Tentacle;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SegmentBase<T extends Tentacle> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "segmentbase"), "main");
	private final ModelPart Biomass;
	private final ModelPart Root1;
	private final ModelPart Root1Details;
	private final ModelPart Root1Detail1;
	private final ModelPart Root1Detail2;
	private final ModelPart Root1SmallDetails;
	private final ModelPart Root2;
	private final ModelPart Root1Details2;
	private final ModelPart Root1Detail3;
	private final ModelPart Root1Detail4;
	private final ModelPart Root3;
	private final ModelPart Root1Details3;
	private final ModelPart Root1Detail5;
	private final ModelPart Root1Detail6;

	public SegmentBase() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Biomass = root.getChild("Biomass");
		this.Root1 = root.getChild("Root1");
		this.Root1Details = this.Root1.getChild("Root1Details");
		this.Root1Detail1 = this.Root1Details.getChild("Root1Detail1");
		this.Root1Detail2 = this.Root1Details.getChild("Root1Detail2");
		this.Root1SmallDetails = this.Root1Details.getChild("Root1SmallDetails");
		this.Root2 = root.getChild("Root2");
		this.Root1Details2 = this.Root2.getChild("Root1Details2");
		this.Root1Detail3 = this.Root1Details2.getChild("Root1Detail3");
		this.Root1Detail4 = this.Root1Details2.getChild("Root1Detail4");
		this.Root3 = root.getChild("Root3");
		this.Root1Details3 = this.Root3.getChild("Root1Details3");
		this.Root1Detail5 = this.Root1Details3.getChild("Root1Detail5");
		this.Root1Detail6 = this.Root1Details3.getChild("Root1Detail6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Biomass = partdefinition.addOrReplaceChild("Biomass", CubeListBuilder.create(), PartPose.offset(-1.4597F, 20.9866F, -0.332F));

		PartDefinition Biomass4_r1 = Biomass.addOrReplaceChild("Biomass4_r1", CubeListBuilder.create().texOffs(12, 4).addBox(-3.5F, -1.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.323F, 1.8005F, 1.2635F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition Biomass3_r1 = Biomass.addOrReplaceChild("Biomass3_r1", CubeListBuilder.create().texOffs(2, 2).addBox(-4.5F, -2.5F, -2.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5599F, -1.0913F, -2.9138F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Biomass2_r1 = Biomass.addOrReplaceChild("Biomass2_r1", CubeListBuilder.create().texOffs(3, 3).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7154F, -0.1518F, -3.6794F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Biomass1_r1 = Biomass.addOrReplaceChild("Biomass1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -3.5F, -3.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.814F, -0.2803F, 2.359F, -0.1801F, 0.3913F, -0.0164F));

		PartDefinition Root1 = partdefinition.addOrReplaceChild("Root1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1574F, 20.7406F, -0.4313F, 0.0F, 0.6109F, -0.5672F));

		PartDefinition Root1seg3_r1 = Root1.addOrReplaceChild("Root1seg3_r1", CubeListBuilder.create().texOffs(46, 0).addBox(15.9957F, 1.5408F, -0.0365F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.493F, -0.639F, 0.7333F));

		PartDefinition Root1seg2_r1 = Root1.addOrReplaceChild("Root1seg2_r1", CubeListBuilder.create().texOffs(44, 0).addBox(9.7816F, -6.4135F, -0.0365F, 7.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.7137F, -0.3614F, 1.1832F));

		PartDefinition Root1seg1_r1 = Root1.addOrReplaceChild("Root1seg1_r1", CubeListBuilder.create().texOffs(48, 0).addBox(6.6479F, 0.3371F, -0.1433F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition Root1Details = Root1.addOrReplaceChild("Root1Details", CubeListBuilder.create(), PartPose.offset(-3.6574F, 7.2594F, -5.3187F));

		PartDefinition Root1Detail1 = Root1Details.addOrReplaceChild("Root1Detail1", CubeListBuilder.create(), PartPose.offset(6.8191F, -6.0F, 6.4264F));

		PartDefinition Root1Detail1Seg4_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg4_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-0.1242F, 14.9328F, -0.4826F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 1.9044F, 1.098F, 1.2567F));

		PartDefinition Root1Detail1Seg3_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg3_r1", CubeListBuilder.create().texOffs(52, 0).addBox(11.8541F, 9.4517F, 5.7334F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.5059F, 0.367F, 0.5088F));

		PartDefinition Root1Detail1Seg2_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg2_r1", CubeListBuilder.create().texOffs(52, 0).addBox(10.105F, 2.901F, 9.991F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.4923F, 0.3776F, 0.9686F));

		PartDefinition Root1Detail1Seg1_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg1_r1", CubeListBuilder.create().texOffs(52, 0).addBox(5.4867F, 5.8562F, 9.9498F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.3598F, 0.5049F, 0.661F));

		PartDefinition Root1Detail2 = Root1Details.addOrReplaceChild("Root1Detail2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.25F, -0.5F));

		PartDefinition Root2Detail2Seg2_r1 = Root1Detail2.addOrReplaceChild("Root2Detail2Seg2_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-12.1372F, 9.1703F, 5.2504F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.206F, 0.4076F, -0.9762F));

		PartDefinition Root1Detail2Seg1_r1 = Root1Detail2.addOrReplaceChild("Root1Detail2Seg1_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-11.1641F, 9.1703F, 1.4283F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.27F, 0.7897F, -0.8648F));

		PartDefinition Root1SmallDetails = Root1Details.addOrReplaceChild("Root1SmallDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Root1DetailSmall2_r1 = Root1SmallDetails.addOrReplaceChild("Root1DetailSmall2_r1", CubeListBuilder.create().texOffs(52, 0).addBox(4.0438F, 7.0416F, -0.2856F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.9366F, -11.3752F, 0.5786F, 1.7F, 0.3469F, 0.9995F));

		PartDefinition Root1DetailSmall1_r1 = Root1SmallDetails.addOrReplaceChild("Root1DetailSmall1_r1", CubeListBuilder.create().texOffs(56, 0).addBox(13.2594F, 1.9374F, -4.6722F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.9366F, -11.3752F, 0.5786F, 1.5395F, -0.5514F, 0.4852F));

		PartDefinition Root2 = partdefinition.addOrReplaceChild("Root2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1574F, 20.4906F, -0.4313F, 2.9357F, -0.7128F, -2.5116F));

		PartDefinition Root1seg3_r2 = Root2.addOrReplaceChild("Root1seg3_r2", CubeListBuilder.create().texOffs(46, 0).addBox(15.9957F, 1.5408F, -0.0365F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.493F, -0.639F, 0.7333F));

		PartDefinition Root1seg2_r2 = Root2.addOrReplaceChild("Root1seg2_r2", CubeListBuilder.create().texOffs(44, 0).addBox(9.7816F, -6.4135F, -0.0365F, 7.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.7137F, -0.3614F, 1.1832F));

		PartDefinition Root1seg1_r2 = Root2.addOrReplaceChild("Root1seg1_r2", CubeListBuilder.create().texOffs(48, 0).addBox(6.6479F, 0.3371F, -0.1433F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition Root1Details2 = Root2.addOrReplaceChild("Root1Details2", CubeListBuilder.create(), PartPose.offset(-3.6574F, 7.2594F, -5.3187F));

		PartDefinition Root1Detail3 = Root1Details2.addOrReplaceChild("Root1Detail3", CubeListBuilder.create(), PartPose.offset(8.8192F, -3.0F, 8.4264F));

		PartDefinition Root1Detail1Seg4_r2 = Root1Detail3.addOrReplaceChild("Root1Detail1Seg4_r2", CubeListBuilder.create().texOffs(52, 0).addBox(-0.1242F, 14.9328F, -0.4826F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 1.9044F, 1.098F, 1.2567F));

		PartDefinition Root1Detail1Seg3_r2 = Root1Detail3.addOrReplaceChild("Root1Detail1Seg3_r2", CubeListBuilder.create().texOffs(52, 0).addBox(11.8541F, 9.4517F, 5.7334F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.5059F, 0.367F, 0.5088F));

		PartDefinition Root1Detail1Seg2_r2 = Root1Detail3.addOrReplaceChild("Root1Detail1Seg2_r2", CubeListBuilder.create().texOffs(52, 0).addBox(10.105F, 2.901F, 9.991F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.4923F, 0.3776F, 0.9686F));

		PartDefinition Root1Detail1Seg1_r2 = Root1Detail3.addOrReplaceChild("Root1Detail1Seg1_r2", CubeListBuilder.create().texOffs(52, 0).addBox(5.4867F, 5.8562F, 9.9498F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.3598F, 0.5049F, 0.661F));

		PartDefinition Root1Detail4 = Root1Details2.addOrReplaceChild("Root1Detail4", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.75F, -0.5F));

		PartDefinition Root2Detail2Seg2_r2 = Root1Detail4.addOrReplaceChild("Root2Detail2Seg2_r2", CubeListBuilder.create().texOffs(52, 0).addBox(-12.1372F, 9.1703F, 5.2504F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.206F, 0.4076F, -0.9762F));

		PartDefinition Root1Detail2Seg1_r2 = Root1Detail4.addOrReplaceChild("Root1Detail2Seg1_r2", CubeListBuilder.create().texOffs(52, 0).addBox(-11.1641F, 9.1703F, 1.4283F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.27F, 0.7897F, -0.8648F));

		PartDefinition Root3 = partdefinition.addOrReplaceChild("Root3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1574F, 20.7406F, -0.4313F, 0.5236F, 2.7925F, 0.4363F));

		PartDefinition Root1seg3_r3 = Root3.addOrReplaceChild("Root1seg3_r3", CubeListBuilder.create().texOffs(46, 0).addBox(15.9957F, 1.5408F, -0.0365F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.493F, -0.639F, 0.7333F));

		PartDefinition Root1seg2_r3 = Root3.addOrReplaceChild("Root1seg2_r3", CubeListBuilder.create().texOffs(44, 0).addBox(9.7816F, -6.4135F, -0.0365F, 7.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.7137F, -0.3614F, 1.1832F));

		PartDefinition Root1seg1_r3 = Root3.addOrReplaceChild("Root1seg1_r3", CubeListBuilder.create().texOffs(48, 0).addBox(6.6479F, 0.3371F, -0.1433F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition Root1Details3 = Root3.addOrReplaceChild("Root1Details3", CubeListBuilder.create(), PartPose.offset(-3.6574F, 7.2594F, -5.3187F));

		PartDefinition Root1Detail5 = Root1Details3.addOrReplaceChild("Root1Detail5", CubeListBuilder.create(), PartPose.offsetAndRotation(11.8192F, 2.0F, 13.4264F, -0.4363F, -1.2654F, -0.2182F));

		PartDefinition Root1Detail1Seg3_r3 = Root1Detail5.addOrReplaceChild("Root1Detail1Seg3_r3", CubeListBuilder.create().texOffs(52, 0).addBox(11.8541F, 9.4517F, 5.7334F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.5059F, 0.367F, 0.5088F));

		PartDefinition Root1Detail1Seg2_r3 = Root1Detail5.addOrReplaceChild("Root1Detail1Seg2_r3", CubeListBuilder.create().texOffs(52, 0).addBox(10.105F, 2.901F, 9.991F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.4923F, 0.3776F, 0.9686F));

		PartDefinition Root1Detail1Seg1_r3 = Root1Detail5.addOrReplaceChild("Root1Detail1Seg1_r3", CubeListBuilder.create().texOffs(52, 0).addBox(5.4867F, 5.8562F, 9.9498F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.3598F, 0.5049F, 0.661F));

		PartDefinition Root1Detail6 = Root1Details3.addOrReplaceChild("Root1Detail6", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.75F, -0.5F));

		PartDefinition Root2Detail2Seg2_r3 = Root1Detail6.addOrReplaceChild("Root2Detail2Seg2_r3", CubeListBuilder.create().texOffs(52, 0).addBox(-12.1372F, 9.1703F, 5.2504F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.206F, 0.4076F, -0.9762F));

		PartDefinition Root1Detail2Seg1_r3 = Root1Detail6.addOrReplaceChild("Root1Detail2Seg1_r3", CubeListBuilder.create().texOffs(52, 0).addBox(-11.1641F, 9.1703F, 1.4283F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.27F, 0.7897F, -0.8648F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Biomass, Mth.sin(ageInTicks/6)/7);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Biomass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Root3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}