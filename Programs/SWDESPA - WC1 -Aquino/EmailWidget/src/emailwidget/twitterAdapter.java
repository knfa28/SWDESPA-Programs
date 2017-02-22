package emailwidget;

import java.util.*;

public class twitterAdapter implements Contacts{
    
    public Twitter twitter;
    public TwitterAccount tAccount;
    public List<String> details = new ArrayList<String>();
    
    public twitterAdapter(String handle, String email, String password, String fullname){
        twitter = new Twitter(email, password);
        String followers = ""+getFollowers().length;
        String following = ""+getFollowing().length;
        tAccount = new TwitterAccount(handle, email, fullname, "<N/A>", followers, following);
        
    }
    
    public twitterAdapter(String handle, String email, String fullName, String lastTweet, String followers, String following){
        twitter = new Twitter(email, "");
        tAccount = new TwitterAccount(handle, email, fullName, lastTweet, followers, following);
    }
  
    public twitterAdapter[] getFollowing(){
        twitterAdapter[] _following;
        TwitterAccount[] temp = twitter.getFollowing();
        
        _following = new twitterAdapter[twitter.getFollowing().length];
        
        for(int i = 0; i<twitter.getFollowing().length; i++){
            String handle = temp[i].get(0);
            String email = temp[i].get(1);
            String fullName = temp[i].get(2);
            String lastTweet = temp[i].get(3);
            String followers = temp[i].get(4);
            String following = temp[i].get(5);
            
            _following[i] = new twitterAdapter(handle, email, fullName, lastTweet, followers, following);
        }
        
        return _following;
    }
    
    public TwitterAccount[] getFollowers(){
        return twitter.getFollowers();
    }
    
    public String toString(){
       return "<html>" + tAccount.get(2) + "<br/>"
               + tAccount.get(0) + "<br/>"
               + tAccount.get(3) + "<br/> <br/> </html>";
    }
    
    @Override
    public List<String> getContactDetails(){
        twitterAdapter[] following = this.getFollowing();
                
        for(int i = 0; i< following.length; i++)
            details.add(following[i].toString());
        
        return details;
    }
}

