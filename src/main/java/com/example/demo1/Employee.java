package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
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
        this.salary_emp=salary_emp;

    }
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonIgnoreProperties(value = {"Employee","listEmployee"})
    private Department department;



    @Override
    public String toString() {
        return "Id= " + getId() + " First Name= " +
                getFirstName() + " Last Name= " + getLastName() +"Salary"+ getSalary_emp();
}

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
