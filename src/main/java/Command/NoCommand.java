package Command;

import java.time.LocalDateTime;

import Event.Event;
import Reservation.ReservationFactory;

public class NoCommand implements Command {
    private String title;
    private Event event;

    public NoCommand(Event event) {
        this.event = event;
        this.event.setEventInfo("In NoCommand class", "Creating No Command object", LocalDateTime.now());
        this.event.trigger();
        this.title = "";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        this.event.setEventInfo("In NoCommand class", "Executing No Command", LocalDateTime.now());
        this.event.trigger();
        return false;
    }

    public void undo() {
        this.event.setEventInfo("In NoCommand class", "Undoing No Command", LocalDateTime.now());
        this.event.trigger();
    }

    public String getCommandTitle() {
        return this.title;
    }

}
