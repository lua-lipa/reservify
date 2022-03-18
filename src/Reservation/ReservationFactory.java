package Reservation;

import java.util.ArrayList;
import java.util.Date;

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

    public ReservationDetail<?> createReservationDetail(String name, String type) {
        ReservationDetail<?> rd = new ReservationDetail<>();
        if (type.equals("Integer")) {
            rd = new ReservationDetail<Integer>(Integer.class, name, type);
         } else if (type.equals("String")) {
            rd = new ReservationDetail<String>(String.class, name, type);
         } else if (type.equals("Date")) {
            rd = new ReservationDetail<Date>(Date.class, name, type);
         } else if (type.equals("Double")) {
            rd = new ReservationDetail<Double>(Double.class, name, type);
         }
         return rd;
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