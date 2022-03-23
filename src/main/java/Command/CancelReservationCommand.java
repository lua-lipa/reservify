package Command;

import java.time.LocalDateTime;
import Event.Event;
import Reservation.ReservationFactory;
import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;

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

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
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
