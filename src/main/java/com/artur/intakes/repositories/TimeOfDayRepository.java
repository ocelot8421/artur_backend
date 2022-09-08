package com.artur.intakes.repositories;

import com.artur.intakes.entity.Date;
import com.artur.intakes.entity.TimeOfDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeOfDayRepository extends JpaRepository<TimeOfDay, Long> {
}
