package com.Harbinger.Spore.Sentities.Variants;

import java.util.Arrays;
import java.util.Comparator;

public enum BairnSkins {
    ZOMBIE(0),
    VILLAGER(1),
    DROWNED(2),
    HUSK(3),
    ZOMBIE_VILLAGER(4);

    private static final BairnSkins[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(BairnSkins::getId)).toArray(BairnSkins[]::new);
    private final int id;

    BairnSkins(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    public static BairnSkins byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
