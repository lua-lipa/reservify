package Reservation;

import java.util.ArrayList;
import java.util.Date;

import Event.Event;
import Input.Input;

abstract public class Reservation implements Cloneable {
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

    public void createDetail(String name, String type, Event event) {
        // type must be Integer, String, Double or Date
        ReservationFactory rf = new ReservationFactory(event);
        // ReservationDetail<?> rd = rf.createReservationDetail("name", "Integer");
        ReservationDetail<?> rd = rf.createReservationDetail(name, type);
        ReservationDetails.add(rd);
    }

    public void requestUserInput() {

    }

    public ArrayList<ReservationDetail<?>> getReservationDetails() {
        return ReservationDetails;
    }

    public void setReservationDetails(ArrayList<ReservationDetail<?>> rd) {
        this.ReservationDetails = rd;
    }

    public String toString() {
        return "1";
    }

}