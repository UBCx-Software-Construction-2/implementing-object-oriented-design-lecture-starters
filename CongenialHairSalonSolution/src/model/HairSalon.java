package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HairSalon {

    private ArrayList<Customer> bookings;
    private Map<Treatment, ArrayList<String>> treatmentSpecialists = new HashMap<>();

    // Effects: creates a hair salon with available booking times from 0-17hrs.
    public HairSalon(){
        bookings = new ArrayList<>();

        for (int i = 0; i <= 17; i++) {
            bookings.add(i, null);
        }

        Treatment cut = new Treatment("cut", 1);
        Treatment colour = new Treatment ("colour", 2);
        Treatment condition = new Treatment ("condition", 3);

        addTreatment(cut);
        addTreatment(colour);
        addTreatment(condition);

        addTreatmentSpecialist(cut, "Jean");
        addTreatmentSpecialist(cut, "Marie");
        addTreatmentSpecialist(cut, "Gerome");
        addTreatmentSpecialist(colour, "Sylvie");
        addTreatmentSpecialist(colour, "Sandrine");
        addTreatmentSpecialist(condition, "Mike");
        addTreatmentSpecialist(condition, "Bob");
    }


    // MODIFIES: this and Customer
    // EFFECTS:  books the customer into the requested timeslot if it is a valid timeslot,
    //           and lets the Customer know the booking time.
    public boolean makeNewBooking(Customer c, int bookingTime, Treatment treatment){
        if (bookingTime >= bookings.size() || bookingTime + treatment.getHoursNeeded() >= bookings.size()) {
            System.out.println("We can't process that booking time");
            return false;
        }
        for (int i = bookingTime; i < bookingTime + treatment.getHoursNeeded(); i++) {
            System.out.println("Customer " + c.getName() + " has been booked at " + bookingTime);
            bookings.set(i,c);
        }
        c.setBookedTime(bookingTime, treatment);
        return true;
    }


    public boolean cancelBooking(Customer c, int bookingTime, Treatment treatment) {
        if (bookingTime >= bookings.size() || bookingTime + treatment.getHoursNeeded() >= bookings.size()) {
            System.out.println("We can't process that booking time");
            return false;
        }
        for (int i = bookingTime; i < bookingTime + treatment.getHoursNeeded(); i++) {
            System.out.println("Time: "+bookingTime+" has been cancelled");
            bookings.set(i,null);
        }
        c.setBookedTime(0, treatment);
        return true;
    }

    // EFFECTS: prints out all the bookings.  If the time has not been booked, prints "available"
    public void printBookingsList(){
        for (int i = 9; i < bookings.size(); i++) { //change this to be the wrong end value
            Customer c = bookings.get(i);
            if (c != null){
                System.out.print(i + "hrs: ");
                c.printName(); //This causes a bug because you can't access methods on a null value!
            }
            else {
                System.out.print(i + "hrs: ");
                System.out.println(" available ");
            }
        }
    }

    // EFFECTS: returns true if the customer is found at the booking time.
    public boolean verifyBooking(Customer c, int bookingTime) {
        Customer bookedCustomer = bookings.get(bookingTime);
        if (bookedCustomer == null){
            System.out.println("There is no customer booked at that time");
            return false;
        }
        if (bookedCustomer.getName().equals(c.getName())) {
            System.out.println("Yes the customer is booked at that time");
        }
        return true;
    }

    // EFFECTS: returns true if the customer is booked at the booking time
    public boolean confirmBookedName(String cName, int bookingTime) {
        if (bookings.get(bookingTime)!= null) {
            Customer bookedCustomer = bookings.get(bookingTime);
            String bookedCustomerName = bookedCustomer.getName();
            boolean isPersonBooked = bookedCustomerName.equals(cName);
            return isPersonBooked;
        }
        return false;
    }


    // MODIFIES: this and Customer
    // EFFECTS:  changes the customer booked in the bookings, and let's the Customer know the new booking time.
    public void changeBooking(Customer customer, int newTime){
        int bookedTime = customer.getBookingTime();
        System.out.print(customer.getName()+"'s time is changing from "+bookedTime);
        System.out.println(" to "+newTime);
        cancelBooking(customer, bookedTime, customer.getTreatment());
        makeNewBooking(customer, newTime, customer.getTreatment());
    }

    public void suggestConsultant(Treatment treatment) {
        System.out.print("May we suggest you work with: ");
        Treatment t1 = new Treatment("Fake Treatment", 0);
        Treatment t2 = new Treatment("Fake Treatment", 0);
        ArrayList<String> names = treatmentSpecialists.get(treatment);
        for (String name : names){
            System.out.println(name+"?");
        }
    }

    private void addTreatment(Treatment treatment){
        treatmentSpecialists.put(treatment, new ArrayList<>());
    }

    private void addTreatmentSpecialist(Treatment t, String name){
        ArrayList<String> names = treatmentSpecialists.get(t);
        names.add(name);
    }


}