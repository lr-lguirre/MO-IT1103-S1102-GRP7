package moit103s1102g7.version2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MainWindow extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton attendanceButton;
    private AttendanceCalculator attendanceCalculator;
    private List<Employee> employees;
    private List<Attendance> attendances;

    public MainWindow(String accessType) throws CsvValidationException {
        super("Employee Details");

        // Set up the panel and layout
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Set up the label
        label = new JLabel("Employee Details", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Set up the table
        table = new JTable();
        scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Set up the attendance button
        if (accessType.equals("hr") || accessType.equals("admin")) {
            attendanceButton = new JButton("Calculate Attendance");
            attendanceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    attendanceCalculator = new AttendanceCalculator();
                    attendanceCalculator.setVisible(true);
                }
            });
            panel.add(attendanceButton, BorderLayout.SOUTH);
        }

        // Add the panel to the frame
        add(panel);

        // Load the employee data
        employees = new ArrayList<Employee>();
        try {
            CSVReader reader = new CSVReader(new FileReader("employeedetails.csv"));
            String[] line;
            while ((line = reader.readNext()) != null) {
                employees.add(new Employee(line[0], line[1], line[2], line[3], line[4], 
                                            line[5], line[6], line[7], line[8], line[9], 
                                            line[10], line[11], line[12], line[13], line[14], 
                                            line[15], line[16], line[17], line[18]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the attendance data
        attendances = new ArrayList<Attendance>();
        try {
            CSVReader reader = new CSVReader(new FileReader("attendance.csv"));
            String[] line;
            while ((line = reader.readNext()) != null) {
                attendances.add(new Attendance(line[0], line[1], line[2], line[3], line[4]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Display the employee data
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Employee #");
        model.addColumn("Last Name");
        model.addColumn("First Name");
        model.addColumn("Birthday");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("SSS #");
        model.addColumn("Philhealth #");
        model.addColumn("TIN #");
        model.addColumn("Pag-ibig #");
        model.addColumn("Status");
        model.addColumn("Position");
        model.addColumn("Immediate Supervisor");
        model.addColumn("Basic Salary");
        model.addColumn("Rice Subsidy");
        model.addColumn("Phone Allowance");
        model.addColumn("Clothing Allowance");
        model.addColumn("Gross Semi-monthly Rate");
        model.addColumn("Hourly Rate");
        
        // create table with model
        JTable table = new JTable(model);
        
        // add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 500));
        
        JPanel mainPanel = new JPanel();
        // add scroll pane to main panel
        mainPanel.add(scrollPane);
    }
}
