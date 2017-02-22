

import java.util.*;

public class City implements Subject{
    private String name;
    private List<Road> roads = new ArrayList<Road>();
    private List<Observer> observers = new ArrayList<Observer>();
    
    public City(String name, List<Road> r){
        this.name = name;
        this.roads = r;
    }
    
    public String getName(){
        return name;
    }
    
    public List<Road> getRoads(){
        return roads;
    }
    
    public List<Observer> getObservers(){
        return observers;
    }
    
    //for previewing roads only
    public void viewRoads(){
        for(int i = 0; i < roads.size(); i++)
            System.out.println("[" + (i+1) + "] " + roads.get(i).getName());
    }
    
    //for testing only. DO NOT PUT IN CLASS DIAGRAM
    public void viewDetails(){
        for(int i = 0; i < roads.size(); i++){
            System.out.println(roads.get(i).getName());
            System.out.println(roads.get(i).getNorthStatus() + " - " + roads.get(i).getNorthAdvisory());
            System.out.println(roads.get(i).getSouthStatus() + " - " + roads.get(i).getSouthAdvisory() + "\n");
        }
    }
    
    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }
    
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    
    public void update(int index, int northTraffic, int southTraffic, int northAdvisory, int southAdvisory){
        roads.get(index).setNorthStatus(northTraffic);
        roads.get(index).setSouthStatus(southTraffic);
        roads.get(index).setNorthAdvisory(northAdvisory);
        roads.get(index).setSouthAdvisory(southAdvisory);
    }
    
    @Override
    public void NotifyAll(){
        for(int i = 0; i < observers.size(); i++)
            observers.get(i).update(roads);
    }
}
