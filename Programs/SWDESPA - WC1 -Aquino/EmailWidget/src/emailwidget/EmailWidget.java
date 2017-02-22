package emailwidget;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmailWidget {
    public static void main(String[] args) {
        List<String> twitterDetails = new ArrayList<String>();
        List<String> googleDetails = new ArrayList<String>();
        List<String> fbDetails = new ArrayList<String>();
        List<String> csvDetails = new ArrayList<String>();
        
        /*
        //API Implementation
        Facebook fb = new Facebook("briane.samson@dlsu.edu.ph", "DLSUCCSRocks!");
	List<FBAccount> friends = fb.getFriends();
        for (Iterator iterator = friends.iterator(); iterator.hasNext();) {
            FBAccount fbAccount = (FBAccount) iterator.next();
            System.out.println(fbAccount);
	}
        
	Twitter t = new Twitter("briane.samson@dlsu.edu.ph", "DLSUCCSRocks!");
	TwitterAccount[] followers = t.getFollowing();
	for (int i = 0; i < followers.length; i++) {
            System.out.println(followers[i]);
	}
        
	GoogleContact gc = new GoogleContact("briane.samson@dlsu.edu.ph", "DLSUCCSRocks!");
	Map<String, String> contacts = gc.getNumbers();
	for(Map.Entry<String, String> entry : contacts.entrySet()){
	    System.out.printf("%s - %s \n", entry.getKey(), entry.getValue());
	}
        */
        /*
        //Adapter Implementation
        fbAdapter fb = new fbAdapter("ptrck.esquillo@gmail.com", "1234", "Patrick Esquillo", "09152824229", "(^_^)");
        fbDetails = fb.getContactDetails();
        for(int i = 0; i < fbDetails.size(); i++)
            System.out.println(fbDetails.get(i));
        
        twitterAdapter t = new twitterAdapter("@esKILLYOU", "ptrck.esquillo@gmail.com", "1234", "Patrick Esquillo");
        twitterDetails = t.getContactDetails();
        for(int i = 0; i < twitterDetails.size(); i++)
            System.out.println(twitterDetails.get(i));
        
        csvAdapter newCSV = new csvAdapter();
        csvDetails = newCSV.getContactDetails();
        for(int i = 0; i < csvDetails.size(); i++)
            System.out.println(csvDetails.get(i));
        
        googleAdapter gc = new googleAdapter("briane.samson@dlsu.edu.ph", "DLSUCCSRocks!");
        googleDetails = gc.getContactDetails();
        for(int i = 0; i < googleDetails.size(); i++)
            System.out.println(googleDetails.get(i));
        */
        
        new emailGUI();
    }
}
