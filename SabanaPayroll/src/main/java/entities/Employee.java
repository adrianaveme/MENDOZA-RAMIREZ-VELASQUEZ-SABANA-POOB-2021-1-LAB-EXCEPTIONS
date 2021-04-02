package entities;

import entities.Department;

import java.util.UUID;

public class Employee {

    private UUID id;
    private String name, lastName;
    private Department department;

    public Employee(String name, String lastName, Department department){
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    public double calculateSalary() {
        return 0;
    }

    public UUID getId(){
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s, department %s, salary $%s,", this.name, this.lastName, this.department.getName(), this.calculateSalary());
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
