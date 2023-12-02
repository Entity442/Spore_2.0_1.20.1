package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SpitterVariants {
    DEFAULT(0),
    EXPLOSIVE(1);

    private static final SpitterVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SpitterVariants::getId)).toArray(SpitterVariants[]::new);
    private final int id;

    SpitterVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SpitterVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
