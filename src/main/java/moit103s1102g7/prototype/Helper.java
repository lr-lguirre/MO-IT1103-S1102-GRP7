package moit103s1102g7.prototype;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.opencsv.exceptions.CsvException;

public class Helper {
	static List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();
	static List<employeeLogin> employeeLogin = readCsvFiles.employeeLogin();

	public static boolean verifyNewUser(JTextField textTIN1, JTextField textTIN2, JTextField textTIN3, JTextField textTIN4, String username, JPasswordField textPassword1, JPasswordField textPassword2) {
	    boolean isVerified = false;
	    String tin = textTIN1.getText() + textTIN2.getText() + textTIN3.getText() + textTIN4.getText();
	    
	    // Check if all TIN fields are filled
	    if (textTIN1.getText().isEmpty() || textTIN2.getText().isEmpty() || textTIN3.getText().isEmpty() || textTIN4.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please fill up all TIN fields.");
	        return isVerified;
	    }
	    
	    String tinID = (textTIN1+"-"+textTIN2+"-"+textTIN3+"-"+textTIN4);
	    System.out.println(tinID);
	    
	    // Check if TIN is a valid number
	    try {
	        Long.parseLong(tin);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "TIN must be a valid number.");
	        return isVerified;
	    }
	    
	    // Check if TIN is unique
	    if (!employeeDetails.stream().anyMatch(e -> Long.parseLong(e.getEmpTIN().replaceAll("-", "")) == Long.parseLong(tin))) {
	        JOptionPane.showMessageDialog(null, "Please input your TIN number.");
	        return isVerified;
	    }
	    
	    // Check if employee ID is unique
	    if (employeeLogin.stream().anyMatch(e -> e.getEmpid().equals(username))) {
	        JOptionPane.showMessageDialog(null, "Employee ID already exists in the database.");
	        return isVerified;
	    }
	    
	    // Check if password fields match
	    if (!Arrays.equals(textPassword1.getPassword(), textPassword2.getPassword())) {
	        JOptionPane.showMessageDialog(null, "Passwords do not match.");
	        textPassword1.setText(null);
	        textPassword2.setText(null);
	        return isVerified;
	    }
	    
	    isVerified = true;
	    return isVerified;
	}

	public Map<String, Object> employeeInfo(String uid) {
	    Map<String, Object> empInfo = new HashMap<>();
	    employeeDetails.stream().filter(e -> e.getEmpid().equals(uid)).findFirst().ifPresent(e -> {
	        empInfo.put("empFName", e.getEmpFName());
	        empInfo.put("empLname", e.getEmpLname());
	        empInfo.put("empBdate", e.getEmpBdate());
	        empInfo.put("empAddress", e.getEmpAddress());
	        empInfo.put("empPhone", e.getEmpPhone());
	        empInfo.put("empSSS", e.getEmpSSS());
	        empInfo.put("empPhilhealth", e.getEmpPhilhealth());
	        empInfo.put("empTIN", e.getEmpTIN());
	        empInfo.put("empPagibig", e.getEmpPagibig());
	        empInfo.put("empStatus", e.getEmpStatus());
	        empInfo.put("empPosition", e.getEmpPosition());
	        empInfo.put("empSupervisor", e.getEmpSupervisor());
	        empInfo.put("empSalary", e.getEmpSalary());
	        empInfo.put("empRice", e.getEmpRice());
	        empInfo.put("empPhoneAllowance", e.getEmpPhoneAllowance());
	        empInfo.put("empClothing", e.getEmpClothing());
	        empInfo.put("empSemi", e.getEmpSemi());
	        empInfo.put("empRate", e.getEmpRate());
	    });
	    return empInfo;
	}
	public static void updateEmployeeDetails(String uid, String newAddress, String newPhone) throws IOException, CsvException {
	    List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();
	    for (employeeDetails emp : employeeDetails) {
	        if (emp.getEmpid().equals(uid)) {
	            emp.setEmpAddress(newAddress);
	            emp.setEmpPhone(newPhone);
	            break;
	        }
	    }
	    writeCsvFiles.empDetails(employeeDetails);
	}
	 public static boolean isValidPhoneNumber(String phoneNo) {
	        Pattern pattern = Pattern.compile("^\\+?[0-9. ()-]{10,25}$");
	        Matcher matcher = pattern.matcher(phoneNo);
	        return matcher.matches();
	 }
}
