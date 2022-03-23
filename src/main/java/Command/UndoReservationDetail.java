package Command;
import Reservation.Reservation;
import Reservation.ReservationDetail;
import Reservation.ReservationFactory;
import Memento.Originator;

import java.util.ArrayList;

import Memento.Caretaker;

public class UndoReservationDetail implements Command{
    public boolean execute(ReservationFactory rf, UIToolkit ui){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        if(originator.getCurrentReservationIndex() >= 1){
			originator.decrementCurrentReservation();
            int ind = originator.getCurrentReservationIndex();
            ArrayList<ReservationDetail<?>> res = originator.restoreFromMemento(caretaker.getMemento(ind));
            reservation.setReservationDetails(res);
            //call something to print out the details
        } else {
            System.out.println("You must make a reservation first.");
        }
        return true;
    }

    public void undo(){}

    public String getCommandTitle(){return "Undo Reservation Detail";}
}
