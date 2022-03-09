package Command;

public class MakeReservationCommand implements Command {

    public MakeReservationCommand() {
        System.out.println("reservation constructor");
    }

    public void execute() {
        System.out.println("creating a reservation");
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub

    }

}
