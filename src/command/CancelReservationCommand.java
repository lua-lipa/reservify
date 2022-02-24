package src.command;

public class CancelReservationCommand implements Command {

    public CancelReservationCommand(String reservation) {
        System.out.println("cancellation constructor");
    }

    public void execute() {
        System.out.println("cancelling a reservation");
    }

}
