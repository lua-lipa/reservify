package Command;

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
  
    public boolean executeCommand(int commandIndex) {
        Command command = commands.get(commandIndex);
        if (command == null) {
            System.out.println("There is no command under the entered index: " + commandIndex);
            return false;
        }
        System.out.println("received command index: " + commandIndex + ": " + command);
        command.execute();
        return true;
    }

}
