package src.command;

public class MakeReservationCommand implements Command {

    public MakeReservationCommand(String reservation) {
        System.out.println("reservation constructor");
    }

    public void execute() {
        System.out.println("creating a reservation");
    }

}
