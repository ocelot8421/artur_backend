package com.artur.intakes.sandbox.manyToMany.compositeKey;
//https://www.baeldung.com/jpa-many-to-many#3-using-a-composite-key-in-jpa

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CourseRating {

    @EmbeddedId
    CourseRatingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private int rating;
}
