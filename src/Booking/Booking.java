package src.Booking;

import java.util.Date;

/*
    Booking.java acts as the Implementation for the Reservation abstraction
    Bridge Design Pattern: Separation of Abstraction(Reservation) from Implementation(Booking)
*/
public interface Booking {

    public boolean createBooking();

    void setPrice(double price);

    double getPrice();

    void setBookingTime(Date date);

    Date getBookingTime();

    void setBookingReference(String referenceNumber);

    String getBookingReference();

    void cancelBooking(String referenceNumber);
}
