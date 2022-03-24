package Interceptor;

public interface interceptor {
    public void execute(String request);

    public void setContextObject(contextObject co);

    public String getTriggerEvent();

    public void setNextChain(interceptor nextInChain);

    public interceptor getNextInChain();
}
