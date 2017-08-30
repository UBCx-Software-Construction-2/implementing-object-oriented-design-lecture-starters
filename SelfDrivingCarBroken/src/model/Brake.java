package model;


public class Brake {

    public void apply() {
        wheel.slow();
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }


}