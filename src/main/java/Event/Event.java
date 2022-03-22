package Event;

import java.time.LocalDateTime;

public interface Event {

    public void setEventInfo(String location, String description, LocalDateTime datetime);
    public void trigger();

}