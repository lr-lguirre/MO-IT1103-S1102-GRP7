package moit103s1102g7.prototype;

import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


public class JpEmpList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtBirthday;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtSSS;
	private JTextField txtPhilhealth;
	private JTextField txtTIN;
	private JTextField txtPagibig;
	private JTextField txtStatus;
	private JTextField txtPosition;
	private JTextField txtSupervisor;
	private JTextField txtBasic;
	private JTextField txtRice;
	private JTextField txtPhoneAllowance;
	private JTextField txtClothing;
	private JTextField txtGross;
	private JTextField txtHourly;

	/**
	 * Launch the application.
	**/
	public static void jpEmpList(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				JpEmpList frame = new JpEmpList();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	 
	/**
	 * Create the frame.
	 */
	public JpEmpList() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1067, 660);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    final JLabel lblNewLabel = new JLabel("Employee Details");
	    lblNewLabel.setBounds(10, 11, 104, 22);
	    contentPane.add(lblNewLabel);
	    
	    final ArrayList<Object> data = empList();
	    final DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(new Object[] {"Employee Number", "Last Name", "First Name"});
	    for (int i = 0; i < data.size(); i += 3) {
	        model.addRow(new Object[] {data.get(i), data.get(i+1), data.get(i+2)});
	    }
	    final JTable tblEmployeeDetails = new JTable(model) {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };
	    final JScrollPane scrollPane = new JScrollPane(tblEmployeeDetails);
	    scrollPane.setBounds(10, 32, 1031, 169);
	    contentPane.add(scrollPane);
	    
	    txtBirthday = new JTextField();
	    txtBirthday.setBounds(66, 363, 268, 20);
	    contentPane.add(txtBirthday);
	    txtBirthday.setColumns(10);
	    
	    txtAddress = new JTextField();
	    txtAddress.setColumns(10);
	    txtAddress.setBounds(66, 332, 599, 20);
	    contentPane.add(txtAddress);
	    
	    txtPhone = new JTextField();
	    txtPhone.setColumns(10);
	    txtPhone.setBounds(779, 332, 195, 20);
	    contentPane.add(txtPhone);
	    
	    txtSSS = new JTextField();
	    txtSSS.setColumns(10);
	    txtSSS.setBounds(66, 404, 220, 20);
	    contentPane.add(txtSSS);
	    
	    JLabel lblBirthday = new JLabel("Birthday");
	    lblBirthday.setBounds(10, 366, 46, 14);
	    contentPane.add(lblBirthday);
	    
	    txtPhilhealth = new JTextField();
	    txtPhilhealth.setColumns(10);
	    txtPhilhealth.setBounds(66, 435, 220, 20);
	    contentPane.add(txtPhilhealth);
	    
	    txtTIN = new JTextField();
	    txtTIN.setColumns(10);
	    txtTIN.setBounds(66, 466, 220, 20);
	    contentPane.add(txtTIN);
	    
	    txtPagibig = new JTextField();
	    txtPagibig.setColumns(10);
	    txtPagibig.setBounds(66, 497, 220, 20);
	    contentPane.add(txtPagibig);
	    
	    txtStatus = new JTextField();
	    txtStatus.setColumns(10);
	    txtStatus.setBounds(779, 301, 195, 20);
	    contentPane.add(txtStatus);
	    
	    txtPosition = new JTextField();
	    txtPosition.setColumns(10);
	    txtPosition.setBounds(66, 301, 268, 20);
	    contentPane.add(txtPosition);
	    
	    txtSupervisor = new JTextField();
	    txtSupervisor.setColumns(10);
	    txtSupervisor.setBounds(432, 301, 233, 20);
	    contentPane.add(txtSupervisor);
	    
	    txtBasic = new JTextField();
	    txtBasic.setColumns(10);
	    txtBasic.setBounds(779, 404, 195, 20);
	    contentPane.add(txtBasic);
	    
	    txtRice = new JTextField();
	    txtRice.setColumns(10);
	    txtRice.setBounds(447, 404, 178, 20);
	    contentPane.add(txtRice);
	    
	    txtPhoneAllowance = new JTextField();
	    txtPhoneAllowance.setColumns(10);
	    txtPhoneAllowance.setBounds(447, 435, 178, 20);
	    contentPane.add(txtPhoneAllowance);
	    
	    txtClothing = new JTextField();
	    txtClothing.setColumns(10);
	    txtClothing.setBounds(447, 466, 178, 20);
	    contentPane.add(txtClothing);
	    
	    txtGross = new JTextField();
	    txtGross.setColumns(10);
	    txtGross.setBounds(779, 435, 195, 20);
	    contentPane.add(txtGross);
	    
	    txtHourly = new JTextField();
	    txtHourly.setColumns(10);
	    txtHourly.setBounds(778, 466, 196, 20);
	    contentPane.add(txtHourly);
	    
	    JLabel lblAddress = new JLabel("Address");
	    lblAddress.setBounds(10, 335, 46, 14);
	    contentPane.add(lblAddress);
	    
	    JLabel lblPhone = new JLabel("Phone Number");
	    lblPhone.setBounds(694, 335, 75, 14);
	    contentPane.add(lblPhone);
	    
	    JLabel lblSSS = new JLabel("SSS #");
	    lblSSS.setBounds(10, 407, 46, 14);
	    contentPane.add(lblSSS);
	    
	    JLabel lblPhilhealth = new JLabel("Philhealth");
	    lblPhilhealth.setBounds(10, 438, 46, 14);
	    contentPane.add(lblPhilhealth);
	    
	    JLabel lblTIN = new JLabel("TIN #");
	    lblTIN.setBounds(10, 469, 46, 14);
	    contentPane.add(lblTIN);
	    
	    JLabel lblPagibig = new JLabel("HDMF");
	    lblPagibig.setBounds(10, 500, 46, 14);
	    contentPane.add(lblPagibig);
	    
	    JLabel lblStatus = new JLabel("Status");
	    lblStatus.setBounds(694, 304, 31, 14);
	    contentPane.add(lblStatus);
	    
	    JLabel lblPosition = new JLabel("Position");
	    lblPosition.setBounds(10, 304, 46, 14);
	    contentPane.add(lblPosition);
	    
	    JLabel lblSupervisor = new JLabel("Supervisor");
	    lblSupervisor.setBounds(365, 304, 57, 14);
	    contentPane.add(lblSupervisor);
	    
	    JLabel lblBasic = new JLabel("Basic Salary");
	    lblBasic.setBounds(635, 407, 63, 14);
	    contentPane.add(lblBasic);
	    
	    JLabel lblNewLabel_4 = new JLabel("Rice Subsidy");
	    lblNewLabel_4.setBounds(345, 407, 92, 14);
	    contentPane.add(lblNewLabel_4);
	    
	    JLabel lblNewLabel_5 = new JLabel("Phone Allowance");
	    lblNewLabel_5.setBounds(345, 438, 95, 14);
	    contentPane.add(lblNewLabel_5);
	    
	    JLabel lblNewLabel_6 = new JLabel("Clothing Allowance");
	    lblNewLabel_6.setBounds(345, 469, 111, 14);
	    contentPane.add(lblNewLabel_6);
	    
	    JLabel lblNewLabel_7 = new JLabel("Gross Semi-Monthly Income");
	    lblNewLabel_7.setBounds(635, 438, 138, 14);
	    contentPane.add(lblNewLabel_7);
	    
	    JLabel lblNewLabel_8 = new JLabel("Hourly Rate");
	    lblNewLabel_8.setBounds(635, 469, 104, 14);
	    contentPane.add(lblNewLabel_8);
	    
	    final JSeparator separator = new JSeparator();
	    separator.setBounds(10, 391, 1001, 2);
	    contentPane.add(separator);
	    
	    final JLabel lblempID = new JLabel("");
	    lblempID.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblempID.setBounds(10, 254, 142, 30);
	    contentPane.add(lblempID);
	    
	    final JLabel lblempName = new JLabel("");
	    lblempName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	    lblempName.setBounds(10, 212, 384, 36);
	    contentPane.add(lblempName);
	    
	    final JSeparator separator_1 = new JSeparator();
	    separator_1.setBounds(10, 288, 1001, 2);
	    contentPane.add(separator_1);
	    
	    JButton btnEdit = new JButton("Edit");
	    btnEdit.setBounds(66, 566, 89, 23);
	    contentPane.add(btnEdit);
	    
	    JButton btnLogin = new JButton("Back to Login");
	    btnLogin.setBounds(779, 566, 163, 23);
	    btnLogin.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            JpAdmLogin loginScreen = new JpAdmLogin();
	            loginScreen.setVisible(true);
	            dispose(); // dispose the current window
	        }
	    });
	    contentPane.add(btnLogin);
	    
	    JButton btnExit = new JButton("Exit");
	    btnExit.setBounds(952, 566, 89, 23);
	    contentPane.add(btnExit);
	    btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
	    
	    JButton btnLeaves = new JButton("Leaves");
	    btnLeaves.setBounds(447, 566, 89, 23);
	    contentPane.add(btnLeaves);
	    
	    JButton btnAttendance = new JButton("Attendance");
	    btnAttendance.setBounds(322, 566, 118, 23);
	    contentPane.add(btnAttendance);
	    
	    JButton btnPayroll = new JButton("Payroll");
	    btnPayroll.setBounds(226, 566, 89, 23);
	    contentPane.add(btnPayroll);
	    
	    final JButton btnClear = new JButton("Clear");
	    btnClear.addActionListener((ActionEvent e) -> {
			lblempID.setText("");
			lblempName.setText("");
			txtBirthday.setText("");
			txtAddress.setText("");
			txtPhone.setText("");
			txtSSS.setText("");
			txtPhilhealth.setText("");
			txtTIN.setText("");
			txtPagibig.setText("");
			txtStatus.setText("");
			txtPosition.setText("");
			txtSupervisor.setText("");
			txtBasic.setText("");
			txtRice.setText("");
			txtPhoneAllowance.setText("");
			txtClothing.setText("");
			txtGross.setText("");
			txtHourly.setText("");
			SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			        if (tblEmployeeDetails.getSelectedRowCount() > 0) {
						tblEmployeeDetails.clearSelection();
					}
			    }
			});
		});
	    btnClear.setBounds(680, 566, 89, 23);
	    contentPane.add(btnClear);
	    
	    // Render the table with Employee ID, Last Name and First Name, enforce only one row is selected
	    tblEmployeeDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    tblEmployeeDetails.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
	    	 if (!event.getValueIsAdjusting()) {
	    	        ListSelectionModel tblModel = tblEmployeeDetails.getSelectionModel();
	    	        int selectedRow = tblModel.getMinSelectionIndex();
	    	        // Handle selected row here
	    	        if (selectedRow >= 0 && selectedRow < tblEmployeeDetails.getRowCount()) {
	    		        final String empNumber = tblEmployeeDetails.getValueAt(selectedRow, 0).toString();
	    		        final String lastName = tblEmployeeDetails.getValueAt(selectedRow, 1).toString();
	    		        final String firstName = tblEmployeeDetails.getValueAt(selectedRow, 2).toString();
	    		        lblempID.setText(empNumber);
	    		        final String empname = (firstName+" "+lastName);
	    		        lblempName.setText(empname);
	    		        final ArrayList<Object> empdata = empData(empNumber);
	    		        txtBirthday.setText(empdata.get(0).toString());
	    		        txtAddress.setText(empdata.get(1).toString());
	    		        txtPhone.setText(empdata.get(2).toString());
	    		        txtSSS.setText(empdata.get(3).toString());
	    		        txtPhilhealth.setText(empdata.get(4).toString());
	    		        txtTIN.setText(empdata.get(5).toString());
	    		        txtPagibig.setText(empdata.get(6).toString());
	    		        txtStatus.setText(empdata.get(7).toString());
	    		        txtPosition.setText(empdata.get(8).toString());
	    		        txtSupervisor.setText(empdata.get(9).toString());
	    		        txtBasic.setText(empdata.get(10).toString());
	    		        txtRice.setText(empdata.get(11).toString());
	    		        txtPhoneAllowance.setText(empdata.get(12).toString());
	    		        txtClothing.setText(empdata.get(13).toString());
	    		        txtGross.setText(empdata.get(14).toString());
	    		        txtHourly.setText(empdata.get(15).toString());
	    		    }
	    	    }
	    	// do something with the selected row data
		    // final int selectedRow = tblEmployeeDetails.getSelectedRow();
		    
		});
	    
	    tblEmployeeDetails.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                JTable target = (JTable)e.getSource();
	                int row = target.getSelectedRow();
	                // Handle double-click event here
	                // For example, open a dialog to edit the content
	                // of the selected row
	                final String empNumber = tblEmployeeDetails.getValueAt(row, 0).toString();
	                final String lastName = tblEmployeeDetails.getValueAt(row, 1).toString();
	                final String firstName = tblEmployeeDetails.getValueAt(row, 2).toString();
	                // ...
	            }
	        }
	    });
	}
	
	
	
	
	
	public static ArrayList<Object> empList () {
		final List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();
		// final Object[] columns = {"Employee Number", "Last Name", "First Name"};
		final ArrayList<Object> newObj = new ArrayList<>();
		employeeDetails.forEach(ed -> {
			newObj.add(ed.getEmpid());
			newObj.add(ed.getEmpLname());
			newObj.add(ed.getEmpFName());
		});
		//System.out.println(newObj.size());
		return newObj;
	}
	
	public static ArrayList<Object> empData (String empId) {
		final List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();
		// final Object[] columns = {"Employee Number", "Last Name", "First Name"};
		final ArrayList<Object> newObj = new ArrayList<>();
		employeeDetails.forEach(ed -> {
			if (empId.equals(ed.getEmpid())) {
				newObj.add(ed.getEmpBdate());
				newObj.add(ed.getEmpAddress());
				newObj.add(ed.getEmpPhone());
				newObj.add(ed.getEmpSSS());
				newObj.add(ed.getEmpPhilhealth());
				newObj.add(ed.getEmpTIN());
				newObj.add(ed.getEmpPagibig());
				newObj.add(ed.getEmpStatus());
				newObj.add(ed.getEmpPosition());
				newObj.add(ed.getEmpSupervisor());
				newObj.add(ed.getEmpSalary());
				newObj.add(ed.getEmpRice());
				newObj.add(ed.getEmpPhoneAllowance());
				newObj.add(ed.getEmpClothing());
				newObj.add(ed.getEmpSemi());
				newObj.add(ed.getEmpRate());
			}
		});
		return newObj;
	}
}
