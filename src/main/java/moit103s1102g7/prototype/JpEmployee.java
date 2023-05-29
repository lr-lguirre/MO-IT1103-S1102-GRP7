package moit103s1102g7.prototype;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.opencsv.exceptions.CsvException;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class JpEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPersonalInfo;
	private JLabel lblEmployeeNo;
	private JLabel lblLastName;
	private JLabel lblFirstName;
	private JLabel lblBirthday;
	private JLabel lblAddress;
	private JLabel lblPhoneNo;
	private JLabel lblSssNo;
	private JLabel lblPhic;
	private JLabel lblTinNo;
	private JLabel lblHdmfNo;
	private JTextField txtEmployeeNo;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtBirthday;
	private JTextArea txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtSssNo;
	private JTextField txtPhic;
	private JTextField txtTinNo;
	private JTextField txtHdmfNo;
	// Variables for Salary Info Panel

	private JButton btnLogout;
	private JPanel personalInfoPanel;
	private JPanel salaryInfoPanel;
	protected String uid;

	public JpEmployee(String uid) {
		Helper helper = new Helper();
		Map<String, Object> empinfo = helper.employeeInfo(uid);
		String fname = (String) empinfo.get("empFName");
		String lname = (String) empinfo.get("empLname");
		String birthday = (String) empinfo.get("empBdate");
		String address = (String) empinfo.get("empAddress");
		String phone = (String) empinfo.get("empPhone");
		String sss = (String) empinfo.get("empSSS");
		String philhealth = (String) empinfo.get("empPhilhealth");
		String tin = (String) empinfo.get("empTIN");
		String pagibig = (String) empinfo.get("empPagibig");

		// Swing components
		// Initialize panel for personal information
		personalInfoPanel = new JPanel();
		personalInfoPanel.setLayout(null);

		// Personal Info panel components
		lblPersonalInfo = new JLabel("Personal Information");
		lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeNo = new JLabel("Employee No.:");
		lblLastName = new JLabel("Last Name:");
		lblFirstName = new JLabel("First Name");
		lblBirthday = new JLabel("Birthday:");
		lblAddress = new JLabel("Address:");
		lblPhoneNo = new JLabel("Phone No.:");
		lblSssNo = new JLabel("SSS No.:");
		lblPhic = new JLabel("Philhealth No.:");
		lblTinNo = new JLabel("TIN No.:");
		lblHdmfNo = new JLabel("Pag-ibig No.:");

		txtEmployeeNo = new JTextField(20);
		txtEmployeeNo.setEditable(false);
		txtEmployeeNo.setEnabled(false);
		txtEmployeeNo.setText(uid);
		txtEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));

		txtLastName = new JTextField(20);
		txtLastName.setEditable(false);
		txtLastName.setEnabled(false);
		txtLastName.setText(lname);
		txtLastName.setDisabledTextColor(new Color(128, 128, 128));

		txtFirstName = new JTextField(20);
		txtFirstName.setEditable(false);
		txtFirstName.setEnabled(false);
		txtFirstName.setText(fname);
		txtFirstName.setDisabledTextColor(new Color(128, 128, 128));

		txtBirthday = new JTextField(20);
		txtBirthday.setEditable(false);
		txtBirthday.setEnabled(false);
		txtBirthday.setText(birthday);
		txtBirthday.setDisabledTextColor(new Color(128, 128, 128));

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(150, 270, 89, 30);
		personalInfoPanel.add(btnUpdate);
		btnUpdate.setEnabled(false);

		txtAddress = new JTextArea(0, 0);
		txtAddress.setEnabled(true);
		txtAddress.setLineWrap(true);
		txtAddress.setWrapStyleWord(true);
		txtAddress.setText(address);
		txtAddress.setDisabledTextColor(new Color(128, 128, 128));
		txtAddress.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnUpdate.setEnabled(true);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtAddress.getText().isEmpty()) {
					btnUpdate.setEnabled(false);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// Not used for plain text documents
			}
		});

		txtPhoneNo = new JTextField(20);
		txtPhoneNo.setEnabled(true);
		txtPhoneNo.setText(phone);
		txtPhoneNo.setDisabledTextColor(new Color(128, 128, 128));
		txtPhoneNo.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnUpdate.setEnabled(true);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtPhoneNo.getText().isEmpty()) {
					btnUpdate.setEnabled(false);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// Not used for plain text documents
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
		    public void actionPerformed(ActionEvent evt) {                                           
		        String newAddress = txtAddress.getText();
		        String newPhone = txtPhoneNo.getText();
		        
		        if( newAddress.equals("") || newPhone.equals("")) {
		            JOptionPane.showMessageDialog(null, "Please fill up all fields.");
		        } else if (!Helper.isValidPhoneNumber(newPhone)) {
		            JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
		        } else {
		            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to update your details?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if(option == JOptionPane.YES_OPTION) {
		                try {
		                    Helper.updateEmployeeDetails(uid, newAddress, newPhone);
		                    JOptionPane.showMessageDialog(null, "Employee details updated successfully.");
		                    btnUpdate.setEnabled(false);
		                } catch (IOException ex) {
		                    JOptionPane.showMessageDialog(null, "Error updating employee details: " + ex.getMessage());
		                } catch (CsvException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            } else {
		                // do nothing
		            }
		        }        
		    }
		});

		txtSssNo = new JTextField(20);
		txtSssNo.setEditable(false);
		txtSssNo.setEnabled(false);
		txtSssNo.setText(sss);
		txtSssNo.setDisabledTextColor(new Color(128, 128, 128));

		txtPhic = new JTextField(20);
		txtPhic.setEditable(false);
		txtPhic.setEnabled(false);
		txtPhic.setText(philhealth);
		txtPhic.setDisabledTextColor(new Color(128, 128, 128));

		txtTinNo = new JTextField(20);
		txtTinNo.setEditable(false);
		txtTinNo.setEnabled(false);
		txtTinNo.setText(tin);
		txtTinNo.setDisabledTextColor(new Color(128, 128, 128));

		txtHdmfNo = new JTextField(20);
		txtHdmfNo.setEditable(false);
		txtHdmfNo.setEnabled(false);
		txtHdmfNo.setText(pagibig);
		txtHdmfNo.setDisabledTextColor(new Color(128, 128, 128));

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(490, 270, 80, 30);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JpEmpProfileMenu empMenu = new JpEmpProfileMenu(uid);
				empMenu.setVisible(true);
			}
		});

		// Set label and text field positions
		lblPersonalInfo.setBounds(250, 10, 250, 40);
		lblEmployeeNo.setBounds(50, 50, 100, 20);
		txtEmployeeNo.setBounds(150, 50, 150, 20);
		lblLastName.setBounds(50, 80, 100, 20);
		txtLastName.setBounds(150, 80, 150, 20);
		lblFirstName.setBounds(50, 110, 100, 20);
		txtFirstName.setBounds(150, 110, 150, 20);
		lblBirthday.setBounds(50, 140, 100, 20);
		txtBirthday.setBounds(150, 140, 150, 20);
		lblAddress.setBounds(50, 170, 100, 20);
		txtAddress.setBounds(150, 170, 250, 49);
		lblPhoneNo.setBounds(50, 230, 100, 20);
		txtPhoneNo.setBounds(150, 230, 150, 20);
		lblSssNo.setBounds(320, 140, 100, 20);
		txtSssNo.setBounds(420, 140, 150, 20);
		lblPhic.setBounds(320, 50, 100, 20);
		txtPhic.setBounds(420, 50, 150, 20);
		lblTinNo.setBounds(320, 80, 100, 20);
		txtTinNo.setBounds(420, 80, 150, 20);
		lblHdmfNo.setBounds(320, 110, 100, 20);
		txtHdmfNo.setBounds(420, 110, 150, 20);

		// Add components to personal info panel
		personalInfoPanel.add(lblPersonalInfo);
		personalInfoPanel.add(lblEmployeeNo);
		personalInfoPanel.add(txtEmployeeNo);
		personalInfoPanel.add(lblLastName);
		personalInfoPanel.add(txtLastName);
		personalInfoPanel.add(lblFirstName);
		personalInfoPanel.add(txtFirstName);
		personalInfoPanel.add(lblBirthday);
		personalInfoPanel.add(txtBirthday);
		personalInfoPanel.add(lblAddress);
		personalInfoPanel.add(txtAddress);
		personalInfoPanel.add(lblPhoneNo);
		personalInfoPanel.add(txtPhoneNo);
		personalInfoPanel.add(lblSssNo);
		personalInfoPanel.add(txtSssNo);
		personalInfoPanel.add(lblPhic);
		personalInfoPanel.add(txtPhic);
		personalInfoPanel.add(lblTinNo);
		personalInfoPanel.add(txtTinNo);
		personalInfoPanel.add(lblHdmfNo);
		personalInfoPanel.add(txtHdmfNo);
		personalInfoPanel.add(btnLogout);

		// Initialize panel for salary info
		salaryInfoPanel = new JPanel();
		salaryInfoPanel.setLayout(null);

		// Add main panel to the frame
		getContentPane().add(personalInfoPanel);

		JButton btnPayslip = new JButton("Payslip");
		btnPayslip.addActionListener((ActionEvent e) -> {
				setVisible(false);
				dispose();
				JpEmpPayslip payslip = new JpEmpPayslip(uid);
				payslip.setVisible(true);
		});
		btnPayslip.setBounds(481, 169, 89, 23);
		personalInfoPanel.add(btnPayslip);

		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.setBounds(481, 199, 89, 23);
		personalInfoPanel.add(btnAttendance);

		JButton btnNewButton = new JButton("Leaves");
		btnNewButton.setBounds(481, 230, 89, 21);
		personalInfoPanel.add(btnNewButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("View");
		menuBar.setBounds(0, 0, 37, 22);
		personalInfoPanel.add(menuBar);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenuItem mntmPayslip = new JMenuItem("Payslip");
		mnView.add(mntmPayslip);

		JMenuItem mntmAttendance = new JMenuItem("Attendance");
		mnView.add(mntmAttendance);

		JMenuItem mntmLeaves = new JMenuItem("Leaves");
		mnView.add(mntmLeaves);

		// Set-up the frame
		setTitle("Employee Info Menu");
		setSize(630, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					// Close the application
					System.exit(0);
				}
			}
		});
		setResizable(true);

		// Sets icon image for the application
		ImageIcon icon = new ImageIcon("MOTORPH.png");
		setIconImage(icon.getImage());

		personalInfoPanel.setVisible(true);

	}
}