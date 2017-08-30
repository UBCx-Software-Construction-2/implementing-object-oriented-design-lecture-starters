package model;

import ui.SelfDrivingCar;

public class AutoDriver {

    public AutoDriver(SelfDrivingCar car) {
        frontSensor = car.getFrontSensor();
        speedRegulator = car.getSpeedRegulator();
    }

    // MODIFIES: SpeedRegulator
    // EFFECTS: for seconds iterations, slows down if too close to object in front
    public void driveForward(int seconds) {

    }


}