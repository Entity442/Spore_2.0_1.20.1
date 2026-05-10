package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum GargoyleVariants {
    DEFAULT(0,"default"),
    BLOOMING(1,"spore.entity.variant.blooming"),
    VALKYRIE(2,"spore.entity.variant.valkyrie"),
    BOMBER(3,"spore.entity.variant.madcap"),
    ICHOR(4,"spore.entity.variant.ichor");

    private static final GargoyleVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(GargoyleVariants::getId)).toArray(GargoyleVariants[]::new);
    private final int id;
    private final String name;

    GargoyleVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static GargoyleVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
