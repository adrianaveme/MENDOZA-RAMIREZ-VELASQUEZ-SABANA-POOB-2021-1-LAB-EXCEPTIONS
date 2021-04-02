package entities;

import java.util.UUID;
import java.util.List;

public class Department {

    private List<Employee>employees;
    private UUID id;
    private String name;

    public Department(String name, List<Employee> employees){
        this.id = UUID.randomUUID();
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public UUID getId(){
        return id;
    }

    public List getEmployees(){
        return employees;
    }

    public double calculateDepartmentSalaries(){
        double cont = 0;
        for (Employee e: employees){
            cont += e.calculateSalary();
        }
        return cont;
    }
}
