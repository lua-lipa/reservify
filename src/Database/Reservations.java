package Database;

import java.util.ArrayList;

import Reservation.Reservation;

public class Reservations {

    private ArrayList<Reservation> allReservations = new ArrayList<Reservation>();
    private ArrayList<Reservation> userReservations = new ArrayList<Reservation>();

    public Reservations() {
        System.out.println("Reservations database constructor");
    }

    public ArrayList<Reservation> getUserReservations() {
        return this.userReservations;
    }

    private void printUserReservations() {
        for (Reservation reservation : this.userReservations) {
            System.out.println("user reservation");
        }
    }

    public ArrayList<Reservation> getAllReservations() {
        return allReservations;
    }

    public void printAllReservations() {
        for (Reservation reservation : this.allReservations) {
            System.out.println("user reservation");
        }
    }

    public void addBookableReservation(Reservation reservation) {
        allReservations.add(reservation);
    }

    public void addUserReservation(Reservation reservation) {
        userReservations.add(reservation);
        allReservations.remove(reservation);
    }

    public void removeUserReservation(Reservation reservation) {
        userReservations.remove(reservation);
        allReservations.add(reservation);
    }

}
