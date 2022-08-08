package com.artur.intakes.sandbox.manyToMany.multipleConnection;
//https://www.baeldung.com/jpa-many-to-many

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Course {
    @Id
    private Long id;

    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> registrations;
}
