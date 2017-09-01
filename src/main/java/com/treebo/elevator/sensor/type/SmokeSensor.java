package com.treebo.elevator.sensor.type;

import com.treebo.elevator.sensor.Sensor;

/**
 *
 * @author ranjeet
 */
public class SmokeSensor implements Sensor<Boolean> {

    private boolean smoke;

    public SmokeSensor() {
    }

    @Override
    public String toString() {
        return "SmokeSensor{" + "smoke=" + smoke + '}';
    }

    @Override
    public Boolean get() {
        return smoke;
    }

    @Override
    public void set(Boolean smoke) {
        this.smoke = smoke;
    }


}
