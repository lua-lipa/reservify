package src.Reservation;

public class ReservationFactory {

    public Reservation getReservation(Reservation reservation) {
        if (reservation.getReservationType().equals("Single")) {
            return new SingleReservation(null);
        } else if (reservation.getReservationType().equals("Recurring")) {
            return new RecurringReservation(null);
        } else {
            return null;
        }
    }

    // Reservation reservation = new RecurringReservation(new EarlyBooking());
}
