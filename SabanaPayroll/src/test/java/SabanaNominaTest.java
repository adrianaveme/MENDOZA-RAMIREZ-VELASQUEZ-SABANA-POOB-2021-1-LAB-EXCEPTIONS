import entities.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SabanaNominaTest {

    private static Department d1;
    private static Department d2;
    private static EmployeeCommission ec1;
    private static EmployeeSalary es1;
    private static EmployeeHours eh1;
    private static SabanaPayroll sp;
    private static Checking ac1;
    private static Savings as1;
    private static Savings as2;

    @BeforeEach
    public void setUp() {

        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Employee> employeesArt = new ArrayList<>();
        ArrayList<Employee> employeesEngineering = new ArrayList<>();

        d1 = new Department("arts", employeesArt);
        d2 = new Department("engineering", employeesEngineering);

        departments.add(d1);
        departments.add(d2);

        ac1 = new Checking();
        as1 = new Savings();
        as2 = new Savings();

        ec1 = new EmployeeCommission("Stan", "Ursic", d2, ac1, 200.0);
        es1 = new EmployeeSalary("Harry", "Porter", d2, as1, 500.0);
        eh1 = new EmployeeHours("Danielle", "Vergara", d1, as2, 3.0);

        employeesEngineering.add(ec1);
        employeesEngineering.add(es1);
        employeesArt.add(eh1);

        sp = new SabanaPayroll(departments);
    }
    @AfterEach
    public void tearDown() {
        sp = null;
        ec1 = null;
        eh1 = null;
        es1 = null;
        ac1 =null;
        as1 = null;
        as2 = null;
        d1 =null;
        d2 =null;
    }


    @Test
    public void shouldCalculateEmployeeSalary(){
        assertEquals(400.0, sp.calculateEmployeeSalary(ec1.getId()));
        assertEquals(460.0, sp.calculateEmployeeSalary(es1.getId()));
        assertEquals(30.0, sp.calculateEmployeeSalary(eh1.getId()));
    }

    @Test
    public void shouldCalculateDepartmentSalaries(){
        assertEquals(30.0, sp.calculateDepartmentSalaries(d1.getId()));
        assertEquals(860.0, sp.calculateDepartmentSalaries(d2.getId()));
    }

    @Test
    public void shouldCalculateUniversitySalaries(){
        assertEquals(890.0, sp.calculateUniversitySalaries());
    }

    @Test
    public void shouldPrintPayroll(){
        String toStringEc1 = "Stan Ursic, department engineering, salary $400.0, payment by commission.";
        String toStringEs1 = "Harry Porter, department engineering, salary $460.0, payment by salary.";
        String toStringEh1 = "Danielle Vergara, department arts, salary $30.0, payment by hours.";
        assertEquals(toStringEc1+toStringEs1+toStringEh1, ec1.toString()+es1.toString()+eh1.toString());
        sp.printPayroll();
    }

    @Test
    public void shouldDepositToEmployee(){
        assertTrue(sp.depositToEmployee(10000, ec1.getId()));
        assertTrue(sp.depositToEmployee(4000, es1.getId()));
        assertTrue(sp.depositToEmployee(12000, eh1.getId()));
    }

    @Test
    public void shouldNotDepositToEmployee(){
        assertFalse(sp.depositToEmployee(4000, ec1.getId()));
        assertFalse(sp.depositToEmployee(2000, es1.getId()));
        assertFalse(sp.depositToEmployee(1000, eh1.getId()));
    }

    @Test
    public void shouldCalculateEmployeeBalance(){
        assertTrue(sp.depositToEmployee(10000, ec1.getId()));
        assertTrue(sp.depositToEmployee(4000, es1.getId()));
        assertFalse(sp.depositToEmployee(2000, es1.getId()));
        assertTrue(sp.depositToEmployee(12000, eh1.getId()));

        assertEquals(5000, sp.calculateEmployeeBalance(ec1.getId()));
        assertEquals(2000, sp.calculateEmployeeBalance(es1.getId()));
        assertEquals(10000, sp.calculateEmployeeBalance(eh1.getId()));
    }
    @Test
    public void shouldCalculateAllEmployeesBalance(){
        assertTrue(sp.depositToEmployee(10000, ec1.getId()));
        assertTrue(sp.depositToEmployee(4000, es1.getId()));
        assertFalse(sp.depositToEmployee(2000, es1.getId()));
        assertTrue(sp.depositToEmployee(12000, eh1.getId()));

        assertEquals(17000, sp.calculateAllEmployeesBalance());
    }



}
