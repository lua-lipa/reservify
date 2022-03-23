package Memento;
import Reservation.Reservation;

// Memento Design Pattern Tutorial

import java.util.ArrayList;

public class Caretaker {
   
	// Where all mementos are saved
	ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	// Adds memento to the ArrayList
	public void addMemento(Reservation m) { reservations.add(m); }
   
	// Gets the memento requested from the ArrayList
	public Reservation getMemento(int index) { return reservations.get(index); }
} 
