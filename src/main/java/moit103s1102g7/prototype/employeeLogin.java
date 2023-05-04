package moit103s1102g7.prototype;

import com.opencsv.bean.CsvBindByName;

public class employeeLogin {
	
	@CsvBindByName( column = "empid")
	private String empid;
	
	@CsvBindByName( column = "password")
	private String password;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "employeeLogin [empid=" + empid + ", password=" + password + "]";
	}

}
