package Reservation;

import java.util.Date;

public class ReservationDetail {
    private String name;
    private Object type;
    private Object value;
    
    public ReservationDetail(String name, Object type) {
        this.name = name;
        this.type = type;
    }

    public void castType() {
        if (this.type instanceof Integer) {
            this.type = (int) type;
         } else if (this.type instanceof String) {
            this.type = (String) type;
         } else if (type instanceof Date) {
            this.type = (Date) type;
         } else if (type instanceof Double) {
            this.type = (double) type;
         }
    }

    public String getName() {
        return this.name;
    }

    public Object getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}