package Visitor;

import Reservation.Reservation;

public interface Visitor {
    public void visit(Reservation reservation);
}
