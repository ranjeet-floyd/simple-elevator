package com.treebo.elevator;

import com.treebo.elevator.bean.RequestBean;
import com.treebo.elevator.constant.DIRECTION;
import com.treebo.elevator.constant.REQ_TYPE;
import com.treebo.elevator.constant.STATE;
import com.treebo.elevator.entity.Elevator;
import com.treebo.elevator.manager.ElevatorManager;
import com.treebo.elevator.sensor.Sensor;
import com.treebo.elevator.sensor.type.SmokeSensor;
import com.treebo.elevator.sensor.type.WeightSensor;

/**
 *
 * @author ranjeet
 */
public class Client {
    public static void main(String[] args) {
        //init elevator with smoke sensor
        Elevator elevator = new Elevator();
        Sensor<Integer> weightSensor = new WeightSensor();
        weightSensor.set(50);
        elevator.setWeightSensor(weightSensor);
        Sensor<Boolean> smokeSensor = new SmokeSensor();
        smokeSensor.set(Boolean.TRUE);

        //execut request using Elevator manager
        ElevatorManager elevatorManager = new ElevatorManager(elevator);
        elevatorManager.addRequest(new RequestBean(1, DIRECTION.DOWN, REQ_TYPE.INSIDE));
        elevatorManager.addRequest(new RequestBean(3, DIRECTION.UP, REQ_TYPE.OUTSIDE));
        elevatorManager.execute();

        weightSensor.set(50);
        elevator.setCurrentState(STATE.WORKING);
        elevatorManager.addRequest(new RequestBean(5, DIRECTION.DOWN, REQ_TYPE.INSIDE));
        elevatorManager.addRequest(new RequestBean(6, DIRECTION.DOWN, REQ_TYPE.INSIDE));

        elevatorManager.execute();
    }

}
