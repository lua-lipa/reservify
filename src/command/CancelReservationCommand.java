package Command;

public class CancelReservationCommand implements Command {

    public CancelReservationCommand() {
        System.out.println("cancellation constructor");
    }

    public void execute() {
        System.out.println("cancelling a reservation");
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub

    }

}
