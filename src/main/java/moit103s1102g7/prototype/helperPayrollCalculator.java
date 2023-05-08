package moit103s1102g7.prototype;

public class helperPayrollCalculator {

	public static double hlpPagIbig(double weeklyPay) {
        double contribution = 0;
        // Check if the basic salary is less than 1500 for the contribution
        if (weeklyPay <= 1500) {
            // If basic salary is below 1500, employee contribution is 1% of basic salary
            // and employer will match it with 2% of the basic salary.

            contribution = weeklyPay * 0.01;
            return contribution;
        } else {
            contribution = weeklyPay * 0.02;
            if (contribution >= 100) {
                return 100;
            } else {
                return contribution;
            }
        }
    }
	
	 public static double hlpPhilhealth(double weeklyPay) {
	        if (weeklyPay <= 10000) {
	            return 150.00;
	        } else if (weeklyPay > 10000 && weeklyPay < 60000) {
	            return ((weeklyPay * 0.03) / 2);
	        } else {
	            return 900.00;
	        }
	  }
	 
	 public static double hlpSSS(double weeklyPay) {
	        if (weeklyPay < 3250) {
	            return 135.00;
	        } else if (weeklyPay >= 3250 && weeklyPay < 24750) {
	            double initial = weeklyPay - 3250;
	            double taxDifference = (initial / 500);
	            double taxFraction = (taxDifference % 1);

	            double taxAdd = (taxDifference - taxFraction);

	            return (((taxAdd + 1) * 22.5)) + 135;
	        } else {
	            return 1125.00;
	        }
	    }
	 
	 public static double hlpWitholdingTax(double basicSalary, double Philhealth, double SSS, double PagIbig) {
	        double taxableIncome = basicSalary - (Philhealth + SSS + PagIbig);

	        if (taxableIncome * 4 <= 20832) {
	            return 0;
	        } else if (taxableIncome * 4 > 20832 && taxableIncome * 4 < 33333) {
	            return ((taxableIncome * 4 - 20833) * 0.2) / 4;
	        } else if (taxableIncome * 4 >= 33333 && taxableIncome * 4 < 66667) {
	            return (2500 + ((taxableIncome * 4 - 33333) * 0.25)) / 4;
	        } else if (taxableIncome * 4 >= 66667 && taxableIncome * 4 < 166667) {
	            return (10833 + ((taxableIncome * 4 - 66667) * 0.30)) / 4;
	        } else if (taxableIncome * 4 >= 166667 && taxableIncome * 4 < 666667) {
	            return (40833.33 + ((taxableIncome * 4 - 166667) * 0.32)) / 4;
	        } else {
	            return (200833.33 + ((taxableIncome * 4 - 666667) * 0.35)) / 4;
	        }
	    }
}
