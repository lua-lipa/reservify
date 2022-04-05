package Reservify;
import java.time.LocalDateTime;

import Booking.Booking;
import Command.UIToolkit;
import Event.Event;
import Event.GoodbyeEvent;
import Event.LoggingEvent;
import Event.WelcomeEvent;
import Input.Input;
import Interceptor.contextObject;
import Interceptor.dispatcher;
import Interceptor.interceptor;
import Reservation.Reservation;
import Reservation.ReservationFactory;
import Reservation.StandardReservation;

public class Reservify {
    private static Reservify instance = null;
    private static UIToolkit uiInstance = null;
    private ReservationFactory reservationFactory;
    private static Event loggingEvent = null;
    private static Event goodbyeEvent = null;
    private static Event welcomeEvent = null;
    private static contextObject co;
    private static dispatcher dispatcher;

    private Reservify() {}

    public static Reservify getInstance() {
        if (instance == null) {
            instance = new Reservify();
            co = new contextObject();
            dispatcher = new dispatcher(co);
            loggingEvent = new LoggingEvent(co, dispatcher);
            welcomeEvent = new WelcomeEvent(co, dispatcher);
            goodbyeEvent = new GoodbyeEvent(co, dispatcher);  
            instance.reservationFactory = new ReservationFactory(loggingEvent);
        }
        
        return instance;
    }

    public UIToolkit getUIToolkit() {
        if (uiInstance == null) {
            uiInstance = new UIToolkit(loggingEvent, goodbyeEvent, reservationFactory);
        }
        welcomeEvent.setEventInfo("In Main class", "Welcome to Reservify, please create a reservation or amend an existing one.", LocalDateTime.now());
        welcomeEvent.trigger();   
        return uiInstance;
    }

    public Input getInput() {
        return Input.getInstance();
    }

    public Reservation createReservation(Booking booking, String name, Double price) {
        Reservation reservation = new StandardReservation(booking, loggingEvent, name, price);
        reservationFactory.registerReservation(reservation);

        return reservation;
    }

    public  Event getLoggingEvent() {
        return loggingEvent;
    }

    public void initInterceptor(interceptor i) {
        dispatcher.register(i);
    }
}
