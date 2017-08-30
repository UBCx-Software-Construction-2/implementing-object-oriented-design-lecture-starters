package model;

import ui.SelfDrivingCar;

import java.util.List;


public class Speedometer {

    private List<Wheel> wheels;

    public Speedometer(SelfDrivingCar car) {
        this.wheels = car.getWheels();
    }

    public int getSpeed() {
        Wheel w = wheels.get(0);
        return w.getSpeed();
    }


}