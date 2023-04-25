package moit103s1102g7.version2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class AttendanceCalculator extends JFrame {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

    private final List<AttendanceRecord> attendanceRecords;

    public AttendanceCalculator() {
        attendanceRecords = new ArrayList<>();

        // Read attendance records from file
        try (CSVReader reader = new CSVReader(new FileReader("attendance.csv"))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                // Parse attendance record from CSV line
                int employeeNumber = Integer.parseInt(line[0]);
                String lastName = line[1];
                String firstName = line[2];
                LocalDate date = LocalDate.parse(line[3], DATE_FORMAT);
                LocalTime timeIn = LocalTime.parse(line[4], DATETIME_FORMAT);
                LocalTime timeOut = LocalTime.parse(line[5], DATETIME_FORMAT);

                // Add attendance record to list
                attendanceRecords.add(new AttendanceRecord(employeeNumber, lastName, firstName, date, timeIn, timeOut));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AttendanceRecord> getAttendanceRecordsByLastNameAndMonth(String lastName, Month month) {
        List<AttendanceRecord> filteredRecords = new ArrayList<>();

        // Filter attendance records by last name and month
        for (AttendanceRecord record : attendanceRecords) {
            if (record.getLastName().equalsIgnoreCase(lastName) &&
                    record.getDate().getMonth() == month) {
                filteredRecords.add(record);
            }
        }

        return filteredRecords;
    }

    public int getTotalHoursWorked(List<AttendanceRecord> records) {
        int totalMinutes = 0;

        // Calculate total minutes worked from attendance records
        for (AttendanceRecord record : records) {
            LocalDateTime dateTimeIn = LocalDateTime.of(record.getDate(), record.getTimeIn());
            LocalDateTime dateTimeOut = LocalDateTime.of(record.getDate(), record.getTimeOut());
            totalMinutes += dateTimeIn.until(dateTimeOut, java.time.temporal.ChronoUnit.MINUTES);
        }

        return totalMinutes / 60; // Convert minutes to hours
    }
}

