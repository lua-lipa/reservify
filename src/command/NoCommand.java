package Command;

public class NoCommand implements Command {

    public NoCommand() {
        System.out.println("No command constructor");
    }

    public void execute() {
    }

    public void undo() {
    }

}
