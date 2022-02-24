package src.command;

public class AmendReservationCommand implements Command {

    public AmendReservationCommand(String reservation) {
        System.out.println("amending reservation command");
    }

    @Override
    public void execute() {
        System.out.println("amending reservation");

    }

}
