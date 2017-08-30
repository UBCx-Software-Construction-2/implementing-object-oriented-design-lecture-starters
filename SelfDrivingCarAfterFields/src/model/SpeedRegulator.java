package model;

import ui.SelfDrivingCar;

import java.util.List;

public class SpeedRegulator {

    private Engine engine;
    private List<Brake> brakes;
    private Speedometer speedometer;
    private int intendedSpeed;

    public SpeedRegulator(SelfDrivingCar car){
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