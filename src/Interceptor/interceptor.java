package src.Interceptor;

public interface Interceptor {
    public void execute();
    public void setContextObject(ContextObject co);
    public String getTriggerEvent();
}
