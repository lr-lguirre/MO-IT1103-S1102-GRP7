package moit103s1102g7.prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class helperCalc {
	public static long hoursCalc(String timeIn, String timeOut ) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date in = format.parse(timeIn);
        Date out = format.parse(timeOut);
        long worksec = out.getTime() - in.getTime();
        long workhours = TimeUnit.MILLISECONDS.toHours(worksec);
        return workhours;
    }
	public static boolean workhoursCalculator(String id) throws NumberFormatException, ParseException, IOException {
        int ID = Integer.valueOf(id);
        File f = new File("attendance.txt");
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            boolean found = false;
            String line = "";
            Map<String, Long> workweek = new HashMap<String, Long>();
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split("\t");
                int empid = Integer.valueOf(einfo[0]);
                String work_date = einfo[3];
                String timeIn = einfo[4];
                String timeOut = einfo[5];
                if (empid == ID) {
                    long worked_hours = hoursCalc(timeIn, timeOut);
                    workweek.put(work_date, worked_hours);
                    found = true;
                }
            } if (found) {
                System.out.println(workweek);
                return true;
            } else {
                return false;
            }
        }
	}
	public static int weekCalc(String date ) throws ParseException {
        String[] arrOfDate = date.split("/");
        int month = Integer.valueOf(arrOfDate[0]);
        int day = Integer.valueOf(arrOfDate[1]);
        int year = Integer.valueOf(arrOfDate[2]);
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month, day);
        int weekNo = cal.get(Calendar.WEEK_OF_YEAR);
        // System.out.println("Week "+weekNo+" Date "+day+"/"+month+"/"+year);
        return weekNo;
    }
}
