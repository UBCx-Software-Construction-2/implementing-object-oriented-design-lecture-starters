package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class SelfDrivingCar {

    private List<Wheel> wheels = new ArrayList<>();
    private List<Brake> brakes = new ArrayList<>();
    private SpeedRegulator speedRegulator;
    private Engine engine;
    private Speedometer speedometer;
    private FrontSensor frontSensor;

    public SelfDrivingCar(int numSecondsToTest) {
        setup();
        AutoDriver driver = new AutoDriver(this);
        driver.driveForward(numSecondsToTest);
    }

    private void setup() {
        engine = new Engine();
        speedometer = new Speedometer(this);
        speedRegulator = new SpeedRegulator(this);
        frontSensor = new FrontSensor();

        for (int i = 0; i < 4; i++) {
            Brake b = new Brake();
            brakes.add(b);
            Wheel w = new Wheel();
            wheels.add(w);
            b.setWheel(w);
        }
    }

    //getters
    public FrontSensor getFrontSensor() { return frontSensor; }
    public SpeedRegulator getSpeedRegulator() { return speedRegulator; }
    public Engine getEngine() { return engine; }
    public List<Brake> getBrakes() { return brakes; }
    public Speedometer getSpeedometer() { return speedometer; }
    public List<Wheel> getWheels() { return wheels; }

    public static void main(String[] args) { SelfDrivingCar car = new SelfDrivingCar(10); }


}