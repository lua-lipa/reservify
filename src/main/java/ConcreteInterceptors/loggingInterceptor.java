package ConcreteInterceptors;

import Interceptor.contextObject;
import Interceptor.interceptor;

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
            System.out.println();
            System.out.println("************************* LOG *************************");
            System.out.println(co.getDateTime());
            System.out.println(co.getLocation());
            System.out.println(co.getDescription());
            System.out.println("*******************************************************");
            System.out.println();
        } else {
            if(this.nextInChain == null){
                System.out.println("No more interceptors in chain, stopped at logging interceptor.");
            } else {
                this.nextInChain.execute(request);
            }
        }
    }

    public String getTriggerEvent() {
        return this.triggerEvent;
    }

    public void setNextChain(interceptor nextInChain) {
        this.nextInChain = nextInChain;
    }

}
