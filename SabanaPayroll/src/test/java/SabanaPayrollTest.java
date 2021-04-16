import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SabanaPayrollTest {

    private static Faker faker;

    private static ArrayList<Employee> employees;
    private static ArrayList<Department> departments;
    private static Department department;

    private static EmployeeSalary employeeSalary;
    private static EmployeeHours employeeHours;
    private static EmployeeCommission employeeCommission;

    private static SabanaPayroll sabanaPayroll;
    private static ColsubsidioFund colsubsidioFund;
    private static CompensarFund compensarFund;
    private static CafamFund cafamFund;

    @BeforeEach
    public void setUp() {
        faker = new Faker(new Locale("en-US"));

        colsubsidioFund = new ColsubsidioFund();
        compensarFund = new CompensarFund();
        cafamFund = new CafamFund();

        employeeSalary = new EmployeeSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        employeeHours = new EmployeeHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        employeeCommission = new EmployeeCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees = new ArrayList<>();
        employees.add(employeeSalary);
        employees.add(employeeHours);
        employees.add(employeeCommission);

        department = new Department("Engineering", employees);

        departments = new ArrayList<>();
        departments.add(department);

        sabanaPayroll = new SabanaPayroll(departments);
    }

    @AfterEach
    protected void tearDown() {

        faker =null;
        department =null;
        colsubsidioFund = null;
        compensarFund = null;
        cafamFund = null;
        employees.clear();
        employeeSalary = null;
        employeeCommission = null;
        employeeHours = null;

    }

    @Test
    public void assignColsubsidioFamilyCompensation() {

        boolean result = sabanaPayroll.assignFamilyCompensation(colsubsidioFund, employeeSalary.getId());
        assertTrue(result);
    }

    @Test
    public void assignCompensarFamilyCompensation() {

        boolean result = sabanaPayroll.assignFamilyCompensation(compensarFund, employeeSalary.getId());
        assertTrue(result);
    }

    @Test
    public void assignCafamFamilyCompensation() {

        boolean result = sabanaPayroll.assignFamilyCompensation(cafamFund, employeeSalary.getId());
        assertTrue(result);
    }

}
