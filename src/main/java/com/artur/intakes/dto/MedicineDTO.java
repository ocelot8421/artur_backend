package com.artur.intakes.dto;

import com.artur.intakes.entity.DailyCycle;
import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {

    private Long id;

    private Long dayOfWeekId;
    private String dayOfWeekHu;
    private String dayOfWeekEng;

    private Long timeOfDayId;
    private String timeOfDayHu;
    private String timeOfDayEng;

    private String medicineName;
    private double dose;
    private String unit;
    private double pieces;
    private String piecesUnit;

    public MedicineDTO(MedicationIntake medicationIntake){
        id = medicationIntake.getMedicine().getId();

        DayOfWeek dayOfWeek = medicationIntake.getDayOfWeek();
        dayOfWeekId = dayOfWeek.getId();
        dayOfWeekHu = dayOfWeek.getDayHu();
        dayOfWeekEng = dayOfWeek.getDayEng();

        DailyCycle timeOfDay = medicationIntake.getTimeOfDay();
        timeOfDayId = timeOfDay.getId();
        timeOfDayHu = timeOfDay.getTimeOfDayHu();
        timeOfDayEng = timeOfDay.getTimeOfDayEng();

        Medicine medicine = medicationIntake.getMedicine();
        medicineName = medicine.getName();
        dose = medicine.getDose();
        unit = medicine.getUnit();
        pieces = medicine.getPieces();
        piecesUnit = medicine.getPiecesUnit();
    }
}
