package Command;

import Memento.Caretaker;
import Memento.Originator;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public interface Command {
    public boolean execute(ReservationFactory rf, UIToolkit ui);

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation);

    public void undo();

    public String getCommandTitle();
}
