package Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import Event.Event;
import Input.Input;

public class StandardReservation extends Reservation {
    private String reservationName;
    private Double reservationPrice;
    private Event event;

    public StandardReservation(Event event, String name, Double Price) {
        this.event = event;
        this.event.setEventInfo("In BookReservation class", "Creating a book reservation object", LocalDateTime.now());
        this.event.trigger();
        this.createDetail("hi", "pls", event);
    }

    public String getReservationName() {
        return this.reservationName;
    }

    public Double getReservationPrice() {
        return this.reservationPrice;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public void setReservationPrice(Double reservationPrice) {
       this.reservationPrice = reservationPrice;
    }



    @Override
    void reserve() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getReservationType() {
        return reservationType;
    }
}