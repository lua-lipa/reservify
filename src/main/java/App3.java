import Booking.EarlyBooking;
import Command.UIToolkit;
import ConcreteInterceptors.goodbyeInterceptor;
import ConcreteInterceptors.loggingInterceptor;
import ConcreteInterceptors.welcomeInterceptor;
import Input.Input;
import Interceptor.interceptor;
import Reservation.Reservation;
import Reservify.Reservify;

public class App3 {
    public static void main(String[] args) throws Exception {
        Reservify reservify = Reservify.getInstance();
        interceptor logging = new loggingInterceptor("log");
        reservify.initInterceptor(logging);
        interceptor welcome = new welcomeInterceptor("welcome");
        reservify.initInterceptor(welcome);
        interceptor goodbye = new goodbyeInterceptor("goodbye");
        reservify.initInterceptor(goodbye);
        UIToolkit ui = reservify.getUIToolkit();
        Input input = reservify.getInput();

        Reservation reservation = reservify.createReservation(new EarlyBooking(), "Gym Class", 0.0);
        reservation.createDetail("First Name", "String", reservify.getLoggingEvent());
        reservation.createDetail("Last Name", "String", reservify.getLoggingEvent());

        boolean sessionExited = false;
        while (!sessionExited) {
            int command_index = input.getInt(ui.getCommandOptions());
            sessionExited = ui.executeCommand(command_index);
        }
    }
}
