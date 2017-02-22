

public class trafficStatus {
    private String status;
    
    public trafficStatus(){
        this.status = "not set";
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(int i){
        switch(i){
            case 1: status = "Light";
                    break;
            case 2: status = "Medium";
                    break;
            case 3: status = "Heavy";
                    break;
            default: break;
        }
    }
}
