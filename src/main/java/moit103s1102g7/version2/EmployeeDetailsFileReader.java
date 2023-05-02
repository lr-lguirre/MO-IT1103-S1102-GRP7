package moit103s1102g7.version2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsFileReader {

    private String filePath;

    public EmployeeDetailsFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Employee> readEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();

        CSVReader reader = new CSVReader(new FileReader(filePath));
        String[] line;

        // Skip the header row
        reader.readNext();

        while ((line = reader.readNext()) != null) {
            int id = Integer.parseInt(line[0]);
            String name = line[1];
            String department = line[2];
            double salary = Double.parseDouble(line[3]);

            Employee employee = new Employee(id, name, department, salary);
            employees.add(employee);
        }

        reader.close();

        return employees;
    }
}
