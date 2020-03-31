package com.example.demo1;

import javassist.NotFoundException;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department findDepartmentById(int depId) throws NotFoundException {
        Optional<Department> dep = departmentRepository.findById(depId);
        if (dep.isPresent()) {
            return dep.get();
        } else {
            throw new NotFoundException("Không Tìm Thấy Department id :" + depId);
        }
    }

    public List<Department> findAllDepartment() {
        List<Department> dep = departmentRepository.findAll();
        if (dep.size() > 0) {
            return dep;
        } else {
            return new ArrayList<Department>();
        }
    }

    public void deleteDepartmentById(int depId) throws NotFoundException {
        Optional<Department> employee = departmentRepository.findById(depId);
        if (employee.isPresent()) {
            departmentRepository.deleteById(depId);
        } else {
            throw new NotFoundException("Không Tìm Thấy Department id :" + depId);
        }
    }

    public Department addDepartment(Department dep) {
        return departmentRepository.save(dep);
    }
    public void updateDepartment(int depId, Department dep) throws NotFoundException {
        Optional<Department> department = departmentRepository.findById(depId);
        dep.setDepId(depId);
        if (department.isPresent()) {
            departmentRepository.save(dep);
        } else {
            throw new NotFoundException("Không Tìm Thấy Department id :" + depId);

        }
    }

    public List<Department> findDepartmentByName(String depName) throws NotFoundException {
        List<Department> dep = departmentRepository.findByDepName(depName);
        if (dep.size() > 0) {
            return dep;
        } else {
            throw new NotFoundException("Không Tìm Thấy Department id :" + depName);
        }
    }

    public Department findEmployeeByDepartmentId(int depId) throws NotFoundException {
        Optional<Department> dep = departmentRepository.findById(depId);
        if (dep.isPresent()) {
            return dep.get();
        } else {
            throw new NotFoundException("Không Tìm Thấy Department id :" + depId);
        }
    }
}
