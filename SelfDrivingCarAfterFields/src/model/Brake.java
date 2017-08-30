package model;

import java.util.List;

public class Brake {

    private Wheel wheel;

    public void apply() {
        wheel.slow();
    }

    // setters
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }


}