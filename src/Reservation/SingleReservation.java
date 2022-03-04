package src.Reservation;

import src.Booking.Booking;

public class SingleReservation extends Reservation {

    SingleReservation(Booking booking) {
        super(booking);
    }

    @Override
    void reserve() {
        this.booking.createBooking();
    }

    @Override
    String getReservationType() {
        return "Single";
    }

}
