package com.artur.intakes.dto;

import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayOfWeekDTO {

    private Long id;
    private Long idCheck;
    private String dayEng;
    private String dayHu;
    private List<TimeOfDayDTO> timeOfDayDTOs = new ArrayList<>();

    public DayOfWeekDTO(MedicationIntake intake) {
        DayOfWeek dayOfWeek = intake.getDayOfWeek();
        id = dayOfWeek.getId();
        idCheck = intake.getDayOfWeek().getId() * 1000;
        dayEng = dayOfWeek.getDayEng();
        dayHu = dayOfWeek.getDayHu();
    }
}
