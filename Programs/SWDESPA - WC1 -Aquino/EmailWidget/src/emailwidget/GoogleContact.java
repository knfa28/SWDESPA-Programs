package emailwidget;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GoogleContact {
	private String email;
	private String password;
	private String[] contacts;
	private Map<String, String> mobileNos;
	
	public GoogleContact(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String[] getContacts() {
		return (String[]) mobileNos.keySet().toArray();
	}

	public Map<String, String> getNumbers() {
		mobileNos = new HashMap<String, String>();
		
		Path path = Paths.get("src/emailwidget/GoogleContacts.txt");
		Charset cs = StandardCharsets.UTF_8;
		String temp;
		
		String fullName, mobile;
		
		try (BufferedReader reader = Files.newBufferedReader(path, cs)) {
			while ((temp = reader.readLine()) != null) {
				fullName = temp;
				mobile = reader.readLine();
				
				mobileNos.put(fullName, mobile);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
		
		return mobileNos;
	}
}

