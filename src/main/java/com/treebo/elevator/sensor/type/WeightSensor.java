package com.treebo.elevator.sensor.type;

import com.treebo.elevator.sensor.Sensor;

/**
 *
 * @author ranjeet
 */
public class WeightSensor implements Sensor<Integer> {

    private int currentWeight;

    public WeightSensor() {
    }

    @Override
    public Integer get() {
        return currentWeight;
    }

    @Override
    public String toString() {
        return "WeightSensor{" + "currentWeight=" + currentWeight + '}';
    }

    @Override
    public void set(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

}
