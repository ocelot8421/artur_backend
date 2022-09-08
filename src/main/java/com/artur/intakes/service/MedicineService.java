package com.artur.intakes.service;

import com.artur.intakes.dto.*;
import com.artur.intakes.entity.*;
import com.artur.intakes.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private DayOfWeekService dayOfWeekService;

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
            TimeOfDayDTO timeOfDayDTO = new TimeOfDayDTO(intake);
            Long idCheckTimeOfDayDTO = timeOfDayDTO.getIdCheck();
            if (!checkTimeOfDayDTOList.contains(idCheckTimeOfDayDTO)) {
                checkTimeOfDayDTOList.add(idCheckTimeOfDayDTO);
                timeOfDayDTOList.add(timeOfDayDTO);
            }
            MedicineDTO medicineDTO = new MedicineDTO(intake);
            Long idCheckMedicineDTO = medicineDTO.getIdCheck();
            if (!checkMedicineDTOList.contains(idCheckMedicineDTO)) {
                checkMedicineDTOList.add(idCheckMedicineDTO);
                medicineDTOList.add(medicineDTO);
            }
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

    public void eraseIntake(Long checkID) {
        medicationIntakeRepository.deleteById(checkID);
    }

//    public MedicationIntakeDTO createAndUpdateIntake(ConnectionDTO connection) {
    public void createAndUpdateIntake(ConnectionDTO connection) {
        MedicationIntake medicationIntake = new MedicationIntake();
        medicationIntake.setId(connection.getId());
        DayOfWeek dayOfWeek = dayOfWeekService.retrieveDayOfWeek(connection);

        Date date = new Date();
        date.setId(connection.getDate());
        TimeOfDay timeOfDay = new TimeOfDay();
        timeOfDay.setId(connection.getTimeOfDay());
        Medicine medicine = new Medicine();
        medicine.setId(connection.getMedicine());

        System.out.println("connection:"); // put -----------------------------
        System.out.println(connection);
//        System.out.println(dayOfWeekService.retrieveDayOfWeek(connection));

        medicationIntake.setDayOfWeek(dayOfWeek);
        medicationIntake.setDate(date);
        medicationIntake.setTimeOfDay(timeOfDay);
        medicationIntake.setMedicine(medicine);
        System.out.println(medicationIntake);

        MedicationIntake intake = medicationIntakeRepository.save(medicationIntake);
//        return new MedicationIntakeDTO(intake);
    }
}


