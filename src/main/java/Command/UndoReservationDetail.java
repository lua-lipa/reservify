package Command;
import Reservation.Reservation;
import Reservation.ReservationDetail;
import Reservation.ReservationFactory;
import Memento.Originator;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Event.Event;
import Memento.Caretaker;

public class UndoReservationDetail implements Command{
    private Event event;
    
    public UndoReservationDetail(Event event){
        this.event = event;
        this.event.setEventInfo("In UndoReservationDetail class", "Creating undo reservation detail command object", LocalDateTime.now());
        this.event.trigger();
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        this.event.setEventInfo("In UndoReservationDetail class", "Executing undo reservation detail, allowing the user to input the detail again.", LocalDateTime.now());
        this.event.trigger();
        if(originator.getCurrentReservationIndex() >= 1){
			originator.decrementCurrentReservation();
            int ind = originator.getCurrentReservationIndex();
            ArrayList<ReservationDetail<?>> res = originator.restoreFromMemento(caretaker.getMemento(ind));
            reservation.setReservationDetails(res);
        } else {
            System.out.println("You must make a reservation first.");
        }
        return true;
    }

    public void undo(){}

    public String getCommandTitle(){return "Undo Reservation Detail";}
}
