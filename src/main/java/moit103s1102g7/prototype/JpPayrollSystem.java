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
	private JpHoursWorked jpHoursWorked;
	private PrintNReadTxt printNRead;
	private JpEmpPayslip jpEmpPayslip;
	// private variables for the Swing components
	Font font = new Font("Nexa Book", Font.BOLD, 15);
	
	public JpPayrollSystem(String uid) { // Constructor
		// Initialize objects
		jpEmployee = new JpEmployee(uid);
		jpHoursWorked = new JpHoursWorked();
		printNRead = new PrintNReadTxt();
		jpEmpPayslip = new JpEmpPayslip(uid);
		// Initialize the profile panel
		
		// Set-up the frame
		setTitle("MotorPH Payroll System Menu");
		setSize(450,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
    	    @Override
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
    }
}