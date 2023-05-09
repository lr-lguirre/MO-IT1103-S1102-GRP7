package moit103s1102g7.prototype;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class readCsvFiles {

	public static List<employeeDetails> employeeDetails () {
		String f = "employeedetails.csv";
		FileReader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			CsvToBeanBuilder<employeeDetails> builder = new CsvToBeanBuilder<>(reader);
			List<employeeDetails> csvBeanReader = builder.withType(employeeDetails.class)
					.withIgnoreLeadingWhiteSpace(true)
					.withIgnoreEmptyLine(true)
					.build()
					.parse();
			return csvBeanReader;	
	}
	
	public static List<employeeLogin> employeeLogin () {
		String f = "employeeLogin.csv";
		FileReader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			CsvToBeanBuilder<employeeLogin> builder = new CsvToBeanBuilder<>(reader);
			List<employeeLogin> csvBeanReader = builder.withType(employeeLogin.class)
					.withIgnoreLeadingWhiteSpace(true)
					.withIgnoreEmptyLine(true)
					.build()
					.parse();
			return csvBeanReader;	
	}
	
	public static employeeLogin searchEmployeeByUsername(String username) throws FileNotFoundException{
	    CsvToBean<employeeLogin> csvToBean = new CsvToBeanBuilder<employeeLogin>(new FileReader("employeeLogin.csv"))
	            .withType(employeeLogin.class)
	            .withIgnoreLeadingWhiteSpace(true)
	            .build();
	    employeeLogin searchUser = csvToBean.parse().stream().filter(u -> u.getEmpid().equals(username)).findFirst().orElse(null);
	    return searchUser;
	}
	
	public static List<employeeAttendance> employeeAttendance () {
		String f = "attendance.csv";
		FileReader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			CsvToBeanBuilder<employeeAttendance> builder = new CsvToBeanBuilder<>(reader);
			List<employeeAttendance> csvBeanReader = builder.withType(employeeAttendance.class)
					.withIgnoreLeadingWhiteSpace(true)
					.withIgnoreEmptyLine(true)
					.build()
					.parse();
			return csvBeanReader;	
	}

	public static List<adminUsers> adminUsers () {
		String f = "users.csv";
		FileReader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			CsvToBeanBuilder<adminUsers> builder = new CsvToBeanBuilder<>(reader);
			List<adminUsers> csvBeanReader = builder.withType(adminUsers.class)
					.withIgnoreLeadingWhiteSpace(true)
					.withIgnoreEmptyLine(true)
					.build()
					.parse();
			return csvBeanReader;	
	}
	
	public static adminUsers searchAdminUserByUsername(String username) throws FileNotFoundException{
        CsvToBean<adminUsers> csvToBean = new CsvToBeanBuilder<adminUsers>(new FileReader("adminusers.csv"))
                .withType(adminUsers.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        adminUsers searchUser = csvToBean.parse().stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
        return searchUser;
    }
	
	
	public static List<employeeLeaves> employeeLeaves () {
		String f = "users.csv";
		FileReader reader = null;
		try {
			reader = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			CsvToBeanBuilder<employeeLeaves> builder = new CsvToBeanBuilder<>(reader);
			List<employeeLeaves> csvBeanReader = builder.withType(employeeLeaves.class)
					.withIgnoreLeadingWhiteSpace(true)
					.withIgnoreEmptyLine(true)
					.build()
					.parse();
			return csvBeanReader;
	}
}
