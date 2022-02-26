package src;

import java.util.Scanner;

import src.command.CancelReservationCommand;
import src.command.Command;
import src.command.MakeReservationCommand;
import src.command.UIToolKit;

public class App {
    public static void main(String args[]) {

        UIToolKit ui = setUpUI();

        handleUserRequests(ui);

    }

    private static UIToolKit setUpUI() {
        UIToolKit uiToolKit = new UIToolKit();

        Command MakeReservationCommand = new MakeReservationCommand();
        Command cancelReservationCommand = new CancelReservationCommand();
        uiToolKit.setCommand(2, MakeReservationCommand);
        uiToolKit.setCommand(3, cancelReservationCommand);

        return uiToolKit;
    }

    private static void handleUserRequests(UIToolKit ui) {
        /*
         * 0 - exit
         * 1 - welcome
         * 2 - book
         * 3 - cancel
         * 4 - change
         * 5 - view
         */

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        String[] instructions = loadInstructions();
        int userRequest = 2;

        boolean requestHandled = false;

        while (!requestHandled) {
            System.out.print(instructions[userRequest]);
            ui.executeCommand(userRequest);
            userRequest = Integer.parseInt(scanner.nextLine());
        }

        scanner.close();
    }

    private static String[] loadInstructions() {
        String[] instructions = new String[6];
        instructions[0] = "Thank you for using Reservify, hope to see you soon.";
        instructions[1] = "What would you like to do? 1. Make a reservation, 2. Cancel an existing reservation, 3. View existing reservations, 4. change an existing reservation. TYPE 0 to exit the system anytime.";
        instructions[2] = "The available reservations are: " + getReservations()
                + "Please enter the number of the reservation you would like to make.";
        instructions[3] = "Which of your reservations would you like to cancel?" + getUserReservations();
        instructions[4] = "Which of your reservations would you like to change?" + getUserReservations();
        instructions[5] = "Your existing reservations are: " + getUserReservations();
        return instructions;
    }

    private static String getReservations() {
        return "";
    }

    private static String getUserReservations() {
        return "";
    }
}
