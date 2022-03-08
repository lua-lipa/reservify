package Command;

public class ChangeReservationCommand implements Command {

    public ChangeReservationCommand() {
        System.out.println("amending reservation command");
    }

    @Override
    public void execute() {
        System.out.println("amending reservation");

    }

}
