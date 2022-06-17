package com.artur.intakes.repositories;

import com.artur.intakes.model.MedicationIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //>>3.
public interface IntakeRepository extends JpaRepository<MedicationIntake, Long> { //>>9.
//public interface IntakeRepository extends CrudRepository<MedicationIntake, Long> { //>>3., 4...


}
