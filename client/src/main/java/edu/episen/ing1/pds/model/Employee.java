package edu.episen.ing1.pds.model;

public class Employee {
    private int id_employee;
    private String name;
    private int accesscard;

    public Employee(int id, String n, int access){
        this.id_employee=id;
        this.name=n;
        this.accesscard=access;


    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccesscard() {
        return accesscard;
    }

    public void setAccesscard(int accesscard) {
        this.accesscard = accesscard;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", name='" + name + '\'' +
                ", accesscard=" + accesscard +
                '}';
    }
}
