package moit103s1102g7.version2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AttendanceFileReader {
    private final String filePath;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AttendanceFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<AttendanceRecord> readAttendanceRecords() {
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // Skip header line
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                String employeeId = nextLine[0];
                LocalDate date = LocalDate.parse(nextLine[1], dateFormatter);
                boolean isPresent = Boolean.parseBoolean(nextLine[2]);
                int hoursWorked = Integer.parseInt(nextLine[3]);

                AttendanceRecord record = new AttendanceRecord(employeeId, date, isPresent, hoursWorked);
                attendanceRecords.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return attendanceRecords;
    }
}
