import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SabanaNominaTest {

    private static Department d1;
    private static Department d2;
    private static Employee e1;
    private static Employee e2;
    private static Employee e3;
    private static EmployeeCommission ec1;
    private static EmployeeSalary es1;
    private static EmployeeHours eh1;
    private static SabanaPayroll sp;

    @BeforeAll
    public static void setUp(){

        List<Department> departments = new ArrayList<>();
        List<Employee> employeesArt = new ArrayList<>();
        List<Employee> employeesEngineering = new ArrayList<>();

        d1 = new Department("arts", employeesArt);
        d2 = new Department("engineering", employeesEngineering);

        departments.add(d1);
        departments.add(d2);

        e1 = new Employee("Bobby", "Brown", d1);
        e2 = new Employee("Philbert", "Horseman", d1);

        ec1 = new EmployeeCommission("Stan", "Ursic", d2, 200.0);
        es1 = new EmployeeSalary("Harry", "Porter", d2, 500.0);
        eh1 = new EmployeeHours("Danielle", "Vergara", d2, 3.0);

        employeesArt.add(e1);
        employeesArt.add(e2);
        employeesEngineering.add(ec1);
        employeesEngineering.add(es1);
        employeesEngineering.add(eh1);

        sp = new SabanaPayroll(departments);
    }

    @Test
    public void shouldCalculateEmployeeSalary(){
        assertEquals(0, sp.calculateEmployeeSalary(e1.getId()));
        assertEquals(400.0, sp.calculateEmployeeSalary(ec1.getId()));
        assertEquals(460.0, sp.calculateEmployeeSalary(es1.getId()));
        assertEquals(30.0, sp.calculateEmployeeSalary(eh1.getId()));
    }

    @Test
    public void shouldCalculateDepartmentSalaries(){
        assertEquals(0, sp.calculateDepartmentSalaries(d1.getId()));
        assertEquals(890.0, sp.calculateDepartmentSalaries(d2.getId()));
    }

    @Test
    public void shouldCalculateUniversitySalaries(){
        assertEquals(890.0, sp.calculateUniversitySalaries());
    }

    @Test
    public void shouldPrintPayroll(){
        String toStringE1 = "Bobby Brown, department arts, salary $0.0,";
        String toStringE2 = "Philbert Horseman, department arts, salary $0.0,";
        String toStringEc1 = "Stan Ursic, department engineering, salary $400.0, payment by commission.";
        String toStringEs1 = "Harry Porter, department engineering, salary $460.0, payment by salary.";
        String toStringEh1 = "Danielle Vergara, department engineering, salary $30.0, payment by hours.";
        assertEquals(toStringE1+toStringE2+toStringEc1+toStringEs1+toStringEh1, e1.toString()+e2.toString()+ec1.toString()+es1.toString()+eh1.toString());
    }









}
