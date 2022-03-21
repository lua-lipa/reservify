package main.java.Reservation;

public class RoomReservation extends Reservation {
    private String reservationType = "Room";

    public RoomReservation() {

    }

    @Override
    void reserve() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getReservationType() {
        return reservationType;
    }

}
