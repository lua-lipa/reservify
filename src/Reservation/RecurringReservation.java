package Reservation;

import Booking.Booking;

public class RecurringReservation extends Reservation {

    RecurringReservation(Booking booking) {
        super(booking);
    }

    @Override
    void reserve() {
        this.booking.createBooking();
    }

    @Override
    String getReservationType() {
        return "Recurring";
    }

}