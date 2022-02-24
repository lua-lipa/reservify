package src.Booking;

import java.util.Date;

public interface Booking {
    void setPrice(double price);

    double getPrice();

    void setBookingTime(Date date);

    Date getBookingTime();

    void setBookingReference(String referenceNumber);

    String getBookingReference();

    void cancelBooking(String referenceNumber);
}
