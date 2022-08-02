package com.artur.intakes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dose", nullable = true)
    private double dose;

    @Column(name = "unit", nullable = true, length = 10)
    private String unit;

    @Column(name = "pieces", nullable = true)
    private double pieces;

    @Column(name = "piecesUnit", nullable = true, length = 25)
    private String piecesUnit;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MedicationIntake> intakes;
}
