package Reservation;

import java.util.ArrayList;
import java.util.Date;

import Booking.Booking;

import java.time.LocalDateTime;
import Event.*;

public class ReservationFactory {
    private ArrayList<Reservation> prototypes;
    public Event event;

    public ReservationFactory(Event event) {
        prototypes = new ArrayList<Reservation>();
        this.event = event;
        this.event.setEventInfo("In ReservationFactory class", "Creating instance of reservation factory", LocalDateTime.now());
        this.event.trigger();
    }

    public void registerReservation(Reservation reservation) {
        this.event.setEventInfo("In ReservationFactory class", "Registering reservation with prototypes array list", LocalDateTime.now());
        this.event.trigger();
        prototypes.add(reservation);
    }

    public Reservation createReservation(int index) {
        this.event.setEventInfo("In ReservationFactory class", "Creating a reservation using clone", LocalDateTime.now());
        this.event.trigger();
        return prototypes.get(index).clone();
    }

    public ArrayList<Reservation> getReservations() {
        this.event.setEventInfo("In ReservationFactory class", "Getting list of reservations", LocalDateTime.now());
        this.event.trigger();
        return prototypes;
    }

    public void createBooking(Booking booking){
        this.event.setEventInfo("In X class", "Creating the Booking", LocalDateTime.now());
        this.event.trigger();
    }

    public ReservationDetail<?> createReservationDetail(String name, String type) {
        this.event.setEventInfo("In ReservationFactory class", "Creating a reservation detail", LocalDateTime.now());
        this.event.trigger();
        ReservationDetail<?> rd = new ReservationDetail<>();
        if (type.equals("Integer")) {
            this.event.setEventInfo("In ReservationFactory class", "Reservation detail created is of type Integer", LocalDateTime.now());
            this.event.trigger();
            rd = new ReservationDetail<Integer>(Integer.class, name, type, event);
        } else if (type.equals("String")) {
            this.event.setEventInfo("In ReservationFactory class", "Reservation detail created is of type String", LocalDateTime.now());
            this.event.trigger();
            rd = new ReservationDetail<String>(String.class, name, type, event);
        } else if (type.equals("Date")) {
            this.event.setEventInfo("In ReservationFactory class", "Reservation detail created is of type Date", LocalDateTime.now());
            this.event.trigger();
            rd = new ReservationDetail<Date>(Date.class, name, type, event);
        } else if (type.equals("Double")) {
            this.event.setEventInfo("In ReservationFactory class", "Reservation detail created is of type Double", LocalDateTime.now());
            this.event.trigger();
            rd = new ReservationDetail<Double>(Double.class, name, type, event);
        }
        return rd;
    }

    public String getReservationOptions() {
        this.event.setEventInfo("In ReservationFactory class", "Printing out reservation options", LocalDateTime.now());
        this.event.trigger();
        // Reservation Types: []
        String str = "Reservation Types";
        for (int i = 0; i < prototypes.size(); i++) {
            Reservation r = prototypes.get(i);
            str += " [" + i + "] " + r.getReservationName().toString();
        }
        return str;
    }

    // Reservation reservation = new RecurringReservation(new EarlyBooking());
}