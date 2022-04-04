package Memento;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Event.Event;
import Reservation.Reservation;
import Reservation.ReservationDetail;

public class Originator {
    private ReservationDetail<?> reservationDetail;
    private Event event;

    public Originator(Event event){
        this.event = event;
        this.event.setEventInfo("In Originator class", "Creating an originator object", LocalDateTime.now());
        this.event.trigger();
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
        this.event.setEventInfo("In Originator class", "Cloning reservation to save an a memento", LocalDateTime.now());
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
