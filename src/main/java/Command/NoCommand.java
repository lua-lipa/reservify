package Command;

import java.time.LocalDateTime;

import Event.Event;
import Reservation.ReservationFactory;
import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;

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

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    public void undo() {
        this.event.setEventInfo("In NoCommand class", "Undoing No Command", LocalDateTime.now());
        this.event.trigger();
    }

    public String getCommandTitle() {
        return this.title;
    }

}
