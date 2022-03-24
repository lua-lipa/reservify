
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Booking.Booking;
import Booking.EarlyBooking;
import Command.Command;
import Command.ExitSystemCommand;
import Command.MakeReservationCommand;

public class AppTest {
    @Test
    public void test() {
        assertEquals(2, 1 + 1);
        ;
    }

    @Test
    public void testMakeReservationCommand() {
        String expected_title = "Make Reservation";
        Command makeReservation = new MakeReservationCommand(null);
        String actual_title = makeReservation.getCommandTitle();
        assertEquals(expected_title, actual_title);
    }

    @Test
    public void testExitReservationCommand() {
        String expected_title = "Exit System";
        Command exitSystem = new ExitSystemCommand(null);
        String actual_title = exitSystem.getCommandTitle();
        assertEquals(expected_title, actual_title);
    }

    @Test
    public void testBookingSetPrice() {
        double expected_price = 20.0;
        Booking earlyBooking = new EarlyBooking();
        earlyBooking.setPrice(expected_price);
        double actual_price = earlyBooking.getPrice();
        // assertEquals(actual_price, expected_price);
        assertEquals(expected_price, actual_price, 0);
    }

    @Test
    public void testBookingSetReference() {
        String expected_reference = "expected reference";
        Booking earlyBooking = new EarlyBooking();
        earlyBooking.setBookingReference(expected_reference);
        String actual_reference = earlyBooking.getBookingReference();
        assertEquals(expected_reference, actual_reference);
    }

}
