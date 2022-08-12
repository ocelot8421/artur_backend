package com.artur.intakes.dto;

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
    private Long idCheck;
    private Long idTime;
    private String medicineName;
    private double dose;
    private String unit;
    private double pieces;
    private String piecesUnit;

    public MedicineDTO(MedicationIntake intake) {
        Long s = intake.getDayOfWeek().getId() *1000 +
                intake.getTimeOfDay().getId() *100;
        Medicine medicine = intake.getMedicine();
        id = intake.getMedicine().getId();
        idCheck = s + id;
        idTime = s;
        medicineName = medicine.getName();
        dose = medicine.getDose();
        unit = medicine.getUnit();
        pieces = medicine.getPieces();
        piecesUnit = medicine.getPiecesUnit();
    }
}
