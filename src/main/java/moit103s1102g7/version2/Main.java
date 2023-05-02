package moit103s1102g7.version2;

public static void main(String[] args) {
    String attendanceFilename = "attendance.csv";
    String employeeDetailsFilename = "employeedetails.csv";
    AttendanceFileReader attendanceFileReader = new AttendanceFileReader(attendanceFilename);
    EmployeeDetailsFileReader employeeDetailsFileReader = new EmployeeDetailsFileReader(employeeDetailsFilename);
    List<Attendance> attendanceList = attendanceFileReader.readAttendance();
    List<Employee> employeeList = employeeDetailsFileReader.readEmployeeDetails();
    AttendanceRecord attendanceRecord = new AttendanceRecord(attendanceList, employeeList);
    attendanceRecord.calculateHours();
    // display results using GUI or write to file
}

public void calculateHours() {
    for(Employee e: employees) {
        double monthlyHours = 0.0;
        double semiMonthlyHours = 0.0;

        for(AttendanceRecord record: attendanceRecords) {
            if(record.getEmployeeId() == e.getId()) {
                if(record.getDate().getDayOfMonth() <= 15) {
                    semiMonthlyHours += record.getHours();
                }
                monthlyHours += record.getHours();
            }
        }

        e.setSemiMonthlyHours(semiMonthlyHours);
        e.setMonthlyHours(monthlyHours);
    }
}
