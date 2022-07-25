package com.artur.intakes.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;
    private String month;
    private String time;
    private String day;
    private String timeOfDay01;

    private String medicine01;
    private double pieces01;
    private double dose01;

    private String medicine02;
    private double dose02;
    private double pieces02;

    private String medicine03;
    private double dose03;


    //    @Override
//    public String toString() {
//        return "MedicationIntake{" +
//                "id=" + id +
//                ", month='" + month + '\'' +
//                ", time='" + time + '\'' +
//                ", day='" + day + '\'' +
//                ", medicine01='" + medicine01 + '\'' +
//                ", pieces01=" + pieces01 +
//                ", dose01=" + dose01 +
//                ", medicine02='" + medicine02 + '\'' +
//                ", dose02=" + dose02 +
//                ", pieces02=" + pieces02 +
//                ", medicine03='" + medicine03 + '\'' +
//                ", dose03=" + dose03 +
//                '}';
//    }
}
