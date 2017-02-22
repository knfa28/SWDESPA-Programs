package emailwidget;

import java.util.*;

public class csvAdapter implements Contacts{
    private CsvToObject adaptee;
    private List<CSVcontact> contacts = new ArrayList<CSVcontact>();
    private List<String> details = new ArrayList<String>();
    
    public csvAdapter(){
        adaptee = new CsvToObject();
    }
    
    public List<CSVcontact> getContacts(){
        return adaptee.getContacts();
    }
    
    @Override
    public List<String> getContactDetails(){
        adaptee.convertCsvToJava();
        contacts = adaptee.getContacts();
     
        for(int i = 0; i < contacts.size(); i++){
            details.add(contacts.get(i).toString());
        } 
        
        return details;
    }
}
