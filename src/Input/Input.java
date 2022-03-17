package Input;

import java.util.Date;
import java.util.Scanner;

public class Input {
    private static Input instance = new Input();
    private Scanner scanner = new Scanner(System.in);

    private Input(){}

    public static Input getInstance() {
        return instance;
    }

    public Object requestInputForType(String name, Object type) {
        System.out.println("Please enter " + name);

        if (type instanceof Integer) {
            //scan for int
         } else if (type instanceof String) {
            //scan for string
         } else if (type instanceof Date) {
            //scan for date
         } else if (type instanceof Double) {
            //scan for double
         }

         return "LOL";
    }


    //show a prompt
    //wait for valid int
    public int getInt(String sPrompt) {
        System.out.println(sPrompt);
        while(!scanner.hasNextInt()) {
            System.out.println("Please print a valid input");
            System.out.println(sPrompt);
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    
}
