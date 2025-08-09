package com.Harbinger.Spore.Sentities;

import java.util.Arrays;
import java.util.Comparator;

public enum HitboxesForParts {
    SIEGER_BODY(0,3.5f,4.5f),
    SIEGER_JAW(1,1,1),
    SIEGER_RIGHT_LEG(2,1.5f,2),
    SIEGER_LEFT_LEG(3,1.5f,2),
    SIEGER_BACK_RIGHT_LEG(4,1.75f,1.75f),
    SIEGER_BACK_LEFT_LEG(5,1.75f,2),
    SIEGER_TAIL(6,3f,1);

    private final int ID;
    private final float width;
    private final float height;
    private static final HitboxesForParts[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(HitboxesForParts::getID)).toArray(HitboxesForParts[]::new);
    HitboxesForParts(int id, float width, float height) {
        ID = id;
        this.width = width;
        this.height = height;
    }

    public int getID() {
        return ID;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
    public static HitboxesForParts byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
