package Interceptor;

public class loggingInterceptor implements interceptor {
    contextObject co;
    String triggerEvent;
    interceptor nextInChain;

    public loggingInterceptor(String triggerEvent) {
        this.triggerEvent = triggerEvent;
    }

    public void setContextObject(contextObject co) {
        this.co = co;
    }

    public void execute(String request) {
        if (request.equals("log")) {
            System.out.println(co.getStatus());
        } else {
            this.nextInChain.execute(request);
        }
    }

    public String getTriggerEvent() {
        return this.triggerEvent;
    }

    public void setNextChain(interceptor nextInChain) {
        this.nextInChain = nextInChain;
    }

}
