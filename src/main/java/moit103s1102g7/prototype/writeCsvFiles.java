package moit103s1102g7.prototype;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.opencsv.CSVWriter;


public class writeCsvFiles {
	    
	public static void empLogin(List<employeeLogin> loginDetails) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter("employeeLogin.csv", true));
		List<String[]> newRecords = new ArrayList<>();
		for (employeeLogin emp : loginDetails) {
		    newRecords.add(new String[] {emp.getEmpid(), emp.getPassword()});
		}
		writer.writeAll(newRecords);
		writer.close();
    }
}
	

