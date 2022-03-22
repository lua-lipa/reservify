package Reservation;

public class ReservationDetail<T> {
    private Class<T> dataClass;
    private String name;
    private String type;
    private Object value;

    public ReservationDetail() {
    }

    public ReservationDetail(Class<T> dataClass, String name, String type) {
        if (type.equals("Integer") ||
                type.equals("String") ||
                type.equals("Date") ||
                type.equals("Double")) {
            this.type = type;
            this.name = name;
            this.dataClass = dataClass;
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
}