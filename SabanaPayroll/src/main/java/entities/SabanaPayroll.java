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

    public double calculateEmployeeSalary(UUID id) throws SabanaPayrollExceptions{
        Employee employee = findEmployee(id);

        if (employee == null)
            throw new SabanaPayrollExceptions(SabanaPayrollExceptions.NONEXISTENT_EMPLOYEE);

        return employee.calculateSalary();
    }

    public void printPayroll(){
        for (Department d: departments){
            List<Employee> employees = d.getEmployees();
            for (Employee e : employees){
               e.toString();
            }
        }
    }

    public boolean depositToEmployee(double amount, UUID id) throws SabanaPayrollExceptions {

        Employee employee = findEmployee(id);

        if (employee==null)
            throw new SabanaPayrollExceptions(SabanaPayrollExceptions.NONEXISTENT_EMPLOYEE);

        return employee.getAccount().deposit(amount);
    }

    public double calculateEmployeeBalance(UUID id) throws SabanaPayrollExceptions {

        Employee employee = findEmployee(id);

        if (employee==null)
            throw new SabanaPayrollExceptions(SabanaPayrollExceptions.NONEXISTENT_EMPLOYEE);

        return employee.getAccount().getBalance();
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

    public boolean assignFamilyCompensation(IFamilyCompensationFund fund, UUID id) throws FamilyCompensationFundException{
        boolean result = false;

        Employee e = findEmployee(id);

        if (e!=null){
            if (fund.registerEmployee(e)){
                e.setFamilyCompensationFund(fund);
                result = true;
            }
        }

        return result;
    }

    public Employee findEmployee(UUID id){
        Employee res = null;

        for (Department d : departments) {
            List<Employee> employees = d.getEmployees();
            for (Employee e : employees){
                if (e.getId() == id){
                    res = e;
                }
            }
        }

        return res;
    }
}
