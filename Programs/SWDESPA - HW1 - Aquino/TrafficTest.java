
import java.util.*;

public class TrafficTest {
    public static void main(String[] args) {
        int nChoice = 0, nRoad;
        int mobAppCnt = 0, webAppCnt = 0;
        
        Road road1 = new Road("Osmena Boulevard");
        road1.setNorthStatus(3);
        road1.setSouthStatus(1);
        road1.setNorthAdvisory(1);
        road1.setSouthAdvisory(2);
        
        Road road2 = new Road("Colon");
        road2.setNorthStatus(2);
        road2.setSouthStatus(3);
        road2.setNorthAdvisory(2);
        
        Road road3 = new Road("V. Rama");
        road3.setNorthStatus(1);
        road3.setSouthStatus(3);
        road3.setSouthAdvisory(3);
        
        Road road4 = new Road("Marcelo Fernan Bridge");
        road4.setNorthStatus(1);
        road4.setSouthStatus(2);
        
        Road road5 = new Road("Mactan-Mandaue Bridge");
        road5.setNorthStatus(3);
        road5.setSouthStatus(3);
        road5.setNorthAdvisory(4);
        
        List<Road> roadList = new ArrayList<Road>();
        roadList.add(road1);
        roadList.add(road2);
        roadList.add(road3);
        roadList.add(road4);
        roadList.add(road5);
        
        City cebu = new City("Metro Cebu", roadList);
        
        Scanner input = new Scanner(System.in);
        
        while(nChoice != 6){
            System.out.println("Welcome to DOTC Metro Cebu Navigator!");
            System.out.println("[1] Add Mobile App");
            System.out.println("[2] Add Web App");
            System.out.println("[3] Update Northbound of a Road");
            System.out.println("[4] Update Sounthbound of a Road");

            nChoice = Integer.parseInt(input.nextLine());

            switch(nChoice){
                case 1: mobAppCnt++;
                        cebu.addObserver(new mobileApp(mobAppCnt, cebu.getRoads(), cebu));
                        System.out.println("Mobile App number " + mobAppCnt + " has been added!");
                        cebu.NotifyAll();
                        break;
                case 2: webAppCnt++;
                        cebu.addObserver(new webApp(webAppCnt, cebu.getRoads(), cebu));
                        System.out.println("Web App number " + webAppCnt + " has been added!");
                        cebu.NotifyAll();
                        break;
                case 3: System.out.println("Which northbound road?");
                        cebu.viewRoads();
                        nRoad = Integer.parseInt(input.nextLine());
                        setInformation(nRoad - 1, "north", cebu);
                        for(int i = 0; i < cebu.getObservers().size(); i++)
                            cebu.getObservers().get(i).printInfo();
                        //cebu.viewDetails();
                        break;
                case 4: System.out.println("Which southbound road?");
                        cebu.viewRoads();
                        nRoad = Integer.parseInt(input.nextLine());
                        setInformation(nRoad - 1, "south", cebu);
                        for(int i = 0; i < cebu.getObservers().size(); i++)
                            cebu.getObservers().get(i).printInfo();
                        //cebu.viewDetails();
                        break;
                case 5: cebu.viewDetails();
                        break;
            }
        }
    }
    
    public static void setInformation(int index, String bound, City city){
       Scanner input = new Scanner(System.in);
       int nChoice, nStatus;
       
       System.out.println("What information?");
       System.out.println("[1] Traffic Condition");
       System.out.println("[2] Traffic Advisory");
       nChoice = Integer.parseInt(input.nextLine());
       
       if(nChoice == 1){
           System.out.println("How is the traffic?");
           System.out.println("[1] Light");
           System.out.println("[2] Medium");
           System.out.println("[3] Heavy");
           
           nStatus = Integer.parseInt(input.nextLine());
           
           if(bound == "north")
               city.update(index, nStatus, 0, 0, 0);
           else if(bound == "south")
               city.update(index, 0, nStatus, 0, 0);         
       }
       else if(nChoice == 2){
           System.out.println("How is the road condition?");
           System.out.println("[1] An accident has occured");
           System.out.println("[2] Flooded");
           System.out.println("[3] Road repairs ongoing");
           System.out.println("[4] Road is blocked");
           System.out.println("[5] Passable");
           
           nStatus = Integer.parseInt(input.nextLine());
           
           if(bound == "north")
              city.update(index, 0, 0, nStatus, 0);
           else if(bound == "south")
              city.update(index, 0, 0, 0, nStatus);    
       }
    }
}
