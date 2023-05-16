package moit103s1102g7.prototype;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JpEmpMainPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel JpEmpMainPanel;
	private JLabel lblEmpName;
	private JButton btnEmployeeProfile;
	private JButton btnLogout;
	Font font = new Font("Nexa Book", Font.BOLD, 15);
	
	public JpEmpMainPanel() {
			// Swing components
			// Initialize main panel
			JpEmpMainPanel = new JPanel();
			JpEmpMainPanel.setLayout(null);
			
			// Main panel components
			lblEmpName = new JLabel("");
			lblEmpName.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmpName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEmpName.setBounds(139, 53, 176, 30);
			JpEmpMainPanel.add(lblEmpName);
			
			btnEmployeeProfile = new JButton("My Profile");
			btnEmployeeProfile.setBounds(150, 94, 150, 30);
			btnEmployeeProfile.addActionListener((ActionEvent e) -> {
				JpEmpProfileMenu empMenu = new JpEmpProfileMenu();
				empMenu.setVisible(true);
				
			});
			
			JpEmpMainPanel.add(btnEmployeeProfile);
			
			btnLogout = new JButton("Log Out");
			btnLogout.setBounds(150, 135, 150, 30);
			btnLogout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
		        	dispose();
					JpAdmLogin admLogin = new JpAdmLogin();
					admLogin.setVisible(true);				}
			});
			
			JpEmpMainPanel.add(btnLogout);
			getContentPane().add(JpEmpMainPanel);
			
			JLabel lblMainMenu_1 = new JLabel("Payroll Application Menu");
			lblMainMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblMainMenu_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMainMenu_1.setBounds(139, 20, 176, 30);
			JpEmpMainPanel.add(lblMainMenu_1);
	}
}
