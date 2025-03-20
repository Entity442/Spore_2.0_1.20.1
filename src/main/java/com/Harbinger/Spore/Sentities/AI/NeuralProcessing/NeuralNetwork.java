package com.Harbinger.Spore.Sentities.AI.NeuralProcessing;

import net.minecraft.util.RandomSource;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NeuralNetwork {
    private int INPUTS = 4;
    private int PROCESSING = 2;
    private final double[][] weightsInputHidden = new double[INPUTS][PROCESSING];
    private final double[] weightsProcessingOutput = new double[PROCESSING];
    private final HashMap<String, Double[]> cache = new HashMap<>();
    private final HashMap<String, Double> damageEffectiveness = new HashMap<>();
    private final RandomSource random = RandomSource.create();
    public NeuralNetwork() {
        initializeWeights();
    }
    public NeuralNetwork(int inputs, int processing) {
        initializeWeights();
        INPUTS = inputs;
        PROCESSING = processing;
    }
    public Map<String, Double> getDamageEffectivenessMap() {
        return damageEffectiveness;
    }
    public int getINPUTS() {
        return INPUTS;
    }
    public int getPROCESSING() {
        return PROCESSING;
    }
    public void setInputs(int inputs) {
        INPUTS = inputs;
        initializeWeights();
    }

    public void setHidden(int hidden) {
        PROCESSING = hidden;
        initializeWeights();
    }
    public double[][] getWeightsInputHidden() {
        return weightsInputHidden;
    }

    public double[] getWeightsHiddenOutput() {
        return weightsProcessingOutput;
    }
    public void setWeightInputHidden(int i, int j, double value) {
        if (i >= 0 && i < INPUTS && j >= 0 && j < PROCESSING) {
            weightsInputHidden[i][j] = value;
        }
    }
    public void registerDamageEffectiveness(String damageType, double damageDealt) {
        if (damageDealt <= 0) return;
        damageEffectiveness.merge(damageType, damageDealt, Double::sum);
        if (damageEffectiveness.size() > 10) {
            cleanupDamageEntries();
        }
    }

    public double getDamageEffectiveness(String damageType) {
        return damageEffectiveness.getOrDefault(damageType, 0.0);
    }
    public String getMostEffectiveDamageType() {
        return damageEffectiveness.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("unknown");
    }

    public void setWeightsProcessingOutput(int i, double value) {
        if (i >= 0 && i < PROCESSING) {
            weightsProcessingOutput[i] = value;
        }
    }

    private void initializeWeights() {
        for (int i = 0; i < INPUTS; i++) {
            for (int j = 0; j < PROCESSING; j++) {
                weightsInputHidden[i][j] = random.nextDouble() * 2 - 1;
            }
        }
        for (int i = 0; i < PROCESSING; i++) {
            weightsProcessingOutput[i] = random.nextDouble() * 2 - 1;
        }
    }
    private void cleanupDamageEntries() {
        Map<String, Double> mergedMap = new HashMap<>();

        for (Map.Entry<String, Double> entry : damageEffectiveness.entrySet()) {
            String type = entry.getKey();
            double value = entry.getValue();

            String bestMatch = mergedMap.keySet().stream()
                    .filter(existingType -> areDamageTypesSimilar(existingType, type))
                    .findFirst()
                    .orElse(type);
            mergedMap.merge(bestMatch, value, Double::sum);
        }

        double maxDamage = mergedMap.values().stream().max(Double::compare).orElse(1.0);
        mergedMap.entrySet().removeIf(entry -> entry.getValue() < maxDamage * 0.05); // Remove weak ones

        damageEffectiveness.clear();
        damageEffectiveness.putAll(mergedMap);
    }
    private boolean areDamageTypesSimilar(String type1, String type2) {
        return type1.contains(type2) || type2.contains(type1) || type1.equalsIgnoreCase(type2);
    }
    public double computeOutput(double[] inputs, String entityID) {
        if (cache.containsKey(entityID)) {
            Double[] cachedValues = cache.get(entityID);
            return cachedValues[cachedValues.length - 1];
        }

        double[] hiddenLayer = new double[PROCESSING];
        for (int i = 0; i < PROCESSING; i++) {
            hiddenLayer[i] = 0;
            for (int j = 0; j < INPUTS; j++) {
                hiddenLayer[i] += inputs[j] * weightsInputHidden[j][i];
            }
            hiddenLayer[i] += random.nextDouble() * 0.1;
            hiddenLayer[i] = Math.tanh(hiddenLayer[i]);
        }

        double output = 0;
        for (int i = 0; i < PROCESSING; i++) {
            output += hiddenLayer[i] * weightsProcessingOutput[i];
        }
        output = Math.tanh(output);
        cache.put(entityID, new Double[]{hiddenLayer[0], hiddenLayer[1], output});
        return output;
    }
}