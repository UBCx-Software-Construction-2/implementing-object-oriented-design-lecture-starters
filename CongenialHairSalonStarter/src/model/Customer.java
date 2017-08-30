package model;

public class Customer {
    private String name;
    private int bookedTime;
    private Treatment treatment;

    public Customer(String name){
        System.out.println("Making a new Customer called "+name);
        this.name = name;
        this.bookedTime = 0;
    }

    // getters
    public String getName() { return name; }
    public int getBookingTime() { return bookedTime; }
    public Treatment getTreatment() { return treatment; }

    // setters
    public void setBookedTime(int time, Treatment treatment){
        bookedTime = time;
        this.treatment = treatment;
    }

    public int confirmBooking(){
        System.out.println(name+ ": Confirming that I am booked at "+bookedTime+" for "+treatment.getName());
        return bookedTime;
    }

    public void printName() {
        System.out.println(" " + name + " ");
    }


}