import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Event.*;
import Interceptor.*;
import Reservation.Reservation;
import Reservation.ReservationFactory;
import Reservation.StandardReservation;

public class ReservationTest {
    @Test
    public void testReservationOptions() {
        Event event = setUpMockEvent();
        ReservationFactory rf = new ReservationFactory(event);
        String expected = "Reservation Types";
        assertEquals(expected, rf.getReservationOptions());
    }

    public Event setUpMockEvent() {
        interceptor logging = new loggingInterceptor("log");
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);

        dispatcher.register(logging);
        Event event = new LoggingEvent(co, dispatcher);
        return event;
    }

    @Test
    public void testPrototypes() {
        Event event = setUpMockEvent();
        ReservationFactory rf = new ReservationFactory(event);
        Reservation reservation = new StandardReservation(null, event, null, null);
        rf.registerReservation(reservation);
        ArrayList<Reservation> expected = rf.getReservations();
        assertEquals(expected.get(0), reservation);
    }

}
