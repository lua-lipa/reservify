import Command.UIToolkit;
import Input.Input;
import Reservation.Reservation;
import Reservify.Reservify;

public class App3 {
    public static void main(String[] args) throws Exception {
        Reservify reservify = Reservify.getInstance();
        UIToolkit ui = reservify.getUIToolkit();
        Input input = reservify.getInput();

        Reservation reservation = reservify.createReservation("Gym Class", 0.0);
        reservation.createDetail("First Name", "String", reservify.getLoggingEvent());
        reservation.createDetail("Last Name", "String", reservify.getLoggingEvent());

        boolean sessionExited = false;
        while (!sessionExited) {
            int command_index = input.getInt(ui.getCommandOptions());
            sessionExited = ui.executeCommand(command_index);
        }
    }
}
