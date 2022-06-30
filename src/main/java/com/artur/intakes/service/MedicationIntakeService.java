package com.artur.intakes.service;

import com.artur.intakes.dto.MedicationIntakeDto;
import com.artur.intakes.model.MedicationIntake;
import com.artur.intakes.repositories.MedicationIntakeRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MedicationIntakeService {

    private MedicationIntakeRepository medicationIntakeRepository;

    public MedicationIntakeService(MedicationIntakeRepository medicationIntakeRepository) {
        this.medicationIntakeRepository = medicationIntakeRepository;
    }

    public Iterable<MedicationIntakeDto> retrieveAllIntakes() {
        return medicationIntakeRepository
                .findAll()
                .stream()
                .map(MedicationIntakeDto::new)
                .collect(Collectors.toList());
    }

    public MedicationIntakeDto retrieveIntakeById(Long id) {
        MedicationIntake intake = medicationIntakeRepository.findById(id).orElse(null);
        if (intake == null) {
            return null;
        }
        return new MedicationIntakeDto(intake);
    }

    public MedicationIntakeDto createAndUpdateIntake(MedicationIntake medicationIntake) {
        MedicationIntake intake = medicationIntakeRepository.save(medicationIntake);
        return new MedicationIntakeDto(intake);
    }

    public void eraseIntake(Long id) {
        medicationIntakeRepository.deleteById(id);
    }

}
