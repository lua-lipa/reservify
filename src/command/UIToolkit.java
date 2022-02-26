package src.command;

import java.util.HashMap;

public class UIToolKit {
    private HashMap<Integer, Command> commands;

    public UIToolKit() {
        commands = new HashMap<>();
    }

    public void setCommand(int commandIndex, Command command) {
        commands.put(commandIndex, command);
        System.out.println("command set");
    }

    public void setCommands(HashMap<Integer, Command> commands) {
        this.commands = commands;
    }

    public Command getCommand(int commandIndex) {
        return commands.get(commandIndex);
    }

    public void executeCommand(int commandIndex) {
        Command command = commands.get(commandIndex);
        command.execute();
    }

}
