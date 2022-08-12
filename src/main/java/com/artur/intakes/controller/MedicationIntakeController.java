package com.artur.intakes.controller;

import com.artur.intakes.dto.MedicationIntakeDTO;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Date;
import com.artur.intakes.service.MedicationIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/intakes")
public class MedicationIntakeController {

    @Autowired
    private MedicationIntakeService medicationIntakeService;

    //    http://localhost:8080/intakes/allIntakes
    @GetMapping("/allIntakes")
    @CrossOrigin
    public @ResponseBody Iterable<MedicationIntakeDTO> getIntakes(){
       return medicationIntakeService.retrieveAllIntakes();
    }

    //     http://localhost:8080/intakes/get/{id}
    @GetMapping("/get/{id}")
    @CrossOrigin
    public @ResponseBody
    MedicationIntakeDTO getIntakeId(@PathVariable("id") Long id) {
        return medicationIntakeService.retrieveIntakeById(id);
    }

    //    http://localhost:8080/intakes/add
    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @CrossOrigin
    public MedicationIntakeDTO addNewIntake(
            @RequestBody MedicationIntake medicationIntake,
            @RequestBody Date date
    ) {
        return medicationIntakeService.createAndUpdateIntake(medicationIntake, date);
    }

    //    http://localhost:8080/intakes/put/{id}
    @PutMapping(path = "/put/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public MedicationIntakeDTO changeIntake(
            @RequestBody MedicationIntake medicationIntake,
            @RequestBody Date date
    ) {
        return medicationIntakeService.createAndUpdateIntake(medicationIntake, date);
    }

    //     http://localhost:8080/intakes/del/{id}
    @DeleteMapping(path = "/del/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            headers = "Accept=application/json")
    @CrossOrigin
    public @ResponseBody
    Iterable<MedicationIntakeDTO> deleteIntakeId(@PathVariable("id") Long id) {
        medicationIntakeService.eraseIntake(id);
        return medicationIntakeService.retrieveAllIntakes();
    }
}
