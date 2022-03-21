package main.java.Command;

import main.java.Reservation.ReservationFactory;

public class CancelReservationCommand implements Command {
    private String title;

    public CancelReservationCommand() {
        this.title = "Cancel Reservation";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("Cancel Reservation");
        return false;
    }

    @Override
    public void undo() {
        System.out.println("Undo cancel reservation");
    }

    public String getCommandTitle() {
        return this.title;
    }

}
