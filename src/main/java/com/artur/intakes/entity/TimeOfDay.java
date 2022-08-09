package com.artur.intakes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "table_time_of_day")
public class TimeOfDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String timeOfDayHu;

    @Column(length = 45)
    private String timeOfDayEng;

    @Column(length = 10)
    private String hour;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "timeOfDay")
    private Set<MedicationIntake> intakes;
}
