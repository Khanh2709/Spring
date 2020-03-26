package com.example.demo1;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="department")
public class Department  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dep_id")
    private int depId;

    @Column(name = "dep_name")
    private String depName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
    public Department() {

    }
    public Department(String depName) {
        this.depName = depName;
    }


    @Override
        public String toString() {
            return "Id= " + getDepId() + " DepName= " +
                    getDepName();
    }



}
