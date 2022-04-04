package Command;

import java.time.LocalDateTime;

import Event.Event;
import Reservation.ReservationFactory;
import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;

public class ExitSystemCommand implements Command {
    private String title;
    private Event event;

    public ExitSystemCommand(Event event) {
        this.event = event;
        this.title = "Exit System";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        this.event.setEventInfo("In ExitSystemCommand class", "Thank you for using Reservify, til next time goodbye.", LocalDateTime.now());
        this.event.trigger();
        return true;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    @Override
    public void undo() {
        System.out.println("Undo exit system");

    }

    public String getCommandTitle() {
        return this.title;
    }

}
