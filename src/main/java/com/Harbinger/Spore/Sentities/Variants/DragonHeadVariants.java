package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum DragonHeadVariants {
    TAR(0),
    ELECTRIC(1),
    SONIC(2);

    private static final DragonHeadVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DragonHeadVariants::getId)).toArray(DragonHeadVariants[]::new);
    private final int id;

    DragonHeadVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public static DragonHeadVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
