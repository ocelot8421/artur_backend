package com.artur.intakes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "medicineSet")
    private Set<MedicationIntake> medicationIntakeSet;

    private String name;
    private double dose;
    private String unit;

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicine='" + name + '\'' +
                ", dose=" + dose +
                ", unit='" + unit + '\'' +
                '}';
    }
}
