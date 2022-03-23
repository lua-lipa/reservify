package Memento;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Event.Event;
import Reservation.Reservation;
import Reservation.ReservationDetail;

public class Originator {
    private ReservationDetail<?> reservationDetail;
	public int savedReservations;
    public int currentReservation;
    private Event event;

    public Originator(Event event){
        this.savedReservations = 0;
        this.currentReservation = 0;
        this.event = event;
        this.event.setEventInfo("In Originator class", "Creating an originator object", LocalDateTime.now());
        this.event.trigger();
    }

    public void incrementSavedReservations(){
        this.event.setEventInfo("In Originator class", "Incrementing the number of saved reservations", LocalDateTime.now());
        this.event.trigger();
        this.savedReservations++;
    }

    public void incrementCurrentReservation(){
        this.event.setEventInfo("In Originator class", "Incrementing the number of current reservations", LocalDateTime.now());
        this.event.trigger();
        this.currentReservation++;
    }

    public void decrementSavedReservations(){
        this.event.setEventInfo("In Originator class", "Decrementing the number of saved reservations", LocalDateTime.now());
        this.event.trigger();
        this.savedReservations--;
    }

    public void decrementCurrentReservation(){
        this.event.setEventInfo("In Originator class", "Decrementing the number of current reservations", LocalDateTime.now());
        this.event.trigger();
        this.currentReservation--;
    }

    public int getSavedReservationsIndex(){
        return this.savedReservations;
    }

    public int getCurrentReservationIndex(){
        return this.currentReservation;
    }

    public void setReservationDetail(ReservationDetail<?> res) { 
        this.event.setEventInfo("In Originator class", "Updating the reservation details on a reservation", LocalDateTime.now());
        this.event.trigger();
	    this.reservationDetail = res; 
	}

	public void set(String val) { 
	    this.reservationDetail.setValue(val);
	}

    public void set(int val) { 
	    this.reservationDetail.setValue(val);
	}

    public void set(Double val) { 
	    this.reservationDetail.setValue(val);
	}

	// Creates a new Memento with a new article
	public Reservation storeInMemento(Reservation r) {
        this.event.setEventInfo("In Originator class", "Cloniing reservation to save an a memento", LocalDateTime.now());
        this.event.trigger();
	    return r.clone(); 
	}
	   
	// Gets the article currently stored in memento
	public ArrayList<ReservationDetail<?>> restoreFromMemento(Reservation memento) {
        this.event.setEventInfo("In Originator class", "Restorign reservation details", LocalDateTime.now());
        this.event.trigger();
        ArrayList<ReservationDetail<?>> rd = memento.getReservationDetails();
		return rd;
	}
}
