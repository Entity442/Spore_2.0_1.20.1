package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Models.CoreModel;
import com.Harbinger.Spore.Client.Models.ElytrumModel;
import com.Harbinger.Spore.Client.Models.WingedChestplate;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.antlr.v4.runtime.misc.Triple;

import java.util.ArrayList;
import java.util.List;
@OnlyIn(Dist.CLIENT)
public class ArmorModelList {

    public static List<Triple<EntityModel<LivingEntity>,Item, ResourceLocation>> modelItemMap(){
        List<Triple<EntityModel<LivingEntity>,Item, ResourceLocation>> map = new ArrayList<>();
        map.add(new Triple<>(new ElytrumModel<>(),Sitems.R_ELYTRON.get(),new ResourceLocation(Spore.MODID,"textures/armor/elytron.png")));
        map.add(new Triple<>(new CoreModel<>(),Sitems.LIVING_CHEST.get(),new ResourceLocation(Spore.MODID,"textures/armor/infected_wing.png")));
        map.add(new Triple<>(new CoreModel<>(),Sitems.INF_CHEST.get(),new ResourceLocation(Spore.MODID,"textures/armor/infected_wing.png")));
        map.add(new Triple<>(new WingedChestplate<>(),Sitems.INF_UP_CHESTPLATE.get(),new ResourceLocation(Spore.MODID,"textures/armor/infected_wing.png")));
        return map;
    }
}
