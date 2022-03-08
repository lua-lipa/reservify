package Interceptor;

public class LoggingInterceptor implements Interceptor{
    ContextObject co;
    String triggerEvent;
    
    public LoggingInterceptor(String triggerEvent){
        this.triggerEvent = triggerEvent;
    }

    public void setContextObject(ContextObject co){
        this.co = co;
    }

    public void execute(){
        System.out.println(co.getStatus());
    }

    public String getTriggerEvent(){
        return this.triggerEvent;
    }

}
