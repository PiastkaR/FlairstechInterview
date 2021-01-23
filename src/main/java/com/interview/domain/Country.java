package com.interview.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {
    private static final String CONTINENTS_CHECK = "continent = 'Asia'::text OR continent = 'Europe'::text OR" +
            " continent = 'North America'::text OR continent = 'Africa'::text OR continent = 'Oceania'::text OR" +
            " continent = 'Antarctica'::text OR continent = 'South America'::text";

    @Id
    @GeneratedValue
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "continent", nullable = false)
    @Check(constraints = CONTINENTS_CHECK)
    private String continent;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "surface_area", nullable = false)
    private Double surfaceArea;

    @Column(name = "indep_year", nullable = false)
    private short independenceYear;

    @Column(name = "population", nullable = false)
    private int population;

    @Column(name = "life_expectancy", nullable = false)
    private double lifeExpectancy;

    @Column(name = "gnp", nullable = false)
    private double gnp;

    @Column(name = "gnp_old", nullable = false)
    private double gnpOld;

    @Column(name = "local_name", nullable = false)
    private String localName;

    @Column(name = "government_form", nullable = false)
    private String governmentForm;

    @Column(name = "head_of_state", nullable = false)
    private String headOfState;

    @JoinColumn(name = "id")
    @Column(name = "capital", nullable = false)
    private int capital;

    @Column(name = "code2", nullable = false)
    private char code2;
}
