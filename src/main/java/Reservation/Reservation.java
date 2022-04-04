package Reservation;

import java.util.ArrayList;
import java.util.Date;

import Event.Event;
import Memento.Memento;

abstract public class Reservation implements Cloneable, Memento {

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

    public abstract void reserve();

    public abstract String getReservationType();

    public abstract String getReservationName();

    public void createDetail(String name, String type, Event event) {
        // type must be Integer, String, Double or Date
        ReservationDetail<?> rd = new ReservationDetail<>();
        if (type.equals("Integer")) {
            rd = new ReservationDetail<Integer>(Integer.class, name, type, event);
        } else if (type.equals("String")) {
            rd = new ReservationDetail<String>(String.class, name, type, event);
        } else if (type.equals("Date")) {
            rd = new ReservationDetail<Date>(Date.class, name, type, event);
        } else if (type.equals("Double")) {
            rd = new ReservationDetail<Double>(Double.class, name, type, event);
        }

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
}