package entities;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ColsubsidioFund implements IFamilyCompensationFund {

    private static Map<UUID, Employee> registeredEmployees = new HashMap<>();

    public ColsubsidioFund() {

    }

    /**
     * No permite registrar empleados de tipo EmployeeByCommission.
     *
     * @param employee
     * @return
     */
    @Override
    public boolean registerEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(UUID id) {
        return false;
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) {
        return false;
    }

    @Override
    public String printBenefits() {
        return null;
    }
}
