package Command;

import Input.Input;
import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class MakeReservationCommand implements Command {

    private String title;
    private Input input;
    private Reservation res;

    public MakeReservationCommand() {
        System.out.println("reservation constructor");
        title = "Make Reservation";
        this.input = Input.getInstance();
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("Make Reservation");
        boolean requestHandled = false;
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        
        while (!requestHandled) {
            int r1 = input.getInt(rf.getReservationOptions());
            this.res = rf.createReservation(r1);
            caretaker.addMemento(originator.storeInMemento(res));
            originator.incrementCurrentReservation();
            originator.incrementSavedReservations();
            System.out.println("reserved: " + res.getReservationType().toString());
            ui.requestUserInput(res, originator, caretaker);
            requestHandled = true;
        }

        return false;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    @Override
    public void undo() {
        System.out.println("Undo make reservation");
    }

    public String getCommandTitle() {
        return this.title;
    }
}
