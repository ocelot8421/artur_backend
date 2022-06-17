package com.artur.intakes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data //>>8.
public class Envelope {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String day;

    //>>8. @Data instead of getter-setter and toString method
}
