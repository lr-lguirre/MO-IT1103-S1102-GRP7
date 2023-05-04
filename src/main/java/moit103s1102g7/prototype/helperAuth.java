package moit103s1102g7.prototype;

import java.util.List;
import java.util.Arrays;

public class helperAuth {

	public static boolean admAuth (String username, char[] pass) {
		boolean authenticated = false;
		List<adminUsers> adminUsers = readCsvFiles.adminUsers();
		for ( adminUsers ed: adminUsers ) {
			if ( ed.getUsername().equals(username)) {
				char[] password = ed.getPassword().toCharArray();
				if (Arrays.equals(pass, password)) {
					authenticated = true;
				}
			}
		}
		return authenticated;
	}
	
	public static boolean empAuth (String username, char[] pass) {
		boolean authenticated = false;
		List<employeeLogin> employeeLogin = readCsvFiles.employeeLogin();
		
		for ( employeeLogin ed: employeeLogin ) {
			if ( ed.getEmpid().equals(username) && ed.getPassword().equals(String.valueOf(pass))) {
			 authenticated = true;
			}
		}
		return authenticated;
	}
}
