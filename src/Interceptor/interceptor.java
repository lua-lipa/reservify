package Interceptor;

public interface interceptor {
    public void execute();
    public void setContextObject(contextObject co);
    public contextObject getContextObject();
    public String getTriggerEvent();
}

