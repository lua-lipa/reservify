package Reservation;

public enum ReservationType_ENUM {
    STANDARD_RESERVATION("Standard Reservation");

    public final String label;

    ReservationType_ENUM(String label) {
        this.label = label;
    }
}
