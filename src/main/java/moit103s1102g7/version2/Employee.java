package moit103s1102g7.version2;

public class Employee {
    private String id;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
    private String basicSalary;
    private String riceSubsidy;
    private String phoneAllowance;
    private String clothingAllowance;
    private String grossSemiMonthlyRate;
    private String hourlyRate;

    public Employee(String line, String lastName, String firstName, String line2, String address, String phoneNumber,
                    String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status,
                    String position, String immediateSupervisor, String line3, String line4,
                    String line5, String line6, String line7, String line8) {
        this.id = line;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = line2;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = line3;
        this.riceSubsidy = line4;
        this.phoneAllowance = line5;
        this.clothingAllowance = line6;
        this.grossSemiMonthlyRate = line7;
        this.hourlyRate = line8;
    }

    // Getters and setters omitted for brevity

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sssNumber='" + sssNumber + '\'' +
                ", philhealthNumber='" + philhealthNumber + '\'' +
                ", tinNumber='" + tinNumber + '\'' +
                ", pagibigNumber='" + pagibigNumber + '\'' +
                ", status='" + status + '\'' +
                ", position='" + position + '\'' +
                ", immediateSupervisor='" + immediateSupervisor + '\'' +
                ", basicSalary=" + basicSalary +
                ", riceSubsidy=" + riceSubsidy +
                ", phoneAllowance=" + phoneAllowance +
                ", clothingAllowance=" + clothingAllowance +
                ", grossSemiMonthlyRate=" + grossSemiMonthlyRate +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}

