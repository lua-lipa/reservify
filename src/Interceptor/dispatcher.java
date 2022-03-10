package Interceptor;
import java.util.*;

public class Dispatcher {
    List<Interceptor> interceptors;
    
    public Dispatcher(){
        this.interceptors = new ArrayList<>();
    }

    public void register(Interceptor i){
        ContextObject co = new ContextObject();
        i.setContextObject(co);
        this.interceptors.add(i);
    }
  
    public void remove(Interceptor i){
        this.interceptors.remove(i);
    }

    public void event(String event, String trigger){
        for(int i = 0; i < interceptors.size(); i++){
            if(this.interceptors.get(i).getTriggerEvent().equals(trigger)){
                ContextObject co = this.interceptors.get(i).getContextObject();
                co.setStatus(event);
                this.interceptors.get(i).execute();
                break;
            }
        }
    }

}

