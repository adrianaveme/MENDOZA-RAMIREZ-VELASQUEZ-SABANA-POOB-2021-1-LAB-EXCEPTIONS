package entities;

public class SabanaPayrollExceptions extends Exception{
    public static final String NONEXISTENT_EMPLOYEE = "This employee doesn't exist";

    public SabanaPayrollExceptions(String message) {
        super(message);
    }

}
