package moit103s1102g7.prototype;

import java.util.List;
import java.util.Map;

public class helperSalary {
	static List<employeeDetails> employeeDetails = readCsvFiles.employeeDetails();

	public static String vars(String uid, String var) {
		Helper helper = new Helper();
		Map<String, Object> empinfo = helper.employeeInfo(uid);
		String clothing = (String) empinfo.get("empClothing");
		String rice = (String) empinfo.get("empRice");
		String phoneAllowance = (String) empinfo.get("empPhoneAllowance");
		String rate = (String) empinfo.get("empRate");
		String salary = (String) empinfo.get("empSalary");
		String semi = (String) empinfo.get("empSemi");
		
		switch(var) {
	    case "clothing":
	      return clothing;
	    case "rice":
	      return rice;
	    case "phoneAllowance":
	      return phoneAllowance;
	    case "rate":
	      return rate;
	    case "salary":
	      return salary;
	    case "semi":
	      return semi;
	    default:
	      return "";
	  }
	}

	public static boolean isBetween(Float x, Float lower, Float upper) {
		return lower <= x && x <= upper;
	}

	public static float sss(Float basicPay) {
		// based on SSS Schedule of deductions
		float deduction = 160f;
		if (basicPay < 2250) {
			deduction = 160;
		} else if (isBetween(basicPay, 2250f, 2749.99f)) {
			deduction = 200;
		} else if (isBetween(basicPay, 2750f, 3249.99f)) {
			deduction = 240;
		} else if (isBetween(basicPay, 3250f, 3749.99f)) {
			deduction = 280;
		} else if (isBetween(basicPay, 3750f, 4249.99f)) {
			deduction = 320;
		} else if (isBetween(basicPay, 4250f, 4749.99f)) {
			deduction = 360;
		} else if (isBetween(basicPay, 4750f, 5249.99f)) {
			deduction = 400;
		} else if (isBetween(basicPay, 5250f, 5749.99f)) {
			deduction = 440;
		} else if (isBetween(basicPay, 5750f, 6249.99f)) {
			deduction = 480;
		} else if (isBetween(basicPay, 6250f, 6749.99f)) {
			deduction = 520;
		} else if (isBetween(basicPay, 6750f, 7249.99f)) {
			deduction = 560;
		} else if (isBetween(basicPay, 7250f, 7749.99f)) {
			deduction = 600;
		} else if (isBetween(basicPay, 7750f, 8249.99f)) {
			deduction = 640;
		} else if (isBetween(basicPay, 8250f, 8749.99f)) {
			deduction = 680;
		} else if (isBetween(basicPay, 8750f, 9249.99f)) {
			deduction = 720;
		} else if (isBetween(basicPay, 9250f, 9749.99f)) {
			deduction = 760;
		} else if (isBetween(basicPay, 9750f, 10249.99f)) {
			deduction = 800;
		} else if (isBetween(basicPay, 10250f, 10749.99f)) {
			deduction = 840;
		} else if (isBetween(basicPay, 10750f, 11249.99f)) {
			deduction = 880;
		} else if (isBetween(basicPay, 11250f, 11749.99f)) {
			deduction = 920;
		} else if (isBetween(basicPay, 11750f, 12249.99f)) {
			deduction = 960;
		} else if (isBetween(basicPay, 12250f, 12749.99f)) {
			deduction = 1000;
		} else if (isBetween(basicPay, 12750f, 13249.99f)) {
			deduction = 1040;
		} else if (isBetween(basicPay, 13250f, 13749.99f)) {
			deduction = 1080;
		} else if (isBetween(basicPay, 13750f, 14249.99f)) {
			deduction = 1120;
		} else if (isBetween(basicPay, 14250f, 14749.99f)) {
			deduction = 1160;
		} else if (isBetween(basicPay, 14750f, 15249.99f)) {
			deduction = 1200;
		} else if (isBetween(basicPay, 15250f, 15749.99f)) {
			deduction = 1240;
		} else if (isBetween(basicPay, 15750f, 16249.99f)) {
			deduction = 1280;
		} else if (isBetween(basicPay, 16250f, 16749.99f)) {
			deduction = 1320;
		} else if (isBetween(basicPay, 16750f, 17249.99f)) {
			deduction = 1360;
		} else if (isBetween(basicPay, 17250f, 17749.99f)) {
			deduction = 1400;
		} else if (isBetween(basicPay, 17750f, 18249.99f)) {
			deduction = 1440;
		} else if (isBetween(basicPay, 18250f, 18749.99f)) {
			deduction = 1480;
		} else if (isBetween(basicPay, 18750f, 19249.99f)) {
			deduction = 1520;
		} else if (isBetween(basicPay, 19250f, 19749.99f)) {
			deduction = 1560;
		} else {
			deduction = 1600;
		}
		return deduction;
	}

	public static float pagibig() {
		float deduction = 100;
		return deduction;
	}
	
	public static float philhealth(Float month) {
		float deduction = (float) (month * 0.04);
		return deduction;
	}

	public static float tax(Float month) {
		// Annual based on basic salary x 13
		float annual = month * 13;
		float deduction = 0f;
		float lower = 250000f;
		float excess = 0f;
		if (isBetween(annual, lower, 399999.99f)) {
			lower = 250000;
			excess = annual - lower;
			deduction = excess * .2f;
		} else if (isBetween(annual, 400000f, 799999.99f)) {
			lower = 400000;
			excess = annual - lower;
			deduction = ((excess * .25f) + 30000) / 13;
		} else if (isBetween(annual, 800000f, 1999999.99f)) {
			lower = 800000;
			excess = annual - lower;
			deduction = ((excess * .30f) + 130000) / 13;
		} else if (isBetween(annual, 2000000f, 7999999.99f)) {
			lower = 2000000;
			excess = annual - lower;
			deduction = ((excess * .32f) + 490000) / 13;
		} else {
			lower = 8000000;
			excess = annual - lower;
			deduction = ((excess * .32f) + 490000) / 13;
		}
		return deduction;
	}
}
