package Command;

import Reservation.ReservationFactory;

public interface Command {
    public boolean execute(ReservationFactory rf, UIToolkit ui);

    public void undo();

    public String getCommandTitle();
}
