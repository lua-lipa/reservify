package Reservation;

import java.util.ArrayList;

public class ReservationFactory {
    private ArrayList<Reservation> prototypes;

    public ReservationFactory() {
        prototypes = new ArrayList<Reservation>();
    }

    public void registerReservation(Reservation reservation) {
        prototypes.add(reservation);
    }

    public Reservation createReservation(int index) {
        return prototypes.get(index).clone();
    }

    public ArrayList<Reservation> getReservations() {
        return prototypes;
    }

    public String getReservationOptions() {
        //Reservation Types: []
        String str = "Reservation Types";
        for (int i = 0; i < prototypes.size(); i++) {
            Reservation r = prototypes.get(i);
            str += " [" + i + "] " + r.getReservationType().toString();
        }
        return str;
    }

    // Reservation reservation = new RecurringReservation(new EarlyBooking());
}