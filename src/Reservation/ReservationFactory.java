package src.Reservation;

public class ReservationFactory {

    public Reservation getReservation(String reservationType) {
        if (reservationType.equalsIgnoreCase("SINGLE")) {
            return new SingleReservation();
        } else if (reservationType.equalsIgnoreCase("RECURRING")) {
            return new RecurringReservation(); 
        } else {
            return null;
        }
    }
    
}
