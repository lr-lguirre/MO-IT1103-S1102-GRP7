package moit103s1102g7.version4;

import java.io.BufferedReader;
import com.opencsv.bean.*;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class employee_details {
	
	@CsvBindByName( column = "Employee # ")
	private String empid;
	
	@CsvBindByName( column = "First Name ")
	private String empFName;
	
	@CsvBindByName( column = "Last Name ")
	private String empLname;
	
	@CsvBindByName( column = "Birthday ")
    private String empBdate;

	@CsvBindByName( column = "Address ")
	private String empAddress;
	
	@CsvBindByName( column = "Phone Number ")
	private String empPhone;
	
	@CsvBindByName( column = "SSS # ")
	private String empSSS;
	
	@CsvBindByName( column = "Philhealt # ")
	private String empPhilhealth;
    
    @CsvBindByName( column = "TIN # ")
    private String empTIN;
    
    @CsvBindByName( column = "Pag-ibig # ")
    private String empPagibig;
    
    @CsvBindByName( column = "Status ")
    private String empStatus;
    
    @CsvBindByName( column = "Position ")
    private String empPosition;
    
    @CsvBindByName( column = "Immediate Supervisor ")
    private String empSupervisor;
    
    @CsvBindByName( column = "Basic Salary ")
    private String empSalary;
    
    @CsvBindByName( column = "Rice Subsidy ")
    private String empRice;
    
    @CsvBindByName( column = "Phone Allowance ")
    private String empPhoneAllowance;
    
    @CsvBindByName( column = "Clothing Allowance ")
    private String empClothing;
    
    @CsvBindByName( column = "Gross Semi-monthly rate ")
    private String empSemi;
    
    @CsvBindByName( column = "Hourly Rate ")
    private String empRate;
    
    public static boolean employeeDetails(String id) throws NumberFormatException, ParseException, IOException {
            int ID = Integer.valueOf(id);
            File f = new File("employeedetails.csv");
            List<EmpDetails> beans  = new CsvToBeanBuilder(new FileReader(f)).withType(null).build().parse();
            beans.Foreach (System.out::println);
            }
	}