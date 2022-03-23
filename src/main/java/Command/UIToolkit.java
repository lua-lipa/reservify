package Command;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import Event.Event;
import Input.Input;
import Reservation.ReservationDetail;
import Reservation.ReservationFactory;

public class UIToolkit {
    final int UNDO_INDEX = 0;
    private HashMap<Integer, Command> commands;
    private Command previousCommand;
    private ReservationFactory rf;
    private Event event;

    public UIToolkit(Event event) {
        this.event = event;
        this.event.setEventInfo("In UIToolkit class", "Creating a UI toolkit object", LocalDateTime.now());
        this.event.trigger();
        commands = new HashMap<>();
        previousCommand = new NoCommand(event);
        this.setCommand(UNDO_INDEX, previousCommand);
    }

    public void setCommand(int commandIndex, Command command) {
        this.event.setEventInfo("In UIToolkit class", "Adding a command to the commands hashmap", LocalDateTime.now());
        this.event.trigger();
        commands.put(commandIndex, command);
    }

    public void setCommands(HashMap<Integer, Command> commands) {
        this.event.setEventInfo("In UIToolkit class", "Setting the commands hashmap to new hashmap", LocalDateTime.now());
        this.event.trigger();
        this.commands = commands;
    }

    private boolean undoButtonPressed(int command_index) {
        this.event.setEventInfo("In UIToolkit class", "Setting index of undo command", LocalDateTime.now());
        this.event.trigger();
        return command_index == UNDO_INDEX;
    }

    public boolean executeCommand(int commandIndex) {
        this.event.setEventInfo("In UIToolkit class", "Executing the command at command index passed in as parameter", LocalDateTime.now());
        this.event.trigger();
        boolean systemExited = false;

        Command command = commands.get(commandIndex);
        if (undoButtonPressed(commandIndex)) {
            previousCommand.undo();
        } else {
            previousCommand = command;
            systemExited = command.execute(rf, this);
        }

        return systemExited;
    }

    public String getCommandOptions() {
        this.event.setEventInfo("In UIToolkit class", "Outputting command options", LocalDateTime.now());
        this.event.trigger();
        // Command Types: []
        String str = "Command Types [0] Undo ";
        for (int i = 1; i < commands.size(); i++) {
            Command c = commands.get(i);
            str += " [" + i + "] " + c.getCommandTitle().toString();
        }
        return str;
    }

    public void requestUserInput(ArrayList<ReservationDetail<?>> rd) {
        this.event.setEventInfo("In UIToolkit class", "Setting up input to request user input", LocalDateTime.now());
        this.event.trigger();
        Input input = Input.getInstance();
        for (int i = 0; i < rd.size(); i++) {
            ReservationDetail<?> r = rd.get(i);
            String type = r.getType();

            if (type.equals("Integer")) {
                int res = input.getInt("Enter " + r.getName());
                r.setValue(res);
            } else if (type.equals("String")) {
                String res = input.getString("Enter " + r.getName());
                r.setValue(res);
            } else if (type.equals("Double")) {
                Double res = input.getDouble("Enter " + r.getName());
                r.setValue(res);
            } else if (type.equals("Date")) {
                String res = input.getDate("Enter " + r.getName());
                r.setValue(res);
            }
        }
    }

    public void registerReservationFactory(ReservationFactory rf) {
        this.event.setEventInfo("In UIToolkit class", "Registering the reservation factory object", LocalDateTime.now());
        this.event.trigger();
        this.rf = rf;
    }

}
