package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum NaiadVariants {
    DEFAULT(0,"default"),
    TRITON(1,"spore.entity.variant.triton");

    private static final NaiadVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(NaiadVariants::getId)).toArray(NaiadVariants[]::new);
    private final int id;
    private final String name;

    NaiadVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName(){
        return name;
    }
    public static NaiadVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
