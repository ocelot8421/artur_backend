package com.artur.intakes.dto;

import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.TimeOfDay;
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
public class TimeOfDayDTO {

    private Long id;
    private Long idCheck;
    private Long idDay;
    private String timeOfDayHu;
    private String timeOfDayEng;
    private String hour;
    private List<MedicineDTO> medicineDTOs = new ArrayList<>();

    public TimeOfDayDTO(MedicationIntake intake) {
        TimeOfDay timeOfDay = intake.getTimeOfDay();
        id = timeOfDay.getId();
        Long l = intake.getDayOfWeek().getId();
        idCheck = l * 1000 + id * 100;
        idDay = l * 1000;
        timeOfDayHu = timeOfDay.getTimeOfDayHu();
        timeOfDayEng = timeOfDay.getTimeOfDayEng();
        hour = timeOfDay.getHour();
    }

    @Override
    public String toString() {
        return "\n" +
                "    TimeOfDayDTO{" + "\n" +
                "       id=" + id + "\n" +
                "       idCheck=" + idCheck + "\n" +
                "       idDay=" + idDay + "\n" +
                "       timeOfDayHu='" + timeOfDayHu + '\'' + "\n" +
                "       timeOfDayEng='" + timeOfDayEng + '\'' + "\n" +
                "       hour='" + hour + '\'' + "\n" +
                "       medicineDTOs=" + medicineDTOs + '}' + "\n";
    }
}
