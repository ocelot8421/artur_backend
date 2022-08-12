package com.artur.intakes.repositories;

import com.artur.intakes.entity.MedicationIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyCycleRepository extends JpaRepository<MedicationIntake, Long> {
}
