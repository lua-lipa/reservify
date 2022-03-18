package Command;

import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class NoCommand implements Command {
    private String title;

    public NoCommand() {
        System.out.println("No command constructor");
        this.title = "";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("No Command");
        return false;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    public void undo() {
        System.out.println("Undo no command");
    }

    public String getCommandTitle() {
        return this.title;
    }

}
