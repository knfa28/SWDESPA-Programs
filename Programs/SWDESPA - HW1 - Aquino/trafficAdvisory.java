

public class trafficAdvisory {
    private String advisory;
    
    public trafficAdvisory(){
        this.advisory = "";
    }
    
    public String getAdvisory(){
        return advisory;
    }
    
    public void setAdvisory(int i){
        switch(i){
            case 1: advisory = "Accident";
                    break;
            case 2: advisory = "Flood";
                    break;
            case 3: advisory = "Road Repair";
                    break;
            case 4: advisory = "Road Blocking";
                    break;
            case 5: advisory = "";
                    break;
            default: break;
        }
    }
}
