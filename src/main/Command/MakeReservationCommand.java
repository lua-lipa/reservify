package main.Command;

import main.Input.Input;
import main.Reservation.Reservation;
import main.Reservation.ReservationFactory;

public class MakeReservationCommand implements Command {

    private String title;
    private Input input;

    public MakeReservationCommand() {
        System.out.println("reservation constructor");
        title = "Make Reservation";
        this.input = Input.getInstance();
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("Make Reservation");
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
        System.out.println("Undo make reservation");
    }

    public String getCommandTitle() {
        return this.title;
    }
}
