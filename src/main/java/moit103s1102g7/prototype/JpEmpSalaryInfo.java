package moit103s1102g7.prototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JpEmpSalaryInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel JpSalaryInfo;
	private JLabel lblSalaryInfo;
	private JLabel lblSalEmployeeNo;
	private JLabel lblEmployeePosition;
	private JLabel lblEmployeeStats;
	private JLabel lblBasicSalary;
	private JLabel lblPhoneAllowance;
	private JLabel lblClothingAllowance;
	private JLabel lblRiceSubsidy;
	private JTextField txtSalEmployeeNo;
	private JTextField txtEmployeeStats;
	private JTextField txtEmployeePosition;
	private JTextField txtBasicSalary;
	private JTextField txtRiceSubsidy;
	private JTextField txtPhoneAllowance;
	private JTextField txtClothingAllowance;
	private JButton btnSalaryBack;
	private String uid;

	/**
	 * Create the frame.
	 */
	public JpEmpSalaryInfo(String uid) {
		Helper helper = new Helper();
		Map<String, Object> empinfo = helper.employeeInfo(uid);
		String salary = (String) empinfo.get("empSalary");
		String position = (String) empinfo.get("empPosition");
		String status = (String) empinfo.get("empStatus");
		String rice = (String) empinfo.get("empRice");
		String phone = (String) empinfo.get("empPhoneAllowance");
		String clothing = (String) empinfo.get("empClothing");

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(JpAdmLogin.class.getResource("/org/springframework/beans/factory/xml/spring-beans.gif")));
		setFont(new Font("Arial", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 292);
		JpSalaryInfo = new JPanel();
		JpSalaryInfo.setToolTipText("MotorPH");
		JpSalaryInfo.setFont(new Font("Arial", Font.PLAIN, 12));
		JpSalaryInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JpSalaryInfo);
		JpSalaryInfo.setLayout(null);

		// Set label and text field positions
		lblSalaryInfo = new JLabel("Salary Information");
		lblSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalaryInfo.setBounds(250, 10, 150, 40);
		JpSalaryInfo.add(lblSalaryInfo);

		lblSalEmployeeNo = new JLabel("Employee No.:");
		txtSalEmployeeNo = new JTextField();
		txtSalEmployeeNo.setText(uid);
		txtSalEmployeeNo.setEditable(false);
		lblSalEmployeeNo.setBounds(20, 60, 100, 20);
		txtSalEmployeeNo.setBounds(150, 60, 150, 20);
		JpSalaryInfo.add(lblSalEmployeeNo);
		JpSalaryInfo.add(txtSalEmployeeNo);

		lblEmployeeStats = new JLabel("Employee Status:");
		txtEmployeeStats = new JTextField();
		txtEmployeeStats.setEditable(false);
		lblEmployeeStats.setBounds(320, 60, 100, 20);
		txtEmployeeStats.setBounds(430, 60, 150, 20);
		txtEmployeeStats.setText(status);
		JpSalaryInfo.add(lblEmployeeStats);
		JpSalaryInfo.add(txtEmployeeStats);

		lblEmployeePosition = new JLabel("Employee Position:");
		txtEmployeePosition = new JTextField();
		txtEmployeePosition.setEditable(false);
		lblEmployeePosition.setBounds(20, 100, 120, 20);
		txtEmployeePosition.setBounds(150, 100, 150, 20);
		txtEmployeePosition.setText(position);
		JpSalaryInfo.add(lblEmployeePosition);
		JpSalaryInfo.add(txtEmployeePosition);

		lblBasicSalary = new JLabel("Basic Salary:");
		txtBasicSalary = new JTextField();
		txtBasicSalary.setEditable(false);
		lblBasicSalary.setBounds(20, 140, 100, 20);
		txtBasicSalary.setBounds(150, 140, 150, 20);
		txtBasicSalary.setText(salary);
		JpSalaryInfo.add(lblBasicSalary);
		JpSalaryInfo.add(txtBasicSalary);

		lblRiceSubsidy = new JLabel("Rice Subsidy:");
		txtRiceSubsidy = new JTextField();
		txtRiceSubsidy.setEditable(false);
		lblRiceSubsidy.setBounds(320, 100, 100, 20);
		txtRiceSubsidy.setBounds(430, 100, 150, 20);
		txtRiceSubsidy.setText(rice);
		JpSalaryInfo.add(lblRiceSubsidy);
		JpSalaryInfo.add(txtRiceSubsidy);

		lblPhoneAllowance = new JLabel("Phone Allowance:");
		txtPhoneAllowance = new JTextField();
		txtPhoneAllowance.setEditable(false);
		lblPhoneAllowance.setBounds(320, 180, 120, 20);
		txtPhoneAllowance.setBounds(430, 180, 150, 20);
		txtPhoneAllowance.setText(phone);
		JpSalaryInfo.add(lblPhoneAllowance);
		JpSalaryInfo.add(txtPhoneAllowance);

		lblClothingAllowance = new JLabel("Clothing Subsidy:");
		txtClothingAllowance = new JTextField();
		txtClothingAllowance.setEditable(false);
		lblClothingAllowance.setBounds(320, 140, 110, 20);
		txtClothingAllowance.setBounds(430, 140, 150, 20);
		txtClothingAllowance.setText(clothing);
		JpSalaryInfo.add(lblClothingAllowance);
		JpSalaryInfo.add(txtClothingAllowance);

		// Add components to salary info panel
		btnSalaryBack = new JButton("Back");
		btnSalaryBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JpEmpProfileMenu empMenu = new JpEmpProfileMenu(uid);
				empMenu.setVisible(true);
			}
		});
		btnSalaryBack.setBounds(265, 215, 80, 30);
		btnSalaryBack.addActionListener(e -> {
			// callProfileMenu();
		});
		JpSalaryInfo.add(btnSalaryBack);
	}

}
