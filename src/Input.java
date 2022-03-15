import java.util.Scanner;

public class Input {
    private static Input instance = new Input();
    private Scanner scanner = new Scanner(System.in);

    private Input(){}

    public static Input getInstance() {
        return instance;
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
