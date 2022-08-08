package com.artur.intakes.dto;

import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DayOfWeekDTO {

    private Long id;
    private String dayEng;
    private String dayHu;

    public DayOfWeekDTO(MedicationIntake intake) {
        DayOfWeek dayOfWeek = intake.getDayOfWeek();
        id = dayOfWeek.getId();
        dayEng = dayOfWeek.getDayEng();
        dayHu = dayOfWeek.getDayHu();
    }
}
