package com.artur.intakes.dto;

import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Medicine;
import com.artur.intakes.entity.TimeOfMedication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationIntakeDTO {

    private Long id;

    private String year;
    private String month;
    private String dayOfMonth;
    private String dayOfWeek;
    private String timeOfDay;
    private String hour;

    private String medicine01;
    private double pieces01;
    private double dose01;

    private String medicine02;
    private double dose02;
    private double pieces02;

    private Set<Medicine> medicines;

    public MedicationIntakeDTO(MedicationIntake medicationIntake) {
        TimeOfMedication timeOfMedication = medicationIntake.getTimeOfMedication();

        id = medicationIntake.getId();

        year = timeOfMedication.getYear();
        month = timeOfMedication.getMonth();
        dayOfMonth = timeOfMedication.getDayOfMonth();
        dayOfWeek = timeOfMedication.getDayOfWeek();
        timeOfDay = timeOfMedication.getTimeOfDay();
        hour = timeOfMedication.getHour();

        medicine01 = medicationIntake.getMedicine01();
        pieces01 = medicationIntake.getPieces01();
        dose01 = medicationIntake.getDose01();

        medicine02 = medicationIntake.getMedicine02();
        dose02 = medicationIntake.getDose02();
        pieces02 = medicationIntake.getPieces02();

        medicines = medicationIntake.getMedicines();
    }
}
