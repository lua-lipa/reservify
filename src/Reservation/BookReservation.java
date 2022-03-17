package Reservation;

import java.util.ArrayList;
import java.util.Date;

import Input.Input;

/*
int
double
string
date



*/

public class BookReservation extends Reservation {
    private String reservationType = "Book";
    //private ReservationDetail<Object> bookId = new ReservationDetail("id");
    private ArrayList<ReservationDetail> ReservationDetails = new ArrayList<ReservationDetail>();


    public BookReservation() {
        this.createDetail("title", (Object) new Integer());
    }

    public void createDetail(String name, Object type) {
   
         //error if unsupported type
        
        ReservationDetails.add(new ReservationDetail(name, type));
    }

    public void requestUserInput() {
        Input input = Input.getInstance();
        String str = "Reservation Types";
        for (int i = 0; i < ReservationDetails.size(); i++) {
            ReservationDetail r = ReservationDetails.get(i);
            String name = r.getName();
            Object type = r.getType();
            Object result = input.requestInputForType(name, type);
            r.setValue(result);
        }
    }


    @Override
    void reserve() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getReservationType() {
        return reservationType;
    }
    
}
