package moit103s1102g7.prototype;

import java.util.List;

public class ActionAdmAuth {
	public static boolean login (String username, String password) {
		boolean authenticated = false;
		List<adminUsers> adminUsers = readCsvFiles.adminUsers();
		
		for ( adminUsers ed: adminUsers ) {
			if ( ed.getUsername().equals(username) && ed.getPassword().equals(password)) {
			 authenticated = true;
			}
		}
		return authenticated;
	}
	
	public static void main (String[] args) {
		if (login("lawrence","password")) {
			System.out.println("AUthenticated!");
		};
		
	}
    
}
