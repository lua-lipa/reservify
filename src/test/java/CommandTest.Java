
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import Command.Command;
import Command.ExitSystemCommand;
import Command.MakeReservationCommand;
import Command.UIToolkit;
import Interceptor.contextObject;
import Interceptor.dispatcher;
import Interceptor.interceptor;
import Interceptor.loggingInterceptor;
import Reservation.ReservationFactory;
import Event.Event;
import Event.LoggingEvent;

public class CommandTest {

    @Test
    public void testCommandTitle() {
        Event event = setUpMockEvent();
        Command exitSystemCommand = new ExitSystemCommand(event);
        assertEquals(exitSystemCommand.getCommandTitle(), "Exit System");

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
    public void testExitCommandExecute() {
        Event event = setUpMockEvent();
        Command exitSystemCommand = new ExitSystemCommand(event);
        Boolean result = exitSystemCommand.execute(null, null);
        assertEquals(result, true);
    }

    @Test
    public void testMakeReservation() {
        Event event = setUpMockEvent();
        Command makeReservationCommand = new MakeReservationCommand(event);
        ReservationFactory rf = new ReservationFactory(event);
        UIToolkit ui = new UIToolkit(event, event, rf);
        Boolean result = makeReservationCommand.execute(rf, ui);
        assertEquals(result, false);
    }

}