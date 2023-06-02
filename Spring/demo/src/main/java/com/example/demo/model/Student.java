package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT_TBL")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String department;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TBL",
            joinColumns = {@JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "COURSE_ID", referencedColumnName = "id")})

    @JsonManagedReference
    private Set<Course> courses;
}
