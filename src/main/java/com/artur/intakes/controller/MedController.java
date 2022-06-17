package com.artur.intakes.controller;

import com.artur.intakes.model.MedicationIntake;
import com.artur.intakes.repositories.IntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/intakes")
public class MedController {

    @Autowired
    private IntakeRepository intakeRepository;

    //    http://localhost:8080/intakes/allIntakes
    @GetMapping("/allIntakes")
    @CrossOrigin
    public @ResponseBody
    Iterable<MedicationIntake> getAllIntakes() {
        return intakeRepository.findAll();
    }

    //     http://localhost:8080/intakes/get/{id}
    @GetMapping("/get/{id}")
    @CrossOrigin
    public @ResponseBody
    Optional<MedicationIntake> getIntakeId(@PathVariable Long id) {
        return intakeRepository.findById(id);
    }


    //    http://localhost:8080/intakes/add
    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public MedicationIntake addNewIntake(@RequestBody MedicationIntake intake) {
        return intakeRepository.save(intake);
    }


    //    http://localhost:8080/intakes/put/{id}
    @PutMapping(path = "/put/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public MedicationIntake changeIntake(@RequestBody MedicationIntake intake) {
        return intakeRepository.save(intake);
    }


    //     http://localhost:8080/intakes/del/{id}
    @DeleteMapping(path = "/del/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public @ResponseBody
    Iterable<MedicationIntake> deleteIntakeId(@RequestBody MedicationIntake intake) {
        intakeRepository.deleteById(intake.getId());
        return intakeRepository.findAll();
    }
}
