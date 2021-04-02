package entities;

public class EmployeeSalary extends Employee {

    private static final double HEALTH_DISCOUNT = 0.04;
    private static final double PENSION_DISCOUNT = 0.04;

    private double salary;

    public EmployeeSalary(String name, String lastName, Department department, double salary) {
        super(name, lastName, department);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return this.salary * (1.0 - (EmployeeSalary.HEALTH_DISCOUNT + EmployeeSalary.PENSION_DISCOUNT));
    }

    @Override
    public String toString(){
        return super.toString() + " payment by salary.";
    }
}
