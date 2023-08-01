package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum BusserVariants {
    DEFAULT(0),
    ENHANCED(1);

    private static final BusserVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BusserVariants::getId)).toArray(BusserVariants[]::new);
    private final int id;

    BusserVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static BusserVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
