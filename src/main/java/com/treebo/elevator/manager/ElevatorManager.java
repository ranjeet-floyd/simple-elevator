package com.treebo.elevator.manager;

import com.treebo.elevator.bean.RequestBean;
import com.treebo.elevator.constant.STATE;
import com.treebo.elevator.entity.Elevator;
import java.util.ArrayList;
import java.util.List;

/**
 * Manage all elavator request in the system.
 *
 * @author ranjeet
 */
public class ElevatorManager {

    private final Elevator elevator;
    private final List<RequestBean> requests;

    public ElevatorManager(Elevator elevator) {
        this.elevator = elevator;
        this.requests = new ArrayList<>();
    }

    public boolean addRequest(RequestBean request) {
        if (this.elevator.getCurrentState().equals(STATE.WORKING)) {
            this.requests.add(request);
            System.out.println("Request accepted");
            return true;
        } else {
            System.out.println("Elevator is dead..no request is acceting now :" + elevator.toString());
        }

        return false;
    }

    public void execute() {
        requests.stream().forEach(req -> this.elevator.move(req));
    }

}
