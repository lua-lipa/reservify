package Command;

import java.time.LocalDateTime;

import Event.Event;
import Reservation.ReservationFactory;

public class ExitSystemCommand implements Command {
    private String title;
    private Event event;

    public ExitSystemCommand(Event event) {
        this.event = event;
        this.event.setEventInfo("In ExitSystemCommand class", "Creating Exit System Command object", LocalDateTime.now());
        this.event.trigger();
        this.title = "Exit System";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        this.event.setEventInfo("In ExitSystemCommand class", "Executing the command and exiting system", LocalDateTime.now());
        this.event.trigger();
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
