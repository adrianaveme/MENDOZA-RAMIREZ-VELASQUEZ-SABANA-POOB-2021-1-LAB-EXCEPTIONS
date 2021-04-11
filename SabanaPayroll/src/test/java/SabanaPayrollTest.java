import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SabanaPayrollTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeSalary employeeSalary;
    private static EmployeeHours employeeHours;
    private static EmployeeCommission employeeCommission;

    private static SabanaPayroll sabanaPayroll;

    @BeforeAll
    public static void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        employeeSalary = new EmployeeSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        employeeHours = new EmployeeHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        employeeCommission = new EmployeeCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees = new ArrayList<>();
        employees.add(employeeSalary);
        employees.add(employeeHours);
        employees.add(employeeCommission);

        sabanaPayroll = new SabanaPayroll(employees);
    }

    @Test
    public void assigneColsubsidioFamilyCompensation() {

        boolean result = sabanaPayroll.assigneFamilyCompensation(ColsubsidioFund.class.getSimpleName(), employeeSalary.getId());
        assertTrue(result);
    }

    @Test
    public void assigneCompensarFamilyCompensation() {

        boolean result = sabanaPayroll.assigneFamilyCompensation(CompensarFund.class.getSimpleName(), employeeSalary.getId());
        assertTrue(result);
    }
}
