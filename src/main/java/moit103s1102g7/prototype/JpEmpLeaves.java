package moit103s1102g7.prototype;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.toedter.calendar.JDateChooser;

public class JpEmpLeaves extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
    private JRadioButton rdbtnVL;
    private JRadioButton rdbtnSL;
    private JRadioButton rdbtnEL;
    private JButton btnApply;
    private JButton btnReset;
    private JButton btnBack;
    private ButtonGroup buttonGroup;
    private JLabel txtVL;
    private JLabel txtSL;
    private JLabel txtEL;
    private JDateChooser dateChooser;
    private List<Date> selectedDates = new ArrayList<>();
    private String uid;


    public JpEmpLeaves(String uid) {
        setTitle("Employee Leave Application Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("VL");
        lblNewLabel.setBounds(25, 29, 20, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("SL");
        lblNewLabel_1.setBounds(25, 60, 20, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("EL");
        lblNewLabel_2.setBounds(25, 88, 20, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Available");
        lblNewLabel_3.setBounds(42, 11, 46, 14);
        contentPane.add(lblNewLabel_3);

        JLabel txtVL = new JLabel("");
        txtVL.setBounds(55, 29, 46, 14);
        contentPane.add(txtVL);
        txtVL.setText("5");

        JLabel txtSL = new JLabel("");
        txtSL.setBounds(55, 60, 46, 14);
        contentPane.add(txtSL);
        txtSL.setText("5");

        JLabel txtEL = new JLabel("");
        txtEL.setBounds(57, 88, 46, 14);
        contentPane.add(txtEL);
        txtSL.setText("5");

        rdbtnVL = new JRadioButton("");
        rdbtnVL.setBounds(102, 20, 28, 23);
        contentPane.add(rdbtnVL);

        rdbtnSL = new JRadioButton("");
        rdbtnSL.setBounds(102, 50, 28, 23);
        contentPane.add(rdbtnSL);

        rdbtnEL = new JRadioButton("");
        rdbtnEL.setBounds(102, 81, 28, 23);
        contentPane.add(rdbtnEL);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnVL);
        buttonGroup.add(rdbtnSL);
        buttonGroup.add(rdbtnEL);

        textField = new JTextField();
        textField.setBounds(102, 116, 46, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Days");
        lblNewLabel_4.setBounds(25, 119, 46, 14);
        contentPane.add(lblNewLabel_4);

        btnApply = new JButton("Apply");
        btnApply.setBounds(25, 166, 89, 23);
        contentPane.add(btnApply);

        btnReset = new JButton("Reset");
        btnReset.setBounds(124, 166, 89, 23);
        contentPane.add(btnReset);

        btnBack = new JButton("Back");
        btnBack.setBounds(74, 210, 89, 23);
        contentPane.add(btnBack);
        
        // Add DateChooser
        dateChooser = new JDateChooser();
        dateChooser.setBounds(226, 23, 198, 20);
        contentPane.add(dateChooser);
        
        // Add action listeners to buttons
        btnApply.addActionListener((ActionEvent e) -> {
		    applyLeave();
		});
        btnReset.addActionListener((ActionEvent e1) -> {
		    resetForm();
		});
        btnBack.addActionListener((ActionEvent e2) -> {
		    goBack();
		});
        
        // Add action listener to dateChooser
        dateChooser.addPropertyChangeListener(evt -> {
            if ("date".equals(evt.getPropertyName())) {
                Date selectedDate = dateChooser.getDate();

                // Check if the selected date is already in the list
                if (selectedDates.contains(selectedDate)) {
                    // Remove the date from the list if it's already selected
                    selectedDates.remove(selectedDate);
                } else {
                    // Add the date to the list if it's not already selected
                    selectedDates.add(selectedDate);
                }

                // Update the number of selected dates
                int selectedCount = selectedDates.size();
                textField.setText(String.valueOf(selectedCount));

                // Get the selected leave type
                String leaveType = "";
                if (rdbtnVL.isSelected()) {
                    leaveType = "VL";
                } else if (rdbtnSL.isSelected()) {
                    leaveType = "SL";
                } else if (rdbtnEL.isSelected()) {
                    leaveType = "EL";
                }

                // Perform validation based on the leave type and selected count
                if (!leaveType.isEmpty() && selectedCount > getAvailableLeaves(leaveType)) {
                    // Display a warning message
                    JOptionPane.showMessageDialog(this, "Selected number of days exceeds available " + leaveType + " leaves!");
                }
                int availableVL = Integer.parseInt(txtVL.getText());
                int availableSL = Integer.parseInt(txtSL.getText());
                int availableEL = Integer.parseInt(txtEL.getText());
                updateLeaveCounts(availableVL, availableSL, availableEL, selectedCount);

            }
        });



    }

    private void applyLeave() {
        String empid = uid;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String dateFrom = dateFormat.format(selectedDates.get(0));
        String dateTo = dateFormat.format(selectedDates.get(selectedDates.size() - 1));
        // Get the number of days requested
        int requestedDays = Integer.parseInt(textField.getText());

        // Check if the selected dates are within the allowed number of leaves
        if (selectedDates.size() <= requestedDays) {
            // Update the available leaves
            int availableVL = Integer.parseInt(txtVL.getText()) - requestedDays;
            int availableSL = Integer.parseInt(txtSL.getText()) - requestedDays;
            int availableEL = Integer.parseInt(txtEL.getText()) - requestedDays;

            // Check if the requested days are within the allowable number of leaves
            if (availableVL >= 0 && availableSL >= 0 && availableEL >= 0) {
                // Update the labels displaying the available leaves
                txtVL.setText(String.valueOf(availableVL));
                txtSL.setText(String.valueOf(availableSL));
                txtEL.setText(String.valueOf(availableEL));

                // Get the selected leave type from the radio buttons
                String leaveType = null;
                if (rdbtnVL.isSelected()) {
                    leaveType = "VL";
                } else if (rdbtnSL.isSelected()) {
                    leaveType = "SL";
                } else if (rdbtnEL.isSelected()) {
                    leaveType = "EL";
                }

                // Store leave application details in CSV file
                try {
                    File file = new File("leaves.csv");
                    boolean isNewFile = !file.exists();

                    // Create a list to hold the leave application objects
                    List<employeeLeaves> leavesList = new ArrayList<>();

                    // Read the existing CSV file data into the list if the file exists
                    if (!isNewFile) {
                        CsvToBean<employeeLeaves> csvToBean = new CsvToBeanBuilder<employeeLeaves>(new FileReader(file))
                                .withType(employeeLeaves.class)
                                .withSeparator(',')
                                .withIgnoreLeadingWhiteSpace(true)
                                .build();

                        leavesList = csvToBean.parse();
                    }

                    // Find the leave application record for the specific employee (based on empid)
                    employeeLeaves existingLeave = leavesList.stream().filter(leave -> leave.getEmpid().equals(empid)).findFirst().orElse(null);

                    // Create a new leave application object for the specific employee if no existing record found
                    if (existingLeave == null) {
                        existingLeave = new employeeLeaves();
                        existingLeave.setEmpid(empid);
                        existingLeave.setAvailableVL(txtVL.getText());
                        existingLeave.setAvailableSL(txtSL.getText());
                        existingLeave.setAvailableEL(txtEL.getText());
                        existingLeave.setDateFrom(dateFrom);
                        existingLeave.setDateTo(dateTo);
                    }

                    // Update the available leaves for the specific employee
                    int updatedVL = Integer.parseInt(existingLeave.getAvailableVL()) - requestedDays;
                    int updatedSL = Integer.parseInt(existingLeave.getAvailableSL()) - requestedDays;
                    int updatedEL = Integer.parseInt(existingLeave.getAvailableEL()) - requestedDays;

                    existingLeave.setAvailableVL(String.valueOf(updatedVL));
                    existingLeave.setAvailableSL(String.valueOf(updatedSL));
                    existingLeave.setAvailableEL(String.valueOf(updatedEL));
                    existingLeave.setLeaveType(leaveType); // Update the leave type

                    // Add or update the leave application in the list
                    if (!leavesList.contains(existingLeave)) {
                        leavesList.add(existingLeave);
                    }

                    // Write the updated list to the CSV file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    StatefulBeanToCsv<employeeLeaves> beanToCsv = new StatefulBeanToCsvBuilder<employeeLeaves>(writer)
                            .withSeparator(',')
                            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                            .build();

                    if (isNewFile) {
                        // Write the header if the file is newly created
                        writer.write("dateFrom,dateTo,availableVL,availableSL,availableEL,empid,leaveType");
                        writer.newLine();
                    }

                    // Write the leave application objects to the CSV file
                    beanToCsv.write(leavesList);
                    writer.close();
                } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                    e.printStackTrace();
                    // Handle the exception or show an error message to the user
                    return;
                }

                // Perform any other necessary operations related to leave application, such as
                // sending notifications, updating a database, etc.

                // Show a success message to the user
                JOptionPane.showMessageDialog(this, "Leave application submitted successfully!");

                // Clear the selected dates
                selectedDates.clear();

                // Reset the number of days requested
                textField.setText("");

                // Go back to the previous screen or close the form
                goBack();
            } else {
                // Show an error message to the user
                JOptionPane.showMessageDialog(this, "Insufficient available leaves!");
            }
        } else {
            // Show an error message to the user
            JOptionPane.showMessageDialog(this, "Number of selected dates exceeds the requested days!");
        }
    }


    
	private void resetForm() {
        // Clear selection and text fields
        rdbtnVL.setSelected(false);
        rdbtnSL.setSelected(false);
        rdbtnEL.setSelected(false);
        textField.setText("");
        dateChooser.setDate(null);
    }

    private void goBack() {
        // Clear selected dates
        selectedDates.clear();
        JpEmployee back = new JpEmployee(uid);
        back.setVisible(true);
        dispose();
    }
    private int getAvailableLeaves(String leaveType) {
        // Perform a lookup or calculation to determine the available leaves for the specified leave type
        int availableLeaves = 0;

        // Assuming you have access to the employee's leave information, you can retrieve the available leaves from there
        if (leaveType.equals("VL")) {
            availableLeaves = Integer.parseInt(txtVL.getText());
        } else if (leaveType.equals("SL")) {
            availableLeaves = Integer.parseInt(txtSL.getText());
        } else if (leaveType.equals("EL")) {
            availableLeaves = Integer.parseInt(txtEL.getText());
        }

        return availableLeaves;
    }
    private void updateLeaveCounts(int availableVL, int availableSL, int availableEL, int selectedDays) {
        int updatedVL = availableVL - selectedDays;
        int updatedSL = availableSL - selectedDays;
        int updatedEL = availableEL - selectedDays;

        txtVL.setText(String.valueOf(updatedVL));
        txtSL.setText(String.valueOf(updatedSL));
        txtEL.setText(String.valueOf(updatedEL));
    }

}
