package Command;

import Reservation.ReservationFactory;

public interface Command {
    public boolean execute(ReservationFactory rf);

    public void undo();

    public String getCommandTitle();
}
