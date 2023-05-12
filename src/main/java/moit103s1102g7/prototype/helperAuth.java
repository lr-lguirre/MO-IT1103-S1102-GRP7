package moit103s1102g7.prototype;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class helperAuth {
	static List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();
	static List<adminUsers> adminUsers = readCsvFiles.adminUsers();

	public static boolean admAuth (String username, char[] pass) {
		boolean authenticated = false;
		adminUsers searchUser = adminUsers.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
		if(searchUser != null) {
			char[] password = searchUser.getPassword().toCharArray();
			if (Arrays.equals(pass, password)) {
				authenticated = true;
			}
		}
		return authenticated;
	}
	
	public static boolean empAuth (String username, char[] pass) {
		boolean authenticated = false;
		List<employeeLogin> employeeLogin = readCsvFiles.employeeLogin();
		employeeLogin searchUser = employeeLogin.stream().filter(u -> u.getEmpid().equals(username)).findFirst().orElse(null);
		if(searchUser != null) {
			char[] password = searchUser.getPassword().toCharArray();
			if (Arrays.equals(pass, password)) {
				authenticated = true;
			} else {
				JpNewUser newUserFrame = new JpNewUser(username);
				newUserFrame.setVisible(true);
			}
		}
		return authenticated;
	}
	
	public static boolean authenticate(String username, char[] password) {
	    boolean authenticated = false;
	    if (username.matches("\\d{5}")) {
			employeeDetails searchUser = employeeDetails.stream().filter(u -> u.getEmpid().equals(username)).findFirst().orElse(null);
			if (searchUser == null) {
				JpNewUser frame = new JpNewUser(username);
				frame.setVisible(true);
			} else {
	        authenticated = empAuth(username, password); 
			}
	    } else {
	        authenticated = admAuth(username, password);
	    }
	    return authenticated;
	}
	
	public static void empSignUp () {
		
	}
}
