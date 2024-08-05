package com.Harbinger.Spore.Sentities;

import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import net.minecraft.world.damagesource.DamageSource;

import java.util.List;

public interface TrueCalamity {
    boolean hurt(CalamityMultipart calamityMultipart, DamageSource source, float value);
    int chemicalRange();
    List<? extends String> buffs();
    List<? extends String> debuffs();
}
