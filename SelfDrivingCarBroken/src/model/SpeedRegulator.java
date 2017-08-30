package model;

import ui.SelfDrivingCar;

public class SpeedRegulator {

    private int intendedSpeed;

    public SpeedRegulator(SelfDrivingCar car) {
        engine = car.getEngine();
        brakes = car.getBrakes();
        speedometer = car.getSpeedometer();
    }

    public void slowDown() {
        intendedSpeed--;
        engine.stop();
        while(speedometer.getSpeed() > intendedSpeed) {
            for (Brake b : brakes) {
                b.apply();
            }
        }
    }


}