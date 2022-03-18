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
    private ArrayList<ReservationDetail<?>> ReservationDetails = new ArrayList<ReservationDetail<?>>();

    public BookReservation() {
        this.createDetail("hi", "pls");
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
