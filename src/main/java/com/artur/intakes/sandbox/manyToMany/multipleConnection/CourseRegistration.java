package com.artur.intakes.sandbox.manyToMany.multipleConnection;
//https://www.baeldung.com/jpa-many-to-many#2-implementation-in-jpa-1

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class CourseRegistration {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime registeredAt;

    private int grade;
}
