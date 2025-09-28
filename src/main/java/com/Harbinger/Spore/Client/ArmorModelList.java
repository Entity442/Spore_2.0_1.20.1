package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.ArmorParts.*;
import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
public class ArmorModelList {
    private static final ResourceLocation psi_glow = new ResourceLocation("spore:textures/item/pci_gl.png");
    private static final ResourceLocation jaw_texture = new ResourceLocation("spore:textures/armor/ravenous_mouth.png");
    private static final ResourceLocation laced_thorns_texture = new ResourceLocation("spore:textures/armor/laced_thorns.png");
    private static final fleshArmorModel<LivingEntity> livingEntityfleshArmorModel = new fleshArmorModel<>();
    private static final platedArmorModel<LivingEntity> plated = new platedArmorModel<>();
    private static final GasMaskModel<LivingEntity> gasMaskModel = new GasMaskModel<>();
    private static final livingArmorModel<LivingEntity> livingArmorModel = new livingArmorModel<>();
    private static final livingArmorMkModel<LivingEntity> livingUpArmor = new livingArmorMkModel<>();
    private static final PCI_Model<LivingEntity> pci = new PCI_Model<>();
    private static final PCI_ModelL<LivingEntity> pciL = new PCI_ModelL<>();
    private static final RavenousJawModel<LivingEntity> jaw = new RavenousJawModel<>();
    private static final lacedThornsModel<LivingEntity> lacedThornsModel = new lacedThornsModel<>();
    private static final SyringeGunModel<LivingEntity> syringeGunModel = new SyringeGunModel<>();

    private static final PCIHandModelItem RIGHT_PCI = new PCIHandModelItem(InteractionHand.MAIN_HAND,pci,pci.PCIBODY,0.95f, -0.7f, -0.35f,1,-90,90,0,psi_glow);
    private static final PCIHandModelItem LEFT_PCI = new PCIHandModelItem(InteractionHand.OFF_HAND,pci,pci.PCIBODY,-1f, -0.7f, -0.35f,1,-90,90,0,psi_glow);
    private static final SyringeGunPart RIGHT_SYRINGE_GUN = new SyringeGunPart(InteractionHand.MAIN_HAND,syringeGunModel,syringeGunModel.syringeGun,0.95f, -0.2f, -1f,1f,0,90,90);
    private static final SyringeGunPart LEFT_SYRINGE_GUN = new SyringeGunPart(InteractionHand.OFF_HAND,syringeGunModel,syringeGunModel.syringeGun,-1f, -0.7f, -0.35f,1f,-90,90,0);

    public static final List<ComplexHandModelItem> ITEM_RENDERING_BITS = new ArrayList<>(){{
        add(RIGHT_PCI);
        add(LEFT_PCI);
        add(RIGHT_SYRINGE_GUN);
        add(LEFT_SYRINGE_GUN);
    }};


    private static final HelmetArmorPart LIVING_HELMET_PART = new HelmetArmorPart(Sitems.LIVING_HELMET.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.headwear,0f,0f,0,1f);
    public static final BodyArmorPart LIVING_CHEST_PART =  new BodyArmorPart(Sitems.LIVING_CHEST.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.body,0,0,0,1f);
    public static final RightArmArmorPart LIVING_RIGHT_ARM_PART = new RightArmArmorPart(Sitems.LIVING_CHEST.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.rightArm,0.3f,-0.125f,0,1f);
    public static final LeftArmArmorPart LIVING_LEFT_ARM_PART =  new LeftArmArmorPart(Sitems.LIVING_CHEST.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.leftArm,-0.3f,-0.125f,0,1f);
    public static final BodyArmorPart LIVING_PELVIS_PART = new BodyArmorPart(Sitems.LIVING_PANTS.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.pelvis,   0,0,0,1f);
    public static final RightLegArmorPart LIVING_RIGHT_LEG_PART = new RightLegArmorPart(Sitems.LIVING_PANTS.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.rightLeg,0.1f,-0.8f,0,1.01f);
    public static final LeftLegArmorPart LIVING_LEFT_LEG_PART = new LeftLegArmorPart(Sitems.LIVING_PANTS.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.leftLeg,-0.1f,-0.8f,0,1f);
    public static final RightBootArmorPart LIVING_RIGHT_BOOT_PART = new RightBootArmorPart(Sitems.LIVING_BOOTS.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.rightBoot,0.1f,-0.8f,0,1.01f);
    public static final LeftBootArmorPart LIVING_LEFT_BOOT_PART = new LeftBootArmorPart(Sitems.LIVING_BOOTS.get().asItem(),() ->livingEntityfleshArmorModel,() ->livingEntityfleshArmorModel.leftBoot,-0.1f,-0.8f,0,1f);

    private static final HelmetArmorPart PLATED_HELMET_PART = new HelmetArmorPart(Sitems.PLATED_HELMET.get().asItem(),() ->plated,() ->plated.headwear,0f,0f,0,1f);
    public static final BodyArmorPart PLATED_CHEST_PART =  new BodyArmorPart(Sitems.PLATED_CHEST.get().asItem(),() ->plated,() ->plated.body,0,0,0,1f);
    public static final RightArmArmorPart PLATED_RIGHT_ARM_PART = new RightArmArmorPart(Sitems.PLATED_CHEST.get().asItem(),() ->plated,() ->plated.rightArm,0.3f,-0.125f,0,1f);
    public static final LeftArmArmorPart PLATED_LEFT_ARM_PART =  new LeftArmArmorPart(Sitems.PLATED_CHEST.get().asItem(),() ->plated,() ->plated.leftArm,-0.3f,-0.125f,0,1f);
    public static final RightLegArmorPart PLATED_RIGHT_LEG_PART = new RightLegArmorPart(Sitems.PLATED_PANTS.get().asItem(),() ->plated,() ->plated.rightLeg,0.1f,-0.8f,0,1.01f);
    public static final LeftLegArmorPart PLATED_LEFT_LEG_PART = new LeftLegArmorPart(Sitems.PLATED_PANTS.get().asItem(),() ->plated,() ->plated.leftLeg,-0.1f,-0.8f,0,1f);
    public static final RightBootArmorPart PLATED_RIGHT_BOOT_PART = new RightBootArmorPart(Sitems.PLATED_BOOTS.get().asItem(),() ->plated,() ->plated.rightBoot,0.1f,-0.8f,0,1.01f);
    public static final LeftBootArmorPart PLATED_LEFT_BOOT_PART = new LeftBootArmorPart(Sitems.PLATED_BOOTS.get().asItem(),() ->plated,() ->plated.leftBoot,-0.1f,-0.8f,0,1f);

    private static final HelmetArmorPart INF_HELMET_PART = new HelmetArmorPart(Sitems.INF_HELMET.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.headwear,0f,0f,0,1f);
    public static final BodyArmorPart INF_CHEST_PART =  new BodyArmorPart(Sitems.INF_CHEST.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.body,0,0,0,1f);
    public static final RightArmArmorPart INF_RIGHT_ARM_PART = new RightArmArmorPart(Sitems.INF_CHEST.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.rightArm,0.3f,-0.125f,0,1f);
    public static final LeftArmArmorPart INF_LEFT_ARM_PART =  new LeftArmArmorPart(Sitems.INF_CHEST.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.leftArm,-0.3f,-0.125f,0,1f);
    public static final BodyArmorPart INF_PELVIS_PART = new BodyArmorPart(Sitems.INF_PANTS.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.pelvis,   0,0,0,1f);
    public static final RightLegArmorPart INF_RIGHT_LEG_PART = new RightLegArmorPart(Sitems.INF_PANTS.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.rightLeg,0.1f,-0.8f,0,1.01f);
    public static final LeftLegArmorPart INF_LEFT_LEG_PART = new LeftLegArmorPart(Sitems.INF_PANTS.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.leftLeg,-0.1f,-0.8f,0,1f);
    public static final RightBootArmorPart INF_RIGHT_BOOT_PART = new RightBootArmorPart(Sitems.INF_BOOTS.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.rightBoot,0.1f,-0.8f,0,1.01f);
    public static final LeftBootArmorPart INF_LEFT_BOOT_PART = new LeftBootArmorPart(Sitems.INF_BOOTS.get().asItem(),() ->livingArmorModel,() ->livingArmorModel.leftBoot,-0.1f,-0.8f,0,1f);

    private static final HelmetArmorPart INF_UP_HELMET_PART = new HelmetArmorPart(Sitems.INF_UP_HELMET.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.headwear,0f,0f,0,1f);
    public static final BodyArmorPart INF_UP_CHEST_PART =  new BodyArmorPart(Sitems.INF_UP_CHESTPLATE.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.body,0,0,0,1f);
    public static final RightArmArmorPart INF_UP_RIGHT_ARM_PART = new RightArmArmorPart(Sitems.INF_UP_CHESTPLATE.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.rightArm,0.3f,-0.125f,0,1f);
    public static final LeftArmArmorPart INF_UP_LEFT_ARM_PART =  new LeftArmArmorPart(Sitems.INF_UP_CHESTPLATE.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.leftArm,-0.3f,-0.125f,0,1f);
    public static final BodyArmorPart INF_UP_PELVIS_PART = new BodyArmorPart(Sitems.INF_UP_PANTS.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.pelvis,   0,0,0,1f);
    public static final RightLegArmorPart INF_UP_RIGHT_LEG_PART = new RightLegArmorPart(Sitems.INF_UP_PANTS.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.rightLeg,0.1f,-0.8f,0,1.01f);
    public static final LeftLegArmorPart INF_UP_LEFT_LEG_PART = new LeftLegArmorPart(Sitems.INF_UP_PANTS.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.leftLeg,-0.1f,-0.8f,0,1f);
    public static final RightBootArmorPart INF_UP_RIGHT_BOOT_PART = new RightBootArmorPart(Sitems.INF_UP_BOOTS.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.rightBoot,0.1f,-0.8f,0,1.01f);
    public static final LeftBootArmorPart INF_UP_LEFT_BOOT_PART = new LeftBootArmorPart(Sitems.INF_UP_BOOTS.get().asItem(),() ->livingUpArmor,() ->livingUpArmor.leftBoot,-0.1f,-0.8f,0,1f);


    private static final HelmetArmorPart GASMASK_PART = new HelmetArmorPart(Sitems.GAS_MASK.get().asItem(),() ->gasMaskModel,() ->gasMaskModel.GasMask,0f,0f,0,1f);
    private static final ElytrumPart ELYTRUM = new ElytrumPart(Sitems.R_ELYTRON.get().asItem(),0f,0f,-0.1f);

    private static final RightPCIArmorPart PCI_RIGHT = new RightPCIArmorPart(() -> pci,() -> pci.PCIBODY,psi_glow);
    private static final LeftPCIArmorPart PCI_LEFT = new LeftPCIArmorPart(() -> pciL,() -> pciL.PCIBODY,psi_glow);
    private static final SyringeGunArmorPartRight SYRINGE_GUN_RIGHT = new SyringeGunArmorPartRight(() -> syringeGunModel,() -> syringeGunModel.syringeGun,-0.15f, -0.35f, -0.05f, 1f);
    private static final SyringeGunArmorPartLeft SYRINGE_GUN_LEFT = new SyringeGunArmorPartLeft(() -> syringeGunModel,() -> syringeGunModel.syringeGun,0.15f, -0.35f, 0.05f, 1f);

    private static final List<Item> fleshBlackList = List.of(Sitems.LIVING_HELMET.get(),Sitems.LIVING_CHEST.get(),Sitems.LIVING_PANTS.get(),Sitems.LIVING_BOOTS.get());
    private static final HelmetArmorPartEnchant JAW_PART = new HelmetArmorPartEnchant(() ->jaw,() ->jaw.jaw,0f,0f,0,1f, Senchantments.VORACIOUS_MAW.get(),jaw_texture,List.of());
    private static final HelmetArmorPartEnchant THORNS_HELMET_PART = new HelmetArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.head,0f,0f,0,1f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);
    public static final RightArmArmorPartEnchant THORNS_RIGHT_ARM_PART = new RightArmArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.rightDarm,0.3f,-0.125f,0,1f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);
    public static final LeftArmArmorPartEnchant THORNS_LEFT_ARM_PART =  new LeftArmArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.leftDarm,-0.3f,-0.125f,0,1f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);
    public static final RightLegArmorPartEnchant THORNS_RIGHT_LEG_PART = new RightLegArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.rightDleg,0.1f,-0.8f,0,1.01f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);
    public static final LeftLegArmorPartEnchant THORNS_LEFT_LEG_PART = new LeftLegArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.leftDleg,-0.1f,-0.8f,0,1f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);
    public static final RightBootArmorPartEnchant THORNS_RIGHT_BOOT_PART = new RightBootArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.rightDboot,0.1f,-0.8f,0,1.01f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);
    public static final LeftBootArmorPartEnchant THORNS_LEFT_BOOT_PART = new LeftBootArmorPartEnchant(() ->lacedThornsModel,() ->lacedThornsModel.leftDboot,-0.1f,-0.8f,0,1f, Senchantments.SERRATED_THORNS.get(),laced_thorns_texture,fleshBlackList);

    public static final List<BaseArmorRenderingBit> ARMOR_RENDERING_BITS = new ArrayList<>(){{
        add(LIVING_HELMET_PART);
        add(LIVING_CHEST_PART);
        add(LIVING_RIGHT_ARM_PART);
        add(LIVING_LEFT_ARM_PART);
        add(LIVING_PELVIS_PART);
        add(LIVING_RIGHT_LEG_PART);
        add(LIVING_LEFT_LEG_PART);
        add(LIVING_RIGHT_BOOT_PART);
        add(LIVING_LEFT_BOOT_PART);

        add(PLATED_HELMET_PART);
        add(PLATED_CHEST_PART);
        add(PLATED_RIGHT_ARM_PART);
        add(PLATED_LEFT_ARM_PART);
        add(PLATED_RIGHT_LEG_PART);
        add(PLATED_LEFT_LEG_PART);
        add(PLATED_RIGHT_BOOT_PART);
        add(PLATED_LEFT_BOOT_PART);

        add(INF_HELMET_PART);
        add(INF_CHEST_PART);
        add(INF_RIGHT_ARM_PART);
        add(INF_LEFT_ARM_PART);
        add(INF_PELVIS_PART);
        add(INF_RIGHT_LEG_PART);
        add(INF_LEFT_LEG_PART);
        add(INF_RIGHT_BOOT_PART);
        add(INF_LEFT_BOOT_PART);

        add(INF_UP_HELMET_PART);
        add(INF_UP_CHEST_PART);
        add(INF_UP_RIGHT_ARM_PART);
        add(INF_UP_LEFT_ARM_PART);
        add(INF_UP_PELVIS_PART);
        add(INF_UP_RIGHT_LEG_PART);
        add(INF_UP_LEFT_LEG_PART);
        add(INF_UP_RIGHT_BOOT_PART);
        add(INF_UP_LEFT_BOOT_PART);

        add(ELYTRUM);
        add(GASMASK_PART);

        add(PCI_RIGHT);
        add(PCI_LEFT);
        add(SYRINGE_GUN_LEFT);
        add(SYRINGE_GUN_RIGHT);
    }};

    public static final List<EnchantingPart> ENCHANTING_RENDERING_BITS = new ArrayList<>(){{
        add(JAW_PART);
        add(THORNS_HELMET_PART);
        add(THORNS_RIGHT_ARM_PART);
        add(THORNS_LEFT_ARM_PART);
        add(THORNS_RIGHT_LEG_PART);
        add(THORNS_LEFT_LEG_PART);
        add(THORNS_RIGHT_BOOT_PART);
        add(THORNS_LEFT_BOOT_PART);
    }};
}