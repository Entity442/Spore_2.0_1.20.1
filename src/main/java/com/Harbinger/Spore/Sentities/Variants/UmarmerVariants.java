package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum UmarmerVariants {
    DEFAULT(0),
    CHARRED(1),
    BILE(2),
    CORROSIVE(3);

    private static final UmarmerVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(UmarmerVariants::getId)).toArray(UmarmerVariants[]::new);
    private final int id;

    UmarmerVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static UmarmerVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
