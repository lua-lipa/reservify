package Interceptor;
import java.util.*;

public class dispatcher {
    List<interceptor> interceptors;
    contextObject co;
    
    public dispatcher(contextObject co){
        this.co = co;
        this.interceptors = new ArrayList<>();
    }

    public void register(interceptor i){
        i.setContextObject(this.co);
        this.interceptors.add(i);
    }
  
    public void remove(interceptor i){
        this.interceptors.remove(i);
    }

    public void event(String trigger){
        for(int i = 0; i < interceptors.size(); i++){
            if(this.interceptors.get(i).getTriggerEvent().equals(trigger)){
                this.interceptors.get(i).execute();
                break;
            }
        }
    }

}

