package emailwidget;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Twitter {
	private String email;
	private String password;
	private List<TwitterAccount> info;

	public static int HANDLE = 0;
	public static int EMAIL = 1;
	public static int FULLNAME = 2;
	public static int LASTTWEET = 3;
	public static int FOLLOWERS = 4;
	public static int FOLLOWING = 5;

	public Twitter(String email, String password) {
		this.email = email;
		this.password = password;
		authenticate();
	}

	private void authenticate() {
		setInfo(new ArrayList<TwitterAccount>());
		// authenticate with server and populate the list with details
	}

	public TwitterAccount[] getFollowing() {
		TwitterAccount[] following = null;
		// connect with server and populate the array with twitter handle and
		// full name
		Path path = Paths.get("src/emailwidget/TwitterFollowing.txt");
		Charset cs = StandardCharsets.UTF_8;
		String temp;
		
		String handle, email, fullName, lasttweet, followers, followings;
		
		try (BufferedReader reader = Files.newBufferedReader(path, cs)) {

			int size = Integer.parseInt((String)reader.readLine());
			following = new TwitterAccount[size];
			
			int cnt = 0;
			while ((temp = reader.readLine()) != null) {
				handle = temp;
				email = reader.readLine();
				fullName = reader.readLine();
				lasttweet = reader.readLine();
				followers = reader.readLine();
				followings = reader.readLine();
				
				TwitterAccount acc = new TwitterAccount(handle, email, fullName, lasttweet, followers, followings);
				following[cnt] = acc;
				cnt++;
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		
		return following;
	}

	public TwitterAccount[] getFollowers() {
		TwitterAccount[] followers = null;
		// connect with server and populate the array with twitter handle and
		// full name
		Path path = Paths.get("src/emailwidget/TwitterFollowers.txt");
		Charset cs = StandardCharsets.UTF_8;
		String temp;
		
		String handle, email, fullName, lasttweet, followersStr, followings;
		
		try (BufferedReader reader = Files.newBufferedReader(path, cs)) {

			int size = Integer.parseInt((String)reader.readLine());
			followers = new TwitterAccount[size];
			
			int cnt = 0;
			while ((temp = reader.readLine()) != null) {
				handle = temp;
				email = reader.readLine();
				fullName = reader.readLine();
				lasttweet = reader.readLine();
				followersStr = reader.readLine();
				followings = reader.readLine();
				
				TwitterAccount acc = new TwitterAccount(handle, email, fullName, lasttweet, followersStr, followings);
				followers[cnt] = acc;
				cnt++;
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		
		return followers;
	}

	public List<TwitterAccount> getInfo() {
		return info;
	}

	public void setInfo(List<TwitterAccount> info) {
		this.info = info;
	}
}

class TwitterAccount {
	private String[] info;

	public TwitterAccount(String handle, String email, String fullName, String lastTweet, String followers, String following) {
		info = new String[6];
		info[0] = handle;
		info[1] = email;
		info[2] = fullName;
		info[3] = lastTweet;
		info[4] = followers;
		info[5] = following;
	}

	public String get(int info) {
		return this.info[info];
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String newLine = "\n";
		return info[0] + newLine + info[1] + newLine + info[2] + newLine + info[3] + newLine + info[4] + newLine + info[5] + newLine;
	}
}

