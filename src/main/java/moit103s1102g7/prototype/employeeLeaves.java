package moit103s1102g7.prototype;

import com.opencsv.bean.CsvBindByName;

public class employeeLeaves {

	@CsvBindByName( column = "empid")
	private String empid;

	@CsvBindByName( column = "leaveType")
	private String leaveType;
	
	@CsvBindByName( column = "leaveDate")
	private String leaveDate;
	
	@CsvBindByName( column = "leaveDays")
	private String leaveDays;
	
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(String leaveDays) {
		this.leaveDays = leaveDays;
	}

	@Override
	public String toString() {
		return "employeeLeaves [empid=" + empid + ", leaveType=" + leaveType + ", leaveDate=" + leaveDate
				+ ", leaveDays=" + leaveDays + "]";
	}
}
