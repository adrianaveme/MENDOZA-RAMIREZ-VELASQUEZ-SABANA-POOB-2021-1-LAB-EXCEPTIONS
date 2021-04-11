package entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CafamFund implements IFamilyCompensationFund{

    Set<UUID> registeredEmployees = new HashSet<>();

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
        return "The benefits of a Cafam Fund are:" +
                " access to entertainment facilities such as ice skating rinks and playgrounds";
    }
}
