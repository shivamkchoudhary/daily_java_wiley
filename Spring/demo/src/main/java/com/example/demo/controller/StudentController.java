package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/course")
public class StudentController {

    private StudentRepo studentRepo;

    private CourseRepo courseRepo;

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @GetMapping("/findByName/{name}")
    public List<Student> findStudentsByName(@PathVariable String name) {
        return studentRepo.findByName(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThan(@PathVariable int price) {
        return courseRepo.findByPriceLessThan(price);
    }

}