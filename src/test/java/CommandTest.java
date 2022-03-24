import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Command.CancelReservationCommand;
import Command.Command;
import Command.MakeReservationCommand;
import Command.UIToolkit;
import Event.Event;
import Event.LoggingEvent;
import Interceptor.*;

public class CommandTest {

    @Test
    public void testConstructor() {
        String title = "Make Reservation";

        interceptor logging = new loggingInterceptor("log");
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);

        Event event = new LoggingEvent(co, dispatcher);

        Command makeReservation = new MakeReservationCommand(event);
        assertEquals(makeReservation.getCommandTitle(), title);
    }

    @Test
    public void testSetCommand() {

        interceptor logging = new loggingInterceptor("log");
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);

        Event event = new LoggingEvent(co, dispatcher);
        Command testCommand = new CancelReservationCommand(event);
        UIToolkit ui = new UIToolkit(event);
        int index = 1;
        ui.setCommand(index, testCommand);
        assertEquals(ui.getCommand(index), testCommand);
    }

    @Test
    public void testExecuteCommand() {
        interceptor logging = new loggingInterceptor("log");
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);

        Event event = new LoggingEvent(co, dispatcher);

        Command cancelCommand = new CancelReservationCommand(event);
        assertEquals(cancelCommand.execute(null, null), false);
    }

}
