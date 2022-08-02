package com.artur.intakes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationIntake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private TimeOfMedication timeOfMedication;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "intake_medicine",
            joinColumns = @JoinColumn(name= "intake_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private Set<Medicine> medicines = new HashSet<>();

    private String time;
    private String day;

    private String medicine01;
    private double pieces01;
    private double dose01;

    private String medicine02;
    private double dose02;
    private double pieces02;

}
