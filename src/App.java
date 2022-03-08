
import java.util.Scanner;

import Command.*;
import Interceptor.*;

public class App {
    public static void main(String args[]) {
        UIToolKit ui = setUpUI();
        handleUserRequests(ui);

        // set up interceptor
        Dispatcher dispatcher = new Dispatcher();
        interceptor_setup("logging", dispatcher);
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
        String welcomeMessage = "Hello, Please enter: 0. exit, 1. make a reservation, 2. cancel a reservation 3. change a reservation 4. undo operation";

        while (!requestHandled) {
            System.out.print(welcomeMessage);
            int userRequest = Integer.parseInt(scanner.nextLine());
            requestHandled = ui.executeCommand(userRequest);
        }

        scanner.close();
    }

    private static void interceptor_setup(String interceptor_type, Dispatcher dispatcher) {
        // Concrete and register interceptor with dispatcher
        if (interceptor_type == "logging") {
            Interceptor concreteInterceptor = new LoggingInterceptor("Method executed");
            dispatcher.register(concreteInterceptor);
        }
    }
}
