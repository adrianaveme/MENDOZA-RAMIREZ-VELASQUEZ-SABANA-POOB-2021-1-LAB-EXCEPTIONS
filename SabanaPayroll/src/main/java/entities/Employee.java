package entities;

import entities.Department;

import java.util.UUID;

public abstract class Employee {

    private UUID id;
    private String name, lastName;
    private Department department;
    private BankAccount account;

    public Employee(String name, String lastName, Department department, BankAccount account){
        this.id = UUID.randomUUID();
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.account = account;
    }

    public abstract double calculateSalary();

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
