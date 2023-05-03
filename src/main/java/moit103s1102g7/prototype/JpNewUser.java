package moit103s1102g7.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class JpNewUser extends JFrame {

	private JPanel contentPane;
	private JTextField empID;
	private JTextField password1;
	private JTextField password2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JpNewUser frame = new JpNewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JpNewUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		empID = new JTextField();
		empID.setBounds(108, 73, 118, 20);
		contentPane.add(empID);
		empID.setColumns(10);
		
		password1 = new JTextField();
		password1.setColumns(10);
		password1.setBounds(108, 104, 233, 20);
		contentPane.add(password1);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(108, 135, 233, 20);
		contentPane.add(password2);
		
		JLabel lblNewAccountSignUp = new JLabel("New Account Sign-up");
		lblNewAccountSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAccountSignUp.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewAccountSignUp.setBounds(75, 21, 233, 20);
		contentPane.add(lblNewAccountSignUp);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setBounds(10, 76, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 107, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Repeat Password");
		lblNewLabel_2.setBounds(10, 138, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSignUp = new JButton("Sign-Up");
		btnSignUp.setBounds(108, 195, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(228, 195, 89, 23);
		contentPane.add(btnCancel);
	}
}
