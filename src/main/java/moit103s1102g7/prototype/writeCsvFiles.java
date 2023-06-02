package moit103s1102g7.prototype;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;

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

	
	/*
	 * public static void empDetails(List<employeeDetails> employeeDetails) throws
	 * IOException { CSVWriter writer = new CSVWriter(new
	 * FileWriter("employeeDetails.csv", true)); List<String[]> newRecords = new
	 * ArrayList<>(); for (employeeDetails emp : employeeDetails) {
	 * newRecords.add(new String[] { emp.getEmpPhone(), emp.getEmpAddress() }); }
	 * writer.writeAll(newRecords); writer.close(); }
	 */
	 
	public static void empDetails(List<employeeDetails> empDetails) throws IOException, CsvException {
	    List<String[]> records = new ArrayList<>();
	    File file = new File("employeeDetails.csv");
	    boolean exists = file.exists();
	    if (exists) {
	        CSVReader reader = new CSVReader(new FileReader(file));
	        try {
	            String[] headers = reader.readNext();
	            if (headers != null) {
	                records.add(headers);
	            }
	            records.addAll(reader.readAll());
	        } catch (CsvValidationException | IOException e) {
	            e.printStackTrace();
	        } finally {
	            reader.close();
	        }
	    }
	        
		for (employeeDetails emp : empDetails) {
			String uid = emp.getEmpid();
			for (String[] record : records) {
				if (record[0].equals(uid)) { // Check if UID matches
					// Update the fields of the matching record
					record[1] = emp.getEmpFName();
					record[2] = emp.getEmpLname();
					record[3] = emp.getEmpBdate();
					record[4] = emp.getEmpAddress();
					record[5] = emp.getEmpPhone();
					record[6] = emp.getEmpSSS();
					record[7] = emp.getEmpPhilhealth();
					record[8] = emp.getEmpTIN();
					record[9] = emp.getEmpPagibig();
					record[10] = emp.getEmpStatus();
					record[11] = emp.getEmpPosition();
					record[12] = emp.getEmpSupervisor();
					record[13] = emp.getEmpSalary();
					record[14] = emp.getEmpRice();
					record[15] = emp.getEmpPhoneAllowance();
					record[16] = emp.getEmpClothing();
					record[17] = emp.getEmpSemi();
					record[18] = emp.getEmpRate();
					break;
				}
			}
		}
	    CSVWriter writer = new CSVWriter(new FileWriter(file));
	    writer.writeAll(records);
	    writer.close();
	}

	public static void updateLeaves(List<employeeLeaves> leavesList) throws Exception {
		CSVReader reader = new CSVReader(new FileReader("leaves.csv"));
	    String[] headers = reader.readNext();
	    reader.close();
	    List<String[]> newRecords = new ArrayList<>();
	    if (headers != null) {
            newRecords.add(headers);
        }
	    for (employeeLeaves emp : leavesList) {
	        newRecords.add(new String[] { emp.getEmpid(), emp.getLeaveType(), emp.getDateFrom(), emp.getDateTo(),
	                emp.getAvailableVL(), emp.getAvailableSL(), emp.getAvailableEL(), emp.getLeaveDescription(),
	                emp.getLeaveStatus() });
	    }

	    // Create a new StringWriter to store the modified contents
	    StringWriter writer = new StringWriter();

	    // Write the existing records (including the header) to the StringWriter
	    CSVWriter csvWriter = new CSVWriter(writer);
	   
	    // csvWriter.writeAll(existingRecords);

	    // Write the new records to the StringWriter
	    csvWriter.writeAll(newRecords);
	    csvWriter.close();

	    // Write the modified contents back to the CSV file
	    FileWriter fileWriter = new FileWriter("leaves.csv");
	    fileWriter.write(writer.toString());
	    fileWriter.close();
	}

}
	
