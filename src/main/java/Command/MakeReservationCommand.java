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
        this.event.setEventInfo("In MakeReservationCommand class", "Creating Make Reservation Command object",
                LocalDateTime.now());
        this.event.trigger();
        title = "Make Reservation";
        this.input = Input.getInstance();
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        // logging
        this.event.setEventInfo("In MakeReservationCommand class", "Executing the command to make a reservation",
                LocalDateTime.now());
        this.event.trigger();
        boolean requestHandled = false;
        // memento
        Originator originator = new Originator(this.event);
        Caretaker caretaker = new Caretaker(this.event);

        // handle the request
        while (!requestHandled) {
            int r1 = input.getInt(rf.getReservationOptions());
            this.res = rf.createReservation(r1);
            caretaker.addMemento(originator.storeInMemento(res));
            // get input from user (reservation details)
            Reservation input = getReservationInput(ui, res, originator, caretaker);
            // and store the reservation
            addReservation(input);
            requestHandled = true;
        }
        // return false because the session has not been exited
        return false;
    }

    private void addReservation(Reservation reservationInput) {
        // todo : add reservation to the database
    }

    private Reservation getReservationInput(UIToolkit ui, Reservation res, Originator originator, Caretaker caretaker) {
        ui.requestUserInput(res, originator, caretaker);
        return null;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation) {
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    @Override
    public void undo() {
        // logging
        this.event.setEventInfo("In MakeReservationCommand class", "Undoing the command to remove the reservation",
                LocalDateTime.now());
        this.event.trigger();
        // fetch latest reservation
        Reservation previousReservation = getPreviousReservation();
        // remove reservation
        deleteReservation(previousReservation);
    }

    private void deleteReservation(Reservation previousReservation) {
    }

    public String getCommandTitle() {
        return this.title;
    }

    public Reservation getPreviousReservation() {
        // to-do: fetch previous command
        // to-do: fetch reservation created by the previous command
        return null;
    }
}
