package emailwidget;

import java.util.*;
import java.io.*;

public class fbAdapter implements Contacts{
    
    public Facebook fb;
    public FBAccount fbAccount;
    public int numFriends;
    //public List<String> details = new ArrayList<String>();
    
    public fbAdapter(String email, String password, String fullname, String mobileNumber, String profilePic)
    {
        fb = new Facebook(email, password);
        fbAccount = new FBAccount(email, fullname, mobileNumber, profilePic);
        numFriends = 0;
    }
    
    public fbAdapter(String email, String fullname, String mobileNumber, String profilePic)
    {
        fb = new Facebook(email, "");
        fbAccount = new FBAccount(email, fullname, mobileNumber, profilePic);
        numFriends = 0;
    }
    
    public List<fbAdapter> getFriends()
    {
        List<FBAccount> friends =  fb.getFriends();
        List<fbAdapter> newFriends = new ArrayList<fbAdapter>();
        
        for(int i = 0; i<friends.size(); i++)
                {
                    FBAccount fbAccount = friends.get(i);
                    String fullname = fbAccount.getFullName();
                    String email = fbAccount.getEmail();
                    String location = fbAccount.getLocation();
                    String profilePic = fbAccount.getProfilePic();
                    
                    newFriends.add(new fbAdapter(email, fullname, location, profilePic));          
                }
        
        return newFriends;
    }
    
    public int getNumFriends()
    {
        return getFriends().size();
    }
    
    @Override
    public String toString() {       
	return "<html>" + fbAccount.getProfilePic() + "<br/>"
                + fbAccount.getFullName() + "<br/>"
                + fbAccount.getEmail() + "<br/>"
                + fbAccount.getLocation() + "<br/> <br/> </html>";
    }
    
    @Override
    public List<String> getContactDetails(){
        List<fbAdapter> friends = this.getFriends();
        List<String> details = new ArrayList();
        
        for(Iterator i = friends.iterator(); i.hasNext();){
            fbAdapter fbAccount = (fbAdapter) i.next();
            details.add(fbAccount.toString());
        }
        
        return details;
    }
    

    public String txtOnly() {       
	return "<html>" + fbAccount.getFullName() + "<br/>"
                + fbAccount.getEmail() + "<br/>"
                + fbAccount.getLocation() + "<br/> <br/> </html>";
    }
    
    public List<String> getTextDetails(){
        List<fbAdapter> friends = this.getFriends();
        List<String> details = new ArrayList();
        
        for(Iterator i = friends.iterator(); i.hasNext();){
            fbAdapter fbAccount = (fbAdapter) i.next();
            details.add(fbAccount.txtOnly());
        }
        
        return details;
    }
}
