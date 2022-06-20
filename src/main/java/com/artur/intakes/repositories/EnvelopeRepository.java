package com.artur.intakes.repositories;

import com.artur.intakes.model.Envelope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvelopeRepository extends JpaRepository<Envelope, Long> {
}
