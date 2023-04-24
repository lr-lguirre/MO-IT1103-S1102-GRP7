package moit103s1102g7.version2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;

    public MainWindow() {
        super("Employee Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // create table
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        // add table to panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // add panel to frame
        setContentPane(panel);

        // read data from CSV file
        String csvFile = "employeedetails.csv";
        CSVReader csvReader;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            csvReader = new CSVReader(reader);
            List<String[]> records = csvReader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                for (int j = 0; j < record.length; j++) {
                    String cell = record[j];
                    if (cell.startsWith("\"") && cell.endsWith("\"")) {
                        // handle quoted cell
                        cell = cell.substring(1, cell.length() - 1);
                    }
                    record[j] = cell;
                }
                if (i == 0) {
                    // add headers to model
                    model.setColumnIdentifiers(record);
                } else {
                    // add data to model
                    model.addRow(record);
                }
            }
            csvReader.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
