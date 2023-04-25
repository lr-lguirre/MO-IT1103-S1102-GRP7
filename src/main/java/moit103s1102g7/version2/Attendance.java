package moit103s1102g7.version2;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Attendance {

    private String employeeNumber;
    private String lastName;
    private String firstName;
    private LocalDate date;
    private LocalTime timeIn;
    private LocalTime timeOut;

    public Attendance(String employeeNumber, String lastName, String firstName, LocalDate date, LocalTime timeIn, LocalTime timeOut) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public Attendance(String string, String string2, String string3, String string4, String string5) {
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public static List<Attendance> readAttendanceCSV() {
        List<Attendance> attendances = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("attendance.csv"))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                String employeeNumber = line[0];
                String lastName = line[1];
                String firstName = line[2];
                LocalDate date = LocalDate.parse(line[3]);
                LocalTime timeIn = LocalTime.parse(line[4]);
                LocalTime timeOut = LocalTime.parse(line[5]);
                attendances.add(new Attendance(employeeNumber, lastName, firstName, date, timeIn, timeOut));
            }
        } catch (IOException e) {
            System.err.println("Error reading attendance.csv file: " + e.getMessage());
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return attendances;
    }

    public static List<Attendance> getAttendanceByLastNameAndMonth(String lastName, Month month) {
        List<Attendance> attendances = readAttendanceCSV();
        List<Attendance> filteredAttendances = new ArrayList<>();
        for (Attendance attendance : attendances) {
            if (attendance.getLastName().equalsIgnoreCase(lastName) && attendance.getDate().getMonth() == month) {
                filteredAttendances.add(attendance);
            }
        }
        return filteredAttendances;
    }

    public static int getTotalHoursWorked(List<Attendance> attendances) {
        int totalHours = 0;
        for (Attendance attendance : attendances) {
            LocalDateTime dateTimeIn = LocalDateTime.of(attendance.getDate(), attendance.getTimeIn());
            LocalDateTime dateTimeOut = LocalDateTime.of(attendance.getDate(), attendance.getTimeOut());
            int hours = dateTimeOut.getHour() - dateTimeIn.getHour();
            int minutes = dateTimeOut.getMinute() - dateTimeIn.getMinute();
            totalHours += hours * 60 + minutes;
        }
        return totalHours;
    }
}
