package model;

import ui.SelfDrivingCar;

public class Speedometer {

    public Speedometer(SelfDrivingCar car) {
        this.wheels = car.getWheels();
    }

    public int getSpeed() {
        Wheel w = wheels.get(0);
        return w.getSpeed();
    }


}