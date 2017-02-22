package emailwidget;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToObject { 
    
    private List<CSVcontact> acctList = new ArrayList<CSVcontact>();
  
    public void convertCsvToJava() {  
        String csvFileToRead = "src/emailwidget/Local.csv";  
        BufferedReader br = null;  
        String line = "";  
        String splitBy = ",";    

        try {  

            br = new BufferedReader(new FileReader(csvFileToRead));  
            while ((line = br.readLine()) != null) {  
               // split on comma(',')  
               String[] acct = line.split(splitBy);  

               // create Account object to store values  
               CSVcontact acctObject = new CSVcontact();  

               // add values from csv to Account object  
               acctObject.setName(acct[0]);  
               acctObject.setAge(acct[1]);  
               acctObject.setGender(acct[2]);  
               acctObject.setWorkPlace(acct[3]);  
               acctObject.setJob(acct[4]);  

               // adding Account objects to a list  
               acctList.add(acctObject);  

            }  
            // print values stored in acctList  
            //printAcctList(acctList);  

        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (br != null) {  
                try {  
                    br.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
    
    public List<CSVcontact> getContacts(){
        return acctList;
    }
  
    public void printAcctList(List<CSVcontact> acctListToPrint) {  
        for (int i = 0; i < acctListToPrint.size(); i++) {  
            System.out.println(acctListToPrint.get(i).getName() + "\n" 
              + acctListToPrint.get(i).getAge() + "\n" 
              + acctListToPrint.get(i).getGender() + "\n"  
              + acctListToPrint.get(i).getWorkPlace() + "\n" 
              + acctListToPrint.get(i).getJob() + "\n");  
        }  
    }
}  

