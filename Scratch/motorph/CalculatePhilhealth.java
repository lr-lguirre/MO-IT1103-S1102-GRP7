package moit103s1102g7.motorph;

public static double Philhealth(double weeklyPay) {
    if (weeklyPay <= 10000) {
        return 150.00;
    } else if (weeklyPay > 10000 && weeklyPay < 60000) {
        return ((weeklyPay * 0.03) / 2);
    } else {
        return 900.00;
    }    
}
}
