package Command;

import java.time.LocalDateTime;

import Event.Event;
import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class ViewReservationsCommand implements Command {
    private Event event;
    private String title;

    public ViewReservationsCommand(Event event) {
        this.title = "View Reservations";
        this.event = event;
        this.event.setEventInfo("In ViewReservations class", "Creating ViewReservations Command object",
                LocalDateTime.now());
        this.event.trigger();
    }

    @Override
    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        String allReservations = rf.viewAllReservations();
        if (allReservations.length() == 0) {
            System.out.println("There are no reservations for the user");
        }
        System.out.println(allReservations);
        return false;
    }

    @Override
    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCommandTitle() {
        return this.title;
    }

}
