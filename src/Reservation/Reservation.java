package Reservation;

import Booking.Booking;

abstract public class Reservation {
    Booking booking;

    Reservation(Booking booking) {
        this.booking = booking;
    }

    abstract void reserve();

    abstract String getReservationType();
}
