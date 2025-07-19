package com.Harbinger.Spore.Client;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
@OnlyIn(Dist.CLIENT)
public interface CorpseHandelingModel {
    List<List<ModelPart>> getCorpseParts();
    void initializePartLists();
}
