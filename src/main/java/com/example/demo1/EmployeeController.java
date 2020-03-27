package com.example.demo1;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) throws NotFoundException {
        Employee emp = empService.findEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = empService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) throws NotFoundException {

        empService.updateEmployee(id, emp);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws NotFoundException {
        empService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee with ID :" + id + " deleted successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        Employee employee = empService.addEmployee(emp);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable String lastName)throws NotFoundException  {
        List<Employee> emp = empService.findEmployeeByName(lastName);
        if (emp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}