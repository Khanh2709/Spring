package com.example.demo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByDepName(String depName);
    @Query(value = "select distinct d.listEmployee" +
            " from Employee  e,Department d " +
            "where d.depName = :depName  ")
    List<Employee> findEmployeeBydepName (@Param("depName") String depName);
}
