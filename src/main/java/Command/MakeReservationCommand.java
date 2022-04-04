package Command;

import java.time.LocalDateTime;

import Event.Event;
import Input.Input;
import Reservation.Reservation;
import Reservation.ReservationFactory;
import Memento.Caretaker;
import Memento.Originator;

public class MakeReservationCommand implements Command {

    private String title;
    private Input input;
    private Event event;
    private Reservation res;

    public MakeReservationCommand(Event event) {
        this.event = event;
        this.event.setEventInfo("In MakeReservationCommand class", "Creating Make Reservation Command object", LocalDateTime.now());
        this.event.trigger();
        title = "Make Reservation";
        this.input = Input.getInstance();
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        this.event.setEventInfo("In MakeReservationCommand class", "Executing the command to make a reservation", LocalDateTime.now());
        this.event.trigger();
        boolean requestHandled = false;
        Originator originator = new Originator(this.event);
        Caretaker caretaker = new Caretaker(this.event);
        while (!requestHandled) {
            int r1 = input.getInt(rf.getReservationOptions());
            this.res = rf.createReservation(r1);
            caretaker.addMemento(originator.storeInMemento(res));
            System.out.println("reserved: " + res.getReservationName().toString());
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
        this.event.setEventInfo("In MakeReservationCommand class", "Undoing the command to remove the reservation", LocalDateTime.now());
        this.event.trigger();
    }

    public String getCommandTitle() {
        return this.title;
    }
}
