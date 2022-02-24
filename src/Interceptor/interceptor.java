package src.Interceptor;

public interface interceptor {
    public void execute();
    public void setContextObject(contextObject co);
    public String getTriggerEvent();
}
