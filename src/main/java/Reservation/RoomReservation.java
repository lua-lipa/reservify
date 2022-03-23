package Reservation;

import java.time.LocalDateTime;

import Event.Event;

public class RoomReservation extends Reservation {
    private String reservationType = "Room";
    private Event event;

    public RoomReservation(Event event) {
        this.event = event;
        this.event.setEventInfo("In RoomReservation class", "Creating a room reservation object", LocalDateTime.now());
        this.event.trigger();
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
