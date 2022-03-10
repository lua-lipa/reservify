package Interceptor;

public class loggingInterceptor implements interceptor{
    contextObject co;
    String triggerEvent;
    
    public loggingInterceptor(String triggerEvent){
        this.triggerEvent = triggerEvent;
    }

    public void setContextObject(contextObject co){
        this.co = co;
    }

    public contextObject getContextObject(){
        return this.co;
    }

    public void execute(){
        System.out.println(co.getStatus());
    }

    public String getTriggerEvent(){
        return this.triggerEvent;
    }

}
