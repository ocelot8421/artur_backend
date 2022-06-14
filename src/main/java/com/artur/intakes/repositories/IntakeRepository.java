package com.artur.intakes.repositories;

import com.artur.intakes.model.MedicationIntake;
import org.springframework.data.repository.CrudRepository;

public interface IntakeRepository extends CrudRepository<MedicationIntake, Long> { //>>3., 4...


}
