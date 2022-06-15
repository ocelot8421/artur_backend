package com.artur.intakes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //>>3.
@Data //>>8.
public class MedicationIntake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String time;
    private String medicine01;
    private double dose01;
    private String medicine02;
    private double dose02;
    private String medicine03;
    private double dose03;

    //>>8. @Data instead of getter-setter and toString method
}
