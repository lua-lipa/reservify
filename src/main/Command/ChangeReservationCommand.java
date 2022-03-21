package main.Command;

import main.Reservation.ReservationFactory;

public class ChangeReservationCommand implements Command {
    private String title;

    public ChangeReservationCommand() {
        System.out.println("amending reservation command");
        this.title = "Change Reservation";
    }

    @Override
    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("amend reservation");
        return false;
    }

    @Override
    public void undo() {
        System.out.println("Undo change reservation");

    }

    public String getCommandTitle() {
        return this.title;
    }

}
