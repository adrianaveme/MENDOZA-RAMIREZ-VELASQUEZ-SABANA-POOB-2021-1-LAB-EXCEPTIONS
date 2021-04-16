package entities;

import java.util.ArrayList;
import java.util.UUID;

public class CompensarFund implements IFamilyCompensationFund{

    ArrayList<UUID> registeredEmployees = new ArrayList<>();

    /**
     * No permite registrar empleados de tipo EmployeeHours.
     *
     * @param employee
     * @return
     */


    @Override
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException {

        if ((registeredEmployees.contains(employee.getId())))
            throw new FamilyCompensationFundException (FamilyCompensationFundException.EMPLOYEE_REGISTERED);
        if (employee instanceof EmployeeHours)
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED);

        return registeredEmployees.add(employee.getId());

    }

    @Override
    public boolean deleteEmployee(UUID id) {

        boolean result = false;
        if(isEmployeeRegistered(id)){
            registeredEmployees.remove(id);
            result = true;
        }

        return result;
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) {

        boolean result = false;
        if (registeredEmployees.contains(id)){
            result= true;
        }
        return result;
    }

    @Override
    public String printBenefits() {
        return "The benefits of a Compensar Fund are:" +
                " access to facilities like swimming pools and dance halls.";
    }
}
