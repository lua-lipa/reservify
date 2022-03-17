import java.security.Identity;

import Input.Input;
import Reservation.BookReservation;
import Reservation.LaptopReservation;
import Reservation.Reservation;
import Reservation.ReservationFactory;
import Reservation.RoomReservation;

public class App2 {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        ReservationFactory rf = new ReservationFactory();
        rf.registerReservation(new BookReservation());
        rf.registerReservation(new LaptopReservation());
        rf.registerReservation(new RoomReservation());

        Input input = Input.getInstance();
        int r1 = input.getInt(rf.getReservationOptions());
        Reservation res = rf.createReservation(r1);
        System.out.println("reserved: " + res.getReservationType().toString());

        //reservation choices
        //array list of input needed
        //scanner loops to ask for input of these choices
        //choices are stored and used to make the booking

        //bookname
        //laptopcolour

        //arraylist of details needed from the user
        //loop through those details, ask for input
        //record user input
        //make a booking object
        // new Property("LaptopName", String)

    }
}
