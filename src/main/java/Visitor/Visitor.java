package Visitor;

import Reservation.Reservation;
import Reservation.ReservationFactory;

public interface Visitor {
    public void visit(ReservationFactory reservationFactory);
}
