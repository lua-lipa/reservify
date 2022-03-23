import Booking.*;

import java.security.Identity;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Command.*;
import Input.Input;
import Reservation.BookReservation;
import Reservation.LaptopReservation;
import Reservation.Reservation;
import Reservation.ReservationDetail;
import Reservation.ReservationFactory;
import Reservation.RoomReservation;
import Interceptor.*;
import Event.*;

public class App2 {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        interceptor logging = new loggingInterceptor("log");
        interceptor welcome = new welcomeInterceptor("welcome");
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);
        dispatcher.register(welcome);

        Event event = new LoggingEvent(co, dispatcher);
        Event welcomeEvent = new WelcomeEvent(co, dispatcher);

        welcomeEvent.setEventInfo("In Main class", "Welcome to Reservify, please create a reservation or amend an existing one.", LocalDateTime.now());
        welcomeEvent.trigger();

        ReservationFactory rf = new ReservationFactory(event);
        rf.registerReservation(new BookReservation(event));
        rf.registerReservation(new LaptopReservation(event));
        rf.registerReservation(new RoomReservation(event));

        UIToolkit ui = new UIToolkit(event);
        Command makeReservationCommand = new MakeReservationCommand(event);
        Command cancelReservationCommand = new CancelReservationCommand(event);
        Command changeReservationCommand = new ChangeReservationCommand(event);
        Command exitSystemCommand = new ExitSystemCommand(event);
        Command undoReservationDetailCommand = new UndoReservationDetail();

        ui.setCommand(1, makeReservationCommand);
        ui.setCommand(2, cancelReservationCommand);
        ui.setCommand(3, changeReservationCommand);
        ui.setCommand(4, exitSystemCommand);
        ui.setMementoCommand(undoReservationDetailCommand);
        ui.registerReservationFactory(rf);

        boolean sessionExited = false;
        Input input = Input.getInstance();

        // ArrayList<ReservationDetail<?>> rds = res.getReservationDetails();
        // for (int i = 0; i < rds.size(); i++) {
        // ReservationDetail<?> r = rds.get(i);
        // System.out.println(r.getValue());
        // }

        // reservation choices
        // array list of input needed
        // scanner loops to ask for input of these choices
        // choices are stored and used to make the booking

        // bookname
        // laptopcolour

        // arraylist of details needed from the user
        // loop through those details, ask for input
        // record user input
        // make a booking object

        while (!sessionExited) {
            int command_index = input.getInt(ui.getCommandOptions());
            sessionExited = ui.executeCommand(command_index);
            // int r1 = input.getInt(rf.getReservationOptions());
            // Reservation res = rf.createReservation(r1);
            // System.out.println("reserved: " + res.getReservationType().toString());

        }

        // reservation choices
        // array list of input needed
        // scanner loops to ask for input of these choices
        // choices are stored and used to make the booking

        // bookname
        // laptopcolour

        // arraylist of details needed from the user
        // loop through those details, ask for input
        // record user input
        // make a booking object
        // new Property("LaptopName", String)

    }
}
