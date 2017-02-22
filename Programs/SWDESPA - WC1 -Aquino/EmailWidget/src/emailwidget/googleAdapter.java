package emailwidget;

import java.util.*;

public class googleAdapter implements Contacts{
    public GoogleContact gc;
    public List<String> details = new ArrayList<String>();
    
    public googleAdapter(String email, String password){
        gc = new GoogleContact(email, password);
    }
    
    public String[] getContacts(){
        return gc.getContacts();
    }
    
    public Map<String, String> getNumbers(){
        return gc.getNumbers();
    } 
    
    @Override
    public List<String> getContactDetails(){
        Map<String, String> contacts = this.getNumbers();
        
        for(Map.Entry<String, String> entry : contacts.entrySet())
            details.add("<html>" + entry.getKey() + " - " + entry.getValue() + "<br/> <br/> </html>\"");
        
        return details;
    }
}
