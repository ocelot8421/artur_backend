package com.artur.intakes.sandbox.manyToMany.compositeKey;
//https://www.baeldung.com/jpa-many-to-many

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Student {

    @Id
    private Long id;

    @OneToMany(mappedBy = "student")
    private Set<CourseRating> ratings;
}
