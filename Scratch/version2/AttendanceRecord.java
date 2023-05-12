package moit103s1102g7.version2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AttendanceRecord {
    private LocalDate startDate;
    private LocalDate endDate;
    private double semiMonthlyHours;
    private double monthlyHours;
    private int employeeId;
    private String employeeName;
    
    public AttendanceRecord(LocalDate startDate, LocalDate endDate, int employeeId, String employeeName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.semiMonthlyHours = 0;
        this.monthlyHours = 0;
    }
    
    public void addAttendance(LocalDate date, double hours) {
        if (date.isAfter(startDate) && date.isBefore(endDate.plusDays(1))) {
            semiMonthlyHours += hours;
            monthlyHours += hours;
        }
    }
    
    public double getSemiMonthlyHours() {
        return semiMonthlyHours;
    }
    
    public double getMonthlyHours() {
        return monthlyHours;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public String toString() {
        return "Employee " + employeeId + " (" + employeeName + ")\n" +
               "Semi-monthly hours: " + semiMonthlyHours + "\n" +
               "Monthly hours: " + monthlyHours + "\n";
    }
}
