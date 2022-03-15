package Reservation;

abstract public class Reservation implements Cloneable {
    
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
}