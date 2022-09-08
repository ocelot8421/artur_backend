package com.artur.intakes.controller;

import com.artur.intakes.dto.ConnectionDTO;
import com.artur.intakes.dto.DayOfWeekDTO;
import com.artur.intakes.service.MedicationIntakeService;
import com.artur.intakes.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private MedicationIntakeService medicationIntakeService;

    //    http://localhost:8080/medicines
    @GetMapping()
    @CrossOrigin
    public @ResponseBody
    Iterable<DayOfWeekDTO> getMedicines(){
        return medicineService.retrieveGroupedMedicines();
    }

    //    http://localhost:8080/intakes/put/{id}
    @PutMapping(path = "/put/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
//    public MedicationIntakeDTO changeIntake(
    public void changeIntake(
            @RequestBody ConnectionDTO connection
    ) {
//        return medicineService.createAndUpdateIntake(connection);
        medicineService.createAndUpdateIntake(connection);
    }

    //     http://localhost:8080/medicines/del/{id}
    @DeleteMapping(path = "/del/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            headers = "Accept=application/json")
    @CrossOrigin
    public @ResponseBody
    Iterable<DayOfWeekDTO> deleteIntakeId(@PathVariable("id") Long id) {
        medicineService.eraseIntake(id);
        return medicineService.retrieveGroupedMedicines();
    }
}
