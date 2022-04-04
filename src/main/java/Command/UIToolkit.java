package Command;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import Event.Event;
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
    private Command mementoCommand;
    private ReservationFactory rf;
    private Event event;
    private Reservation reservation;
    private Originator originator;
    private Caretaker caretaker;

    public UIToolkit(Event event, ReservationFactory rf) {
        this.event = event;
        this.event.setEventInfo("In UIToolkit class", "Creating a UI toolkit object", LocalDateTime.now());
        this.event.trigger();
        commands = new HashMap<>();
        previousCommand = new NoCommand(event);
        mementoCommand = new NoCommand(event);
        this.setCommand(UNDO_INDEX, previousCommand);
        this.rf = rf;

        Command makeReservationCommand = new MakeReservationCommand(event);
        Command cancelReservationCommand = new CancelReservationCommand(event);
        Command changeReservationCommand = new ChangeReservationCommand(event);
        Command exitSystemCommand = new ExitSystemCommand(event);
        Command undoReservationDetailCommand = new UndoReservationDetail(event);

        this.setCommand(1, makeReservationCommand);
        this.setCommand(2, cancelReservationCommand);
        this.setCommand(3, changeReservationCommand);
        this.setCommand(4, exitSystemCommand);
        this.setMementoCommand(undoReservationDetailCommand);
    }

    public void registerReservation(Reservation r) {
        rf.registerReservation(r);
    }

    public void setCommand(int commandIndex, Command command) {
        this.event.setEventInfo("In UIToolkit class", "Adding a command to the commands hashmap", LocalDateTime.now());
        this.event.trigger();
        commands.put(commandIndex, command);
    }

    public void setMementoCommand(Command command) {
        this.mementoCommand = command;
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

    public boolean executeMementoCommand() {
        boolean systemExited = mementoCommand.mementoExecute(originator, caretaker, this, reservation);
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

    public String getMementoCommandOptions() {
        // Command Types: []
        String str = "Command Types ";
        str += " [" + 0 + "] " + mementoCommand.getCommandTitle().toString();
        str += " [" + 1 + "] continue";
        return str;
    }

    public void requestUserInput(Reservation newReservation, Originator newOriginator, Caretaker newCaretaker) {
        this.event.setEventInfo("In UIToolkit class", "Setting up input to request user input", LocalDateTime.now());
        this.event.trigger();
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
            
            while(wait){
                int command_index = input.getInt(getMementoCommandOptions());
                boolean sessionExited = true;
                if(command_index == 0){
                    i--;
                    sessionExited = executeMementoCommand();
                } else {
                    wait = false;
                }
                if(sessionExited){
                    reservation.reserve();
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

    

}
