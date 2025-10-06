package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum InfVillagerSkins {
    DEFAULT(0),
    DESERT(1),
    JUNGLE(2),
    SAVANNA(3),
    SWAMP(4),
    TAIGA(5),
    TUNDRA(6);

    private static final InfVillagerSkins[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(InfVillagerSkins::getId)).toArray(InfVillagerSkins[]::new);
    private final int id;

    InfVillagerSkins(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public static InfVillagerSkins byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
