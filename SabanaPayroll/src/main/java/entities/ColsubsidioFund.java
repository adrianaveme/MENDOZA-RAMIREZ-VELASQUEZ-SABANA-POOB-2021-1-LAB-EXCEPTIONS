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

    boolean result = false;

    if (!(isEmployeeRegistered(employee.getId())||employee instanceof EmployeeCommission)) {
        registeredEmployees.put(employee.getId(),employee);
        result = true;

    }

    return result;
    }

    @Override
    public boolean deleteEmployee(UUID id) {

        boolean result = false;

        if (isEmployeeRegistered(id)){
            registeredEmployees.remove(id);
            result = true;
        }

        return result;
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) {
        return registeredEmployees.containsKey(id);
    }

    @Override
    public String printBenefits() {
        return null;
    }
}
