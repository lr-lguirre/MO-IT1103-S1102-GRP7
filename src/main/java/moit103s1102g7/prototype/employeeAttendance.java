package moit103s1102g7.prototype;

import com.opencsv.bean.CsvBindByName;

public class employeeAttendance {

	@CsvBindByName( column = "Employee #")
	private String empid;
	
	@CsvBindByName( column = "Last Name")
	private String empLName;
	
	@CsvBindByName( column = "First Name")
	private String empFName;
	
	@CsvBindByName( column = "Date")
	private String date;
	
	@CsvBindByName( column = "Time-in")
	private String timein;
	
	@CsvBindByName( column = "Time-out")
	private String timeout;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpLName() {
		return empLName;
	}

	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimein() {
		return timein;
	}

	public void setTimein(String timein) {
		this.timein = timein;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "employeeAttendance [empid=" + empid + ", empLName=" + empLName + ", empFName=" + empFName + ", date="
				+ date + ", timein=" + timein + ", timeout=" + timeout + "]";
	}
	
}
