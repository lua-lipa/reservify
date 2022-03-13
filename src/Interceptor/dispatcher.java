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
        if(this.interceptors.size() > 0){
            this.interceptors.get(this.interceptors.size()-1).setNextChain(i);
        }
        i.setContextObject(this.co);
        this.interceptors.add(i);
    }
  
    public void remove(interceptor i){
        this.interceptors.remove(i);
    }

    public void event(String trigger){
        this.interceptors.get(0).execute(trigger);
    }

}

