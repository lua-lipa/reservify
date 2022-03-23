package Interceptor;

public class welcomeInterceptor implements interceptor{
    contextObject co;
    String triggerEvent;
    interceptor nextInChain;

    public welcomeInterceptor(String triggerEvent) {
        this.triggerEvent = triggerEvent;
    }

    public void setContextObject(contextObject co) {
        this.co = co;
    }

    public void execute(String request) {
        if (request.equals("welcome")) {
            System.out.println();
            System.out.println("********************** RESERVIFY **********************");
            System.out.println(co.getDateTime());
            System.out.println(co.getDescription());
            System.out.println("*******************************************************");
            System.out.println();
        } else {
            if(nextInChain == null){
                System.out.println("No more interceptors in chain, stopped at welcome interceptor.");
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
