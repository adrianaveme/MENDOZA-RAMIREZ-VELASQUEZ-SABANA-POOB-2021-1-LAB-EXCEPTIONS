package entities;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class SabanaPayroll {

    public ArrayList<Department> departments;

    public SabanaPayroll(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public double calculateUniversitySalaries() {
        double cont = 0;
        for (Department d : departments) {
            cont += d.calculateDepartmentSalaries();
        }
        return cont;
    }

    public double calculateDepartmentSalaries(UUID id) {
        double cont = 0;
        for (Department d : departments) {
            if (d.getId() == id) {
                cont = d.calculateDepartmentSalaries();
            }
        }
        return cont;
    }

    public double calculateEmployeeSalary(UUID id) {
        double cont = 0;
        for (Department d : departments) {
           List<Employee> employees = d.getEmployees();
           for (Employee e : employees){
               if (e.getId() == id){
                   cont = e.calculateSalary();
               }
           }
        }
        return cont;
    }

    public void printPayroll(){
        for (Department d: departments){
            List<Employee> employees = d.getEmployees();
            for (Employee e : employees){
               e.toString();
            }
        }
    }

    public boolean depositToEmployee(double amount, UUID id) {
        boolean result = false;

        for (Department d : departments) {
            List<Employee> employees = d.getEmployees();
            for (Employee e : employees){
                if (e.getId() == id){
                   result = e.getAccount().deposit(amount);
                }
            }
        }

        return result;
    }

    public double calculateEmployeeBalance(UUID id){
        double result = 0;

        for (Department d : departments) {
            List<Employee> employees = d.getEmployees();
            for (Employee e : employees){
                if (e.getId() == id){
                    result = e.getAccount().getBalance();
                }
            }
        }

        return result;
    }

    public double calculateAllEmployeesBalance(){
        double cont = 0;

        for (Department d : departments) {
            List<Employee> employees = d.getEmployees();
            for (Employee e : employees){
                 cont += e.getAccount().getBalance();
            }
        }

        return cont;
    }
}
