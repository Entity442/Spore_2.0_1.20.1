package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum DelusionerVariants {
    DEFAULT(0,"default"),
    MAGE(1,"spore.entity.variant.mage");

    private static final DelusionerVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DelusionerVariants::getId)).toArray(DelusionerVariants[]::new);
    private final int id;
    private final String name;

    DelusionerVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static DelusionerVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
