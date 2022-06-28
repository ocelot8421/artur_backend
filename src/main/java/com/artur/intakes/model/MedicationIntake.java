package com.artur.intakes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationIntake {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String month;
    private String time;
    private String day;
    private String medicine01;
    private double pieces01;
    private double dose01;
    private String medicine02;
    private double dose02;
    private double pieces02;
    private String medicine03;
    private double dose03;

}
