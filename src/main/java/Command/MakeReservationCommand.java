package Command;

import java.time.LocalDateTime;

import Event.Event;
import Input.Input;
import Reservation.Reservation;
import Reservation.ReservationFactory;

public class MakeReservationCommand implements Command {

    private String title;
    private Input input;
    private Event event;

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
        while (!requestHandled) {
            int r1 = input.getInt(rf.getReservationOptions());
            Reservation res = rf.createReservation(r1);
            System.out.println("reserved: " + res.getReservationType().toString());
            ui.requestUserInput(res.getReservationDetails());
            requestHandled = true;
        }

        return false;
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
