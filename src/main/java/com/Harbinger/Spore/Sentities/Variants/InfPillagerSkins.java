package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum InfPillagerSkins {
    DEFAULT(0),
    CAPTAIN(1);

    private static final InfPillagerSkins[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(InfPillagerSkins::getId)).toArray(InfPillagerSkins[]::new);
    private final int id;

    InfPillagerSkins(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public static InfPillagerSkins byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
