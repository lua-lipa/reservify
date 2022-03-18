package Command;

import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class CancelReservationCommand implements Command {
    private String title;

    public CancelReservationCommand() {
        this.title = "Cancel Reservation";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("Cancel Reservation");
        return false;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    @Override
    public void undo() {
        System.out.println("Undo cancel reservation");
    }

    public String getCommandTitle() {
        return this.title;
    }

}
