package src.Interceptor;

public class ContextObject{
    String status;
    
    public ContextObject(){
        this.status = "";
    }

    public void setStatus(String s){
        this.status = s;
    }

    public String getStatus(){
        return this.status;
    }
}