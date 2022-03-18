package Reservation;

import java.util.ArrayList;
import java.util.Date;

import Input.Input;

abstract public class Reservation implements Cloneable {
    private ArrayList<ReservationDetail<?>> ReservationDetails = new ArrayList<ReservationDetail<?>>();
    
    public Reservation clone() {
        Reservation reservation;
        try {
            reservation = (Reservation) super.clone();
        } catch (CloneNotSupportedException e) {
            reservation = null;
        }
        return reservation;
    }

    abstract void reserve();

    public abstract String getReservationType();

    public void createDetail(String name, String type) {
        //type must be Integer, String, Double or Date
        ReservationFactory rf = new ReservationFactory();
        ReservationDetail<?> rd = rf.createReservationDetail("name", "Integer");
        ReservationDetails.add(rd);
    }

    public void requestUserInput() {
        Input input = Input.getInstance();
        for (int i = 0; i < ReservationDetails.size(); i++) {
            ReservationDetail<?> r = ReservationDetails.get(i);
            String type = r.getType();

            if (type.equals("Integer")) {
                int res = input.getInt("Enter " + r.getName());
                r.setValue(res);
             } else if (type.equals("String")) {
                String res = input.getString("Enter " + r.getName());
                r.setValue(res);
             } else if (type.equals("Double")) {
                Double res = input.getDouble("Enter " + r.getName());
                r.setValue(res);
             } else if (type.equals("Date")) {
                String res = input.getDate("Enter " + r.getName());
                r.setValue(res);
             }
        }
    }

    public ArrayList<ReservationDetail<?>> getReservationDetails() {
        return ReservationDetails;
    }
}