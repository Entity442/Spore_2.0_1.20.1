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
    SIEGER_TAIL(6,3f,1),
    GAZEN_TAIL(7,2,2),
    GAZEN_HEAD(8,2,2),
    GAZEN_RIGHT_LEG(9,1.75f,1),
    GAZEN_LEFT_LEG(10,1.75f,1),
    LICKER(11,1,1),
    HINDEN_FRONT(12,3.5f,3.5f),
    HINDEN_BACK(13,3.5f,3.5f),
    MAW(14,3,1.5f),
    RIGHT_CANNON(15,1.5f,1),
    LEFT_CANNON(16,1.5f,1),
    HOWI_CANNON1(17,2f,3f),
    HOWI_CANNON2(18,2f,3f),
    HOWI_CANNON3(19,2f,3f),
    HOWI_LEFT_LEG(20,1.5f,1.5f),
    HOWI_RIGHT_LEG(21,2f,1f),
    HOWI_LEFT_ARM(22,3,2),
    HOWI_RIGHT_ARM(23,3,2),
    HOWI_SACK(24,2,1),
    HOHL_JAW(25,3,3),
    HOHL_HEAD(26,3,3),
    HOHL_SEG1(27,3,3),
    HOHL_SEG2(28,3,3),
    HOHL_SEG3(29,3,3),
    HOHL_TAIL(30,3,3);

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
