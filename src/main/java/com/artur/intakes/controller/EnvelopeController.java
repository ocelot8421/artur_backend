package com.artur.intakes.controller;

import com.artur.intakes.model.Envelope;
import com.artur.intakes.repositories.EnvelopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envelope")
public class EnvelopeController {

    @Autowired
    private EnvelopeRepository envelopeRepository;
//    private IntakeRepository intakeRepository;

    //    http://localhost:8080/envelope/put/{id}
    @PutMapping(path = "/put/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Envelope changeIntake(@RequestBody Envelope envelope) {
        return envelopeRepository.save(envelope);
    }


}
