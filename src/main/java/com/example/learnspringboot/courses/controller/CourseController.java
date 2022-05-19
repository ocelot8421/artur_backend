package com.example.learnspringboot.courses.controller;

import com.example.learnspringboot.courses.bean.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    List<Course> courseList = List.of(new Course(1, "Learn Microservices", "in28minutes"),
            new Course(2, "Learn Full Stack with Angular and React", "in28minutes"));

    // http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseList;
    }

    //http://localhost:8080/courses/1
    @GetMapping("courses/1")
    public Course getCourseDetails(){
        return new Course(1, "Learn Microservices 1", "in28minutes");
    }

    @GetMapping("/ping")
    ResponseEntity<String> ping(){
        return ResponseEntity.ok("All is well");
    }

}
