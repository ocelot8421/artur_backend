package com.artur.intakes.repositories;

import com.artur.intakes.model.MedicationIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationIntakeRepository extends JpaRepository<MedicationIntake, Long> {
}
