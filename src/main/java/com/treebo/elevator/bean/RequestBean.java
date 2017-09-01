package com.treebo.elevator.bean;

import com.treebo.elevator.constant.DIRECTION;
import com.treebo.elevator.constant.REQ_TYPE;

/**
 * Request object for elavator
 *
 * @author ranjeet
 */
public class RequestBean {

    private final int floor;
    private final DIRECTION direction;
    private final REQ_TYPE reqType;

    public RequestBean(int floor, DIRECTION direction, REQ_TYPE reqType) {
        this.floor = floor;
        this.direction = direction;
        this.reqType = reqType;
    }

    public int getFloor() {
        return floor;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public REQ_TYPE getReqType() {
        return reqType;
    }

    @Override
    public String toString() {
        return "RequestBean{" + "floor=" + floor + ", direction=" + direction + ", reqType=" + reqType + '}';
    }

}
