

import java.util.*;

public class mobileApp implements Observer{
    private int appNum;
    private List<Road> roads = new ArrayList<Road>();
    private City city;
    
    public mobileApp(int appNum, List<Road> roads, City city){
        this.appNum = appNum;
        this.roads = roads;
        this.city = city;
    }
    
    @Override
    public void update(List<Road> roads){
        this.roads = roads;
    }
    
	@Override
    public void printInfo(){
        System.out.println("Mobile App number: " + appNum);
        System.out.println("City: " + city.getName());
        for(int i = 0; i < roads.size(); i++){
            Road tempRoad= roads.get(i);
            System.out.print(tempRoad.getNorthStatus() + "(NB) - ");
            if(tempRoad.getNorthAdvisory() != "")
                System.out.print("!" + tempRoad.getNorthAdvisory() + "! - ");
            System.out.print(tempRoad.getName() + " - ");
            if(tempRoad.getSouthAdvisory() != "")
                System.out.print("!" + tempRoad.getSouthAdvisory() + "! - ");
            System.out.println("(SB)" + tempRoad.getNorthStatus());
        }
        System.out.println();
    }
}
