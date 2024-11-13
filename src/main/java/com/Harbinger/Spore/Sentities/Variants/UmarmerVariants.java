package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum UmarmerVariants {
    DEFAULT(0,"default"),
    CHARRED(1,"spore.entity.variant.crispy"),
    BILE(2,"spore.entity.variant.bile"),
    CORROSIVE(3,"spore.entity.variant.corrosive");

    private static final UmarmerVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(UmarmerVariants::getId)).toArray(UmarmerVariants[]::new);
    private final int id;
    private final String name;
    UmarmerVariants(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId() {
        return this.id;
    }

    public static UmarmerVariants byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
