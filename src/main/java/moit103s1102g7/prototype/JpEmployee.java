package moit103s1102g7.prototype;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class JpEmployee extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPersonalInfo;
	private JLabel lblSalaryInfo;
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
	private JTextField txtAddress;
	private JTextField txtPhoneNo;
	private JTextField txtSssNo;
	private JTextField txtPhic;
	private JTextField txtTinNo;
	private JTextField txtHdmfNo;
	// Variables for Salary Info Panel
	private JLabel lblSalEmployeeNo;
	private JLabel lblEmployeeStats;
	private JLabel lblEmployeePosition;
	private JLabel lblSalaryClass;
	private JLabel lblBasicSalary;
	private JLabel lblRiceSubsidy;
	private JLabel lblPhoneAllowance;
	private JLabel lblClothingAllowance;
	private JTextField txtSalEmployeeNo;
	private JTextField txtEmployeeStats;
	private JTextField txtEmployeePosition;
	private JTextField txtSalaryClass;
	private JTextField txtBasicSalary;
	private JTextField txtRiceSubsidy;
	private JTextField txtPhoneAllowance;
	private JTextField txtClothingAllowance;
	
	private JButton btnLogout;
	private JButton btnSalaryBack;
	private JPanel personalInfoPanel;
	private JPanel salaryInfoPanel;
	protected String uid;
	
	public JpEmployee(String uid) {

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
		lblSssNo= new JLabel("SSS No.:");
		lblPhic = new JLabel("Philhealth No.:");
		lblTinNo = new JLabel("TIN No.:");
		lblHdmfNo = new JLabel("Pag-ibig No.:");
		
		txtEmployeeNo = new JTextField(20);
		txtEmployeeNo.setEditable(false);
		txtEmployeeNo.setEnabled(false);
		txtEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
		
		txtLastName = new JTextField(20);
		txtLastName.setEditable(false);
		txtLastName.setEnabled(false);
		txtLastName.setDisabledTextColor(new Color(128, 128, 128));
		
		txtFirstName = new JTextField(20);
		txtFirstName.setEditable(false);
		txtFirstName.setEnabled(false);
		txtFirstName.setDisabledTextColor(new Color(128, 128, 128));
		
		txtBirthday = new JTextField(20);
		txtBirthday.setEditable(false);
		txtBirthday.setEnabled(false);
		txtBirthday.setDisabledTextColor(new Color(128, 128, 128));
		
		txtAddress = new JTextField(20);
		txtAddress.setEnabled(false);
		txtAddress.setDisabledTextColor(new Color(128, 128, 128));
		
		txtPhoneNo = new JTextField(20);
		txtPhoneNo.setEnabled(false);
		txtPhoneNo.setDisabledTextColor(new Color(128, 128, 128));
		
		txtSssNo = new JTextField(20);
		txtSssNo.setEditable(false);
		txtSssNo.setEnabled(false);
		txtSssNo.setDisabledTextColor(new Color(128, 128, 128));
		
		txtPhic = new JTextField(20);
		txtPhic.setEditable(false);
		txtPhic.setEnabled(false);
		txtPhic.setDisabledTextColor(new Color(128, 128, 128));
		
		txtTinNo = new JTextField(20);
		txtTinNo.setEditable(false);
		txtTinNo.setEnabled(false);
		txtTinNo.setDisabledTextColor(new Color(128, 128, 128));
		
		txtHdmfNo = new JTextField(20);
		txtHdmfNo.setEditable(false);
		txtHdmfNo.setEnabled(false);
		txtHdmfNo.setDisabledTextColor(new Color(128, 128, 128));
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(490, 270, 80, 30);
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callProfileMenu();				
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
		txtAddress.setBounds(150, 170, 150, 20);
		lblPhoneNo.setBounds(50, 200, 100, 20);
		txtPhoneNo.setBounds(150, 200, 150, 20);
		lblSssNo.setBounds(50, 230, 100, 20);
		txtSssNo.setBounds(150, 230, 150, 20);
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
		
		// Salary Info Panel components
		lblSalaryInfo = new JLabel("Salary Information");
		lblSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalEmployeeNo = new JLabel("Employee No.:");
		lblEmployeeStats = new JLabel("Employee Status:");
		lblEmployeePosition = new JLabel("Employee Position:");
		lblSalaryClass = new JLabel("Salary Class:");
		lblBasicSalary = new JLabel("Basic Salary:");
		lblRiceSubsidy = new JLabel("Rice Subsidy:");
		lblPhoneAllowance = new JLabel("Phone Allowance:");
		lblClothingAllowance = new JLabel("Clothing Subsidy:");
		
		txtSalEmployeeNo = new JTextField(20);
		txtSalEmployeeNo.setEnabled(false);
		txtSalEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
		txtSalEmployeeNo.setText(uid);
		
		txtEmployeeStats = new JTextField(20);
		txtEmployeeStats.setEnabled(false);
		txtEmployeeStats.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeeStats.setText("Regular");
		
		txtEmployeePosition	= new JTextField(20);
		txtEmployeePosition.setEnabled(false);
		txtEmployeePosition.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeePosition.setText("HR Manager");
		
		txtSalaryClass = new JTextField(20);
		txtSalaryClass.setEnabled(false);
		txtSalaryClass.setDisabledTextColor(new Color(128, 128, 128));
		txtSalaryClass.setText("Rank and File");
		
		txtBasicSalary = new JTextField(20);
		txtBasicSalary.setEnabled(false);
		txtBasicSalary.setDisabledTextColor(new Color(128, 128, 128));
		txtBasicSalary.setText("PHP 62, 670.00");
		
		txtRiceSubsidy = new JTextField(20);
		txtRiceSubsidy.setEnabled(false);
		txtRiceSubsidy.setDisabledTextColor(new Color(128, 128, 128));
		txtRiceSubsidy.setText("PHP 1,500.00");
		
		txtPhoneAllowance = new JTextField(20);
		txtPhoneAllowance.setEnabled(false);
		txtPhoneAllowance.setDisabledTextColor(new Color(128, 128, 128));
		txtPhoneAllowance.setText("PHP 1,000.00");
		
		txtClothingAllowance = new JTextField(20);
		txtClothingAllowance.setEnabled(false);
		txtClothingAllowance.setDisabledTextColor(new Color(128, 128, 128));
		txtClothingAllowance.setText("PHP 1,000.00");
		
		btnSalaryBack = new JButton("Back");
		btnSalaryBack.setBounds(265, 260, 80, 30);
		btnSalaryBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callProfileMenu();				
			}
		});
		
		// Set label and text field positions
		lblSalaryInfo.setBounds(250, 10, 150, 40);
		lblSalEmployeeNo.setBounds(20, 60, 100, 20);
		txtSalEmployeeNo.setBounds(150, 60, 150, 20);
		lblEmployeeStats.setBounds(320, 60, 100, 20);
		txtEmployeeStats.setBounds(430, 60, 150, 20);
		lblEmployeePosition.setBounds(20, 100, 120, 20);
		txtEmployeePosition.setBounds(150, 100, 150, 20);
		lblSalaryClass.setBounds(320, 100, 100, 20);
		txtSalaryClass.setBounds(430, 100, 150, 20);
		lblBasicSalary.setBounds(20, 140, 100, 20);
		txtBasicSalary.setBounds(150, 140, 150, 20);
		lblRiceSubsidy.setBounds(320, 140, 100, 20);
		txtRiceSubsidy.setBounds(430, 140, 150, 20);
		lblPhoneAllowance.setBounds(20, 180, 120, 20);
		txtPhoneAllowance.setBounds(150, 180, 150, 20);
		lblClothingAllowance.setBounds(320, 180, 110, 20);
		txtClothingAllowance.setBounds(430, 180, 150, 20);

		// Add components to salary info panel
		salaryInfoPanel.add(lblSalaryInfo);
		salaryInfoPanel.add(lblSalEmployeeNo);
		salaryInfoPanel.add(txtSalEmployeeNo);
		salaryInfoPanel.add(lblEmployeeStats);
		salaryInfoPanel.add(lblEmployeePosition);
		salaryInfoPanel.add(lblSalaryClass);
		salaryInfoPanel.add(lblBasicSalary);
		salaryInfoPanel.add(lblRiceSubsidy);
		salaryInfoPanel.add(lblPhoneAllowance);
		salaryInfoPanel.add(lblClothingAllowance);
		salaryInfoPanel.add(txtEmployeeStats);
		salaryInfoPanel.add(txtEmployeePosition);
		salaryInfoPanel.add(txtSalaryClass);
		salaryInfoPanel.add(txtBasicSalary);
		salaryInfoPanel.add(txtRiceSubsidy);
		salaryInfoPanel.add(txtPhoneAllowance);
		salaryInfoPanel.add(txtClothingAllowance);
		salaryInfoPanel.add(btnSalaryBack);
		
		
		// Add main panel to the frame
		getContentPane().add(personalInfoPanel);
		
		JButton btnPayslip = new JButton("Payslip");
		btnPayslip.setBounds(481, 139, 89, 23);
		personalInfoPanel.add(btnPayslip);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.setBounds(481, 169, 89, 23);
		personalInfoPanel.add(btnAttendance);
		
		JButton btnNewButton = new JButton("Leaves");
		btnNewButton.setBounds(481, 200, 89, 21);
		personalInfoPanel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(150, 270, 89, 30);
		personalInfoPanel.add(btnUpdate);
		
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
		setSize(630,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
    	    public void windowClosing(WindowEvent e) {
    	        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
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
	
	public void printPersonalInfo() {
//		salaryInfoPanel.setVisible(false); 	
//    	getContentPane().remove(salaryInfoPanel);
//    	getContentPane().add(profilePanel);
    	setContentPane(personalInfoPanel);
    	setVisible(true);
    	// Repaint the frame
        revalidate();
        repaint();
		
	}
	
	public void printSalaryRecords() {
		
		setContentPane(salaryInfoPanel);
    	setVisible(true);
    	// Repaint the frame
        revalidate();
        repaint();
		
		
		/*
		System.out.println("Salary Information:");
		
		for (int i = 0; i < 50; i++) {
			System.out.print("=");}
		
		System.out.println();
		System.out.println(employeeSalary);
		
		for (int i = 0; i < 50; i++) {
			System.out.print("=");}
			*/
	}
	
	public void callProfileMenu() {
		
		// Hide Employee Info Window
		setVisible(false);
		dispose();
		JpPayrollSystem payroll = new JpPayrollSystem(uid);
		payroll.profileMenu();
		
	}
}