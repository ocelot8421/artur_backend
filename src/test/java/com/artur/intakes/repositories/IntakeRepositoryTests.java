package com.artur.intakes.repositories;

import com.artur.intakes.configuration.AppConfig;
import com.artur.intakes.model.MedicationIntake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ContextConfiguration(classes = AppConfig.class)
public class IntakeRepositoryTests {

//    @Autowired
//    private IntakeRepository intakeRepository;
//
//    @Test
//    public void testSaveThenFindAll(){
//        MedicationIntake intake = new MedicationIntake();
//        intake.setDay("Munkaszüneti nap");
//        intake.setMedicine01("L");
//        intake.setDose01(200);
//        intake.setTime("2022.06.20");
//        intakeRepository.save(intake);
//
//        Iterable<MedicationIntake> intakes =
//                intakeRepository.findAll();
//        assertEquals(List.of(intake), StreamSupport.stream(
//                intakes.spliterator(), false)
//                .collect(Collectors.toList()));
//    }
}
