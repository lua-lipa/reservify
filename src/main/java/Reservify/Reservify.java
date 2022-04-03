package Reservify;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Booking.Booking;
import Command.UIToolkit;
import Event.Event;
import Event.LoggingEvent;
import Event.WelcomeEvent;
import Input.Input;
import Interceptor.contextObject;
import Interceptor.dispatcher;
import Interceptor.interceptor;
import Interceptor.loggingInterceptor;
import Interceptor.welcomeInterceptor;
import Reservation.Reservation;
import Reservation.ReservationFactory;
import Reservation.StandardReservation;

public class Reservify {
    private static Reservify instance = null;
    private static UIToolkit uiInstance = null;
    private ReservationFactory reservationFactory;
    private Event loggingEvent = null;
    
    private Reservify() {}

    public static Reservify getInstance() {
        if (instance == null) {
            instance = new Reservify();
            instance.initInterceptor();
            instance.reservationFactory = new ReservationFactory(instance.loggingEvent);
        }
        
        return instance;
    }

    public UIToolkit getUIToolkit() {
        if (uiInstance == null) {
            uiInstance = new UIToolkit(loggingEvent, reservationFactory);
        }
        
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

    public Event getLoggingEvent() {
        return this.loggingEvent;
    }

    private void initInterceptor() {
        interceptor logging = new loggingInterceptor("log");
        interceptor welcome = new welcomeInterceptor("welcome");
        contextObject co = new contextObject();
        dispatcher dispatcher = new dispatcher(co);
        dispatcher.register(logging);
        dispatcher.register(welcome);

        this.loggingEvent = new LoggingEvent(co, dispatcher);
        Event welcomeEvent = new WelcomeEvent(co, dispatcher);

        welcomeEvent.setEventInfo("In Main class", "Welcome to Reservify, please create a reservation or amend an existing one.", LocalDateTime.now());
        welcomeEvent.trigger();
    }
}
