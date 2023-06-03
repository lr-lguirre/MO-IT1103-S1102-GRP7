package moit103s1102g7.prototype;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class JpLeaveApplication extends JFrame {

	private static final String path = "leaves.csv";
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	private static final long serialVersionUID = 1L;
	private JComboBox<Object> comboBoxLeaveType;
	private JDateChooser txtStartDate;
	private JDateChooser txtEndDate;
	private List<employeeLeaves> leavesList = readCsvFiles.employeeLeaves();
	private JTextArea txtLeaveDescription;
	private JButton btnCancel_1;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public JpLeaveApplication(String uid) {

		setTitle("MotorPH Employee Leave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 419);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblLeaveApplication = new JLabel("Employee Leave Application");
		lblLeaveApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveApplication.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeaveApplication.setBounds(192, 24, 225, 17);
		getContentPane().add(lblLeaveApplication);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(510, 335, 64, 23);
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JpEmployee employee = new JpEmployee(uid);
				employee.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(btnBack);

		JPanel payrollInformationPanel_1 = new JPanel();
		payrollInformationPanel_1.setLayout(null);
		payrollInformationPanel_1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel_1.setBounds(10, 51, 564, 143);
		getContentPane().add(payrollInformationPanel_1);

		JLabel lblAddNewLeave = new JLabel("Add New Leave:");
		lblAddNewLeave.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewLeave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddNewLeave.setBounds(185, 6, 193, 14);
		payrollInformationPanel_1.add(lblAddNewLeave);

		JLabel lblLeaveType = new JLabel("Leave Type:");
		lblLeaveType.setBounds(10, 29, 102, 14);
		payrollInformationPanel_1.add(lblLeaveType);

		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(10, 54, 84, 14);
		payrollInformationPanel_1.add(lblStartDate);

		comboBoxLeaveType = new JComboBox<Object>(new Object[] {});
		comboBoxLeaveType
				.setModel(new DefaultComboBoxModel<Object>(new String[] { "Select Leave Type ", "SL", "VL", "EL" }));
		comboBoxLeaveType.setBounds(89, 25, 136, 20);
		payrollInformationPanel_1.add(comboBoxLeaveType);

		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(10, 79, 84, 14);
		payrollInformationPanel_1.add(lblEndDate);

		JLabel lblReasonForLeave = new JLabel("Reason for ");
		lblReasonForLeave.setBounds(235, 29, 90, 14);
		payrollInformationPanel_1.add(lblReasonForLeave);

		txtLeaveDescription = new JTextArea();
		txtLeaveDescription.setMargin(new Insets(4, 4, 4, 4));
		txtLeaveDescription.setBorder(new LineBorder(new Color(128, 128, 128)));
		txtLeaveDescription.setLineWrap(true);
		txtLeaveDescription.setWrapStyleWord(true);
		txtLeaveDescription.setBounds(316, 25, 238, 71);
		txtLeaveDescription.setToolTipText("A leave description can't contain a comma.");
		txtLeaveDescription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_COMMA) {
					e.consume(); // consume the key event to prevent the comma from being entered
				}
			}
		});
		payrollInformationPanel_1.add(txtLeaveDescription);

		JButton btnApplyLeave = new JButton("File Leave");
		btnApplyLeave.setBounds(450, 107, 104, 23);
		payrollInformationPanel_1.add(btnApplyLeave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(316, 107, 104, 23);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// clearFields();

			}
		});
		payrollInformationPanel_1.add(btnCancel);

		JLabel lblLeave = new JLabel("Leave:");
		lblLeave.setBounds(235, 47, 90, 14);
		payrollInformationPanel_1.add(lblLeave);

		// Create a custom date editor with selectable date predicate
		JTextFieldDateEditor dateEditor = new JTextFieldDateEditor();
		dateEditor.setDateFormatString("MM/dd/yyyy");

		// Disable weekends in the date chooser
		dateEditor.addPropertyChangeListener(e -> {
		    if ("date".equals(e.getPropertyName())) {
		        JTextFieldDateEditor editor = (JTextFieldDateEditor) e.getSource();
		        JDateChooser chooser = (JDateChooser) editor.getParent();
		        Date selectedDate = chooser.getDate();
		        Calendar calendar = Calendar.getInstance();
		        calendar.setTime(selectedDate);
		        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
		            chooser.setDate(null);
		        }
		    }
		});

		// Create the JDateChooser instances with the custom date editor
		JDateChooser txtStartDate = new JDateChooser();
		txtStartDate.setDateFormatString("MM/dd/yyyy");
		txtStartDate.setBounds(89, 50, 136, 20);

		JDateChooser txtEndDate = new JDateChooser();
		txtEndDate.setDateFormatString("MM/dd/yyyy");
		txtEndDate.setBounds(89, 76, 136, 20);
		
		JLabel txtDays = new JLabel("");
		txtDays.setBounds(278, 78, 38, 16);
		payrollInformationPanel_1.add(txtDays);

		// Disable weekends in the date choosers
		txtStartDate.getDateEditor().addPropertyChangeListener(e -> {
		    if ("date".equals(e.getPropertyName())) {
		        Date selectedDate = txtStartDate.getDate();
		        Calendar calendar = Calendar.getInstance();
		        calendar.setTime(selectedDate);
		        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
		            txtStartDate.setDate(null);
		        }
		    }
		});

		txtEndDate.getDateEditor().addPropertyChangeListener(e -> {
		    if ("date".equals(e.getPropertyName())) {
		        Date startDate = txtStartDate.getDate();
		        Date endDate = txtEndDate.getDate();
		        if (startDate != null && endDate != null) {
		            // Check if the selected end date is a weekend
		            Calendar calendar = Calendar.getInstance();
		            calendar.setTime(endDate);
		            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		            if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
		                txtEndDate.setDate(null);
		            } else {
		                // Calculate the number of selected days
		                long daysCount = TimeUnit.MILLISECONDS.toDays(endDate.getTime() - startDate.getTime()) + 1;
		                txtDays.setText(String.valueOf(daysCount));
		            }
		        } else {
		            txtDays.setText("");
		        }
		    }
		});


		// Set min and max dates
		Calendar minDate = Calendar.getInstance();
		minDate.set(2023, Calendar.JANUARY, 1);
		txtStartDate.setMinSelectableDate(minDate.getTime());
		txtEndDate.setMinSelectableDate(minDate.getTime());

		Calendar maxDate = Calendar.getInstance();
		maxDate.set(2024, Calendar.DECEMBER, 31);
		txtStartDate.setMaxSelectableDate(maxDate.getTime());
		txtEndDate.setMaxSelectableDate(maxDate.getTime());

		// Add the date choosers to the panel
		payrollInformationPanel_1.add(txtStartDate);
		payrollInformationPanel_1.add(txtEndDate);

		JLabel lblVL = new JLabel("VL:");
		lblVL.setFont(new Font("Dialog", Font.BOLD, 12));
		lblVL.setBounds(10, 115, 29, 16);
		payrollInformationPanel_1.add(lblVL);

		JLabel lblSL = new JLabel("SL:");
		lblSL.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSL.setBounds(89, 114, 29, 16);
		payrollInformationPanel_1.add(lblSL);

		JLabel lblEL = new JLabel("EL:");
		lblEL.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEL.setBounds(185, 115, 29, 16);
		payrollInformationPanel_1.add(lblEL);

		// Create a filtered list based on uid
		String availableVL = "5";
		String availableSL = "5";
		String availableEL = "5";
		List<employeeLeaves> filteredList = new ArrayList<>();
		for (employeeLeaves leaves : leavesList) {
			String empid = leaves.getEmpid();
			if (empid != null && empid.equals(uid)) {
				filteredList.add(leaves);
			}
		}
		if (!filteredList.isEmpty()) {
			employeeLeaves lastEntry = filteredList.get(filteredList.size() - 1);
			availableVL = lastEntry.getAvailableVL();
			availableSL = lastEntry.getAvailableSL();
			availableEL = lastEntry.getAvailableEL();
		}

		// Create a table model and set it to the JTable
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("empid");
		model.addColumn("leaveType");
		model.addColumn("dateFrom");
		model.addColumn("dateTo");
		model.addColumn("availabeVL");
		model.addColumn("availableSL");
		model.addColumn("availableEL");
		model.addColumn("leaveDescription");
		model.addColumn("leaveStatus");

		for (employeeLeaves leaves : filteredList) {
			model.addRow(new Object[] { leaves.getEmpid(), leaves.getLeaveType(), leaves.getDateFrom(),
					leaves.getDateTo(), leaves.getAvailableVL(), leaves.getAvailableSL(), leaves.getAvailableEL(),
					leaves.getLeaveDescription(), leaves.getLeaveStatus() });
		}

		JTable tblLeaves = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(tblLeaves);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setBounds(10, 217, 564, 107);
		tblLeaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblLeaves);
		getContentPane().add(scrollPane);

		JLabel txtVL = new JLabel("");
		txtVL.setBounds(38, 114, 38, 16);
		txtVL.setText(availableVL);
		payrollInformationPanel_1.add(txtVL);

		JLabel txtSL = new JLabel("");
		txtSL.setBounds(117, 113, 38, 16);
		txtSL.setText(availableSL);
		payrollInformationPanel_1.add(txtSL);

		JLabel txtEL = new JLabel("");
		txtEL.setBounds(213, 114, 38, 16);
		txtEL.setText(availableEL);
		payrollInformationPanel_1.add(txtEL);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDays.setBounds(235, 78, 38, 16);
		payrollInformationPanel_1.add(lblDays);

		JLabel lblFiledLeaves = new JLabel("Filed Leaves:");
		lblFiledLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiledLeaves.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFiledLeaves.setBounds(195, 199, 193, 14);
		getContentPane().add(lblFiledLeaves);

		btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setBounds(10, 338, 72, 23);
		btnCancel_1.setEnabled(false);
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get the selected row index
				int rowIndex = tblLeaves.getSelectedRow();
				// update the leave status to "Cancelled"
				tblLeaves.setValueAt("Cancelled", rowIndex, 8);
				// open the CSV file for writing
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(path));

					// loop through the leave array and write to the CSV file
					for (employeeLeaves leaveDetail : leavesList) {
						// check if leaveDetail is not null
						if (leaveDetail != null) {
							// write the leave detail to the CSV file
							writer.write(leaveDetail.getEmpid() + "," + leaveDetail.getLeaveType() + ","
									+ leaveDetail.getDateFrom() + "," + leaveDetail.getDateTo() + ","
									+ leaveDetail.getAvailableVL() + "," + leaveDetail.getAvailableSL() + ","
									+ leaveDetail.getAvailableEL() + "," + leaveDetail.getLeaveDescription() + ","
									+ leaveDetail.getLeaveStatus());
							writer.newLine();
						}
					}

					// close the CSV file
					writer.close();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(btnCancel_1);

		// Load leave data from CSV file
		// loadLeaveData(uid);

		btnApplyLeave.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // get the selected leave type
		        String leaveType = (String) comboBoxLeaveType.getSelectedItem();
		        // get the start date
		        Date startDate = txtStartDate.getDate();
		        // get the end date
		        Date endDate = txtEndDate.getDate();
		        // get the leave description
		        String leaveDescription = txtLeaveDescription.getText();

		        // validate the leave application
		        if (leaveType.equals("Select Leave Type ")) {
		            JOptionPane.showMessageDialog(null, "Please select a leave type.", "Invalid Leave Type",
		                    JOptionPane.WARNING_MESSAGE);
		        } else if (startDate == null || endDate == null) {
		            JOptionPane.showMessageDialog(null, "Please select start and end dates.", "Invalid Dates",
		                    JOptionPane.WARNING_MESSAGE);
		        } else if (startDate.after(endDate)) {
		            JOptionPane.showMessageDialog(null, "Start date cannot be after end date.", "Invalid Dates",
		                    JOptionPane.WARNING_MESSAGE);
		        } else if (leaveDescription.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please enter a leave description.", "Invalid Description",
		                    JOptionPane.WARNING_MESSAGE);
		        } else {
		            // Calculate the number of selected dates
		            long daysCount = 0;
		            Calendar calendar = Calendar.getInstance();
		            calendar.setTime(startDate);

		            while (!calendar.getTime().after(endDate)) {
		                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
		                    daysCount++;
		                }
		                calendar.add(Calendar.DAY_OF_MONTH, 1);
		            }

		            // Check if the number of selected dates exceeds the available leaves
		            int availableVL = Integer.parseInt(txtVL.getText());
		            int availableSL = Integer.parseInt(txtSL.getText());
		            int availableEL = Integer.parseInt(txtEL.getText());

		            if (leaveType.equals("VL") && daysCount > availableVL) {
		                JOptionPane.showMessageDialog(null, "Selected dates exceed available VL.",
		                        "Insufficient Leaves", JOptionPane.WARNING_MESSAGE);
		            } else if (leaveType.equals("SL") && daysCount > availableSL) {
		                JOptionPane.showMessageDialog(null, "Selected dates exceed available SL.",
		                        "Insufficient Leaves", JOptionPane.WARNING_MESSAGE);
		            } else if (leaveType.equals("EL") && daysCount > availableEL) {
		                JOptionPane.showMessageDialog(null, "Selected dates exceed available EL.",
		                        "Insufficient Leaves", JOptionPane.WARNING_MESSAGE);
		            } else {
		                // Check if the leave date already exists in leaves.csv
		                boolean leaveExists = false;
		                for (employeeLeaves existingLeave : leavesList) {
		                    String existingLeaveStartDate = existingLeave.getDateFrom();
		                    String existingLeaveEndDate = existingLeave.getDateTo();
		                    try {
								if (startDate.compareTo(formatter.parse(existingLeaveStartDate)) >= 0 &&
								        endDate.compareTo(formatter.parse(existingLeaveEndDate)) <= 0) {
								    leaveExists = true;
								    break;
								}
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }

		                if (leaveExists) {
		                    JOptionPane.showMessageDialog(null, "Leave for the selected dates already exists.",
		                            "Leave Already Exists", JOptionPane.WARNING_MESSAGE);
		                } else {
		                    // Create a new leave detail object
		                    employeeLeaves leaveDetail = new employeeLeaves();
		                    leaveDetail.setEmpid(uid);
		                    leaveDetail.setLeaveType(leaveType);
		                    leaveDetail.setDateFrom(formatter.format(startDate));
		                    leaveDetail.setDateTo(formatter.format(endDate));
		                    leaveDetail.setLeaveDescription(leaveDescription);
		                    leaveDetail.setLeaveStatus("Applied");
		                    if (leaveType.equals("VL")) {
		                        leaveDetail.setAvailableVL(String.valueOf(availableVL - daysCount));
		                        leaveDetail.setAvailableSL(String.valueOf(availableSL));
		                        leaveDetail.setAvailableEL(String.valueOf(availableEL));
		                    } else if (leaveType.equals("SL")) {
		                        leaveDetail.setAvailableVL(String.valueOf(availableVL));
		                        leaveDetail.setAvailableSL(String.valueOf(availableSL - daysCount));
		                        leaveDetail.setAvailableEL(String.valueOf(availableEL));
		                    } else if (leaveType.equals("EL")) {
		                        leaveDetail.setAvailableVL(String.valueOf(availableVL));
		                        leaveDetail.setAvailableSL(String.valueOf(availableSL));
		                        leaveDetail.setAvailableEL(String.valueOf(availableEL - daysCount));
		                    }

		                    // Add the leave detail to the array
		                    leavesList.add(leaveDetail);

		                    // Save the leave data to the CSV file
		                    try {
		                        writeCsvFiles.updateLeaves(leavesList);
		                    } catch (Exception e1) {
		                        e1.printStackTrace();
		                    }

		                    // Clear the input fields
		                    clearFields();

		                    // Display success message
		                    JOptionPane.showMessageDialog(null, "Leave filed successfully.", "Leave Filed",
		                            JOptionPane.INFORMATION_MESSAGE);

		                    // Update the table data
		                    updateTableData(uid);
		                }
		            }
		        }
		    }
		});


		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Method to clear the input fields.
	 */
	private void clearFields() {
		comboBoxLeaveType.setSelectedIndex(0);
		txtStartDate.setDate(null);
		txtEndDate.setDate(null);
		txtLeaveDescription.setText("");
	}

	/**
	 * Main method to run the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String uid = "10001";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JpLeaveApplication window = new JpLeaveApplication(uid);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateTableData(String uid) {
		// Clear the existing rows from the table
		// model = new DefaultTableModel();
		model.setRowCount(0);

		// Retrieve the updated leaves list
		List<employeeLeaves> leavesList = readCsvFiles.employeeLeaves();

		// Filter the leaves list based on the UID
		List<employeeLeaves> filteredList = leavesList.stream().filter(leaves -> leaves.getEmpid().equals(uid))
				.collect(Collectors.toList());

		// Populate the table with the filtered leaves data
		for (employeeLeaves leave : filteredList) {
			model.addRow(new Object[] { leave.getEmpid(), leave.getLeaveType(), leave.getDateFrom(), leave.getDateTo(),
					leave.getAvailableVL(), leave.getAvailableSL(), leave.getAvailableEL(), leave.getLeaveDescription(),
					leave.getLeaveStatus() });
		}

		// Notify the table of the data changes
		model.fireTableDataChanged();
	}

	// Utility method to parse date string
	/*
	 * private Date getDate(String dateString) { try { SimpleDateFormat dateFormat =
	 * new SimpleDateFormat("MM/dd/yyyy"); return dateFormat.parse(dateString); }
	 * catch (ParseException e) { e.printStackTrace(); return null; } }
	 */
}
