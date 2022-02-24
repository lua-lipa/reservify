package src.Interceptor;
import java.util.*;

public class dispatcher {
    List<interceptor> interceptors;
    
    public dispatcher(){
        this.interceptors = new ArrayList<>();
    }

    public void register(interceptor i, contextObject co){
        this.interceptors.add(i);
    }

    public void remove(interceptor i){
        this.interceptors.remove(i);
    }

    public void callback(){
        // implement iteration here
        this.interceptors.get(0).execute();
    }

}
