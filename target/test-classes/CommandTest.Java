
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import Booking.Booking;
import Booking.EarlyBooking;
import Command.Command;
import Command.ExitSystemCommand;
import Command.MakeReservationCommand;

public class CommandTest {

    @Test
    public void testCommandTitle() {
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);
        Event event = new LoggingEvent(co, dispatcher);
        
        exitSystemCommand = new ExitSystemCommand(event); 
        assertEquals(exitSystemCommand.getCommandTitle, "Exit System");

    }

    @Test
    public void testCommandExecutge() {
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);
        Event event = new LoggingEvent(co, dispatcher);
        
        exitSystemCommand = new ExitSystemCommand(event); 
        result = exitSystemCommand.execute();
        assertEquals(result, true);

    }



}