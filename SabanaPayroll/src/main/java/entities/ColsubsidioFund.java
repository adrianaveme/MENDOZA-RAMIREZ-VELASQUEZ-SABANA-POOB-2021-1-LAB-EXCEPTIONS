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
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException {

        if (registeredEmployees.containsKey(employee.getId()))
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_REGISTERED);
        if (employee instanceof EmployeeCommission)
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED);

        registeredEmployees.put(employee.getId(), employee);
        return registeredEmployees.containsKey(employee.getId());
    }

    @Override
    public boolean deleteEmployee(UUID id) throws FamilyCompensationFundException {

        if (!(isEmployeeRegistered(id)))
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);

        registeredEmployees.remove(id);

        return (!(registeredEmployees.containsKey(id)));
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) throws FamilyCompensationFundException {

        if (!(registeredEmployees.containsKey(id)))
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);

        return registeredEmployees.containsKey(id);
    }

    @Override
    public String printBenefits() {
        return "The benefits of a Colsubsidio Fund are: access to facilities like gyms and training centers and courses every month for varied skills";
    }
}
