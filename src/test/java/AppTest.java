
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Booking.Booking;
import Booking.EarlyBooking;

public class AppTest {
    @Test
    public void test() {
        assertEquals(2, 1 + 1);
        ;
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
