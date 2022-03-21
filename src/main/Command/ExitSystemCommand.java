package main.Command;

import main.Reservation.ReservationFactory;

public class ExitSystemCommand implements Command {
    private String title;

    public ExitSystemCommand() {
        System.out.println("Exit command constructor");
        this.title = "Exit System";
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui) {
        System.out.println("Exiting the system. Thank you for using reservify.");
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
