import com.github.javafaker.Faker;
import entities.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class ColsubsidioFundTest {

    private static Faker faker;

    private static ArrayList<Employee> employees;
    private static Department department;

    private static EmployeeSalary employeeSalary;
    private static EmployeeHours employeeHours;
    private static EmployeeCommission employeeCommission;

    private static IFamilyCompensationFund colsubsidioFund;

    @BeforeEach
    public void setUp() {
        faker = new Faker(new Locale("en-US"));

        employees = new ArrayList<>();

        department = new Department("Engineering", employees);

        employeeSalary = new EmployeeSalary(faker.name().firstName(), faker.name().lastName(), department, 1000000);
        employeeHours = new EmployeeHours(faker.name().firstName(), faker.name().lastName(), department, 40);
        employeeCommission = new EmployeeCommission(faker.name().firstName(), faker.name().lastName(), department, 100);

        employees.add(employeeSalary);
        employees.add(employeeHours);
        employees.add(employeeCommission);


        colsubsidioFund = new ColsubsidioFund();
    }

    @AfterEach
    protected void tearDown() {

        faker =null;
        department =null;
        colsubsidioFund = null;
        employees.clear();
        employeeSalary = null;
        employeeCommission = null;
        employeeHours = null;
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));

    }

    @Test
    @DisplayName("GIVEN a employee by commission WHEN try to register THEN fails")
    public void shouldNotRegisterEmployeeWhenByCommission() throws FamilyCompensationFundException {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.registerEmployee(employeeCommission));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED, e.getMessage());

    }

    @Test
    @DisplayName("GIVEN an employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.registerEmployee(employeeSalary));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_REGISTERED, e.getMessage());

    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));
        assertTrue(colsubsidioFund.deleteEmployee(employeeSalary.getId()));

    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() throws FamilyCompensationFundException {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.deleteEmployee(employeeSalary.getId()));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED, e.getMessage());

    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() throws FamilyCompensationFundException {

        assertTrue(colsubsidioFund.registerEmployee(employeeSalary));
        assertTrue(colsubsidioFund.isEmployeeRegistered(employeeSalary.getId()));

    }


    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() throws FamilyCompensationFundException {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> colsubsidioFund.isEmployeeRegistered(employeeSalary.getId()));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED, e.getMessage());

    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = colsubsidioFund.printBenefits();
        assertNotNull(benefits);

    }

}
