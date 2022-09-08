package com.artur.intakes.service;

import com.artur.intakes.dto.*;
import com.artur.intakes.entity.*;
import com.artur.intakes.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MedicineService {
    private static final Long NEW_MED_MARKER_ID = 99L;

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
        DayOfWeek dayOfWeek = dayOfWeekService.retrieveDayOfWeek(connection);
        Date date = new Date();
        date.setId(connection.getDate());
        TimeOfDay timeOfDay = new TimeOfDay();
        timeOfDay.setId(connection.getTimeOfDay());

        Long medicineID = retrieveMedicineID(connection.getMedicine());
        Medicine medicine = new Medicine();
        medicine.setId(medicineID);

        System.out.println("connection:"); // put -----------------------------
        System.out.println(connection);
//        System.out.println(dayOfWeekService.retrieveDayOfWeek(connection));

        medicationIntake.setDayOfWeek(dayOfWeek);
        medicationIntake.setDate(date);
        medicationIntake.setTimeOfDay(timeOfDay);
        medicationIntake.setMedicine(medicine);
        medicationIntake.setId(connection.getId() - NEW_MED_MARKER_ID + medicineID);

        System.out.println(medicationIntake);

        MedicationIntake intake = medicationIntakeRepository.save(medicationIntake);
//        return new MedicationIntakeDTO(intake);
    }

    private Long retrieveMedicineID(Medicine medicine) {
        Long medID = 99L;
        String medName = medicine.getName();
        System.out.println("got medicine:");
        System.out.println(medicine);
        for (Medicine aMedicine : medicineRepository.findAll()) {
            //TODO ugly this so many if-branch
            if (Objects.equals(aMedicine.getName(), medName)
                    && aMedicine.getDose() == medicine.getDose()
                    && aMedicine.getPieces() == medicine.getPieces()
            ) {
                System.out.println(aMedicine.getId());
                System.out.println(aMedicine.getName());
                medID = aMedicine.getId();
            }
        }
        return medID;
    }


}


