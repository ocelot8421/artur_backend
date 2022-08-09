package com.artur.intakes.service;

import com.artur.intakes.dto.MedicationIntakeDTO;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Date;
import com.artur.intakes.repositories.MedicationIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;


@Service
public class MedicationIntakeService {

    @Autowired
    private MedicationIntakeRepository medicationIntakeRepository;

    @Autowired
    private MedicineService medicineService;

    public MedicationIntakeService(MedicationIntakeRepository medicationIntakeRepository) {
        this.medicationIntakeRepository = medicationIntakeRepository;
    }

    public List<MedicationIntakeDTO> retrieveAllIntakes() {
        return medicationIntakeRepository
                .findAll()
                .stream()
                .map(MedicationIntakeDTO::new)
//                .map(intake -> intake.setMedicineDTOList(medicineService.retrieveAllMedicineByIntakeIds(intake)))
                .collect(Collectors.toList());
    }

    public MedicationIntakeDTO retrieveIntakeById(Long id) {
        MedicationIntake intake = medicationIntakeRepository.findById(id).orElse(null);
        if (intake == null) {
            return null;
        }
        return new MedicationIntakeDTO(intake);
    }

    public MedicationIntakeDTO createAndUpdateIntake(MedicationIntake medicationIntake, Date date) {
        MedicationIntake intake = medicationIntakeRepository.save(medicationIntake);
        return new MedicationIntakeDTO(intake);
    }

    public void eraseIntake(Long id) {
        medicationIntakeRepository.deleteById(id);
    }

}
