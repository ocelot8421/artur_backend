package com.artur.intakes.sandbox.manyToMany.basicManyToMany;
//https://www.baeldung.com/jpa-many-to-many

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Data
public class Course {
    @Id
    private Long id;

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;
}
