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
    public boolean registerEmployee(Employee employee) {
        boolean result = false;

        if (registeredEmployees.contains(employee.getId())||employee instanceof EmployeeCommission){
            registeredEmployees.add(employee.getId());
            result = true;
        }
        return result;
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
        return null;
    }
}
