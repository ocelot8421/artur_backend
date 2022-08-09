package com.artur.intakes.dto;

import com.artur.intakes.entity.TimeOfDay;
import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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
    private Set<MedicineDTO> medicineDTOs = new HashSet<>();

    public MedicationIntakeDTO(MedicationIntake medicationIntake) {

        Date date = medicationIntake.getDate();

        id = medicationIntake.getId();

        year = date.getYear();
        month = date.getMonth();
        dayOfMonth = date.getDayOfMonth();

        DayOfWeek dayOfWeek = medicationIntake.getDayOfWeek();
        dayOfWeekId = dayOfWeek.getId();
        dayOfWeekHu = dayOfWeek.getDayHu();
//        dayOfWeekEng = dayOfWeek.getDayEng();

        TimeOfDay timeOfDay = medicationIntake.getTimeOfDay();
        timeOfDayId = timeOfDay.getId();
        timeOfDayHu = timeOfDay.getTimeOfDayHu();
//        timeOfDayEng = timeOfDay.getTimeOfDayEng();

        medicineDTO = new MedicineDTO(medicationIntake);
    }
}
