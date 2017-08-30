package model;

import java.util.Random;

public class FrontSensor {

    public boolean tooClose() {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            return false;
        } else {
            return true;
        }
    }


}