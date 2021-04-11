import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CompensarFundTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeSalary employeeSalary;
    private static EmployeeHours employeeHours;
    private static EmployeeCommission employeeCommission;

    private static IFamilyCompensationFund compensarFund;

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

        compensarFund = new CompensarFund();
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by hours WHEN try to register THEN fails")
    public void shouldNotRegisterEmployeeWhenByCommission() {

        assertFalse(compensarFund.registerEmployee(employeeHours));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
        assertFalse(compensarFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
        assertTrue(compensarFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() {

        assertFalse(compensarFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
        assertTrue(compensarFund.isEmployeeRegistered(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(compensarFund.isEmployeeRegistered(employeeSalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = compensarFund.printBenefits();
        assertNotNull(benefits);
    }

}
