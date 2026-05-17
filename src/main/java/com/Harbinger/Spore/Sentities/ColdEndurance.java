package com.Harbinger.Spore.Sentities;

public enum ColdEndurance {
    INFECTED(0,0.1),
    EVOLVED(1,0.075),
    HYPER(2,0.05),
    ABNORMALS(3,0.05),
    CALAMITY(4,0.025);


    private final int level;
    private final double healthModifier;

    ColdEndurance(int level, double healthModifier) {
        this.level = level;
        this.healthModifier = healthModifier;
    }
    public int getLevel(){return level;}
    public double getHealthModifier(){return healthModifier;}
}
