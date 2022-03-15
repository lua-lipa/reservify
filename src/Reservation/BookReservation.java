package Reservation;

import java.util.ArrayList;

public class BookReservation extends Reservation {
    private String reservationType = "Book";

    public BookReservation() {
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
