package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum ScamperVariants {
    DEFAULT(0),
    VILLAGER(1),
    DROWNED(2);

    private static final ScamperVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ScamperVariants::getId)).toArray(ScamperVariants[]::new);
    private final int id;
    ScamperVariants(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public static ScamperVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
