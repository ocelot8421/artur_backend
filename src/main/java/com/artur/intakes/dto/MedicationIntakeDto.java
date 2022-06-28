package com.artur.intakes.dto;

import com.artur.intakes.model.MedicationIntake;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationIntakeDto {

    private Long id;
    private String month;
    private String time;
    private String day;
    private String medicine01;
    private double pieces01;
    private double dose01;
    private String medicine02;
    private double dose02;
    private double pieces02;


    public MedicationIntakeDto(MedicationIntake medicationIntake) {
        id = medicationIntake.getId();
        month = medicationIntake.getMonth();
        time = medicationIntake.getTime();
        day = medicationIntake.getDay();
        medicine01 = medicationIntake.getMedicine01();
        pieces01 = medicationIntake.getPieces01();
        dose01 = medicationIntake.getDose01();
        medicine02 = medicationIntake.getMedicine02();
        dose02 = medicationIntake.getDose02();
        pieces02 = medicationIntake.getPieces02();
    }

    @Override
    public String toString() {
        return "MedicationIntakeDto{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", time='" + time + '\'' +
                ", day='" + day + '\'' +
                ", medicine01='" + medicine01 + '\'' +
                ", pieces01=" + pieces01 +
                ", dose01=" + dose01 +
                ", medicine02='" + medicine02 + '\'' +
                ", dose02=" + dose02 +
                ", pieces02=" + pieces02 +
                '}';
    }
}
