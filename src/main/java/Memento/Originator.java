package Memento;
import java.util.ArrayList;

import Reservation.Reservation;
import Reservation.ReservationDetail;

public class Originator {
    private ReservationDetail<?> reservationDetail;
	public int savedReservations;
    public int currentReservation;

    public Originator(){
        this.savedReservations = 0;
        this.currentReservation = 0;
    }

    public void incrementSavedReservations(){
        this.savedReservations++;
    }

    public void incrementCurrentReservation(){
        this.currentReservation++;
    }

    public void decrementSavedReservations(){
        this.savedReservations--;
    }

    public void decrementCurrentReservation(){
        this.currentReservation--;
    }

    public int getSavedReservationsIndex(){
        return this.savedReservations;
    }

    public int getCurrentReservationIndex(){
        return currentReservation;
    }

    // Sets the value for the article
    public void setReservationDetail(ReservationDetail<?> res) { 
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
	    return r.clone(); 
	}
	   
	// Gets the article currently stored in memento
	public ArrayList<ReservationDetail<?>> restoreFromMemento(Reservation memento) {
        ArrayList<ReservationDetail<?>> rd = memento.getReservationDetails();
		return rd;
	}
}
