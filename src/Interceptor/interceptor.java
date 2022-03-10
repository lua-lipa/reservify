package Interceptor;

public interface Interceptor {
    public void execute();
    public void setContextObject(ContextObject co);
    public ContextObject getContextObject();
    public String getTriggerEvent();
}

