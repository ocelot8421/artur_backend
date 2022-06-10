package com.example.learnspringboot.courses.controller;

import com.example.learnspringboot.courses.bean.Envelope;
import com.example.learnspringboot.courses.bean.MedicationIntake;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedController {
    List<MedicationIntake> intakeList = List.of(
            new MedicationIntake(
                    1, "2022.06.10., 8:00",
                    "L", 0,
                    "R", 0,
                    "A", 0
            ),
            new MedicationIntake(
                    1, "2022.06.10., 20:00",
                    "L", 200,
                    "R", 1,
                    "A", 100
                    ),
            new MedicationIntake(
                    1, "2022.06.10., 20:00",
                    "L", 200,
                    "R", 1,
                    "A", 0
            )
    );

    // http://localhost:8080/intakes
    @GetMapping("/intakes")
    public List<MedicationIntake> getAllCourses(){
        return intakeList;
    }

    // http://localhost:8080/intakes/1
    @GetMapping("intakes/1")
    public MedicationIntake getCourseDetails(){
       return new MedicationIntake(
                1, "2022.06.10., 20:00",
                "L", 200,
                "R", 1,
                "A", 100
        );
    }
}
