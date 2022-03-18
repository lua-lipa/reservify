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
    private HashMap<Integer, Command> mementoCommands;
    private Command previousCommand;
    private ReservationFactory rf;
    private Reservation reservation;
    private Originator originator;
    private Caretaker caretaker;

    public UIToolkit() {
        commands = new HashMap<>();
        mementoCommands = new HashMap<>();
        previousCommand = new NoCommand();
        this.setCommand(UNDO_INDEX, previousCommand);
    }

    public void setCommand(int commandIndex, Command command) {
        commands.put(commandIndex, command);
    }

    public void setMementoCommand(int commandIndex, Command command) {
        mementoCommands.put(commandIndex, command);
    }

    public void setCommands(HashMap<Integer, Command> commands) {
        this.commands = commands;
    }

    public void setMementoCommands(HashMap<Integer, Command> mementoCommands) {
        this.mementoCommands = mementoCommands;
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

    public boolean executeMementoCommand(int commandIndex) {
        Command command = mementoCommands.get(commandIndex);
        boolean systemExited = command.mementoExecute(originator, caretaker, this, reservation);
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

    public String getMementoCommandOptions() {
        // Command Types: []
        String str = "Command Types ";
        for (int i = 0; i < mementoCommands.size(); i++) {
            Command c = mementoCommands.get(i);
            str += " [" + i + "] " + c.getCommandTitle().toString();
        }
        str += " [" + 1 + "] continue";
        return str;
    }

    public void requestUserInput(Reservation newReservation, Originator newOriginator, Caretaker newCaretaker) {
        //originator should be called here?
        this.reservation = newReservation;
        this.originator = newOriginator;
        this.caretaker = newCaretaker;
        ArrayList<ReservationDetail<?>> rd = reservation.getReservationDetails();
        Input input = Input.getInstance();
        boolean wait;
        
        for (int i = 0; i < rd.size(); i++) {
            wait = true;
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

            while(wait){
                int command_index = input.getInt(getMementoCommandOptions());
                boolean sessionExited = true;
                if(command_index == 0){
                    i--;
                    sessionExited = executeMementoCommand(command_index);
                } else {
                    wait = false;
                }
                if(sessionExited){
                    System.out.println("Reservation Details: ");
                    for (int j = 0; j < rd.size(); j++) {
                        ReservationDetail<?> reservationDetail = rd.get(j);
                        reservationDetail.print();
                    }
                    wait = false;
                }
            }

        }
    }

    public void registerReservationFactory(ReservationFactory rf) {
        this.rf = rf;
    }

}
