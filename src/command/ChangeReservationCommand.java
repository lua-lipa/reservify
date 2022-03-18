package Command;

import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class ChangeReservationCommand implements Command {
    private String title;

    public ChangeReservationCommand() {
        System.out.println("amending reservation command");
        this.title = "Change Reservation";
    }

    @Override
    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("amend reservation");
        return false;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    @Override
    public void undo() {
        System.out.println("Undo change reservation");

    }

    public String getCommandTitle() {
        return this.title;
    }

}
