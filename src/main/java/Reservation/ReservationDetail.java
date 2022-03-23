package Reservation;

import java.time.LocalDateTime;

import Event.Event;

public class ReservationDetail<T> {
    private Class<T> dataClass;
    private String name;
    private String type;
    private Object value;
    private Event event;

    public ReservationDetail() {
    }

    public ReservationDetail(Class<T> dataClass, String name, String type, Event event) {
        if (type.equals("Integer") ||
                type.equals("String") ||
                type.equals("Date") ||
                type.equals("Double")) {
            this.type = type;
            this.name = name;
            this.dataClass = dataClass;
            this.event = event;
            this.event.setEventInfo("In ReservationDetail class", "Creating a reservation detail object", LocalDateTime.now());
            this.event.trigger();
        } else {
            // error
        }
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public T getValue() {
        return dataClass.cast(this.value);
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void print(){
        String str = "";
        if(getValue() == null){
            str = getName() + ": null";
        } else {
            str = getName() + ": " + getValue().toString();
        }
        System.out.println(str);
    }
}