package entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CafamFund implements IFamilyCompensationFund{

    Set<UUID> registeredEmployees = new HashSet<>();

    @Override
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException {

        if (registeredEmployees.contains(employee.getId()))
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_REGISTERED);

        return registeredEmployees.add(employee.getId());

    }

    @Override
    public boolean deleteEmployee(UUID id) throws FamilyCompensationFundException {

        if(!(isEmployeeRegistered(id)))
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);


        return  registeredEmployees.remove(id);
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) throws FamilyCompensationFundException {

        if (!(registeredEmployees.contains(id)))
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);

        return registeredEmployees.contains(id);
    }

    @Override
    public String printBenefits() {
        return "The benefits of a Cafam Fund are:" +
                " access to entertainment facilities such as ice skating rinks and playgrounds";
    }
}
