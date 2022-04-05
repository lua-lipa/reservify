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

    public boolean mementoExecute(Originator originator, Caretaker caretaker, UIToolkit ui, Reservation reservation){
        this.event.setEventInfo("In UndoReservationDetail class", "Executing undo reservation detail, allowing the user to input the detail again.", LocalDateTime.now());
        this.event.trigger();
        ArrayList<ReservationDetail<?>> res = originator.restoreFromMemento(caretaker.getMemento());
        if(res == null){
            System.out.println("You must make a reservation first.");
            return false;
        }
        reservation.setReservationDetails(res);
        return true;
    }

    public boolean execute(ReservationFactory rf, UIToolkit ui){
        System.out.println("You shouldn't be using this execute method babes.");
        return true;
    }
    
    public void undo(){}

    public String getCommandTitle(){return "Undo Reservation Detail";}
}
