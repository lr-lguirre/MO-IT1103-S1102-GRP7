package moit103s1102g7.version2;

import java.awt.Dimension;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class MainWindow extends JFrame {
    private JTable table;

    public MainWindow(String accessType) {
        super("Employee Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"};
        List<String[]> data = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("employeedetails.csv");
            CSVParser csvParser = new CSVParserBuilder().withQuoteChar('"').build();
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).build();// use quote character to catch quoted entries
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                // check accessType and add corresponding rows to data list
                if (accessType.equals("hr")) {
                    if (nextRecord[10].equalsIgnoreCase("active")) { // check status column for "active"
                        data.add(nextRecord);
                    }
                } else if (accessType.equals("employee")) {
                    if (nextRecord[0].equals("12345")) { // example: show only data for Employee #
                        data.add(nextRecord);
                    }
                } else if (accessType.equals("admin")) {
                    data.add(nextRecord);
                }
            }

            fileReader.close();
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String[][] dataArray = data.toArray(new String[0][0]);
        table = new JTable(dataArray, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1200, 700));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        pack();
        setVisible(true);
    }
}
