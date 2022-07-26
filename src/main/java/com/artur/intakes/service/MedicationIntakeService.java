package com.artur.intakes.service;

import com.artur.intakes.dto.MedicationIntakeDto;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.TimeOfMedication;
import com.artur.intakes.repositories.MedicationIntakeRepository;
import com.artur.intakes.repositories.TimeOfMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;


@Service
public class MedicationIntakeService {

    @Autowired
    private MedicationIntakeRepository medicationIntakeRepository;

    public MedicationIntakeService(MedicationIntakeRepository medicationIntakeRepository) {
        this.medicationIntakeRepository = medicationIntakeRepository;
    }

    public List<MedicationIntakeDto> retrieveAllIntakes() {
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

    public MedicationIntakeDto createAndUpdateIntake(MedicationIntake medicationIntake, TimeOfMedication timeOfMedication) {
        MedicationIntake intake = medicationIntakeRepository.save(medicationIntake);
        return new MedicationIntakeDto(intake);
    }

    public void eraseIntake(Long id) {
        medicationIntakeRepository.deleteById(id);
    }



}
