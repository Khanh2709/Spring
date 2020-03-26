package com.example.demo1;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="salary")
    private int salary_emp;
    @Column(name = "department_id")
    private int dept;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getSalary_emp() {
        return salary_emp;
    }

    public void setSalary_emp(int salary_emp) {
        this.salary_emp = salary_emp;
    }

    public Employee() {

    }

    public Employee(String firstName, String lastName, int dept, int salary_emp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.salary_emp=salary_emp;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;
    @Override
    public String toString() {
        return "Id= " + getId() + " First Name= " +
                getFirstName() + " Last Name= " + getLastName() +"Salary"+ getSalary_emp()
                + " Dept= " + getDept();
}
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }
}
