package com.artur.intakes.service;

import com.artur.intakes.dto.DayOfWeekDTO;
import com.artur.intakes.dto.MedicationIntakeDTO;
import com.artur.intakes.dto.MedicineDTO;
import com.artur.intakes.dto.TimeOfDayDTO;
import com.artur.intakes.entity.MedicationIntake;
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

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public Iterable<DayOfWeekDTO> retrieveGroupedMedicines() {
        List<DayOfWeekDTO> dayOfWeekDTOList = new ArrayList<>();
        List<Long> checkDayOfWeekDTOList = new ArrayList<>();
        List<TimeOfDayDTO> timeOfDayDTOList = new ArrayList<>();
        List<Long> checkTimeOfDayDTOList = new ArrayList<>();
        List<MedicineDTO> medicineDTOList = new ArrayList<>();
        List<Long> checkMedicineDTOList = new ArrayList<>();

        for (MedicationIntake intake : (medicationIntakeRepository.findAll())) {
            DayOfWeekDTO dayOfWeekDTO = new DayOfWeekDTO(intake);
            Long idCheckDayOfWeekDTO = dayOfWeekDTO.getIdCheck();
            if (!checkDayOfWeekDTOList.contains(idCheckDayOfWeekDTO)) {
                checkDayOfWeekDTOList.add(idCheckDayOfWeekDTO);
                dayOfWeekDTOList.add(dayOfWeekDTO);
            }
            System.out.println("-- dayOfWeek:");
            System.out.println(checkDayOfWeekDTOList);
            System.out.println(dayOfWeekDTOList);

            TimeOfDayDTO timeOfDayDTO = new TimeOfDayDTO(intake);
            Long idCheckTimeOfDayDTO = timeOfDayDTO.getIdCheck();
            if (!checkTimeOfDayDTOList.contains(idCheckTimeOfDayDTO)) {
                checkTimeOfDayDTOList.add(idCheckTimeOfDayDTO);
                timeOfDayDTOList.add(timeOfDayDTO);
            }
            System.out.println("-- timeOfDay:");
            System.out.println(checkTimeOfDayDTOList);
            System.out.println(timeOfDayDTOList);

            MedicineDTO medicineDTO = new MedicineDTO(intake);
            Long idCheckMedicineDTO = medicineDTO.getIdCheck();
            if (!checkMedicineDTOList.contains(idCheckMedicineDTO)) {
                checkMedicineDTOList.add(idCheckMedicineDTO);
                medicineDTOList.add(medicineDTO);
            }
            System.out.println("-- medicine:");
            System.out.println(checkMedicineDTOList);
            System.out.println(medicineDTOList);
        }
        for (MedicineDTO medicineDTO : medicineDTOList) {
            for (TimeOfDayDTO timeOfDayDTO : timeOfDayDTOList) {
                if (medicineDTO.getIdTime().longValue() == timeOfDayDTO.getIdCheck().longValue()) {
                    timeOfDayDTO.getMedicineDTOs().add(medicineDTO);
                }
            }
        }
        for (TimeOfDayDTO timeOfDayDTO : timeOfDayDTOList) {
            for (DayOfWeekDTO dayOfWeekDTO : dayOfWeekDTOList) {
                if (timeOfDayDTO.getIdDay().longValue() == dayOfWeekDTO.getIdCheck().longValue()) {
                    dayOfWeekDTO.getTimeOfDayDTOs().add(timeOfDayDTO);
                }
            }
        }
        return dayOfWeekDTOList;
    }
}


