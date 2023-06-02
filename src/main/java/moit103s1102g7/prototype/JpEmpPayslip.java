package moit103s1102g7.prototype;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class JpEmpPayslip extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static List<employeeAttendance> attendance = readCsvFiles.employeeAttendance();
	private JPanel contentPane;
	protected JTextField txtEmployeeName;
	protected JTextField txtPayrollPeriod;
	protected JTextField txtStatus;
	protected JTextField txtEmployeeNo;
	protected JTextField txtTIN;
	protected JTextField txtPhicNo;
	protected JTextField txtHdmfNo;
	protected JTextField txtSssNo;
	protected JTextField txtPosition;
	protected JTextField txtHourlyRate;
	protected JTextField txtBasicPay;
	protected JTextField txtRiceSubsidy;
	protected JTextField txtPhoneSubsidy;
	protected JTextField txtClothingAllowance;
	protected JTextField txtTotalNonTaxable;
	protected JTextField txtTotalTaxable;
	protected JTextField txtSss;
	protected JTextField txtPagibig;
	protected JTextField txtPhilhealth;
	protected JTextField txtWithholdingTax;
	protected JTextField txtNetEarnings;
	protected JTextField txtGrossEarnings;
	protected JTextField txtBasicPayHrs;
	// protected JComboBox monthsSelector;
	
	protected String[] payPeriod = {"======= Pay Period =======",
								  "1st Week September 2022"}; // For JComboBox use
	private JpHoursWorked hrsWkd;
	
	private PrintNReadTxt printRead;
	protected double[] allEmpRate;
	protected double[] weeklyPay;
	protected double rice = 1500.0 / 4;
	protected double phone = 1000.0 / 4;
	protected double clothes = 1000.0 / 4;
	private String uid;

	/**
	 * Create the frame.
	 */
	public JpEmpPayslip(String uid) {
		Helper helper = new Helper();
		Map<String, Object> empinfo = helper.employeeInfo(uid);
		String fname = (String) empinfo.get("empFName");
		String lname = (String) empinfo.get("empLname");
		String birthday = (String) empinfo.get("empBdate");
		String address = (String) empinfo.get("empAddress");
		String phone = (String) empinfo.get("empPhone");
		String sss = (String) empinfo.get("empSSS");
		String philhealth = (String) empinfo.get("empPhilhealth");
		String tin = (String) empinfo.get("empTIN");
		String pagibig = (String) empinfo.get("empPagibig");
		String position = (String) empinfo.get("empPosition");
		String supervisor = (String) empinfo.get("empSupervisor");
		String status = (String) empinfo.get("empStatus");
		String clothing = helperSalary.vars(uid, "clothing");
		String phoneAllowance = helperSalary.vars(uid, "phoneAllowance");
		String rice = helperSalary.vars(uid,"rice");
		String rate = helperSalary.vars(uid, "rate");
		String salary = helperSalary.vars(uid, "salary");
		String semi = helperSalary.vars(uid, "semi");
		Long allowance = Long.parseLong(clothing) + Long.parseLong(phoneAllowance) + Long.parseLong(rice);
		// Long deductions = 1.001;
		
		hrsWkd = new JpHoursWorked();
		printRead = new PrintNReadTxt();
		printRead.printRead();
		allEmpRate = printRead.getAllEmpRate();
		weeklyPay = printRead.getWeeklyPay();
		
		setResizable(false);
		setTitle("MotorPH Payroll System");
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
		setBounds(100, 100, 567, 680);
		setIconImage(Toolkit.getDefaultToolkit().getImage("MOTORPH.png"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MotorPH Employee Payslip");
		lblNewLabel.setBounds(183, 15, 184, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterPayPeriod = new JLabel("Enter Pay Period:");
		lblEnterPayPeriod.setBounds(66, 48, 104, 14);
		contentPane.add(lblEnterPayPeriod);
		
		JComboBox<String> monthSelector = new JComboBox<String>();
		List<String> months = helperCalc.getMonths(uid);
		DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<String>(months.toArray(new String[0]));
		monthSelector.setModel(monthModel);
		monthSelector.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedMonth = (String) monthSelector.getSelectedItem();
		        String totalHours = null;
				try {
					totalHours = helperCalc.getWorkHoursForMonth(uid, selectedMonth);
				} catch (NumberFormatException | ParseException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        txtBasicPayHrs.setText(totalHours);
		        Long basicPay = Long.parseLong(rate) * Long.parseLong(totalHours);
		        txtBasicPay.setText(String.valueOf(basicPay));
		        Float deductions = helperSalary.sss(Float.parseFloat(String.valueOf(basicPay))) + helperSalary.pagibig() + helperSalary.philhealth(Float.parseFloat(String.valueOf(basicPay)));
		        Float deductible = basicPay - deductions;
		        Float tax = helperSalary.tax(Float.parseFloat(String.valueOf(deductible)));
		        txtTotalTaxable.setText(String.valueOf(deductible));
		        Float gross = allowance + deductible;
		        txtGrossEarnings.setText(String.valueOf(gross));
		        txtPhilhealth.setText(String.valueOf(helperSalary.philhealth(Float.parseFloat(String.valueOf(basicPay)))));
		        txtSss.setText(String.valueOf(helperSalary.sss(Float.parseFloat(String.valueOf(basicPay)))));
		        txtWithholdingTax.setText(String.valueOf(tax));
		        try {
		            txtPayrollPeriod.setText(selectedMonth);
		        } catch (NumberFormatException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		    }
		});
		monthSelector.setBounds(166, 44, 222, 22);
		contentPane.add(monthSelector);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(398, 43, 93, 23);
		btnSubmit.addActionListener((ActionEvent e) -> {
		    String selectedMonth = (String) monthSelector.getSelectedItem();
		    String totalHours = null;
			try {
				totalHours = helperCalc.getWorkHoursForMonth(uid, selectedMonth);
			} catch (NumberFormatException | ParseException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtBasicPayHrs.setText(totalHours);
	        Long basicPay = Long.parseLong(rate) * Long.parseLong(totalHours);
	        txtBasicPay.setText(String.valueOf(basicPay));
	        Float deductions = helperSalary.sss(Float.parseFloat(String.valueOf(basicPay))) + helperSalary.pagibig() + helperSalary.philhealth(Float.parseFloat(String.valueOf(basicPay)));
	        Float deductible = basicPay - deductions;
	        Float tax = helperSalary.tax(Float.parseFloat(String.valueOf(deductible)));
	        txtTotalTaxable.setText(String.valueOf(deductible));
	        Float gross = allowance + deductible;
	        txtGrossEarnings.setText(String.valueOf(gross));
	        txtPhilhealth.setText(String.valueOf(helperSalary.philhealth(Float.parseFloat(String.valueOf(basicPay)))));
	        txtSss.setText(String.valueOf(helperSalary.sss(Float.parseFloat(String.valueOf(basicPay)))));
	        txtWithholdingTax.setText(String.valueOf(tax));
	        Float netpay = gross - tax;
	        txtNetEarnings.setText(String.valueOf(netpay));
		    try {
		        txtPayrollPeriod.setText(selectedMonth);
		    } catch (NumberFormatException e1) {
		        // TODO Auto-generated catch block
		        e1.printStackTrace();
		    }
		});
		contentPane.add(btnSubmit);
		
		JPanel payrollInformationPanel = new JPanel();
		payrollInformationPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		payrollInformationPanel.setBounds(10, 77, 531, 79);
		contentPane.add(payrollInformationPanel);
		payrollInformationPanel.setLayout(null);
		
		JLabel lblPayrollInformation = new JLabel("PAYROLL INFORMATION");
		lblPayrollInformation.setBounds(199, 6, 132, 14);
		lblPayrollInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		payrollInformationPanel.add(lblPayrollInformation);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(10, 29, 102, 14);
		payrollInformationPanel.add(lblEmployeeName);
		
		JLabel lblPayrollPeriod = new JLabel("Payroll Period:");
		lblPayrollPeriod.setBounds(10, 54, 84, 14);
		payrollInformationPanel.add(lblPayrollPeriod);
		
		
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeeName.setEnabled(false);
		txtEmployeeName.setBounds(110, 26, 156, 20);
		payrollInformationPanel.add(txtEmployeeName);
		txtEmployeeName.setText(fname+" "+lname);
		txtEmployeeName.setColumns(10);
		
		txtPayrollPeriod = new JTextField();
		txtPayrollPeriod.setDisabledTextColor(new Color(128, 128, 128));
		txtPayrollPeriod.setEnabled(false);
		txtPayrollPeriod.setColumns(10);
		txtPayrollPeriod.setBounds(110, 51, 156, 20);
		payrollInformationPanel.add(txtPayrollPeriod);
		
		txtStatus = new JTextField();
		txtStatus.setDisabledTextColor(new Color(128, 128, 128));
		txtStatus.setEnabled(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(376, 51, 144, 20);
		txtStatus.setText(status);
		payrollInformationPanel.add(txtStatus);
		
		txtEmployeeNo = new JTextField();
		txtEmployeeNo.setDisabledTextColor(new Color(128, 128, 128));
		txtEmployeeNo.setEnabled(false);
		txtEmployeeNo.setColumns(10);
		txtEmployeeNo.setBounds(376, 26, 144, 20);
		txtEmployeeNo.setText(uid);
		payrollInformationPanel.add(txtEmployeeNo);
		
		JLabel lblEmployeeNo = new JLabel("Employee No.:");
		lblEmployeeNo.setBounds(270, 29, 102, 14);
		payrollInformationPanel.add(lblEmployeeNo);
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setBounds(270, 54, 84, 14);
		payrollInformationPanel.add(lblStatus);
		
		JPanel employeeInformationPanel = new JPanel();
		employeeInformationPanel.setLayout(null);
		employeeInformationPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		employeeInformationPanel.setBounds(10, 163, 531, 134);
		contentPane.add(employeeInformationPanel);
		
		JLabel lblEmployeeInformation = new JLabel("EMPLOYEE INFORMATION");
		lblEmployeeInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeInformation.setBounds(193, 6, 144, 14);
		employeeInformationPanel.add(lblEmployeeInformation);
		
		JLabel lblTin = new JLabel("TIN:");
		lblTin.setBounds(10, 29, 102, 14);
		employeeInformationPanel.add(lblTin);
		
		JLabel lblPhicNo = new JLabel("PHIC No.:");
		lblPhicNo.setBounds(10, 54, 84, 14);
		employeeInformationPanel.add(lblPhicNo);
		
		txtTIN = new JTextField();
		txtTIN.setDisabledTextColor(new Color(128, 128, 128));
		txtTIN.setEnabled(false);
		txtTIN.setColumns(10);
		txtTIN.setBounds(116, 26, 144, 20);
		txtTIN.setText(tin);
		employeeInformationPanel.add(txtTIN);
		
		txtPhicNo = new JTextField();
		txtPhicNo.setDisabledTextColor(new Color(128, 128, 128));
		txtPhicNo.setEnabled(false);
		txtPhicNo.setColumns(10);
		txtPhicNo.setBounds(116, 51, 144, 20);
		txtPhicNo.setText(philhealth);
		employeeInformationPanel.add(txtPhicNo);
		
		txtHdmfNo = new JTextField();
		txtHdmfNo.setDisabledTextColor(new Color(128, 128, 128));
		txtHdmfNo.setEnabled(false);
		txtHdmfNo.setColumns(10);
		txtHdmfNo.setBounds(376, 51, 144, 20);
		txtHdmfNo.setText(pagibig);		employeeInformationPanel.add(txtHdmfNo);
		
		txtSssNo = new JTextField();
		txtSssNo.setDisabledTextColor(new Color(128, 128, 128));
		txtSssNo.setEnabled(false);
		txtSssNo.setColumns(10);
		txtSssNo.setBounds(376, 26, 144, 20);
		txtSssNo.setText(sss);
		employeeInformationPanel.add(txtSssNo);
		
		JLabel lblSssNo = new JLabel("SSS No.:");
		lblSssNo.setBounds(270, 29, 102, 14);
		employeeInformationPanel.add(lblSssNo);
		
		JLabel lblHdmfNo = new JLabel("HDMF No.:");
		lblHdmfNo.setBounds(270, 54, 84, 14);
		employeeInformationPanel.add(lblHdmfNo);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 79, 84, 14);
		employeeInformationPanel.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setDisabledTextColor(new Color(128, 128, 128));
		txtPosition.setEnabled(false);
		txtPosition.setColumns(10);
		txtPosition.setBounds(116, 76, 144, 20);
		txtPosition.setText(position);
		employeeInformationPanel.add(txtPosition);
		
		txtHourlyRate = new JTextField();
		txtHourlyRate.setDisabledTextColor(new Color(128, 128, 128));
		txtHourlyRate.setEnabled(false);
		txtHourlyRate.setColumns(10);
		txtHourlyRate.setBounds(376, 76, 144, 20);
		txtHourlyRate.setText(rate);
		employeeInformationPanel.add(txtHourlyRate);
		
		JLabel lblHourlyRate = new JLabel("Hourly Rate:");
		lblHourlyRate.setBounds(270, 79, 84, 14);
		employeeInformationPanel.add(lblHourlyRate);
		
		JPanel employeeEarningsPanel = new JPanel();
		employeeEarningsPanel.setLayout(null);
		employeeEarningsPanel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		employeeEarningsPanel.setBounds(10, 305, 531, 278);
		contentPane.add(employeeEarningsPanel);
		
		JLabel lblEmployeeEarnings = new JLabel("EMPLOYEE EARNINGS");
		lblEmployeeEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeEarnings.setBounds(204, 6, 122, 14);
		employeeEarningsPanel.add(lblEmployeeEarnings);
		
		JLabel lblTaxableEarnings = new JLabel("Taxable Earnings:");
		lblTaxableEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTaxableEarnings.setBounds(10, 29, 102, 14);
		employeeEarningsPanel.add(lblTaxableEarnings);
		
		JLabel lblBasicPay = new JLabel("Basic Pay - ");
		lblBasicPay.setBounds(10, 55, 69, 14);
		employeeEarningsPanel.add(lblBasicPay);
		
		txtBasicPay = new JTextField();
		txtBasicPay.setDisabledTextColor(new Color(128, 128, 128));
		txtBasicPay.setEnabled(false);
		txtBasicPay.setColumns(10);
		txtBasicPay.setBounds(158, 52, 102, 20);
		txtBasicPay.setText(rate);
		employeeEarningsPanel.add(txtBasicPay);
		
		txtBasicPayHrs = new JTextField();
		txtBasicPayHrs.setDisabledTextColor(new Color(128, 128, 128));
		txtBasicPayHrs.setEnabled(false);
		txtBasicPayHrs.setColumns(10);
		txtBasicPayHrs.setBounds(76, 52, 43, 20);
		employeeEarningsPanel.add(txtBasicPayHrs);
		
		txtRiceSubsidy = new JTextField();
		txtRiceSubsidy.setDisabledTextColor(new Color(128, 128, 128));
		txtRiceSubsidy.setEnabled(false);
		txtRiceSubsidy.setColumns(10);
		txtRiceSubsidy.setBounds(398, 52, 122, 20);
		txtRiceSubsidy.setText(rice);
		employeeEarningsPanel.add(txtRiceSubsidy);
		
		JLabel lblNonTaxableEarnings = new JLabel("Non-Taxable Earnings:");
		lblNonTaxableEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNonTaxableEarnings.setBounds(270, 29, 153, 14);
		employeeEarningsPanel.add(lblNonTaxableEarnings);
		
		JLabel lblRiceSubsidy = new JLabel("Rice Subsidy:");
		lblRiceSubsidy.setBounds(270, 55, 84, 14);
		employeeEarningsPanel.add(lblRiceSubsidy);
		
		txtPhoneSubsidy = new JTextField();
		txtPhoneSubsidy.setDisabledTextColor(new Color(128, 128, 128));
		txtPhoneSubsidy.setEnabled(false);
		txtPhoneSubsidy.setColumns(10);
		txtPhoneSubsidy.setBounds(398, 76, 122, 20);
		txtPhoneSubsidy.setText(phoneAllowance);
		employeeEarningsPanel.add(txtPhoneSubsidy);
		
		JLabel lblPhoneSubsidy = new JLabel("Phone Subsidy:");
		lblPhoneSubsidy.setBounds(270, 79, 96, 14);
		employeeEarningsPanel.add(lblPhoneSubsidy);
		
		JLabel lblClothingAllowance = new JLabel("Clothing Allowance:");
		lblClothingAllowance.setBounds(270, 103, 118, 14);
		employeeEarningsPanel.add(lblClothingAllowance);
		
		txtClothingAllowance = new JTextField();
		txtClothingAllowance.setDisabledTextColor(new Color(128, 128, 128));
		txtClothingAllowance.setEnabled(false);
		txtClothingAllowance.setColumns(10);
		txtClothingAllowance.setBounds(398, 100, 122, 20);
		txtClothingAllowance.setText(clothing);
		employeeEarningsPanel.add(txtClothingAllowance);
		
		JLabel lblTotalNonTaxable = new JLabel("TOTAL NON-TAXABLE:");
		lblTotalNonTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalNonTaxable.setBounds(270, 127, 130, 14);
		employeeEarningsPanel.add(lblTotalNonTaxable);
		
		txtTotalNonTaxable = new JTextField();
		txtTotalNonTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTotalNonTaxable.setDisabledTextColor(new Color(128, 128, 128));
		txtTotalNonTaxable.setEnabled(false);
		txtTotalNonTaxable.setColumns(10);
		txtTotalNonTaxable.setBounds(398, 124, 122, 20);
		txtTotalNonTaxable.setText(Long.toString(allowance));
		employeeEarningsPanel.add(txtTotalNonTaxable);
		
		JLabel lblTotalTaxable = new JLabel("TOTAL TAXABLE:");
		lblTotalTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalTaxable.setBounds(10, 127, 102, 14);
		employeeEarningsPanel.add(lblTotalTaxable);
		
		txtTotalTaxable = new JTextField();
		txtTotalTaxable.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTotalTaxable.setDisabledTextColor(new Color(128, 128, 128));
		txtTotalTaxable.setEnabled(false);
		txtTotalTaxable.setColumns(10);
		txtTotalTaxable.setBounds(158, 124, 102, 20);
		employeeEarningsPanel.add(txtTotalTaxable);
		
		JLabel lblDeductions = new JLabel("Deductions:");
		lblDeductions.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeductions.setBounds(10, 180, 102, 14);
		employeeEarningsPanel.add(lblDeductions);
		
		JLabel lblSss = new JLabel("SSS:");
		lblSss.setBounds(10, 204, 102, 14);
		employeeEarningsPanel.add(lblSss);
		
		txtSss = new JTextField();
		txtSss.setDisabledTextColor(new Color(128, 128, 128));
		txtSss.setEnabled(false);
		txtSss.setColumns(10);
		txtSss.setBounds(116, 201, 144, 20);
		employeeEarningsPanel.add(txtSss);
		
		JLabel lblPagibig = new JLabel("Pag-ibig:");
		lblPagibig.setBounds(10, 229, 84, 14);
		employeeEarningsPanel.add(lblPagibig);
		
		txtPagibig = new JTextField();
		txtPagibig.setDisabledTextColor(new Color(128, 128, 128));
		txtPagibig.setEnabled(false);
		txtPagibig.setColumns(10);
		txtPagibig.setBounds(116, 226, 144, 20);
		txtPagibig.setText(String.valueOf(helperSalary.pagibig()));
		employeeEarningsPanel.add(txtPagibig);
		
		txtPhilhealth = new JTextField();
		txtPhilhealth.setDisabledTextColor(new Color(128, 128, 128));
		txtPhilhealth.setEnabled(false);
		txtPhilhealth.setColumns(10);
		txtPhilhealth.setBounds(376, 201, 144, 20);
		employeeEarningsPanel.add(txtPhilhealth);
		
		JLabel lblPhilhealth = new JLabel("PhilHealth:");
		lblPhilhealth.setBounds(270, 204, 102, 14);
		employeeEarningsPanel.add(lblPhilhealth);
		
		JLabel lblWithholdingTax = new JLabel("Withholding Tax:");
		lblWithholdingTax.setBounds(270, 229, 96, 14);
		employeeEarningsPanel.add(lblWithholdingTax);
		
		txtWithholdingTax = new JTextField();
		txtWithholdingTax.setDisabledTextColor(new Color(128, 128, 128));
		txtWithholdingTax.setEnabled(false);
		txtWithholdingTax.setColumns(10);
		txtWithholdingTax.setBounds(376, 226, 144, 20);
		employeeEarningsPanel.add(txtWithholdingTax);
		
		JLabel lblNetEarnings = new JLabel("NET EARNINGS:");
		lblNetEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNetEarnings.setBounds(270, 254, 96, 14);
		employeeEarningsPanel.add(lblNetEarnings);
		
		txtNetEarnings = new JTextField();
		txtNetEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNetEarnings.setDisabledTextColor(new Color(128, 128, 128));
		txtNetEarnings.setEnabled(false);
		txtNetEarnings.setColumns(10);
		txtNetEarnings.setBounds(376, 251, 144, 20);
		employeeEarningsPanel.add(txtNetEarnings);
		
		JLabel lblGrossEarnings = new JLabel("GROSS EARNINGS:");
		lblGrossEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrossEarnings.setBounds(10, 155, 118, 14);
		employeeEarningsPanel.add(lblGrossEarnings);
		
		txtGrossEarnings = new JTextField();
		txtGrossEarnings.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtGrossEarnings.setDisabledTextColor(new Color(128, 128, 128));
		txtGrossEarnings.setEnabled(false);
		txtGrossEarnings.setColumns(10);
		txtGrossEarnings.setBounds(158, 152, 102, 20);
		employeeEarningsPanel.add(txtGrossEarnings);
		
		JLabel lblHrs = new JLabel("hr(s):");
		lblHrs.setBounds(122, 55, 61, 14);
		employeeEarningsPanel.add(lblHrs);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(373, 600, 73, 23);
		btnReset.addActionListener((ActionEvent e) -> {
			txtEmployeeName.setText("");
			txtPayrollPeriod.setText("");
			txtEmployeeNo.setText("");
			// txtPayDate.setText("");
			
			txtTIN.setText("");
			txtPhicNo.setText("");
			txtPosition.setText("");
			txtSssNo.setText("");
			txtHdmfNo.setText("");
			txtHourlyRate.setText("");
			
			txtBasicPayHrs.setText("");
			txtBasicPay.setText("");
			txtTotalTaxable.setText("");
			
			txtRiceSubsidy.setText("");
			txtPhoneSubsidy.setText("");
			txtClothingAllowance.setText("");
			txtTotalNonTaxable.setText("");
			txtGrossEarnings.setText("");

			txtSss.setText("");
			txtPagibig.setText("");
			txtPhilhealth.setText("");
			txtWithholdingTax.setText("");
			txtNetEarnings.setText("");
			
		});
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("Exit");
		btnBack.setBounds(456, 600, 64, 23);
		btnBack.addActionListener((ActionEvent e1) -> {
			setVisible(false);
			dispose();
			JpEmpMainPanel mainPanel = new JpEmpMainPanel(uid);
			mainPanel.setVisible(true);
		});
		contentPane.add(btnBack);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(289, 600, 73, 23);
		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
			}
		});
		contentPane.add(btnPrint);
	}


	protected void helperPayrollCalculator() {
		// TODO Auto-generated method stub
		
	}
}