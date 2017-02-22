

import java.util.*;

public class webApp implements Observer{ 
    private int appNum;
    private List<Road> roads = new ArrayList<Road>();
    private City city;
    
    public webApp(int appNum, List<Road> roads, City city){
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
        System.out.println("Web App number: " + appNum);
        System.out.println("City: " + city.getName());
        for(int i = 0; i < roads.size(); i++){
            Road tempRoad= roads.get(i);
            System.out.print(tempRoad.getName() + "\t");
            System.out.print(tempRoad.getNorthStatus());
            if(tempRoad.getNorthAdvisory() != "")
                System.out.print("(" + tempRoad.getNorthAdvisory() + ")\t");
            else
                System.out.print("\t");
            System.out.print(tempRoad.getSouthStatus());
            if(tempRoad.getSouthAdvisory() != "")
                System.out.println("(" + tempRoad.getSouthAdvisory() + ")");
            else
                System.out.println();
        }
        System.out.println();
    }
}
