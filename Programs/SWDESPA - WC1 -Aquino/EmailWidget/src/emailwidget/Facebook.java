package emailwidget;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facebook {

	private String email;
	private String password;

	public Facebook(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Map getDetails() {
		Map details = new HashMap<>();
		
		return details;
	}

	public List<FBAccount> getFriends() {
		List<FBAccount> friends = new ArrayList<FBAccount>();
		
		Path path = Paths.get("src/emailwidget/FBContacts.txt");
		Charset cs = StandardCharsets.UTF_8;
		String temp;
		
		String email, fullName, mobile, profilePic;
		
		try (BufferedReader reader = Files.newBufferedReader(path, cs)) {

			while ((temp = reader.readLine()) != null) {
				email = temp;
				fullName = reader.readLine();
				mobile = reader.readLine();
				profilePic = reader.readLine();
				
				FBAccount acc = new FBAccount(email, fullName, mobile, profilePic);
				friends.add(acc);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		
		return friends;
	}
}

class FBAccount {
	private String email;
	private String fullName;
	private String location;
	private String profilePic;
	
	public FBAccount(String email, String fullName, String location, String profilePic){
		this.setEmail(email);
		this.setFullName(fullName);
		this.setLocation(location);
		this.setProfilePic(profilePic);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String newLine = "\n";
		return profilePic + newLine + fullName + newLine + email + newLine + location + newLine;
	}
}

