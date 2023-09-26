package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SlasherVariants {
    DEFAULT(0),
    PIERCER(1);

    private static final SlasherVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SlasherVariants::getId)).toArray(SlasherVariants[]::new);
    private final int id;

    SlasherVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SlasherVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
