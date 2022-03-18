package Reservation;

import java.util.ArrayList;
import java.util.Date;

import Input.Input;

abstract public class Reservation implements Cloneable {
    //This is the memento class and ReservationDetails 
    private ArrayList<ReservationDetail<?>> ReservationDetails = new ArrayList<ReservationDetail<?>>();
    
    public Reservation clone() {
        Reservation reservation;
        try {
            reservation = (Reservation) super.clone();
        } catch (CloneNotSupportedException e) {
            reservation = null;
        }
        return reservation;
    }

    abstract void reserve();

    public abstract String getReservationType();

    public void createDetail(String name, String type) {
        //type must be Integer, String, Double or Date
        ReservationFactory rf = new ReservationFactory();
        ReservationDetail<?> rd = rf.createReservationDetail("name", "Integer");
        ReservationDetail<?> rd_2 = rf.createReservationDetail("age", "Integer");
        ReservationDetails.add(rd);
        ReservationDetails.add(rd_2);
    }

    public void requestUserInput() {
        
    }

    public ArrayList<ReservationDetail<?>> getReservationDetails() {
        return ReservationDetails;
    }

    public void setReservationDetails(ArrayList<ReservationDetail<?>> rd) {
        this.ReservationDetails = rd;
    }
}