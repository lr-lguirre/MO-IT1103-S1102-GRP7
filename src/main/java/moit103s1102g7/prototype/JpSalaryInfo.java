package moit103s1102g7.prototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JpSalaryInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel JpSalaryInfo;
	private JLabel lblSalaryInfo;
	private JLabel lblSalEmployeeNo;
	private JLabel lblEmployeePosition;
	private JLabel lblEmployeeStats;
	private JLabel lblSalaryClass;
	private JLabel lblBasicSalary;
	private JLabel lblPhoneAllowance;
	private JLabel lblClothingAllowance;
	private JLabel lblRiceSubsidy;
	private Window txtSalEmployeeNo;
	private Window txtEmployeeStats;
	private Window txtEmployeePosition;
	private Window txtSalaryClass;
	private Window txtBasicSalary;
	private Window txtRiceSubsidy;
	private Window txtPhoneAllowance;
	private Window txtClothingAllowance;
	private JButton btnSalaryBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JpSalaryInfo frame = new JpSalaryInfo();
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
	public JpSalaryInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JpSalaryInfo salaryInfoPanel = new JpSalaryInfo();
		salaryInfoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Set label and text field positions
		lblSalaryInfo = new JLabel("Salary Information");
		lblSalaryInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalEmployeeNo = new JLabel("Employee No.:");
		lblEmployeeStats = new JLabel("Employee Status:");
		lblEmployeePosition = new JLabel("Employee Position:");
		lblSalaryClass = new JLabel("Salary Class:");
		lblBasicSalary = new JLabel("Basic Salary:");
		lblRiceSubsidy = new JLabel("Rice Subsidy:");
		lblPhoneAllowance = new JLabel("Phone Allowance:");
		lblClothingAllowance = new JLabel("Clothing Subsidy:");
		lblSalaryInfo.setBounds(250, 10, 150, 40);
		lblSalEmployeeNo.setBounds(20, 60, 100, 20);
		txtSalEmployeeNo.setBounds(150, 60, 150, 20);
		lblEmployeeStats.setBounds(320, 60, 100, 20);
		txtEmployeeStats.setBounds(430, 60, 150, 20);
		lblEmployeePosition.setBounds(20, 100, 120, 20);
		txtEmployeePosition.setBounds(150, 100, 150, 20);
		lblSalaryClass.setBounds(320, 100, 100, 20);
		txtSalaryClass.setBounds(430, 100, 150, 20);
		lblBasicSalary.setBounds(20, 140, 100, 20);
		txtBasicSalary.setBounds(150, 140, 150, 20);
		lblRiceSubsidy.setBounds(320, 140, 100, 20);
		txtRiceSubsidy.setBounds(430, 140, 150, 20);
		lblPhoneAllowance.setBounds(20, 180, 120, 20);
		txtPhoneAllowance.setBounds(150, 180, 150, 20);
		lblClothingAllowance.setBounds(320, 180, 110, 20);
		txtClothingAllowance.setBounds(430, 180, 150, 20);
		// Add components to salary info panel
		btnSalaryBack = new JButton("Back");
		btnSalaryBack.setBounds(265, 260, 80, 30);
		btnSalaryBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//callProfileMenu();				
			}
		});
				salaryInfoPanel.add(lblSalaryInfo);
				salaryInfoPanel.add(lblSalEmployeeNo);
				salaryInfoPanel.add(txtSalEmployeeNo);
				salaryInfoPanel.add(lblEmployeeStats);
				salaryInfoPanel.add(lblEmployeePosition);
				salaryInfoPanel.add(lblSalaryClass);
				salaryInfoPanel.add(lblBasicSalary);
				salaryInfoPanel.add(lblRiceSubsidy);
				salaryInfoPanel.add(lblPhoneAllowance);
				salaryInfoPanel.add(lblClothingAllowance);
				salaryInfoPanel.add(txtEmployeeStats);
				salaryInfoPanel.add(txtEmployeePosition);
				salaryInfoPanel.add(txtSalaryClass);
				salaryInfoPanel.add(txtBasicSalary);
				salaryInfoPanel.add(txtRiceSubsidy);
				salaryInfoPanel.add(txtPhoneAllowance);
				salaryInfoPanel.add(txtClothingAllowance);
				salaryInfoPanel.add(btnSalaryBack);
				

		setContentPane(JpSalaryInfo);
	}

}
