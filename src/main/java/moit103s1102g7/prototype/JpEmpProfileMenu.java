package moit103s1102g7.prototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JpEmpProfileMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel profilePanel;
	private JLabel lblProfileMenu;
	private JButton btnPersonalInfo;
	private JButton btnSalaryInfo;
	private JButton btnDailyTimesheet;
	private JButton btnPayslip;
	private JButton btnBack;
	Font font = new Font("Nexa Book", Font.BOLD, 15);
	private String uid;

	/**
	 * Create the frame.
	 */
	public JpEmpProfileMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		profilePanel = new JPanel();
		profilePanel.setLayout(null);
		
		// Profile panel components
		lblProfileMenu = new JLabel("My Profile Menu");
		lblProfileMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfileMenu.setBounds(170, 10, 450, 30);
		profilePanel.add(lblProfileMenu);
		
		btnPersonalInfo = new JButton("Personal Information");
		btnSalaryInfo = new JButton("Salary Information");
		btnDailyTimesheet = new JButton("Daily Timesheet");
		btnPayslip = new JButton("Payslip");
		btnBack = new JButton("Main Menu");
		
		btnPersonalInfo.setBounds(45, 55, 155, 30);
		btnSalaryInfo.setBounds(245, 55, 155, 30);
		btnDailyTimesheet.setBounds(45, 95, 155, 30);
		btnPayslip.setBounds(245, 95, 155, 30);
		btnBack.setBounds(170, 135, 100, 30);
		
		btnPersonalInfo.addActionListener((ActionEvent e) -> {
			setVisible(false);
			dispose();
			JpEmployee empInfo = new JpEmployee(uid);
			//jpEmployee.printPersonalInfo();
			
		});
		
		btnSalaryInfo.addActionListener((ActionEvent e1) -> {
			setVisible(false);
			dispose();
			//jpEmployee.printSalaryRecords();
			
		});
		
		btnDailyTimesheet.addActionListener((ActionEvent e2) -> {
			setVisible(false);
			dispose();
			//hoursWorked.displayTimeSheet();
			
		});
		
		btnPayslip.addActionListener((ActionEvent e3) -> {
			setVisible(false);
			dispose();
			//.displayPayslip();
			
		});
		
		btnBack.addActionListener((ActionEvent e4) -> {
			//mainMenu();
			
		});
		
		profilePanel.add(btnPersonalInfo);
		profilePanel.add(btnSalaryInfo);
		profilePanel.add(btnDailyTimesheet);
		profilePanel.add(btnPayslip);
		profilePanel.add(btnBack);
		setContentPane(profilePanel);
	}

}
