package com.artur.intakes.dto;

import com.artur.intakes.entity.DailyCycle;
import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.TimeOfMedication;
import com.artur.intakes.service.MedicineService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationIntakeDTO {

    private Long id;

    private Long dayOfWeekId;
    private String dayOfWeekHu;
//    private String dayOfWeekEng;

    private Long timeOfDayId;
    private String timeOfDayHu;
//    private String timeOfDayEng;

    private String year;
    private String month;
    private String dayOfMonth;

    private MedicineDTO medicineDTO;
    private List<MedicineDTO> medicineDTOList = new ArrayList<>();

    public MedicationIntakeDTO(MedicationIntake medicationIntake) {

        TimeOfMedication timeOfMedication = medicationIntake.getDate();

        id = medicationIntake.getId();

        year = timeOfMedication.getYear();
        month = timeOfMedication.getMonth();
        dayOfMonth = timeOfMedication.getDayOfMonth();

        DayOfWeek dayOfWeek = medicationIntake.getDayOfWeek();
        dayOfWeekId = dayOfWeek.getId();
        dayOfWeekHu = dayOfWeek.getDayHu();
//        dayOfWeekEng = dayOfWeek.getDayEng();

        DailyCycle timeOfDay = medicationIntake.getTimeOfDay();
        timeOfDayId = timeOfDay.getId();
        timeOfDayHu = timeOfDay.getTimeOfDayHu();
//        timeOfDayEng = timeOfDay.getTimeOfDayEng();

        medicineDTO = new MedicineDTO(medicationIntake);
    }
}
