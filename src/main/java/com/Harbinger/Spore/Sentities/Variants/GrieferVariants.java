package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum GrieferVariants {
    DEFAULT(0),
    TOXIC(1),
    RADIOACTIVE(2);


    private static final GrieferVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(GrieferVariants::getId)).toArray(GrieferVariants[]::new);
    private final int id;

    GrieferVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static GrieferVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
