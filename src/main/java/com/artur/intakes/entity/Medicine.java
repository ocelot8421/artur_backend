package com.artur.intakes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dose")
    private double dose;

    @Column(name = "unit", length = 10)
    private String unit;

    @Column(name = "pieces")
    private double pieces;

    @Column(name = "piecesUnit", length = 25)
    private String piecesUnit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicine")
//    @JsonBackReference
    private Set<MedicationIntake> intakes;
}
