package Reservation;

import java.time.LocalDateTime;

import Event.Event;

public class LaptopReservation extends Reservation {
    private String reservationType = "Laptop";
    private Event event;

    public LaptopReservation(Event event) {
        this.event = event;
        this.event.setEventInfo("In LaptopReservation class", "Creating a laptop reservation object", LocalDateTime.now());
        this.event.trigger();
    }

    @Override
    void reserve() {
    }

    @Override
    public String getReservationType() {
        return reservationType;
    }

}
