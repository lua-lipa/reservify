package Memento;
import Reservation.Reservation;

import java.time.LocalDateTime;

// Memento Design Pattern Tutorial

import java.util.ArrayList;

import Event.Event;

public class Caretaker {
    private Event event;
   
	// Where all mementos are saved
	ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	public Caretaker(Event event){
		this.event = event;
        this.event.setEventInfo("In Caretaker class", "Creating caretaker object", LocalDateTime.now());
        this.event.trigger();
	}

	// Adds memento to the ArrayList
	public void addMemento(Reservation m) {
		this.event.setEventInfo("In Caretaker class", "Adding a memento of reservation to the memento list", LocalDateTime.now());
        this.event.trigger();
		reservations.add(m); 
	}
   
	// Gets the memento requested from the ArrayList
	public Reservation getMemento(int index) { 
		this.event.setEventInfo("In Caretaker class", "Getting a memento of reservation from the memento list", LocalDateTime.now());
        this.event.trigger();
		return reservations.get(index); 
	}
} 
