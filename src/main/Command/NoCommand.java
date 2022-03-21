package main.Command;

import main.Reservation.ReservationFactory;

public class NoCommand implements Command {
    private String title;

    public NoCommand() {
        System.out.println("No command constructor");
        this.title = "";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("No Command");
        return false;
    }

    public void undo() {
        System.out.println("Undo no command");
    }

    public String getCommandTitle() {
        return this.title;
    }

}
