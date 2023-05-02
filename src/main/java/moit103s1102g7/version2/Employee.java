package moit103s1102g7.version2;

public class Employee {
    private int id;
    private String name;
    private int departmentId;
    private double monthlySalary;

    public Employee(int id, String name, int departmentId, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.monthlySalary = monthlySalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
