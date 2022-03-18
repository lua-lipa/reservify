package Command;

import java.util.HashMap;

import Reservation.ReservationFactory;

public class UIToolkit {
    final int UNDO_INDEX = 0;
    private HashMap<Integer, Command> commands;
    private Command previousCommand;
    private ReservationFactory rf;

    public UIToolkit() {
        commands = new HashMap<>();
        previousCommand = new NoCommand();
        this.setCommand(UNDO_INDEX, previousCommand);
    }

    public void setCommand(int commandIndex, Command command) {
        commands.put(commandIndex, command);
    }

    public void setCommands(HashMap<Integer, Command> commands) {
        this.commands = commands;
    }

    private boolean undoButtonPressed(int command_index) {
        return command_index == UNDO_INDEX;
    }

    public boolean executeCommand(int commandIndex) {
        boolean systemExited = false;

        Command command = commands.get(commandIndex);
        if (undoButtonPressed(commandIndex)) {
            previousCommand.undo();
        } else {
            previousCommand = command;
            systemExited = command.execute(rf);
        }

        return systemExited;
    }

    public String getCommandOptions() {
        // Command Types: []
        String str = "Command Types [0] Undo ";
        for (int i = 1; i < commands.size(); i++) {
            Command c = commands.get(i);
            str += " [" + i + "] " + c.getCommandTitle().toString();
        }
        return str;
    }

    public void registerReservationFactory(ReservationFactory rf) {
        this.rf = rf;
    }

}
