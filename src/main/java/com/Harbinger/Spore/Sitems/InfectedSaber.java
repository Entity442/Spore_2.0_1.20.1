package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;

public class InfectedSaber extends SporeSwordBase {
    public InfectedSaber() {
        super(SConfig.SERVER.saber_damage.get(), 1f, 2f, SConfig.SERVER.saber_durability.get());
    }
}
