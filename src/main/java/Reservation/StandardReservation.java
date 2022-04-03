package Reservation;

import java.time.LocalDateTime;

import Booking.Booking;
import Event.Event;

public class StandardReservation extends Reservation {
    private String reservationName;
    private Double reservationPrice;
    private ReservationType_ENUM reservationType = ReservationType_ENUM.STANDARD_RESERVATION;
    private Booking booking;

    private Event event;

    public StandardReservation(Booking booking, Event event, String name, Double Price) {
        this.booking = booking;
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
    public void reserve() {
        booking.createBooking();
    }

    @Override
    public String getReservationType() {
        return reservationType.label;
    }
}