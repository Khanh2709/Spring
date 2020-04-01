package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
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
    @ManyToOne
    @JoinColumn(name ="dep_id")
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
