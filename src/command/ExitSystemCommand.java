package Command;

import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class ExitSystemCommand implements Command {
    private String title;

    public ExitSystemCommand() {
        System.out.println("Exit command constructor");
        this.title = "Exit System";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("Exiting the system. Thank you for using reservify.");
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
