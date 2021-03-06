package Memento;
import Reservation.Reservation;

import java.time.LocalDateTime;

import Event.Event;

public class Caretaker {
    private Event event;
	Reservation reservation;
	
	public Caretaker(Event event){
		this.event = event;
        this.event.setEventInfo("In Caretaker class", "Creating caretaker object", LocalDateTime.now());
        this.event.trigger();
	}

	public void addMemento(Reservation m) {
		this.event.setEventInfo("In Caretaker class", "Adding a memento of reservation", LocalDateTime.now());
        this.event.trigger();
		this.reservation = m;
	}
   
	public Reservation getMemento() { 
		this.event.setEventInfo("In Caretaker class", "Getting a memento of reservation", LocalDateTime.now());
        this.event.trigger();
		return this.reservation; 
	}
} 
