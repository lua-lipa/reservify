package Command;

import java.util.ArrayList;
import java.util.HashMap;

import Input.Input;
import Reservation.Reservation;
import Reservation.ReservationDetail;
import Reservation.ReservationFactory;

import Memento.Originator;
import Memento.Caretaker;

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
            systemExited = command.execute(rf, this);
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

    public void requestUserInput(Reservation reservation, Originator originator, Caretaker caretaker) {
        //originator should be called here?
        ArrayList<ReservationDetail<?>> rd = reservation.getReservationDetails();
        Input input = Input.getInstance();
        
        for (int i = 0; i < rd.size(); i++) {
            ReservationDetail<?> r = rd.get(i);
            String type = r.getType();
            originator.setReservationDetail(r);

            if (type.equals("Integer")) {
                int res = input.getInt("Enter " + r.getName());
                originator.set(res);
            } else if (type.equals("String")) {
                String res = input.getString("Enter " + r.getName());
                originator.set(res);
            } else if (type.equals("Double")) {
                Double res = input.getDouble("Enter " + r.getName());
                originator.set(res);
            } else if (type.equals("Date")) {
                String res = input.getDate("Enter " + r.getName());
                originator.set(res);
            }
            
            caretaker.addMemento(originator.storeInMemento(reservation));
            originator.incrementCurrentReservation();
            originator.incrementSavedReservations();
        }
    }

    public void registerReservationFactory(ReservationFactory rf) {
        this.rf = rf;
    }

}
