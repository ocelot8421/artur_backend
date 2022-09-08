package com.artur.intakes.dto;

import com.artur.intakes.entity.MedicationIntake;
import com.artur.intakes.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ConnectionDTO {

    private Long id;
    private Long dayOfWeek;
    private Long date;
    private Long medicine;
    private Long timeOfDay;

    public ConnectionDTO(Long id, Long dayOfWeek, Long date, Long medicine, Long timeOfDay) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.date = date;
        this.medicine = medicine;
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "ConnectionDTO{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", date=" + date +
                ", medicine='" + medicine + '\'' +
                ", timeOfDay=" + timeOfDay +
                '}';
    }
}
