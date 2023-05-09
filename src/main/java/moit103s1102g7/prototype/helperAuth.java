package moit103s1102g7.prototype;

import java.util.Arrays;
import java.util.List;

public class helperAuth {

	public static boolean admAuth (String username, char[] pass) {
		boolean authenticated = false;
		List<adminUsers> adminUsers = readCsvFiles.adminUsers();
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
			}
		}
		return authenticated;
	}
	
	public static boolean authenticate(String username, char[] password) {
	    boolean authenticated = false;
	    if (username.matches("\\d{5}")) {
	        authenticated = empAuth(username, password);
	    } else {
	        authenticated = admAuth(username, password);
	    }
	    return authenticated;
	}
}
