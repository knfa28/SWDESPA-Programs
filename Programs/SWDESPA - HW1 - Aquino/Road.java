

public class Road {
    private String name;
    private trafficStatus northBound;
    private trafficStatus southBound;
    private trafficAdvisory northAdvisory;
    private trafficAdvisory southAdvisory;
    
    public Road(String name){
        this.name = name;
        northBound = new trafficStatus();
        southBound = new trafficStatus();
        northAdvisory = new trafficAdvisory();
        southAdvisory = new trafficAdvisory();
    }
    
    public String getName(){
        return name;
    }
    
    public String getNorthStatus(){
        return northBound.getStatus();
    }
    
    public String getSouthStatus(){
        return southBound.getStatus();
    }
    
    public String getNorthAdvisory(){
        return northAdvisory.getAdvisory();
    }
    
    public String getSouthAdvisory(){
        return southAdvisory.getAdvisory();
    }
    
    public void setNorthStatus(int i){
        northBound.setStatus(i);
    }
    
    public void setSouthStatus(int i){
        southBound.setStatus(i);
    }
    
    public void setNorthAdvisory(int i){
        northAdvisory.setAdvisory(i);
    }
    
    public void setSouthAdvisory(int i){
        southAdvisory.setAdvisory(i);
    }
}