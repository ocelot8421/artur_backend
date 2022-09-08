package com.artur.intakes.repositories;

import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long> {

}
