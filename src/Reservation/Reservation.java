package src.Reservation;

import src.Booking.Booking;

abstract public class Reservation {
    Booking booking;

    Reservation(Booking booking) {
        this.booking = booking;
    }

    abstract void reserve();

    abstract String getReservationType();
}
