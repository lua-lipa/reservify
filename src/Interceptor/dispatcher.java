package src.Interceptor;
import java.util.*;

public class dispatcher {
    List<interceptor> interceptors;
    
    public dispatcher(){
        this.interceptors = new ArrayList<>();
    }

    public void register(interceptor i, contextObject co){
        i.setContextObject(co);
        this.interceptors.add(i);
    }

    public void remove(interceptor i){
        this.interceptors.remove(i);
    }

    public void callback(String event){
        for(int i = 0; i < interceptors.size(); i++){
            if(this.interceptors.get(i).getTriggerEvent().equals(event)){
                this.interceptors.get(i).execute();
                break;
            }
        }
    }

}
