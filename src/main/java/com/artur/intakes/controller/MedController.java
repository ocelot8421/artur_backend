package com.artur.intakes.controller;

import com.artur.intakes.model.MedicationIntake;
import com.artur.intakes.repositories.IntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/intakes")
public class MedController {

    @Autowired
    private IntakeRepository intakeRepository;

//    http://localhost:8080/intakes/add
    @PostMapping(path = "/add")
    public @ResponseBody String addNewIntake(
            @RequestParam String time){
        MedicationIntake intake = new MedicationIntake();
        intake.setTime(time);
        intakeRepository.save(intake);
        return "new medication intake saved";
    }

    //    http://localhost:8080/intakes/allIntakes
    @GetMapping("/allIntakes")
    @CrossOrigin //>>5.
    public @ResponseBody Iterable<MedicationIntake> getAllIntakes(){
        return intakeRepository.findAll();
    }

//     http://localhost:8080/intakes/{id}
    @GetMapping("/{id}")
    @CrossOrigin //>>5.
    public @ResponseBody
    Optional<MedicationIntake> getIntakeId(@PathVariable Long id){
       return intakeRepository.findById(id);
    }

    //     http://localhost:8080/intakes/{id}
    @DeleteMapping("/{id}")
    @CrossOrigin //>>5.
    public @ResponseBody Iterable<MedicationIntake> deleteIntakeId(@PathVariable("id") Long id){
       intakeRepository.deleteById(id);
       return intakeRepository.findAll();
    }
}
