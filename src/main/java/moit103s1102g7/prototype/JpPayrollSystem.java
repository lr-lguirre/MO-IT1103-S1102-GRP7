package moit103s1102g7.prototype;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JpPayrollSystem extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JpEmployee jpEmployee;
	private HoursWorked hoursWorked;
	private PrintNReadTxt printNRead;
	private JpPayslip jpPayslip;
	// private variables for the Swing components
	private JPanel mainPanel;
	private JPanel profilePanel;
	private JLabel lblMainMenu;
	private JLabel lblProfileMenu;
	private JButton btnEmployeeProfile;
	private JButton btnEmployeeMaster;
	private JButton btnLogout;
	private JButton btnPersonalInfo;
	private JButton btnSalaryInfo;
	private JButton btnDailyTimesheet;
	private JButton btnPayslip;
	private JButton btnBack;
	Font font = new Font("Nexa Book", Font.BOLD, 15);
	
	
	Scanner scan = new Scanner(System.in);
	
	public JpPayrollSystem() { // Constructor
		
		// Initialize objects
		jpEmployee = new JpEmployee();
		hoursWorked = new HoursWorked();
		printNRead = new PrintNReadTxt();
		jpPayslip = new JpPayslip();
		
		// Swing components
		// Initialize main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		// Main panel components
		lblMainMenu = new JLabel("Payroll Application Menu");
		lblMainMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainMenu.setBounds(139, 10, 450, 30);
		mainPanel.add(lblMainMenu);
		
		btnEmployeeProfile = new JButton("My Employee Profile");
		btnEmployeeProfile.setBounds(150, 55, 150, 30);
		btnEmployeeProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				profileMenu();
				
			}
		});
		
		mainPanel.add(btnEmployeeProfile);
		
		btnEmployeeMaster = new JButton("Employee Master");
		btnEmployeeMaster.setBounds(150, 95, 150, 30);
		btnEmployeeMaster.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JpPayrollSystem.this, "This option is not yet available.", "Sorry!", JOptionPane.INFORMATION_MESSAGE, null);
				
			}
		});
		
		mainPanel.add(btnEmployeeMaster);
		
		btnLogout = new JButton("Log Out");
		btnLogout.setBounds(150, 135, 150, 30);
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	dispose();
				callMainMenu();
				
			}
		});
		
		mainPanel.add(btnLogout);
		
		// Initialize the profile panel
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
		
		btnPersonalInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				jpEmployee.printPersonalInfo();
				
			}
		});
		
		btnSalaryInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				jpEmployee.printSalaryRecords();
				
			}
		});
		
		btnDailyTimesheet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				hoursWorked.displayTimeSheet();
				
			}
		});
		
		btnPayslip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				jpPayslip.displayPayslip();
				
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenu();
				
			}
		});
		
		profilePanel.add(btnPersonalInfo);
		profilePanel.add(btnSalaryInfo);
		profilePanel.add(btnDailyTimesheet);
		profilePanel.add(btnPayslip);
		profilePanel.add(btnBack);
		
		// Add main panel to the frame
		getContentPane().add(mainPanel);
		
		// Set-up the frame
		setTitle("MotorPH Payroll System Menu");
		setSize(450,250);
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
    	setResizable(false);
    	
    	// Sets icon image for the application
    	ImageIcon icon = new ImageIcon("MOTORPH.png");
    	setIconImage(icon.getImage());
    	
    	mainPanel.setVisible(true);
    	
		
	}
	
	/*
	 * public static void main(String[] args) { PayrollSystem payroll = new
	 * PayrollSystem(); payroll.callMainMenu(); }
	 */
	
	/*
	 * public void callMainMenu() {
	 * 
	 * UserLogin userLogin = new UserLogin(); userLogin.setVisible(true);
	 * 
	 * 
	 * }
	 */
    
    public void mainMenu() {
    	profilePanel.setVisible(false);
    	printNRead.printRead();   	
    	getContentPane().remove(profilePanel);
//    	getContentPane().add(profilePanel);
    	setContentPane(mainPanel);
    	setVisible(true);
    	// Repaint the frame
        revalidate();
        repaint(); 
         
    }
    
    public void profileMenu() {
    	setVisible(true);
    	profilePanel.setVisible(true);
    	// Remove the main panel from the frame
        getContentPane().remove(mainPanel);

        // Add the profile panel to the frame
        getContentPane().add(profilePanel);
        setContentPane(profilePanel);
        // Repaint the frame
        revalidate();
        repaint();
   }
}