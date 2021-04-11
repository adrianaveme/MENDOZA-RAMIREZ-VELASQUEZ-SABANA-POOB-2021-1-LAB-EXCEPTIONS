import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class ColsubsidioFundTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeSalary employeeSalary;
    private static EmployeeHours employeeHours;
    private static EmployeeCommission employeeCommission;

    private static IFamilyCompensationFund colsubsidioFund;

    @BeforeAll
    public static void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        employeeSalary = new EmployeeSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        employeeHours = new EmployeeHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        employeeCommission = new EmployeeCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees = new ArrayList<>();
        employees.add(EmployeeSalary);
        employees.add(EmployeeHours);
        employees.add(EmployeeCommission);

        colsubsidioFund = new ColsubsidioFund();
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by commission WHEN try to register THEN fails")
    public void shouldNotRegisterEmployeeWhenByCommission() {

        assertFalse(colsubsidioFund.registerEmployee(employeeCommission));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));
        assertFalse(colsubsidioFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));
        assertTrue(colsubsidioFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() {

        assertFalse(colsubsidioFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));
        assertTrue(colsubsidioFund.isEmployeeRegistered(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(colsubsidioFund.isEmployeeRegistered(employeeSalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = colsubsidioFund.printBenefits();
        assertNotNull(benefits);
    }

}
