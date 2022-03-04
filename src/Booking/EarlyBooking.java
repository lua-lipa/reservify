package src.Booking;

import java.util.Date;

public class EarlyBooking implements Booking {
    private double price;
    private Date date;
    private String referenceNumber;

    // EarlyBooking(double price, Date date, String referenceNumber) {
    // this.price = price;
    // this.date = date;
    // this.referenceNumber = referenceNumber;
    // }

    public boolean createBooking() {
        System.out.println("Early Booking Done");

        return true;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setBookingTime(Date date) {
        this.date = date;
    }

    public Date getBookingTime() {
        return date;
    }

    public void setBookingReference(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getBookingReference() {
        return referenceNumber;
    }

    public void cancelBooking(String referenceNumber) {
        // implement cancelation
    }
}
