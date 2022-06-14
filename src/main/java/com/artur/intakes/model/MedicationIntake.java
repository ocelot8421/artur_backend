package com.artur.intakes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

//    public MedicationIntake(Long id, String time, String medicine01, double dose01, String medicine02, double dose02, String medicine03, double dose03) {
//        this.id = id;
//        this.time = time;
//        this.medicine01 = medicine01;
//        this.dose01 = dose01;
//        this.medicine02 = medicine02;
//        this.dose02 = dose02;
//        this.medicine03 = medicine03;
//        this.dose03 = dose03;
//    }

    @Override
    public String toString() {
        return "MedicationIntake{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", medicine01='" + medicine01 + '\'' +
                ", dose01=" + dose01 +
                ", medicine02='" + medicine02 + '\'' +
                ", dose02=" + dose02 +
                ", medicine03='" + medicine03 + '\'' +
                ", dose03=" + dose03 +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMedicine01() {
        return medicine01;
    }

    public void setMedicine01(String medicine01) {
        this.medicine01 = medicine01;
    }

    public double getDose01() {
        return dose01;
    }

    public void setDose01(double dose01) {
        this.dose01 = dose01;
    }

    public String getMedicine02() {
        return medicine02;
    }

    public void setMedicine02(String medicine02) {
        this.medicine02 = medicine02;
    }

    public double getDose02() {
        return dose02;
    }

    public void setDose02(double dose02) {
        this.dose02 = dose02;
    }

    public String getMedicine03() {
        return medicine03;
    }

    public void setMedicine03(String medicine03) {
        this.medicine03 = medicine03;
    }

    public double getDose03() {
        return dose03;
    }

    public void setDose03(double dose03) {
        this.dose03 = dose03;
    }
}
