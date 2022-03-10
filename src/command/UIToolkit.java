package Command;

import java.util.HashMap;

public class UIToolkit {
    private HashMap<Integer, Command> commands;
    private Command undoCommand;

    public UIToolkit() {
        commands = new HashMap<>();
        undoCommand = new NoCommand();
    }

    public void setCommand(int commandIndex, Command command) {
        commands.put(commandIndex, command);
        System.out.println("command set");
    }

    public void setCommands(HashMap<Integer, Command> commands) {
        this.commands = commands;
    }

    public boolean executeCommand(int commandIndex) {
        Command command = commands.get(commandIndex);
        if (commandIndex == 4) { // undo
            System.out.println("undoing the previous request");
            undoCommand.undo();
        } else if (command == null) {
            System.out.println("There is no command under the entered index: " + commandIndex);
            return false;
        }
        System.out.println("received command index: " + commandIndex + ": " + command);
        command.execute();
        undoCommand = command;
        return true;
    }

}
