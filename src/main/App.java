package main;

import java.util.Scanner;

import main.Command.*;
import main.Interceptor.*;

public class App {
    static contextObject co;
    static dispatcher dispatcher;

    public static void main(String args[]) {
        // set up interceptor
        co = new contextObject();
        dispatcher = new dispatcher(co);
        interceptor_setup("log", dispatcher);

        UIToolkit ui = setUpUI();
        handleUserRequests(ui);
    }

    private static UIToolkit setUpUI() {
        // interceptor
        callback_method_execution("Setting up UI in setUpUI()");

        UIToolkit uiToolKit = new UIToolkit();

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

    private static void handleUserRequests(UIToolkit ui) {
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

    private static void interceptor_setup(String interceptor_type, dispatcher dispatcher) {
        // Concrete and register interceptor with dispatcher
        if (interceptor_type == "log") {
            interceptor concreteInterceptor = new loggingInterceptor("log");
            dispatcher.register(concreteInterceptor);
        }
    }

    private static void callback_method_execution(String method) {
        co.setStatus(method);
        dispatcher.event("log");
        // System.out.println(method);
    }
}
