import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

        compensarFund = new CompensarFund();
    }
    @AfterEach
    protected void tearDown() {

        faker =null;
        department =null;
        compensarFund = null;
        employees.clear();
        employeeSalary = null;
        employeeCommission = null;
        employeeHours = null;
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() throws FamilyCompensationFundException {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
    }

    @Test
    @DisplayName("GIVEN a employee by hours WHEN try to register THEN fails")
    public void shouldNotRegisterEmployeeWhenByHours() throws FamilyCompensationFundException{

        assertFalse(compensarFund.registerEmployee(employeeHours));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> compensarFund.registerEmployee(employeeHours));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() throws FamilyCompensationFundException {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
        assertFalse(compensarFund.registerEmployee(employeeSalary));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> compensarFund.registerEmployee(employeeSalary));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_REGISTERED, e.getMessage());
    }



    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() {

        assertTrue(compensarFund.registerEmployee(employeeSalary));
        assertTrue(compensarFund.deleteEmployee(employeeSalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() throws FamilyCompensationFundException {

        assertFalse(compensarFund.deleteEmployee(employeeSalary.getId()));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> compensarFund.deleteEmployee(employeeSalary.getId()));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED, e.getMessage());
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
