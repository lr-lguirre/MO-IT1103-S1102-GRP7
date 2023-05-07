package moit103s1102g7.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JpAdmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				final JpAdmLogin frame = new JpAdmLogin();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JpAdmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JpAdmLogin.class.getResource("/org/springframework/beans/factory/xml/spring-beans.gif")));
		setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("MotorPH");
		contentPane.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("MOTORPH Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setBounds(134, 29, 216, 36);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 14));
		username.setBounds(141, 77, 198, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(30, 80, 66, 17);
		contentPane.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(30, 127, 66, 17);
		contentPane.add(lblNewLabel_1_1);
		
		pass = new JPasswordField();
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					final char[] pwd = pass.getPassword();
					final String uid = username.getText();
					if (helperAuth.admAuth(uid, pwd)) {
						username.setText(null);
						pass.setText(null);
						JOptionPane.showMessageDialog(contentPane, "Successful Login.");
						JpEmpList frame = new JpEmpList();
						JFrame loginWindow = (JFrame) SwingUtilities.getWindowAncestor(contentPane);
				        loginWindow.dispose();
			            frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(contentPane, "Invalid password. Try again.", "Error Message",
								JOptionPane.ERROR_MESSAGE);
					}
					Arrays.fill(pwd, '0');
					pass.selectAll();
				}
			}
		});
		pass.setFont(new Font("Arial", Font.PLAIN, 12));
		pass.setBounds(141, 125, 198, 20);
		contentPane.add(pass);
		;
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        final char[] pwd = pass.getPassword();
		        final String uid = username.getText();
		        if (helperAuth.admAuth(uid, pwd)) {
		            username.setText(null);
		            pass.setText(null);
		            JOptionPane.showMessageDialog(contentPane, "Successful Login.");
		            JpEmpList frame = new JpEmpList();
		            frame.setVisible(true);
		            // Dismiss the login window
		            JFrame loginWindow = (JFrame) SwingUtilities.getWindowAncestor(btnLogin);
		            loginWindow.dispose();
		        } else {
		            JOptionPane.showMessageDialog(contentPane, "Invalid password. Try again.",
		                    "Error Message",
		                    JOptionPane.ERROR_MESSAGE);
		        }
		        Arrays.fill(pwd, '0');
		        pass.selectAll();
		    }
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLogin.setBounds(145, 182, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExit.setBounds(250, 182, 89, 23);
		contentPane.add(btnExit);
	}
}
