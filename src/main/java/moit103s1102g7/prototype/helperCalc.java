package moit103s1102g7.prototype;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class helperCalc {
	static List<employeeAttendance> attendance = readCsvFiles.employeeAttendance();

	public static long hoursCalc(String timeIn, String timeOut) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date in = format.parse(timeIn);
		Date out = format.parse(timeOut);
		long worksec = out.getTime() - in.getTime();
		long workhours = TimeUnit.MILLISECONDS.toHours(worksec);
		return workhours;
	}

	public static Map<Object, Map<Object, Long>> workhoursCalculator(String uid) throws NumberFormatException, ParseException, IOException {
	    Map<Object, Map<Object, Long>> hoursByDate = attendance.stream()
	        .filter(entry -> entry.getEmpid().equals(uid))
	        .collect(Collectors.groupingBy(entry -> {
	            try {
	                return weekCalc(entry.getDate());
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	            return 0;
	        }, LinkedHashMap::new, Collectors.groupingBy(entry -> entry.getDate(), LinkedHashMap::new, Collectors.summingLong(entry -> {
	            try {
	                return hoursCalc(entry.getTimein(), entry.getTimeout());
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	            return 0;
	        }))));
	    return hoursByDate;
	}

	public static int weekCalc(String date) throws ParseException {
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
	
	public static List<String> getMonths(String uid) {
	    List<String> months = attendance.stream()
	        .filter(entry -> entry.getEmpid().equals(uid))
	        .map(entry -> {
	            try {
	                return new SimpleDateFormat("MM/dd/yyyy").parse(entry.getDate());
	            } catch (ParseException e) {
	                e.printStackTrace();
	                return null;
	            }
	        })
	        .filter(date -> date != null)
	        .map(date -> {
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(date);
	            return cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	        })
	        .distinct()
	        .collect(Collectors.toList());
	    
	    return months;
	}
	public static String getWorkHoursForMonth(String uid, String month) throws NumberFormatException, ParseException, IOException {
		int monthIndex = monthsList().indexOf(month) + 1;
		String monthString = monthIndex < 10 ? "0" + monthIndex : String.valueOf(monthIndex);
		Map<String, Long> hoursByDate = attendance.stream()
			    .filter(entry -> entry.getEmpid().equals(uid))
			    .filter(entry -> {
			    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					try {
						Date date = dateFormat.parse(entry.getDate());
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						return cal.get(Calendar.MONTH) == monthIndex - 1;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return false;
			    })
			    .collect(Collectors.groupingBy(entry -> entry.getDate(),
			    		Collectors.summingLong(entry -> {
							try {
								return hoursCalc(entry.getTimein(), entry.getTimeout());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return 0;
						})));
		long hours = hoursByDate.values().stream().mapToLong(Long::longValue).sum();
		return String.valueOf(hours);
	}
	public static List<String> monthsList() {
	    List<String> months = new ArrayList<>();
	    for (int i = 1; i <= 12; i++) {
	        Calendar cal = Calendar.getInstance();
	        cal.set(Calendar.MONTH, i-1);
	        String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	        months.add(monthName);
	    }
	    return months;
	}
}
