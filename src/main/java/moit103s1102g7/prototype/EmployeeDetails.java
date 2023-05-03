package moit103s1102g7.prototype;

import com.opencsv.bean.CsvBindByName;

public class EmployeeDetails {
		
	@CsvBindByName( column = "Employee #")
	private String empid;
	
	@CsvBindByName( column = "First Name")
	private String empFName;
	
	@CsvBindByName( column = "Last Name")
	private String empLname;
	
	@CsvBindByName( column = "Birthday")
    private String empBdate;

	@CsvBindByName( column = "Address")
	private String empAddress;
	
	@CsvBindByName( column = "Phone Number")
	private String empPhone;
	
	@CsvBindByName( column = "SSS #")
	private String empSSS;
	
	@CsvBindByName( column = "Philhealt #")
	private String empPhilhealth;
    
    @CsvBindByName( column = "TIN #")
    private String empTIN;
    
    @CsvBindByName( column = "Pag-ibig #")
    private String empPagibig;
    
    @CsvBindByName( column = "Status")
    private String empStatus;
    
    @CsvBindByName( column = "Position")
    private String empPosition;
    
    @CsvBindByName( column = "Immediate Supervisor")
    private String empSupervisor;
    
    @CsvBindByName( column = "Basic Salary")
    private String empSalary;
    
    @CsvBindByName( column = "Rice Subsidy")
    private String empRice;
    
    @CsvBindByName( column = "Phone Allowance")
    private String empPhoneAllowance;
    
    @CsvBindByName( column = "Clothing Allowance")
    private String empClothing;
    
    @CsvBindByName( column = "Gross Semi-monthly rate")
    private String empSemi;
    
    @CsvBindByName( column = "Hourly Rate")
    private String empRate;

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getEmpLname() {
		return empLname;
	}

	public void setEmpLname(String empLname) {
		this.empLname = empLname;
	}

	public String getEmpBdate() {
		return empBdate;
	}

	public void setEmpBdate(String empBdate) {
		this.empBdate = empBdate;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpSSS() {
		return empSSS;
	}

	public void setEmpSSS(String empSSS) {
		this.empSSS = empSSS;
	}

	public String getEmpPhilhealth() {
		return empPhilhealth;
	}

	public void setEmpPhilhealth(String empPhilhealth) {
		this.empPhilhealth = empPhilhealth;
	}

	public String getEmpTIN() {
		return empTIN;
	}

	public void setEmpTIN(String empTIN) {
		this.empTIN = empTIN;
	}

	public String getEmpPagibig() {
		return empPagibig;
	}

	public void setEmpPagibig(String empPagibig) {
		this.empPagibig = empPagibig;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public String getEmpSupervisor() {
		return empSupervisor;
	}

	public void setEmpSupervisor(String empSupervisor) {
		this.empSupervisor = empSupervisor;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpRice() {
		return empRice;
	}

	public void setEmpRice(String empRice) {
		this.empRice = empRice;
	}

	public String getEmpPhoneAllowance() {
		return empPhoneAllowance;
	}

	public void setEmpPhoneAllowance(String empPhoneAllowance) {
		this.empPhoneAllowance = empPhoneAllowance;
	}

	public String getEmpClothing() {
		return empClothing;
	}

	public void setEmpClothing(String empClothing) {
		this.empClothing = empClothing;
	}

	public String getEmpSemi() {
		return empSemi;
	}

	public void setEmpSemi(String empSemi) {
		this.empSemi = empSemi;
	}

	public String getEmpRate() {
		return empRate;
	}

	public void setEmpRate(String empRate) {
		this.empRate = empRate;
	}

	@Override
	public String toString() {
		return "employee_details [empid=" + empid + ", empFName=" + empFName + ", empLname=" + empLname + ", empBdate="
				+ empBdate + ", empAddress=" + empAddress + ", empPhone=" + empPhone + ", empSSS=" + empSSS
				+ ", empPhilhealth=" + empPhilhealth + ", empTIN=" + empTIN + ", empPagibig=" + empPagibig
				+ ", empStatus=" + empStatus + ", empPosition=" + empPosition + ", empSupervisor=" + empSupervisor
				+ ", empSalary=" + empSalary + ", empRice=" + empRice + ", empPhoneAllowance=" + empPhoneAllowance
				+ ", empClothing=" + empClothing + ", empSemi=" + empSemi + ", empRate=" + empRate + "]";
	}
}