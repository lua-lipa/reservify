
import java.util.Scanner;

import Command.*;

public class App {
    public static void main(String args[]) {
        UIToolKit ui = setUpUI();
        handleUserRequests(ui);

    }

    private static UIToolKit setUpUI() {
        UIToolKit uiToolKit = new UIToolKit();

        Command makeReservationCommand = new MakeReservationCommand();
        Command cancelReservationCommand = new CancelReservationCommand();
        Command changeReservationCommand = new ChangeReservationCommand();
        Command exitSystemCommand = new ExitSystemCommand();

        uiToolKit.setCommand(1, makeReservationCommand);
        uiToolKit.setCommand(2, cancelReservationCommand);
        uiToolKit.setCommand(3, changeReservationCommand);
        uiToolKit.setCommand(0, exitSystemCommand);

        return uiToolKit;
    }

    private static void handleUserRequests(UIToolKit ui) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        boolean requestHandled = false;
        String welcomeMessage = "Hello, Please enter: 0. exit, 1. make a reservation, 2. cancel a reservation 3. change a reservation";

        while (!requestHandled) {
            System.out.print(welcomeMessage);
            int userRequest = Integer.parseInt(scanner.nextLine());
            requestHandled = ui.executeCommand(userRequest);
        }

        scanner.close();
    }

    private static String[] loadInstructions() {
        String[] instructions = new String[6];
        return instructions;
    }

    private static String getReservations() {
        return "";
    }

    private static String getUserReservations() {
        return "";
    }
}
