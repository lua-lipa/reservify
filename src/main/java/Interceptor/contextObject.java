package Interceptor;

import java.time.LocalDateTime;

public class contextObject {
    String location;
    String description;
    LocalDateTime datetime;

    public contextObject()  {
        this.location = "";
        this.description = "";
        this.datetime = null;
    }

    public void setLocation(String s) {
        this.location = s;
    }

    public String getLocation() {
        return this.location;
    }

    public void setDescription(String s) {
        this.description = s;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDateTime(LocalDateTime s) {
        this.datetime = s;
    }

    public LocalDateTime getDateTime() {
        return this.datetime;
    }
}