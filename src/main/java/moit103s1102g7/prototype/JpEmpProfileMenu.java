package moit103s1102g7.prototype;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JpEmpProfileMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel profilePanel;
	private JLabel lblProfileMenu;
	private JButton btnPersonalInfo;
	private JButton btnPayslip;
	private JButton btnBack;
	Font font = new Font("Nexa Book", Font.BOLD, 15);
	private String uid;

	/**
	 * Create the frame.
	 */
	public JpEmpProfileMenu(String uid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		profilePanel = new JPanel();
		setContentPane(profilePanel);
		profilePanel.setLayout(null);

		
		// Profile panel components
		lblProfileMenu = new JLabel("My Profile Menu");
		lblProfileMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfileMenu.setBounds(170, 10, 450, 30);
		profilePanel.add(lblProfileMenu);
		
		btnPersonalInfo = new JButton("Personal Information");
		btnPayslip = new JButton("Payslip");
		btnBack = new JButton("Main Menu");
		
		btnPersonalInfo.setBounds(45, 55, 155, 30);
		btnPayslip.setBounds(241, 55, 155, 30);
		btnBack.setBounds(170, 135, 100, 30);
		
		btnPersonalInfo.addActionListener((ActionEvent e) -> {
			setVisible(false);
			dispose();
			JpEmployee empInfo = new JpEmployee(uid);
			empInfo.setVisible(true);
		});
		profilePanel.add(btnPersonalInfo);
		
		btnPayslip.addActionListener((ActionEvent e3) -> {
			setVisible(false);
			dispose();
			JpEmpPayslip payslip = new JpEmpPayslip(uid);
			payslip.setVisible(true);
		});
		profilePanel.add(btnPayslip);
		
		btnBack.addActionListener((ActionEvent e4) -> {
			setVisible(false);
			dispose();
			JpEmpMainPanel mainPanel = new JpEmpMainPanel(uid);
			mainPanel.setVisible(true);			
		});
		profilePanel.add(btnBack);
	}

}
