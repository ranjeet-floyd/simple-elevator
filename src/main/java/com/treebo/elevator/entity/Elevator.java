package com.treebo.elevator.entity;

import com.treebo.elevator.bean.RequestBean;
import com.treebo.elevator.constant.STATE;
import com.treebo.elevator.sensor.Sensor;
import com.treebo.elevator.sensor.type.SmokeSensor;
import com.treebo.elevator.sensor.type.WeightSensor;

/**
 *
 * @author ranjeet
 */
public class Elevator {

    private static int MAX_WEIGHT = 100; //kg
    private int currentFloor;
    private STATE currentState;
    private Sensor<Integer> weightSensor;
    private Sensor<Boolean> SmokeSensor;

    public Elevator(int currentFloor, STATE currentState, Sensor<Integer> weightSensor, Sensor<Boolean> smokeSensor) {
        this.currentState = currentState;
        this.currentFloor = currentFloor;
        this.weightSensor = weightSensor;
        this.SmokeSensor = smokeSensor;
    }

    public Elevator() {
        this(0, STATE.WORKING, new WeightSensor(), new SmokeSensor());

    }

    public void move(RequestBean request) {
        //check all sensor before executing request
        if (this.sensorNoitification()) {
            System.out.println("Alarm.... ");
            return;
        }
        if (this.getCurrentState().equals(STATE.WORKING)) {
            System.out.println("Moving :" + request.getDirection() + " from floor: " + getCurrentFloor()
                    + " to floor : " + request.getFloor());
            this.setCurrentFloor(request.getFloor());
        } else {
            System.err.println("Elvator is dead." + this.toString());
        }
    }

    public STATE getCurrentState() {
        return currentState;
    }

    public void setCurrentState(STATE currentState) {
        this.currentState = currentState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Sensor getWeightSensor() {
        return weightSensor;
    }

    public void setWeightSensor(Sensor weightSensor) {
        this.weightSensor = weightSensor;
    }

    public Sensor getSmokeSensor() {
        return SmokeSensor;
    }

    public void setSmokeSensor(Sensor SmokeSensor) {
        this.SmokeSensor = SmokeSensor;
    }


    public boolean sensorNoitification() {
        if (SmokeSensor.get() || weightSensor.get() >= MAX_WEIGHT) {
            System.out.println("Alarm ....");
            this.setCurrentState(STATE.DEAD);
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Elevator{" + "currentFloor=" + currentFloor + ", currentState=" + currentState + '}';
    }

}
