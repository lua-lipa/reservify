package src.command;

import java.util.HashMap;

public class UIToolKit {
    private HashMap<String, Command> commands;

    public UIToolKit() {
        commands = new HashMap<>();
    }

    public void setCommand(String operation, Command command) {
        commands.put(operation, command);
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    public void executeOperation(String operation) {
        Command command = commands.get(operation);
        command.execute();
    }

}
