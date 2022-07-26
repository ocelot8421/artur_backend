package com.artur.intakes.dto;

import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationIntakeDto {

    private Long id;

    private String year;
    private String month;
    private String dayOfMonth;
    private String dayOfWeek;
    private String timeOfDay;

//    @NotNull
//    private Medicine medicine;

//    private String time;
//    private String day;
//    private String timeOfDay01;

    private String medicine01;
    private double pieces01;
    private double dose01;

    private String medicine02;
    private double dose02;
    private double pieces02;

    public MedicationIntakeDto(MedicationIntake medicationIntake) {
        id = medicationIntake.getId();

        year = medicationIntake.getTimeOfMedication().getYear();
        month = medicationIntake.getTimeOfMedication().getMonth();
        dayOfMonth = medicationIntake.getTimeOfMedication().getDayOfMonth();
        dayOfWeek = medicationIntake.getTimeOfMedication().getDayOfWeek();
        timeOfDay = medicationIntake.getTimeOfMedication().getTimeOfDay();

//        medicines = medicationIntake.getMedicineSet();
//        System.out.println("gyógyszerek: ");
//        medicines.forEach(System. out::println);

//        medicine01 = medicationIntake.getMedicineList();
        pieces01 = medicationIntake.getPieces01();
        dose01 = medicationIntake.getDose01();

        medicine02 = medicationIntake.getMedicine02();
        dose02 = medicationIntake.getDose02();
        pieces02 = medicationIntake.getPieces02();
    }
}
