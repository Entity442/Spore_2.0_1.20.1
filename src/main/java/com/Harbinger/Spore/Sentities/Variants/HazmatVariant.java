package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum HazmatVariant {
    DEFAULT(0),
    TANK(1),
    COAT(2);


    private static final HazmatVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(HazmatVariant::getId)).toArray(HazmatVariant[]::new);
    private final int id;

    HazmatVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static HazmatVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
