package com.artur.intakes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeOfMedication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private MedicationIntake medicationIntake;

    private String year;
    private String month;
    private String dayOfMonth;
    private String dayOfWeek;
    private String timeOfDay;
}
