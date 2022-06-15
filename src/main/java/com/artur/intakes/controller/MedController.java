package com.artur.intakes.controller;

import com.artur.intakes.model.MedicationIntake;
import com.artur.intakes.repositories.IntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/intakes")
public class MedController {

    @Autowired
    private IntakeRepository intakeRepository;

    //    http://localhost:8080/intakes/add
//    @PostMapping("/add") //>>3. //del>>6.
    @PostMapping(path = "/add", //>>6.
            consumes = MediaType.APPLICATION_JSON_VALUE, // >>6.
            produces = MediaType.APPLICATION_JSON_VALUE) //>>6.
    @CrossOrigin //>>google
    public MedicationIntake addNewIntake(@RequestBody MedicationIntake intake) //>>9.
    ////vv3.            //vv9.delete
//    public @ResponseBody
//    String addNewIntake(
//            @RequestParam Long id,
//            @RequestParam String time,
//            @RequestParam String medicine01,
//            @RequestParam double dose01,
//            @RequestParam String medicine02,
//            @RequestParam double dose02,
//            @RequestParam String medicine03,
//            @RequestParam double dose03
//            ){
//        MedicationIntake intake = new MedicationIntake();
//        intake.setTime(time);
//        intake.setMedicine01(medicine01);
//        intake.setDose01(dose01);
//        intake.setMedicine02(medicine02);
//        intake.setDose02(dose02);
//        intake.setMedicine03(medicine03);
//        intake.setDose03(dose03);
    //  return "Saved";
    //^^3. //^^9.delete
    {
        return intakeRepository.save(intake); //>>9.
    }


    //    http://localhost:8080/intakes/allIntakes
    @GetMapping("/allIntakes")
    @CrossOrigin //>>5.
    public @ResponseBody
    Iterable<MedicationIntake> getAllIntakes() {
        return intakeRepository.findAll();
    }

    //     http://localhost:8080/intakes/{id}
    @GetMapping("/{id}")
    @CrossOrigin //>>5.
    public @ResponseBody
    Optional<MedicationIntake> getIntakeId(@PathVariable Long id) {
        return intakeRepository.findById(id);
    }

    //     http://localhost:8080/intakes/{id}
    @DeleteMapping("/{id}")
    @CrossOrigin //>>5.
    public @ResponseBody
    Iterable<MedicationIntake> deleteIntakeId(@PathVariable("id") Long id) {
        intakeRepository.deleteById(id);
        return intakeRepository.findAll();
    }
}
