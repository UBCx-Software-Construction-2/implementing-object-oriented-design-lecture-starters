package model;



public class Treatment {

    private String name;
    private int hoursNeeded;

    public Treatment(String name, int time) {
        this.name = name;
        this.hoursNeeded = time;
    }

    // getters
    public int getHoursNeeded() { return hoursNeeded; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Treatment treatment = (Treatment) o;

        return name.equals(treatment.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


}