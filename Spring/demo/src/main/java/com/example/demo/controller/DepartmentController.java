package com.example.demo.controller;

import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepService depService;

    @PostMapping("/deps")
    public Department createDepartment(@RequestBody Department department) {
        return depService.createDepartment(department);

    }
    @GetMapping("/deps/{id}")
    public Department getDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
        return depService.getDepartmentById(id);
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return depService.getAllDepartmentsList();
    }

}
