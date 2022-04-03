package Reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import Booking.Booking;
import Event.Event;
import Input.Input;

public class StandardReservation extends Reservation {
    private String reservationName;
    private Double reservationPrice;
    private ReservationType_ENUM reservationType = ReservationType_ENUM.STANDARD_RESERVATION;

    private Event event;

    StandardReservation(Booking booking) {
        super(booking);
    }

    public StandardReservation(Event event, String name, Double Price) {
        super(event, name, Price);
        this.event = event;
        this.event.setEventInfo("In BookReservation class", "Creating a book reservation object", LocalDateTime.now());
        this.event.trigger();
        this.reservationName = name;
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
        return reservationType.label;
    }
}