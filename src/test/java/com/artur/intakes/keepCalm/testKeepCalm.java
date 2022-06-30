package com.artur.intakes.keepCalm;

import com.artur.intakes.configuration.IntakeJpaConfig;
import com.artur.intakes.model.MedicationIntake;
import com.artur.intakes.repositories.MedicationIntakeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {IntakeJpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class testKeepCalm {

    @Resource
    private MedicationIntakeRepository medicationIntakeRepository;

    @Test
    public void givenIntake_whenSave_thenGetOk(){
        MedicationIntake medicationIntake = new MedicationIntake(
                9L, "test month", "test day of month", "test day of week",
                "med 1", 0.123, 123,
                "med 2", 0.456, 456,
                null, 0);
        medicationIntakeRepository.save(medicationIntake);

//        MedicationIntake medicationIntake2 = medicationIntakeRepository.findOne(9L);
//        assertEquals("")

    }
}
