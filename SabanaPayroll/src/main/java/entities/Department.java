package entities;

import java.util.UUID;
import java.util.ArrayList;

public class Department {

    private ArrayList<Employee>employees;
    private UUID id;
    private String name;

    public Department(String name, ArrayList<Employee> employees){
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

    public ArrayList getEmployees(){
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
