package com.artur.intakes.controller;

import com.artur.intakes.model.MedicationIntake;
import com.artur.intakes.repositories.IntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedController {

    @Autowired
    private IntakeRepository intakeRepository;

    @PostMapping(path = "/addIntake")
    public @ResponseBody String addNewIntake(
            @RequestParam String time){
        MedicationIntake intake = new MedicationIntake();
        intake.setTime(time);
        intakeRepository.save(intake);
        return "new medication intake saved";
    }

//    List<MedicationIntake> intakeList = List.of(
//            new MedicationIntake(
//                    1L, "2022.06.10., 8:00",
//                    "L", 0,
//                    "R", 0,
//                    "A", 0
//            ),
//            new MedicationIntake(
//                    2L, "2022.06.10., 20:00",
//                    "L", 200,
//                    "R", 1,
//                    "A", 100
//                    ),
//            new MedicationIntake(
//                    3L, "2022.06.10., 20:00",
//                    "L", 200,
//                    "R", 1,
//                    "A", 0
//            )
//    );

    // http://localhost:8080/allIntakes
    @GetMapping("/allIntakes")
    @CrossOrigin //>>5.
//    public List<MedicationIntake> getAllCourses(){
//        return intakeList;
//    }
    public @ResponseBody Iterable<MedicationIntake> getAllIntakes(){
        return intakeRepository.findAll();
    }

//     http://localhost:8080/allIntakes/1
    @GetMapping("allIntakes/1")
    @CrossOrigin //>>5.
    public MedicationIntake getCourseDetails(){
       return new MedicationIntake(
                1L, "2022.06.10., 20:00",
                "L", 200,
                "R", 1,
                "A", 100
        );
    }
}
