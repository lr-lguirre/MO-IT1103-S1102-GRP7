package moit103s1102g7.prototype;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JpEmpMainPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblEmpName;
	private JButton btnEmployeeProfile;
	private JButton btnLogout;
	Font font = new Font("Nexa Book", Font.BOLD, 15);
	
	public JpEmpMainPanel(String uid) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(JpEmpMainPanel.class.getResource("/org/springframework/beans/factory/xml/spring-beans.gif")));
		setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("MotorPH");
		contentPane.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Employee Application Menu");
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Main panel components
		lblEmpName = new JLabel("");
		lblEmpName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpName.setBounds(139, 53, 176, 30);
		contentPane.add(lblEmpName);

		btnEmployeeProfile = new JButton("My Profile");
		btnEmployeeProfile.setBounds(150, 94, 150, 30);
		btnEmployeeProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose();
			JpEmpProfileMenu empMenu = new JpEmpProfileMenu(uid);
			empMenu.setVisible(true);
			}
		});

		contentPane.add(btnEmployeeProfile);

		btnLogout = new JButton("Log Out");
		btnLogout.setBounds(150, 135, 150, 30);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JpAdmLogin admLogin = new JpAdmLogin();
				admLogin.setVisible(true);
			}
		});

		contentPane.add(btnLogout);

		JLabel lblMainMenu_1 = new JLabel("Employee Application Menu");
		lblMainMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMenu_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainMenu_1.setBounds(114, 11, 212, 30);
		contentPane.add(lblMainMenu_1);
	}
}
