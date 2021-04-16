import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CafamFundTest {

    private static EmployeeSalary employeeSalary;
    private static EmployeeHours employeeHours;

    private static IFamilyCompensationFund cafamFund;

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeCommission employeeCommission;


    @BeforeEach
    public void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        employeeSalary = new EmployeeSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        employeeHours = new EmployeeHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        employeeCommission = new EmployeeCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees = new ArrayList<>();
        employees.add(employeeSalary);
        employees.add(employeeHours);
        employees.add(employeeCommission);

        cafamFund = new CafamFund();
    }
    @AfterEach
    protected void tearDown() {

        faker =null;
        department =null;
        cafamFund = null;
        employees.clear();
        employeeSalary = null;
        employeeCommission = null;
        employeeHours = null;
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() {

        assertTrue(cafamFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() {

        assertTrue(cafamFund.registerEmployee(employeeSalary));
        assertFalse(cafamFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() {

        assertTrue(cafamFund.registerEmployee(employeeSalary));
        assertTrue(cafamFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() {

        assertFalse(cafamFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() {

        assertTrue(cafamFund.registerEmployee(employeeSalary));
        assertTrue(cafamFund.isEmployeeRegistered(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(cafamFund.isEmployeeRegistered(employeeSalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = cafamFund.printBenefits();
        assertNotNull(benefits);
    }

}
