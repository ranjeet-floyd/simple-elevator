package com.treebo.elevator.sensor;

/**
 *
 * @author ranjeet
 */
public interface Sensor<T> {

    T get();

    void set(T t);
}
