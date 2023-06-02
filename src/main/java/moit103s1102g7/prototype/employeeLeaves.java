package moit103s1102g7.prototype;

import com.opencsv.bean.CsvBindByName;

public class employeeLeaves {
	
	@CsvBindByName(column = "empId", required = true)
	private String empid;
	
	@CsvBindByName( column = "leaveType")
	private String leaveType;
	
	@CsvBindByName( column = "dateFrom")
	private String dateFrom;
	
	@CsvBindByName( column = "dateTo")
	private String dateTo;
	
	@CsvBindByName( column = "availableVL")
	private String availableVL;
	
	@CsvBindByName( column = "availableSL")
	private String availableSL;
	
	@CsvBindByName( column = "availableEL")
	private String availableEL;

	@CsvBindByName( column = "leaveDescription")
	private String leaveDescription;
	
	@CsvBindByName( column = "leaveStatus")
	private String leaveStatus;

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

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getAvailableVL() {
		return availableVL;
	}

	public void setAvailableVL(String availableVL) {
		this.availableVL = availableVL;
	}

	public String getAvailableSL() {
		return availableSL;
	}

	public void setAvailableSL(String availableSL) {
		this.availableSL = availableSL;
	}

	public String getAvailableEL() {
		return availableEL;
	}

	public void setAvailableEL(String availableEL) {
		this.availableEL = availableEL;
	}

	public String getLeaveDescription() {
		return leaveDescription;
	}

	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	@Override
	public String toString() {
		return "employeeLeaves [empid=" + empid + ", leaveType=" + leaveType + ", dateFrom=" + dateFrom + ", dateTo="
				+ dateTo + ", availableVL=" + availableVL + ", availableSL=" + availableSL + ", availableEL="
				+ availableEL + ", leaveDescription=" + leaveDescription + ", leaveStatus=" + leaveStatus + "]";
	}
}
