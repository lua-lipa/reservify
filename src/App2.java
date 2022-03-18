import java.security.Identity;
import java.util.ArrayList;

import Input.Input;
import Reservation.BookReservation;
import Reservation.LaptopReservation;
import Reservation.Reservation;
import Reservation.ReservationDetail;
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
        res.requestUserInput();
        ArrayList<ReservationDetail<?>> rds = res.getReservationDetails();
        for (int i = 0; i < rds.size(); i++) {
            ReservationDetail<?> r = rds.get(i);
            System.out.println(r.getValue());
        }

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
