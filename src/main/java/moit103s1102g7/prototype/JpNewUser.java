package moit103s1102g7.prototype;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class JpNewUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField empID;
	private String username;
	private JTextField textTIN1;
	private JTextField textTIN2;
	private JTextField textTIN3;
	private JTextField textTIN4;
	private JPasswordField textPassword1;
	private JPasswordField textPassword2;
	static List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();
	static List<employeeLogin> employeeLogin = readCsvFiles.employeeLogin();

	/**
	 * Launch the application.
	 */
	/*
	 * public static void newUserSignUp(String[] args) { EventQueue.invokeLater(()
	 * -> { try { JpNewUser frame = new JpNewUser(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } }); }
	 */

	/**
	 * Create the frame.
	 */
	public JpNewUser(String username) {
		this.username = username;
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
		empID.setEditable(false);
		empID.setText(username);
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
		lblWelcome.setBounds(10, 11, 86, 20);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setBounds(10, 76, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 139, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Repeat Password");
		lblNewLabel_2.setBounds(10, 170, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JpAdmLogin admLogin = new JpAdmLogin();
				admLogin.setVisible(true);
				dispose();
			}
		});
		btnCancel.setBounds(219, 227, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_3 = new JLabel("TIN #");
		lblNewLabel_3.setToolTipText("Enter TIN for Employee ID verification");
		lblNewLabel_3.setBounds(10, 101, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textTIN1 = new JTextField();
		textTIN1.setBounds(108, 104, 39, 20);
		contentPane.add(textTIN1);
		textTIN1.setColumns(10);
		
		textTIN2 = new JTextField();
		textTIN2.setBounds(157, 104, 39, 20);
		contentPane.add(textTIN2);
		textTIN2.setColumns(10);
		
		textTIN3 = new JTextField();
		textTIN3.setBounds(206, 105, 39, 20);
		contentPane.add(textTIN3);
		textTIN3.setColumns(10);
		
		textTIN4 = new JTextField();
		textTIN4.setEditable(false);
		textTIN4.setText("000");
		textTIN4.setBounds(255, 105, 39, 20);
		contentPane.add(textTIN4);
		textTIN4.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 213, 414, 2);
		contentPane.add(separator);
		
		JLabel lblEmpName = new JLabel("");
		lblEmpName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpName.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmpName.setBounds(85, 17, 309, 14);
		// employeeDetails.stream().anyMatch(e -> e.getEmpid().equals(username));
		Optional<employeeDetails> matchingEmployee = employeeDetails.stream()
			    .filter(e -> e.getEmpid().equals(username))
			    .findFirst();
			    
			matchingEmployee.ifPresent(value -> {
			    String empFName = value.getEmpFName();
			    String empLName = value.getEmpLname();
			    String empName = (empFName+" "+empLName);
			    lblEmpName.setText(empName);
			});
		contentPane.add(lblEmpName);
		
		JLabel lblCreateAccount = new JLabel("Please create your account");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreateAccount.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCreateAccount.setBounds(10, 42, 235, 20);
		contentPane.add(lblCreateAccount);
		
		textPassword1 = new JPasswordField();
		textPassword1.setBounds(108, 136, 267, 20);
		contentPane.add(textPassword1);
		
		JButton btnSignUp = new JButton("Sign-Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.verifyNewUser(textTIN1, textTIN2, textTIN3, textTIN4, username, textPassword1, textPassword2)) {
	            	employeeLogin login = new employeeLogin();
	            	login.setEmpid(username);
	            	char[] cpassword = textPassword1.getPassword();
	            	String password = new String(cpassword);
	            	login.setPassword(password);
	            	List<employeeLogin> loginDetails = new ArrayList<>();
	            	loginDetails.add(login);
	            	try {
						writeCsvFiles.empLogin(loginDetails);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	JOptionPane.showMessageDialog(null, "User created successfully");
	            	dispose();
	            }
			}
		});
		btnSignUp.setBounds(106, 227, 89, 23);
		contentPane.add(btnSignUp);
		
		textPassword2 = new JPasswordField();
		textPassword2.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            if (Helper.verifyNewUser(textTIN1, textTIN2, textTIN3, textTIN4, username, textPassword1, textPassword2)) {
		            	employeeLogin login = new employeeLogin();
		            	login.setEmpid(username);
		            	char[] cpassword = textPassword1.getPassword();
		            	String password = new String(cpassword);
		            	login.setPassword(password);
		            	List<employeeLogin> loginDetails = new ArrayList<>();
		            	loginDetails.add(login);
		            	try {
							writeCsvFiles.empLogin(loginDetails);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	JOptionPane.showMessageDialog(null, "User created successfully");
		            	dispose();
		            }
		        }
		    }
		});
		textPassword2.setBounds(108, 167, 267, 20);
		contentPane.add(textPassword2);
		
		// Set document filters to limit input to 3 characters for all TIN text fields
		((AbstractDocument) textTIN1.getDocument()).setDocumentFilter(new DocumentFilter() {
		    @Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        if (newStr.length() <= 3 && newStr.matches("\\d*")) {
		            super.replace(fb, offset, length, text, attrs);
		            if (newStr.length() == 3) {
		                textTIN2.requestFocusInWindow();
		            }
		        }
		    }
		});
		((AbstractDocument) textTIN2.getDocument()).setDocumentFilter(new DocumentFilter() {
		    @Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        if (newStr.length() <= 3 && newStr.matches("\\d*")) {
		            super.replace(fb, offset, length, text, attrs);
		            if (newStr.length() == 3) {
		                textTIN3.requestFocusInWindow();
		            }
		        }
		    }
		});

		((AbstractDocument) textTIN3.getDocument()).setDocumentFilter(new DocumentFilter() {
		    @Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        if (newStr.length() <= 3 && newStr.matches("\\d*")) {
		            super.replace(fb, offset, length, text, attrs);
		            if (newStr.length() == 3) {
		                textPassword1.requestFocusInWindow();
		            }
		        }
		    }
		});
	}
}
