package entities;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ColsubsidioFund implements IFamilyCompensationFund {

    private Map<UUID, Employee> registeredEmployees = new HashMap<>();

    public ColsubsidioFund() {

    }

    /**
     * No permite registrar empleados de tipo EmployeeByCommission.
     *
     * @param employee
     * @return result
     */
    @Override
    public boolean registerEmployee(Employee employee) {

    boolean result = false;

        if (!(registeredEmployees.containsKey(employee.getId()))) {
            if (!(employee instanceof EmployeeCommission)) {
            registeredEmployees.put(employee.getId(), employee);
            result = true;
            }
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
        return "The benefits of a Colsubsidio Fund are: access to facilities like gyms and training centers and courses every month for varied skills";
    }
}
