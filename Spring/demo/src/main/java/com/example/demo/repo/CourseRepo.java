package com.example.demo.repo;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Student, Long> {

    public List<Course> findByPriceLessThan(int price);

}