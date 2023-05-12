package moit103s1102g7.prototype;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVWriter;


public class writeCsvFiles {
	    
	public static void empLogin(List<employeeLogin> loginDetails) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("employeeLogin.csv"));

        // Write header
        writer.writeNext(new String[] {"empid", "password"});

        // Write objects
        for (employeeLogin emp : loginDetails) {
            writer.writeNext(new String[] {emp.getEmpid(), emp.getPassword()});
        }

        // Close writer
        writer.close();
    }
}
	

