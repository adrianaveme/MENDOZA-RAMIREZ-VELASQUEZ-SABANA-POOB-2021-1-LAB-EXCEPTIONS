package entities;

import entities.Department;
import entities.Employee;

public class EmployeeCommission extends Employee {


    private double soldProducts;
    private static final double COMMISSION_VAL = 2;

    public EmployeeCommission(String name, String lastName, Department department, double soldProducts) {
        super(name, lastName, department);
        this.soldProducts = soldProducts;
    }

    @Override
    public double calculateSalary() {
        return this.soldProducts*COMMISSION_VAL;
    }

    @Override
    public String toString(){
        return super.toString() + " payment by commission.";
    }
}
