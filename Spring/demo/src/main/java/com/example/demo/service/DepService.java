package com.example.demo.service;

import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;

import java.util.List;

public interface DepService {
    Department createDepartment(Department department);
    List<Department> getAllDepartmentsList();
    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    Department updateDepartment(Long departmentId, Department department);
    void deleteDepartmentById(Long departmentId);
    Department getDepartmentByName(String departmentName);


}
