package Reservation;

public enum ReservationType_ENUM {
    STANDARD_RESERVATION("Standard Reservation"),

    public final String label;

    private Element(String label) {
        this.label = label;
    }
}
