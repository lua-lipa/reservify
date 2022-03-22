package Reservation;

public class LaptopReservation extends Reservation {
    private String reservationType = "Laptop";

    public LaptopReservation() {
    }

    @Override
    void reserve() {
    }

    @Override
    public String getReservationType() {
        return reservationType;
    }

}
