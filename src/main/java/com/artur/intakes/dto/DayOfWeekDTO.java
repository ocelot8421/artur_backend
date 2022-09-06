package com.artur.intakes.dto;

import com.artur.intakes.entity.Date;
import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.entity.MedicationIntake;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayOfWeekDTO {

    private Long id;
    private Long idCheck;
    private String dayEng;
    private String dayHu;
    private String year;
    private String month;
    private String dayOfMonth;
    private List<TimeOfDayDTO> timeOfDayDTOs = new ArrayList<>();

    public DayOfWeekDTO(MedicationIntake intake) {
        DayOfWeek dayOfWeek = intake.getDayOfWeek();
        id = dayOfWeek.getId();
        idCheck = intake.getDayOfWeek().getId() * 1000;
        dayEng = dayOfWeek.getDayEng();
        dayHu = dayOfWeek.getDayHu();

        Date date = intake.getDate();
        year = date.getYear();
        month = date.getMonth();
        dayOfMonth = date.getDayOfMonth();
    }

    @Override
    public String toString() {
        return "DayOfWeekDTO{" + "\n" +
                "id=" + id + "\n" +
                ", idCheck=" + idCheck + "\n" +
                ", dayEng='" + dayEng + '\'' + "\n" +
                ", dayHu='" + dayHu + '\'' + "\n" +
                ", year='" + year + '\'' + "\n" +
                ", month='" + month + '\'' + "\n" +
                ", dayOfMonth='" + dayOfMonth + '\'' + "\n" +
                ", timeOfDayDTOs=" + timeOfDayDTOs + '}';
    }
}
