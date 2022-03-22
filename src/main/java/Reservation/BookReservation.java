package Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import Input.Input;
import Event.*;

/*
int
double
string
date



*/

public class BookReservation extends Reservation {
    private String reservationType = "Book";
    // private ReservationDetail<Object> bookId = new ReservationDetail("id");
    private ArrayList<ReservationDetail<?>> ReservationDetails = new ArrayList<ReservationDetail<?>>();
    private Event event;

    public BookReservation(Event event) {
        this.event = event;
        this.event.setEventInfo("In BookReservation class", "Creating a book reservation object", LocalDateTime.now());
        this.event.trigger();
        this.createDetail("hi", "pls", event);
    }

    @Override
    void reserve() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getReservationType() {
        this.event.setEventInfo("In BookReservation class", "Getting reservation type", LocalDateTime.now());
        this.event.trigger();
        return reservationType;
    }

}
