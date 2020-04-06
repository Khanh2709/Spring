package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{depId}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable int depId) throws NotFoundException {
        Department dep = departmentService.findDepartmentById(depId);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAllDepartment() {
        List<Department> departments = departmentService.findAllDepartment();
        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PutMapping("/{depId}")
// @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Department> updateDepartment(@PathVariable int depId, @RequestBody Department dep) throws NotFoundException {
        departmentService.updateDepartment(depId, dep);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

    @DeleteMapping("/{depId}")
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteDepartmentById(@PathVariable int depId) throws NotFoundException {
        departmentService.deleteDepartmentById(depId);
        return new ResponseEntity<>("Department with ID :" + depId + " deleted successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department dep) {
        dep = departmentService.addDepartment(dep);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

    @GetMapping("/depname/{depName}")
    public ResponseEntity<List<Department>> findDepartmentByName(@PathVariable String depName) throws NotFoundException {
        List<Department> dep = departmentService.findDepartmentByName(depName);
        if (dep.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

    @GetMapping("/departments/{depId}")
    public ResponseEntity<Department> findEmployeeByDEPId(@PathVariable int depId) throws NotFoundException {
        Department dep = departmentService.findEmployeeByDepartmentId(depId);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }
    @GetMapping("/dep/{depName}")
    public ResponseEntity<Department> findEmployeeByDEPName(@PathVariable String depName) throws NotFoundException {
        Department dep = departmentService.findEmployeeByDepartmentName(depName);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

}
