package Command;

public class ExitSystemCommand implements Command {

    public ExitSystemCommand() {
        System.out.println("Exit command constructor");
    }

    public void execute() {
        System.out.println("Exiting the system. Thank you for using reservify.");
    }

}
