package com.example.demo1;

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
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Department> addDepartment(@RequestBody Department dep) {
        departmentService.addDepartment(dep);
        return new ResponseEntity<>(dep,HttpStatus.OK);
    }

    @GetMapping("/depname/{depName}")
    public ResponseEntity<List<Department>> findDepartmentByName(@PathVariable String depName)throws NotFoundException  {
        List<Department> dep = departmentService.findDepartmentByName(depName);
        if (dep.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<List<Department>> findEmployeeByDepartmentId(@PathVariable int depId,@RequestBody Department dep) throws NotFoundException {
//        List<Department> departments = departmentService.findEmployeeByDepartmentId(depId,dep);
//        if (departments.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>(departments, HttpStatus.OK);
//    }
}
