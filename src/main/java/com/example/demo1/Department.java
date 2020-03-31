package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
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
    @OneToMany( mappedBy = "department",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonManagedReference
    public List<Employee> listEmployee ;

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
    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    @Override
        public String toString() {
            return "Id= " + getDepId() + " DepName= " +
                    getDepName();
    }
}
