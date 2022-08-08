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
public class DayOfWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String dayEng;

    @Column(length = 45)
    private String dayHu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dayOfWeek")
    private Set<MedicationIntake> intakes;
}
