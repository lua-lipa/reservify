package Input;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    private static Input instance = new Input();
    private Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static Input getInstance() {
        return instance;
    }

    // show a prompt
    // wait for valid int
    public int getInt(String sPrompt) {
        System.out.println(sPrompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please print a valid input");
            System.out.println(sPrompt);
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    public double getDouble(String sPrompt) {
        System.out.println(sPrompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please print a valid input");
            System.out.println(sPrompt);
            scanner.nextLine();
        }
        return scanner.nextDouble();
    }

    public String getString(String sPrompt) {
        System.out.println(sPrompt);
        while (!scanner.hasNextLine()) {
            System.out.println("Please print a valid input");
            System.out.println(sPrompt);
            scanner.nextLine();
        }
        return scanner.next();
    }

    public String getDate(String sPrompt) {
        System.out.println(sPrompt);
        Pattern pattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}", Pattern.MULTILINE);
        while (!scanner.hasNext(pattern)) {
            System.out.println("Please print a valid input");
            System.out.println(sPrompt);
            scanner.nextLine();
        }

        // convert string to date
        return scanner.nextLine();
    }

}
