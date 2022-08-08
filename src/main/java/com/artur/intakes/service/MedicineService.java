package com.artur.intakes.service;

import com.artur.intakes.dto.DayOfWeekDTO;
import com.artur.intakes.dto.MedicationIntakeDTO;
import com.artur.intakes.dto.MedicineDTO;
import com.artur.intakes.entity.*;
import com.artur.intakes.repositories.MedicationIntakeRepository;
import com.artur.intakes.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicationIntakeRepository medicationIntakeRepository;

    public MedicineService(MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }

    //TODO
    public List<MedicineDTO> retrieveAllMedicineByIntakeIds(MedicationIntakeDTO intake){
        return medicationIntakeRepository
                .findAll()
                .stream()
                .filter(c -> c.getDayOfWeek().getId() == intake.getDayOfWeekId()
                && c.getTimeOfDay().getId() == intake.getTimeOfDayId())
                .map(MedicineDTO::new)
                .collect(Collectors.toList());
    }

    public Iterable<DayOfWeekDTO> retrieveGroupedMedicines() {
        List<DayOfWeekDTO> dayOfWeekList = new ArrayList<>();
        List<Object> timeOfDay = new ArrayList<>();
        List<Object> medicines = new ArrayList<>();

        for (MedicationIntake intake : (medicationIntakeRepository.findAll())) {

            DayOfWeekDTO day = new DayOfWeekDTO(intake);
            if(!dayOfWeekList.contains(day))
            dayOfWeekList.add(day);

        }
        return dayOfWeekList;
    }
}
