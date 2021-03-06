package Command;

import java.time.LocalDateTime;

import Event.Event;
import Reservation.ReservationFactory;
import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;

public class ChangeReservationCommand implements Command {
    private String title;
    private Event event;

    public ChangeReservationCommand(Event event) {
        this.event = event;
        this.event.setEventInfo("In ChangeReservationCommand class", "Creating Change Reservation Command object", LocalDateTime.now());
        this.event.trigger();
        this.title = "Change Reservation";
    }

    @Override
    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        this.event.setEventInfo("In ChangeReservationCommand class", "Executing the command and changing the reservation", LocalDateTime.now());
        this.event.trigger();
        return false;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    @Override
    public void undo() {
        this.event.setEventInfo("In ChangeReservationCommand class", "Undoing the command and the change made to the", LocalDateTime.now());
        this.event.trigger();

    }

    public String getCommandTitle() {
        return this.title;
    }

}
