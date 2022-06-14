package com.artur.intakes.repositories;

import com.artur.intakes.model.MedicationIntake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface IntakeRepository extends CrudRepository<MedicationIntake, Long> { //>>3., 4...


}
