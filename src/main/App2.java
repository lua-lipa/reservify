package main;

import java.security.Identity;
import java.util.ArrayList;

import main.Command.*;
import main.Input.Input;
import main.Reservation.BookReservation;
import main.Reservation.LaptopReservation;
import main.Reservation.Reservation;
import main.Reservation.ReservationDetail;
import main.Reservation.ReservationFactory;
import main.Reservation.RoomReservation;

public class App2 {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        ReservationFactory rf = new ReservationFactory();
        rf.registerReservation(new BookReservation());
        rf.registerReservation(new LaptopReservation());
        rf.registerReservation(new RoomReservation());

        UIToolkit ui = new UIToolkit();
        Command makeReservationCommand = new MakeReservationCommand();
        Command cancelReservationCommand = new CancelReservationCommand();
        Command changeReservationCommand = new ChangeReservationCommand();
        Command exitSystemCommand = new ExitSystemCommand();

        ui.setCommand(1, makeReservationCommand);
        ui.setCommand(2, cancelReservationCommand);
        ui.setCommand(3, changeReservationCommand);
        ui.setCommand(4, exitSystemCommand);
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