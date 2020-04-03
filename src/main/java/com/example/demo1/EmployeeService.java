package com.example.demo1;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee findEmployeeById(int id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new NotFoundException("Không Tìm Thấy Employee id :" + id);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(int id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new NotFoundException("Không Tìm Thấy Employee id :" + id);
        }
    }

    public Employee addEmployee(Employee emp) {

        return employeeRepository.save(emp);
    }

    public void updateEmployee(int id, Employee emp) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            emp.setId(id);
            employeeRepository.save(emp);
        } else {
            throw new NotFoundException("Không Tìm Thấy Employee id :" + id);
        }
    }

    public List<Employee> findEmployeeByName(String lastName) throws NotFoundException {
        List<Employee> emp = employeeRepository.findByLastName(lastName);
        if (emp.size() > 0) {
            return emp;
        } else {
            throw new NotFoundException("Không Tìm Thấy Employee lastname :" + lastName);
        }
    }


}

