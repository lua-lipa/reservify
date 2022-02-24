package src;

import java.util.Scanner;

import src.command.Command;
import src.command.LogInCommand;
import src.command.LogOutCommand;
import src.command.Profile;
import src.command.UIToolKit;

public class App {
    public static void main(String args[]) {

        UIToolKit uiToolKit = new UIToolKit();
        Profile profile = new Profile();
        Command logInCommand = new LogInCommand(profile);
        Command logOutCommand = new LogOutCommand(profile);
        uiToolKit.setCommand("Log In", logInCommand);
        uiToolKit.setCommand("Log Out", logOutCommand);
        uiToolKit.executeOperation("Log In");

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Sign in or sign up?");
        String userName = scanner.nextLine(); // Read user input

        scanner.close();
    }
}
