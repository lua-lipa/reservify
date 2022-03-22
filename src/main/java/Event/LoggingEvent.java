package Event;

import Interceptor.*;
import java.time.LocalDateTime;

public class LoggingEvent implements Event {
    //Log the time, date, Location, Description
    String location;
    String description;
    LocalDateTime datetime;
    contextObject co;
    dispatcher dispatcher;

    public LoggingEvent(contextObject co, dispatcher dispatcher){
        this.co = co;
        this.dispatcher = dispatcher;
    }

    public void setEventInfo(String location, String description, LocalDateTime datetime){
        this.location = location;
        this.description = description;
        this.datetime = datetime;
    }

    public void trigger(){
        co.setDateTime(datetime);
        co.setDescription(description);
        co.setLocation(location);
        dispatcher.event("log");
    }
}
