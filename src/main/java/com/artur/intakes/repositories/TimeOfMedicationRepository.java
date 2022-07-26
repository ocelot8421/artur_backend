package com.artur.intakes.repositories;

import com.artur.intakes.entity.TimeOfMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeOfMedicationRepository extends JpaRepository<TimeOfMedication, Long> {
}
