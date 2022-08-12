package com.artur.intakes.sandbox.manyToMany.basicManyToMany;
//https://www.baeldung.com/jpa-many-to-many

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Student {

    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> likedCourses;
}
