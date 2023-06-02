package com.example.demo.service;

import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repo.DepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // get department by id
        Department dep = depRepo.findById(departmentId).get();
        // check for null values
        if(department.getDepartmentName() != null && !"".equalsIgnoreCase(department.getDepartmentName())){
            dep.setDepartmentName(department.getDepartmentName());
        }
        if(department.getDepartmentAddress() != null && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            dep.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(department.getDepartmentCode() != null && !"".equalsIgnoreCase(department.getDepartmentCode())){
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        // save department
        return depRepo.save(dep);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        depRepo.deleteById(departmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return depRepo.findByDepartmentName(departmentName);
    }
}
