package com.example.demo.service;

import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repo.DepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {
    @Autowired
    private DepRepo depRepo;

    public Department createDepartment(Department department) {
        return depRepo.save(department);

    }

    public List<Department> getAllDepartmentsList() {
        return depRepo.findAll();
    }

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        if(depRepo.findById(departmentId).isEmpty()){
            throw new DepartmentNotFoundException("Department not found: " + departmentId + "");
        }
        return depRepo.findById(departmentId).get();
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {

    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return null;
    }
}
