package com.interview.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name= "country")
//@Check(constraints = "COL_A IS NULL OR (COL_B IS NOT NULL and COL_C IS NOT NULL)")
public class Country {
    @Id
    private char code;

    private String name;

    // ADD CONSTRAINT country_continent_check sprawdza stringi...
    private String continent;

    private String region;

    private Double surfaceArea;

    private short independenceYear;

    private int population;

    private double lifeExpectancy;

    private double gnp;

    private double gnpOld;

    private String localName;

    private String governmentForm;

    private String HeadOfState;

    @Column
    private int capital;

    private char code2;
}
