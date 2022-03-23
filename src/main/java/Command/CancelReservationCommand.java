package Command;

import java.time.LocalDateTime;

import Event.Event;
import Reservation.ReservationFactory;

public class CancelReservationCommand implements Command {
    private String title;
    private Event event;

    public CancelReservationCommand(Event event) {
        this.title = "Cancel Reservation";
        this.event = event;
        this.event.setEventInfo("In CancelReservationCommand class", "Creating Cancel Reservation Command object", LocalDateTime.now());
        this.event.trigger();
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        this.event.setEventInfo("In CancelReservationCommand class", "Executing the command and cancelling the reservation", LocalDateTime.now());
        this.event.trigger();
        return false;
    }

    @Override
    public void undo() {
        this.event.setEventInfo("In CancelReservationCommand class", "Undoing the command and rebooking the reservation", LocalDateTime.now());
        this.event.trigger();
    }

    public String getCommandTitle() {
        return this.title;
    }

}
